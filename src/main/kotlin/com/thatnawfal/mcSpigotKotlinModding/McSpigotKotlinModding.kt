package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.Effect
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.plugin.java.JavaPlugin

class McSpigotKotlinModding : JavaPlugin(), Listener {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    private fun onSneak(p: PlayerToggleSneakEvent){
//        basicSound(p)
//        pitchSound(p)
        discSound(p)
    }

    private fun discSound(p: PlayerToggleSneakEvent) {
//        Music disc need exact location to play and it will be played in the exact location
//        the location will behave like music disc, fade away if we move
        if (p.isSneaking) {
            p.player.playEffect(Location(Bukkit.getWorld("world"), 0.0, 0.0, 0.0), Effect.RECORD_PLAY, Material.MUSIC_DISC_11)
        }
    }

    private fun pitchSound(p: PlayerToggleSneakEvent) {
        if (p.isSneaking){
            p.player.playSound(p.player.location, Sound.BLOCK_NOTE_BLOCK_BANJO, 1.0f, 1.0f)
        }
    }

    private fun basicSound(p: PlayerToggleSneakEvent){
//        the volume 0.0-1 are the volume
//        1++ will be sound to around
        p.player.playSound(p.player.location, Sound.BLOCK_LAVA_POP, 1.0F, 1.0F)
        Bukkit.getWorld("world")
    }
}
