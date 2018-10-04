package com.veesus.farmablesponge.proxy;

import com.veesus.farmablesponge.FarmableSponge;
import com.veesus.farmablesponge.block.Blocks;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
@EventBusSubscriber(modid = FarmableSponge.MODID)
public abstract class SharedProxy {
	public void preInit(FMLPreInitializationEvent event) {

		
	} 
	
	public void init(FMLInitializationEvent event) {
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public static void doBlocks(RegistryEvent.Register<Block> event) {
		Blocks.registerBlocks(event.getRegistry());
	}
	
	@SubscribeEvent
	public static void doItems(RegistryEvent.Register<Item> event) {
		Blocks.registerItemBlocks(event.getRegistry());
	}
	@SubscribeEvent
	public static void doRecipes(RegistryEvent.Register<IRecipe> event) {
		
		GameRegistry.addShapedRecipe(new ResourceLocation(FarmableSponge.MODID,"spongeseedrecipe"),null, new ItemStack(Blocks.SPONGE_SEED,1), 
				"BBB",
				"BSB",
				"BBB",
				
				'B',new ItemStack(Items.DYE,1,EnumDyeColor.WHITE.getDyeDamage()),
				'S', new ItemStack(net.minecraft.init.Blocks.SPONGE,1,1));
	}
}
