package com.example.mymod.Item.custom;

import java.util.List;

import com.example.mymod.util.ModTags;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @SuppressWarnings("null")
    @Override
    public InteractionResult useOn(@SuppressWarnings("null") UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuables Found!"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;

    }

    @SuppressWarnings("null")
    @Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pToolTipComponents,
            TooltipFlag pIsAdvanced) {
        pToolTipComponents.add(Component.translatable("tooltip.mymod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pToolTipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(
                Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " + "(" + blockPos.getX() + ", "
                        + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    // private boolean isValuableBlock(BlockState state) {
    // return state.is(Blocks.IRON_ORE) || state.is(Blocks.DIAMOND_ORE);
    // }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
