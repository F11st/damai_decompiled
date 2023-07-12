package com.alibaba.android.umbrella.trace;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.android.umbrella.trace.UmbrellaInfo;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import tb.kt2;
import tb.lt2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes15.dex */
public class UmbrellaTracker {
    public static final String ERROR_BUSINESS_TYPE = "UMBRELLA_ERROR";
    public static final String PURCHASE_MODULE = "Page_Trade_Govern";
    public static final String PURCHASE_POINT_POST = "_Service";
    public static final String PURCHASE_POINT_PRE = "Monitor_";
    private static HashMap<String, Integer> identifyMap = new HashMap<>();
    private static int currIndex = 1;
    private static Handler sHandler = new a(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof UmbrellaInfo) {
                UmbrellaInfo umbrellaInfo = (UmbrellaInfo) obj;
                Map<String, String> map = umbrellaInfo.args;
                String str2 = "";
                if (map != null) {
                    str2 = map.get("errorCode");
                    str = umbrellaInfo.args.get("errorMsg");
                } else {
                    str = "";
                }
                UmbrellaTracker.commitFailureStability(umbrellaInfo, str2, str);
            }
        }
    }

    public static void commitFailureStability(UmbrellaInfo umbrellaInfo, String str, String str2) {
        if (kt2.y() || lt2.b(str) || TextUtils.isEmpty(str) || umbrellaInfo == null || !kt2.m(umbrellaInfo, str)) {
            return;
        }
        AppMonitor.Alarm.commitFail(PURCHASE_MODULE, PURCHASE_POINT_PRE + umbrellaInfo.mainBizName + PURCHASE_POINT_POST, umbrellaInfo.toJsonString(), str, str2);
    }

    public static void commitSuccessStability(UmbrellaInfo umbrellaInfo) {
        if (kt2.B() || umbrellaInfo == null || TextUtils.isEmpty(umbrellaInfo.mainBizName) || !kt2.w(umbrellaInfo)) {
            return;
        }
        AppMonitor.Alarm.commitSuccess(PURCHASE_MODULE, PURCHASE_POINT_PRE + umbrellaInfo.mainBizName + PURCHASE_POINT_POST, umbrellaInfo.toJsonString());
    }

    private static String getIdentify(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        return str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + str3;
    }

    private static int getMessageIndex(String str) {
        Integer num = identifyMap.get(str);
        if (num == null) {
            num = Integer.valueOf(currIndex);
            identifyMap.put(str, Integer.valueOf(currIndex));
            currIndex++;
        }
        return num.intValue();
    }

    public static void traceProcessBegin(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7, long j) {
        if (kt2.y()) {
            return;
        }
        int messageIndex = getMessageIndex(getIdentify(str, str2, str3));
        UmbrellaInfo.b bVar = new UmbrellaInfo.b(str2, str3, str, str4, str5);
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", str6);
        hashMap.put("errorMsg", str7);
        bVar.b(hashMap);
        bVar.c(str3).b(map);
        Message obtainMessage = sHandler.obtainMessage(messageIndex);
        obtainMessage.obj = bVar.a();
        sHandler.removeMessages(messageIndex);
        sHandler.sendMessageDelayed(obtainMessage, j);
    }

    public static void traceProcessEnd(String str, String str2, String str3) {
        if (kt2.y()) {
            return;
        }
        sHandler.removeMessages(getMessageIndex(getIdentify(str, str2, str3)));
    }

    public static void commitSuccessStability(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (kt2.B()) {
            return;
        }
        UmbrellaInfo.b bVar = new UmbrellaInfo.b(str2, str3, str, str4, str5);
        bVar.c(str3).b(map);
        commitSuccessStability(bVar.a());
    }

    public static void commitFailureStability(String str, String str2, String str3, String str4, String str5, Map<String, String> map, String str6, String str7) {
        if (kt2.y()) {
            return;
        }
        UmbrellaInfo.b bVar = new UmbrellaInfo.b(str2, str3, str, str4, str5);
        bVar.c(str3).b(map);
        commitFailureStability(bVar.a(), str6, str7);
    }
}
