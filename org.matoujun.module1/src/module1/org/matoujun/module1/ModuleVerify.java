/**
 * 
 */
package org.matoujun.module1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ServiceLoader;

import org.matoujun.module2.provider.ServiceInterfaces;


//import org.matoujun.module2.open.OpenService;

/**
 * @author matoujun
 */
public class ModuleVerify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("Modularity verify");
//		Logger log = Logger.getLogger(ModuleVerify.class.getName());
//		if (log.isLoggable(Level.INFO)) {
//			log.info("in ModuleVerify");
//		}
//
		ModuleVerify mv = new ModuleVerify();
//		mv.callModule2();

//		mv.commonAutoModule();
		mv.unnamedModule();
		
//		System.out.println(mv.getClass().getModule().getName());
	}
	
	public void unnamedModule() {
		String gs = com.google.common.base.Strings.nullToEmpty("guava");
		System.out.println(gs);
		Module module = com.google.common.base.Strings.class.getModule();
		System.out.println(module.getName());
	}
	
	public void commonAutoModule() {
//		System.out.println(org.apache.commons.lang.StringUtils.lowerCase("AAAAA"));
		Module module = org.apache.commons.lang.StringUtils.class.getModule();
		System.out.println(module.getName());
	}

	public void callModule2() {
//		ExportedService.printName();
		// default access control to prevent visit out of the package
//		org.matoujun.module2.bedefault.DefaultService ds = new org.matoujun.module2.bedefault.DefaultService();

		// Although parent package is exported, if the package not, the types under it
		// still isn't accessible.
//		CLzInSubExportedPack subClz = new CLzInSubExportedPack();
		// Because module2 is opened, all classes reflection is permitted.
		try {
			Class<?> cLzInSubExportedPackClass = Class
					.forName("org.matoujun.module2.exported.subpack.CLzInSubExportedPack");
			System.out.println(cLzInSubExportedPackClass.getName());

			Class<?> cLzInOpenPackClass = Class.forName("org.matoujun.module2.open.OpenService");

			Method staticMethod = cLzInOpenPackClass.getMethod("classMethod", null);
			System.out.println("OpenService classMethod: " + staticMethod.getName());
			Object openObject = cLzInOpenPackClass.getConstructor(null).newInstance(null);

			staticMethod.invoke(openObject, null);

			Method instanceMethod = cLzInOpenPackClass.getMethod("instanceMethod", null);
			System.out.println("OpenService instanceMethod: " + instanceMethod.getName());
			instanceMethod.invoke(openObject, null);

			Field idField = cLzInOpenPackClass.getDeclaredField("id");
			idField.setAccessible(true);
			System.out.println(idField.get(openObject));

//			OpenService open = new OpenService();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * DI can do the same job.
		 */
		Iterable<ServiceInterfaces> serviceInterfaces = ServiceLoader.load(ServiceInterfaces.class);
		for (ServiceInterfaces si : serviceInterfaces) {
			si.printImplName();
		}

	}

}
