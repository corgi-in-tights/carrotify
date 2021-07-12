package ca.thecorgi.carrotify.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static ca.thecorgi.carrotify.registry.blockRegistry.CARRASTEEL_BLOCK;
import static ca.thecorgi.carrotify.registry.itemRegistry.*;

public class ItemGroupRegistry {
    public static final ItemGroup CarrotifyMain = FabricItemGroupBuilder.create(
            new Identifier("carrotify", "main_group"))
            .icon(() -> new ItemStack(CARROT_SWORD))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(CARRASTEEL_INGOT));
                stacks.add(new ItemStack(CARRASTEEL_BLOCK));
                stacks.add(new ItemStack(DIAMOND_NUGGET));

                stacks.add(new ItemStack(CARROT_SWORD));
                stacks.add(new ItemStack(CARROT_BOW));
                stacks.add(new ItemStack(CARROT_PICKAXE));
                stacks.add(new ItemStack(CARROT_AXE));
                stacks.add(new ItemStack(CARROT_SHOVEL));
                stacks.add(new ItemStack(CARROT_HOE));

                stacks.add(new ItemStack(CARRASTEEL_HELMET));
                stacks.add(new ItemStack(CARRASTEEL_CHESTPLATE));
                stacks.add(new ItemStack(CARRASTEEL_LEGGINGS));
                stacks.add(new ItemStack(CARRASTEEL_BOOTS));

                stacks.add(new ItemStack(CARROT_JUICE));
                stacks.add(new ItemStack(CARROT_PASTRY));
                stacks.add(new ItemStack(CARROT_SOUP));
                stacks.add(new ItemStack(DIAMOND_CARROT));
                stacks.add(new ItemStack(OBSIDIAN_CARROT));
                stacks.add(new ItemStack(UNSTABLE_CARROT));
            })
            .build();
}
