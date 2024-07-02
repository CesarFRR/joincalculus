package com.unal.AST;
import java.util.HashMap;
import java.util.Map;

public class TableAST {
    private static Map<String, Map<String, Object>> idTable = new HashMap<>();
    private static Map<String, Thread> threadTable = new HashMap<>();
    private static Map<String, NodeChannel> channelTable = new HashMap<>();
    private static Map<String, NodeProcess> processTable = new HashMap<>();
    static {
        idTable.put("main", new HashMap<String, Object>());
    }

    public TableAST() {}

    public Object getId(String threadName, String varName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        Map<String, Object> threadMap = idTable.get(threadName);
        if (threadMap == null) {
            return null;
        }
        return threadMap.get(varName);
    }
    public void deleteTableId(String threadName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        idTable.remove(threadName);
    }

    public Thread getThread(String threadName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        return threadTable.get(threadName);
    }
    public NodeChannel getChannel(String channelName) {
        if (channelName == null ) {
            channelName = Thread.currentThread().getName();
        }
        return channelTable.get(channelName);
    }

    public NodeProcess getProcess(String processName) {
        if (processName == null || processName.equals("main")) {
            processName = Thread.currentThread().getName();
        }
        return processTable.get(processName);
    }

    public void setId(String threadName, String varName, Object value) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
//        System.out.println("insertando variable: " + varName + " en el hilo: " + threadName + " con valor: " + value);


//        System.out.println("\n\n Se va a insertar en la tabla de simbolos: " + varName + " = " + value + " en el hilo: " + threadName + "\n\n");
        Map<String, Object> threadMap = idTable.get(threadName);
        threadMap.put(varName, value);
//        printAllMaps();
    }

    public void setThread(String threadName, Thread thread) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        threadTable.put(threadName, thread);
    }

    public void setChannel(String channelName, NodeChannel channel) {
        if (channelName == null ) {
            channelName = Thread.currentThread().getName();
        }
        channelTable.put(channelName, channel);
    }
    public void setProcess(String processName, NodeProcess process) {
        if (processName == null || processName.equals("main")) {
            processName = Thread.currentThread().getName();
        }
        idTable.put(processName, new HashMap<>());
        processTable.put(processName, process);
    }

    public void printChannels() {
        for (Map.Entry<String, NodeChannel> entry : channelTable.entrySet()) {
            System.out.println("Channels MAP: " + entry.getKey());
        }
    }
    public void printThreads() {
        for (Map.Entry<String, Thread> entry : threadTable.entrySet()) {
            System.out.println("Threads MAP: " + entry.getKey());
        }
    }
    public void printProcesses() {
        for (Map.Entry<String, NodeProcess> entry : processTable.entrySet()) {
            System.out.println("Process MAP: " + entry.getKey());
        }
    }

    public boolean existsId(String threadName, String varName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        Map<String, Object> threadMap = idTable.get(threadName);
        if (threadMap == null) {
            return false;
        }

        return threadMap.containsKey(varName) ;
    }

    public void deleteId(String threadName, String varName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        Map<String, Object> threadMap = idTable.get(threadName);
        if (threadMap != null) {
            threadMap.remove(varName);
        }
    }
    public void deleteThread(String threadName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        threadTable.remove(threadName);
    }
    public void deleteChannel(String channelName) {
        if (channelName == null ) {
            channelName = Thread.currentThread().getName();
        }
        channelTable.remove(channelName);
    }
    public void deleteProcess(String processName) {
        if (processName == null || processName.equals("main")) {
            processName = Thread.currentThread().getName();
            if (processName.equals("main")) return;
        }
        idTable.remove(processName);
        processTable.remove(processName);
    }

    public void printMap(String threadName) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        Map<String, Object> threadMap = idTable.get(threadName);
        if (threadMap != null) {
            for (Map.Entry<String, Object> entry : threadMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public void printAllMaps() {
        System.out.println("Printing all maps:");
        for (Map.Entry<String, Map<String, Object>> entry : idTable.entrySet()) {
            System.out.println("Thread: " + entry.getKey());
            this.printMap(entry.getKey());
            System.out.println();
        }
    }

    public void updateId(String threadName, String nameid, Object execute) {
        if (threadName == null ) {
            threadName = Thread.currentThread().getName();
        }
        Map<String, Object> threadMap = idTable.get(threadName);
        if (threadMap != null) {
            threadMap.put(nameid, execute);
        }

    }
}
