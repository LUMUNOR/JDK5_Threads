package homeWork;

public class Philosopher extends Thread {
    private static final int MAX_SATIETY = 3;
    private static final int TIME_THOUGHT = 10000;
    private static final int TIME_EAT = 1000;
    private String name;
    private int satiety;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name,Fork leftFork, Fork rightFork){
        this.name = name;
        this.satiety = 0;
    }

    public void eat () throws InterruptedException {
        System.out.println(this.name + " взял вилки, начал есть.");
        Thread.sleep(TIME_EAT);
        this.satiety++;
        System.out.println(this.name + " покушал и думает...");
        Thread.sleep(TIME_THOUGHT);
    }

    @Override
    public void run() {
        try {
            while (satiety < MAX_SATIETY){
                eat();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " завершил приём пищи");
    }
}
