package ca.thecorgi.carrotify.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

import static ca.thecorgi.carrotify.Carrotify.UnstableCarrotEntityType;
import static ca.thecorgi.carrotify.client.PacketReciever.PacketID;
import static ca.thecorgi.carrotify.registry.itemRegistry.UNSTABLE_CARROT;


@SuppressWarnings("EntityConstructor")
public class UnstableCarrotEntity extends ThrownItemEntity {
    public UnstableCarrotEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public UnstableCarrotEntity(World world, LivingEntity owner) {
        super(UnstableCarrotEntityType, owner, world);
    }


//    public UnstableCarrotEntity(World world, double x, double y, double z) {
//        super(UnstableCarrotEntityType, x, y, z, world);
//    }

    @Override
    protected Item getDefaultItem() {
        return UNSTABLE_CARROT;
    }

    @Override
    public Packet createSpawnPacket() {
        return EntitySpawnPacket.create(this, PacketID);
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return itemStack.isEmpty() ? ParticleTypes.EXPLOSION : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
    }

    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = 2;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, (byte)3);
            this.discard();
            Box box = this.getBoundingBox().expand(1.4, 1.4, 1.4);
            List<LivingEntity> livingEntities = world.getEntitiesByClass(LivingEntity.class, box, EntityPredicates.VALID_LIVING_ENTITY);
            world.playSound(null,getBlockPos(),SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS,0.8F,0.5F);
            if (!livingEntities.isEmpty() && !this.world.isClient()) {
                for (LivingEntity livingEntity : livingEntities) {
                    livingEntity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)4);
                }
            }
        }
    }
}