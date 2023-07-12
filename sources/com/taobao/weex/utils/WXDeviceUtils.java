package com.taobao.weex.utils;

import android.content.Context;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXDeviceUtils {
    public static boolean isAutoResize(Context context) {
        IWXFoldDeviceAdapter E = WXSDKManager.v().E();
        if (E == null) {
            return false;
        }
        return E.isFoldDevice() || E.isMateX() || E.isGalaxyFold();
    }
}
