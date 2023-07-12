package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.UTMCLogFields;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.ut.mini.UTConstants;
import com.ut.mini.exposure.ExposureUtils;
import com.ut.mini.exposure.TrackerFrameLayout;
import com.ut.mini.module.plugin.UTPlugin;
import com.ut.mini.module.plugin.UTPluginMgr;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import com.ut.mini.module.util.ReadonlyMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.C9225hn;
import tb.et2;
import tb.ft2;
import tb.hl2;
import tb.sj;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTTracker {
    public static final int PAGE_STATUS_CODE_302 = 1;
    private static final String TAG = "UTTracker";
    private static List<String> s_logfield_cache;
    private static Pattern s_p = Pattern.compile("(\\|\\||[\t\r\n]|\u0001|\u0000)+");
    private String mTrackerId = null;
    private Map<String, String> mArgsMap = new ConcurrentHashMap();
    private String mAppkey = null;

    static {
        s_logfield_cache = null;
        s_logfield_cache = new ArrayList(34);
        for (LogField logField : LogField.values()) {
            s_logfield_cache.add(String.valueOf(logField).toLowerCase());
        }
    }

    private static void dropAllIllegalKey(Map<String, String> map) {
        if (map != null) {
            map.remove(LogField.IMEI.toString());
            map.remove(LogField.IMSI.toString());
            map.remove(LogField.CARRIER.toString());
            map.remove(LogField.ACCESS.toString());
            map.remove(LogField.ACCESS_SUBTYPE.toString());
            map.remove(LogField.CHANNEL.toString());
            map.remove(LogField.LL_USERNICK.toString());
            map.remove(LogField.USERNICK.toString());
            map.remove(LogField.LL_USERID.toString());
            map.remove(LogField.USERID.toString());
            map.remove(LogField.SDKVERSION.toString());
            map.remove(LogField.START_SESSION_TIMESTAMP.toString());
            map.remove(LogField.UTDID.toString());
            map.remove(LogField.SDKTYPE.toString());
            map.remove(LogField.RESERVE2.toString());
            map.remove(LogField.RESERVE3.toString());
            map.remove(LogField.RESERVE4.toString());
            map.remove(LogField.RESERVE5.toString());
            map.remove(LogField.RESERVES.toString());
        }
    }

    private void fillReserve1Fields(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), C9225hn.SDK_TYPE);
        if (!TextUtils.isEmpty(this.mAppkey)) {
            map.put(LogField.APPKEY.toString(), this.mAppkey);
        } else {
            map.put(LogField.APPKEY.toString(), sj.c().a());
        }
    }

    private static void fillReservesFields(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("_track_id")) {
            String str = map.get("_track_id");
            map.remove("_track_id");
            if (!yh2.f(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(LogField.RESERVES.toString(), yh2.a(hashMap));
        }
        LogField logField = LogField.PAGE;
        if (map.containsKey(logField.toString())) {
            return;
        }
        map.put(logField.toString(), BizTime.UT);
    }

    private static Map<String, Object> parseJsonToMap(String str) {
        try {
            return (Map) JSON.parseObject(str, Map.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processPluginMap(UTPlugin uTPlugin, Map<String, String> map, String str, int i, String str2, String str3, String str4, Map<String, String> map2) {
        Map<String, String> onEventDispatch;
        if (!UTPlugin.isEventIDInRange(uTPlugin.getAttentionEventIds(), i) || (onEventDispatch = uTPlugin.onEventDispatch(str, i, str2, str3, str4, map2)) == null || onEventDispatch.size() <= 0) {
            return;
        }
        Logger.f(TAG, "UTPlugin", uTPlugin.getPluginName(), "PluginArgs", onEventDispatch);
        String str5 = "";
        for (Map.Entry<String, String> entry : onEventDispatch.entrySet()) {
            String key = entry.getKey();
            if (!s_logfield_cache.contains(String.valueOf(key).toLowerCase())) {
                if (UTPluginMgr.getInstance().getUTPluginConfigMgr().isWritableKey(uTPlugin, key)) {
                    map.put(key, entry.getValue());
                }
                if ("utparam-cnt".equals(key)) {
                    str5 = onEventDispatch.get(key);
                }
            }
        }
        if (TextUtils.isEmpty(str5)) {
            return;
        }
        try {
            Map<String, Object> parseJsonToMap = parseJsonToMap(str5);
            if (parseJsonToMap != null && parseJsonToMap.size() >= 1) {
                Iterator<Map.Entry<String, Object>> it = parseJsonToMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (!UTPluginMgr.getInstance().getUTPluginConfigMgr().isWritableUtparamCnt(uTPlugin, it.next().getKey())) {
                        it.remove();
                    }
                }
                if (parseJsonToMap.size() < 1) {
                    return;
                }
                String str6 = map.get("utparam-cnt");
                if (TextUtils.isEmpty(str6)) {
                    map.put("utparam-cnt", JSON.toJSONString(parseJsonToMap));
                    return;
                }
                Map<String, Object> parseJsonToMap2 = parseJsonToMap(str6);
                if (parseJsonToMap2 != null && parseJsonToMap2.size() >= 1) {
                    parseJsonToMap2.putAll(parseJsonToMap);
                    map.put("utparam-cnt", JSON.toJSONString(parseJsonToMap2));
                    return;
                }
                map.put("utparam-cnt", JSON.toJSONString(parseJsonToMap));
            }
        } catch (Exception e) {
            if (Logger.n()) {
                Logger.h(TAG, e, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLog(Map<String, String> map, int i) {
        String str;
        if (i == 2201) {
            try {
                str = map.get(LogField.PAGE.toString());
            } catch (Exception unused) {
                str = "";
            }
            if (RepeatExposurePageMgr.getInstance().isRepeatExposurePage(str)) {
                RepeatExposureQueueMgr.getInstance().putExposureEvent(map);
                return;
            }
        }
        if (i == 2001) {
            UTPageHitHelper.encodeUtParam(map);
        }
        UTAnalytics.getInstance().transferLog(map);
    }

    private static void translateFieldsName(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey("_field_os")) {
                map.remove("_field_os");
                map.put(LogField.OS.toString(), map.get("_field_os"));
            }
            if (map.containsKey("_field_os_version")) {
                map.remove("_field_os_version");
                map.put(LogField.OSVERSION.toString(), map.get("_field_os_version"));
            }
        }
    }

    public void addTPKCache(String str, String str2) {
        et2.e().c(str, str2);
    }

    public void addTPKItem(ft2 ft2Var) {
        et2.e().d(ft2Var);
    }

    public void commitExposureData() {
        TrackerFrameLayout.commitExposureData();
    }

    public synchronized String getGlobalProperty(String str) {
        if (str != null) {
            return this.mArgsMap.get(str);
        }
        return null;
    }

    public Map<String, String> getPageAllProperties(Activity activity) {
        return UTPageHitHelper.getInstance().getPageAllProperties(activity);
    }

    public Map<String, String> getPageProperties(Object obj) {
        return UTPageHitHelper.getInstance().getPageProperties(obj);
    }

    public String getPageScmPre(Activity activity) {
        return UTPageHitHelper.getInstance().getPageScmPre(activity);
    }

    public String getPageSpmPre(Activity activity) {
        return UTPageHitHelper.getInstance().getPageSpmPre(activity);
    }

    public String getPageSpmUrl(Activity activity) {
        return UTPageHitHelper.getInstance().getPageSpmUrl(activity);
    }

    public void pageAppear(Object obj) {
        pageAppear(obj, null, false);
    }

    public void pageAppearDonotSkip(Object obj) {
        pageAppear(obj, null, true);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj, this);
    }

    public void refreshExposureData() {
        TrackerFrameLayout.refreshExposureData();
    }

    public void refreshExposureDataByViewId(String str, String str2) {
        TrackerFrameLayout.refreshExposureDataByViewId(str, str2);
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            this.mArgsMap.remove(str);
        }
    }

    public void send(Map<String, String> map) {
        if (!UTAnalytics.getInstance().isInit()) {
            Logger.i(TAG, "send", "Please initialize UT-Analytics first");
        } else if (map == null) {
            Logger.i(TAG, "send", "aLogMap is null");
        } else {
            try {
                final int intValue = Integer.valueOf(map.get(LogField.EVENTID.toString())).intValue();
                if (!map.containsKey(UTEvent.TAG_UTEVENT)) {
                    UTTrackerListenerMgr.getInstance().sendEvent(map, intValue);
                } else {
                    map.remove(UTEvent.TAG_UTEVENT);
                }
                UTTrackerListenerMgr.getInstance().send(this, map);
                final HashMap hashMap = new HashMap(map);
                hashMap.remove(UTConstants.PrivateLogFields.FLAG_BUILD_MAP_BY_UT);
                hashMap.putAll(this.mArgsMap);
                UTPagePropertiesHelper.updateEventProperties(intValue, hashMap);
                try {
                    if (!sj.c().i()) {
                        LogField logField = LogField.RECORD_TIMESTAMP;
                        if (!hashMap.containsKey(logField.toString())) {
                            long currentTimeMillis = System.currentTimeMillis();
                            String str = logField.toString();
                            hashMap.put(str, "" + currentTimeMillis);
                        }
                    }
                } catch (Exception unused) {
                }
                if (!yh2.f(this.mTrackerId)) {
                    hashMap.put("_track_id", this.mTrackerId);
                }
                if (sj.c().h()) {
                    hashMap.put(UTMCLogFields.ALIYUN_PLATFORM_FLAG.toString(), BQCCameraParam.VALUE_YES);
                }
                String e = sj.c().e();
                if (!yh2.f(e)) {
                    hashMap.put("UTPVID_T", e);
                }
                if (!map.containsKey(UTConstants.PrivateLogFields.FLAG_USE_ALL_MAP_FIELDS)) {
                    dropAllIllegalKey(hashMap);
                } else {
                    hashMap.remove(UTConstants.PrivateLogFields.FLAG_USE_ALL_MAP_FIELDS);
                }
                translateFieldsName(hashMap);
                fillReserve1Fields(hashMap);
                fillReservesFields(hashMap);
                if (intValue == 2101 || intValue == 2102) {
                    hashMap.put(RestConstants.LogContentKeys.PRIORITY, "4");
                }
                UTPvidHelper.processOtherPvid(intValue, hashMap);
                ReadonlyMap readonlyMap = null;
                if (UTPluginMgr.getInstance().getUTPluginConfigMgr().isOpen()) {
                    ReadonlyMap readonlyMap2 = new ReadonlyMap(hashMap);
                    String str2 = hashMap.get(LogField.PAGE.toString());
                    String str3 = hashMap.get(LogField.ARG1.toString());
                    String str4 = hashMap.get(LogField.ARG2.toString());
                    String str5 = hashMap.get(LogField.ARG3.toString());
                    try {
                        Iterator openUTPluginMapIterator = UTPluginMgr.getInstance().getUTPluginConfigMgr().getOpenUTPluginMapIterator();
                        while (openUTPluginMapIterator.hasNext()) {
                            UTPlugin uTPlugin = (UTPlugin) ((Map.Entry) openUTPluginMapIterator.next()).getValue();
                            if (uTPlugin != null) {
                                processPluginMap(uTPlugin, hashMap, str2, intValue, str3, str4, str5, readonlyMap2);
                            }
                        }
                    } catch (Throwable th) {
                        if (Logger.n()) {
                            Logger.h(TAG, th, new Object[0]);
                        }
                    }
                    readonlyMap = readonlyMap2;
                }
                if (UTPluginMgr.getInstance().getUTPluginConfigMgr().isAsyncOpen()) {
                    if (readonlyMap == null) {
                        readonlyMap = new ReadonlyMap(hashMap);
                    }
                    final ReadonlyMap readonlyMap3 = readonlyMap;
                    final String str6 = hashMap.get(LogField.PAGE.toString());
                    final String str7 = hashMap.get(LogField.ARG1.toString());
                    final String str8 = hashMap.get(LogField.ARG2.toString());
                    final String str9 = hashMap.get(LogField.ARG3.toString());
                    hl2.c().f(new Runnable() { // from class: com.ut.mini.UTTracker.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Iterator openAsyncUTPluginMapIterator = UTPluginMgr.getInstance().getUTPluginConfigMgr().getOpenAsyncUTPluginMapIterator();
                                while (openAsyncUTPluginMapIterator.hasNext()) {
                                    UTPlugin uTPlugin2 = (UTPlugin) ((Map.Entry) openAsyncUTPluginMapIterator.next()).getValue();
                                    if (uTPlugin2 != null) {
                                        UTTracker.processPluginMap(uTPlugin2, hashMap, str6, intValue, str7, str8, str9, readonlyMap3);
                                    }
                                }
                            } catch (Throwable th2) {
                                if (Logger.n()) {
                                    Logger.h(UTTracker.TAG, th2, new Object[0]);
                                }
                            }
                            UTTracker.this.sendLog(hashMap, intValue);
                        }
                    });
                    return;
                }
                sendLog(hashMap, intValue);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAppKey(String str) {
        this.mAppkey = str;
    }

    public void setCommitImmediatelyExposureBlock(String str) {
        TrackerFrameLayout.setCommitImmediatelyExposureBlock(str);
    }

    public void setExposureSpmAB(View view, String str, String str2) {
        ExposureUtils.setExposureSpmAB(view, str, str2);
    }

    public void setExposureSpmCD(View view, String str, String str2) {
        ExposureUtils.setExposureSpmCD(view, str, str2);
    }

    public void setExposureTag(View view, String str, String str2, Map<String, String> map) {
        ExposureUtils.setExposure(view, str, str2, map);
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (!yh2.f(str) && str2 != null) {
            this.mArgsMap.put(str, str2);
        } else {
            Logger.i("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setH5Url(String str) {
        if (str != null) {
            UTVariables.getInstance().setH5Url(str);
        }
    }

    public void setPageSessionPropertiesRule(Activity activity, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        UTPagePropertiesHelper.setPageSessionPropertiesRule(activity, arrayList, arrayList2);
    }

    public void setPageStatusCode(Object obj, int i) {
        UTPageHitHelper.getInstance().setPageStatusCode(obj, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTrackId(String str) {
        this.mTrackerId = str;
    }

    public void skipNextPageBack() {
        UTPageHitHelper.getInstance().skipNextPageBack();
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }

    public void skipPageBack(Activity activity) {
        UTPageHitHelper.getInstance().skipBack(activity);
    }

    @Deprecated
    public void skipPageBackForever(Activity activity, boolean z) {
        UTPageHitHelper.getInstance().skipBackForever(activity, z);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTTrackerListenerMgr.getInstance().updateNextPageProperties(this, map);
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updateNextPageUtparam(String str) {
        UTTrackerListenerMgr.getInstance().updateNextPageUtparam(str);
        UTPageHitHelper.getInstance().updateNextPageUtparam(str);
    }

    public void updateNextPageUtparamCnt(String str) {
        UTPageHitHelper.getInstance().updateNextPageUtparamCnt(str);
    }

    public void updatePageName(Object obj, String str) {
        UTTrackerListenerMgr.getInstance().updatePageName(this, obj, str);
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        Logger.f(TAG, "updatePageProperties", map);
        UTTrackerListenerMgr.getInstance().updatePageProperties(this, obj, map);
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
        UTTrackerListenerMgr.getInstance().updatePagePropertiesEnd(this, obj);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void updatePageUtparam(Object obj, String str) {
        UTTrackerListenerMgr.getInstance().updatePageUtparam(obj, str);
        UTPageHitHelper.getInstance().updatePageUtparam(obj, str);
    }

    public void pageAppear(Object obj, String str) {
        pageAppear(obj, str, false);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        pageAppear(obj, str, true);
    }

    public void refreshExposureData(String str) {
        TrackerFrameLayout.refreshExposureData(str);
    }

    public void pageAppear(Object obj, String str, boolean z) {
        UTPageHitHelper.getInstance().pageAppear(obj, str, z);
    }
}
