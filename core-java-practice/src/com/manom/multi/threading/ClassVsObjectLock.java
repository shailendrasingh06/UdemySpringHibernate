package com.manom.multi.threading;

import java.util.concurrent.*;

public class ClassVsObjectLock implements Runnable{
    // it has only object level lock so both the threads will execute it parallel
    // make below method static to implement class level lock

    public synchronized void sleep() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " : sleeping for 10 secs");
        Thread.sleep(10000);
        System.out.println("Done.");
    }

    @Override
    public void run(){
        try {
            sleep();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        ExecutorService executorService = new ScheduledThreadPoolExecutor(1);

        ClassVsObjectLock o1 = new ClassVsObjectLock();
        ClassVsObjectLock o2 = new ClassVsObjectLock();
        ClassVsObjectLock o3 = new ClassVsObjectLock();


            Runnable r1 = () -> {
                System.out.println(Thread.currentThread().getName() + " : sleeping for 10 secs");
                try {

                    Thread.sleep(10000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Done.");
            };


        executorService.submit(o1);
        executorService.submit(o2);
        executorService.submit(r1);

        executorService.shutdown();
    }
}
