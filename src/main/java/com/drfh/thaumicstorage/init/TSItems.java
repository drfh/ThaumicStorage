package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.common.blocks.ArcaneCoalBlock;
import com.drfh.thaumicstorage.common.items.ArcaneCoal;
import com.drfh.thaumicstorage.common.items.ArcaneCoalS;
import com.drfh.thaumicstorage.common.items.ArcaneTorchDispenser;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TSItems
{
	
	public static Item		storage_foci;
	public static Item		arcane_coal;
	public static Item		arcane_coalS;
	public static Item		arcane_coal_block;
	public static Item		arcane_torch_dispenser;
	
	public static void init()
	{
		//	Fuel Items
		arcane_coal=new ArcaneCoal().setUnlocalizedName("arcane_coal").setCreativeTab(Main.tscreative);
		arcane_coalS=new ArcaneCoalS().setUnlocalizedName("arcane_coalS").setCreativeTab(Main.tscreative);
		arcane_coal_block=new ArcaneCoalBlock().setUnlocalizedName("arcane_coal_block").setCreativeTab(Main.tscreative);
		
		//	Utility Items
		arcane_torch_dispenser=new ArcaneTorchDispenser().setUnlocalizedName("arcane_torch_dispenser").setCreativeTab(Main.tscreative);
		
		//	Foci
		storage_foci=new Item().setUnlocalizedName("storage_foci");
	}
	
	public static void register()
	{
		//	Fuel Items
		GameRegistry.registerItem(arcane_coal, arcane_coal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(arcane_coalS, arcane_coalS.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(arcane_coal_block, arcane_coal_block.getUnlocalizedName().substring(5));
		
		//	Utlility Items
		GameRegistry.registerItem(arcane_torch_dispenser, arcane_torch_dispenser.getUnlocalizedName().substring(5));
		
		//	Foci
		GameRegistry.registerItem(storage_foci, storage_foci.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		//	Fuel Items
		registerRender(arcane_coal);
		registerRender(arcane_coalS);
		registerRender(arcane_coal_block);
		
		//	Utility Items
		registerRender(arcane_torch_dispenser);

		// Foci
		registerRender(storage_foci);

	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
	 
}
