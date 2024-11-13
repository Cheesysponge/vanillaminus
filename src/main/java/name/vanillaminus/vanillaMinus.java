package name.vanillaminus;

import name.vanillaminus.block.ModBlocks;
import name.vanillaminus.effect.ModEffects;
import name.vanillaminus.item.ModItemGroup;
import name.vanillaminus.potion.ModPotions;
import name.vanillaminus.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

public class vanillaMinus implements ModInitializer {
    public static final String MOD_ID = "vanillaminus";
    public static final Logger LOGGER = LoggerFactory.getLogger("vanillaminus");
    @Override
    public void onInitialize() {
        ModEffects.registerEffects();

        ModBlocks.registerModBlocks();
        ModScreenHandlers.registerAllScreenHandlers();
        ModItemGroup.registerItemGroups();
        ModPotions.registerPotions();
        MixinBootstrap.init();
        Mixins.addConfiguration("vanillaminus.mixins.json");
    }
}
