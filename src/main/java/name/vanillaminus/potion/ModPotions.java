package name.vanillaminus.potion;

import name.vanillaminus.effect.ModEffects;
import name.vanillaminus.item.ModItems;
import name.vanillaminus.mixin.BrewingRecipeRegistryMixin;
import name.vanillaminus.vanillaMinus;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion SHELL_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(vanillaMinus.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.SHELL, 240, 0)));
    }

    public static void registerPotions() {
        SHELL_POTION = registerPotion("shell_potion");

        registerPotionRecipes();
    }
    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.SHELL, ModPotions.SHELL_POTION);
    }

}
