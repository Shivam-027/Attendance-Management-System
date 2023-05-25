/**             Make a Student Attendance Management System which will be able to add, delete, update,
                records of student using linked list. Also, sorting of students based on roll number is done using
                the best sorting algorithm.
                DoD :
                1. use linked list and its operations
                2. use sorting technique
                3. adding of attendance as A and P for any number of days should be done according to
                the user using Linked List only

                                                Shreya 21csu096
                                                Somil 21csu100
                                                Soha 21csu099
                                                Sidhant 21csu098

*/

import java.util.*;
import java.io.*;
import java.text.*;

public class Main{
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        AttendanceList ll = new AttendanceList();
        AttendanceList aa = new AttendanceList();
        opening();
        try {
            File fi = new File("info.txt");
            Scanner content = new Scanner(fi);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] parts = data.split(" ");                  
                ll.insert(parts[0],parts[1],parts[2],parts[3],parts[4]);
            }
            content.close();
        } 
        catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
        System.out.println("Book Updated");
        int a = 10;
        while(a != 0){
            System.out.println("\n0. Exit\n1. View Attendance(Student)\n2. View Overall Attendance\n3. Update\n4. Insert\n5. Delete\n6. Search Attendance");
            System.out.print("Enter: ");
            a = obj.nextInt();
            if(a == 1){
                ll.viewAttendance();
            }
            else if (a == 2){
                aa.view();
            }
            else if(a == 3){
                ll.update();
            }
            else if(a == 4){
                System.out.print("\nEnter\nRoll Number: ");
                String r = obj.next();
                System.out.print("Name: ");
                String n = convertString(obj.next());
                ll.insert(r, n, "0/0", "0/0", "0/0");
            }
            else if(a == 5){
                System.out.print("\nEnter\nRoll Number: ");
                String n = obj.next();
                ll.delete(n);
            }
            else if(a == 6){
                ll.search();
            }
        }
        ll.exit();
    }

    static String convertString(String s)  
    {  
        int ctr = 0 ;  
        int n = s.length( ) ;  
        char ch[ ] = s.toCharArray( ) ;  
        int c = 0 ;  
        for ( int i = 0; i < n; i++ )  
        {  
            if( i == 0 )  
            ch[ i ] = Character.toUpperCase( ch[ i ] ) ;    
            if ( ch[ i ] == ' ' )  
            {  
                ctr++ ;  
                ch[ i + 1 ] = Character.toUpperCase( ch[ i + 1] ) ;  
                continue ;  
            }  
            else  
                ch[ c++ ] = ch[ i ] ;  
        }  
        return String.valueOf( ch, 0, n - ctr ) ;  
    }  

    static void opening(){
        System.out.println("\n");
        System.out.println("\t\t\t     *******************************************************");
        System.out.println("\t\t\t     *                                                     *");
        System.out.println("\t\t\t     *                                                     *");
        System.out.println("\t\t\t     *     ------------------------------------------      *");
        System.out.println("\t\t\t     *        WELCOME TO Attendance Management System      *");
        System.out.println("\t\t\t     *     ------------------------------------------      *");
        System.out.println("\t\t\t     *                                                     *");
        System.out.println("\t\t\t     *                                                     *");
        System.out.println("\t\t\t     *******************************************************");
        System.out.println();
    }
}
