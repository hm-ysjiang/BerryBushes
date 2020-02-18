package hmysjiang.berrybushes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class ModRegistry {
	
	public static final Map<Block, Item> bush_berry_mapping = new HashMap<>();
	
	@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class Items {

		private static final Food BERRY = (new Food.Builder()).setAlwaysEdible().fastToEat().hunger(1).saturation(0.3F).build();
		
		public static final Item BERRY_WHITE		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_white"));
		public static final Item BERRY_ORANGE		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_orange"));
		public static final Item BERRY_MAGENTA		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_magenta"));
		public static final Item BERRY_LIGHT_BLUE	= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_lightblue"));
		public static final Item BERRY_YELLOW		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_yellow"));
		public static final Item BERRY_LIME			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_lime"));
		public static final Item BERRY_PINK			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_pink"));
		public static final Item BERRY_GRAY			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_gray"));
		public static final Item BERRY_LIGHT_GRAY	= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_lightgray"));
		public static final Item BERRY_CYAN			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_cyan"));
		public static final Item BERRY_PURPLE		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_purple"));
		public static final Item BERRY_BLUE			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_blue"));
		public static final Item BERRY_BROWN		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_brown"));
		public static final Item BERRY_GREEN		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_green"));
		public static final Item BERRY_RED			= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_red"));
		public static final Item BERRY_BLACK		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(BERRY)).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.BERRY + "_black"));
		
		public static List<Item> berries;
		
		public static final Item BUSH_WHITE			= new BlockItem(Blocks.BUSH_WHITE, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_white"));
		public static final Item BUSH_ORANGE		= new BlockItem(Blocks.BUSH_ORANGE, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_orange"));
		public static final Item BUSH_MAGENTA		= new BlockItem(Blocks.BUSH_MAGENTA, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_magenta"));
		public static final Item BUSH_LIGHT_BLUE	= new BlockItem(Blocks.BUSH_LIGHT_BLUE, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lightblue"));
		public static final Item BUSH_YELLOW		= new BlockItem(Blocks.BUSH_YELLOW, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_yellow"));
		public static final Item BUSH_LIME			= new BlockItem(Blocks.BUSH_LIME, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lime"));
		public static final Item BUSH_PINK			= new BlockItem(Blocks.BUSH_PINK, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_pink"));
		public static final Item BUSH_GRAY			= new BlockItem(Blocks.BUSH_GRAY, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_gray"));
		public static final Item BUSH_LIGHT_GRAY	= new BlockItem(Blocks.BUSH_LIGHT_GRAY, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lightgray"));
		public static final Item BUSH_CYAN			= new BlockItem(Blocks.BUSH_CYAN, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_cyan"));
		public static final Item BUSH_PURPLE		= new BlockItem(Blocks.BUSH_PURPLE, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_purple"));
		public static final Item BUSH_BLUE			= new BlockItem(Blocks.BUSH_BLUE, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_blue"));
		public static final Item BUSH_BROWN			= new BlockItem(Blocks.BUSH_BROWN, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_brown"));
		public static final Item BUSH_GREEN			= new BlockItem(Blocks.BUSH_GREEN, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_green"));
		public static final Item BUSH_RED			= new BlockItem(Blocks.BUSH_RED, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_red"));
		public static final Item BUSH_BLACK			= new BlockItem(Blocks.BUSH_BLACK, new Item.Properties().group(BerryBushes.GROUP)).setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_black"));
		
		public static final Item BERRY_SALAD		= new Item(new Item.Properties().group(BerryBushes.GROUP).food(new Food.Builder().hunger(7).saturation(1.0F).build())).setRegistryName(new ResourceLocation("berrybushes", Reference.ItemRegs.SALAD));
		
		@SubscribeEvent
		public static void onItemReg(RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(BERRY_WHITE,
											BERRY_ORANGE,
											BERRY_MAGENTA,
											BERRY_LIGHT_BLUE,
											BERRY_YELLOW,
											BERRY_LIME,
											BERRY_PINK,
											BERRY_GRAY,
											BERRY_LIGHT_GRAY,
											BERRY_CYAN,
											BERRY_PURPLE,
											BERRY_BLUE,
											BERRY_BROWN,
											BERRY_GREEN,
											BERRY_RED,
											BERRY_BLACK
											,
											BUSH_WHITE,
											BUSH_ORANGE,
											BUSH_MAGENTA,
											BUSH_LIGHT_BLUE,
											BUSH_YELLOW,
											BUSH_LIME,
											BUSH_PINK,
											BUSH_GRAY,
											BUSH_LIGHT_GRAY,
											BUSH_CYAN,
											BUSH_PURPLE,
											BUSH_BLUE,
											BUSH_BROWN,
											BUSH_GREEN,
											BUSH_RED,
											BUSH_BLACK
											,
											BERRY_SALAD);
			
			berries = Arrays.asList(BERRY_WHITE,
									BERRY_ORANGE,
									BERRY_MAGENTA,
									BERRY_LIGHT_BLUE,
									BERRY_YELLOW,
									BERRY_LIME,
									BERRY_PINK,
									BERRY_GRAY,
									BERRY_LIGHT_GRAY,
									BERRY_CYAN,
									BERRY_PURPLE,
									BERRY_BLUE,
									BERRY_BROWN,
									BERRY_GREEN,
									BERRY_RED,
									BERRY_BLACK);
		}
		
	}

	@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class Blocks {
		
		public static final Block BUSH_WHITE		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_white"));
		public static final Block BUSH_ORANGE		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_orange"));
		public static final Block BUSH_MAGENTA		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_magenta"));
		public static final Block BUSH_LIGHT_BLUE	= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lightblue"));
		public static final Block BUSH_YELLOW		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_yellow"));
		public static final Block BUSH_LIME			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lime"));
		public static final Block BUSH_PINK			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_pink"));
		public static final Block BUSH_GRAY			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_gray"));
		public static final Block BUSH_LIGHT_GRAY	= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_lightgray"));
		public static final Block BUSH_CYAN			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_cyan"));
		public static final Block BUSH_PURPLE		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_purple"));
		public static final Block BUSH_BLUE			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_blue"));
		public static final Block BUSH_BROWN		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_brown"));
		public static final Block BUSH_GREEN		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_green"));
		public static final Block BUSH_RED			= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_red"));
		public static final Block BUSH_BLACK		= new BlockBerryBush().setRegistryName(new ResourceLocation("berrybushes", Reference.BlockRegs.BUSH + "_black"));
		
		public static List<Block> bushes;
		
		@SubscribeEvent
		public static void onBlockReg(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(BUSH_WHITE,
											BUSH_ORANGE,
											BUSH_MAGENTA,
											BUSH_LIGHT_BLUE,
											BUSH_YELLOW,
											BUSH_LIME,
											BUSH_PINK,
											BUSH_GRAY,
											BUSH_LIGHT_GRAY,
											BUSH_CYAN,
											BUSH_PURPLE,
											BUSH_BLUE,
											BUSH_BROWN,
											BUSH_GREEN,
											BUSH_RED,
											BUSH_BLACK);
			bushes = Arrays.asList(BUSH_WHITE,
								   BUSH_ORANGE,
								   BUSH_MAGENTA,
								   BUSH_LIGHT_BLUE,
								   BUSH_YELLOW,
								   BUSH_LIME,
								   BUSH_PINK,
								   BUSH_GRAY,
								   BUSH_LIGHT_GRAY,
								   BUSH_CYAN,
								   BUSH_PURPLE,
								   BUSH_BLUE,
								   BUSH_BROWN,
								   BUSH_GREEN,
								   BUSH_RED,
								   BUSH_BLACK);
			
			// Set Berry Bush render layer
			BerryBushes.proxy.setupBlockRenderTypes();
		}
		
	}

	@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
	public static class Features {
		
		@SuppressWarnings("unchecked")
		public static final Feature<NoFeatureConfig> BUSH = (Feature<NoFeatureConfig>) new FeatureBushGen().setRegistryName(new ResourceLocation("berrybushes", Reference.FeatureRegs.BUSH));
		
		@SubscribeEvent
		public static void onFeatureReg(RegistryEvent.Register<Feature<?>> event) {
			event.getRegistry().register(BUSH);
		}
		
	}

}
