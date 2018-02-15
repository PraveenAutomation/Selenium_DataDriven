package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=5)
	public void sum()
	{
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println("sum is "+c);
	}
	
	@Test(invocationCount=3)
	public void minus()
	{
		int a=20;
		int b=10;
		int x=a-b;
		System.out.println("minus is "+x);
	}
	
	
	
	

}
