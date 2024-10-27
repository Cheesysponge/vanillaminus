package name.vanillaminus.mixin;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerScreenHandler.class)
public abstract class PlayerScreenHandlerMixin extends ScreenHandler {

    @Unique

    private static final Identifier BLOCK_ATLAS_TEXTURE = new Identifier("textures/atlas/blocks.png");
    @Unique

    private static final Identifier EMPTY_HELMET_SLOT_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    @Unique

    private static final Identifier EMPTY_CHESTPLATE_SLOT_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    @Unique
    private static final Identifier EMPTY_LEGGINGS_SLOT_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    @Unique
    private static final Identifier EMPTY_BOOTS_SLOT_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    @Unique
    private static final Identifier EMPTY_OFFHAND_ARMOR_SLOT = new Identifier("item/empty_armor_slot_shield");
    @Unique
    private static final Identifier[] EMPTY_ARMOR_SLOT_TEXTURES = new Identifier[]{EMPTY_BOOTS_SLOT_TEXTURE, EMPTY_LEGGINGS_SLOT_TEXTURE, EMPTY_CHESTPLATE_SLOT_TEXTURE, EMPTY_HELMET_SLOT_TEXTURE};
    @Unique
    private static final EquipmentSlot[] EQUIPMENT_SLOT_ORDER = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    @Mutable
    @Final
    @Shadow
    private final RecipeInputInventory craftingInput;
    @Unique
    private final CraftingResultInventory craftingResult = new CraftingResultInventory();

    @Unique
    private PlayerEntity owner;
    protected PlayerScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, boolean onServer, RecipeInputInventory craftingInput, PlayerEntity owner) {
        super(type, syncId);
        this.craftingInput = craftingInput;
        this.owner = owner;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(PlayerInventory inventory, boolean onServer, PlayerEntity owner, CallbackInfo ci) {
//        int i;
//        this.owner = owner;
//        for (i = 0; i < 4; ++i) {
//                this.addSlot(new Slot(this.craftingInput, i, 80 + i * 18, 5 ));
//        }
    }

    @Unique
    private static void onEquipStack(PlayerEntity player, EquipmentSlot slot, ItemStack newStack, ItemStack currentStack) {
        Equipment equipment = Equipment.fromStack(newStack);
        if (equipment != null) {
            player.onEquipStack(slot, currentStack, newStack);
        }
    }


}

