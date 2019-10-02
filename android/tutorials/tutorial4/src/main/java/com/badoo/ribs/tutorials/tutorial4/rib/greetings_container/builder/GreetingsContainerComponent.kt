package com.badoo.ribs.tutorials.tutorial4.rib.greetings_container.builder

import com.badoo.ribs.core.BuildContext
import com.badoo.ribs.core.Node
import com.badoo.ribs.tutorials.tutorial4.rib.greetings_container.GreetingsContainer
import com.badoo.ribs.tutorials.tutorial4.rib.hello_world.HelloWorld
import dagger.BindsInstance

@GreetingsContainerScope
@dagger.Component(
    modules = [GreetingsContainerModule::class],
    dependencies = [GreetingsContainer.Dependency::class]
)
internal interface GreetingsContainerComponent : HelloWorld.Dependency {

    @dagger.Component.Factory
    interface Factory {
        fun create(
            dependency: GreetingsContainer.Dependency,
            @BindsInstance buildContext: BuildContext.Resolved<Nothing?>
        ): GreetingsContainerComponent
    }

    fun node(): Node<Nothing>
}
