package com.veesus.farmablesponge.proxy;

import org.lwjgl.input.Keyboard;

import com.veesus.farmablesponge.FarmableSponge;
import com.veesus.farmablesponge.block.Blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
@EventBusSubscriber(modid=FarmableSponge.MODID)
public class ClientProxy extends SharedProxy {
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
	@SubscribeEvent
	public static void onModels(ModelRegistryEvent event) {
		for(ItemBlock b : Blocks.ITEMBLOCKS) {
			ModelLoader.setCustomModelResourceLocation(b,0, new ModelResourceLocation(b.getRegistryName(),"inventory"));
		}
		
	}
	@SubscribeEvent
	public static void onKeyEvent(TickEvent.ClientTickEvent event) {
		if(Keyboard.isKeyDown(Keyboard.KEY_G)) {

			PlayerControllerMP control = Minecraft.getMinecraft().playerController;
			RayTraceResult result = Minecraft.getMinecraft().objectMouseOver;
			if(result.entityHit==null) return;
			FarmableSponge.logger.info("Test");
			Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().player,result.entityHit);
		}
	}
}
