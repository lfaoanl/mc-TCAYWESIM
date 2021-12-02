package com.lfaoanl.tcaywesim;

import com.lfaoanl.tcaywesim.entities.models.CrowModel;
import com.lfaoanl.tcaywesim.entities.render.CrowEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

@Environment(EnvType.CLIENT)
public class ClientProxy implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(TheAnimals.CROW, CrowEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CrowModel.LAYER_LOCATION, CrowModel::createBodyLayer);
    }
}
