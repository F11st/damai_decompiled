package com.ut.mini;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.fastjson.JSON;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.ut.mini.extend.JTrackExtend;
import com.ut.mini.extend.UTExtendSwitch;
import com.ut.mini.module.UTOperationStack;
import com.ut.mini.module.trackerlistener.UTTrackerListenerMgr;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import tb.m80;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTPageHitHelper {
    private static final String FORCE_SPM_CNT = "force-spm-cnt";
    private static final String FORCE_SPM_URL = "force-spm-url";
    static final String ISBF = "isbf";
    static final String ISFM = "isfm";
    private static final int MAX_SKIP_CLEAR_PAGE_OBJECT_CACHE_CAPACITY = 100;
    private static final int MAX_SPM_OBJECT_CACHE_CAPACITY = 50;
    static final String SKIPBK = "skipbk";
    static final String SPM_URL = "spm-url";
    private static final String TAG = "UTPageHitHelper";
    static final String UTPARAM_CNT = "utparam-cnt";
    static final String UTPARAM_PRE = "utparam-pre";
    static final String UTPARAM_URL = "utparam-url";
    static final String UT_ISBK = "ut_isbk";
    private static UTPageHitHelper s_instance = new UTPageHitHelper();
    private static ArrayList<PageChangeListener> mPageChangerListeners = new ArrayList<>();
    private Map<String, UTPageStateObject> mPageStateObjects = new HashMap();
    private Queue<String> mClearUTPageStateObjectList = new LinkedList();
    private String mLastCacheKey = null;
    private String mLastCacheKeySpmUrl = null;
    private String mLastCacheKeyScmUrl = null;
    private String mLastCacheKeyUtParam = null;
    private String mLastCacheKeyUtParamCnt = null;
    private boolean mIsTurnOff = false;
    private Map<String, String> mPageProperties = new HashMap();
    private Map<String, UTPageEventObject> mPageEventObjects = new HashMap();
    private String mCurrentPageCacheKey = null;
    private Map<String, String> mNextPageProperties = new HashMap();
    private boolean mNextPageSkipBack = false;
    private Map<String, String> mBackupNextPageProperties = null;
    private String mCurPage = null;
    private Queue<UTPageEventObject> mSkipClearPageObjectList = new LinkedList();
    private Map<String, String> mSPMObjectMap = new HashMap();
    private Queue<String> mSPMObjectList = new LinkedList();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface PageChangeListener {
        void onPageAppear(Object obj);

        void onPageDisAppear(Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTPageEventObject {
        private Map<String, String> mPageProperties = new HashMap();
        private long mPageAppearTimestamp = 0;
        private long mPageStayTimstamp = 0;
        private Uri mPageUrl = null;
        private String mPageName = null;
        private String mRefPage = null;
        private UTPageStatus mPageStatus = null;
        private boolean mIsPageAppearCalled = false;
        private boolean mIsSkipPage = false;
        private boolean mIsH5Called = false;
        private String mCacheKey = null;
        private int mPageStatusCode = 0;
        private Map<String, String> mNextPageProperties = null;

        public String getCacheKey() {
            return this.mCacheKey;
        }

        public Map<String, String> getNextPageProperties() {
            return this.mNextPageProperties;
        }

        public long getPageAppearTimestamp() {
            return this.mPageAppearTimestamp;
        }

        public String getPageName() {
            return this.mPageName;
        }

        public Map<String, String> getPageProperties() {
            return this.mPageProperties;
        }

        public UTPageStatus getPageStatus() {
            return this.mPageStatus;
        }

        public int getPageStatusCode() {
            return this.mPageStatusCode;
        }

        public long getPageStayTimstamp() {
            return this.mPageStayTimstamp;
        }

        public Uri getPageUrl() {
            return this.mPageUrl;
        }

        public String getRefPage() {
            return this.mRefPage;
        }

        public boolean isH5Called() {
            return this.mIsH5Called;
        }

        public boolean isPageAppearCalled() {
            return this.mIsPageAppearCalled;
        }

        public boolean isSkipPage() {
            return this.mIsSkipPage;
        }

        public void resetPropertiesWithoutSkipFlagAndH5Flag() {
            this.mPageProperties = new HashMap();
            this.mPageAppearTimestamp = 0L;
            this.mPageStayTimstamp = 0L;
            this.mPageUrl = null;
            this.mPageName = null;
            this.mRefPage = null;
            UTPageStatus uTPageStatus = this.mPageStatus;
            if (uTPageStatus == null || uTPageStatus != UTPageStatus.UT_H5_IN_WebView) {
                this.mPageStatus = null;
            }
            this.mIsPageAppearCalled = false;
            this.mIsH5Called = false;
            this.mPageStatusCode = 0;
            this.mNextPageProperties = null;
        }

        public void setCacheKey(String str) {
            this.mCacheKey = str;
        }

        public void setH5Called() {
            this.mIsH5Called = true;
        }

        public void setNextPageProperties(Map<String, String> map) {
            this.mNextPageProperties = map;
        }

        public void setPageAppearCalled() {
            this.mIsPageAppearCalled = true;
        }

        public void setPageAppearTimestamp(long j) {
            this.mPageAppearTimestamp = j;
        }

        public void setPageName(String str) {
            this.mPageName = str;
        }

        public void setPageProperties(Map<String, String> map) {
            this.mPageProperties = map;
        }

        public void setPageStatus(UTPageStatus uTPageStatus) {
            this.mPageStatus = uTPageStatus;
        }

        public void setPageStatusCode(int i) {
            this.mPageStatusCode = i;
        }

        public void setPageStayTimstamp(long j) {
            this.mPageStayTimstamp = j;
        }

        public void setPageUrl(Uri uri) {
            this.mPageUrl = uri;
        }

        public void setRefPage(String str) {
            this.mRefPage = str;
        }

        public void setToSkipPage() {
            this.mIsSkipPage = true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UTPageStateObject {
        public String mSpmCnt = null;
        public String mSpmUrl = null;
        public String mSpmPre = null;
        public boolean mIsBack = false;
        public boolean mIsFrame = false;
        public boolean mIsSwitchBackground = false;
        public String mUtparamCnt = null;
        public String mUtparamUrl = null;
        public String mUtparamPre = null;
        public String mScmUrl = null;
        public String mScmPre = null;
        boolean mIsSkipBack = false;
        boolean mIsSkipBackForever = false;
        public boolean mIsH5Page = false;

        public Map<String, String> getPageStatMap(boolean z) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.mSpmCnt)) {
                hashMap.put("spm-cnt", this.mSpmCnt);
            }
            if (!TextUtils.isEmpty(this.mSpmUrl)) {
                hashMap.put("spm-url", this.mSpmUrl);
            }
            if (!TextUtils.isEmpty(this.mSpmPre)) {
                hashMap.put("spm-pre", this.mSpmPre);
            }
            if (!TextUtils.isEmpty(this.mScmPre)) {
                hashMap.put("scm-pre", this.mScmPre);
            }
            if (this.mIsSwitchBackground) {
                hashMap.put(UTPageHitHelper.ISBF, "1");
            } else if (this.mIsFrame && z) {
                hashMap.put(UTPageHitHelper.ISFM, "1");
            } else if (this.mIsBack) {
                hashMap.put(UTPageHitHelper.UT_ISBK, "1");
            }
            if (!TextUtils.isEmpty(this.mUtparamCnt)) {
                hashMap.put("utparam-cnt", this.mUtparamCnt);
            }
            if (!TextUtils.isEmpty(this.mUtparamUrl)) {
                hashMap.put("utparam-url", this.mUtparamUrl);
            }
            if (!TextUtils.isEmpty(this.mUtparamPre)) {
                hashMap.put(UTPageHitHelper.UTPARAM_PRE, this.mUtparamPre);
            }
            return hashMap;
        }
    }

    private void _clearPageDisAppearContext() {
        this.mPageProperties = new HashMap();
        this.mCurrentPageCacheKey = null;
        this.mCurPage = null;
        this.mBackupNextPageProperties = null;
        UTVariables.getInstance().setBackupH5Url(null);
    }

    private synchronized void _clearUTPageEventObjectCache(UTPageEventObject uTPageEventObject) {
        if (this.mPageEventObjects.containsKey(uTPageEventObject.getCacheKey())) {
            this.mPageEventObjects.remove(uTPageEventObject.getCacheKey());
        }
    }

    private synchronized UTPageEventObject _getOrNewAUTPageEventObject(Object obj) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
        if (this.mPageEventObjects.containsKey(_getPageEventObjectCacheKey)) {
            return this.mPageEventObjects.get(_getPageEventObjectCacheKey);
        }
        UTPageEventObject uTPageEventObject = new UTPageEventObject();
        this.mPageEventObjects.put(_getPageEventObjectCacheKey, uTPageEventObject);
        uTPageEventObject.setCacheKey(_getPageEventObjectCacheKey);
        return uTPageEventObject;
    }

    private static String _getOutsideTTID(Uri uri) {
        List<String> queryParameters;
        if (uri == null || (queryParameters = uri.getQueryParameters("ttid")) == null) {
            return null;
        }
        for (String str : queryParameters) {
            if (!str.contains(m80.DINAMIC_PREFIX_AT) && !str.contains("%40")) {
                return str;
            }
        }
        return null;
    }

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

    private static String _getPageName(Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        return simpleName.toLowerCase().endsWith("activity") ? simpleName.substring(0, simpleName.length() - 8) : simpleName;
    }

    private String _getSpmByUri(Uri uri) {
        String queryParameter = uri.getQueryParameter("spm");
        if (yh2.f(queryParameter)) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8"));
                queryParameter = uri.getQueryParameter("spm");
            } catch (Exception e) {
                Logger.u("", e, new Object[0]);
            }
        }
        if (yh2.f(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("spm_url");
            if (yh2.f(queryParameter2)) {
                try {
                    return Uri.parse(URLDecoder.decode(uri.toString(), "UTF-8")).getQueryParameter("spm_url");
                } catch (Exception e2) {
                    Logger.u("", e2, new Object[0]);
                    return queryParameter2;
                }
            }
            return queryParameter2;
        }
        return queryParameter;
    }

    private synchronized void _putUTPageEventObjectToCache(String str, UTPageEventObject uTPageEventObject) {
        this.mPageEventObjects.put(str, uTPageEventObject);
    }

    private synchronized void _releaseUTPageStateObject() {
        if (this.mClearUTPageStateObjectList.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String poll = this.mClearUTPageStateObjectList.poll();
                if (poll != null && this.mPageStateObjects.containsKey(poll)) {
                    this.mPageStateObjects.remove(poll);
                }
            }
        }
    }

    private synchronized void _removeUTPageEventObject(Object obj) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
        if (this.mPageEventObjects.containsKey(_getPageEventObjectCacheKey)) {
            this.mPageEventObjects.remove(_getPageEventObjectCacheKey);
        }
    }

    public static synchronized void addPageChangerListener(PageChangeListener pageChangeListener) {
        synchronized (UTPageHitHelper.class) {
            if (pageChangeListener == null) {
                return;
            }
            if (!mPageChangerListeners.contains(pageChangeListener)) {
                mPageChangerListeners.add(pageChangeListener);
            }
        }
    }

    private void clearMapEmptyValue(Map<String, Object> map) {
        try {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value == null) {
                    it.remove();
                } else if ((value instanceof String) && TextUtils.isEmpty((String) value)) {
                    it.remove();
                }
            }
        } catch (Exception e) {
            Logger.f("", e);
        }
    }

    private void clearUTPageStateObject(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        map.remove("spm-cnt");
        map.remove("spm-url");
        map.remove("spm-pre");
        map.remove("utparam-cnt");
        map.remove("utparam-url");
        map.remove(UTPARAM_PRE);
        map.remove("scm-pre");
    }

    private UTPageStateObject copyUTPageStateObject(UTPageStateObject uTPageStateObject) {
        if (uTPageStateObject == null) {
            return null;
        }
        UTPageStateObject uTPageStateObject2 = new UTPageStateObject();
        uTPageStateObject2.mSpmCnt = uTPageStateObject.mSpmCnt;
        uTPageStateObject2.mSpmUrl = uTPageStateObject.mSpmUrl;
        uTPageStateObject2.mSpmPre = uTPageStateObject.mSpmPre;
        uTPageStateObject2.mIsBack = uTPageStateObject.mIsBack;
        uTPageStateObject2.mIsFrame = uTPageStateObject.mIsFrame;
        uTPageStateObject2.mIsSwitchBackground = uTPageStateObject.mIsSwitchBackground;
        uTPageStateObject2.mUtparamCnt = uTPageStateObject.mUtparamCnt;
        uTPageStateObject2.mUtparamUrl = uTPageStateObject.mUtparamUrl;
        uTPageStateObject2.mUtparamPre = uTPageStateObject.mUtparamPre;
        uTPageStateObject2.mScmUrl = uTPageStateObject.mScmUrl;
        uTPageStateObject2.mScmPre = uTPageStateObject.mScmPre;
        uTPageStateObject2.mIsSkipBack = uTPageStateObject.mIsSkipBack;
        uTPageStateObject2.mIsSkipBackForever = uTPageStateObject.mIsSkipBackForever;
        return uTPageStateObject2;
    }

    static synchronized void disPathcherPageChangerEvent(int i, Object obj) {
        synchronized (UTPageHitHelper.class) {
            int size = mPageChangerListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                PageChangeListener pageChangeListener = mPageChangerListeners.get(i2);
                if (pageChangeListener != null) {
                    if (i == 0) {
                        pageChangeListener.onPageAppear(obj);
                    } else {
                        pageChangeListener.onPageDisAppear(obj);
                    }
                }
            }
        }
    }

    public static Map<String, String> encodeUtParam(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        try {
            String str = map.get("utparam-cnt");
            if (!TextUtils.isEmpty(str)) {
                map.put("utparam-cnt", URLEncoder.encode(str));
            }
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        try {
            String str2 = map.get("utparam-url");
            if (!TextUtils.isEmpty(str2)) {
                map.put("utparam-url", URLEncoder.encode(str2));
            }
        } catch (Throwable th2) {
            Logger.h(null, th2, new Object[0]);
        }
        try {
            String str3 = map.get(UTPARAM_PRE);
            if (!TextUtils.isEmpty(str3)) {
                map.put(UTPARAM_PRE, URLEncoder.encode(str3));
            }
        } catch (Throwable th3) {
            Logger.h(null, th3, new Object[0]);
        }
        try {
            String str4 = map.get("ut_seq");
            if (!TextUtils.isEmpty(str4)) {
                map.put("ut_seq", URLEncoder.encode(str4));
            }
        } catch (Throwable th4) {
            Logger.h(null, th4, new Object[0]);
        }
        return map;
    }

    private void forceSetSpm(UTPageStateObject uTPageStateObject, Map<String, String> map) {
        if (uTPageStateObject == null || map == null) {
            return;
        }
        String str = map.get(FORCE_SPM_CNT);
        if (!TextUtils.isEmpty(str)) {
            uTPageStateObject.mSpmCnt = str;
        }
        String str2 = map.get(FORCE_SPM_URL);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        uTPageStateObject.mSpmUrl = str2;
    }

    public static UTPageHitHelper getInstance() {
        return s_instance;
    }

    private String getSpmUrl(Map<String, String> map, String str) {
        if (map != null) {
            String str2 = map.get("spm-url");
            if (TextUtils.isEmpty(str2)) {
                String str3 = map.get("spm_url");
                if (TextUtils.isEmpty(str3)) {
                    if (TextUtils.isEmpty(str)) {
                        String str4 = map.get("spm");
                        return !TextUtils.isEmpty(str4) ? str4 : "";
                    }
                    return str;
                }
                return str3;
            }
            return str2;
        }
        return str;
    }

    private static boolean isDefaultActivityName(Object obj, String str) {
        String _getPageName;
        return (obj instanceof Activity) && (_getPageName = _getPageName(obj)) != null && _getPageName.equalsIgnoreCase(str);
    }

    private boolean isEmptyMap(Map<String, Object> map) {
        return map == null || map.size() < 1;
    }

    private Map<String, Object> parseJsonToMap(String str) {
        try {
            return (Map) JSON.parseObject(str, Map.class);
        } catch (Exception unused) {
            return null;
        }
    }

    private void refreshUTPageStateObject(UTPageStateObject uTPageStateObject, Map<String, String> map, String str, String str2, String str3, String str4) {
        String str5 = map.get("spm-cnt");
        if (!TextUtils.isEmpty(str5)) {
            uTPageStateObject.mSpmCnt = str5;
        } else {
            uTPageStateObject.mSpmCnt = map.get(UTDataCollectorNodeColumn.SPM_CNT);
        }
        uTPageStateObject.mSpmUrl = getSpmUrl(map, str);
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mSpmPre = this.mLastCacheKeySpmUrl;
        } else {
            uTPageStateObject.mSpmPre = "";
        }
        if (!TextUtils.isEmpty(str3)) {
            uTPageStateObject.mScmUrl = str3;
        } else {
            uTPageStateObject.mScmUrl = map.get("scm");
        }
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mScmPre = this.mLastCacheKeyScmUrl;
        } else {
            uTPageStateObject.mScmPre = "";
        }
        String refreshUtParam = refreshUtParam(map.get("utparam-cnt"), str4);
        if (!TextUtils.isEmpty(refreshUtParam)) {
            uTPageStateObject.mUtparamCnt = refreshUtParam;
        } else {
            uTPageStateObject.mUtparamCnt = "";
        }
        uTPageStateObject.mUtparamUrl = refreshUtParam(str2, refreshUtParam(map.get("utparam-url"), !TextUtils.isEmpty(this.mLastCacheKey) ? this.mLastCacheKeyUtParamCnt : ""));
        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
            uTPageStateObject.mUtparamPre = this.mLastCacheKeyUtParam;
        } else {
            uTPageStateObject.mUtparamPre = "";
        }
    }

    synchronized void _releaseSPMCacheObj(String str) {
        if (!this.mSPMObjectList.contains(str)) {
            this.mSPMObjectList.add(str);
        }
        if (this.mSPMObjectList.size() > 100) {
            for (int i = 0; i < 50; i++) {
                String poll = this.mSPMObjectList.poll();
                if (poll != null && this.mSPMObjectMap.containsKey(poll)) {
                    this.mSPMObjectMap.remove(poll);
                }
            }
        }
    }

    synchronized void _releaseSkipFlagAndH5FlagPageObject(UTPageEventObject uTPageEventObject) {
        uTPageEventObject.resetPropertiesWithoutSkipFlagAndH5Flag();
        if (!this.mSkipClearPageObjectList.contains(uTPageEventObject)) {
            this.mSkipClearPageObjectList.add(uTPageEventObject);
        }
        if (this.mSkipClearPageObjectList.size() > 200) {
            for (int i = 0; i < 100; i++) {
                UTPageEventObject poll = this.mSkipClearPageObjectList.poll();
                if (poll != null && this.mPageEventObjects.containsKey(poll.getCacheKey())) {
                    this.mPageEventObjects.remove(poll.getCacheKey());
                }
            }
        }
    }

    public String getCurrentPageName() {
        return this.mCurPage;
    }

    public String getLastCacheKey() {
        return this.mLastCacheKey;
    }

    public String getLastCacheKeyScmUrl() {
        return this.mLastCacheKeyScmUrl;
    }

    public String getLastCacheKeySpmUrl() {
        return this.mLastCacheKeySpmUrl;
    }

    public String getLastCacheKeyUtParam() {
        return this.mLastCacheKeyUtParam;
    }

    public String getLastCacheKeyUtParamCnt() {
        return this.mLastCacheKeyUtParamCnt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map<String, String> getNextPageProperties(Object obj) {
        if (obj != null) {
            return _getOrNewAUTPageEventObject(obj).getNextPageProperties();
        }
        return null;
    }

    public synchronized UTPageStateObject getOrNewUTPageStateObject(Object obj) {
        if (obj instanceof Activity) {
            String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
            if (!this.mClearUTPageStateObjectList.contains(_getPageEventObjectCacheKey)) {
                this.mClearUTPageStateObjectList.add(_getPageEventObjectCacheKey);
            }
            if (this.mPageStateObjects.containsKey(_getPageEventObjectCacheKey)) {
                return this.mPageStateObjects.get(_getPageEventObjectCacheKey);
            }
            UTPageStateObject uTPageStateObject = new UTPageStateObject();
            this.mPageStateObjects.put(_getPageEventObjectCacheKey, uTPageStateObject);
            return uTPageStateObject;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3 A[Catch: all -> 0x0103, TryCatch #2 {, blocks: (B:5:0x0006, B:8:0x000c, B:10:0x0016, B:13:0x0023, B:15:0x0029, B:17:0x0031, B:20:0x003e, B:22:0x0048, B:25:0x0055, B:27:0x0065, B:28:0x006c, B:30:0x007a, B:32:0x0080, B:40:0x00a5, B:42:0x00b3, B:44:0x00c1, B:46:0x00c5, B:49:0x00cd, B:51:0x00d1, B:56:0x00e3, B:58:0x00e7, B:59:0x00ea, B:54:0x00d7, B:48:0x00c9, B:55:0x00de, B:62:0x00f6), top: B:76:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00de A[Catch: all -> 0x0103, TryCatch #2 {, blocks: (B:5:0x0006, B:8:0x000c, B:10:0x0016, B:13:0x0023, B:15:0x0029, B:17:0x0031, B:20:0x003e, B:22:0x0048, B:25:0x0055, B:27:0x0065, B:28:0x006c, B:30:0x007a, B:32:0x0080, B:40:0x00a5, B:42:0x00b3, B:44:0x00c1, B:46:0x00c5, B:49:0x00cd, B:51:0x00d1, B:56:0x00e3, B:58:0x00e7, B:59:0x00ea, B:54:0x00d7, B:48:0x00c9, B:55:0x00de, B:62:0x00f6), top: B:76:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7 A[Catch: all -> 0x0103, TryCatch #2 {, blocks: (B:5:0x0006, B:8:0x000c, B:10:0x0016, B:13:0x0023, B:15:0x0029, B:17:0x0031, B:20:0x003e, B:22:0x0048, B:25:0x0055, B:27:0x0065, B:28:0x006c, B:30:0x007a, B:32:0x0080, B:40:0x00a5, B:42:0x00b3, B:44:0x00c1, B:46:0x00c5, B:49:0x00cd, B:51:0x00d1, B:56:0x00e3, B:58:0x00e7, B:59:0x00ea, B:54:0x00d7, B:48:0x00c9, B:55:0x00de, B:62:0x00f6), top: B:76:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.Map<java.lang.String, java.lang.String> getPageAllProperties(android.app.Activity r13) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.getPageAllProperties(android.app.Activity):java.util.Map");
    }

    public synchronized Map<String, String> getPageProperties(Object obj) {
        if (obj == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.mPageProperties;
        if (map != null) {
            hashMap.putAll(map);
        }
        Map<String, String> pageProperties = _getOrNewAUTPageEventObject(obj).getPageProperties();
        if (pageProperties != null) {
            hashMap.putAll(pageProperties);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getPageScmPre(Activity activity) {
        String str;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
            String str2 = "";
            UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
            if (orNewUTPageStateObject != null) {
                boolean z = orNewUTPageStateObject.mIsBack;
                if (!orNewUTPageStateObject.mIsSwitchBackground) {
                    boolean z2 = false;
                    z = (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) ? false : false;
                    boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                    if (!orNewUTPageStateObject.mIsFrame || !equals) {
                        z2 = z;
                    }
                    if (!z2) {
                        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
                            str = this.mLastCacheKeyScmUrl;
                        }
                    } else {
                        str = orNewUTPageStateObject.mScmPre;
                    }
                    str2 = str;
                } else {
                    str2 = orNewUTPageStateObject.mScmPre;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            return str2;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getPageSpmPre(Activity activity) {
        String str;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
            String str2 = "";
            UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
            if (orNewUTPageStateObject != null) {
                boolean z = orNewUTPageStateObject.mIsBack;
                if (!orNewUTPageStateObject.mIsSwitchBackground) {
                    boolean z2 = false;
                    z = (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) ? false : false;
                    boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                    if (!orNewUTPageStateObject.mIsFrame || !equals) {
                        z2 = z;
                    }
                    if (!z2) {
                        if (!TextUtils.isEmpty(this.mLastCacheKey)) {
                            str = this.mLastCacheKeySpmUrl;
                        }
                    } else {
                        str = orNewUTPageStateObject.mSpmPre;
                    }
                    str2 = str;
                } else {
                    str2 = orNewUTPageStateObject.mSpmPre;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            return str2;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getPageSpmUrl(Activity activity) {
        Intent intent;
        if (activity == null) {
            return "";
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(activity);
        if (_getOrNewAUTPageEventObject.getPageStatus() == null || UTPageStatus.UT_H5_IN_WebView != _getOrNewAUTPageEventObject.getPageStatus()) {
            String str = "";
            Uri pageUrl = _getOrNewAUTPageEventObject.getPageUrl();
            if (pageUrl == null && (intent = activity.getIntent()) != null) {
                pageUrl = intent.getData();
            }
            if (pageUrl != null) {
                try {
                    str = _getSpmByUri(pageUrl);
                } catch (Throwable unused) {
                }
            }
            if (TextUtils.isEmpty(str)) {
                UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(activity);
                if (orNewUTPageStateObject != null) {
                    boolean z = orNewUTPageStateObject.mIsBack;
                    if (!orNewUTPageStateObject.mIsSwitchBackground) {
                        boolean z2 = false;
                        z = (orNewUTPageStateObject.mIsSkipBackForever || orNewUTPageStateObject.mIsSkipBack) ? false : false;
                        boolean equals = _getPageEventObjectCacheKey(activity).equals(this.mLastCacheKey);
                        if (!orNewUTPageStateObject.mIsFrame || !equals) {
                            z2 = z;
                        }
                        if (!z2) {
                            Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                            String str2 = pageProperties.get("spm-url");
                            String str3 = pageProperties.get("spm_url");
                            if (TextUtils.isEmpty(str2)) {
                                str2 = !TextUtils.isEmpty(str3) ? str3 : pageProperties.get("spm");
                            }
                            str = str2;
                        } else {
                            str = orNewUTPageStateObject.mSpmUrl;
                        }
                    } else {
                        str = orNewUTPageStateObject.mSpmUrl;
                    }
                }
                if (str == null) {
                    str = "";
                }
                return str;
            }
            return str;
        }
        return "";
    }

    public synchronized String getPageUrl(Object obj) {
        if (obj == null) {
            return null;
        }
        UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
        if (_getOrNewAUTPageEventObject == null || _getOrNewAUTPageEventObject.getPageUrl() == null) {
            return null;
        }
        return _getOrNewAUTPageEventObject.getPageUrl().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isH52001(Object obj) {
        if (obj != null) {
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            if (_getOrNewAUTPageEventObject.getPageStatus() != null && _getOrNewAUTPageEventObject.getPageStatus() == UTPageStatus.UT_H5_IN_WebView) {
                Logger.f(TAG, "isH52001:true aPageObject", obj);
                return true;
            }
        }
        Logger.f(TAG, "isH52001:false aPageObject", obj);
        return false;
    }

    @Deprecated
    public synchronized void pageAppear(Object obj) {
        pageAppear(obj, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageAppearByAuto(Activity activity) {
        if (this.mIsTurnOff) {
            return;
        }
        pageAppear(activity);
    }

    public void pageDestroyed(Activity activity) {
        String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(activity);
        if (this.mPageStateObjects.containsKey(_getPageEventObjectCacheKey)) {
            this.mPageStateObjects.remove(_getPageEventObjectCacheKey);
        }
        if (this.mClearUTPageStateObjectList.contains(_getPageEventObjectCacheKey)) {
            this.mClearUTPageStateObjectList.remove(_getPageEventObjectCacheKey);
        }
        _releaseUTPageStateObject();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(31:18|(4:22|(1:24)|25|(5:29|(1:31)|32|33|34))|35|(10:37|(1:43)|44|(1:46)(1:66)|47|(1:49)(1:65)|(1:51)(1:64)|(1:63)(1:55)|56|(1:59))|67|(1:290)|71|(1:73)|74|(3:262|263|(28:265|(4:267|268|269|270)(1:288)|271|(1:273)(1:285)|(24:275|(1:277)|278|(1:282)|77|(1:79)|80|(6:82|(1:84)|85|(1:89)|90|(14:92|93|(25:177|178|179|180|181|(8:183|184|185|186|187|188|(1:248)(1:192)|(1:194))(1:254)|196|197|198|199|200|201|202|203|204|(3:206|207|208)(1:233)|209|(3:211|212|213)(1:229)|214|(1:216)|217|(1:219)|220|(1:222)|224)(1:95)|96|(3:98|(5:154|(5:156|(1:174)|162|(1:168)|173)(1:175)|169|(1:171)|172)(3:102|(1:104)|105)|106)(1:176)|107|108|(1:110)|112|(1:116)|117|(2:142|(5:144|(1:146)(1:151)|147|(1:149)|150))|123|(1:125)(2:139|140)))|261|93|(0)(0)|96|(0)(0)|107|108|(0)|112|(2:114|116)|117|(2:119|121)|142|(0)|123|(0)(0))|284|278|(2:280|282)|77|(0)|80|(0)|261|93|(0)(0)|96|(0)(0)|107|108|(0)|112|(0)|117|(0)|142|(0)|123|(0)(0)))|76|77|(0)|80|(0)|261|93|(0)(0)|96|(0)(0)|107|108|(0)|112|(0)|117|(0)|142|(0)|123|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x04cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x04cd, code lost:
        com.alibaba.analytics.utils.Logger.f("", r0.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0256 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0261 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03c2 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04c6 A[Catch: Exception -> 0x04cc, all -> 0x060b, TRY_LEAVE, TryCatch #2 {Exception -> 0x04cc, blocks: (B:222:0x04b4, B:224:0x04c6), top: B:279:0x04b4, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04e2 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0502 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x051c A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x058b A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05a8 A[Catch: all -> 0x060b, TryCatch #5 {, blocks: (B:4:0x0007, B:6:0x0021, B:10:0x0034, B:12:0x0038, B:15:0x0045, B:17:0x004f, B:19:0x007c, B:21:0x0084, B:23:0x008a, B:24:0x009d, B:26:0x00a3, B:28:0x00a9, B:30:0x00ba, B:31:0x00bc, B:34:0x00c4, B:36:0x00d6, B:38:0x00df, B:40:0x00e8, B:42:0x00f5, B:43:0x011e, B:45:0x0124, B:47:0x012a, B:49:0x0133, B:52:0x013b, B:55:0x0143, B:62:0x0154, B:65:0x015c, B:58:0x014b, B:66:0x015f, B:68:0x0169, B:71:0x0171, B:73:0x0175, B:74:0x017a, B:100:0x0250, B:102:0x0256, B:103:0x025d, B:105:0x0261, B:108:0x026f, B:110:0x0275, B:112:0x027b, B:113:0x0282, B:117:0x0294, B:187:0x03bc, B:189:0x03c2, B:191:0x03c8, B:193:0x03d0, B:195:0x03d4, B:196:0x03d7, B:219:0x0453, B:222:0x04b4, B:224:0x04c6, B:228:0x04dc, B:230:0x04e2, B:232:0x04ee, B:233:0x04fa, B:235:0x0502, B:237:0x050a, B:250:0x054b, B:252:0x058b, B:256:0x05d7, B:258:0x05dd, B:266:0x05f8, B:259:0x05e1, B:261:0x05e7, B:263:0x05ef, B:264:0x05f3, B:253:0x05a8, B:254:0x05af, B:240:0x0512, B:242:0x051c, B:244:0x0525, B:246:0x052c, B:249:0x0533, B:227:0x04cd, B:197:0x03e4, B:199:0x03f2, B:201:0x0400, B:203:0x0404, B:206:0x040d, B:208:0x0411, B:215:0x043e, B:217:0x0442, B:218:0x0445, B:213:0x041e, B:205:0x0408, B:214:0x0433, B:185:0x03a4, B:255:0x05b0, B:267:0x05fc), top: B:285:0x0007, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x02a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void pageDisAppear(java.lang.Object r27, com.ut.mini.UTTracker r28) {
        /*
            Method dump skipped, instructions count: 1550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTPageHitHelper.pageDisAppear(java.lang.Object, com.ut.mini.UTTracker):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pageDisAppearByAuto(Activity activity) {
        if (this.mIsTurnOff) {
            return;
        }
        pageDisAppear(activity, UTAnalytics.getInstance().getDefaultTracker());
    }

    public void pageSwitchBackground() {
        UTPageStateObject uTPageStateObject;
        if (!this.mPageStateObjects.containsKey(this.mLastCacheKey) || (uTPageStateObject = this.mPageStateObjects.get(this.mLastCacheKey)) == null) {
            return;
        }
        uTPageStateObject.mIsSwitchBackground = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String refreshUtParam(String str, String str2) {
        try {
            Map<String, Object> parseJsonToMap = !TextUtils.isEmpty(str) ? parseJsonToMap(str) : null;
            Map<String, Object> parseJsonToMap2 = TextUtils.isEmpty(str2) ? null : parseJsonToMap(str2);
            if (!isEmptyMap(parseJsonToMap) && !isEmptyMap(parseJsonToMap2)) {
                parseJsonToMap2.putAll(parseJsonToMap);
                clearMapEmptyValue(parseJsonToMap2);
                return JSON.toJSONString(parseJsonToMap2);
            } else if (!isEmptyMap(parseJsonToMap) && isEmptyMap(parseJsonToMap2)) {
                clearMapEmptyValue(parseJsonToMap);
                return JSON.toJSONString(parseJsonToMap);
            } else if (!isEmptyMap(parseJsonToMap) || isEmptyMap(parseJsonToMap2)) {
                return "";
            } else {
                clearMapEmptyValue(parseJsonToMap2);
                return JSON.toJSONString(parseJsonToMap2);
            }
        } catch (Exception e) {
            Logger.f("", e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setH5Called(Object obj) {
        if (obj != null) {
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            if (_getOrNewAUTPageEventObject.getPageStatus() != null) {
                _getOrNewAUTPageEventObject.setH5Called();
            }
        }
    }

    public void setLastCacheKey(String str) {
        this.mLastCacheKey = str;
    }

    public void setLastCacheKeyScmUrl(String str) {
        this.mLastCacheKeyScmUrl = str;
    }

    public void setLastCacheKeySpmUrl(String str) {
        this.mLastCacheKeySpmUrl = str;
    }

    public void setLastCacheKeyUtParam(String str) {
        this.mLastCacheKeyUtParam = str;
    }

    public void setLastCacheKeyUtParamCnt(String str) {
        this.mLastCacheKeyUtParamCnt = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setPageStatusCode(Object obj, int i) {
        if (obj == null) {
            return;
        }
        _getOrNewAUTPageEventObject(obj).setPageStatusCode(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void skipBack(Object obj) {
        if (obj == null) {
            return;
        }
        UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
        if (orNewUTPageStateObject != null) {
            orNewUTPageStateObject.mIsSkipBack = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void skipBackForever(Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        UTPageStateObject orNewUTPageStateObject = getOrNewUTPageStateObject(obj);
        if (orNewUTPageStateObject != null) {
            orNewUTPageStateObject.mIsSkipBackForever = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void skipNextPageBack() {
        this.mNextPageSkipBack = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void skipPage(Object obj) {
        if (obj == null) {
            return;
        }
        Logger.f(TAG, "skipPage", obj);
        _getOrNewAUTPageEventObject(obj).setToSkipPage();
    }

    @Deprecated
    public synchronized void turnOffAutoPageTrack() {
        this.mIsTurnOff = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateNextPageProperties(Map<String, String> map) {
        if (map != null) {
            Map<String, String> map2 = this.mNextPageProperties;
            if (map2 == null) {
                this.mNextPageProperties = new HashMap(map);
            } else {
                map2.putAll(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateNextPageUtparam(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            Map<String, String> map = this.mNextPageProperties;
            if (map != null) {
                str2 = map.get("utparam-url");
            } else {
                this.mNextPageProperties = new HashMap();
            }
            String refreshUtParam = refreshUtParam(str, str2);
            if (!TextUtils.isEmpty(refreshUtParam)) {
                HashMap hashMap = new HashMap();
                hashMap.put("utparam-url", refreshUtParam);
                this.mNextPageProperties.putAll(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateNextPageUtparamCnt(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            Map<String, String> map = this.mNextPageProperties;
            if (map != null) {
                str2 = map.get("utparam-cnt");
            } else {
                this.mNextPageProperties = new HashMap();
            }
            String refreshUtParam = refreshUtParam(str, str2);
            if (!TextUtils.isEmpty(refreshUtParam)) {
                HashMap hashMap = new HashMap();
                hashMap.put("utparam-cnt", refreshUtParam);
                this.mNextPageProperties.putAll(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updatePageName(Object obj, String str) {
        Logger.f(TAG, "updatePageName", str);
        if (obj != null && !yh2.f(str)) {
            _getOrNewAUTPageEventObject(obj).setPageName(str);
            this.mCurPage = str;
        }
    }

    @Deprecated
    public synchronized void updatePageProperties(Map<String, String> map) {
        if (map != null) {
            Logger.i(TAG, "UTPageHitHelper.updatePageProperties is deprecated.Please use UTAnalytics.getInstance().getDefaultTracker().updatePageProperties with PageObject parameter.");
            this.mPageProperties.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        if (obj == null) {
            return;
        }
        _getOrNewAUTPageEventObject(obj).setPageStatus(uTPageStatus);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updatePageUrl(Object obj, Uri uri) {
        if (obj == null) {
            return;
        }
        _getOrNewAUTPageEventObject(obj).setPageUrl(uri);
        UTPagePropertiesHelper.updatePageProperties(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updatePageUtparam(Object obj, String str) {
        if (obj != null) {
            if (!yh2.f(str)) {
                Map<String, String> pageProperties = getPageProperties(obj);
                String refreshUtParam = refreshUtParam(str, pageProperties != null ? pageProperties.get("utparam-cnt") : "");
                if (!TextUtils.isEmpty(refreshUtParam)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("utparam-cnt", refreshUtParam);
                    updatePageProperties(obj, hashMap);
                }
                UTPagePropertiesHelper.updatePageProperties(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void pageAppear(Object obj, String str, boolean z) {
        UTPageStateObject orNewUTPageStateObject;
        UTPageStateObject orNewUTPageStateObject2;
        Logger.f(TAG, "pageAppear aPageObject", obj, "aCustomPageName", str, "aIsDonotSkipFlag", Boolean.valueOf(z));
        if (!UTAnalytics.getInstance().isInit()) {
            Logger.i(TAG, "pageAppear", "Please initialize UT_Analytics first");
            return;
        }
        if (obj != null) {
            String _getPageEventObjectCacheKey = _getPageEventObjectCacheKey(obj);
            if (_getPageEventObjectCacheKey != null && _getPageEventObjectCacheKey.equals(this.mCurrentPageCacheKey)) {
                Logger.f(TAG, "pageAppear", "pageAppear repeat");
                return;
            }
            if (this.mCurrentPageCacheKey != null) {
                Logger.i("lost 2001", "Last page requires leave(" + this.mCurrentPageCacheKey + ").");
            }
            UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
            if (!z && _getOrNewAUTPageEventObject.isSkipPage()) {
                Logger.m("skip page[pageAppear]", "page name:" + obj.getClass().getSimpleName());
                return;
            }
            UTPvidHelper.pageAppear();
            UTTrackerListenerMgr.getInstance().pageAppear(UTAnalytics.getInstance().getDefaultTracker(), obj, str, z);
            disPathcherPageChangerEvent(0, obj);
            UTOperationStack uTOperationStack = UTOperationStack.getInstance();
            uTOperationStack.addAction("pageAppear:" + obj.getClass().getSimpleName());
            String h5Url = UTVariables.getInstance().getH5Url();
            if (h5Url != null) {
                UTVariables.getInstance().setBackupH5Url(h5Url);
                Uri parse = Uri.parse(h5Url);
                String queryParameter = parse.getQueryParameter("spm");
                String queryParameter2 = parse.getQueryParameter("scm");
                this.mPageProperties.put("spm", queryParameter);
                this.mPageProperties.put("scm", queryParameter2);
                UTVariables.getInstance().setH5Url(null);
            }
            String _getPageName = _getPageName(obj);
            if (UTExtendSwitch.bJTrackExtend) {
                try {
                    String pageName = JTrackExtend.getPageName(obj.getClass().getSimpleName());
                    if (!TextUtils.isEmpty(pageName)) {
                        if (pageName.toLowerCase().endsWith("activity")) {
                            pageName = pageName.substring(0, pageName.length() - 8);
                        }
                        Logger.m("JTrack", "getPageName:" + pageName);
                        _getPageName = pageName;
                    }
                } catch (Throwable unused) {
                }
            }
            if (yh2.f(str)) {
                str = _getPageName;
            }
            if (!yh2.f(_getOrNewAUTPageEventObject.getPageName())) {
                str = _getOrNewAUTPageEventObject.getPageName();
            }
            this.mCurPage = str;
            _getOrNewAUTPageEventObject.setPageName(str);
            _getOrNewAUTPageEventObject.setPageAppearTimestamp(System.currentTimeMillis());
            _getOrNewAUTPageEventObject.setPageStayTimstamp(SystemClock.elapsedRealtime());
            _getOrNewAUTPageEventObject.setRefPage(UTVariables.getInstance().getRefPage());
            _getOrNewAUTPageEventObject.setPageAppearCalled();
            Map<String, String> map = this.mNextPageProperties;
            if (map != null) {
                this.mBackupNextPageProperties = map;
                _getOrNewAUTPageEventObject.setNextPageProperties(map);
                Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                if (pageProperties == null) {
                    _getOrNewAUTPageEventObject.setPageProperties(this.mNextPageProperties);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(pageProperties);
                    hashMap.putAll(this.mNextPageProperties);
                    _getOrNewAUTPageEventObject.setPageProperties(hashMap);
                }
            }
            this.mNextPageProperties = null;
            this.mCurrentPageCacheKey = _getPageEventObjectCacheKey(obj);
            if (this.mNextPageSkipBack && (orNewUTPageStateObject2 = getOrNewUTPageStateObject(obj)) != null) {
                orNewUTPageStateObject2.mIsSkipBack = true;
                this.mNextPageSkipBack = false;
            }
            _clearUTPageEventObjectCache(_getOrNewAUTPageEventObject);
            _putUTPageEventObjectToCache(_getPageEventObjectCacheKey(obj), _getOrNewAUTPageEventObject);
            if (z && _getOrNewAUTPageEventObject.isSkipPage() && (orNewUTPageStateObject = getOrNewUTPageStateObject(obj)) != null) {
                orNewUTPageStateObject.mIsFrame = true;
            }
        } else {
            Logger.i("pageAppear", "The page object should not be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updatePageProperties(Object obj, Map<String, String> map) {
        if (obj != null && map != null) {
            if (map.size() != 0) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                UTPageEventObject _getOrNewAUTPageEventObject = _getOrNewAUTPageEventObject(obj);
                Map<String, String> pageProperties = _getOrNewAUTPageEventObject.getPageProperties();
                if (pageProperties == null) {
                    _getOrNewAUTPageEventObject.setPageProperties(hashMap);
                } else {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.putAll(pageProperties);
                    hashMap2.putAll(hashMap);
                    _getOrNewAUTPageEventObject.setPageProperties(hashMap2);
                }
                UTPagePropertiesHelper.updatePageProperties(obj);
                return;
            }
        }
        Logger.i("", "failed to update project properties");
    }

    synchronized void pageAppear(Object obj, String str) {
        pageAppear(obj, str, false);
    }

    @Deprecated
    public synchronized void pageDisAppear(Object obj) {
        pageDisAppear(obj, UTAnalytics.getInstance().getDefaultTracker());
    }
}
