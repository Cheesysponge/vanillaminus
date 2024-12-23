package name.vanillaminus.datagen;

import com.ibm.icu.impl.TextTrieMap;
import name.vanillaminus.block.ModBlocks;
import name.vanillaminus.item.ModItems;
import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeGenerator(Items.DIRT,Item.fromBlock(ModBlocks.DIRT_CLUMP), exporter);
        ShapelessRecipeGenerator(Items.SAND, ModItems.SHELL, exporter);

        ShapelessRecipeGenerator(Item.fromBlock(ModBlocks.DIRT_CLUMP),Item.fromBlock(ModBlocks.DIRT_CRAFTER), exporter);
        ShapelessRecipeGenerator(Items.GRAVEL, Item.fromBlock(ModBlocks.SILT), exporter, 3);
        ShapelessRecipeGenerator( 3,Items.IRON_NUGGET, Item.fromBlock(ModBlocks.IRON_CHUNK), exporter);
        ShapelessRecipeGenerator( 3,Items.SANDSTONE, Item.fromBlock(ModBlocks.SAND_CHUNK), exporter);
        ShapelessRecipeGenerator( Item.fromBlock(ModBlocks.SAND_CHUNK),Items.SANDSTONE , exporter,3);
        ShapelessRecipeGenerator( 3, Item.fromBlock(ModBlocks.IRON_CHUNK),Items.IRON_INGOT , exporter);
        ShapelessRecipeGenerator( Item.fromBlock(ModBlocks.IRON_CHUNK),Items.IRON_NUGGET , exporter,3);
        TwoVerticalRecipeGenerator(Items.STICK,ModItems.SHELL,ModItems.SHELL_HATCHET, exporter);
        TwoVerticalRecipeGenerator(Items.SAND,Items.SANDSTONE,ModItems.SAND_CUDGEL, exporter);
        recipeGenerator(exporter, ModItems.SAND_CHESTPLATE);
        recipeGenerator(exporter, ModItems.SAND_HELMET);
        recipeGenerator(exporter, ModItems.SAND_LEGGINGS);
        recipeGenerator(exporter, ModItems.SAND_BOOTS);



    }


    public void ShapelessRecipeGenerator(Item item, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(item)
                .criterion(FabricRecipeProvider.hasItem(item),
                        FabricRecipeProvider.conditionsFromItem(item))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void ShapelessRecipeGenerator(Item item, Item output, Consumer<RecipeJsonProvider> exporter, int outputCount) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, outputCount)
                .input(item)
                .criterion(FabricRecipeProvider.hasItem(item),
                        FabricRecipeProvider.conditionsFromItem(item))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void ShapelessRecipeGenerator(int inputCount, Item item, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(item, inputCount)
                .criterion(FabricRecipeProvider.hasItem(item),
                        FabricRecipeProvider.conditionsFromItem(item))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }

    public void TwoVerticalRecipeGenerator(Item First, Item Second, Item Output, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                .pattern("I")
                .pattern("#")
                .input('I', Second)
                .input('#', First)

                .criterion(FabricRecipeProvider.hasItem(Second),
                        FabricRecipeProvider.conditionsFromItem(Second))
                .criterion(FabricRecipeProvider.hasItem(First),
                        FabricRecipeProvider.conditionsFromItem(First))
                .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
    }
    public void recipeGenerator(Consumer<RecipeJsonProvider> exporter, Item Output){

        Item First = Items.BARRIER;
        String OutName = getRecipeName(Output);
        vanillaMinus.LOGGER.info("Out: " + OutName);

        if(OutName.contains("sand")) {
            First = Item.fromBlock(ModBlocks.SAND_CHUNK);
        }



        if(getRecipeName(Output).contains("sword")){
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("#")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("_axe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I#")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("pickaxe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern(" I ")
                    .pattern(" I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("hoe")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("##")
                    .pattern("I ")
                    .pattern("I ")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("shovel")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("#")
                    .pattern("I")
                    .pattern("I")
                    .input('I', Items.STICK)
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                            FabricRecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("chestplate")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("leggings")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("boots")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', First)

                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }
        if(getRecipeName(Output).contains("helmet")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("# #")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
        }

        if(getRecipeName(Output).contains("block")) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Output)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .input('#', First)


                    .criterion(FabricRecipeProvider.hasItem(First),
                            FabricRecipeProvider.conditionsFromItem(First))
                    .offerTo(exporter, new Identifier("generated_" + FabricRecipeProvider.getRecipeName(Output)));
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, First)
                    .input(Output)
                    .criterion(FabricRecipeProvider.hasItem(Output),
                            FabricRecipeProvider.conditionsFromItem(Output))
                    .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(First)));
        }

    }



}
