package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.TabooLib
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.kotlin.Reflex
import io.izzel.taboolib.kotlin.Tasks
import io.izzel.taboolib.module.ai.SimpleAiSelector
import io.izzel.taboolib.module.lite.SimpleReflection
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.entity.Skeleton
import org.bukkit.util.Consumer

class TestSimpleAI : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            sender.sendMessage("§8[§fTabooLib§8] §7SimpleAI.")
            val skeleton = sender.world.spawn(sender.location, Skeleton::class.java) { c ->
                c.customName = "Fearless Skeleton"
                c.isCustomNameVisible = true
            }
            Tasks.delay(20) {
                SimpleAiSelector.getExecutor().getGoalAi(skeleton).forEach { ai ->
                    sender.sendMessage("§8[§fTabooLib§8] §7AI (Origin): §8" + Reflex.of(ai!!).read("a"))
                }
                SimpleAiSelector.getExecutor().removeGoalAi(skeleton, 3)
                SimpleAiSelector.getExecutor().getGoalAi(skeleton).forEach { ai ->
                    sender.sendMessage("§8[§fTabooLib§8] §7AI (After): §8" + Reflex.of(ai!!).read("a"))
                }
            }
        }
    }
}