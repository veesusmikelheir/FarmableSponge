package com.veesus.farmablesponge;

import org.apache.logging.log4j.Logger;

import com.veesus.farmablesponge.proxy.SharedProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FarmableSponge.MODID,version = FarmableSponge.VERSION, name = FarmableSponge.NAME)
public class FarmableSponge {
	public static final String MODID = "farmablesponge";
	public static final String NAME = "Farmable Sponge";
	public static final String VERSION = "1.0.0";
	
	public static Logger logger;
	@Instance(value=MODID)
	public static FarmableSponge INSTANCE;
	
	@SidedProxy(serverSide = "com.veesus.farmablesponge.proxy.ServerProxy",clientSide = "com.veesus.farmablesponge.proxy.ClientProxy")
	public static SharedProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
