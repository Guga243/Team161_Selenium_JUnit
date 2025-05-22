package tests.day12_actiopnsClass_FakerClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C06_FakerClass extends TestBase_Each {
    @Test
    public void test(){

        Faker faker = new Faker();
        System.out.println(faker.address().fullAddress());

    }
}
