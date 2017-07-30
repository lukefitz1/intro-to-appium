package test.tmp;

import org.testng.annotations.Test;

public class androidbasicsTest {

  @Test
  public void mainString1() {
	  System.out.println("Test1");
	  throw new RuntimeException("Test not implemented");
  }

  @Test
  public void mainString2() {
	  System.out.println("Test2");
	  throw new RuntimeException("Test not implemented");
  }
}
