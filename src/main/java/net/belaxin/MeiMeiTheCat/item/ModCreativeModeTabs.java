package net.belaxin.MeiMeiTheCat.item;

import net.belaxin.MeiMeiTheCat.MeiMeiTheCat;
import net.belaxin.MeiMeiTheCat.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MeiMeiTheCat.MOD_ID);

    // This adds items into their own tab
    public static final RegistryObject<CreativeModeTab> MEIMEI_TAB = CREATIVE_MODE_TABS.register("meimei_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TAIL.get()))
                    .title(Component.translatable("creativetab.meimei_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //items
                        pOutput.accept(ModItems.TAIL.get());
                        pOutput.accept(ModItems.KIBBLE.get());
                        pOutput.accept(ModItems.KIBBLE_POWDER.get());

                        //blocks
                        pOutput.accept(ModBlocks.TANGLED_TAILS.get());
                        pOutput.accept(ModBlocks.KIBBLE_PILE.get());
                        pOutput.accept(ModBlocks.KIBBLE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_KIBBLE_ORE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
