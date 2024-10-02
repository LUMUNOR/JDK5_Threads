package homeWork;

public class Philosopher extends Thread {
    private static final int MAX_SATIETY = 3;
    private static final int TIME_THOUGHT = 10000;
    private static final int TIME_EAT = 100;
    private String name;
    private int satiety;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name,Fork leftFork, Fork rightFork){
        this.name = name;
        this.satiety = 0;
        this.rightFork = rightFork;
        this.leftFork = leftFork;
    }

    public void eat () throws InterruptedException {
        synchronized (leftFork) {
            synchronized (rightFork) {
                Thread.sleep(TIME_EAT);// Задержка для последовательного вывода в консоль
                System.out.println(this.name + " взял вилки "+leftFork+","+rightFork+" и начал есть.");
                Thread.sleep(TIME_EAT);
                this.satiety++;
            }
        }
        if (this.satiety == MAX_SATIETY) System.out.println(this.name + " наелся и исключительно думает.");
        else System.out.println(this.name + " покушал и думает...");
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
    }
}
