package ua.edu.ucu.collections.immutable;

/**
 * Created by Olia on 03.11.2016.
 */
public class Node {

    public final Object data;
    public Node nextNode;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Node nextNode, Object data) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Object getData() {
        return this.data;
    }


    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String toString() {
        return this.getData().toString();
    }

    public Node clone() {
        return new Node(data);
    }
}
