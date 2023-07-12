package com.youku.arch.v3.util.log;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class JsonLog {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void printJson(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206805069")) {
            ipChange.ipc$dispatch("206805069", new Object[]{str, str2, str3});
            return;
        }
        try {
            if (str2.startsWith(jn1.BLOCK_START_STR)) {
                str2 = new JSONObject(str2).toString(4);
            } else if (str2.startsWith(jn1.ARRAY_START_STR)) {
                str2 = new JSONArray(str2).toString(4);
            }
        } catch (JSONException unused) {
        }
        LogUtil.printLine(str, true);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String str4 = LogUtil.LINE_SEPARATOR;
        sb.append(str4);
        sb.append(str2);
        String[] split = sb.toString().split(str4);
        for (String str5 : split) {
            Log.d(str, "║ " + str5);
        }
        LogUtil.printLine(str, false);
    }
}
