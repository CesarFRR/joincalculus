package com.unal.tests;

public class Process extends Thread {
    private Channel inputChannel;
    private Channel outputChannel;
    private ConsoleWriter consoleWriter;

    public Process(Channel inputChannel, Channel outputChannel) {
        this.inputChannel = inputChannel;
        this.outputChannel = outputChannel;
        this.consoleWriter = new ConsoleWriter();
    }

    public Process() {

    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
//        System.out.println("Running in thread: " + threadName);
        try {
            while (!Thread.currentThread().isInterrupted()) {

                Long random;
                int a = 500;
                int b = 2000;
                consoleWriter.writeMessage("Waiting for a message...");
                random = (long) (a + (Math.random() * (b - a)));
                Thread.sleep(random); // Pause before receiving a message
                Object message = inputChannel.receive();
                consoleWriter.writeMessage("\nMessage received: " + message);

                consoleWriter.writeMessage("Making message...");
                random = (long) (a + (Math.random() * (b - a)));
                Thread.sleep(random); // Pause while "making" a message
                // Aquí puedes definir la lógica de tu proceso
                // Por ejemplo, podrías modificar el mensaje de alguna manera
                String newMessage = "Processed: " + message;

                consoleWriter.writeMessage("Sending message: " + newMessage);
                random = (long) (a + (Math.random() * (b - a)));
                Thread.sleep(random); // Pause before sending a message
                outputChannel.send(newMessage);
                consoleWriter.writeMessage("\nMessage sent: " + newMessage);
                random = (long) (a + (Math.random() * (b - a)));
                Thread.sleep(random); // Pause after sending a message
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stopProcess() {
        this.interrupt();
    }


}