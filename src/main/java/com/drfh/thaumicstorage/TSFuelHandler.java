package com.drfh.thaumicstorage;

import com.drfh.thaumicstorage.common.items.EnergyItem;
import com.drfh.thaumicstorage.init.TSItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class TSFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		EnergyItem	fuelItem=(EnergyItem)fuel.getItem();
		int			burn_time=0;
		
		if(fuelItem.equals(TSItems.arcane_coal))
		{
		//	EntityPlayerSP	e=Minecraft.getMinecraft().thePlayer;
			
			Main.logger.info("getBurnTime:(getFuelLeft) "+fuelItem.getFuelLeft());
			burn_time=fuelItem.getBurnTime();
		}
		else if(fuelItem.equals(TSItems.arcane_coal_block))
		{
		//	EntityPlayerSP	e=Minecraft.getMinecraft().thePlayer;
			
			burn_time=fuelItem.getBurnTime();
		}
		Main.logger.info("getBurnTime: "+burn_time);
		return burn_time;
	}
}
