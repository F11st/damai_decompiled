package android.taobao.windvane.cache;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.prefetch.WVPrefetchHandler;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVConstants;
import android.text.TextUtils;
import com.taobao.weaver.prefetch.WMLPrefetch;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVCacheManager {
    private static final String TAG = "WVCacheManager";
    private static WVCacheManager cacheManager;
    private WVFileCache fileCache;
    private WVFileCache imagePool;

    private WVCacheManager() {
    }

    private boolean checkCacheDirIsNull() {
        return this.fileCache == null || this.imagePool == null;
    }

    public static synchronized WVCacheManager getInstance() {
        WVCacheManager wVCacheManager;
        synchronized (WVCacheManager.class) {
            if (cacheManager == null) {
                cacheManager = new WVCacheManager();
            }
            wVCacheManager = cacheManager;
        }
        return wVCacheManager;
    }

    public String getCacheDir(boolean z) {
        if (checkCacheDirIsNull()) {
            return null;
        }
        if (z) {
            return this.imagePool.getDirPath();
        }
        return this.fileCache.getDirPath();
    }

    public File getTempDir(boolean z) {
        String str;
        if (checkCacheDirIsNull()) {
            return null;
        }
        if (z) {
            str = this.imagePool.getDirPath() + File.separator + "temp";
        } else {
            str = this.fileCache.getDirPath() + File.separator + "temp";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public void init(Context context) {
        init(context, null, 0);
    }

    public boolean isCacheEnabled(String str) {
        if (str.contains(WVConstants.LOCAL_CACHE_TAG)) {
            Uri parse = Uri.parse(str);
            return (parse != null && parse.isHierarchical() && TextUtils.isEmpty(parse.getQueryParameter(WVConstants.LOCAL_CACHE_TAG)) && "0".equals(parse.getQueryParameter(WVConstants.LOCAL_CACHE_TAG))) ? false : true;
        }
        return false;
    }

    public boolean writeToFile(WVFileInfo wVFileInfo, byte[] bArr) {
        if (checkCacheDirIsNull()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (CommonUtils.isImage(wVFileInfo.mimeType)) {
            return this.imagePool.write(wVFileInfo, wrap);
        }
        String sha256ToHex = DigestUtils.sha256ToHex(bArr);
        if (sha256ToHex == null) {
            return false;
        }
        wVFileInfo.sha256ToHex = sha256ToHex;
        return this.fileCache.write(wVFileInfo, wrap);
    }

    public synchronized void init(Context context, String str, int i) {
        if (context != null) {
            TaoLog.d(TAG, "start init.");
            long currentTimeMillis = System.currentTimeMillis();
            WMLPrefetch.getInstance().registerHandler(new WVPrefetchHandler());
            if (this.fileCache == null) {
                this.fileCache = WVFileCacheFactory.getInstance().createFileCache(str, WVConstants.WEBCACHE_FOLDER, 250, true);
                this.imagePool = WVFileCacheFactory.getInstance().createFileCache(str, WVConstants.IMAGE_CACHE_FOLDER, 300, true);
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d(TAG, "init finish.  cost time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } else {
            throw new NullPointerException("CacheManager init error, context is null");
        }
    }
}
