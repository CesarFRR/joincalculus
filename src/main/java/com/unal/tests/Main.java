package com.unal.tests;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Channel channel1 = new Channel();
        Channel channel2 = new Channel();

        Process process1 = new Process(channel1, channel2);
        Process process2 = new Process(channel2, channel1);

        process1.start();
        process2.start();

        channel1.send("Hello, world!");
    }
}