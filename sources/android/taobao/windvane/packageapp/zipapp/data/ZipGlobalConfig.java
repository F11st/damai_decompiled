package android.taobao.windvane.packageapp.zipapp.data;

import android.taobao.windvane.packageapp.ZipAppFileManager;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZipGlobalConfig {
    private String TAG = "ZipGlobalConfig";
    public String v = "0";
    public String i = "0";
    public String online_v = null;
    private Map<String, ZipAppInfo> mAppsMap = new ConcurrentHashMap();
    private Hashtable<String, ArrayList<String>> mZcacheResConfig = new Hashtable<>();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CacheFileData {
        public String appName;
        public String errorCode;
        public String path;
        public long seq;
        public String v;
    }

    public void addZcacheResConfig(String str, ArrayList<String> arrayList) {
        if (str == null || arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.mZcacheResConfig.put(str, arrayList);
        String str2 = this.TAG;
        TaoLog.d(str2, "ZcacheforDebug 新增zcache name:" + str);
    }

    public ZipAppInfo getAppInfo(String str) {
        if (isAvailableData()) {
            return this.mAppsMap.get(str);
        }
        return null;
    }

    public Map<String, ZipAppInfo> getAppsTable() {
        return this.mAppsMap;
    }

    public Hashtable<String, ArrayList<String>> getZcacheResConfig() {
        return this.mZcacheResConfig;
    }

    public boolean isAllAppUpdated() {
        if (isAvailableData()) {
            try {
                for (Map.Entry<String, ZipAppInfo> entry : this.mAppsMap.entrySet()) {
                    ZipAppInfo value = entry.getValue();
                    if (value.status != ZipAppConstants.ZIP_REMOVED && value.s != value.installedSeq) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public boolean isAvailableData() {
        Map<String, ZipAppInfo> map = this.mAppsMap;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public CacheFileData isZcacheUrl(String str) {
        if (this.mZcacheResConfig != null) {
            try {
                str = WVUrlUtil.removeQueryParam(str);
                String md5ToHex = DigestUtils.md5ToHex(str);
                for (Map.Entry<String, ArrayList<String>> entry : this.mZcacheResConfig.entrySet()) {
                    ArrayList<String> value = entry.getValue();
                    String key = entry.getKey();
                    if (value != null && value.contains(md5ToHex)) {
                        ZipAppInfo zipAppInfo = this.mAppsMap.get(key);
                        if (this.mAppsMap != null && zipAppInfo != null) {
                            CacheFileData cacheFileData = new CacheFileData();
                            cacheFileData.appName = zipAppInfo.name;
                            cacheFileData.v = zipAppInfo.v;
                            cacheFileData.path = ZipAppFileManager.getInstance().getZipResAbsolutePath(zipAppInfo, md5ToHex, false);
                            cacheFileData.seq = zipAppInfo.s;
                            return cacheFileData;
                        }
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                String str2 = this.TAG;
                TaoLog.d(str2, "ZcacheforDebug 资源url 解析匹配异常，url=" + str);
                return null;
            }
        }
        return null;
    }

    public void putAppInfo2Table(String str, ZipAppInfo zipAppInfo) {
        Map<String, ZipAppInfo> map;
        if (str == null || zipAppInfo == null || zipAppInfo.getAppType() == ZipAppTypeEnum.ZIP_APP_TYPE_REACT || zipAppInfo.getAppType() == ZipAppTypeEnum.ZIP_APP_TYPE_UNKNOWN || (map = this.mAppsMap) == null) {
            return;
        }
        if (map.containsKey(str)) {
            ZipAppInfo zipAppInfo2 = this.mAppsMap.get(str);
            if (zipAppInfo.getInfo() == ZipUpdateInfoEnum.ZIP_UPDATE_INFO_DELETE) {
                if (!zipAppInfo2.isOptional && zipAppInfo.getAppType() != ZipAppTypeEnum.ZIP_APP_TYPE_ZCACHE) {
                    zipAppInfo2.isOptional = true;
                    return;
                }
                zipAppInfo2.status = ZipAppConstants.ZIP_REMOVED;
                zipAppInfo2.f = zipAppInfo.f;
                return;
            }
            zipAppInfo2.f = zipAppInfo.f;
            long j = zipAppInfo2.s;
            long j2 = zipAppInfo.s;
            if (j > j2) {
                return;
            }
            zipAppInfo2.s = j2;
            zipAppInfo2.v = zipAppInfo.v;
            zipAppInfo2.t = zipAppInfo.t;
            zipAppInfo2.z = zipAppInfo.z;
            zipAppInfo2.isOptional = zipAppInfo.isOptional;
            zipAppInfo2.isPreViewApp = zipAppInfo.isPreViewApp;
            ArrayList<String> arrayList = zipAppInfo.folders;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList<String> arrayList2 = zipAppInfo2.folders;
                TaoLog.e(this.TAG + "-Folders", "Before replace: " + zipAppInfo2.name + " [" + (arrayList2 == null ? -1 : arrayList2.size()) + "] ");
                zipAppInfo2.folders = zipAppInfo.folders;
                StringBuilder sb = new StringBuilder();
                sb.append(this.TAG);
                sb.append("-Folders");
                TaoLog.e(sb.toString(), "Replace " + zipAppInfo2.name + " folders to [" + zipAppInfo.folders.size() + "] ");
            }
            if (!TextUtils.isEmpty(zipAppInfo.mappingUrl)) {
                zipAppInfo2.mappingUrl = zipAppInfo.mappingUrl;
            }
            long j3 = zipAppInfo.installedSeq;
            if (j3 > 0) {
                zipAppInfo2.installedSeq = j3;
            }
            if (zipAppInfo.installedVersion.equals("0.0")) {
                return;
            }
            zipAppInfo2.installedVersion = zipAppInfo.installedVersion;
            return;
        }
        this.mAppsMap.put(str, zipAppInfo);
    }

    public void removeAppInfoFromTable(String str) {
        Map<String, ZipAppInfo> map;
        if (str == null || (map = this.mAppsMap) == null) {
            return;
        }
        map.remove(str);
    }

    public void removeZcacheRes(String str) {
        if (str != null) {
            this.mZcacheResConfig.remove(str);
            String str2 = this.TAG;
            TaoLog.d(str2, "ZcacheforDebug 删除zcache name:" + str);
        }
    }

    public void reset() {
        this.v = "0";
        this.i = "0";
        if (isAvailableData()) {
            this.mAppsMap.clear();
        }
        Hashtable<String, ArrayList<String>> hashtable = this.mZcacheResConfig;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    public void setZcacheResConfig(Hashtable<String, ArrayList<String>> hashtable) {
        Hashtable<String, ArrayList<String>> hashtable2 = this.mZcacheResConfig;
        if (hashtable2 != null) {
            hashtable2.putAll(hashtable);
            if (TaoLog.getLogStatus()) {
                String str = this.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("ZcacheforDebug 设置Zcache 的url map size:");
                sb.append(hashtable != null ? hashtable.size() : 0);
                TaoLog.d(str, sb.toString());
            }
        }
    }
}
