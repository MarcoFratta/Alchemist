/*
 * Copyright (C) 2010-2025, Danilo Pianini and contributors
 * listed, for each module, in the respective subproject's build.gradle.kts file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */

package it.unibo.alchemist.dsl

import it.unibo.alchemist.boundary.dsl.model.Incarnation
import it.unibo.alchemist.boundary.dsl.simulation
import it.unibo.alchemist.model.deployments.Grid
import it.unibo.alchemist.model.deployments.Point
import org.junit.jupiter.api.Test

class TestDeployments {

    @Test
    fun testDeployments() {
        val loader = simulation {
            incarnation = Incarnation.SAPERE
            environment(getDefault()) {
                deployments {
                    Point(environment, 0.0, 0.0)
                }
            }
        }

        loader.launch(loader.launcher)
    }

    @Test
    fun testMultipleDeployments() {
        val loader = simulation {
            incarnation = Incarnation.SAPERE
            environment(getDefault()) {
                deployments {
                    val point = Point(environment, 0.0, 0.0)
                    deploy(point)
                    deploy(Point(environment, 1.0, 1.0))
                }
            }
        }

        loader.launch(loader.launcher)
    }

    @Test
    fun testGridDeployment() {
        val loader = simulation {
            incarnation = Incarnation.SAPERE
            environment(getDefault()) {
                deployments {
                    val grid = Grid(
                        environment,
                        generator,
                        1.0,
                        1.0,
                        5.0,
                        5.0,
                        1.0,
                        1.0,
                    )
                    deploy(grid)
                }
            }
        }

        loader.launch(loader.launcher)
    }
}
