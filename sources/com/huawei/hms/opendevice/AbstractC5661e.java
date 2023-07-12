package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.opendevice.e */
/* loaded from: classes10.dex */
public abstract class AbstractC5661e {
    public static String a(Context context, String str, String str2, String str3, String str4) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str4);
        if (!TextUtils.isEmpty(str3)) {
            grsBaseInfo.setAppName(str3);
        }
        String synGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl(str, str2);
        if (TextUtils.isEmpty(synGetGrsUrl)) {
            HMSLog.i("QueryGrs", "Query Grs base url is empty.");
            return "";
        }
        HMSLog.i("QueryGrs", "Query Grs base url success.");
        return synGetGrsUrl;
    }
}
