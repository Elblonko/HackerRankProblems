import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/** 
* Code.UtopiaTree Tester.
* 
* @author <Authors name> 
* @since <pre>Sep 30, 2014</pre> 
* @version 1.0 
*/ 
public class UtopiaTreeTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
}



/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...

    ArrayList<Integer> cycleSet1 = new ArrayList<Integer>(10);
    cycleSet1.add(1);
    cycleSet1.add(2);
    cycleSet1.add(3);
    cycleSet1.add(40);
    cycleSet1.add(4);
    cycleSet1.add(5);
    cycleSet1.add(6);

    int numTests1 = cycleSet1.size();

    //create Code.UtopiaTree
    UtopiaTree testTree1 = new UtopiaTree(cycleSet1, numTests1);

    //Test the Monsoon and Summer methods
    assertEquals( testTree1.Summer(1), 2);
    assertEquals( testTree1.Monsoon(6), 12);

    //Test the Calculate height and print methods
    assertEquals(testTree1.findMax(), 40);

    int max = testTree1.findMax();

    //test if calculate is working correctly
    testTree1.CalcHeights(max);

    cycleSet1 = testTree1.getCycleNumbers();
    for(int curr: cycleSet1){
        System.out.println(testTree1.getHeight(curr));
    }

} 


} 
