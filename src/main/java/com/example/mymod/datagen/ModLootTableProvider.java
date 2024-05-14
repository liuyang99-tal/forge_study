package com.example.mymod.datagen;

import java.util.List;
import java.util.Set;

import com.example.mymod.datagen.loot.ModBlockLootTables;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider {
    public static LootTableProvider create(PackOutput pOutput) {

        return new LootTableProvider(pOutput, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
