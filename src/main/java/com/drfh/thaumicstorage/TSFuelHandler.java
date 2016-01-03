package com.drfh.thaumicstorage;

import com.drfh.thaumicstorage.common.items.EnergyItem;
import com.drfh.thaumicstorage.init.TSItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class TSFuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		EnergyItem	fuelItem=(EnergyItem)fuel.getItem();
		int			burn_time=0;
		
		if(fuelItem instanceof EnergyItem)
			burn_time=fuelItem.getBurnTime();
		return burn_time;
	}
}

