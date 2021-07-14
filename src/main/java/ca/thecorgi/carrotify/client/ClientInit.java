package ca.thecorgi.carrotify.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

import static ca.thecorgi.carrotify.Carrotify.UnstableCarrotEntityType;
import static ca.thecorgi.carrotify.client.CarrotModelProvider.registerBowModels;
import static ca.thecorgi.carrotify.client.PacketReceiver.receiveEntityPacket;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerBowModels();
        EntityRendererRegistry.INSTANCE.register(UnstableCarrotEntityType, FlyingItemEntityRenderer::new);
        receiveEntityPacket();
    }

}
