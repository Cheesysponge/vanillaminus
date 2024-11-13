package name.vanillaminus.effect;

import name.vanillaminus.vanillaMinus;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
public class ModEffects {
    public static StatusEffect SHELL;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(vanillaMinus.MOD_ID, name),
                new ShellEffect(StatusEffectCategory.HARMFUL, 13607211));
    }

    public static void registerEffects(){
        SHELL = registerStatusEffect("shell");
    }
}
