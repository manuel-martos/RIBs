package com.badoo.ribs.sandbox.rib.lorem_ipsum

import android.view.ViewGroup
import com.badoo.ribs.clienthelper.Connectable
import com.badoo.ribs.clienthelper.NodeConnector
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.builder.BuildParams
import com.badoo.ribs.core.plugin.Plugin
import com.badoo.ribs.sandbox.rib.lorem_ipsum.LoremIpsum.Input
import com.badoo.ribs.sandbox.rib.lorem_ipsum.LoremIpsum.Output

class LoremIpsumNode(
    buildParams: BuildParams<Nothing?>,
    viewFactory: (ViewGroup) -> LoremIpsumView,
    plugins: List<Plugin> = emptyList(),
    connector: NodeConnector<Input, Output> = NodeConnector()
): Node<LoremIpsumView>(
    buildParams = buildParams,
    viewFactory = viewFactory,
    plugins = plugins
), LoremIpsum, Connectable<Input, Output> by connector {

}