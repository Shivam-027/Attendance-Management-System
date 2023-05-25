import java.util.*;
import java.io.*;
import java.lang.*;

class AttendanceList {
    int size;
    Node head;
    Node tail;

    AttendanceList() {
        size = 0;
        head = null;
        tail = null;
    }

    void viewAttendance() {
        Node t;
        int count = 1;
        if (head == null) {
            System.out.println("Database is empty");
        } else {
            System.out.println("\nAttendance: ");
            System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s","S.No.","Roll Number","Name","CN","DECA","DS");
            System.out.println();
            t = head;
            while (t != null) {
                System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s",count,t.RollNo,t.Name,t.CN,t.DECA,t.DS);
                System.out.println();
                count++;
                t = t.next;
            }
        }
    }

    void view() {
        try {
            File fi = new File("all.txt");
            Scanner content = new Scanner(fi);
            int flag = 0;
            while (content.hasNextLine()) {
                if(content.hasNextLine() == true){
                    flag = flag + 1;
                }
                if(flag == 1){
                    System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s","S.No.","Roll Number","Name","Subject","Date","Attendance");
                    System.out.println();
                }
                String data = content.nextLine();
                String[] parts = data.split(" ");
                System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s",flag,parts[0],parts[1],parts[2],parts[3],parts[4]);
                System.out.println();
            }
            if(flag == 0){
                System.out.println("Database is empty");
            }
            content.close();
        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    void insert(String RollNo, String Name, String CN, String DECA, String DS) {
        Node t;
        t = head;
        int count = 1;
        if (head == null) {
            insertAtPos(RollNo, Name, CN, DECA, DS, count);
        } else {
            while (t != null) {
                int a = Integer.parseInt(t.RollNo);
                int b = Integer.parseInt(RollNo);

                if (a > b) {
                    insertAtPos(RollNo, Name, CN, DECA, DS, count);
                    return;
                } else if (a < b) {
                    count++;
                    t = t.next;
                }
                else{
                    System.out.println("Roll Number already exists");
                    return;
                }
            }
            insertAtPos(RollNo, Name, CN, DECA, DS, size + 1);
        }
    }

    void insertAtPos(String RollNo, String Name, String CN, String DECA, String DS, int pos) {
        Node n = new Node(RollNo, Name, CN, DECA, DS);
        Node t;
        Node temp;
        t = head;
        if (pos == 1) {
            if (head == null) {
                tail = n;
                head = n;
            } else {
                t.prev = n;
            }
            n.next = t;
            head = n;
            size++;
        } else if (pos == size + 1) {
            if (head == null) {
                head = n;
            } else {
                tail.next = n;
            }
            n.prev = tail;
            tail = n;
            size++;
        } else {
            for (int i = 1; i < pos - 1; i++) {
                t = t.next;
            }
            temp = t.next;
            n.next = t.next;
            t.next = n;
            n.prev = t;
            temp.prev = n;
            size++;
        }
    }

    void delete(String RollNo) {
        Node t;
        t = head;
        int count = 1;
        if (head == null) {
            System.out.println("Database is empty");
        } else {
            while (t != null) {
                String ch = t.RollNo;

                if (RollNo.equals(ch)) {
                    deleteAtPos(count);
                    return;
                } else {
                    count++;
                    t = t.next;
                }
            }
            System.out.println("Student does not exist in the Book");
        }
    }

    void update() {
        Node t;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the number of class: ");
        int days = obj.nextInt();
        while(days != 0){
            t = head;
            System.out.println("\nEnter the Date (dd/mm/yyyy): ");
            String date = obj.next();
            String sub = "";
            String sub1 = "";
            String ch = "";
            String up = "";
            System.out.println("Enter the Subject (CN / DECA / DS): ");
            sub = obj.next();
            while (t != null) {
                int i0 = 0;
                int i1 = 0;
                if (sub.equals("CN")) {
                    String data = t.CN;
                    String[] parts = data.split("/");
                    System.out.println(t.RollNo + " " + t.Name + " was (A for absent and P for present): ");
                    ch = obj.next();
                    if (ch.equals("A")) {
                        i0 = Integer.parseInt(parts[0]);
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else if (ch.equals("P")) {
                        i0 = Integer.parseInt(parts[0]) + 1;
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else {
                        System.out.println("Invalid Input");
                        return;
                    }
                    up = i0 + "/" + i1;
                    t.CN = up;
                    sub1 = "Computer_Networks";
                    enter(t.RollNo, t.Name, sub1, date, ch);
                } else if (sub.equals("DECA")) {
                    String data = t.DECA;
                    String[] parts = data.split("/");
                    System.out.println(t.RollNo + " " + t.Name + " was (A for absent and P for present): ");
                    ch = obj.next();
                    if (ch.equals("A")) {
                        i0 = Integer.parseInt(parts[0]);
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else if (ch.equals("P")) {
                        i0 = Integer.parseInt(parts[0]) + 1;
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else {
                        System.out.println("Invalid Input");
                        return;
                    }
                    up = i0 + "/" + i1;
                    t.DECA = up;
                    sub1 = "DECA";
                    enter(t.RollNo, t.Name, sub1, date, ch);
                } else if (sub.equals("DS")) {
                    String data = t.DS;
                    String[] parts = data.split("/");
                    System.out.println(t.RollNo + " " + t.Name + " was (A for absent and P for present): ");
                    ch = obj.next();
                    if (ch.equals("A")) {
                        i0 = Integer.parseInt(parts[0]);
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else if (ch.equals("P")) {
                        i0 = Integer.parseInt(parts[0]) + 1;
                        i1 = Integer.parseInt(parts[1]) + 1;
                    } else {
                        System.out.println("Invalid Input");
                        return;
                    }
                    up = i0 + "/" + i1;
                    t.DS = up;
                    sub1 = "Data_Structures";
                    enter(t.RollNo, t.Name, sub1, date, ch);
                } else {
                    System.out.println("Invalid Input");
                    return;
                }
                t = t.next;
            } 
            days--;
        }
        exit();
    }

    void enter(String RollNo, String Name, String sub1, String date, String ch){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("all.txt",true));
                String merge = RollNo + " " + Name + " " + sub1 + " " + date + " " + ch;
                out.write(merge + "\n");
                out.close();
            } catch (IOException e) {
                System.out.println("exception occoured" + e);
            }
    }

    void deleteAtPos(int pos) {
        if (head == null)
            System.out.println("list is empty");
        else if (pos < 1 || pos > size)
            System.out.println("invalid position");
        else if (pos == 1) {
            if (head == null)
                System.out.println("List is empty");
            else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (pos == size) {
            if (head == null)
                System.out.println("List is empty");
            else if (size == 1) {
                head = null;
                size--;
            } else {
                Node t;
                t = head;
                for (int i = 1; i < size - 1; i++) {
                    t = t.next;
                }
                tail = t;
                t.next = null;
                size--;
            }
        } else {
            Node t, t1;
            t = head;
            for (int i = 1; i < pos - 1; i++) {
                t = t.next;
            }
            t1 = t.next;
            t.next = t1.next;
            t1.next.prev = t;
            size--;
        }
    }

    void search() {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Roll Number: ");
        int roll = obj.nextInt();
        try {
            File fi = new File("all.txt");
            Scanner content = new Scanner(fi);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] parts = data.split(" ");
                if (Integer.parseInt(parts[0]) == roll) {
                    flag++;
                    if (flag == 1) {
                        System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s","S.No.","Roll Number","Name","Subject","Date","Attendance");
                        System.out.println();
                    }
                    System.out.printf("%-6s%-20s %-20s %-20s %-20s %-20s",flag,parts[0],parts[1],parts[2],parts[3],parts[4]);
                    System.out.println();
                } 
            }
            if(flag == 0){
                    System.out.println("Invalid input");
            }
            content.close();
        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    void exit() {
        Node t = head;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("info.txt"));
            while (t != null) {
                String merge = t.RollNo + " " + t.Name + " " + t.CN + " " + t.DECA + " " + t.DS;
                out.write(merge + "\n");
                t = t.next;
            }
            out.close();
        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
        System.out.println("File Updated");
    }
}
