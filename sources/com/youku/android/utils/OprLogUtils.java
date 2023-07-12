package com.youku.android.utils;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OprLogUtils {
    public static final String LOG_PREFIX = "OPR_v2_";

    public static void TLogPrint(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AdapterForTLog.logi(LOG_PREFIX + str, "TLogPrint: " + str2);
    }
}
