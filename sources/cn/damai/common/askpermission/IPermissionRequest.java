package cn.damai.common.askpermission;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface IPermissionRequest {
    IPermissionRequest onDenied(IPermissionAction iPermissionAction);

    IPermissionRequest onGranted(IPermissionAction iPermissionAction);

    void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    IPermissionRequest permission(@NonNull String... strArr);

    IPermissionRequest showRationale(IRationale iRationale);

    void start();
}
