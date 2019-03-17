package io.skrot

import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment
import io.skrot.api.NamesComponent
import io.skrot.api.TestComponent

fun main(args: Array<String>) {
    SkrotApp().run(*args)
}

class SkrotApp : Application<SkrotConfig>() {
    override fun run(configuration: SkrotConfig, environment: Environment) {
        println("Running ${configuration.name}!")

        environment.objectMapper.registerModule(KotlinModule())

        environment.jersey().register(TestComponent())
        environment.jersey().register(NamesComponent())
    }
}

class SkrotConfig(val name: String = "Unknown") : Configuration()
