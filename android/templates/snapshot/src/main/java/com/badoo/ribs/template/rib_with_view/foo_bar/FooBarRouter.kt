package com.badoo.ribs.template.rib_with_view.foo_bar

import com.badoo.ribs.core.BuildContext
import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.template.rib_with_view.foo_bar.FooBarRouter.Configuration
import com.badoo.ribs.template.rib_with_view.foo_bar.FooBarRouter.Configuration.Content
import com.badoo.ribs.template.rib_with_view.foo_bar.FooBarRouter.Configuration.Overlay
import com.badoo.ribs.template.rib_with_view.foo_bar.FooBarRouter.Configuration.Permanent
import kotlinx.android.parcel.Parcelize

class FooBarRouter(
    buildContext: BuildContext.Resolved<Nothing?>
): Router<Configuration, Permanent, Content, Overlay, FooBarView>(
    buildContext = buildContext,
    initialConfiguration = Content.Default,
    permanentParts = emptyList()
) {
    sealed class Configuration : Parcelable {
        sealed class Permanent : Configuration()
        sealed class Content : Configuration() {
            @Parcelize object Default : Content()
        }
        sealed class Overlay : Configuration()
    }

    override fun resolveConfiguration(configuration: Configuration): RoutingAction<FooBarView> =
        RoutingAction.noop()
}
