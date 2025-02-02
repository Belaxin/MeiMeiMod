package net.belaxin.MeiMeiTheCat.item;

import net.belaxin.MeiMeiTheCat.MeiMeiTheCat;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MeiMeiTheCat.MOD_ID);

    public static final RegistryObject<Item> TAIL = ITEMS.register("tail",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KIBBLE = ITEMS.register("kibble",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KIBBLE_POWDER = ITEMS.register("kibble_powder",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
