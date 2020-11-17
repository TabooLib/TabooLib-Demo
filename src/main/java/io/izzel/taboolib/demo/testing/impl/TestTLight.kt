package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.TabooLib
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.light.TLight
import io.izzel.taboolib.module.nms.impl.Type
import org.bukkit.block.Block
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TestTLight : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            val block = sender.location.block
            sender.sendMessage("§8[§fTabooLib§8] §7Lighting. §a(+)")
            TLight.create(block, Type.BLOCK, 15)
            TabooLib.getPlugin().runTask({
                TLight.create(block, Type.BLOCK, 5)
                sender.sendMessage("§8[§fTabooLib§8] §7Lighting. §c(-)")
            }, 20)
            TabooLib.getPlugin().runTask({
                TLight.delete(block, Type.BLOCK)
                sender.sendMessage("§8[§fTabooLib§8] §7Lighting. §8(-)")
            }, 40)
        }
    }
}