package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.init.TorchHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aura.AuraHelper;

public class ArcaneTorchDispenser extends Item
{
	public ArcaneTorchDispenser()
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(64);
	}

	private int getTorchSlotIndex(ItemStack[] stacks)
	{
		for(int index=0;index<stacks.length;index++)
		{
			if(stacks[index]!=null && stacks[index].getItem() == net.minecraft.item.Item.getItemFromBlock(Blocks.torch))
				return index;
		}
		return -1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return stack.isItemEnchanted();
	}

	@Override
	public boolean hasContainerItem()
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer play, List l, boolean par4)
	{
		super.addInformation(item,play,l,par4);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		return TorchHandler.onItemUse(null,player,world,pos,side,hitX,hitY,hitZ);
	}

}

