package pack_test1;

import com.skippersoft.testng.Groups;
import com.skippersoft.testng.Unstable;
import io.qameta.allure.Flaky;
import org.testng.Assert;
import org.testng.annotations.Test;

@Groups("aaa")
public class ApiTests {
    @Test(groups = {"t1"})
    void passedTest(){
        System.out.println("IT'S T1 TEST");
        Assert.assertTrue(true);
    }

    @Test(groups = {"t2"})
    @Unstable @Flaky
    void passedTest2(){
        System.out.println("IT'S T2 TEST");
        Assert.assertTrue(true);
    }
    @Test(groups = {"t2"})
    void failedTest3(){
        System.out.println("IT'S T2 TEST too");
        Assert.assertTrue(true);
    }
}
