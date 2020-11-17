package io.izzel.taboolib.demo.testing

import org.bukkit.command.CommandSender

/**
 * ExamplePlugin
 * io.izzel.taboolib.demo.testing.TestModule
 *
 * @author bkm016
 * @since 2020/11/17 2:12 下午
 */
interface TestModule {

    fun eval(sender: CommandSender, args: Array<String>)
}