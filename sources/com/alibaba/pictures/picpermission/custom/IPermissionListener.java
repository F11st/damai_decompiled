package com.alibaba.pictures.picpermission.custom;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001f\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/alibaba/pictures/picpermission/custom/IPermissionListener;", "", "Ltb/wt2;", "onPermissionGranted", "", "", "permission", "onPermissionDenied", "([Ljava/lang/String;)V", "deniedPermissions", "onShowRationale", "permission_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IPermissionListener {
    void onPermissionDenied(@NotNull String[] strArr);

    void onPermissionGranted();

    void onShowRationale(@NotNull String[] strArr);
}
