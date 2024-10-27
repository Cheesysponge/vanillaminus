package name.vanillaminus.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Slot.class)
public abstract class SlotCommon {

    @Shadow
    @Final
    private int index;

    @Shadow
    @Final
    public Inventory inventory;

    @Shadow public abstract ItemStack insertStack(ItemStack stack);

    @Shadow public abstract ItemStack insertStack(ItemStack stack, int count);

    @Shadow public abstract void setStack(ItemStack stack);

    @Shadow public abstract boolean hasStack();

    @Shadow public abstract ItemStack getStack();


    @Shadow public abstract boolean canInsert(ItemStack stack);

    @Unique
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void disableSlot(CallbackInfoReturnable callback, Inventory container, int index) {

        if (index<3 && container instanceof CraftingInventory) {
            //vanillaMinus.LOGGER.info(container.getClass() + vanillaMinus.MOD_ID);
            if(((CraftingInventory) container).getHeight()==2) {
                callback.setReturnValue(false);
                callback.cancel();
            }
        }
    }

    @Inject(method = "canInsert", at = @At("TAIL"), cancellable = true)
    private void mayPlaceItem(ItemStack stack, CallbackInfoReturnable<Boolean> callback) {
        disableSlot(callback, inventory, index);
    }

    @Inject(method = "canBeHighlighted", at = @At("TAIL"), cancellable = true)
    private void canBeHighlighted(CallbackInfoReturnable<Boolean> cir){
//        if (index<3 && !hasStack()) {
//            setStack(new ItemStack(Items.BARRIER));
//        }
        disableSlot(cir, inventory, index);
    }




    @Inject(method = "canTakeItems", at = @At("TAIL"), cancellable = true)
    private void canTakeItems(PlayerEntity playerEntity, CallbackInfoReturnable<Boolean> cir) {
        if(Objects.equals(getStack(), new ItemStack(Items.BARRIER))) {
            disableSlot(cir, inventory, index);
        }
    }

//    @Inject(method = "isEnabled", at = @At("TAIL"), cancellable = true)
//    public void isEnabled(CallbackInfoReturnable<Boolean> cir) {
//        disableSlot(cir, inventory, index);
//    }



}