package com.practice.timer;
//https://www.geeksforgeeks.org/java-util-timer-class-java/

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer time = new Timer();
        TimerTask task = new Helper();
        System.out.println(new Date()+" Program Started");
        time.schedule(task, 2000, 5000);
    }
}

class Helper extends TimerTask {

    private int i = 0;
    @Override
    public void run() {
        System.out.println(new Date() +" Timer ran " + ++i);
    }
}
