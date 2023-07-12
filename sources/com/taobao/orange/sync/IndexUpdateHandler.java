package com.taobao.orange.sync;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.alibaba.fastjson.JSON;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.orange.ConfigCenter;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.OThreadFactory;
import com.taobao.orange.util.AndroidUtil;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IndexUpdateHandler {
    private static final long CHECK_INDEX_UPD_INTERVAL = 20000;
    static final String TAG = "IndexUpdateHandler";
    private static boolean disableTaobaoClientIndexCheckUpd = true;
    private static volatile long lastIndexUpdTime;
    static final Set<IndexUpdateInfo> mCurIndexUpdInfo = new HashSet();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IndexUpdateInfo implements Serializable {
        static final String SYNC_KEY_BASE_VERSION = "baseVersion";
        static final String SYNC_KEY_CDN = "cdn";
        static final String SYNC_KEY_MD5 = "md5";
        static final String SYNC_KEY_PROTOCOL = "protocol";
        static final String SYNC_KEY_RESOURCEID = "resourceId";
        public String baseVersion;
        public String cdn;
        public String md5;
        public String protocol;
        public String resourceId;

        public boolean checkValid() {
            if (TextUtils.isEmpty(this.cdn) || TextUtils.isEmpty(this.resourceId) || TextUtils.isEmpty(this.md5)) {
                OLog.w(IndexUpdateHandler.TAG, "lack param", new Object[0]);
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IndexUpdateInfo indexUpdateInfo = (IndexUpdateInfo) obj;
            if (this.cdn.equals(indexUpdateInfo.cdn) && this.resourceId.equals(indexUpdateInfo.resourceId)) {
                return this.md5.equals(indexUpdateInfo.md5);
            }
            return false;
        }

        public int hashCode() {
            return (((this.cdn.hashCode() * 31) + this.resourceId.hashCode()) * 31) + this.md5.hashCode();
        }

        public String toString() {
            return "IndexUpdateInfo{cdn='" + this.cdn + "', resourceId='" + this.resourceId + "', md5='" + this.md5 + "', protocol='" + this.protocol + "', baseVersion='" + this.baseVersion + "'}";
        }
    }

    public static void checkIndexUpdate(final String str, final String str2) {
        if (AndroidUtil.isTaobaoPackage(GlobalOrange.context) && disableTaobaoClientIndexCheckUpd) {
            OLog.w(TAG, "checkIndexUpdate skip as in com.taobao.taobao package", new Object[0]);
            return;
        }
        synchronized (IndexUpdateHandler.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastIndexUpdTime <= CHECK_INDEX_UPD_INTERVAL) {
                OLog.w(TAG, "checkIndexUpdate too frequently, interval should more than 20s", new Object[0]);
                return;
            }
            lastIndexUpdTime = currentTimeMillis;
            OLog.i(TAG, "checkIndexUpdate", OConstant.DIMEN_INDEX_UPDATE_APP_INDEX_VERSION, str, "versionIndexVersion", str2);
            OThreadFactory.execute(new Runnable() { // from class: com.taobao.orange.sync.IndexUpdateHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    IndexUpdateHandler.updateIndex(new BaseAuthRequest<String>(null, false, GlobalOrange.indexDiff == 0 ? OConstant.REQTYPE_INDEX_UPDATE : OConstant.REQTYPE_PROBE_UPDATE) { // from class: com.taobao.orange.sync.IndexUpdateHandler.1.1
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected Map<String, String> getReqParams() {
                            HashMap hashMap = new HashMap();
                            hashMap.put(OConstant.KEY_CLIENTAPPINDEXVERSION, str);
                            hashMap.put(OConstant.KEY_CLIENTVERSIONINDEXVERSION, str2);
                            return hashMap;
                        }

                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        protected String getReqPostBody() {
                            return null;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.taobao.orange.sync.BaseAuthRequest
                        public String parseResContent(String str3) {
                            return str3;
                        }
                    }.syncRequest(), true);
                }
            });
        }
    }

    private static IndexUpdateInfo parseIndexUpdInfo(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            return (IndexUpdateInfo) JSON.parseObject(str, IndexUpdateInfo.class);
        }
        String[] split = str.split("&");
        if (split != null) {
            IndexUpdateInfo indexUpdateInfo = new IndexUpdateInfo();
            for (String str2 : split) {
                if (str2 != null) {
                    String substring = str2.substring(str2.indexOf("=") + 1);
                    if (str2.startsWith(ConnType.PK_CDN)) {
                        indexUpdateInfo.cdn = substring.trim();
                    } else if (str2.startsWith("md5")) {
                        indexUpdateInfo.md5 = substring.trim();
                    } else if (str2.startsWith("resourceId")) {
                        indexUpdateInfo.resourceId = substring.trim();
                    } else if (str2.startsWith("protocol")) {
                        indexUpdateInfo.protocol = substring;
                    } else if (str2.startsWith(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION)) {
                        indexUpdateInfo.baseVersion = substring.trim();
                    }
                }
            }
            return indexUpdateInfo;
        }
        return null;
    }

    public static void updateIndex(String str, boolean z) {
        try {
            IndexUpdateInfo parseIndexUpdInfo = parseIndexUpdInfo(str, z);
            if (parseIndexUpdInfo == null || !parseIndexUpdInfo.checkValid()) {
                return;
            }
            Set<IndexUpdateInfo> set = mCurIndexUpdInfo;
            synchronized (set) {
                if (!set.add(parseIndexUpdInfo)) {
                    if (OLog.isPrintLog(0)) {
                        OLog.v(TAG, "updateIndex is ongoing", new Object[0]);
                    }
                    return;
                }
                if (OLog.isPrintLog(2)) {
                    OLog.i(TAG, "updateIndex", parseIndexUpdInfo);
                }
                GlobalOrange.schema = "https".equalsIgnoreCase(parseIndexUpdInfo.protocol) ? "https" : "http";
                ConfigCenter.getInstance().updateIndex(parseIndexUpdInfo);
                synchronized (set) {
                    set.remove(parseIndexUpdInfo);
                }
            }
        } catch (Throwable th) {
            OLog.e(TAG, "updateIndex", th, new Object[0]);
        }
    }
}
