package net.egrasel.tutorialmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STARWBERRY = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200), 0.1f)
            .fast()
            .build();

}
