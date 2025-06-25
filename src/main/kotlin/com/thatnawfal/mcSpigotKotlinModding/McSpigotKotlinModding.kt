package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.plugin.java.JavaPlugin

class McSpigotKotlinModding : JavaPlugin(), Listener {

    override fun onEnable() {
//        itemStack()
//        setBlockAt()
//        checkBlockTypes()

//        itemMetaExplain()
        givePlayerArmorSpawn()
    }

    private fun givePlayerArmorSpawn() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    private fun onJoin(playerJoinEvent: PlayerJoinEvent){
        val helmet = ItemStack(Material.LEATHER_HELMET)
        val helmetMeta = helmet.itemMeta as LeatherArmorMeta
//        the function are on the meta variable
        helmetMeta.setColor(Color.GREEN)
//        then set the meta into the helmet
        helmet.itemMeta = helmetMeta

        val chestPlate = ItemStack(Material.LEATHER_CHESTPLATE)
        val chestMeta = helmet.itemMeta as LeatherArmorMeta
        chestMeta.setColor(Color.RED)
        chestPlate.itemMeta = chestMeta

        playerJoinEvent.player.inventory.addItem(helmet)
        playerJoinEvent.player.inventory.addItem(chestPlate)

    }

    private fun itemMetaExplain() {
//        Meta More like function you can change the
//        function of items to function as another item meta

//        if i left it the bamboo_block they dont have the block meta
        val itemStack = ItemStack(Material.BAMBOO_BLOCK)
//        forcing the bamboo having the book meta
        val theMeta = itemStack.itemMeta as BookMeta
//        and set it
        itemStack.itemMeta = theMeta

    }

    private fun setBlockAt() {
        val block = Bukkit.getWorld("world")?.getBlockAt(1, 1, 1)?.type = Material.LAVA
    }

    private fun checkBlockTypes() {
        val block = Bukkit.getWorld("world")?.getBlockAt(15, 60, 42)
        block?.type?.equals(Material.BAMBOO_BLOCK)
    }

    private fun itemStack() {
        val itemStack = ItemStack(Material.CARROT, 3);
        val itemMeta = itemStack.itemMeta

        itemStack.itemMeta = itemMeta
    }


    override fun onDisable() {
        // Plugin shutdown logic
    }
}
