package io.izzel.taboolib.demo.testing.impl

import com.google.common.collect.Lists
import io.izzel.taboolib.common.listener.ListenerCommand
import io.izzel.taboolib.demo.testing.TestModule
import io.izzel.taboolib.module.tellraw.TellrawJson
import io.izzel.taboolib.util.lite.Effects
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.util.NumberConversions
import org.bukkit.util.Vector

class TestEffects : TestModule {

    override fun eval(sender: CommandSender, args: Array<String>) {
        if (sender is Player) {
            if (args.size < 2) {
                sender.sendMessage("§8[§fTabooLib§8] §7Effects:")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f LINE-[interval]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f POLYGON-[radius]-[interval]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CIRCLE-[radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CONE-[height]-[radius]-[rate]-[circle rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f ATOM-[orbits]-[radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f ELLIPSE-[radius]-[other radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f INFINITY-[radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CRESCENT-[radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f WARE_FUNCTION-[extend]-[height range]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CYLINDER-[height]-[radius]-[rate]-[interval]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f SPHERE-[radius]-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f SPHERE_SPIKE-[radius]-[rate]-[chance]-[min]-[max]-[interval]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f RING-[rate]-[tube rate]-[radius]-[tube radius]")
                TellrawJson.create().append("§8[§fTabooLib§8] §7-§f LIGHTING-").append("§c[...]").hoverText("[rate]-[direction]-[entries]-[branches]-[radius]-[offset]-[offset rate]-[length]-[length rate]-[branch]-[branch rate]").send(sender)
                sender.sendMessage("§8[§fTabooLib§8] §7-§f DNA-[radius]-[rate]-[extension]-[height]-[hydrogen bond dist]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f RECTANGLE-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CAGE-[rate]-[bar rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CUBE-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CUBE_FILLED-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f CUBE_STRUCTURED-[rate]")
                sender.sendMessage("§8[§fTabooLib§8] §7-§f HYPERCUBE-[rate]-[size rate]-[cubes]")
                return
            }
            val a: List<String> = Lists.newArrayList(*args[1].toUpperCase().split("-".toRegex()).toTypedArray())
            val locA: Location = sender.eyeLocation
            val locB: Location = sender.eyeLocation.add(sender.location.direction.multiply(10)).add(Vector.getRandom().multiply(5))
            val action1 = java.util.function.Consumer { loc: Location? -> Effects.create(Particle.FLAME, loc).count(1).player(sender).play() }
            val action2 = java.util.function.Consumer { loc: Location? -> Effects.create(Particle.VILLAGER_HAPPY, loc).count(1).player(sender).play() }
            when (a[0]) {
                "LINE" -> {
                    Effects.buildLine(locA, locB, action1, orDob(a, 1, 0.1))
                }
                "POLYGON" -> {
                    Effects.buildPolygon(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "CIRCLE" -> {
                    Effects.buildCircle(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "CONE" -> {
                    Effects.buildCone(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), orDob(a, 4, 10.0), action1)
                }
                "ATOM" -> {
                    Effects.buildAtom(locA, orInt(a, 1, 10), orDob(a, 2, 10.0), orDob(a, 3, 10.0), action1, action2)
                }
                "ELLIPSE" -> {
                    Effects.buildEllipse(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), action1)
                }
                "INFINITY" -> {
                    Effects.buildInfinity(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "CRESCENT" -> {
                    Effects.buildCrescent(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "WARE_FUNCTION" -> {
                    Effects.buildWaveFunction(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), orDob(a, 4, 10.0), action1)
                }
                "CYLINDER" -> {
                    Effects.buildCylinder(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), orDob(a, 4, 10.0), action1)
                }
                "SPHERE" -> {
                    Effects.buildSphere(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "SPHERE_SPIKE" -> {
                    Effects.buildSphereSpike(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orInt(a, 3, 10), orDob(a, 4, 10.0), orDob(a, 5, 10.0), orDob(a, 6, 10.0), action1)
                }
                "RING" -> {
                    Effects.buildRing(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), orDob(a, 4, 10.0), action1)
                }
                "LIGHTING" -> {
                    Effects.buildLightning(locA, locA.direction, orInt(a, 1, 10), orInt(a, 2, 10), orDob(a, 3, 10.0), orDob(a, 4, 10.0), orDob(a, 5, 10.0), orDob(a, 6, 10.0), orDob(a, 7, 10.0), orDob(a, 8, 10.0), orDob(a, 9, 10.0), action1)
                }
                "DNA" -> {
                    Effects.buildDNA(locA, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orDob(a, 3, 10.0), orInt(a, 4, 10), orInt(a, 5, 10), action1, action2)
                }
                "RECTANGLE" -> {
                    Effects.buildRectangle(locA, locB, orDob(a, 1, 10.0), action1)
                }
                "CAGE" -> {
                    Effects.buildCage(locA, locB, orDob(a, 1, 10.0), orDob(a, 2, 10.0), action1)
                }
                "CUBE" -> {
                    Effects.buildCube(locA, locB, orDob(a, 1, 10.0), action1)
                }
                "CUBE_FILLED" -> {
                    Effects.buildCubeFilled(locA, locB, orDob(a, 1, 10.0), action1)
                }
                "CUBE_STRUCTURED" -> {
                    Effects.buildCubeStructured(locA, locB, orDob(a, 1, 10.0), action1)
                }
                "HYPERCUBE" -> {
                    Effects.buildHypercube(locA, locB, orDob(a, 1, 10.0), orDob(a, 2, 10.0), orInt(a, 3, 10), action1)
                }
                else -> sender.sendMessage("§8[§fTabooLib§8] §7No Effect.")
            }
        }
    }

    private fun orInt(list: List<String>, index: Int, def: Int): Int {
        return if (list.size > index) NumberConversions.toInt(list[index]) else def
    }

    private fun orDob(list: List<String>, index: Int, def: Double): Double {
        return if (list.size > index) NumberConversions.toDouble(list[index]) else def
    }
}