import java.util.*;
public class Main{
    public static void main(String[] args){
        StudentManager manager=new StudentManager();
        Scanner scanner=new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n....STUDENT REOCRD MANAGEMENT SYSTEM...\n");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            choice=scanner.nextInt();

            switch(choice){
                case 1 -> manager.addStudent();
                case 2 -> manager.viewStudents();
                case 3 -> manager.updateStudent();
                case 4 -> manager.deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice ");
            }
            

        }
        while(choice!=5);
        scanner.close();
    }
}