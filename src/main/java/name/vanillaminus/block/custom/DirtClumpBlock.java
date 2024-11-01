package name.vanillaminus.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.Item;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class DirtClumpBlock extends Block {

    public DirtClumpBlock(Settings settings) {
        super(settings);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {


        VoxelShape shape = Stream.of(
                Block.createCuboidShape(3, 0, 0, 13, 2, 16),
                Stream.of(
                        Block.createCuboidShape(15, 0, 3, 16, 2, 13),
                        Block.createCuboidShape(14, 0, 2, 15, 2, 14),
                        Block.createCuboidShape(13, 0, 1, 14, 2, 15)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
        Stream.of(
                Block.createCuboidShape(0, 0, 3, 1, 2, 13),
                Block.createCuboidShape(1, 0, 2, 2, 2, 14),
                Block.createCuboidShape(2, 0, 1, 3, 2, 15)
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
        return shape;

    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = Stream.of(
                Block.createCuboidShape(3, 0, 0, 13, 2, 16),
                Stream.of(
                        Block.createCuboidShape(15, 0, 3, 16, 2, 13),
                        Block.createCuboidShape(14, 0, 2, 15, 2, 14),
                        Block.createCuboidShape(13, 0, 1, 14, 2, 15)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get(),
                Stream.of(
                        Block.createCuboidShape(0, 0, 3, 1, 2, 13),
                        Block.createCuboidShape(1, 0, 2, 2, 2, 14),
                        Block.createCuboidShape(2, 0, 1, 3, 2, 15)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get()
        ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
        return shape;
    }



    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.down());
    }
//    Stream.of(
//            Block.box(3, 0, 0, 13, 2, 16),
//            Stream.of(
//            Block.box(15, 0, 3, 16, 2, 13),
//            Block.box(14, 0, 2, 15, 2, 14),
//            Block.box(13, 0, 1, 14, 2, 15)
//            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();,
//            Stream.of(
//            Block.box(0, 0, 3, 1, 2, 13),
//            Block.box(1, 0, 2, 2, 2, 14),
//            Block.box(2, 0, 1, 3, 2, 15)
//            ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
//).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
}
