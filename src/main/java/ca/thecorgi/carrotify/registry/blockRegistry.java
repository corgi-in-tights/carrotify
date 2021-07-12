package ca.thecorgi.carrotify.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static ca.thecorgi.carrotify.Carrotify.ModID;
import static ca.thecorgi.carrotify.registry.ItemGroupRegistry.CarrotifyMain;
import static net.minecraft.util.registry.Registry.register;

public class blockRegistry {
    public static final Block CARRASTEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(6.5F).requiresTool().breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL));
    public static void registerBlocks() {
        register(Registry.BLOCK, new Identifier(ModID, "carrasteel_block"), CARRASTEEL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ModID, "carrasteel_block"), new BlockItem(CARRASTEEL_BLOCK, new FabricItemSettings().group(CarrotifyMain)));
    }
}
