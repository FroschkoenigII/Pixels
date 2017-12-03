package pixels.webserver.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomApplicationTest {
	
@Test
public void testFuntctionWorking()
{
	int result = 1+1;
	assertEquals(2, result);
	}
	
@Test
public void testFuntctionNotWorking()
{
	int result = 3;
	assertEquals(2,result);
	}

@Test
public void testFuntctionWorking2()
{
	int result = 3;
	assertEquals(3,result);
	}

@Test
public void testFuntctionNotWorking2()
{
	int result = 3;
	assertEquals(2,result);
	}

}
