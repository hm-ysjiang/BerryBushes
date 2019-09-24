package hmysjiang.berrybushes;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockBerryBush extends Block implements IGrowable, IPlantable {
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;
	public static final BooleanProperty SOLID = BooleanProperty.create("solid");
	private static final VoxelShape SHAPE = makeCuboidShape(2, 0, 2, 14, 13, 14);
	private static final ResourceLocation PLACABLE_BLOCKS = new ResourceLocation(Reference.MOD_ID, "bush_plantable_on");
	private static final DamageSource DMG = new DamageSource("berrybushes_bush");
	private static final Predicate<ItemEntity> IS_ITEM_BERRY = item -> { return ModRegistry.Items.berries.contains(item.getItem().getItem()); };
	
	public BlockBerryBush() {
		super(Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).sound(SoundType.PLANT).tickRandomly());
		
		setDefaultState(this.stateContainer.getBaseState().with(AGE, 0).with(SOLID, false));
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (ItemTags.LOGS.contains(player.getHeldItem(handIn).getItem()) && !state.get(SOLID)) {
			if (!player.isCreative())
				player.getHeldItem(handIn).shrink(1);
			worldIn.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, state.with(SOLID, true));
			}
			return true;
		}
		if (isMature(state)) {
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, state.with(AGE, 1));
				ItemEntity item = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModRegistry.bush_berry_mapping.get(this)));
				worldIn.addEntity(item);
				item.onCollideWithPlayer(player);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		if (isMature(state)) {
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, state.with(AGE, 1));
				ItemEntity item = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModRegistry.bush_berry_mapping.get(this)));
				worldIn.addEntity(item);
				item.onCollideWithPlayer(player);
			}
		}
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.FOX) {
			if (!worldIn.isRemote) {
				entityIn.attackEntityFrom(DMG, 1.0F);
			}
		}
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this)
			return getDefaultState();
		return state;
	}
	
	public boolean isMature(BlockState state) {
		return state.get(AGE) == 2;
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !isMature(state);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		if (canGrow(worldIn, pos, state, false)) {
			worldIn.setBlockState(pos, state.cycle(AGE));
		}
		else if (ModConfig.mature_drop.get() && worldIn.getEntitiesWithinAABB(ItemEntity.class, new AxisAlignedBB(pos.getX()-4, pos.getY()-4, pos.getZ()-4, pos.getX()+4, pos.getY()+4, pos.getZ()+4), IS_ITEM_BERRY).size() < 8) {
			worldIn.setBlockState(pos, state.with(AGE, 0));
			if (!worldIn.isRemote) {
				ItemEntity item = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModRegistry.bush_berry_mapping.get(this)));
				worldIn.addEntity(item);
			}
		}
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
			ISelectionContext context) {
		return state.get(SOLID) ? SHAPE : VoxelShapes.empty();
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return true;
	}
	
	@Override
	public boolean canSpawnInBlock() {
		return false;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return isPlacableOnBlock(worldIn, pos.down());
	}

	public boolean isPlacableOnBlock(IWorldReader world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		return BlockTags.getCollection().getOrCreate(PLACABLE_BLOCKS).contains(state.getBlock());
	}
	
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		if (fromPos.up().equals(pos))
			if (!isPlacableOnBlock(worldIn, pos.down()))
				worldIn.destroyBlock(pos, true);
	}
	
	@Override
	public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
		if (worldIn.isRemote)
			return;
		if (isMature(state))
			worldIn.addEntity(new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModRegistry.bush_berry_mapping.get(this))));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (isPlacableOnBlock(context.getWorld(), context.getPos().down()))
			return getDefaultState().with(AGE, 0);
		return null;
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(AGE, SOLID);
	}
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		while (worldIn.getBlockState(pos.up()).getBlock() instanceof BlockBerryBush)
			pos = pos.up();
		if (worldIn.isRainingAt(pos.up()) && !worldIn.getBlockState(pos.down()).isSolid() && rand.nextInt(12) == 1) {
			double d0 = (double)((float)pos.getX() + rand.nextFloat());
			double d1 = (double)pos.getY() - 0.05D;
			double d2 = (double)((float)pos.getZ() + rand.nextFloat());
			worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		super.tick(state, worldIn, pos, random);
		if (random.nextInt(ModConfig.growth_rate.get()) == 0)
			grow(worldIn, random, pos, state);
	}

	public BlockState getRandomSpawnState(Random rand) {
		return this.getDefaultState().with(AGE, rand.nextInt(2) + 1);
	}
	
}
