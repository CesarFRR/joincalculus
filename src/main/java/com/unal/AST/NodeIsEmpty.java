package com.unal.AST;

public class NodeIsEmpty extends NodeLeaf{
    private  static TableAST table;

    static {
        table = new TableAST();
    }


    public NodeIsEmpty(Object value) {
        super(value);
    }

    @Override
    public String toString() {
        return "isEmpty( + " + value + ")";
    }

    @Override
    public Object execute() {
        Object value = this.value;

        if (value instanceof Node n){
            value =  n.execute();
            if (value != null){
                return new NodeLeaf(((String)value).isEmpty());
            }
        }
        String channelName = (String) value;

        if (channelName == null) {
//            System.out.println("porque es null ? + " + this.value + " " + this.value.getClass());
            if (this.value instanceof NodeID n){
                String id = n.getId();
                Object v = n.execute();
                if (v==null) {
                    v = table.getChannel(id);
                    return new NodeLeaf(((NodeChannel)v).receive()==null);
                }else{
                    System.out.println("es variable " + id + " " + v);
                }
            }

        }
        System.out.println("channelName: " + channelName );
        if (channelName.isEmpty()) return new NodeLeaf(true);
        NodeChannel ch = (NodeChannel) table.getChannel( channelName);
        boolean isEmpty = ch.receive()==null;
        return new NodeLeaf(isEmpty);
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public void clean() {

    }
}
