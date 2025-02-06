package net.example.magik.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.List;

public class LootTableEventHandler {

    private static final ResourceLocation CUSTOM_LOOT_TABLE = new ResourceLocation("magik", "entities/custom_loot");

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Mob) {
            try {
                // Use reflection to access the private 'level' field
                Field levelField = net.minecraft.world.entity.Entity.class.getDeclaredField("level");
                levelField.setAccessible(true);
                Level level = (Level) levelField.get(entity);

                LootContext.Builder builder = new LootContext.Builder((ServerLevel) level)
                        .withParameter(LootContextParams.ORIGIN, entity.position())
                        .withParameter(LootContextParams.THIS_ENTITY, entity)
                        .withParameter(LootContextParams.DAMAGE_SOURCE, event.getSource())
                        .withParameter(LootContextParams.LAST_DAMAGE_PLAYER, event.getSource().getEntity());

                LootTable lootTable = ((ServerLevel) level).getServer().getLootTables().get(CUSTOM_LOOT_TABLE);
                List<ItemStack> loot = lootTable.getRandomItems(builder.create(LootContextParamSets.ENTITY));

                for (ItemStack itemStack : loot) {
                    entity.spawnAtLocation(itemStack);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(LootTableEventHandler.class);
    }
}