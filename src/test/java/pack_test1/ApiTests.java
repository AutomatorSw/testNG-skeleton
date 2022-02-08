package pack_test1;

import com.skippersoft.testng.Groups;
import com.skippersoft.testng.Unstable;
import io.qameta.allure.Attachment;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Groups("aaa")
public class ApiTests {
    @Attachment
    String intercept(){
        System.out.println("{a:b}");
        return "{a:b}";
    }

    @Step
    void step1(String s){
        System.out.println("I'm step1");
        intercept();
    }
    @Test(groups = {"t1"})
    void passedTest() {
        System.out.println("IT'S T1 TEST");
        Assert.assertTrue(true);
    }

    @Test(groups = {"t1", "t2"})
    @Unstable
    @Flaky
    void passedTest2() {
        System.out.println("IT'S T1 and T2 TEST");
        step1("ssss");
        Assert.assertTrue(true);
    }

    @Test(groups = {"t2"})
    void failedTest3() {
        System.out.println("IT'S T2 TEST");
        Assert.assertTrue(true);
    }

    @Test
    void firstUnique() {
        String s = "hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs";
        Map<Character, Long> map = s
                .chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
