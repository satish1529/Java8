/**
 * 
 */
package com.satish.dynamicproxy;

/**
 * @author satish.k
 *
 */
public class InterfaceAImpl implements InterfaceA {

	/* (non-Javadoc)
	 * @see com.satish.dynamicproxy.InterfaceA#test(java.lang.String, int)
	 */
	@Override
	public void test(String a, int b) {
		// TODO Auto-generated method stub
		System.out.println("Target method start............");
		System.out.println("a : "+a+", b : "+b);
  	System.out.println("Target method end............");
	}

}
