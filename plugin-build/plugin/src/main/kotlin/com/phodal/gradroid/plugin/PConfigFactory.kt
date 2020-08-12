package com.phodal.gradroid.plugin

import com.phodal.gradroid.PConfig
import org.gradle.api.NamedDomainObjectFactory
import org.gradle.internal.reflect.Instantiator

class PConfigFactory(private val instantiator: Instantiator) : NamedDomainObjectFactory<PConfig> {
    override fun create(name: String): PConfig {
        return instantiator.newInstance(PConfig::class.java, name)
    }

}
