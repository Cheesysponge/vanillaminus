package name.vanillaminus.item.custom;

import name.vanillaminus.vanillaMinus;
import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MultiTool extends MiningToolItem {
    public static final TagKey<Block> PAXEL_TAG = TagKey.of(RegistryKeys.BLOCK, new Identifier(vanillaMinus.MOD_ID, "multi_tag"));


    public MultiTool(float attackDamage, float attackSpeed, ToolMaterial material, Settings settings) {
        super(attackDamage, attackSpeed, material, PAXEL_TAG, settings);
    }
}
