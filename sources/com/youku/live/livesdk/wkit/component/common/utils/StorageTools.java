package com.youku.live.livesdk.wkit.component.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class StorageTools {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ANALYTICS_AGENT_CACHE = "analytics_agent_cache_";
    private static final String ANALYTICS_AGENT_HEADER = "analytics_agent_header_";
    private static final String ANALYTICS_AGENT_STATE = "analytics_agent_state_";
    private static final String COUNTER_CACHE = "counter";
    private static final String NUMBER = "n2";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SharedPreferences getAgentState(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1022574081")) {
            return (SharedPreferences) ipChange.ipc$dispatch("1022574081", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(ANALYTICS_AGENT_STATE + context.getPackageName(), 0);
    }

    public static String getHeaderPreference(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1841856717") ? (String) ipChange.ipc$dispatch("1841856717", new Object[]{context, str}) : context == null ? "" : context.getSharedPreferences(ANALYTICS_AGENT_HEADER, 0).getString(str, "");
    }

    public static void savePreference(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987152441")) {
            ipChange.ipc$dispatch("-1987152441", new Object[]{context, str, str2});
        } else if (context == null) {
        } else {
            context.getSharedPreferences(ANALYTICS_AGENT_HEADER, 0).edit().putString(str, str2).commit();
        }
    }
}
