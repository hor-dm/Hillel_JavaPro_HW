import instruction.AfterSuite;
import instruction.BeforeSuite;
import instruction.Test;

public class Tests {
    @BeforeSuite
    public void beforeMethod(){
        System.out.println("Method with @BeforeSuit was ran.");
    }

    @Test(priority = 1)
    public void test_1(){
        System.out.println("Method with @Test and priority 1 was ran. " + (int) (Math.random() * 10));
    }

    @Test(priority = 2)
    public void test_3(){
        System.out.println("Method with @Test and priority 2 was ran. " + (int) (Math.random() * 10));
    }

    @AfterSuite
    public void afterMethod(){
        System.out.println("Method with @AfterSuite was ran.");
    }
}
