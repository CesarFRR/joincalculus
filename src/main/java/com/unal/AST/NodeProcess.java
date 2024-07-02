package com.unal.AST;

import com.unal.model.Process;

import java.util.List;

public class NodeProcess extends Node2 implements InterfaceStruct{

    private Process p;
    private boolean stopIntruction = false;
    public NodeProcess(Node processName, Node sentlist) {
        super(processName, sentlist);
        if(processName == null)
            p = new Process(Thread.currentThread().getName());
        else
            p = new Process((String) processName.execute());
    }

    @Override
    public String toString() {
        int size = getInstructionNodes((NodeTree) this.child2).size();
        return "Process: " + this.child1 + " with " + size + " instructions";
    }

    @Override
    public Object execute() {
        Node ch1 = this.child1;
        Node ch2 =  this.child2;
        String currentProcess = Thread.currentThread().getName();
        String name = ch1 ==null? currentProcess: (String) ch1.execute();
        if (this.stopIntruction) {
            this.stopIntruction = false;
            Process p1= table.getProcess(name).getProcess();
//           System.out.println("stoping process: " + name + " cuando el current process es: " + Thread.currentThread().getName());
//           table.printAllMaps();
            //table.deleteProcess(name);
            p1.stopProcess();

            return null;
        }


        List<Node> sentList = this.getInstructionNodes((NodeTree) ch2);
//        System.out.println("Executing process: " + ch1 + " with " + sentList.size() + " instructions");

        // TODO: AQUI SE USA LA CLASE PROCESS QUE HEREDA DE THREAD
        p.setSentlist(sentList);
        table.setProcess(name, this);
        p.start();
        return null;
    }

    public void stopInstruccion() {
        this.stopIntruction = true;
    }
    public Process getProcess() {
        return p;
    }

    @Override
    public Object clone() {
        Node name = (Node) this.child1.clone();
        Node sentlist = this.child2;
        return new NodeProcess(name, sentlist);
    }

    @Override
    public void clean() {

    }

    public void setName(String s) {
        this.child1 = new NodeLeaf(s);
    }

    public String getName() {
        return (String) this.child1.execute();
    }
}
