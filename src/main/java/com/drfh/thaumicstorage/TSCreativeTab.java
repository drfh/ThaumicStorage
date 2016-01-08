package com.drfh.thaumicstorage;

import com.drfh.thaumicstorage.init.TSItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TSCreativeTab extends CreativeTabs {
	public TSCreativeTab(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return TSItems.arcane_coal;
	}
}
