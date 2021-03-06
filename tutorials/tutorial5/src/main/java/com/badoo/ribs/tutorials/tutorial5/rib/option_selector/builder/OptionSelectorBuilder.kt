package com.badoo.ribs.tutorials.tutorial5.rib.option_selector.builder

import com.badoo.ribs.builder.SimpleBuilder
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.modality.BuildParams
import com.badoo.ribs.tutorials.tutorial5.rib.option_selector.OptionSelector
import com.badoo.ribs.tutorials.tutorial5.rib.option_selector.OptionSelectorView

class OptionSelectorBuilder(
    private val dependency: OptionSelector.Dependency
) : SimpleBuilder<Node<OptionSelectorView>>() {

    override fun build(buildParams: BuildParams<Nothing?>): Node<OptionSelectorView> =
        DaggerOptionSelectorComponent
            .factory()
            .create(
                buildParams = buildParams,
                dependency = dependency,
                customisation = OptionSelector.Customisation()
            )
            .node()
}
