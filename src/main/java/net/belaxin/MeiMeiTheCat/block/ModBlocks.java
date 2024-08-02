package net.belaxin.MeiMeiTheCat.block;

import net.belaxin.MeiMeiTheCat.MeiMeiTheCat;
import net.belaxin.MeiMeiTheCat.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MeiMeiTheCat.MOD_ID);

    public static final RegistryObject<Block> TANGLED_TAILS = registerBlock("tangled_tails",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK).speedFactor(1.4f)));

    public static final RegistryObject<Block> KIBBLE_PILE = registerBlock("kibble_pile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.CANDLE)));

    public static final RegistryObject<Block> KIBBLE_ORE = registerBlock("kibble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(), UniformInt.of(1, 2)));

    public static final RegistryObject<Block> DEEPSLATE_KIBBLE_ORE = registerBlock("deepslate_kibble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3.5f).requiresCorrectToolForDrops(), UniformInt.of(1, 2)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }

}
