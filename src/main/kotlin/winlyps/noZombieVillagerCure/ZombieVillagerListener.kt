package winlyps.noZombieVillagerCure

import org.bukkit.entity.ZombieVillager
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPotionEffectEvent
import org.bukkit.event.entity.EntityTransformEvent
import org.bukkit.potion.PotionEffectType

class ZombieVillagerListener(private val plugin: NoZombieVillagerCure) : Listener {

    // Cancel the weakness effect on zombie villagers
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onPotionEffect(event: EntityPotionEffectEvent) {
        if (event.entity is ZombieVillager &&
                event.newEffect?.type == PotionEffectType.WEAKNESS) {
            event.isCancelled = true
            plugin.logger.fine("Prevented applying weakness to a zombie villager")
        }
    }

    // Prevent zombie villager transformation (as backup)
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onEntityTransform(event: EntityTransformEvent) {
        if (event.entity is ZombieVillager &&
                event.transformReason == EntityTransformEvent.TransformReason.CURED) {
            event.isCancelled = true
            plugin.logger.fine("Prevented zombie villager from being cured")
        }
    }
}