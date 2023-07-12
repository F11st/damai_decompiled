package android.taobao.windvane.config;

import android.os.Handler;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCPrecacheManager implements WVEventListener {
    private static final String TAG = "WVUCPrecacheManager";
    private static WVUCPrecacheManager mInstance = null;
    private static boolean sCanClearByCommonConfig = false;
    private static boolean sCanClearByZcacheUpdate = false;
    private static boolean sCanPrecacheByCommonConfig = false;
    private static boolean sCanPrecacheByZcacheUpdate = false;
    private static boolean sHasInitUrlSet = false;
    private static boolean sHasPrecache = false;
    private static boolean sLastEnableUCPrecache = false;
    private static String sLastPrecachePackageName = "";
    private static long sLastPrecacheTime = -1;
    private static final long sMaxPrecacheTime = 3600000;
    private static HashSet<String> sPreMemCacheUrlSet = new HashSet<>();
    private static HashSet<String> sPrecacheDocResMap = new HashSet<>();
    private Handler mPrecacheHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class WVUCPrecacheManagerHolder {
        static final WVUCPrecacheManager sInstance = new WVUCPrecacheManager();

        private WVUCPrecacheManagerHolder() {
        }
    }

    public static boolean canClearPrecache() {
        if (sHasPrecache) {
            if (sCanClearByCommonConfig || sCanClearByZcacheUpdate) {
                return true;
            }
            return sLastPrecacheTime > 0 && System.currentTimeMillis() - sLastPrecacheTime > 3600000;
        }
        return false;
    }

    public static boolean canPrecache() {
        if (WVCommonConfig.commonConfig.enableUCPrecache && !TextUtils.isEmpty(sLastPrecachePackageName)) {
            if (!sHasInitUrlSet) {
                sHasInitUrlSet = true;
                updatePreMemCacheUrls();
            }
            HashSet<String> hashSet = sPreMemCacheUrlSet;
            if (hashSet != null && hashSet.size() > 0) {
                return sCanPrecacheByCommonConfig || sCanPrecacheByZcacheUpdate || !sHasPrecache;
            }
        }
        return false;
    }

    public static WVUCPrecacheManager getInstance() {
        return WVUCPrecacheManagerHolder.sInstance;
    }

    private void init() {
        WVEventService.getInstance().addEventListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void notifyUpdateCommonConfig() {
        /*
            android.taobao.windvane.config.WVCommonConfigData r0 = android.taobao.windvane.config.WVCommonConfig.commonConfig
            boolean r1 = r0.enableUCPrecache
            java.lang.String r0 = r0.precachePackageName
            boolean r2 = android.taobao.windvane.config.WVUCPrecacheManager.sLastEnableUCPrecache
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L14
            if (r1 != 0) goto L14
            android.taobao.windvane.config.WVUCPrecacheManager.sCanClearByCommonConfig = r4
            android.taobao.windvane.config.WVUCPrecacheManager.sCanPrecacheByCommonConfig = r3
        L12:
            r3 = 1
            goto L1d
        L14:
            if (r2 != 0) goto L1d
            if (r1 == 0) goto L1d
            android.taobao.windvane.config.WVUCPrecacheManager.sCanClearByCommonConfig = r4
            android.taobao.windvane.config.WVUCPrecacheManager.sCanPrecacheByCommonConfig = r4
            goto L12
        L1d:
            java.lang.String r2 = android.taobao.windvane.config.WVUCPrecacheManager.sLastPrecachePackageName
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L30
            android.taobao.windvane.config.WVUCPrecacheManager.sCanClearByCommonConfig = r4
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L31
            android.taobao.windvane.config.WVUCPrecacheManager.sCanPrecacheByCommonConfig = r4
            goto L31
        L30:
            r4 = r3
        L31:
            android.taobao.windvane.config.WVUCPrecacheManager.sLastEnableUCPrecache = r1
            android.taobao.windvane.config.WVUCPrecacheManager.sLastPrecachePackageName = r0
            if (r4 != 0) goto L3b
            boolean r0 = android.taobao.windvane.config.WVUCPrecacheManager.sHasInitUrlSet
            if (r0 != 0) goto L3e
        L3b:
            updatePreMemCacheUrls()
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.config.WVUCPrecacheManager.notifyUpdateCommonConfig():void");
    }

    private static void notifyUpdateZcache(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(sLastPrecachePackageName)) {
            return;
        }
        sCanClearByZcacheUpdate = true;
        sCanPrecacheByZcacheUpdate = true;
        updatePreMemCacheUrls();
    }

    public static HashSet<String> preMemCacheUrlSet() {
        return sPreMemCacheUrlSet;
    }

    public static void resetClearConfig() {
        sCanClearByCommonConfig = false;
        sCanClearByZcacheUpdate = false;
    }

    public static void resetPrecacheConfig() {
        sCanPrecacheByCommonConfig = false;
        sCanPrecacheByZcacheUpdate = false;
    }

    private void sendClearPrecacheDocMessage(final String str) {
        if (sPrecacheDocResMap.size() <= 0) {
            return;
        }
        if (this.mPrecacheHandler == null) {
            this.mPrecacheHandler = new Handler();
        }
        this.mPrecacheHandler.postDelayed(new Runnable() { // from class: android.taobao.windvane.config.WVUCPrecacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                WVUCPrecacheManager.this.clearPrecacheDoc(str);
            }
        }, 10000L);
    }

    public static void setHasPrecache(boolean z) {
        sHasPrecache = z;
        if (z) {
            sLastPrecacheTime = System.currentTimeMillis();
        } else {
            sLastPrecacheTime = -1L;
        }
    }

    private static void updatePreMemCacheUrls() {
        Object obj;
        if (WVCommonConfig.commonConfig.enableUCPrecache && !TextUtils.isEmpty(sLastPrecachePackageName)) {
            WVEventResult onEvent = WVEventService.getInstance().onEvent(WVEventId.GET_URLS_BY_APP_NAME, sLastPrecachePackageName);
            if (onEvent.isSuccess && (obj = onEvent.resultObj) != null && (obj instanceof HashSet)) {
                sPreMemCacheUrlSet = (HashSet) obj;
                sHasInitUrlSet = true;
                return;
            }
            return;
        }
        sPreMemCacheUrlSet = new HashSet<>();
    }

    public void addPrecacheDoc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
            str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
        sPrecacheDocResMap.add(str);
        sendClearPrecacheDocMessage(str);
    }

    public boolean canPrecacheDoc(String str) {
        if (!WVCommonConfig.commonConfig.enableUCPrecacheDoc || TextUtils.isEmpty(str)) {
            return false;
        }
        if (sPreMemCacheUrlSet.isEmpty()) {
            return true;
        }
        Iterator<String> it = sPreMemCacheUrlSet.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void clearPrecacheDoc(String str) {
        if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
            str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
        sPrecacheDocResMap.remove(str);
    }

    public boolean hasPrecacheDoc(String str) {
        if (str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) > 0) {
            str = str.substring(0, str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
        return sPrecacheDocResMap.contains(str);
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        if (i == 6008) {
            notifyUpdateZcache((String) objArr[0]);
            return null;
        } else if (i != 6012) {
            return null;
        } else {
            notifyUpdateCommonConfig();
            return null;
        }
    }

    private WVUCPrecacheManager() {
        this.mPrecacheHandler = null;
        init();
    }
}
