package com.drfh.thaumicstorage.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
//	@SuppressWarnings("unused")
	public static void setup()
	{
//		OreDictionary.registerOre("obsidian", Blocks.obsidian);
		
		
//		GameRegistry.addSmelting(new ItemStack(Items.,1,0), new ItemStack(Items.coal,1,1), 0.15F);

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch,1,0),new Object[]{
				"12",
				'1',new ItemStack(TSItems.arcane_coal,1,0),
				'2',new ItemStack(Items.stick,1,0)
				});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch,2,0),new Object[]{
				"12",
				'1',new ItemStack(TSItems.arcane_coal,1,0),
				'2',new ItemStack(Items.stick,1,0)
				});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch,8,0),new Object[]{
				"12",
				'1',new ItemStack(TSItems.arcane_coal,1,0),
				'2',new ItemStack(Items.stick,1,0)
				});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch,1,0),new Object[]{
				"1",
				'1',new ItemStack(TSItems.arcane_torch_dispenser,1,0)
				});
/*		GameRegistry.addShapedRecipe(new ItemStack(TSItems.arcane_coal),new Object[]{
				"1",
				"",
				"",
				'1',new ItemStack(Blocks.log2,1,OreDictionary.WILDCARD_VALUE)
			});


		GameRegistry.addShapedRecipe(new ItemStack(TSItems.arcane_coal),new Object[]{
				"111",
				"111",
				"111",
				'1',new ItemStack(ItemsTC.wandRods,1,OreDictionary.WILDCARD_VALUE)
			});
*/	}
}
