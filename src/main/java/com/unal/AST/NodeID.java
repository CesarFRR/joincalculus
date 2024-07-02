package com.unal.AST;

public class NodeID extends NodeLeaf{

    private static TableAST table;

    static {
        table = new TableAST();
    }

    public NodeID(Object identifier) {
        super(identifier);
    }
    public String getId(){
        return (String) value;
    }

    @Override
    public String toString() {
        return (String) value;
    }

    @Override
    public Object execute() {
        Object v = this.value;
        String id = "";
        String threadName = Thread.currentThread().getName();
//        table.printProcesses();
//        System.out.println("Running in thread: " + threadName);
        if (v instanceof String) {
            id = (String) v;

        } else if (v instanceof Node n) {
            id = (String) n.execute();
        }

        v = table.getId(threadName, id);
        v = v== null? table.getId("main", id): v;
        if (v instanceof NodeVar nv) {
            v = nv.getValue();
        }

//        System.out.println("returning: id: "+ id +" value: " + v);
        return v;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public void clean() {
    super.clean();
    }
}
