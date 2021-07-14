package ca.thecorgi.carrotify.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class CarrotSoupItem extends Item {
    public CarrotSoupItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);

        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.NAUSEA);
            user.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            user.removeStatusEffect(StatusEffects.SLOWNESS);
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.BOWL);
        } else {
            if (user instanceof PlayerEntity playerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(Items.BOWL);
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }
            return this.isFood() ? user.eatFood(world, stack) : stack;
        }
    }
}
