package name.vanillaminus.item;

import name.vanillaminus.item.custom.MultiTool;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SHELL = registerItem("shell", new Item(new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SHELL_HATCHET = registerItem("shell_hatchet", new MultiTool(0,1,ToolMaterials.WOOD,new FabricItemSettings().food(ModFoodComponents.ICKY)));


    private static Item registerItem(String name, Item item) {
        //addToItemGroup(ModItemGroup.CHEESY_SPONGE,item);
        return Registry.register(Registries.ITEM, new Identifier(vanillaMinus.MOD_ID, name), item);
    }
    //    public static void addToItemGroup(ItemGroup group, Item item) {
//        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
//    }
    public static void registerModItems() {
        vanillaMinus.LOGGER.info("Registering Mod Items for " + vanillaMinus.MOD_ID);
    }
}
