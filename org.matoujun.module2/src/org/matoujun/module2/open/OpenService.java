/**
 * 
 */
package org.matoujun.module2.open;

import java.util.UUID;

/**
 * @author matoujun
 *
 */
public class OpenService {
	private static final String id = UUID.randomUUID().toString();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OpenService.classMethod();
		OpenService openService = new OpenService();
		openService.instanceMethod();
	}
	
	public static void classMethod() {
		System.out.println(OpenService.class.getName() + "-" + id);
	}
	
	public void instanceMethod() {
		
		System.out.println(id);
	}

}
