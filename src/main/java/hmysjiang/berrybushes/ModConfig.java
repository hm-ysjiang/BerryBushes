package hmysjiang.berrybushes;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.google.common.base.Predicate;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
	
	public static ForgeConfigSpec.IntValue spawn_rate;
	public static ForgeConfigSpec.IntValue spawn_min;
	public static ForgeConfigSpec.IntValue spawn_max;
	public static ForgeConfigSpec.IntValue growth_rate;
	public static ForgeConfigSpec.BooleanValue mature_drop;
	public static ForgeConfigSpec.BooleanValue bush_hurt;
	public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> banned_dim;
	public static ForgeConfigSpec.ConfigValue<List<? extends String>> banned_biome;
	
	private static final ForgeConfigSpec.Builder builderCOM = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec configCOM;
	
	public static void init(ForgeConfigSpec.Builder builder) {
		
		spawn_rate = builder.comment(" This determines the spawn rate of berry bushes (1/n). Set this to 0 will disable the spawn.")
							.defineInRange("spawn.spawn_rate", 25, 0, 50);
		
		spawn_min = builder.comment(" This defines the min y that a bush is able to spawn at")
						   .defineInRange("spawn.height.spawn_min", 54, 0, 256);
		
		spawn_max = builder.comment(" This defines the max y that a bush is able to spawn at")
						   .defineInRange("spawn.height.spawn_max", 80, 0, 256);
		
		growth_rate = builder.comment(" There is a 1/n of chance that a bush will grow on a random tick")
							 .defineInRange("prop.growth_rate", 6, 1, 12);
		
		mature_drop = builder.comment(" Berry Bushes will drop their berry if this is set to true")
							 .define("prop.mature_drop", true);
		
		bush_hurt = builder.comment(" Does the bushes hurt livings like cactus")
						   .define("prop.bush_hurt", true);
		
		banned_dim = builder.comment(" Bushes spawn will exclude the dimensions that id is in this list")
							.defineList("spawn.banned.banned_dim", Arrays.asList(-1, 1), new Predicate<Object>() {
								@Override
								public boolean apply(@Nullable Object input) { return input != null && input instanceof Integer; }
							});
		
		banned_biome = builder.comment(" Bushes spawn will exclude the biomes that id is in this list")
							  .defineList("spawn.banned.banned_biome", Arrays.asList("minecraft:ocean", 
									  									"minecraft:desert", 
									  									"minecraft:nether", 
									  									"minecraft:the_end", 
									  									"minecraft:frozen_ocean", 
									  									"minecraft:frozen_river", 
									  									"minecraft:desert_hills", 
									  									"minecraft:deep_ocean", 
									  									"minecraft:stone_shore", 
									  									"minecraft:badlands", 
									  									"minecraft:small_end_islands", 
									  									"minecraft:end_midlands", 
									  									"minecraft:end_highlands", 
									  									"minecraft:end_barrens", 
									  									"minecraft:warm_ocean", 
									  									"minecraft:lukewarm_ocean", 
									  									"minecraft:cold_ocean", 
									  									"minecraft:deep_warm_ocean", 
									  									"minecraft:deep_lukewarm_ocean", 
									  									"minecraft:deep_cold_ocean", 
									  									"minecraft:deep_frozen_ocean", 
									  									"minecraft:the_void"), new Predicate<Object>() {
							      @SuppressWarnings("deprecation")
								  @Override
							      public boolean apply(@Nullable Object input) { return input != null && input instanceof String && Registry.BIOME.containsKey(new ResourceLocation((String) input)); }
						   	  });
		
	}
	
	public static void loadConfig(String path) {
		CommentedFileConfig fileConfig = CommentedFileConfig.builder(new File(path)).autosave().sync().writingMode(WritingMode.REPLACE).build();
		fileConfig.load();
		configCOM.setConfig(fileConfig);
	}
	
	public static ForgeConfigSpec getConfig() {
		return configCOM;
	}
	
	static {
		init(builderCOM);
		configCOM = builderCOM.build();
	}
	
}
