package site.btsearch.tools;

import org.junit.Assert;
import org.junit.Test;

public class TestPropertiesReader {


    @Test
    public void TestLoadProperties(){
        PropertiesReader reader = PropertiesReader.NewInstance();
        Assert.assertNull(reader);
    }

}
