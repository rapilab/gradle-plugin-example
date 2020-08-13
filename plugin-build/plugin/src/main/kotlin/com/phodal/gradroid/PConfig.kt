package com.phodal.gradroid

import org.gradle.api.Named
import java.io.Serializable

class PConfig(name: String) : Serializable, Named {
    private val mName: String = name

    override fun getName(): String {
        return mName;
    }
}
