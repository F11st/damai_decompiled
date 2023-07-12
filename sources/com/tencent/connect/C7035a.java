package com.tencent.connect;

import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/* compiled from: Taobao */
/* renamed from: com.tencent.connect.a */
/* loaded from: classes11.dex */
public class C7035a {
    public static boolean a(String str, IUiListener iUiListener) {
        return a(str, iUiListener, -6, Constants.MSG_PERMISSION_NOT_GRANTED, Constants.MSG_PERMISSION_NOT_GRANTED);
    }

    public static boolean a(String str, IUiListener iUiListener, int i, String str2, String str3) {
        if (Tencent.isPermissionNotGranted()) {
            SLog.i(str, "permission not granted");
            if (iUiListener != null) {
                iUiListener.onError(new UiError(i, str2, str3));
                return true;
            }
            return true;
        }
        return false;
    }
}
