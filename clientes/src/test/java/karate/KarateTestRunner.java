package karate;

import com.intuit.karate.junit5.Karate;

public class KarateTestRunner {
    
    @Karate.Test
    Karate integrationTest(){
        return Karate.run("classpath:karate").relativeTo(getClass());
    }
}
