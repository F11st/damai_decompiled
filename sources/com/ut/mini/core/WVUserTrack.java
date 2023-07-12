package com.ut.mini.core;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.util.Log;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHybridHelper;
import com.ut.mini.internal.UTTeamWork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WVUserTrack extends WVApiPlugin {
    private boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    private Map<String, String> transStringToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!yh2.f(next)) {
                    String string = jSONObject.getString(next);
                    if (!yh2.f(string)) {
                        hashMap.put(next, string);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("toUT".equals(str)) {
            toUT(str2, wVCallBackContext);
            return true;
        } else if ("toUT2".equalsIgnoreCase(str)) {
            toUT2(str2, wVCallBackContext);
            return true;
        } else if ("turnOnUTRealtimeDebug".equals(str)) {
            turnOnUTRealtimeDebug(str2, wVCallBackContext);
            return true;
        } else if ("turnOffUTRealtimeDebug".equals(str)) {
            turnOffUTRealtimeDebug(str2, wVCallBackContext);
            return true;
        } else if ("turnOnRealtimeDebug".equals(str)) {
            turnOnAppMonitorRealtimeDebug(str2, wVCallBackContext);
            return true;
        } else if ("turnOffRealtimeDebug".equals(str)) {
            turnOffAppMonitorRealtimeDebug(str2, wVCallBackContext);
            return true;
        } else if ("selfCheck".equals(str)) {
            selfCheck(str2, wVCallBackContext);
            return true;
        } else if ("skipPage".equals(str)) {
            Logger.f("WVUserTrack", "skipPage");
            try {
                UTAnalytics.getInstance().getDefaultTracker().skipPage(this.mContext);
            } catch (Throwable unused) {
            }
            return true;
        } else if ("updateNextPageUtparam".equals(str)) {
            Logger.f("WVUserTrack", "updateNextPageUtparam params", str2);
            try {
                UTAnalytics.getInstance().getDefaultTracker().updateNextPageUtparam(str2);
                wVCallBackContext.success();
            } catch (Throwable unused2) {
                wVCallBackContext.error();
            }
            return true;
        } else if ("updateSessionProperties".equals(str)) {
            Logger.f("WVUserTrack", "updateSessionProperties params", str2);
            try {
                UTAnalytics.getInstance().updateSessionProperties(transStringToMap(str2));
                wVCallBackContext.success();
            } catch (Throwable unused3) {
                wVCallBackContext.error();
            }
            return true;
        } else {
            return false;
        }
    }

    public final void selfCheck(String str, WVCallBackContext wVCallBackContext) {
        if (isEmpty(str)) {
            return;
        }
        try {
            String obj = JSON.parseObject(str).get("utap_sample").toString();
            Log.i("selfCheck", "utap_sample:" + obj);
            String selfCheck = UTAnalytics.getInstance().selfCheck(obj);
            Log.i("selfCheck", "result:" + selfCheck);
            WVResult wVResult = new WVResult();
            wVResult.addData("result", selfCheck);
            wVCallBackContext.success(wVResult);
        } catch (com.alibaba.fastjson.JSONException unused) {
            wVCallBackContext.error();
        }
    }

    public final void toUT(String str, WVCallBackContext wVCallBackContext) {
        Map<String, String> transStringToMap;
        if (this.mContext != null && (transStringToMap = transStringToMap(str)) != null) {
            UTHybridHelper.getInstance().h5UT(transStringToMap, this.mContext);
        }
        wVCallBackContext.success();
    }

    public void toUT2(String str, WVCallBackContext wVCallBackContext) {
        Map<String, String> transStringToMap;
        if (this.mContext != null && (transStringToMap = transStringToMap(str)) != null) {
            UTHybridHelper.getInstance().h5UT2(transStringToMap, this.mContext);
        }
        wVCallBackContext.success();
    }

    public final void turnOffAppMonitorRealtimeDebug(String str, WVCallBackContext wVCallBackContext) {
        try {
            AppMonitor.turnOffRealTimeDebug();
        } catch (com.alibaba.fastjson.JSONException unused) {
            wVCallBackContext.error();
        }
        wVCallBackContext.success();
    }

    public final void turnOffUTRealtimeDebug(String str, WVCallBackContext wVCallBackContext) {
        try {
            UTTeamWork.getInstance().turnOffRealTimeDebug();
        } catch (com.alibaba.fastjson.JSONException unused) {
            wVCallBackContext.error();
        }
        wVCallBackContext.success();
    }

    public final void turnOnAppMonitorRealtimeDebug(String str, WVCallBackContext wVCallBackContext) {
        if (!isEmpty(str)) {
            try {
                com.alibaba.fastjson.JSONObject parseObject = JSON.parseObject(str);
                Set<String> keySet = parseObject.keySet();
                HashMap hashMap = new HashMap();
                if (keySet != null && keySet.size() > 0) {
                    for (String str2 : keySet) {
                        hashMap.put(str2, parseObject.get(str2).toString());
                    }
                    AppMonitor.turnOnRealTimeDebug(hashMap);
                }
            } catch (com.alibaba.fastjson.JSONException unused) {
                wVCallBackContext.error();
            }
        }
        wVCallBackContext.success();
    }

    public final void turnOnUTRealtimeDebug(String str, WVCallBackContext wVCallBackContext) {
        if (!isEmpty(str)) {
            try {
                com.alibaba.fastjson.JSONObject parseObject = JSON.parseObject(str);
                Set<String> keySet = parseObject.keySet();
                HashMap hashMap = new HashMap();
                if (keySet != null && keySet.size() > 0) {
                    for (String str2 : keySet) {
                        hashMap.put(str2, parseObject.get(str2).toString());
                    }
                    UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
                }
            } catch (com.alibaba.fastjson.JSONException unused) {
                wVCallBackContext.error();
            }
        }
        wVCallBackContext.success();
    }
}
