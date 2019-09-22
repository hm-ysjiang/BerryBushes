package hmysjiang.berrybushes;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FeatureBushGen extends Feature<NoFeatureConfig> {
	
	public FeatureBushGen() {
		super(NoFeatureConfig::deserialize);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		if (ModConfig.spawn_rate.get() == 0 || ModConfig.banned_dim.get().contains(worldIn.getDimension().getType().getId()))
			return true;
		if (rand.nextInt(ModConfig.spawn_rate.get()) == 0) {
			for (int i = 0; i < 10; ++i) {
				BlockPos blockpos = getFirstAirBlock(worldIn, pos.add(rand.nextInt(4) - rand.nextInt(4), -pos.getY(), rand.nextInt(4) - rand.nextInt(4)), ModConfig.spawn_max.get());
				if (blockpos.getY() < ModConfig.spawn_min.get() || blockpos.getY() > ModConfig.spawn_max.get())
					continue;
				if (worldIn.isAirBlock(blockpos)) {
					if (ModRegistry.Blocks.BUSH_WHITE.getDefaultState().isValidPosition(worldIn, blockpos)) {
						worldIn.setBlockState(blockpos, ((BlockBerryBush) ModRegistry.Blocks.bushes.get(rand.nextInt(16))).getRandomSpawnState(rand), 2);
					}
				}
			}
		}

		return true;
	}
	
	protected BlockPos getFirstAirBlock(IWorld world, final BlockPos pos, int lim) {
		BlockPos blockpos = pos.add(0, 0, 0);
		while (!world.isAirBlock(blockpos)) {
			if (blockpos.getY() > lim)
				return pos;
			blockpos = blockpos.add(0, 1, 0);
		}
		return blockpos;
	}
	
}
