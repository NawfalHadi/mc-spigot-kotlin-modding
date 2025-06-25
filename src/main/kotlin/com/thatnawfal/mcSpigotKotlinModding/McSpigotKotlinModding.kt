package com.thatnawfal.mcSpigotKotlinModding

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class McSpigotKotlinModding : JavaPlugin() {

    override fun onEnable() {
//        itemStack()
//        setBlockAt()
//        checkBlockTypes()

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
