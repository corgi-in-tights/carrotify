package ca.thecorgi.carrotify;

import ca.thecorgi.carrotify.entities.UnstableCarrotEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static ca.thecorgi.carrotify.registry.blockRegistry.registerBlocks;
import static ca.thecorgi.carrotify.registry.itemRegistry.registerItems;
import static ca.thecorgi.carrotify.registry.lootTableRegistry.registerLootTables;

public class Carrotify implements ModInitializer {
    public static String ModID = "carrotify";

    public static final EntityType<UnstableCarrotEntity> UnstableCarrotEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ModID, "unstable_carrot"),
            FabricEntityTypeBuilder.<UnstableCarrotEntity>create(SpawnGroup.MISC, UnstableCarrotEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build());

    @Override
    public void onInitialize() {
        registerItems();
        registerBlocks();
        registerLootTables();
    }
}
