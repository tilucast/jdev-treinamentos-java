package SchoolProgram;

public class Main {
    public static void main(String[] args) {

        StudentClass studentclass = new StudentClass();
        studentclass.populate();

        System.out.println(studentclass);
        studentclass.find();

    }

}
