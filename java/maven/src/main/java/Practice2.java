import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchong on 9/7/16.
 */
public class Practice2 {

    public static String NATION_HAN="HAN";
    public static String NATION_OTHER="Other";
    public static String EXPERTISE_SPORT="Sport";
    public static String EXPERTISE_ART="ART";
    public static String SP = "|";
    public static double calculateTotal(Student stu){
        double total = stu.totalScore();
        if(NATION_OTHER.equals(stu.nation)){
            total += 10;
        }
        if(EXPERTISE_SPORT.equals(stu.expertise)){
            total += 20;
        }else if(EXPERTISE_ART.equals(stu.expertise)){
            total += 15;
        }
        return total;
    }

    public static String[][] getInitData(){
        String[][] input = {{"张三","90","85","75","95","ID001",Practice2.NATION_HAN,Practice2.EXPERTISE_SPORT},
                {"李四","95","90","75","95","ID002",Practice2.NATION_OTHER,Practice2.EXPERTISE_ART},
                {"熊大","95","90","75","90","ID003",Practice2.NATION_OTHER,null}};
        return input;
    }

    public static Map<String, Student> tranformToMap(String[][] input){
        Map<String,Student> map = new HashMap<String, Student>();
        for(String[] s : input){
            Student st = new Student(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
            map.put(s[5],st);
        }
        return map;
    }

    public static double[] calculateClassAvgAndMiddle(Map<String,Student> map){
        double[] ret = new double[2];
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        for(String key : map.keySet()){
            Student stu = map.get(key);
            total += stu.total_score;
            if (stu.total_score > highest){
                highest = stu.total_score;
            }
            if(stu.total_score < lowest){
                lowest = stu.total_score;
            }
        }
        ret[0] = total/map.size();
        ret[1] = (highest+lowest)/2;
        return ret;
    }

    public static String generateOutput(String[] IDs, Map<String,Student> map, double[] totalAngAvg){
        StringBuilder sb = new StringBuilder("成绩单\n");
        sb.append("姓名|数学|语文|英语|编程|平均分|总分 \n");
        sb.append("========================\n" );
        for (String id : IDs){
            Student student = map.get(id);
            sb.append(student.name).append(SP).append(student.math).append(SP).append(student.chinese).append(SP).append(student.english);
            sb.append(SP).append(student.programming).append(SP).append(student.averageScore()).append(SP).append(student.total_score);
            sb.append("\n");
        }
        sb.append("========================\n" );
        sb.append("全班总分平均数：" ).append(Math.round(totalAngAvg[0])).append("\n");
        sb.append("全班总分中位数：").append(Math.round(totalAngAvg[1]));

        return sb.toString();

    }
}
