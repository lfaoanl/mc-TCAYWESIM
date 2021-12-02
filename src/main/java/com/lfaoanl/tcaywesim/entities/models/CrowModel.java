package com.lfaoanl.tcaywesim.entities.models;

import com.lfaoanl.tcaywesim.TheAnimals;
import com.lfaoanl.tcaywesim.entities.CrowEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class CrowModel extends EntityModel<CrowEntity> {

    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(TheAnimals.MODID, "crow"), "main");

    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart head;

    public CrowModel(ModelPart root) {
        this.body = root.getChild("body");
        this.leftLeg = root.getChild("left");
        this.rightLeg = root.getChild("right");

        this.head = this.body.getChild("top").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(-1.0F, 4.0F, -3.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, 20.0F, 1.5F));

        PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(4, 0).addBox(-1.0F, 4.0F, -3.5F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(15, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.25F, 20.0F, 1.5F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 23).addBox(-2.5F, -6.0F, -6.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(16, 6).addBox(1.5F, -5.5F, -5.5F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(1, 1).addBox(-3.5F, -5.5F, -5.5F, 1.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 20.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition tail_r1 = body.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(28, 23).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 2.0F, 0.6545F, 0.0F, 0.0F));

        PartDefinition top = body.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -4.5F));

        PartDefinition neck_r1 = top.addOrReplaceChild("neck_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, -2.5F, 2.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition head = top.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -1.5F));

        PartDefinition beak_r1 = head.addOrReplaceChild("beak_r1", CubeListBuilder.create().texOffs(15, 0).addBox(-1.5F, -2.25F, -6.25F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(18, 23).addBox(-2.0F, -2.25F, -3.25F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(CrowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * 0.017453292F;
        this.head.yRot = netHeadYaw * 0.017453292F;
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
//        this.rightWing.zRot = ageInTicks;
//        this.leftWing.zRot = -ageInTicks;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(poseStack, buffer, packedLight, packedOverlay);
        leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
    }

}