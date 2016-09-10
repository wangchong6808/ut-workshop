/**
 * Created by wangchong on 9/7/16.
 */
public class Practice1 {
    private static String[][] input = {{"z张三","95","80","75","80"}, {"李四","80","70","85","90"}};
    private static String[] scores = {"语文", "英语", "数学", "编程", "平均分", "总分"};

    public static void main(String[] args){

        Person[] persons = transform(input);
        print(persons);
    }

    public static Person[] transform(String[][] input){
        Person[] persons = new Person[input.length];
        int pos = 0;
        for(String[] p : input){
            Person ps = new Person(p[0],p[1],p[2],p[3],p[4]);
            persons[pos] = ps;
            pos++;
        }
        return persons;
    }

    public static void print(Person[] persons){
        System.out.println("成绩单");
        double totalScoreOfWholeClass = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("================================");
        String sp = "|";
        for (Person p : persons){
            double totals = p.totalScore();
            if(totals < lowest){
                lowest = totals;
            }
            if(totals > highest){
                highest = totals;
            }
            totalScoreOfWholeClass += totals;
            String output = p.name+sp+p.math+sp+p.chinese+sp+p.english+sp+p.programming+sp+p.averageScore()+sp+p.totalScore();
            System.out.println(output);
        }
        System.out.println("================================");
        System.out.println("全班总分："+totalScoreOfWholeClass);
        System.out.println("全班总分中位数："+(highest+lowest)/2);

    }
}
