package net.egrasel.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.egrasel.tutorialmod.TutorialMod;
import net.egrasel.tutorialmod.item.ModItems;
import net.egrasel.tutorialmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid= TutorialMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =  event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 12),
                    10, 8, 0.02f));

            // Level 2
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.CORN.get(), 6),
                    12, 4, 0.035f));
        }

        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =  event.getTrades();

            // Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(ModItems.SAPPHIRE.get(), 24),
                    new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                    2, 15, 0.050f));
        }

        if (event.getType() == VillagerProfession.LIBRARIAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =  event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.KNOCKBACK, 10));

            // Level 3
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 52),
                    enchantedBook,
                    5, 15, 0.050f));
        }

        if (event.getType() == ModVillagers.SOUND_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades =  event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9),
                    new ItemStack(Items.MUSIC_DISC_13, 1),
                    3, 10, 0.02f));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add(((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(), 1),
                10, 2, 0.2f)));

        rareTrades.add(((pTrader, pRandom) -> {
            ItemStack sapphirePickaxe = new ItemStack(ModItems.SAPPHIRE_CHESTPLATE.get(), 1);

            sapphirePickaxe.enchant(Enchantments.BLOCK_EFFICIENCY, 10);

            return new MerchantOffer(
                    new ItemStack(Items.EMERALD, 24),
                    sapphirePickaxe,
                    10, 2, 0.2f
            );
        }));
    }
}
