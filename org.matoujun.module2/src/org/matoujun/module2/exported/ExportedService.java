/**
 * 
 */
package org.matoujun.module2.exported;

/**
 * @author matoujun
 *
 */
public class ExportedService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExportedService.printName();
	}
	
	public void visisDefault() {
		//compile failed
//		DefaultService ds = new DefaultService(); 
	}
	
	public static void printName() {
		System.out.println(ExportedService.class.getName());		
	}
	
	

}
