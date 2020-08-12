package com.phodal.gradroid.internal.variant

import com.phodal.gradroid.internal.tasks.Dex
import com.phodal.gradroid.internal.tasks.TaskManager

class ApkVariantOutputData(val taskManager: TaskManager): BaseVariantOutputData() {
    lateinit var dexTask: Dex
}