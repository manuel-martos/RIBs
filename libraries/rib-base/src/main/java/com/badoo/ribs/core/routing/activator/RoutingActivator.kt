package com.badoo.ribs.core.routing.activator

import android.os.Parcelable
import com.badoo.ribs.core.ActivationMode
import com.badoo.ribs.core.Node
import com.badoo.ribs.core.routing.history.Routing

internal class RoutingActivator<C : Parcelable>(
    private val parentNode: Node<*>,
    private val clientActivator: ChildActivator<C>
) {
    private val defaultActivator: ChildActivator<C> =
        DefaultChildActivator()

    fun add(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            parentNode.attachChildNode(child)
        }
    }

    fun remove(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            parentNode.detachChildView(child)
            parentNode.detachChildNode(child)
        }
    }

    fun activate(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            when (child.activationMode) {
                ActivationMode.ATTACH_TO_PARENT -> defaultActivator.activate(routing, child)
                ActivationMode.CLIENT -> clientActivator.activate(routing, child)
                ActivationMode.BY_ROUTING_ACTION -> Unit // intended to be no-op
            }
        }
    }

    fun deactivate(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            when (child.activationMode) {
                ActivationMode.ATTACH_TO_PARENT -> defaultActivator.deactivate(routing, child)
                ActivationMode.CLIENT -> clientActivator.deactivate(routing, child)
                ActivationMode.BY_ROUTING_ACTION -> Unit // intended to be no-op
            }
        }
    }

    fun onTransitionAdd(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            child.markPendingDetach(false)
        }
    }

    fun onTransitionRemove(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            child.markPendingDetach(true)
        }
    }

    fun onTransitionActivate(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            child.markPendingViewDetach(false)
        }
    }

    fun onTransitionDeactivate(routing: Routing<C>, nodes: List<Node<*>>) {
        nodes.forEach { child ->
            child.markPendingViewDetach(true)
        }
    }
}