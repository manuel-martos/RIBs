package com.badoo.ribs.samples.simplerouting.app

import android.os.Bundle
import android.view.ViewGroup
import com.badoo.ribs.android.RibActivity
import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.modality.BuildContext
import com.badoo.ribs.samples.simplerouting.rib.simple_routing_parent.SimpleRoutingParent
import com.badoo.ribs.samples.simplerouting.rib.simple_routing_parent.builder.SimpleRoutingParentBuilder

class RootActivity : RibActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_root)
        super.onCreate(savedInstanceState)
    }

    override val rootViewGroup: ViewGroup
        get() = findViewById(R.id.root)

    override fun createRib(savedInstanceState: Bundle?): Rib =
        SimpleRoutingParentBuilder(
            object : SimpleRoutingParent.Dependency {}
        ).build(
            BuildContext.root(savedInstanceState)
        )
}
