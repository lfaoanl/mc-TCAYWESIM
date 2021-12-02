package com.lfaoanl.tcaywesim.entities.render;

import com.lfaoanl.tcaywesim.ClientProxy;
import com.lfaoanl.tcaywesim.TheAnimals;
import com.lfaoanl.tcaywesim.entities.CrowEntity;
import com.lfaoanl.tcaywesim.entities.models.CrowModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrowEntityRenderer extends MobRenderer<CrowEntity, CrowModel> {

    public CrowEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new CrowModel(context.bakeLayer(CrowModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrowEntity entity) {
        return new ResourceLocation(TheAnimals.MODID, "textures/entity/crow.png");
    }
}
