package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.framework.AILPAdapterFactory;
import com.youku.live.dago.widgetlib.ailpbaselib.protocol.AILPAnalyticsProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnalyticsUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int EVENT_ID = 19999;
    private static final String FLAG_FAIL = "0";
    private static final String FLAG_SUCCESS = "1";
    private static final String PAGE_NAME = "ailp_room";
    public static final String TAG = "AnalyticsUtils";

    public static void callbackFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1085916481")) {
            ipChange.ipc$dispatch("-1085916481", new Object[]{str, str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AgooConstants.MESSAGE_FLAG, "0");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("spm", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("error_failure_reason", str2);
        }
        if (getAdapter() != null && !TextUtils.isEmpty(str)) {
            getAdapter().customEvent(PAGE_NAME, 19999, null, null, null, hashMap);
        } else {
            ((ILog) Dsl.getService(ILog.class)).e(TAG, "spm == null");
        }
    }

    public static void callbackSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731399992")) {
            ipChange.ipc$dispatch("-1731399992", new Object[]{str});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AgooConstants.MESSAGE_FLAG, "1");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("spm", str);
        }
        if (getAdapter() != null && !TextUtils.isEmpty(str)) {
            getAdapter().customEvent(PAGE_NAME, 19999, null, null, null, hashMap);
        } else {
            ((ILog) Dsl.getService(ILog.class)).e(TAG, "spm == null");
        }
    }

    private static AILPAnalyticsProtocol getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-626180475") ? (AILPAnalyticsProtocol) ipChange.ipc$dispatch("-626180475", new Object[0]) : (AILPAnalyticsProtocol) AILPAdapterFactory.getInstance().createInterface(AILPAnalyticsProtocol.class);
    }
}
