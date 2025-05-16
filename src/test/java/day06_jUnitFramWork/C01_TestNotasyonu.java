package day06_jUnitFramWork;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class C01_TestNotasyonu {

    /*
    bir classin run edilir olmasi icin mutlaka main method olmali demistik

   main method olmadan methodlarin yaninda run tusu cikmiyir

   junit freamwork ile gelen en buyuk promosyon

   @test notasyonu sayesinde her bir method bagimsiz olarak calistirilabilir hale gelir


     */

    @Test @Disabled
    public void test01(){
        System.out.println("test 1 calistii");
    }

    @Test
    public void test02(){
        System.out.println("test 2 calisti");


    }

    @Test
    public void test03(){
        System.out.println("test 3 calisti");


    }


}
 