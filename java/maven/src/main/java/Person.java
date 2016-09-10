/**
 * Created by wangchong on 9/7/16.
 */
public class Person {

    String name;
    double chinese;
    double english;
    double math;
    double programming;

    public Person(String name, String chinese, String english, String math, String programming){
        this.name = name;
        this.chinese = Double.valueOf(chinese);
        this.english = Double.valueOf(english);
        this.math = Double.valueOf(math);
        this.programming = Double.valueOf(programming);
    }

    public Person(){

    }

    public double averageScore(){
        System.out.println("averageScore is called.."+chinese+name);
        System.out.println("totalScore()="+totalScore());
        return totalScore()/4;
    }
    public double totalScore(){
        System.out.println("total socre is called.");
        return chinese+english+math+programming;
    }
}
