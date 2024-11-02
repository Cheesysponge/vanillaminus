package name.vanillaminus.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BLOCK = new FoodComponent.Builder().hunger(-1).saturationModifier(1.0f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 1), 0.9f).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 0), 0.9f).alwaysEdible().build();

}
