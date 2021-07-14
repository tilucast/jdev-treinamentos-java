package Threads;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Thread newthread = new Thread(somethread);
//        newthread.start();
//        Thread newthread2 = someotherthread;
//        newthread2.start();
//
//        System.out.println("I dont need to wait to be executed.");

        SwingThreadExample somescreen = new SwingThreadExample();
    }

    static Runnable somethread = () -> {
        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("Im being printed every 1000 milliseconds");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    static Thread someotherthread = new Thread(() -> {
        String[] x = new String[4];
        Arrays.fill(x, "some string");
        try {

            for (String s : x) {
                System.out.println(s);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
}