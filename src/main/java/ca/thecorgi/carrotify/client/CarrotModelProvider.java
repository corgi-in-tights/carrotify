package ca.thecorgi.carrotify.client;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

import static ca.thecorgi.carrotify.registry.itemRegistry.CARROT_BOW;

public class CarrotModelProvider {
    public static void registerBowModels() {
        FabricModelPredicateProviderRegistry.register(CARROT_BOW, new Identifier("pull"), (itemStack, clientWorld, livingEntity, world) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
        });

        FabricModelPredicateProviderRegistry.register(CARROT_BOW, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, world) -> {
            if (livingEntity == null) {
                return 0.0F;
            }
            return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }
}
