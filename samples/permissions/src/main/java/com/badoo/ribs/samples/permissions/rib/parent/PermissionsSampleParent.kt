package com.badoo.ribs.samples.permissions.rib.parent

import com.badoo.ribs.android.permissionrequester.CanProvidePermissionRequester
import com.badoo.ribs.core.Rib

interface PermissionsSampleParent : Rib {

    interface Dependency : CanProvidePermissionRequester
}
