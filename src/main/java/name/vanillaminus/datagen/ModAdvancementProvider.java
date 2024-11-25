package name.vanillaminus.datagen;

import name.vanillaminus.block.ModBlocks;
import name.vanillaminus.item.ModItems;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import java.util.function.Consumer;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    protected ModAdvancementProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        String id = "vanillaminus";
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        Blocks.DIRT, // The display icon
                        Text.literal("Dirt..."), // The title
                        Text.literal("I wonder what this can make"), // The description
                        new Identifier(vanillaMinus.MOD_ID,"textures/block/dirtcrafter_side.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("dirty", InventoryChangedCriterion.Conditions.items(Blocks.DIRT))
                .build(consumer, id +"/root");

        Advancement dirtClumpAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        ModBlocks.DIRT_CLUMP,
                        Text.literal("A Clump of Dirt?"),
                        Text.literal("I wonder what I can craft with this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("dirt_clump", InventoryChangedCriterion.Conditions.items(ModBlocks.DIRT_CLUMP))
                .build(consumer, id + "/dirt_clump");
        Advancement dirtCrafterAdvancement = Advancement.Builder.create().parent(dirtClumpAdvancement)
                .display(
                        ModBlocks.DIRT_CRAFTER,
                        Text.literal("A Crafting Table Made of DIRT??"),
                        Text.literal("It'll take one iron and two planks and one of these to make something better"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("dirt_crafter", InventoryChangedCriterion.Conditions.items(ModBlocks.DIRT_CRAFTER))
                .build(consumer, id + "/dirt_crafter");
        Advancement CrafterAdvancement = Advancement.Builder.create().parent(dirtCrafterAdvancement)
                .display(
                        Items.CRAFTING_TABLE,
                        Text.literal("Crafting Table"),
                        Text.literal("Don't lose this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("crafting_table", InventoryChangedCriterion.Conditions.items(Items.CRAFTING_TABLE))
                .build(consumer, id + "/crafting_table");
        Advancement gravelAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.GRAVEL,
                        Text.literal("Gravel.."),
                        Text.literal("I wonder what I can craft with this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("gravel", InventoryChangedCriterion.Conditions.items(Items.GRAVEL))
                .build(consumer, id + "/gravel");
        Advancement siltAdvancement = Advancement.Builder.create().parent(gravelAdvancement)
                .display(
                        ModBlocks.SILT,
                        Text.literal("Silt?"),
                        Text.literal("I wonder what happens when I break this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("silt", InventoryChangedCriterion.Conditions.items(ModBlocks.SILT))
                .build(consumer, id + "/silt");
        Advancement ironNuggetAdvancement = Advancement.Builder.create().parent(siltAdvancement)
                .display(
                        Items.IRON_NUGGET,
                        Text.literal("Iron Nuggies"),
                        Text.literal("Maybe put three of these in a crafting table"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("nuggets", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
                .build(consumer, id + "/nuggets");

        Advancement ironChunkAdvancement = Advancement.Builder.create().parent(ironNuggetAdvancement)
                .display(
                        ModBlocks.IRON_CHUNK,
                        Text.literal("Chunky Iron"),
                        Text.literal("Maybe put three of these in a crafting table"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("iron_chunk", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_CHUNK))
                .build(consumer, id + "/iron_chunk");
        Advancement sandAdvancement = Advancement.Builder.create().parent(rootAdvancement)
                .display(
                        Items.SAND,
                        Text.literal("Sandy Sand"),
                        Text.literal("I wonder what I can craft with this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("sand", InventoryChangedCriterion.Conditions.items(Items.SAND))
                .build(consumer, id + "/sand");
        Advancement sandstoneAdvancement = Advancement.Builder.create().parent(sandAdvancement)
                .display(
                        Items.SANDSTONE,
                        Text.literal("Hard Sand"),
                        Text.literal("I wonder what I can craft with three of these"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("sandstone", InventoryChangedCriterion.Conditions.items(Items.SAND))
                .build(consumer, id + "/sandstone");
        Advancement sandChunkAdvancement = Advancement.Builder.create().parent(sandstoneAdvancement)
                .display(
                        ModBlocks.SAND_CHUNK,
                        Text.literal("A Chunk of Sand"),
                        Text.literal("I wonder what I can craft with this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("sand_chunk", InventoryChangedCriterion.Conditions.items(ModBlocks.SAND_CHUNK))
                .build(consumer, id + "/sand_chunk");
        Advancement sandCudgelAdvancement = Advancement.Builder.create().parent(sandstoneAdvancement)
                .display(
                        ModItems.SAND_CUDGEL,
                        Text.literal("Make a tool made out of sand"),
                        Text.literal("A sand and a sandstone"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("sand_cudgel", InventoryChangedCriterion.Conditions.items(ModItems.SAND_CUDGEL))
                .build(consumer, id + "/sand_cudgel");
        Advancement sandArmorAdvancement = Advancement.Builder.create().parent(sandChunkAdvancement)
                .display(
                        ModItems.SAND_CHESTPLATE,
                        Text.literal("Sandy Armor"),
                        Text.literal("This seems useful"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("sand_armor", InventoryChangedCriterion.Conditions.items(ModItems.SAND_CHESTPLATE,ModItems.SAND_LEGGINGS,ModItems.SAND_BOOTS,ModItems.SAND_HELMET))
                .build(consumer, id + "/sand_armor");
        Advancement seaShellAdvancement = Advancement.Builder.create().parent(sandAdvancement)
                .display(
                        ModItems.SHELL,
                        Text.literal("A sea shell"),
                        Text.literal("I wonder what happens if I eat this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("shell", InventoryChangedCriterion.Conditions.items(ModItems.SHELL))
                .build(consumer, id + "/shell");
        Advancement shellHatchetAdvancement = Advancement.Builder.create().parent(seaShellAdvancement)
                .display(
                        ModItems.SHELL_HATCHET,
                        Text.literal("A Chunk of Sand"),
                        Text.literal("I wonder what happens if I eat this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("shell_hatchet", InventoryChangedCriterion.Conditions.items(ModItems.SHELL_HATCHET))
                .build(consumer, id + "/shell_hatchet");
        Advancement eatShellAdvancement = Advancement.Builder.create().parent(seaShellAdvancement)
                .display(
                        ModItems.SHELL,
                        Text.literal("Eat a Shell"),
                        Text.literal("I wonder why you did this"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.GOAL,
                        true,
                        true,
                        true
                )
                .rewards(AdvancementRewards.Builder.experience(1))
                .criterion("eat_shell", ConsumeItemCriterion.Conditions.item(ModItems.SHELL))
                .build(consumer, id + "/eat_shell");

    }

}