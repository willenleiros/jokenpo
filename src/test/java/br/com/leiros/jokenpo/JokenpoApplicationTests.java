package br.com.leiros.jokenpo;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("br.com.leiros.jokenpo")
@IncludeClassNamePatterns({"^.*ATeste?$"})
class JokenpoApplicationTests {

    @Test
    void contextLoads() {
    }

}
