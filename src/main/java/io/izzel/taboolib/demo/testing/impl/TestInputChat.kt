package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.util.Features
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

class TestInputChat : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            Features.inputChat(sender, object : Features.ChatInput {

                override fun head() {
                    sender.sendMessage("§8[§fTabooLib§8] §7Please enter \"chat\".")
                }

                override fun onChat(message: String): Boolean {
                    return message == "chat"
                }
            })
        }
    }
}