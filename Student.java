public class Student {
    public Student() {
        super();
    }
    String fName;
    String mName;
    String lName;
    int stuNumber;
    double gpa;

    public String getFullName() {
        return lName+", " + lName + " " + mName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMName() {
        return mName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
}