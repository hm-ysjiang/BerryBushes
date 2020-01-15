package hmysjiang.berrybushes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.common.collect.Maps;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

	@SubscribeEvent
	public static void onDataGather(GatherDataEvent event) {
		DataGenerator dataGen = event.getGenerator();
		dataGen.addProvider(new RecipeGen(dataGen));
	}
	
	public static class RecipeGen extends RecipeProvider {

		public RecipeGen(DataGenerator generatorIn) {
			super(generatorIn);
		}
		
		@Override
		protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
			ShapelessRecipeBuilder.shapelessRecipe(ModRegistry.Items.BERRY_SALAD)
			  					  .addIngredient(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry")))
			  					  .addIngredient(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry")))
			  					  .addIngredient(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "vege")))
			  					  .addIngredient(Items.BAKED_POTATO)
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
			  					  .build(consumer, "berrybushes:berry_salad");
			
			registerVanillaOverrides(consumer);
		}

		private void registerVanillaOverrides(Consumer<IFinishedRecipe> consumer) {
			ShapelessRecipeBuilder.shapelessRecipe(Items.CYAN_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLUE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.GREEN)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:cyan_dye");

			ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_BLUE_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLUE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:light_blue_dye_from_blue_white");

			ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.PURPLE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.PINK)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:magenta_dye_from_purple_pink");

			ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 4)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLUE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:magenta_dye_from_blue_red_white");

			ShapelessRecipeBuilder.shapelessRecipe(Items.MAGENTA_DYE, 3)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLUE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.PINK)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:magenta_dye_from_blue_red_pink");

			ShapelessRecipeBuilder.shapelessRecipe(Items.PURPLE_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLUE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:purple_dye");

			ShapelessRecipeBuilder.shapelessRecipe(Items.GRAY_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLACK)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:gray_dye");

			ShapelessRecipeBuilder.shapelessRecipe(Items.PINK_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:pink_dye");
			
			ShapelessRecipeBuilder.shapelessRecipe(Items.ORANGE_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.RED)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.YELLOW)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:orange_dye");

			ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 3)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.BLACK)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:light_gray_dye_from_black_white");
			
			ShapelessRecipeBuilder.shapelessRecipe(Items.LIGHT_GRAY_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.GRAY)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:light_gray_dye_from_gray_white");
			
			ShapelessRecipeBuilder.shapelessRecipe(Items.LIME_DYE, 2)
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.GREEN)))
								  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(DyeColor.WHITE)))
			  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								  .build(consumer, "berrybushes:lime_dye");
			
			for (DyeColor color: DyeColor.values()) {
				int index = color.getId();
				ShapelessRecipeBuilder.shapelessRecipe(dyes.get(index))
									  .addIngredient(ModRegistry.Items.berries.get(index))
									  .setGroup("berry_dyes")
				  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
									  .build(consumer, "berrybushes:" + color.getTranslationKey() + "_dye_from_berry");
				
				if (color != DyeColor.WHITE) {
					ShapelessRecipeBuilder.shapelessRecipe(beds.get(index))
										  .addIngredient(Items.WHITE_BED)
										  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(color)))
										  .setGroup("dyed_bed")
										  .addCriterion("has_bed", this.hasItem(Items.WHITE_BED))
					  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
										  .build(consumer, "berrybushes:" + color.getTranslationKey() + "_bed_from_white_bed");
					
					ShapedRecipeBuilder.shapedRecipe(carpets.get(index), 8)
									   .key('#', Blocks.WHITE_CARPET)
									   .key('$', ItemTags.getCollection().getOrCreate(tagNames.get(color)))
									   .patternLine("###")
									   .patternLine("#$#")
									   .patternLine("###")
									   .setGroup("carpet")
									   .addCriterion("has_white_carpet", this.hasItem(Blocks.WHITE_CARPET))
									   .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
									   .build(consumer, "berrybushes:" + color.getTranslationKey() + "_carpet_from_white_carpet");

					ShapelessRecipeBuilder.shapelessRecipe(wools.get(index))
										  .addIngredient(Blocks.WHITE_WOOL)
										  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(color)))
										  .setGroup("wool")
										  .addCriterion("has_white_wool", this.hasItem(Blocks.WHITE_WOOL))
					  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
										  .build(consumer, "berrybushes:" + color.getTranslationKey() + "_wool");
				}
				
				ShapelessRecipeBuilder.shapelessRecipe(concretePowders.get(index), 8)
									  .addIngredient(ItemTags.getCollection().getOrCreate(tagNames.get(color)))
									  .addIngredient(Blocks.SAND, 4)
									  .addIngredient(Blocks.GRAVEL, 4)
									  .setGroup("concrete_powder")
									  .addCriterion("has_sand", this.hasItem(Blocks.SAND))
									  .addCriterion("has_gravel", this.hasItem(Blocks.GRAVEL))
				  					  .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
									  .build(consumer, "berrybushes:" + color.getTranslationKey() + "_concrete_powder");
				
				ShapedRecipeBuilder.shapedRecipe(glasses.get(index), 8)
								   .key('#', Blocks.GLASS)
								   .key('X', ItemTags.getCollection().getOrCreate(tagNames.get(color)))
								   .patternLine("###")
								   .patternLine("#X#")
								   .patternLine("###")
								   .setGroup("stained_glass")
								   .addCriterion("has_glass", this.hasItem(Blocks.GLASS))
								   .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								   .build(consumer, "berrybushes:" + color.getTranslationKey() + "_stained_glass");
				
				ShapedRecipeBuilder.shapedRecipe(glassPanes.get(index), 8)
								   .key('#', Blocks.GLASS_PANE)
								   .key('$', ItemTags.getCollection().getOrCreate(tagNames.get(color)))
								   .patternLine("###")
								   .patternLine("#$#")
								   .patternLine("###")
								   .setGroup("stained_glass_pane")
								   .addCriterion("has_glass_pane", this.hasItem(Blocks.GLASS_PANE))
								   .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								   .build(consumer, "berrybushes:" + color.getTranslationKey() + "_stained_glass_pane_from_glass_pane");
				
				ShapedRecipeBuilder.shapedRecipe(terracotta.get(index), 8)
								   .key('#', Blocks.TERRACOTTA)
								   .key('X', ItemTags.getCollection().getOrCreate(tagNames.get(color)))
								   .patternLine("###")
								   .patternLine("#X#")
								   .patternLine("###")
								   .setGroup("stained_terracotta")
								   .addCriterion("has_terracotta", this.hasItem(Blocks.TERRACOTTA))
								   .addCriterion("has_berry", this.hasItem(ItemTags.getCollection().getOrCreate(new ResourceLocation(Reference.MOD_ID, "berry"))))
								   .build(consumer, "berrybushes:" + color.getTranslationKey() + "_terracotta");
			}
		}
		
	}

	public static List<Item> dyes = Arrays.asList(Items.WHITE_DYE, Items.ORANGE_DYE, Items.MAGENTA_DYE,
			Items.LIGHT_BLUE_DYE, Items.YELLOW_DYE, Items.LIME_DYE, Items.PINK_DYE, Items.GRAY_DYE,
			Items.LIGHT_GRAY_DYE, Items.CYAN_DYE, Items.PURPLE_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.GREEN_DYE,
			Items.RED_DYE, Items.BLACK_DYE);
	public static List<Item> beds = Arrays.asList(Items.WHITE_BED, Items.ORANGE_BED, Items.MAGENTA_BED,
			Items.LIGHT_BLUE_BED, Items.YELLOW_BED, Items.LIME_BED, Items.PINK_BED, Items.GRAY_BED,
			Items.LIGHT_GRAY_BED, Items.CYAN_BED, Items.PURPLE_BED, Items.BLUE_BED, Items.BROWN_BED, Items.GREEN_BED,
			Items.RED_BED, Items.BLACK_BED);
	public static List<Item> carpets = Arrays.asList(Items.WHITE_CARPET, Items.ORANGE_CARPET, Items.MAGENTA_CARPET,
			Items.LIGHT_BLUE_CARPET, Items.YELLOW_CARPET, Items.LIME_CARPET, Items.PINK_CARPET, Items.GRAY_CARPET,
			Items.LIGHT_GRAY_CARPET, Items.CYAN_CARPET, Items.PURPLE_CARPET, Items.BLUE_CARPET, Items.BROWN_CARPET,
			Items.GREEN_CARPET, Items.RED_CARPET, Items.BLACK_CARPET);
	public static List<Item> concretePowders = Arrays.asList(Items.WHITE_CONCRETE_POWDER, Items.ORANGE_CONCRETE_POWDER,
			Items.MAGENTA_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE_POWDER, Items.YELLOW_CONCRETE_POWDER,
			Items.LIME_CONCRETE_POWDER, Items.PINK_CONCRETE_POWDER, Items.GRAY_CONCRETE_POWDER,
			Items.LIGHT_GRAY_CONCRETE_POWDER, Items.CYAN_CONCRETE_POWDER, Items.PURPLE_CONCRETE_POWDER,
			Items.BLUE_CONCRETE_POWDER, Items.BROWN_CONCRETE_POWDER, Items.GREEN_CONCRETE_POWDER,
			Items.RED_CONCRETE_POWDER, Items.BLACK_CONCRETE_POWDER);
	public static List<Item> glassPanes = Arrays.asList(Items.WHITE_STAINED_GLASS_PANE, Items.ORANGE_STAINED_GLASS_PANE,
			Items.MAGENTA_STAINED_GLASS_PANE, Items.LIGHT_BLUE_STAINED_GLASS_PANE, Items.YELLOW_STAINED_GLASS_PANE,
			Items.LIME_STAINED_GLASS_PANE, Items.PINK_STAINED_GLASS_PANE, Items.GRAY_STAINED_GLASS_PANE,
			Items.LIGHT_GRAY_STAINED_GLASS_PANE, Items.CYAN_STAINED_GLASS_PANE, Items.PURPLE_STAINED_GLASS_PANE,
			Items.BLUE_STAINED_GLASS_PANE, Items.BROWN_STAINED_GLASS_PANE, Items.GREEN_STAINED_GLASS_PANE,
			Items.RED_STAINED_GLASS_PANE, Items.BLACK_STAINED_GLASS_PANE);
	public static List<Item> glasses = Arrays.asList(Items.WHITE_STAINED_GLASS, Items.ORANGE_STAINED_GLASS,
			Items.MAGENTA_STAINED_GLASS, Items.LIGHT_BLUE_STAINED_GLASS, Items.YELLOW_STAINED_GLASS,
			Items.LIME_STAINED_GLASS, Items.PINK_STAINED_GLASS, Items.GRAY_STAINED_GLASS,
			Items.LIGHT_GRAY_STAINED_GLASS, Items.CYAN_STAINED_GLASS, Items.PURPLE_STAINED_GLASS,
			Items.BLUE_STAINED_GLASS, Items.BROWN_STAINED_GLASS, Items.GREEN_STAINED_GLASS, Items.RED_STAINED_GLASS,
			Items.BLACK_STAINED_GLASS);
	public static List<Item> terracotta = Arrays.asList(Items.WHITE_TERRACOTTA, Items.ORANGE_TERRACOTTA,
			Items.MAGENTA_TERRACOTTA, Items.LIGHT_BLUE_TERRACOTTA, Items.YELLOW_TERRACOTTA, Items.LIME_TERRACOTTA,
			Items.PINK_TERRACOTTA, Items.GRAY_TERRACOTTA, Items.LIGHT_GRAY_TERRACOTTA, Items.CYAN_TERRACOTTA,
			Items.PURPLE_TERRACOTTA, Items.BLUE_TERRACOTTA, Items.BROWN_TERRACOTTA, Items.GREEN_TERRACOTTA,
			Items.RED_TERRACOTTA, Items.BLACK_TERRACOTTA);
	public static List<Item> wools = Arrays.asList(Items.WHITE_WOOL, Items.ORANGE_WOOL, Items.MAGENTA_WOOL,
			Items.LIGHT_BLUE_WOOL, Items.YELLOW_WOOL, Items.LIME_WOOL, Items.PINK_WOOL, Items.GRAY_WOOL,
			Items.LIGHT_GRAY_WOOL, Items.CYAN_WOOL, Items.PURPLE_WOOL, Items.BLUE_WOOL, Items.BROWN_WOOL,
			Items.GREEN_WOOL, Items.RED_WOOL, Items.BLACK_WOOL);
	
	public static Map<DyeColor, ResourceLocation> tagNames;
	static {
		tagNames = Maps.newHashMap();
		for (DyeColor color: DyeColor.values()) {
			tagNames.put(color, new ResourceLocation("forge", "dyes/" + color.getTranslationKey()));
		}
	}
	
}
