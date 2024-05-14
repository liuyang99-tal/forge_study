package com.example.mymod.datagen;

import java.util.concurrent.CompletableFuture;

import com.example.mymod.MyMod;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        generator.addProvider(event.includeServer(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemModelProvider(packOutput, existingFileHelper));

        ModBlockTagProvider blockTagProvider = generator.addProvider(event.includeServer(),
                new ModBlockTagProvider(packOutput, lookUpProvider, existingFileHelper));
        generator.addProvider(event.includeServer(),
                new ModItemTagProvider(packOutput, lookUpProvider, blockTagProvider.contentsGetter(),
                        existingFileHelper));
    }

}
