package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.WorldCreator
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class McSpigotKotlinModding : JavaPlugin() {

    override fun onEnable() {

        val player: Player? = null
//        how do i get environment around player
        player?.world?.setStorm(true)

//        You Can Creating a new wolrd
        Bukkit.createWorld(WorldCreator("New World"))
//        This is the default
        Bukkit.getWorld("world")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
