import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        //기존 Date
        //불편함.
        Date date = new Date();
        //date에서 time을 가져온다고? 불명확
        long time = date.getTime();
        System.out.println(time);
        System.out.println(date);

        Thread.sleep(1000*3);
        Date after3Second = new Date();
        System.out.println(after3Second);
        after3Second.setTime(time);//시간 변경 가능
        System.out.println(after3Second); //3초 전으로 변경됨. mutable. thread safe 하지 않음.

        //bug가 발생가능. 아무 값이나 들어올수 있음. -100같은.. Type safe하지 않음.
        Calendar sangmoonBirthDay = new GregorianCalendar(1992,Calendar.APRIL,17);
        Calendar sangmoonBirthDay2 = new GregorianCalendar(1992, -100,17);

        //조금더 명확한 API가 필요하다..
        System.out.println(sangmoonBirthDay.getTime());
        sangmoonBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(sangmoonBirthDay.getTime());


        SimpleDateFormat dateFormat = new SimpleDateFormat();

    }
}
