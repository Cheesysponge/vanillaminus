package name.vanillaminus.item;

import name.vanillaminus.block.ModBlocks;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup VANILLA_MINUS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(vanillaMinus.MOD_ID, "vanilla_minus"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.vanillaminus.vanilla_minus"))
                    .icon(() -> new ItemStack(ModBlocks.DIRT_CRAFTER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DIRT_CRAFTER);
                        entries.add(ModBlocks.DIRT_CLUMP);
                        entries.add(ModBlocks.IRON_CHUNK);
                        entries.add(ModBlocks.SILT);
                        entries.add(ModItems.SHELL);
                        entries.add(ModItems.SHELL_HATCHET);
                    }).build());

    public static void registerItemGroups() {
        vanillaMinus.LOGGER.info("Registering Item Groups for " + vanillaMinus.MOD_ID);
    }
}
