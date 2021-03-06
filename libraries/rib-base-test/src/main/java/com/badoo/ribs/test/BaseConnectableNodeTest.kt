package com.badoo.ribs.test

@Suppress("FunctionNaming", "IllegalIdentifier")
abstract class BaseConnectableNodeTest {

    abstract fun `WHEN_child_emit_some_output_before_it_is_attached_to_parent_THEN_parent_receive_the_output_after_child_attach_finished`()

    abstract fun `WHEN_child_is_attached_and_emit_some_output_THEN_parent_receive_the_exact_output`()

    abstract fun `WHEN_child_emit_multiple_outputs_before_it_is_attached_to_parent_THEN_parent_receive_the_output_after_attach_finished_in_correct_order`()

    abstract fun `WHEN_child_emit_output_before_it_is_attached_to_parent_and_then_after_it_is_attached_to_parent_THEN_parent_receive_the_output_in_correct_order`()
}
