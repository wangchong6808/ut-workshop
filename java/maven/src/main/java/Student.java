/**
 * Created by wangchong on 9/7/16.
 */
public class Student extends Person {
    String id;
    String nation;
    String expertise;
    double total_score;

    public Student(String name, String chinese, String english, String math, String programming, String id, String nation, String expertise){
        super(name,chinese,english,math,programming);
        this.id = id;
        this.nation = nation;
        this.expertise = expertise;
    }

    public Student(){

    }

}
