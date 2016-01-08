package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArcaneCoal extends EnergyItem 
{
	public ArcaneCoal()
	{
		super();
		this.setMaxDamage(2400);
		super.setFuelLevel(2400);
		this.setBurnTime(20);
	}

	@Override
	public boolean canRecharge()
	{
		return true;
	}
	
	@Override
	public boolean hasContainerItem()
	{
		return true;
	}

	@Override
	public Item setContainerItem(Item containerItem)
	{
		super.setContainerItem(containerItem);
		Main.logger.info("setContainerItem: "+containerItem);
		return this;
	}
	
	@Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
		Main.logger.info("onCreated: "+stack+"  "+stack.getItemDamage());
		super.onCreated(stack, worldIn, playerIn);
    }
}
