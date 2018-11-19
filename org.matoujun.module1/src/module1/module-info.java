
/**
 * @author matoujun
 *
 */
module module1 {
	requires transitive java.logging;
	requires org.matoujun.module2;
	exports org.matoujun.module1;
	uses org.matoujun.module2.provider.ServiceInterfaces;
	requires commons.lang;
}