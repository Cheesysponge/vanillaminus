package name.vanillaminus.datagen;

import com.ibm.icu.impl.TextTrieMap;
import name.vanillaminus.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
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
        ShapelessRecipeGenerator(Items.DIRT,Item.fromBlock(ModBlocks.DIRT_CRAFTER), exporter);
        ShapelessRecipeGenerator(Items.GRAVEL, Item.fromBlock(ModBlocks.SILT), exporter, 3);
    }


    public void ShapelessRecipeGenerator(Item item, Item output, Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, 1)
                .input(item)
                .criterion(FabricRecipeProvider.hasItem(item),
                        FabricRecipeProvider.conditionsFromItem(item))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }
    public void ShapelessRecipeGenerator(Item item, Item output, Consumer<RecipeJsonProvider> exporter, int n) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, output, n)
                .input(item)
                .criterion(FabricRecipeProvider.hasItem(item),
                        FabricRecipeProvider.conditionsFromItem(item))
                .offerTo(exporter, new Identifier("generated_craft_" + FabricRecipeProvider.getRecipeName(output)));
    }

}