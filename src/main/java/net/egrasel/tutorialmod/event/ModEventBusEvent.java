package net.egrasel.tutorialmod.event;

import net.egrasel.tutorialmod.TutorialMod;
import net.egrasel.tutorialmod.entity.ModEntites;
import net.egrasel.tutorialmod.entity.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntites.RHINO.get(), RhinoEntity.createAttributes().build());
    }

}
