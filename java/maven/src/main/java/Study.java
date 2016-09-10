import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by wangchong on 9/8/16.
 */
public class Study {
    public static void main(String[] args) throws IOException {
        testScanner("请输入你的答案：");
        //String s = readDataFromConsole("input:");
        //System.out.println("output:"+s);
    }

    public static void test1() throws IOException {
        byte[] input = new byte[6];
        System.in.read(input);
        String s1 = new String(input);
        System.out.println("s1:" + s1);
    }

    public static String readDataFromConsole(String prompt) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.print(prompt);
            str = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void testScanner(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(text);
    }
}
