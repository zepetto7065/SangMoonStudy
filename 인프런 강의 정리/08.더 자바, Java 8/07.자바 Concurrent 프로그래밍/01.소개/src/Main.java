public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true){
                System.out.println("Thread : "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    System.out.println("exit!");
                    return;
                }

            }
        });

        thread.start();

        System.out.println("Hello : " + Thread.currentThread().getName());

//        Thread.sleep(3000L);
//        thread.interrupt(); //InterruptedException 발생
        thread.join(); //다른 스레드가 기다릴 때까지 대기
        System.out.println(thread + " is finished");
    }
}
