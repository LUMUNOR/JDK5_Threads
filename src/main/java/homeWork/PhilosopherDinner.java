package homeWork;

import java.util.ArrayList;

public class PhilosopherDinner {

    public static void main(String[] args) throws InterruptedException {
        final int COUNT_PERSON = 5;
        ArrayList<Fork> forks = new ArrayList<>();
        ArrayList<Philosopher> philosophers = new ArrayList<>();

        for (int i = 0; i < COUNT_PERSON; i++){
            forks.add(new Fork(i));
        }

        for (int i = 0; i < COUNT_PERSON; i++){
            String name = "Филосов " + String.valueOf(i+1);
            Fork rightFork = null;
            if (i==0) rightFork = forks.get(COUNT_PERSON-1);
            else rightFork = forks.get(i-1);
            Fork leftFork = forks.get(i);
            philosophers.add(new Philosopher(name,leftFork,rightFork));
        }

        for(Philosopher philosopher: philosophers){
            philosopher.start();
        }
    }
}
