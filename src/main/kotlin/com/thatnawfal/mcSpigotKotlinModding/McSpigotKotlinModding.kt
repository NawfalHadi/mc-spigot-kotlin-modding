package com.thatnawfal.mcSpigotKotlinModding

import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class McSpigotKotlinModding : JavaPlugin(), Listener {

    private lateinit var bossBar: BossBar

    override fun onEnable() {
//        this are important to check what class they gonna listen
        Bukkit.getPluginManager().registerEvents(this, this)

//        this variable are only excist in system no player see it
        bossBar = Bukkit.createBossBar(
            "${ChatColor.RED} This is wow",
            BarColor.WHITE,
            BarStyle.SEGMENTED_20
        )

        bossBar.progress = 0.9
    }

    @EventHandler
    private fun onJoin(playerJoinEvent: PlayerJoinEvent){
        playerJoinEvent.player.sendMessage("Hello")
//        Send title, title, sub, seconds....
        playerJoinEvent.player.sendTitle("${ChatColor.RED} Hello,", "Welcome", 20, 100, 20)

//        Action Bar
        playerJoinEvent.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy("Hello"))

//        Tablist the player & ping
        playerJoinEvent.player.setPlayerListHeaderFooter("Top\n\n\n", "\n\nBottom")

//        Boss Bars
//        this are the players, that can see
        bossBar.addPlayer(playerJoinEvent.player)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
