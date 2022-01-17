package pack_test1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {
    @Test(groups = {"t1"})
    void passedTest(){
        System.out.println("IT'S T1 TEST");
        Assert.assertTrue(true);
    }

    @Test(groups = {"t2"})
    void passedTest2(){
        System.out.println("IT'S T2 TEST");
        Assert.assertTrue(true);
    }
}
