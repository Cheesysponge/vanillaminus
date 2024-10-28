package name.vanillaminus.screen;

import name.vanillaminus.vanillaMinus;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<DirtCrafterScreenHandler> DIRT_CRAFTER_SCREEN_HANDLER;



    public static void registerAllScreenHandlers() {
        DIRT_CRAFTER_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(vanillaMinus.MOD_ID, "dirtcrafter"),
                        DirtCrafterScreenHandler::new);

    }
}
