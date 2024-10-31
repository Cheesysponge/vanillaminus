package name.vanillaminus.client;

import name.vanillaminus.block.ModBlocks;
import name.vanillaminus.screen.DirtCrafterScreen;
import name.vanillaminus.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class VanillaMinusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRT_CRAFTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRT_CRAFTER, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DIRT_CRAFTER, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SILT, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SILT, RenderLayer.getTranslucent());



        ScreenRegistry.register(ModScreenHandlers.DIRT_CRAFTER_SCREEN_HANDLER, DirtCrafterScreen::new);

    }
}
