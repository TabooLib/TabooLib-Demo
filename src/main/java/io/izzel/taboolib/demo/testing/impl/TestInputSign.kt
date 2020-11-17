package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.util.Features
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class TestInputSign : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            Features.inputSign(sender, emptyArray()) { lines ->
                sender.sendMessage("§8[§fTabooLib§8] §7Lines: §f" + Arrays.toString(lines))
            }
        }
    }
}