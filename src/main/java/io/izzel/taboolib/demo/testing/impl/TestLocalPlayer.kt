package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.TabooLibAPI
import io.izzel.taboolib.TabooLibLoader
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.db.local.LocalPlayer
import io.izzel.taboolib.module.tellraw.TellrawJson
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TestLocalPlayer : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            TellrawJson.create().append("§8[§fTabooLib§8] §7LocalPlayer: ")
                    .append("§c[...]").hoverText(LocalPlayer.get(sender).saveToString())
                    .send(sender)
            // 以下代码仅供测试 SQLite 性能时使用，禁止在正式环境下运行
            var time = System.currentTimeMillis()
            val conf = LocalPlayer.get0(sender)
            sender.sendMessage("§8[§fTabooLib§8] §7get: " + (System.currentTimeMillis() - time) + "ms")
            time = System.currentTimeMillis()
            LocalPlayer.set0(sender, conf)
            sender.sendMessage("§8[§fTabooLib§8] §7set: " + (System.currentTimeMillis() - time) + "ms")
        }
    }
}