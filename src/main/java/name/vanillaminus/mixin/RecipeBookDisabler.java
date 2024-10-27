package name.vanillaminus.mixin;

import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.recipe.book.RecipeBookCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeBook.class)

public class RecipeBookDisabler {

    @Inject(method = "isGuiOpen", at = @At("TAIL"), cancellable = true)
    public void shouldntDisplay(RecipeBookCategory category, CallbackInfoReturnable<Boolean> cir){
        cir.setReturnValue(false);
    }
    //@Inject(method = "", at = @At("TAIL"), cancellable = true)

}
