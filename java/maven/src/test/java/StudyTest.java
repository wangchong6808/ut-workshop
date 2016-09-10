import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by wangchong on 9/8/16.
 */
public class StudyTest {

    @Test()
    public void testInput(){
        Student student = Mockito.mock(Student.class);

        student.name="Tom";
        student.chinese=30;
        student.english=80;
        student.math=95;
        student.programming=100;
        Mockito.doCallRealMethod().when(student).averageScore();
        Mockito.doCallRealMethod().when(student).totalScore();
        double d= student.averageScore();
        System.out.println("d="+d);
        //Mockito.doReturn(Mockito.doCallRealMethod()).when(student).averageScore();
        //Mockito.doReturn(150d).when(student).averageScore();
        System.out.println(student.name);
        System.out.println(student.averageScore());
    }
}