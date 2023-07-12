package android.taobao.windvane.cache;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.util.StorageMgr;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFileCacheFactory {
    private static WVFileCacheFactory cacheFactory;

    private WVFileCacheFactory() {
    }

    public static synchronized WVFileCacheFactory getInstance() {
        WVFileCacheFactory wVFileCacheFactory;
        synchronized (WVFileCacheFactory.class) {
            if (cacheFactory == null) {
                cacheFactory = new WVFileCacheFactory();
            }
            wVFileCacheFactory = cacheFactory;
        }
        return wVFileCacheFactory;
    }

    public WVFileCache createFileCache(String str, String str2, int i, boolean z) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("FileCacheFactory", "createFileCache: " + str + "/" + str2 + " capacity: " + i + " sdcard: " + z);
        }
        if (str2 != null && i >= 10) {
            boolean z2 = z && StorageMgr.checkSDCard();
            String createBaseDir = FileManager.createBaseDir(GlobalConfig.context, str, str2, z2);
            String createInnerfileStorage = FileManager.createInnerfileStorage(GlobalConfig.context, str, str2);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("FileCacheFactory", "base dir: " + createBaseDir);
            }
            WVFileCache wVFileCache = new WVFileCache(createBaseDir, createInnerfileStorage, i, z2);
            if (wVFileCache.init()) {
                return wVFileCache;
            }
            TaoLog.w("FileCacheFactory", "init FileCache failed");
            return null;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("FileCacheFactory", "createFileCache: url is null, or capacity is too small");
        }
        return null;
    }
}
