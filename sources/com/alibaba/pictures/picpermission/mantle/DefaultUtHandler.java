package com.alibaba.pictures.picpermission.mantle;

import com.alibaba.pictures.picpermission.custom.IUtHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/picpermission/mantle/DefaultUtHandler;", "Lcom/alibaba/pictures/picpermission/custom/IUtHandler;", "<init>", "()V", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class DefaultUtHandler implements IUtHandler {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.picpermission.custom.IUtHandler
    public void onPermissionDenied(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286127821")) {
            ipChange.ipc$dispatch("286127821", new Object[]{this, str});
        } else {
            b41.i(str, "permissions");
        }
    }

    @Override // com.alibaba.pictures.picpermission.custom.IUtHandler
    public void onPermissionGranted(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555672133")) {
            ipChange.ipc$dispatch("-555672133", new Object[]{this, str});
        } else {
            b41.i(str, "permissions");
        }
    }

    @Override // com.alibaba.pictures.picpermission.custom.IUtHandler
    public void onShowRationale(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720620013")) {
            ipChange.ipc$dispatch("720620013", new Object[]{this, str});
        } else {
            b41.i(str, "permissions");
        }
    }
}
