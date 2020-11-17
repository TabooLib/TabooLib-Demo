package io.izzel.taboolib.demo.testing.impl

import com.google.common.collect.Lists
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.util.chat.ChatColor
import org.bukkit.command.CommandSender
import java.awt.Color

class TestChatColor : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        val colors = listOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED)
        for (color in colors) {
            sender.sendMessage("§8[§fTabooLib§8] " + ChatColor.of(color) + "Color: " + ChatColor.of(color).toString().replace("§", "&"))
        }
    }
}