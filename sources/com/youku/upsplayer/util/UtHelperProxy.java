package com.youku.upsplayer.util;

import android.app.Application;
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
import com.youku.ups.data.RequestParams;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tb.pl2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UtHelperProxy {
    public static final String APPKEY_YOUKU = "23640594";
    private static int CUSTOM_EVENT_ID = 19999;
    private static boolean sIsUseAppMonitor = false;
    private static boolean sIsUseUt = true;
    private String mAppId;
    private String mAppVersion;
    private String mCcode;
    private String mClientIp;
    private UtEventSender mUtEventSender;
    private String mUtdid;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class Holder {
        private static final UtHelperProxy instance = new UtHelperProxy();

        private Holder() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
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
    }

    private UtHelperProxy() {
        this.mCcode = "";
        this.mAppId = "";
        this.mAppVersion = "";
        this.mClientIp = "";
        this.mUtdid = "";
    }

    public static UtHelperProxy getInstance() {
        return Holder.instance;
    }

    public static void ut3init(Application application) {
    }

    public static void utInit(Application application, final String str) {
        if (sIsUseUt) {
            UTAnalytics.getInstance().setAppApplicationInstance(application, new IUTApplication() { // from class: com.youku.upsplayer.util.UtHelperProxy.1
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
            MeasureValueSet measureValueSet = null;
            if (map2 != null && map2.size() > 0) {
                measureValueSet = MeasureValueSet.create();
                for (String str3 : map2.keySet()) {
                    if (map2.get(str3) != null) {
                        measureValueSet.setValue(str3, map2.get(str3).doubleValue());
                    }
                }
            }
            AppMonitor.Stat.commit(str, str2, create, measureValueSet);
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

    public void init(String str, String str2, String str3, String str4, String str5, UtEventSender utEventSender) {
        this.mCcode = str;
        this.mAppId = str2;
        this.mAppVersion = str3;
        this.mClientIp = str4;
        this.mUtdid = str5;
        this.mUtEventSender = utEventSender;
    }

    public void register(String str, String str2, Set<String> set, Set<String> set2) {
        if (sIsUseAppMonitor) {
            AppMonitor.register(str, str2, MeasureSet.create(set2), DimensionSet.create(set));
        } else if (this.mUtEventSender != null) {
            set.add("ccode");
            set.add("page");
            set.add(pl2.TAG_MONITOR_POINT);
            set.add(UTDataCollectorNodeColumn.EVENT_ID);
            set.add("app_id");
            set.add("app_version");
            set.add(RequestParams.client_ip);
            set.add("utdid");
            set.add(AdUtConstants.XAD_UT_ARG_COUNT);
            set.add("noise");
            this.mUtEventSender.register(set, set2);
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
            if (map == null) {
                map = new HashMap<>();
            }
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
