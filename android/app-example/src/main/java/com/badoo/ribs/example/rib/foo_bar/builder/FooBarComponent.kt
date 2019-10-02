package com.badoo.ribs.example.rib.foo_bar.builder

import com.badoo.ribs.core.BuildContext
import com.badoo.ribs.example.rib.foo_bar.FooBar
import com.badoo.ribs.example.rib.foo_bar.FooBarNode
import dagger.BindsInstance


@FooBarScope
@dagger.Component(
    modules = [FooBarModule::class],
    dependencies = [FooBar.Dependency::class]
)
internal interface FooBarComponent {

    @dagger.Component.Factory
    interface Factory {
        fun create(
            dependency: FooBar.Dependency,
            @BindsInstance customisation: FooBar.Customisation,
            @BindsInstance buildContext: BuildContext.Resolved<Nothing?>
        ): FooBarComponent
    }

    fun node(): FooBarNode
}

