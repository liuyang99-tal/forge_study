package com.example.mymod.Item;

import com.example.mymod.MyMod;
import com.example.mymod.Item.custom.MetalDetectorItem;
import com.example.mymod.util.ModTags.Items;
import com.example.mymod.Item.custom.FuelItem;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MODID);

        public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
                        () -> new MetalDetectorItem(new Item.Properties().durability(100)));

        public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
                        () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

        public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
                        () -> new Item(new Item.Properties().stacksTo(1)));

        public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
                        () -> new FuelItem(new Item.Properties(), 400));

        public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
                        () -> new SwordItem(ModToolTiers.SAPPHIRE, 4, 2, new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, 1, new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
                        () -> new AxeItem(ModToolTiers.SAPPHIRE, 7, 1, new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
                        () -> new ShovelItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));
        public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
                        () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
