package io.izzel.taboolib.demo.testing.impl

import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.tellraw.TellrawJson
import io.izzel.taboolib.util.book.BookFormatter
import io.izzel.taboolib.util.item.Books
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.BookMeta

class TestBooks : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            Books.create()
                    .write {
                        it.append("BookBuilder Page 1").hoverText("HoverText")
                    }
                    .write {
                        it.append("BookBuilder Page 2").hoverText("HoverText")
                    }.open(sender)
        }
    }
}