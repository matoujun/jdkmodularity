
/**
 * @author matoujun
 *
 */
//open module org.matoujun.module2 {//open the whole module
module org.matoujun.module2 {
	exports org.matoujun.module2.bedefault;
	exports org.matoujun.module2.exported to org.matoujun.module3;
	opens org.matoujun.module2.open to module1;
	exports org.matoujun.module2.provider;
	provides org.matoujun.module2.provider.ServiceInterfaces with org.matoujun.module2.provider.ServiceInterfacesImpl;
//	exports org.matoujun.module2.open;
}