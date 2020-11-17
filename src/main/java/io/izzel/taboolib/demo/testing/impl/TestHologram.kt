package io.izzel.taboolib.demo.testing.impl

import com.google.common.collect.Lists
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.hologram.THologram
import org.bukkit.Location
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TestHologram : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            THologram.create(sender.eyeLocation.add(sender.location.direction), "TabooLib", sender)
                    .flash(listOf(
                            "§bT§fabooLib",
                            "§bTa§fbooLib",
                            "§bTab§fooLib",
                            "§bTabo§foLib",
                            "§bTaboo§fLib",
                            "§bTabooL§fib",
                            "§bTabooLi§fb",
                            "§bTabooLib",
                            "§bTabooLi§fb",
                            "§bTabooL§fib",
                            "§bTaboo§fLib",
                            "§bTabo§foLib",
                            "§bTab§fooLib",
                            "§bTa§fbooLib",
                            "§bT§fabooLib",
                            "§fTabooLib"
                    ), 1).deleteOn(30)
            sender.sendMessage("§8[§fTabooLib§8] §7Hologram.")
        }
    }
}