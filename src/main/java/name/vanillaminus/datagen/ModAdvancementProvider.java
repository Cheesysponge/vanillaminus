package name.vanillaminus.datagen;

import name.vanillaminus.block.ModBlocks;
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
                .build(consumer, "vanillaminus" + "/root");

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
                .build(consumer, "vanillaminus" + "/dirt_clump");
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
                .build(consumer, "vanillaminus" + "/dirt_crafter");
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
                .build(consumer, "vanillaminus" + "/gravel");
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
                .build(consumer, "vanillaminus" + "/silt");
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
                .criterion("silt", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
                .build(consumer, "vanillaminus" + "/silt");

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
                .build(consumer, "vanillaminus" + "/iron_chunk");



    }

}