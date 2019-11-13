import java.util.Scanner;

public class StudListRunner {
    public StudListRunner() {
        super();
    }
   
   
   
    public  int getUserSelectionMenu(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Please select an option  ");
        System.out.println( "1 > Add Student");
        System.out.println( "2 > Edit Student");
        System.out.println( "3 > Delete Student");
        System.out.println( "4 > Print Student List");
        System.out.println( "5 > Print Student");
        System.out.println( "6 > Sort Students By Name");
        System.out.println( "7 > Sort Students By Number");
        System.out.println( "8 > Filter Students");
        System.out.println( "9 > Clear Students List");
        System.out.println( "10 > Exit");
        int optionSelected = -1;
        try {
               optionSelected = scannerObj.nextInt();
        }catch(Exception e) {
           // System.out.println("User selection failed . Enter a number between 1 to 10");
        }
        System.out.println("User selection " + optionSelected);
        return optionSelected;
    }
   
    public int getUserByNameOrNumber(String operation){
        Scanner scannerObj = new Scanner(System.in);
        if ("DELETE".equals(operation))
           System.out.println("Please select a delete option: ");
        else if ("EDIT".equals(operation))
            System.out.println("Please select an edit option: ");
        else if ("PRINT".equals(operation))
            System.out.println("Please select a print option: ");
        else if ("FILTER".equals(operation))
            System.out.println("Please select a filter option: ");
        if ("FILTER".equals(operation))
            System.out.println( "1 > Student GPA");
        else
            System.out.println( "1 > Student Last Name");
        System.out.println( "2 > Student Number");
        int optionSelected = scannerObj.nextInt();
        return optionSelected;
    }
   
    private String getStudentName(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println( "Enter Student Last Name");
        return scannerObj.nextLine();
    }
   
    private int getStudentNumber(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println( "Enter Student Number");
        return scannerObj.nextInt();
    }
   
    private  void addStudent(StudList studList){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scannerObj.nextLine();    
        System.out.println("Number: ");
        int stuNumber = scannerObj.nextInt();
        System.out.println("GPA: "); ;
        double gpa = scannerObj.nextDouble();
        studList.addStudent(name, stuNumber, gpa);
       
    }

    public static void main(String[] args) {
        StudListRunner slistRunner = new StudListRunner();
        StudList studList = new StudList();
//        //testing
//        Student s  = new Student();
//        s.setLName("aa");
//        studList.students.add(s);
//        
//        Student s1  = new Student();
//        s1.setLName("ff");
//        studList.students.add(s1);
//        
//        Student s2  = new Student();
//        s2.setLName("ba");
//        studList.students.add(s2);
       
        int optionSelected =0;
        while (optionSelected != 10   ) {
            optionSelected = slistRunner.getUserSelectionMenu();
            if (optionSelected == 1) {
                slistRunner.addStudent(studList);
            }else if (optionSelected == 2) {
                int option = slistRunner.getUserByNameOrNumber("EDIT");
                if (option == 1){
                    String stuName =slistRunner.getStudentName();
                    studList.editStudentList(stuName);
                //Delete by number    
                }else {
                    int stuNumber=slistRunner.getStudentNumber();
                    studList.editStudentList(stuNumber);
                   
                }
            }else if (optionSelected == 3) {
                int option = slistRunner.getUserByNameOrNumber("DELETE");
                //Delete by name
                if (option == 1){
                    String stuName =slistRunner.getStudentName();
                    studList.deleteStudent(stuName);
                //Delete by number    
                }else {
                    int stuNumber=slistRunner.getStudentNumber();
                    studList.deleteStudent(stuNumber);
                   
                }
           }else if (optionSelected == 4) {
                studList.printList();
            }else if (optionSelected == 5) {
                    int option = slistRunner.getUserByNameOrNumber("PRINT");
                    //Delete by name
                    if (option == 1){
                        String stuName =slistRunner.getStudentName();
                        studList.printStudent(stuName);
                    //Delete by number    
                    }else {
                        int stuNumber=slistRunner.getStudentNumber();
                        studList.printStudent(stuNumber);
                       
                    }    
            }else if (optionSelected == 9) {
                Scanner scannerObj = new Scanner(System.in);
                System.out.println("This will remove all students. Do you want to proceed ( Y or N )");
                String confirm = scannerObj.nextLine();
                if ("Y".equalsIgnoreCase(confirm))
                    studList.clearList();
            }else if (optionSelected == 6) {
                studList.SortStudentsByLastName();
            }else if (optionSelected == 7) {
                studList.SortStudentsByNumber();
            }else if (optionSelected == 8) {
                int option = slistRunner.getUserByNameOrNumber("FILTER");
                Scanner scannerObj = new Scanner(System.in);
                if (option ==1 ){
                    System.out.println("Enter student GPA");
                    double gpa = scannerObj.nextDouble();
                    studList.filterStudentsByGPA(gpa);
                }else {
                    System.out.println("Enter student number");
                    int studNumber = scannerObj.nextInt();
                    studList.filterStudentsByNumber(studNumber);
                }
            }
            else {
                System.out.println("No. of students " + StudList.students.size());
                break;
            }
        }
       

    }
   
}