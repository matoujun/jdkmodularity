/**
 * 
 */
package org.matoujun.module3;

import java.util.logging.Logger;

import org.matoujun.module2.exported.ExportedService;

/**
 * @author matoujun
 *
 */
public class Module3Clz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExportedService.printName();
		Logger log = Logger.getLogger(Module3Clz.class.getName());
		log.info("In Module3Clz " + System.currentTimeMillis());
	}

}
