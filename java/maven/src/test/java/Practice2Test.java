import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.fest.assertions.api.Assertions.assertThat;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by wangchong on 9/7/16.
 */
public class Practice2Test {

    List<Student> studentList = null;
    String[][] input = {{"张三", "90", "85", "75", "95", "ID001", Practice2.NATION_HAN, Practice2.EXPERTISE_SPORT},
            {"李四", "95", "90", "75", "95", "ID002", Practice2.NATION_OTHER, Practice2.EXPERTISE_ART},
            {"熊大", "95", "90", "75", "90", "ID003", Practice2.NATION_OTHER, null}};

    @Before
    public void setUp() throws Exception {
        studentList = new ArrayList<Student>(3);
        studentList.add(new Student("张三", "90", "85", "75", "95", "ID001", Practice2.NATION_HAN, Practice2.EXPERTISE_SPORT));
        studentList.add(new Student("李四", "95", "90", "75", "95", "ID002", Practice2.NATION_OTHER, Practice2.EXPERTISE_ART));
        studentList.add(new Student("熊大", "95", "90", "75", "90", "ID003", Practice2.NATION_OTHER, null));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calculateTotalTest(){
        assertThat(Practice2.calculateTotal(studentList.get(0))).isEqualTo(studentList.get(0).totalScore()+20);
        assertThat(Practice2.calculateTotal(studentList.get(1))).isEqualTo(studentList.get(1).totalScore()+10+15);
        assertThat(Practice2.calculateTotal(studentList.get(2))).isEqualTo(studentList.get(2).totalScore()+10);
    }

    @Test
    public void transformToMapTest(){
        Map<String, Student> map = Practice2.tranformToMap(Practice2.getInitData());
        assertThat(map).isNotEmpty();
        assertThat(map.get("ID001").name).isEqualTo(studentList.get(0).name);
    }

    @Test
    public void calculateClassTotalAndAvgTest(){
        Map<String,Student> map = Practice2.tranformToMap(Practice2.getInitData());
        double total = studentList.get(0).totalScore()+20+studentList.get(1).totalScore()+10+15+studentList.get(2).totalScore()+10;
        double avg = total/3;
        double[] ret = Practice2.calculateClassAvgAndMiddle(map);
        assertThat(ret[0]).isEqualTo(total);
        assertThat(ret[1]).isEqualTo(avg);
    }

    @Test
    public void generateOutputTest(){
        String[] ids = {"ID001","ID002"};
        Map<String,Student> map = Practice2.tranformToMap(input);
        for(Student student : map.values()){
            student.total_score = Practice2.calculateTotal(student);

        }
        double[] totalAndAvg = Practice2.calculateClassAvgAndMiddle(map);

        String result = Practice2.generateOutput(ids,map,totalAndAvg);

        String a="成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
                "========================\n" +
                "张三|75.0|90.0|85.0|95.0|86.25|365.0\n" +
                "李四|75.0|95.0|90.0|95.0|88.75|380.0\n" +
                "========================\n" +
                "全班总分平均数：368\n" +
                "全班总分中位数：370";
        assertThat(result).isEqualTo(a);

    }

}