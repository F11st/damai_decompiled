package com.ut.mini.internal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.module.appstatus.UTAppStatusCallbacks;
import java.util.HashMap;
import java.util.Map;
import tb.sj;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RealtimeDebugSwitch implements UTAppStatusCallbacks {
    private static final String DEBUG_DATE = "debug_date";
    private static final String TAG = "RealtimeDebugSwitch";
    private static final String UTRTD_NAME = "UTRealTimeDebug";
    private static int i;

    private void storeRealTimeDebugSharePreference(Map<String, String> map, boolean z) {
        try {
            SharedPreferences.Editor edit = sj.c().b().getSharedPreferences(UTRTD_NAME, 0).edit();
            if (map != null && z) {
                edit.putString("debug_api_url", map.get("debug_api_url"));
                edit.putString("debug_key", map.get("debug_key"));
                edit.putLong(DEBUG_DATE, System.currentTimeMillis());
            } else {
                edit.putLong(DEBUG_DATE, 0L);
            }
            edit.commit();
        } catch (Exception unused) {
        }
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        String scheme;
        if (i == 0) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                Logger.v(TAG, "i", Integer.valueOf(i));
                return;
            }
            Uri data = intent.getData();
            if (data == null || (scheme = data.getScheme()) == null || !scheme.startsWith("ut.")) {
                return;
            }
            Logger.v(TAG, "scheme", scheme);
            String queryParameter = data.getQueryParameter("debugkey");
            String queryParameter2 = data.getQueryParameter("from");
            if (scheme.startsWith("ut.")) {
                HashMap hashMap = new HashMap();
                hashMap.put("debug_api_url", "http://muvp.alibaba-inc.com/online/UploadRecords.do");
                if (queryParameter == null) {
                    hashMap.put("debug_key", "");
                } else {
                    hashMap.put("debug_key", queryParameter);
                }
                if (queryParameter2 == null) {
                    hashMap.put("from", "");
                } else {
                    hashMap.put("from", queryParameter2);
                }
                if (!TextUtils.isEmpty(data.getQueryParameter("store"))) {
                    storeRealTimeDebugSharePreference(hashMap, true);
                    hashMap.put("debug_store", "true");
                } else {
                    storeRealTimeDebugSharePreference(hashMap, false);
                }
                hashMap.put("debug_sampling_option", "true");
                UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
            }
        }
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        i--;
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        i++;
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchBackground() {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchForeground() {
    }
}
