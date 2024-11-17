package name.vanillaminus.item;

import name.vanillaminus.item.custom.MultiTool;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SHELL = registerItem("shell", new Item(new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SHELL_HATCHET = registerItem("shell_hatchet", new MultiTool(1.5f,-1.5f,ModToolMaterials.SHELL,new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SAND_CUDGEL = registerItem("sand_cudgel", new MultiTool(3,-2.2f,ModToolMaterials.SAND,new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SAND_HELMET = registerItem("sand_helmet", new ArmorItem(ModArmorMaterials.SAND, ArmorItem.Type.HELMET,new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SAND_CHESTPLATE = registerItem("sand_chestplate", new ArmorItem(ModArmorMaterials.SAND, ArmorItem.Type.CHESTPLATE,new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SAND_LEGGINGS = registerItem("sand_leggings", new ArmorItem(ModArmorMaterials.SAND, ArmorItem.Type.LEGGINGS,new FabricItemSettings().food(ModFoodComponents.ICKY)));
    public static final Item SAND_BOOTS = registerItem("sand_boots", new ArmorItem(ModArmorMaterials.SAND, ArmorItem.Type.BOOTS,new FabricItemSettings().food(ModFoodComponents.ICKY)));





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
