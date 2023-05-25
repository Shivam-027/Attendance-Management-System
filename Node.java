import java.util.*;

class Node{
    String RollNo;
    String Name;
    String CN;
    String DECA;
    String DS;
    Node next;
    Node prev;
    Node(){
        RollNo = "";
        Name = "";
        CN = "";
        DECA = "";
        DS = "";
        next = null;
        prev = null;
    }
    Node(String RollNo, String Name, String CN, String DECA, String DS){
        this.RollNo = RollNo;
        this.Name = Name;
        this.CN = CN;
        this.DECA = DECA;
        this.DS = DS;
        next = null;
        prev = null;
    }
}

