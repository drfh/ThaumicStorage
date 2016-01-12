package com.drfh.thaumicstorage.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SmeltingRecipes
{
	public static void init()
	{
	//	FurnaceRecipes.instance().addSmelting(TSItems.arcane_coal,new ItemStack(TSItems.arcane_coal), 0.0F);
	//	FurnaceRecipes.instance().addSmelting(TSItems.arcane_coal,new ItemStack(TSItems.arcane_coal), 0.0F);
		GameRegistry.addSmelting(new ItemStack(TSItems.arcane_coal,1,OreDictionary.WILDCARD_VALUE),new ItemStack(TSItems.arcane_coal,1,0), 10.0F);
	}
	/** TEMP \ TEMP */
	//FurnaceRecipes.smelting().addSmelting(TEMP.ID, 0, new ItemStack(TEMP), 0.0F);

}
