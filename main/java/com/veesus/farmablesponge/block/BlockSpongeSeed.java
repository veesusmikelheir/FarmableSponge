package com.veesus.farmablesponge.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSponge;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpongeSeed extends Block{
	public BlockSpongeSeed() {
		super(Material.SPONGE);
		setSoundType(SoundType.PLANT);
		this.setHardness(.6f);
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	@Override
    public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random)
    {

        BlockPos newpos = pos.offset(EnumFacing.random(worldIn.rand));
        
        if(worldIn.getBlockState(newpos).getMaterial()!=Material.WATER) return;
        float growthCoefficient = getGrowthCoefficient(pos,worldIn);
        float deathChance = getSeedsAround(pos,worldIn)*.5f;
        if((worldIn.rand.nextDouble())<deathChance) {
        	worldIn.setBlockState(pos, Blocks.SPONGE.getDefaultState().withProperty(BlockSponge.WET, true));
        	return;
        }
        if((worldIn.rand.nextDouble()*growthCoefficient)>.5) worldIn.setBlockState(newpos, com.veesus.farmablesponge.block.Blocks.SPONGE_SEED.getDefaultState());//.withProperty(BlockSponge.WET, true));

        
    }
	@Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
		return true;
    }
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
		drops.add((new Random()).nextBoolean()?new ItemStack(com.veesus.farmablesponge.block.Blocks.SPONGE_SEED,1):new ItemStack(Blocks.SPONGE,1,1));
    }
	// Can't get this to work for now so just making it return 1 in all cases
	float getGrowthCoefficient(BlockPos pos, World worldIn) {
		if(worldIn.canBlockSeeSky(pos.offset(EnumFacing.UP))) return 1;
		if(worldIn.getLight(pos)>=7) return 1;
		return 1f;
	}
	int getSeedsAround(BlockPos pos, World worldIn) {
		int count = 0;
		for(EnumFacing f : EnumFacing.VALUES) {
			if(worldIn.getBlockState(pos.offset(f)).getBlock()==com.veesus.farmablesponge.block.Blocks.SPONGE_SEED) count++;
		}
		return count;
	}
}
