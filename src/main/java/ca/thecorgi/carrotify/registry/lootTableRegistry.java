package ca.thecorgi.carrotify.registry;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import static ca.thecorgi.carrotify.registry.itemRegistry.UNSTABLE_CARROT;

public class lootTableRegistry {
    private static final Identifier CARROTS_LOOT_TABLE_ID = Blocks.CARROTS.getLootTableId();

    public static void registerLootTables() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
            if (CARROTS_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(UNSTABLE_CARROT).weight(85))
                        .with(EmptyEntry.Serializer().weight(15));

                table.pool(poolBuilder);
            }
        });
    }
}

