package com.drfh.thaumicstorage.common.items;

import java.util.List;

import com.drfh.thaumicstorage.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArcaneCoal extends EnergyItem 
{
	public ArcaneCoal()
	{
		super();
		this.setMaxDamage(1800);
		super.setFuelLevel(1800);
		this.setBurnTime(20);
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
}
