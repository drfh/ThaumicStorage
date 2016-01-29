package com.drfh.thaumicstorage;

public class Reference {
	public static final String MOD_ID = "thaumicstorage";
	public static final String MOD_NAME = "Thaumic Storage";
	public static final String VERSION = "0.2.1.1";

	public static final String CLIENT_PROXY_CLASS = "com.drfh.thaumicstorage.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.drfh.thaumicstorage.proxy.ServerProxy";
	
	public static final String	deps="required-after:FML;required-after:Thaumcraft@[5.0.1,);required-after:Baubles@[1.1.1.0,);";
	public static final String	version_check_url="https://raw.githubusercontent.com/DRFH/ThaumicStorage/master/version.json";
}
