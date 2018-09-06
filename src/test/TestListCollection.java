import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestListCollection {

    private List<String> l;

    @Before
    public void setUp(){

        l = new LinkedList<>();
        l.add("texto1");
        l.add("texto2");
        l.add("texto3");

    }

    @Test
    public void testSize(){

        Assert.assertEquals(3, l.size() );

    }

    @Test
    public void testEmpty(){

        Assert.assertFalse("List is empty", l.isEmpty());

    }

}
