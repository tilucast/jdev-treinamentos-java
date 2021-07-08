package Exceptions;

public class Testing {
    public static void main(String[] args) {
        //System.out.println(x);
        String x = "";
        try{

            int c = Integer.parseInt(x);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
