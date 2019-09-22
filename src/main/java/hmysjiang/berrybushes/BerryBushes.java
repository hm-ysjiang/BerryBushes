package hmysjiang.berrybushes;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Reference.MOD_ID)
public class BerryBushes {
	
	public static BerryBushes INSTANCE_REF;
	public BerryBushes() {
		INSTANCE_REF = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);

		ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.getConfig());
		
        ModConfig.loadConfig(FMLPaths.CONFIGDIR.get().resolve("berrybushes-common.toml").toString());
	}
	
	public static final ItemGroup GROUP = new ItemGroup(Reference.MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModRegistry.Items.BERRY_PINK);
		}
	};
	
	@SuppressWarnings("deprecation")
	private void onCommonSetup(final FMLCommonSetupEvent event) {
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_WHITE, ModRegistry.Items.BERRY_WHITE);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_ORANGE, ModRegistry.Items.BERRY_ORANGE);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_MAGENTA, ModRegistry.Items.BERRY_MAGENTA);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_LIGHT_BLUE, ModRegistry.Items.BERRY_LIGHT_BLUE);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_YELLOW, ModRegistry.Items.BERRY_YELLOW);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_LIME, ModRegistry.Items.BERRY_LIME);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_PINK, ModRegistry.Items.BERRY_PINK);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_GRAY, ModRegistry.Items.BERRY_GRAY);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_LIGHT_GRAY, ModRegistry.Items.BERRY_LIGHT_GRAY);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_CYAN, ModRegistry.Items.BERRY_CYAN);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_PURPLE, ModRegistry.Items.BERRY_PURPLE);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_BLUE, ModRegistry.Items.BERRY_BLUE);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_BROWN, ModRegistry.Items.BERRY_BROWN);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_GREEN, ModRegistry.Items.BERRY_GREEN);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_RED, ModRegistry.Items.BERRY_RED);
		ModRegistry.bush_berry_mapping.put(ModRegistry.Blocks.BUSH_BLACK, ModRegistry.Items.BERRY_BLACK);
		
		for (Biome biome: Registry.BIOME) {
			if (!ModConfig.banned_biome.get().contains(biome.getRegistryName().toString()))
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(ModRegistry.Features.BUSH, new NoFeatureConfig(), Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
		}
	}
	
}
