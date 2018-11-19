/**
 * 
 */
package org.matoujun.module2.bedefault;

import org.matoujun.module2.exported.ExportedService;

/**
 * @author matoujun
 *
 */
class DefaultService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DefaultService defaultService = new DefaultService();
		
		defaultService.visitPublic();

	}
	
	public void visitPublic() {
		ExportedService.printName();
		
	}
	
	public void printName() {
		System.out.println(DefaultService.class.getSimpleName());
	}
	
	protected class ProtectedClz{
		
	}
	class DefaultClz{
		PrivateClz privateClz = new PrivateClz();
	}
	
	private class PrivateClz{
		
	}
}
