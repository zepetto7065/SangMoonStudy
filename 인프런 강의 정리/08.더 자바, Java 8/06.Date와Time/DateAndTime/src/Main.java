import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        //기존 Date
        //불편함.
        Date date = new Date();
        //date에서 time을 가져온다고? 불명확
        long time = date.getTime();
        System.out.println(time);
        System.out.println(date);

        Thread.sleep(1000 * 3);
        Date after3Second = new Date();
        System.out.println(after3Second);
        after3Second.setTime(time);//시간 변경 가능
        System.out.println(after3Second); //3초 전으로 변경됨. mutable. thread safe 하지 않음.

        //bug가 발생가능. 아무 값이나 들어올수 있음. -100같은.. Type safe하지 않음.
        Calendar sangmoonBirthDay = new GregorianCalendar(1992, Calendar.APRIL, 17);
        Calendar sangmoonBirthDay2 = new GregorianCalendar(1992, -100, 17);

        //조금더 명확한 API가 필요하다..
        System.out.println(sangmoonBirthDay.getTime());
        sangmoonBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(sangmoonBirthDay.getTime());


        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //java8 DateTime API
        //1. 기계적 시간을 사용하는 방법. Instant
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC or GMT , 영국 그리니츠가 23시다
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        //2. 인간용 시간을 사용하는 방법. LocalDateTime
        LocalDateTime now = LocalDateTime.now(); //코드가 동작하고 있는 zone에 해당.
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(1992, Month.APRIL, 17, 12, 0, 0);
        System.out.println(birthDay);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));//특정 zone의 현재 시
        System.out.println(nowInKorea);

        //3. 기간을 표현하는 방법. Period
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthDay = LocalDate.of(2022, Month.APRIL, 17);
        //날짜로 표현 - 휴먼
        Period period = Period.between(today, nextYearBirthDay);
        System.out.println(period.getDays());

        Period until = today.until(nextYearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS));
        //머신용Time
        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds());

        //4. 포맷팅
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime plus1 = now1.plus(10, ChronoUnit.DAYS);//ChronoUnit은 외워두자.

        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        //5. 파싱
        LocalDate parse = LocalDate.parse("04/17/1992", MMddyyyy);
        System.out.println(parse);

        //6. 레거시 API 지원
        Date date2 = new Date();
        Instant instant1 = date2.toInstant();
        Date newDate = date2.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(dateTime);

        //왔다갔다 가능
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

    }
}
