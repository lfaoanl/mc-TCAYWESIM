package com.lfaoanl.tcaywesim;

import com.lfaoanl.tcaywesim.entities.CrowEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class TheAnimals implements ModInitializer {

    public static final String MODID = "tcaywesim";

    public static final EntityType<CrowEntity> CROW = Registry.register(
            Registry.ENTITY_TYPE,
            new ResourceLocation(TheAnimals.MODID, "crow"),
            FabricEntityTypeBuilder.create(MobCategory.CREATURE, CrowEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final Item CROW_SPAWN_EGG = new SpawnEggItem(CROW, 0x52595e, 0x333536, new Item.Properties().tab(CreativeModeTab.TAB_MISC));


    @Override
    public void onInitialize() {

        FabricDefaultAttributeRegistry.register(CROW, CrowEntity.createAttributes());
        Registry.register(Registry.ITEM, new ResourceLocation(MODID, "crow_spawn_egg"), CROW_SPAWN_EGG);


    }
}
