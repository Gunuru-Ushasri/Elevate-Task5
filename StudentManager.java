import java.util.*;
public class StudentManager{
    private ArrayList<Student> students=new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);

    public void addStudent(){
        System.out.println("Enter ID: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name: ");
        String name=scanner.nextLine();

        System.out.println("Enter marks: ");
        double marks=scanner.nextDouble();

        students.add(new Student(id,name,marks));
        System.out.println("Student added Successfully!...\n");
    }

    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No records found!...\n");
        }
        else{
            for(Student s:students){
                System.out.println(s.toString());
            }
        }
    }

    public void updateStudent(){
        System.out.println("Enter Id to update: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        for(Student s:students){
            if(s.getId()==id){
                System.out.println("Enter new Name: ");
                s.setName(scanner.nextLine());

                System.out.println("Enter new Marks: ");
                s.setMarks(scanner.nextDouble());

                System.out.println("Student updated successfully!...\n");
                return;
            }
            System.out.println("Student not found.\n");

        }
        

    }

    public void deleteStudent(){
        System.out.println("Enter Id to delete: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        for(Student s:students){
            if(s.getId()==id){
                students.remove(s);
                System.out.println("Student deleted succesfully!..\n");
                return;
            }
        }
        System.out.println("Student not found \n");

    }


}