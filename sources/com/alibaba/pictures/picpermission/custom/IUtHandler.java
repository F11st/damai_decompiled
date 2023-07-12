package com.alibaba.pictures.picpermission.custom;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/picpermission/custom/IUtHandler;", "", "", "permissions", "Ltb/wt2;", "onPermissionGranted", "onPermissionDenied", "onShowRationale", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IUtHandler {
    void onPermissionDenied(@NotNull String str);

    void onPermissionGranted(@NotNull String str);

    void onShowRationale(@NotNull String str);
}
