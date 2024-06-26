package com.example.mymod.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

import com.example.mymod.MyMod;
import com.example.mymod.block.ModBlocks;
import com.example.mymod.util.ModTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

        public ModBlockTagProvider(PackOutput output, CompletableFuture<Provider> lookupProvider,
                        @Nullable ExistingFileHelper existingFileHelper) {
                super(output, lookupProvider, MyMod.MODID, existingFileHelper);
        }

        @SuppressWarnings("null")
        @Override
        protected void addTags(Provider pProvider) {
                this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                                .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

                this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                                                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                                                ModBlocks.SAPPHIRE_ORE.get(),
                                                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                                                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                                                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                                                ModBlocks.SOUND_BLOCK.get());

                this.tag(BlockTags.NEEDS_IRON_TOOL)
                                .add(ModBlocks.SAPPHIRE_BLOCK.get());

                this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                                .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                this.tag(BlockTags.NEEDS_STONE_TOOL)
                                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());

                this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                                .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

                this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL).add(ModBlocks.SOUND_BLOCK.get());

                this.tag(BlockTags.FENCES).add(ModBlocks.SAPPHIRE_FENCE.get());
                this.tag(BlockTags.FENCE_GATES).add(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                this.tag(BlockTags.WALLS).add(ModBlocks.SAPPHIRE_WALL.get());
        }

}
