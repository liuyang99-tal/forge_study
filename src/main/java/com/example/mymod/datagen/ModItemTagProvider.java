package com.example.mymod.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.example.mymod.MyMod;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<Provider> p_275729_,
            CompletableFuture<TagLookup<Block>> p_275322_,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MyMod.MODID, existingFileHelper);
    }

    @SuppressWarnings("null")
    @Override
    protected void addTags(Provider pProvider) {
    }

}
