package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.common.blocks.ArcaneCoalBlock;
import com.drfh.thaumicstorage.common.blocks.BlockTiny;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TSBlocks {

	public static Block		tiny_block;
	public static Block		arcane_coal_block;
	
	
	public static void init()
	{
		arcane_coal_block=new ArcaneCoalBlock(Material.wood).setUnlocalizedName("arcane_coal_block").setCreativeTab(Main.tscreative);
		tiny_block=new BlockTiny(Material.clay).setUnlocalizedName("tiny_block").setCreativeTab(Main.tscreative);
	}

	public static void register()
	{
		GameRegistry.registerBlock(arcane_coal_block,arcane_coal_block.getUnlocalizedName().substring(5));//Reference.MOD_ID+":"+"tiny_block");
		GameRegistry.registerBlock(tiny_block,tiny_block.getUnlocalizedName().substring(5));//Reference.MOD_ID+":"+"tiny_block");
	}

	public static void registerRenders()
	{
		registerRender(tiny_block);
	}

	public static void registerRender(Block block)
	{
		Item item=Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
}
