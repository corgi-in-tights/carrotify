package ca.thecorgi.carrotify.components;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import static ca.thecorgi.carrotify.registry.itemRegistry.CARRASTEEL_INGOT;


public class CarrotToolComponent implements ToolMaterial {

    public static final CarrotToolComponent INSTANCE = new CarrotToolComponent();

    @Override
    public int getDurability() {
        return 640;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.5F;
    }

    @Override
    public float getAttackDamage() {
        return 2.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(CARRASTEEL_INGOT);
    }
}
