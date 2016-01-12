package com.drfh.thaumicstorage.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategoryList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;


public class Thaumonomicon
{
	public static final String	catName="ThaumicStorage";
	public static final ResourceLocation icon = new ResourceLocation("thaumicstorage","textures/thaumonomicon/ThaumicStorge.png");
	public static final ResourceLocation back = new ResourceLocation("thaumicstorage","textures/thaumonomicon/tileable-classic-nebula-3120259-h.jpg");
	public static final ResourceLocation back2 = new ResourceLocation("thaumcraft","textures/gui/gui_research_back_over.png");

	@SuppressWarnings("unchecked")
	public static void setup()
	{
		//	Create Thaumonomicon Page
		ResearchCategories.registerCategory(catName,null, icon, back,null);
		
	//	ResearchCategoryList	THAUMATURGY=ResearchCategories.getResearchList("THAUMATURGY");
		ResearchCategoryList	ALCHEMY=ResearchCategories.getResearchList("ALCHEMY");
	//	ResearchCategoryList	ARTIFICE=ResearchCategories.getResearchList("ARTIFICE");
		ResearchItem			crucRes=ALCHEMY.research.get("CRUCIBLE");
		
		copy(crucRes,"TC.CRUCIBLE",catName,0,0).setHidden().registerResearchItem();
//		copy(crucRes,"TC.CRUCIBLE",catName,0,0).setHidden().registerResearchItem();
		copy(ResearchCategories.getResearchList("ALCHEMY").research.get("METALLURGY"),"TS.ALCHEMY",catName,-3,-5).setHidden().registerResearchItem();
//		copy(ResearchCategories.getResearchList("ALCHEMY").research.get("METALLURGY"),"TS.ALCHEMY",catName,-3,-5).setHidden().registerResearchItem();
		
		//	Register items and aspects <???>
		ThaumcraftApi.registerObjectTag(new ItemStack(TSItems.arcane_coal,1,OreDictionary.WILDCARD_VALUE), new AspectList().add(Aspect.FIRE, 16).add(Aspect.ORDER, 8).add(Aspect.LIGHT, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(TSItems.arcane_coal_block,1,OreDictionary.WILDCARD_VALUE), new AspectList().add(Aspect.FIRE, 16).add(Aspect.ORDER, 8).add(Aspect.LIGHT, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(TSItems.arcane_torch_dispenser,1,OreDictionary.WILDCARD_VALUE), new AspectList().add(Aspect.FIRE, 16).add(Aspect.ORDER, 8).add(Aspect.LIGHT, 20));
//		ThaumcraftApi.registerObjectTag(new ItemStack(TSItems.arcane_torch_dispenser,1,OreDictionary.WILDCARD_VALUE), new AspectList().add(Aspect.FIRE, 16).add(Aspect.ORDER, 8).add(Aspect.LIGHT, 6));
		
		//	Crucible Recipe
		//	Clean Clay - Costs Permutatio(EXCHANGE)String
		
		ItemStack		clay3Rec_cat[]={new ItemStack(Blocks.clay,1,0),new ItemStack(Blocks.hardened_clay,1,0),new ItemStack(Blocks.stained_hardened_clay,1,0)};
		CrucibleRecipe clay3Rec = new CrucibleRecipe(new String[] {"TS.r.Entropy_clay"},new ItemStack(Items.clay_ball,3,0),clay3Rec_cat,new AspectList().add(Aspect.ENTROPY,1));

		ItemStack		arcaneCoalS_cat[]={new ItemStack(TSItems.arcane_coal,1,0)};
		CrucibleRecipe arcaneCoalS_Rec = new CrucibleRecipe(new String[] {"TS.ALCHEMY"},new ItemStack(TSItems.arcane_coalS,1,0),arcaneCoalS_cat,new AspectList().add(Aspect.FIRE,32).add(Aspect.ENERGY,32).add(Aspect.EXCHANGE,20).add(Aspect.LIGHT,16));
		
		//	Define Recipes
		ThaumcraftApi.getCraftingRecipes().add(clay3Rec);
		ThaumcraftApi.getCraftingRecipes().add(arcaneCoalS_Rec);
		
		// ThaumicStorage.archane_coal
		ShapedArcaneRecipe arcane_coal_rec=ThaumcraftApi.addArcaneCraftingRecipe("",new ItemStack(TSItems.arcane_coal),new AspectList().add(Aspect.FIRE, 40).add(Aspect.ORDER, 20).add(Aspect.ENTROPY, 20).add(Aspect.EARTH, 10),new Object[]{
				"121",
				"343",
				"151",
				'1',new ItemStack(BlocksTC.plank,1,0),
				'2',new ItemStack(ItemsTC.shard,1,1),
				'3',new ItemStack(ItemsTC.nuggets,1,6),
				'4',new ItemStack(Blocks.coal_block),
				'5',new ItemStack(ItemsTC.alumentum,1,0)
			});
		
		// ThaumicStorage.archane_coal_block
		ShapedArcaneRecipe arcane_coal_block_rec=ThaumcraftApi.addArcaneCraftingRecipe("",new ItemStack(TSItems.arcane_coal_block),new AspectList().add(Aspect.FIRE, 20).add(Aspect.ORDER, 20).add(Aspect.ENTROPY, 20),new Object[]{
				"111",
				"111",
				"111",
				'1',TSItems.arcane_coal
			});
		
		// ThaumicStorage.arcane_torch_dispenser
		ShapedArcaneRecipe arcane_torch_dispenser_rec=ThaumcraftApi.addArcaneCraftingRecipe("",new ItemStack(TSItems.arcane_torch_dispenser),new AspectList().add(Aspect.FIRE, 40).add(Aspect.ORDER, 20).add(Aspect.ENTROPY, 20).add(Aspect.EARTH, 10),new Object[]{
				"121",
				"131",
				"141",
				'1',new ItemStack(ItemsTC.plate,1,0),
				'2',new ItemStack(Items.flint_and_steel,1,0),
				'3',new ItemStack(TSItems.arcane_coalS,1,0),
				'4',new ItemStack(ItemsTC.wandRods,1,OreDictionary.WILDCARD_VALUE)
			});
		
		// Register Research Page
		// Arcane Coal
		new ResearchItem("TS.r.arcane_coal",catName,new AspectList().add(Aspect.ORDER,3).add(Aspect.FIRE,3).add(Aspect.LIGHT,3),3,0,1,new ItemStack(TSItems.arcane_coal,1,0))
		.setParents("TC.CRUCIBLE")
		.setPages(
				new ResearchPage("TS.p0.arcane_coal"),
				new ResearchPage("TS.p1.arcane_coal"),
				new ResearchPage(arcane_coal_rec),
				new ResearchPage("TS.p2.arcane_coal"),
				new ResearchPage("TS.p3.arcane_coal")
			).registerResearchItem();
		
		// Register Research Page
		// Arcane Coal super-charged
		new ResearchItem("TS.r.arcane_coalS",catName,new AspectList().add(Aspect.ORDER,3).add(Aspect.FIRE,3).add(Aspect.LIGHT,3),4,-1,1,
					new ItemStack(TSItems.arcane_coal,1,1))
		.setParents("TS.r.arcane_coal")
		.setSecondary()
		.setPages(
				new ResearchPage("TS.p0.arcane_coalS"),
				new ResearchPage(arcaneCoalS_Rec)
			).registerResearchItem();
		
		// Register Research Page
		// Arcane Coal Block
		new ResearchItem("TS.r.arcane_coal_block",catName,new AspectList().add(Aspect.ORDER,3),4,1,1,new ItemStack(TSItems.arcane_coal_block,1,0))
		.setParents("TS.r.arcane_coal")
		.setPages(
				new ResearchPage("TS.p0.arcane_coal_block"),
				new ResearchPage(arcane_coal_block_rec)
			).registerResearchItem();

		// Register Research Page
		// Arcane Torch Dispenser
		new ResearchItem("TS.r.arcane_torch_dispenser",catName,new AspectList().add(Aspect.ORDER,3).add(Aspect.FIRE,3).add(Aspect.LIGHT,3),5,-2,1,new ItemStack(TSItems.arcane_torch_dispenser,1,0))
		.setParents("TS.r.arcane_coalS")
		.setPages(
				new ResearchPage("TS.p0.arcane_torch_dispenser"),
				new ResearchPage(arcane_torch_dispenser_rec)
			).registerResearchItem();

		new ResearchItem("TS.r.Entropy_clay",catName,new AspectList().add(Aspect.ENTROPY, 2),-1,-4,3,new ItemStack(Items.clay_ball,1,0))
		.setParents("TS.ALCHEMY")
		.setPages(
			new ResearchPage("TS.p0.Entropy_clay"),
			new ResearchPage(clay3Rec)
		//	new ResearchPage(clay3Rec2),
		//	new ResearchPage(clay3Rec3)
			).registerResearchItem();
		
	}
	
	public static ResearchItem copy(ResearchItem res, String newKey, String newCat, int dC, int dR)
	{
		ResearchItem rItem;
		
		if(res.icon_resource != null)
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),Object[].class.cast(res.icon_resource));
		else
			rItem = new ResearchItem(newKey,newCat,res.tags,dC,dR,res.getComplexity(),Object[].class.cast(res.icon_item));
		
		rItem.parents = res.parents;
		rItem.parentsHidden = res.parentsHidden;
		rItem.siblings = res.siblings;
		rItem.setPages(res.getPages());
		
		rItem.setHidden();
		
		if(res.isAutoUnlock())
			rItem.setAutoUnlock();
		
		if(res.isFlipped())
			rItem.setFlipped();
		
		if(res.isHidden())
			rItem.setHidden();
		
		if(res.isRound())
			rItem.setRound();
		
		if(res.isSecondary())
			rItem.setSecondary();
		
		if(res.isSpecial())
			rItem.setSpecial();
		
		if(res.isStub())
			rItem.setStub();
		
		if(res.siblings != null && res.siblings.length > 0)
		{
			String[] sibStr = new String[res.siblings.length+1];
			for(int i = 0; i < res.siblings.length; ++i)
				sibStr[i] = res.siblings[i];
			
			sibStr[sibStr.length - 1] = newKey;
			
			res.setSiblings(sibStr);
		}else
		{
			res.setSiblings(newKey);
		}
		
		if(rItem.siblings != null && rItem.siblings.length > 0)
		{
			String[] sibStr = new String[rItem.siblings.length+1];
			for(int i = 0; i < rItem.siblings.length; ++i)
				sibStr[i] = rItem.siblings[i];
			
			sibStr[sibStr.length - 1] = res.key;
			
			rItem.setSiblings(sibStr);
		}else
		{
			rItem.setSiblings(res.key);
		}
		
		return rItem;
	}	
}

/*
				"121",
				"343",
				"151",
'1',"thaumcraft:plank",
'2',"thaumcraft:shard 1 6",
'3',"thaumcraft:nugget 1 6",
'4',Blocks.coal_block,
'5',"thaumcraft:alumentum"

				'1',new ItemStack(BlocksTC.plank,1,0),
				'2',new ItemStack(ItemsTC.shard,1,1),
				'3',new ItemStack(ItemsTC.nuggets,1,6),
				'4',new ItemStack(Blocks.coal_block,1,0),
				'5',new ItemStack(ItemsTC.alumentum,1,0)


				'1',new ItemStack(ItemsTC.plate,1,0),
				'2',new ItemStack(Items.flint_and_steel,1,0),
				'3',new ItemStack(TSItems.arcane_coal_block,1,6),
				'4',new ItemStack(ItemsTC.wandRods,1,OreDictionary.WILDCARD_VALUE)


*/