public class Node {

    private int id;
    private  String val;
    private Node next;

    public void Node (String valP, Node nextP, int idP) {
        val = valP;
        next = nextP;
        id = idP;
    };

    public void setLetra(String valP){
        this.val = valP;
    }

    public void setNext(Node nextP){
        this.next = nextP;
    }

    public void setId(int idP){
        this.id = idP;
    }

    public String getLetra(){
        return val;
    }

    public Node getNext(){
        return next;
    }

    public int getId(){
        return id;
    }
}
