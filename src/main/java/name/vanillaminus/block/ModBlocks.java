package name.vanillaminus.block;

import name.vanillaminus.block.custom.DirtClumpBlock;
import name.vanillaminus.block.custom.DirtCrafterBlock;
import name.vanillaminus.block.custom.IronChunkBlock;
import name.vanillaminus.item.ModFoodComponents;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {
    public static final Block DIRT_CRAFTER = registerBlock("dirt_crafter",
            new DirtCrafterBlock(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE).strength(1f)));

    public static final Block SILT = registerBlock("silt",
            new GlowLichenBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN).strength(0.25f).luminance(0)));

    public static final Block DIRT_CLUMP = registerBlock("dirt_clump",
            new DirtClumpBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CARPET).strength(0.25f).luminance(0).slipperiness(0.989f)));
    public static final Block IRON_CHUNK = registerBlock("iron_chunk",
            new IronChunkBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(1f)));

    private static Item registerBlockItem(String name, Block block, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(vanillaMinus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(vanillaMinus.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(vanillaMinus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().food(ModFoodComponents.BLOCK)));
        return item;
    }
    public static void registerModBlocks() {
        vanillaMinus.LOGGER.info("Registering ModBlocks for " + vanillaMinus.MOD_ID);
    }
}