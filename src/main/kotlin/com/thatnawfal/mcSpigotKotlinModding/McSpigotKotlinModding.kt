package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.FireworkEffect

import org.bukkit.entity.Firework
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class McSpigotKotlinModding : JavaPlugin(), Listener {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    private fun onSneak(p: PlayerToggleSneakEvent){
        val firework = p.player.world.spawn(p.player.location, Firework::class.java)
        val meta = firework.fireworkMeta

        meta.addEffect(FireworkEffect.builder()
            .withColor(Color.BLUE)
            .withColor(Color.YELLOW)
            .withColor(Color.WHITE)
            .with(FireworkEffect.Type.CREEPER)
            .build())

        meta.power = 2

        firework.fireworkMeta = meta
    }

    @EventHandler
    private fun onJoin(p: PlayerJoinEvent){
        p.player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 100, 3))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
