package com.youku.android.statistics;

import android.app.Application;
import androidx.annotation.Keep;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alipay.sdk.m.l.C4231b;
import com.ut.mini.IUTApplication;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;
import com.ut.mini.internal.UTTeamWork;
import com.youku.android.utils.OprLogUtils;
import com.youku.ups.data.RequestParams;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tb.pl2;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OprUtProxy {
    public static final String APPKEY_YOUKU = "23640594";
    public static int CUSTOM_EVENT_ID = 19999;
    private static final String TAG = "UtProxy";
    private static boolean sIsUseAppMonitor = false;
    private static boolean sIsUseUt = true;
    private UtEventSender mUtEventSender;
    private String mCcode = "";
    private String mAppId = "";
    private String mAppVersion = "";
    private String mClientIp = "";
    private String mUtdid = "";

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes8.dex */
    private static class Holder {
        private static final OprUtProxy instance = new OprUtProxy();

        private Holder() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface UtEventSender {
        void commit(Map<String, String> map, Map<String, Double> map2);

        void register(Set<String> set, Set<String> set2);

        void sendEvent(Map<String, String> map);
    }

    static {
        try {
            sIsUseAppMonitor = true;
        } catch (ClassNotFoundException unused) {
            sIsUseAppMonitor = false;
        }
        OprLogUtils.TLogPrint(TAG, "sIsUseAppMonitor: " + sIsUseAppMonitor);
    }

    protected OprUtProxy() {
    }

    public static OprUtProxy getInstance() {
        return Holder.instance;
    }

    public static boolean isIsUseAppMonitor() {
        return sIsUseAppMonitor;
    }

    public static void ut3init(Application application) {
    }

    public static void utInit(Application application, final String str) {
        if (sIsUseUt) {
            UTAnalytics.getInstance().setAppApplicationInstance(application, new IUTApplication() { // from class: com.youku.android.statistics.OprUtProxy.1
                @Override // com.ut.mini.IUTApplication
                public String getUTAppVersion() {
                    return "你应用的版本号";
                }

                @Override // com.ut.mini.IUTApplication
                public String getUTChannel() {
                    return "自定义的发布渠道";
                }

                @Override // com.ut.mini.IUTApplication
                public IUTCrashCaughtListner getUTCrashCraughtListener() {
                    return null;
                }

                @Override // com.ut.mini.IUTApplication
                public IUTRequestAuthentication getUTRequestAuthInstance() {
                    return new UTSecuritySDKRequestAuthentication(str);
                }

                @Override // com.ut.mini.IUTApplication
                public boolean isAliyunOsSystem() {
                    return false;
                }

                @Override // com.ut.mini.IUTApplication
                public boolean isUTCrashHandlerDisable() {
                    return false;
                }

                @Override // com.ut.mini.IUTApplication
                public boolean isUTLogEnable() {
                    return true;
                }
            });
        }
    }

    public static void utTestInit() {
        if (sIsUseUt) {
            HashMap hashMap = new HashMap();
            hashMap.put("debug_api_url", "http://muvp.alibaba-inc.com/online/UploadRecords.do");
            hashMap.put("debug_key", "23640594");
            UTTeamWork.getInstance().turnOnRealTimeDebug(hashMap);
        }
    }

    public void commit(String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        if (sIsUseAppMonitor) {
            DimensionValueSet create = DimensionValueSet.create();
            if (map != null) {
                create.setMap(map);
            }
            MeasureValueSet create2 = MeasureValueSet.create();
            if (map2 != null && map2.size() > 0) {
                for (String str3 : map2.keySet()) {
                    if (map2.get(str3) != null) {
                        create2.setValue(str3, map2.get(str3).doubleValue());
                    }
                }
            }
            AppMonitor.Stat.commit(str, str2, create, create2);
        } else if (this.mUtEventSender != null) {
            map.put("page", str);
            map.put(pl2.TAG_MONITOR_POINT, str2);
            map.put(UTDataCollectorNodeColumn.EVENT_ID, "65503");
            map.put("ccode", this.mCcode);
            map.put("app_id", this.mAppId);
            map.put("app_version", this.mAppVersion);
            map.put(RequestParams.client_ip, this.mClientIp);
            map.put("utdid", this.mUtdid);
            map.put(AdUtConstants.XAD_UT_ARG_COUNT, "1");
            map.put("noise", "0");
            this.mUtEventSender.commit(map, map2);
        }
    }

    public void register(String str, String str2, Set<String> set, Set<String> set2) {
        if (sIsUseAppMonitor) {
            AppMonitor.register(str, str2, MeasureSet.create(set), DimensionSet.create(set2));
        } else if (this.mUtEventSender != null) {
            set2.add("ccode");
            set2.add("page");
            set2.add(pl2.TAG_MONITOR_POINT);
            set2.add(UTDataCollectorNodeColumn.EVENT_ID);
            set2.add("app_id");
            set2.add("app_version");
            set2.add(RequestParams.client_ip);
            set2.add("utdid");
            set2.add(AdUtConstants.XAD_UT_ARG_COUNT);
            set2.add("noise");
            this.mUtEventSender.register(set2, set);
        }
    }

    public void sendCustomEvent(String str, String str2, String str3, String str4, long j, Map<String, String> map) {
        if (sIsUseUt) {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str3);
            uTCustomHitBuilder.setEventPage(str2);
            uTCustomHitBuilder.setDurationOnEvent(j);
            uTCustomHitBuilder.setProperties(map);
            (str == null ? UTAnalytics.getInstance().getDefaultTracker() : UTAnalytics.getInstance().getTrackerByAppkey(str)).send(uTCustomHitBuilder.build());
        } else if (this.mUtEventSender != null) {
            map.put("ccode", this.mCcode);
            map.put("app_id", this.mAppId);
            map.put("app_version", this.mAppVersion);
            map.put(RequestParams.client_ip, this.mClientIp);
            map.put("utdid", this.mUtdid);
            map.put(C4231b.h, str);
            map.put("page_name", str2);
            map.put(UTDataCollectorNodeColumn.EVENT_ID, String.valueOf(CUSTOM_EVENT_ID));
            map.put("event_name", str3);
            map.put("arg2", str4);
            map.put(UTDataCollectorNodeColumn.ARG3, String.valueOf(j));
            this.mUtEventSender.sendEvent(map);
        }
    }
}
