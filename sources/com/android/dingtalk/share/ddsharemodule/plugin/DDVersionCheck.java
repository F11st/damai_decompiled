package com.android.dingtalk.share.ddsharemodule.plugin;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DDVersionCheck {
    public static int getSdkVersionFromMetaData(Context context, int i) {
        int innerGetSdkVersionFromMetaData = innerGetSdkVersionFromMetaData(context, ShareConstant.DD_APP_PACKAGE, -1);
        return innerGetSdkVersionFromMetaData == -1 ? innerGetSdkVersionFromMetaData(context, ShareConstant.ALI_DD_APP_PACKAGE, i) : innerGetSdkVersionFromMetaData;
    }

    private static int innerGetSdkVersionFromMetaData(Context context, String str, int i) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            if (bundle != null) {
                return bundle.getInt(ShareConstant.DD_SDK_VERSION_META_KEY);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
        return i;
    }
}
