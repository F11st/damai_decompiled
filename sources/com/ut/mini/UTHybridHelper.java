package com.ut.mini;

import android.app.Activity;
import android.net.Uri;
import com.alibaba.analytics.utils.Logger;
import com.taobao.ju.track.JTrack;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import tb.et2;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTHybridHelper {
    private static final String TAG = "UTHybridHelper";
    private static UTHybridHelper s_instance = new UTHybridHelper();

    private String _getPageEventObjectCacheKey(Object obj) {
        String simpleName;
        if (obj instanceof String) {
            simpleName = (String) obj;
        } else {
            simpleName = obj.getClass().getSimpleName();
        }
        int hashCode = obj.hashCode();
        return simpleName + hashCode;
    }

    private void beginEvent(Map<String, String> map, Object obj, String str, String str2, Map<String, String> map2) {
        try {
            UTEvent eventByKey = UTEventTracker.getInstance().getEventByKey(UTEventTracker.getInstance().getKeyForObject(obj));
            eventByKey.setEventId(2001);
            eventByKey.setContext(obj);
            eventByKey.setPageName(str);
            eventByKey.setArg1(str2);
            eventByKey.updateProperties(map2);
            eventByKey.setH5Pv(true);
            UTEventTracker.getInstance().beginEvent(eventByKey);
            map.put(UTEvent.TAG_UTEVENT, "1");
        } catch (Exception unused) {
        }
    }

    private boolean checkUtUpdateSpm(Map<String, String> map) {
        if (map == null || !"1".equals(map.get("_ut_update_spm"))) {
            return false;
        }
        Logger.f(TAG, "_ut_update_spm=1");
        return true;
    }

    private String getH5PageName(String str, String str2) {
        if (str == null || yh2.f(str)) {
            if (yh2.f(str2)) {
                return "";
            }
            int indexOf = str2.indexOf("?");
            return indexOf == -1 ? str2 : str2.substring(0, indexOf);
        }
        return str;
    }

    public static UTHybridHelper getInstance() {
        return s_instance;
    }

    private Map<String, String> getUTPageStateObjectSpmMap(Object obj, Map<String, String> map, String str, Map<String, String> map2) {
        return getUTPageStateObjectSpmMap(obj, map, str, "", map2, false);
    }

    private void h5Ctrl(String str, Date date, Map<String, String> map) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Throwable unused) {
            i = -1;
        }
        if (i == -1 || map == null || map.size() == 0) {
            return;
        }
        String h5PageName = getH5PageName(map.get("urlpagename"), map.get("url"));
        if (h5PageName != null && !yh2.f(h5PageName)) {
            String str2 = map.get("logkey");
            if (str2 != null && !yh2.f(str2)) {
                Map<String, String> map2 = null;
                String str3 = map.get("utjstype");
                map.remove("utjstype");
                if (str3 != null && !str3.equals("0")) {
                    if (str3.equals("1")) {
                        map2 = h5CtrlParseArgsWithOutAplus(map);
                    }
                } else {
                    map2 = h5CtrlParseArgsWithAplus(map);
                }
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(h5PageName, i, str2, null, null, map2);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                    return;
                } else {
                    Logger.i("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
                    return;
                }
            }
            Logger.m("h5Ctrl", "logkey is null,return");
            return;
        }
        Logger.m("h5Ctrl", "pageName is null,return");
    }

    private void h5Ctrl2(Map<String, String> map) {
        int i;
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            i = Integer.parseInt(map.remove("funcId"));
        } catch (Throwable unused) {
            i = -1;
        }
        if (i == -1) {
            return;
        }
        String remove = map.remove("url");
        if (remove != null && !yh2.f(remove)) {
            String remove2 = map.remove("logkey");
            if (remove2 != null && !yh2.f(remove2)) {
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(remove, i, remove2, null, null, map);
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    defaultTracker.send(uTOriginalCustomHitBuilder.build());
                    return;
                } else {
                    Logger.i("h5Ctrl event error", "Fatal Error,must call setRequestAuthentication method first.");
                    return;
                }
            }
            Logger.m("h5Ctrl", "logkey is null,return");
            return;
        }
        Logger.m("h5Ctrl", "pageName is null,return");
    }

    private Map<String, String> h5CtrlParseArgsWithAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("logkeyargs");
        if (str == null) {
            str = "";
        }
        hashMap.put("_lka", str);
        String str2 = map.get("cna");
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("_cna", str2);
        String str3 = map.get("extendargs");
        hashMap.put("_h5ea", str3 != null ? str3 : "");
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> h5CtrlParseArgsWithOutAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("extendargs");
        if (str == null) {
            str = "";
        }
        hashMap.put("_h5ea", str);
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private void h5Page(Date date, Map<String, String> map, Object obj) {
        Map<String, String> h5PageParseArgsWithAplus;
        int i;
        Logger.d();
        if (map == null || map.size() == 0) {
            return;
        }
        String str = map.get("url");
        String h5PageName = getH5PageName(map.get("urlpagename"), str);
        if (h5PageName != null && !yh2.f(h5PageName)) {
            String str2 = map.get("utjstype");
            map.remove("utjstype");
            if (str2 != null && !str2.equals("0")) {
                h5PageParseArgsWithAplus = str2.equals("1") ? h5PageParseArgsWithOutAplus(map) : null;
            } else {
                h5PageParseArgsWithAplus = h5PageParseArgsWithAplus(map);
            }
            int i2 = UTPageHitHelper.getInstance().isH52001(obj) ? 2001 : 2006;
            String refPage = UTVariables.getInstance().getRefPage();
            int i3 = i2;
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(h5PageName, i2, refPage, null, null, h5PageParseArgsWithAplus);
            if (2001 == i3) {
                UTVariables.getInstance().setRefPage(h5PageName);
                Map<String, String> nextPageProperties = UTPageHitHelper.getInstance().getNextPageProperties(obj);
                if (nextPageProperties != null && nextPageProperties.size() > 0) {
                    uTOriginalCustomHitBuilder.setProperties(nextPageProperties);
                }
                if (obj instanceof Activity) {
                    uTOriginalCustomHitBuilder.setProperties(getUTPageStateObjectSpmMap(obj, map, str, nextPageProperties));
                }
            }
            try {
                String f = et2.e().f(Uri.parse(str), null);
                if (!yh2.f(f)) {
                    uTOriginalCustomHitBuilder.setProperty("_tpk", f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                Map<String, String> build = uTOriginalCustomHitBuilder.build();
                if (i3 == 2001) {
                    UTPageSequenceMgr.pushNode(obj, build);
                    i = i3;
                    beginEvent(build, obj, h5PageName, refPage, h5PageParseArgsWithAplus);
                } else {
                    i = i3;
                }
                defaultTracker.send(UTPvidHelper.processH5PagePvid(i, build));
            } else {
                Logger.i("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
            UTPageHitHelper.getInstance().setH5Called(obj);
            return;
        }
        Logger.i("h5Page", "pageName is null,return");
    }

    private void h5Page2(Map<String, String> map, Object obj) {
        Map<String, String> uTPageStateObjectSpmMap;
        Logger.d();
        if (map != null && map.size() != 0) {
            String remove = map.remove("url");
            if (remove != null && !yh2.f(remove)) {
                String refPage = UTVariables.getInstance().getRefPage();
                int i = UTPageHitHelper.getInstance().isH52001(obj) ? 2001 : 2006;
                HashMap hashMap = new HashMap(map);
                if (2001 == i) {
                    UTVariables.getInstance().setRefPage(remove);
                    Map<String, String> nextPageProperties = UTPageHitHelper.getInstance().getNextPageProperties(obj);
                    if (nextPageProperties != null && nextPageProperties.size() > 0) {
                        hashMap.putAll(nextPageProperties);
                    }
                    if ((obj instanceof Activity) && (uTPageStateObjectSpmMap = getUTPageStateObjectSpmMap(obj, map, remove, map.get("_h5url"), nextPageProperties)) != null) {
                        hashMap.putAll(uTPageStateObjectSpmMap);
                    }
                }
                int i2 = i;
                UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(remove, i, refPage, null, null, hashMap);
                try {
                    String f = et2.e().f(Uri.parse(map.get("_h5url")), null);
                    if (!yh2.f(f)) {
                        uTOriginalCustomHitBuilder.setProperty("_tpk", f);
                    }
                } catch (Throwable th) {
                    Logger.h(null, th, new Object[0]);
                }
                UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
                if (defaultTracker != null) {
                    Map<String, String> build = uTOriginalCustomHitBuilder.build();
                    if (i2 == 2001) {
                        UTPageSequenceMgr.pushNode(obj, build);
                        beginEvent(build, obj, remove, refPage, hashMap);
                    }
                    defaultTracker.send(UTPvidHelper.processH5PagePvid(i2, build));
                } else {
                    Logger.i("h5Page event error", "Fatal Error,must call setRequestAuthentication method first.");
                }
                UTPageHitHelper.getInstance().setH5Called(obj);
                return;
            }
            Logger.m("h5Page2", "pageName is null,return");
            return;
        }
        Logger.m("h5Page2", "dataMap is null or empty,return");
    }

    private Map<String, String> h5PageParseArgsWithAplus(Map<String, String> map) {
        Map argsMap;
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        hashMap.put("_h5url", str == null ? "" : str);
        if (str != null) {
            try {
                int indexOf = str.indexOf(63);
                if (indexOf > 0 && (argsMap = JTrack.Page.getArgsMap(str.substring(0, indexOf), Uri.parse(str))) != null) {
                    hashMap.putAll(argsMap);
                }
            } catch (Throwable unused) {
            }
        }
        if (str != null) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("spm");
            if (queryParameter != null && !yh2.f(queryParameter)) {
                hashMap.put("spm", queryParameter);
            } else {
                hashMap.put("spm", "0.0.0.0");
            }
            String queryParameter2 = parse.getQueryParameter("scm");
            if (queryParameter2 != null && !yh2.f(queryParameter2)) {
                hashMap.put("scm", queryParameter2);
            }
            String queryParameter3 = parse.getQueryParameter("pg1stepk");
            if (queryParameter3 != null && !yh2.f(queryParameter3)) {
                hashMap.put("pg1stepk", queryParameter3);
            }
            if (!yh2.f(parse.getQueryParameter("point"))) {
                hashMap.put("issb", "1");
            }
        } else {
            hashMap.put("spm", "0.0.0.0");
        }
        String str2 = map.get("spmcnt");
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("_spmcnt", str2);
        String str3 = map.get("spmpre");
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("_spmpre", str3);
        String str4 = map.get("lzsid");
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("_lzsid", str4);
        String str5 = map.get("extendargs");
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("_h5ea", str5);
        String str6 = map.get("cna");
        hashMap.put("_cna", str6 != null ? str6 : "");
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    private Map<String, String> h5PageParseArgsWithOutAplus(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = map.get("url");
        if (str == null) {
            str = "";
        }
        hashMap.put("_h5url", str);
        String str2 = map.get("extendargs");
        hashMap.put("_h5ea", str2 != null ? str2 : "");
        hashMap.put("_ish5", "1");
        return hashMap;
    }

    public void h5UT(Map<String, String> map, Object obj) {
        if (Logger.n()) {
            Logger.f(TAG, "h5UT view", obj, "dataMap", map);
        }
        if (map != null && map.size() != 0) {
            String str = map.get("functype");
            if (str == null) {
                Logger.i(TAG, "h5UT funcType is null");
                return;
            }
            String str2 = map.get("utjstype");
            if (str2 != null && !str2.equals("0") && !str2.equals("1")) {
                Logger.i(TAG, "h5UT utjstype should be 1 or 0 or null");
                return;
            }
            map.remove("functype");
            Date date = new Date();
            if (str.equals("2001")) {
                h5Page(date, map, obj);
                UTTeamWork.getInstance().dispatchH5JSCall(obj, map);
                return;
            }
            h5Ctrl(str, date, map);
            return;
        }
        Logger.i(TAG, "h5UT dataMap is empty");
    }

    public void h5UT2(Map<String, String> map, Object obj) {
        if (Logger.n()) {
            Logger.f(TAG, "h5UT2 view", obj, "dataMap", map);
        }
        if (map != null && map.size() != 0) {
            String remove = map.remove("functype");
            if (remove == null) {
                Logger.i("h5UT", "funcType is null");
                return;
            } else if (remove.equals("page")) {
                map.remove("funcId");
                h5Page2(map, obj);
                UTTeamWork.getInstance().dispatchH5JSCall(obj, map);
                return;
            } else if (remove.equals("ctrl")) {
                h5Ctrl2(map);
                return;
            } else {
                return;
            }
        }
        Logger.i("h5UT", "dataMap is empty");
    }

    public void setH5Url(String str) {
        UTAnalytics.getInstance().getDefaultTracker().setH5Url(str);
    }

    private Map<String, String> getUTPageStateObjectSpmMap(Object obj, Map<String, String> map, String str, String str2, Map<String, String> map2) {
        return getUTPageStateObjectSpmMap(obj, map, str, str2, map2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fa, code lost:
        if (checkUtUpdateSpm(r24) == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.String> getUTPageStateObjectSpmMap(java.lang.Object r23, java.util.Map<java.lang.String, java.lang.String> r24, java.lang.String r25, java.lang.String r26, java.util.Map<java.lang.String, java.lang.String> r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 857
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTHybridHelper.getUTPageStateObjectSpmMap(java.lang.Object, java.util.Map, java.lang.String, java.lang.String, java.util.Map, boolean):java.util.Map");
    }
}
