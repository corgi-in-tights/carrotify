package ca.thecorgi.carrotify.components;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CarrotFoodComponent {
    public static final FoodComponent CARROT_JUICE = (new FoodComponent.Builder())
            .hunger(2)
            .saturationModifier(0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 800, 0), 0.4F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 0), 0.25F)
            .snack()
            .alwaysEdible().build();

    public static final FoodComponent CARROT_PASTRY = (new FoodComponent.Builder())
            .hunger(6)
            .saturationModifier(3).build();

    public static final FoodComponent CARROT_SOUP = (new FoodComponent.Builder())
            .hunger(6)
            .saturationModifier(3.5F).build();

    public static final FoodComponent DIAMOND_CARROT = (new FoodComponent.Builder())
            .hunger(3)
            .saturationModifier(3)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 800, 1), 1)
            .alwaysEdible().build();

    public static final FoodComponent OBSIDIAN_CARROT = (new FoodComponent.Builder())
            .hunger(2)
            .saturationModifier(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 550, 0), 1)
            .alwaysEdible().build();
}
