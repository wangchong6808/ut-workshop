import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by wangchong on 9/8/16.
 */
public class CompareNumberTest {

    @Test
    public void should_return_4A0B_when_input_is_1234_and_answer_is_1234(){
        String input = "1234";
        String answer = "1234";

        CompareNumber compareNumber = new CompareNumber();
        String tips = compareNumber.getTips(input, answer);

        assertThat(tips).isEqualTo("4A0B");
    }
}
