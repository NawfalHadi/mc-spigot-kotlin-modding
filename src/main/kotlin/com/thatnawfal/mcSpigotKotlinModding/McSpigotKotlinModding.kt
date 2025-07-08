package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.World
import org.bukkit.entity.Arrow
import org.bukkit.entity.Egg
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.plugin.java.JavaPlugin
import org.spigotmc.event.player.PlayerSpawnLocationEvent

class McSpigotKotlinModding : JavaPlugin(), Listener {

//    Projectlis is throwable, ex arrow

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);


    }

    @EventHandler
    private fun onSpawn(p: PlayerSpawnLocationEvent){

//        in this case i just tryna to force it, with my charafcter
        val player = p.player
        val world: World

//        It Spawns a particle only for player
        player.spawnParticle(Particle.LAVA, p.spawnLocation, 100)

//        it spawn particles for everybody in the world
//        world.spawnParticle()

    }

    @EventHandler
    private fun onLaunch(e: ProjectileLaunchEvent){

    }

    private fun onHit(e: ProjectileHitEvent) {

//        e.entity.shoo

    }

    @EventHandler
    private fun onPlayerInteract(p: PlayerInteractEvent){
//        Here is checking the player hold something in the main hand
//        clicking iar will do something

        val player = p.player

        if(p.hand == EquipmentSlot.HAND){
            if (p.action == Action.RIGHT_CLICK_AIR || p.action == Action.RIGHT_CLICK_BLOCK){
                if (player.inventory.itemInMainHand.type == Material.DIAMOND_HOE){
                    player.launchProjectile(Arrow::class.java, player.location.direction)
                    player.launchProjectile(Egg::class.java, player.location.direction)

                } else {

                }
            }
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
