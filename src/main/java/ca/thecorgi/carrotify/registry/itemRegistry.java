package ca.thecorgi.carrotify.registry;

import ca.thecorgi.carrotify.components.CarrotArmorComponent;
import ca.thecorgi.carrotify.components.CarrotFoodComponent;
import ca.thecorgi.carrotify.items.UnstableCarrotItem;
import ca.thecorgi.carrotify.items.tools.CarrotAxeItem;
import ca.thecorgi.carrotify.items.tools.CarrotHoeItem;
import ca.thecorgi.carrotify.items.tools.CarrotPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static ca.thecorgi.carrotify.Carrotify.ModID;
import static ca.thecorgi.carrotify.components.CarrotToolComponent.INSTANCE;
import static ca.thecorgi.carrotify.registry.ItemGroupRegistry.CarrotifyMain;
import static net.minecraft.util.registry.Registry.ITEM;
import static net.minecraft.util.registry.Registry.register;

public class itemRegistry {
    public static final Item CARRASTEEL_INGOT = new Item(new FabricItemSettings().group(CarrotifyMain));
    public static final Item DIAMOND_NUGGET = new Item(new FabricItemSettings().group(CarrotifyMain));

    public static final Item CARROT_JUICE = new Item(new FabricItemSettings().group(CarrotifyMain).food(CarrotFoodComponent.CARROT_JUICE).maxCount(8));
    public static final Item CARROT_PASTRY = new Item(new FabricItemSettings().group(CarrotifyMain).food(CarrotFoodComponent.CARROT_PASTRY).maxCount(16));
    public static final Item CARROT_SOUP = new Item(new FabricItemSettings().group(CarrotifyMain).food(CarrotFoodComponent.CARROT_SOUP).maxCount(1));
    public static final Item DIAMOND_CARROT = new Item(new FabricItemSettings().group(CarrotifyMain).food(CarrotFoodComponent.DIAMOND_CARROT).maxCount(64));
    public static final Item OBSIDIAN_CARROT = new Item(new FabricItemSettings().group(CarrotifyMain).food(CarrotFoodComponent.OBSIDIAN_CARROT).maxCount(64));
    public static final Item UNSTABLE_CARROT = new UnstableCarrotItem(new Item.Settings().group(CarrotifyMain).maxCount(8));

    public static final ToolItem CARROT_SWORD = new SwordItem(INSTANCE, 2,  -2.2F, new Item.Settings().group(CarrotifyMain));
    public static final ToolItem CARROT_PICKAXE = new CarrotPickaxeItem(INSTANCE, 1, -2.8F, new Item.Settings().group(CarrotifyMain));
    public static final ToolItem CARROT_AXE = new CarrotAxeItem(INSTANCE, 5, -3F, new Item.Settings().group(CarrotifyMain));
    public static final ToolItem CARROT_HOE = new CarrotHoeItem(INSTANCE, -3, 0, new Item.Settings().group(CarrotifyMain));
    public static final ToolItem CARROT_SHOVEL = new ShovelItem(INSTANCE, -1.5F, -3.0F, new Item.Settings().group(CarrotifyMain));

    public static BowItem CARROT_BOW = new BowItem(new FabricItemSettings().group(CarrotifyMain).maxDamage(650));

    public static final ArmorMaterial CARROT_ARMOR_MAT = new CarrotArmorComponent();
    public static final Item CARRASTEEL_HELMET = new ArmorItem(CARROT_ARMOR_MAT, EquipmentSlot.HEAD, new Item.Settings().group(CarrotifyMain));
    public static final Item CARRASTEEL_CHESTPLATE = new ArmorItem(CARROT_ARMOR_MAT, EquipmentSlot.CHEST, new Item.Settings().group(CarrotifyMain));
    public static final Item CARRASTEEL_LEGGINGS = new ArmorItem(CARROT_ARMOR_MAT, EquipmentSlot.LEGS, new Item.Settings().group(CarrotifyMain));
    public static final Item CARRASTEEL_BOOTS = new ArmorItem(CARROT_ARMOR_MAT, EquipmentSlot.FEET, new Item.Settings().group(CarrotifyMain));



    public static void registerItems(){
        register(ITEM, new Identifier(ModID,"carrasteel_ingot"), CARRASTEEL_INGOT);
        register(ITEM, new Identifier(ModID,"diamond_nugget"), DIAMOND_NUGGET);

        register(ITEM, new Identifier(ModID,"carrot_juice"), CARROT_JUICE);
        register(ITEM, new Identifier(ModID,"carrot_pastry"), CARROT_PASTRY);
        register(ITEM, new Identifier(ModID,"carrot_soup"), CARROT_SOUP);

        register(ITEM, new Identifier(ModID,"diamond_carrot"), DIAMOND_CARROT);
        register(ITEM, new Identifier(ModID,"obsidian_carrot"), OBSIDIAN_CARROT);
        register(ITEM, new Identifier(ModID, "unstable_carrot"), UNSTABLE_CARROT);

        register(ITEM, new Identifier(ModID,"carrot_pickaxe"), CARROT_PICKAXE);
        register(ITEM, new Identifier(ModID,"carrot_axe"), CARROT_AXE);
        register(ITEM, new Identifier(ModID,"carrot_shovel"), CARROT_SHOVEL);
        register(ITEM, new Identifier(ModID,"carrot_hoe"), CARROT_HOE);

        register(ITEM, new Identifier(ModID,"carrot_sword"), CARROT_SWORD);
        register(ITEM, new Identifier(ModID,"carrot_bow"), CARROT_BOW);

        register(ITEM, new Identifier(ModID,"carrasteel_helmet"), CARRASTEEL_HELMET);
        register(ITEM, new Identifier(ModID,"carrasteel_chestplate"), CARRASTEEL_CHESTPLATE);
        register(ITEM, new Identifier(ModID,"carrasteel_leggings"), CARRASTEEL_LEGGINGS);
        register(ITEM, new Identifier(ModID,"carrasteel_boots"), CARRASTEEL_BOOTS);
    }
}