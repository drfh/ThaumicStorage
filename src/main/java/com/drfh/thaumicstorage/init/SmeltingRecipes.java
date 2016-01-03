package com.drfh.thaumicstorage.init;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes
{
	public static void init()
	{
		/** VANILLA STYLE RECIPES */
	//	FurnaceRecipes.instance().addSmelting(TSItems.arcane_coal,new ItemStack(TSItems.arcane_coal), 0.0F);
	//	FurnaceRecipes.instance().addSmelting(TSItems.arcane_coal,new ItemStack(TSItems.arcane_coal), 0.0F);
		GameRegistry.addSmelting(TSItems.arcane_coal, new ItemStack(TSItems.arcane_coal), 0.0F);
	}
	/** TEMP \ TEMP */
	//FurnaceRecipes.smelting().addSmelting(TEMP.ID, 0, new ItemStack(TEMP), 0.0F);

}
