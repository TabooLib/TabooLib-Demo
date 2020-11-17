package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.tellraw.TellrawJson
import io.izzel.taboolib.util.item.Items
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TestTellrawJson : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        val json = TellrawJson.create().append("§8[§fTabooLib§8] §7TellrawJson Testing.")
        if (sender is Player) {
            json.newLine()
                    .append("§8[§fTabooLib§8] §7Hover Item: [")
                    .append(Items.getName(sender.inventory.itemInMainHand)).hoverItem(sender.inventory.itemInMainHand)
                    .append("§7]")
        }
        json.newLine()
                .append("§8[§fTabooLib§8] ")
                .append("§a[Suggest]").clickSuggest("/testTellrawJson")
                .append(" ")
                .append("§a[Command]").clickCommand("/testTellrawJson")
                .append(" ")
                .append("§a[Insertion]").clickInsertion("/testTellrawJson")
                .send(sender)
    }
}