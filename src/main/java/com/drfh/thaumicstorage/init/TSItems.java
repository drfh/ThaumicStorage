package com.drfh.thaumicstorage.init;

import com.drfh.thaumicstorage.Main;
import com.drfh.thaumicstorage.Reference;
import com.drfh.thaumicstorage.common.items.ArcaneCoal;
import com.drfh.thaumicstorage.common.items.ArcaneCoalS;
import com.drfh.thaumicstorage.common.items.ArcaneTorchDispenser;
import com.drfh.thaumicstorage.common.items.MagicPouch;
import com.drfh.thaumicstorage.common.items.FocusTorch;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TSItems
{
	public static Item		torch_foci;
	public static Item		storage_foci;
	public static Item		arcane_coal;
	public static Item		arcane_coalS;
	public static Item		arcane_coal_block;
	public static Item		arcane_torch_dispenser;
	public static Item		magic_pouch;
	
	
	public static void init()
	{
		//	Fuel Items
		arcane_coal=new ArcaneCoal().setUnlocalizedName("arcane_coal").setCreativeTab(Main.tscreative);
		arcane_coalS=new ArcaneCoalS().setUnlocalizedName("arcane_coalS").setCreativeTab(Main.tscreative);
		
		//	Utility Items
		arcane_torch_dispenser=new ArcaneTorchDispenser().setUnlocalizedName("arcane_torch_dispenser").setCreativeTab(Main.tscreative);
		magic_pouch=new MagicPouch().setUnlocalizedName("magic_pouch").setCreativeTab(Main.tscreative);
		
		//	Foci
//		storage_foci=new Item().setUnlocalizedName("focus_storage").setCreativeTab(Main.tscreative);
		torch_foci=new FocusTorch().setUnlocalizedName("focus_torch").setCreativeTab(Main.tscreative);
	}
	
	public static void register()
	{
		//	Fuel Items
		GameRegistry.registerItem(arcane_coal, arcane_coal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(arcane_coalS, arcane_coalS.getUnlocalizedName().substring(5));
		
		//	Utlility Items
		GameRegistry.registerItem(arcane_torch_dispenser, arcane_torch_dispenser.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(magic_pouch, magic_pouch.getUnlocalizedName().substring(5));
		
		//	Foci
//		GameRegistry.registerItem(storage_foci, storage_foci.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torch_foci, torch_foci.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		//	Fuel Items
		registerRender(arcane_coal);
		registerRender(arcane_coalS);
		
		//	Utility Items
		registerRender(arcane_torch_dispenser);
		registerRender(magic_pouch);

		// Foci
//		registerRender(storage_foci);
		registerRender(torch_foci);
	}
	
	public static void registerRender(Item item)
	{
		if(item!=null)
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
		else
			Main.logger.warn("Remove registerRender(NULL):");
	}
}
