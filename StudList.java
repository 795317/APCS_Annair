import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudList {
    public StudList() {
        super();
    }
   
    static ArrayList<Student> students = new ArrayList<Student>();
   
    /*
     *  Allows the user to add a student to the end of the List.  
     *  For each student, the user can input a student number, a GPA, and a student name.  
     *  Names may be entered in one of four formats::
     *    1. Last, First
     *    2. Last, First Middle
     *    3. First Last
     *    4. First Middle Last
     */
    public void addStudent(String fullName,int stuNumber,double gpa){
        Student stud = new Student();
        String[] name = nameScanner(fullName);
        if (name[0]  == null  || name [2]  == null) {
            System.out.println("First or Last name missing");
        } else {
            stud.setFName(name[0]);
            stud.setLName(name[2].trim());
            stud.setMName(name[1]);
            stud.setStuNumber(stuNumber);
            stud.setGpa(gpa);
            students.add(stud);
        }
       
    }
   
    /**
     *
     * @param fullName
     * @return
     */
    private String[] nameScanner(String fullName){
        String[] names = new String[3];
        String firstName = null, middleName = "", lastName = null;
        if (fullName.indexOf(",") != -1) {
            //LastNameformat
            lastName = fullName.substring(0, fullName.indexOf(","));
            String firstMiddle =
                fullName.substring(fullName.indexOf(",") + 2, fullName.length());

            if (firstMiddle.lastIndexOf(" ") != -1) {
                firstName =
                        firstMiddle.substring(0, firstMiddle.lastIndexOf(" "));
                middleName = fullName.substring(fullName.lastIndexOf(" "));
            } else {
                firstName = firstMiddle;
            }


        } else {
            if (fullName.indexOf(" ") != -1)
                firstName = fullName.substring(0, fullName.indexOf(" "));
            if (fullName.indexOf(" ") != fullName.lastIndexOf(" ")) {
                middleName =
                        fullName.substring(fullName.indexOf(" "), fullName.lastIndexOf(" "));

            }
            if (fullName.indexOf(" ") !=-1)
                lastName = fullName.substring(fullName.lastIndexOf(" "));
            //First Nameformat
        }
        names[0]=firstName;
        names[1] = middleName;
        names[2] = lastName;
        return names;
    }
    /*
     * Allows the user to specify a Student last name deleted from the list.
     */
    public void deleteStudent(String lastName){
        Student student = StudList.findByName( lastName, StudList.students);
        if(student != null){
             students.remove(student);
           
        }  else
            System.out.println("No student exist with the last name > " + lastName);
    }
   
    /*
     * Allows the user to specify a student number and deletes that student from the list.
     */
    public void deleteStudent(int stuNumber){
        Student student = StudList.findByNumber(stuNumber, StudList.students);
        if(student != null){
            students.remove(student);
           
        }else
            System.out.println("No student exist");
       
    }
   
    /*
     * Allows the user to specify a student name and then update or change the Student name and GPA
     */
    public void editStudentList(String lastName){
        Student student = StudList.findByName( lastName, StudList.students);
        if (student != null){
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Enter new  name ("+student.getLName()+") :");
            String name = scannerObj.nextLine();
            if(name != null ) {
                String [] names = this.nameScanner(name);
                if (names[0]  == null  || names [2]  == null) {
                    System.out.println("First or Last name missing");
                } else {
                   student.setFName(names[0]);
                   student.setLName(names[2].trim());
                   student.setMName(names[1]);
                }
            }
               
            System.out.println("Enter new GPA ("+ student.getGpa()+ ") :");
            double gpa = scannerObj.nextDouble();
            if(gpa > 0)
                student.setGpa(gpa);
           
        }else
            System.out.println("No student exist with the last name > " + lastName);
    }
   
    /*
     * Allows the user to specify a Student number and then update or change the Student name and GPA
     */
    public void editStudentList(int stuNumber){
        Student student = StudList.findByNumber( stuNumber, StudList.students);
        if (student != null){
            Scanner scannerObj = new Scanner(System.in);
            System.out.println("Enter new  name ("+student.getLName()+") :");
            String name = scannerObj.nextLine();
            if(name != null ) {
                String [] names = this.nameScanner(name);
                if (names[0]  == null  || names [2]  == null) {
                    System.out.println("First or Last name missing");
                } else {
                   student.setFName(names[0]);
                   student.setLName(names[2].trim());
                   student.setMName(names[1]);
                }
            }
             
            System.out.println("Enter new GPA ("+ student.getGpa()+ ") :");
            double gpa = scannerObj.nextDouble();
            if(gpa > 0)
                student.setGpa(gpa);
           
        }else
            System.out.println("No student exist with the number > " + stuNumber);
    }
   
    /*
     *  Deletes the entire list (null in each element without a student record).
     */
    public void clearList() {
        students.clear();
    }
   
    /*
     * Clears the screen and then prints the list to the screen.  Does not print null records.
     */
    public void printList(){
        for (int i = 0; i < students.size(); i++) {
            Student st = students.get(i);
            if (st.getLName() != null) {
                System.out.println("Number       > " + st.getStuNumber());
                System.out.println("First Name   > " + st.getFName());
                System.out.println("Last Name    > " + st.getLName());
                System.out.println("GPA          > " + st.getGpa());
                System.out.println("----------------------");
                System.out.println("  ");
            }
        }
    }
   
    /*
     * Clears  the screen and then prints a student with the input name to the screen.  
     * If the Student does not exist, print message to the console: "Student does not exist."
     */
    public void printStudent(String lastName){
        Student student = StudList.findByName( lastName, StudList.students);
        if (student != null){
           
            System.out.println("Number       > " + student.getStuNumber());
            System.out.println("First Name   > " + student.getFName());
            System.out.println("Last Name    > " + student.getLName());
            System.out.println("GPA          > " + student.getGpa());
            System.out.println("");
           
        }else
            System.out.println("No student exist with the last name > " + lastName);
    }
   
    /*
     * Clears  the screen and then prints a student student with the input student number to the screen.
     * If the Student does not exist, print message to the console: "Student does not exist."
     */
    public void printStudent(int stuNumber){
        Student student = StudList.findByNumber( stuNumber, StudList.students);
        if (student != null){
            System.out.println("Number       > "   + student.getStuNumber());
            System.out.println("First Name   > "   + student.getFName());
            System.out.println("Last Name    > "   + student.getLName());
            System.out.println("GPA          > "   + student.getGpa());
           
        }else
            System.out.println("No student exist with the number > " + stuNumber);
    }
   
    /*
     * Sorts students by student name
     */
    public void SortStudentsByLastName() {
        //Quick Sort
        QuickSort(students,0,students.size());
        System.out.println("Sorted List by Name ");
        System.out.println(" ");
        for (int i=0; i < students.size();i++ ){
            Student st = students.get(i);
            System.out.println("Number       > " + st.getStuNumber());
            System.out.println("First Name   > " + st.getFName());
            System.out.println("Last Name    > " + st.getLName());
            System.out.println("GPA          > " + st.getGpa());
            System.out.println("----------------------");
            System.out.println("  ");
        }
    }
   
    private void QuickSort(ArrayList<Student>  students,int lowerBound,int upperBound){
        if (lowerBound < upperBound) {
            int location = ParitionList(students,lowerBound,upperBound);
            QuickSort(students,lowerBound,location-1);
            QuickSort(students,location+1,upperBound);
        }
       
    }
   
    private int ParitionList(ArrayList<Student>  students,int lowerBound,int upperBound){
        int start = lowerBound;
        int end   = upperBound-1;
        String pivot = students.get(lowerBound).getLName();
        while (start < end){
            while (students.get(start).getLName().compareTo(pivot) <=  0 && start < end)  {
                start++;
            }
            while (students.get(end).getLName().compareTo(pivot) > 0)  {
                end--;
            }
            if (start < end){
                swap( start , end );
            }
        }
         swap( lowerBound , end );
        return end;
    }
   
    private void swap(int start,int end){
       Student tmp = students.get(end);
       students.set(end,students.get(start));
       students.set(start,tmp);
    }
   
    /*
     * Sorts students by student number
     */
    public void SortStudentsByNumber(){
        //using Bubble Sort
       
        Student tmp ;
        for (int i=0; i < students.size()-1; i++){
            for (int j =0; j < students.size()-1-i; j++){
                if (students.get(j).getStuNumber() > students.get(j+1).getStuNumber()){
                    tmp = students.get(j);
                     
                    students.set(j,students.get(j+1)) ;
                    students.set(j+1,tmp) ;
                }
            }
        }
       
        System.out.println("Sorted List by Number ");
        System.out.println(" ");
       for (int i=0; i < students.size(); i++){
             Student st = students.get(i);
             System.out.println("Number       > " + st.getStuNumber());
             System.out.println("First Name   > " + st.getFName());
             System.out.println("Last Name    > " + st.getLName());
             System.out.println("GPA          > " + st.getGpa());
             System.out.println("----------------------");
             System.out.println("  ");
         }
    }
   
    /*
     * Finds all students matching "key" and creates and returns a list of those students
     */
    public ArrayList<Student> filterSearchStudentList(String key){
      return null;  
    }
   
    /**
     *Get student object by name
     * @param name
     * @param students
     * @return
     */
    public static Student findByName(String name, List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getLName().equals(name)) {
                return student;
            }
        }
        return null;
    }
   
    /**
     *Get student object by number
     * @param studNum
     * @param students
     * @return
     */
    public static Student findByNumber(int studNum, ArrayList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStuNumber()== studNum) {
                return student;
            }
        }
        return null;
    }
   
    public void filterStudentsByGPA(double gpa) {
        ArrayList<Student> filterList = new ArrayList<Student>();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getGpa() <= gpa)
                filterList.add(student);
        }
       
        //print filtered list
        if (filterList.isEmpty())
            System.out.println("No student exist ...");
        else {
            Iterator<Student> filtItr = filterList.iterator();
            while (filtItr.hasNext()) {
                Student st = filtItr.next();
                System.out.println("Number       > " + st.getStuNumber());
                System.out.println("First Name   > " + st.getFName());
                System.out.println("Last Name    > " + st.getLName());
                System.out.println("GPA          > " + st.getGpa());
                System.out.println("----------------------");
                System.out.println("  ");
            }
        }
    }
   
    public void filterStudentsByNumber(int studNumber) {
        ArrayList<Student> filterList = new ArrayList<Student>();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStuNumber() <= studNumber)
                filterList.add(student);
           
        }
       
        //print filtered list
        if (filterList.isEmpty())
            System.out.println("No student exist ...");
        else {
            Iterator<Student> filtItr = filterList.iterator();
            while (filtItr.hasNext()) {
                Student st = filtItr.next();
                System.out.println("Number       > " + st.getStuNumber());
                System.out.println("First Name   > " + st.getFName());
                System.out.println("Name         > " + st.getLName());
                System.out.println("GPA          > " + st.getGpa());
                System.out.println("----------------------");
                System.out.println("  ");
            }
        }
    }
}