package winlyps.noZombieVillagerCure

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener

class NoZombieVillagerCure : JavaPlugin() {
    override fun onEnable() {
        logger.info("NoZombieVillagerCure plugin has been enabled")
        server.pluginManager.registerEvents(ZombieVillagerListener(this), this)
    }

    override fun onDisable() {
        logger.info("NoZombieVillagerCure plugin has been disabled")
    }
}