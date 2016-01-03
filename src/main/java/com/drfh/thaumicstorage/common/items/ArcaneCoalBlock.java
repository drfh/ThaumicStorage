package com.drfh.thaumicstorage.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArcaneCoalBlock extends EnergyItem 
{
	public ArcaneCoalBlock()
	{
		super();
		this.setMaxDamage(1800*10);
		super.setFuelLevel(1800*10);
		this.setBurnTime(200);
	}

	@Override
	public boolean hasContainerItem()
	{
		return true;
	}
}
