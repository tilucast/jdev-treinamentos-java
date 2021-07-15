package Threads;

import java.util.Objects;

public class QueueObject {

    private String name;
    private String email;
    private double random;

    QueueObject(double random){
        this.name = "Some generic name";
        this.email = "Some generic email";
        this.random = random;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRandom(){
        return random;
    }

    public void busyMethod(){
        double count = 0;
        for (int i = 0; i < 40000; i++) {
            count += random;
        }

        System.out.println("Count is: " + count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueObject that = (QueueObject) o;
        return name.equals(that.name) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
