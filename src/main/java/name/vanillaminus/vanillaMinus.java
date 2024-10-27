package name.vanillaminus;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

public class vanillaMinus implements ModInitializer {
    public static final String MOD_ID = "vanillaminus";
    public static final Logger LOGGER = LoggerFactory.getLogger("vanillaminus");
    @Override
    public void onInitialize() {
        MixinBootstrap.init();
        Mixins.addConfiguration("vanillaminus.mixins.json");
    }
}
