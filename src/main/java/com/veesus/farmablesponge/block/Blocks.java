package com.veesus.farmablesponge.block;

import com.veesus.farmablesponge.FarmableSponge;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class Blocks {
	
	public static ItemBlock[] ITEMBLOCKS;
	public static final BlockSpongeSeed SPONGE_SEED = new BlockSpongeSeed();
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		registerBlock(registry,SPONGE_SEED,"spongeseed");
		
	}
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		ITEMBLOCKS = new ItemBlock[] {
				new ItemBlock(SPONGE_SEED)
		};
		
		for(ItemBlock b : ITEMBLOCKS) {
			b.setRegistryName(b.getBlock().getRegistryName());
			registry.register(b);
		}
	}
	static void registerBlock(IForgeRegistry<Block> registry,Block block, String name) {
		block.setRegistryName(new ResourceLocation(FarmableSponge.MODID,name)).setUnlocalizedName(name);
		registry.register(block);
	}
	
}
