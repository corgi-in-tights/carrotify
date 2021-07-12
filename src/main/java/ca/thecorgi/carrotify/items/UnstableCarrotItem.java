package ca.thecorgi.carrotify.items;

import ca.thecorgi.carrotify.entities.UnstableCarrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UnstableCarrotItem extends Item {

    public UnstableCarrotItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand); // creates a new ItemStack instance of the user's itemStack in-hand
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.NEUTRAL, 0.5F, 1F); // plays a globalSoundEvent

        user.getItemCooldownManager().set(this, 5);

        if (!world.isClient) {
            UnstableCarrotEntity snowballEntity = new UnstableCarrotEntity(world, user);
            snowballEntity.setItem(itemStack);
            snowballEntity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
            world.spawnEntity(snowballEntity); // spawns entity
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }
}
