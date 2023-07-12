package com.taobao.tao.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogController implements ITLogController {
    private static final String TAG = "TLogController";
    private LogLevel logLevel;
    private Map<String, LogLevel> moduleFilter;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static final TLogController INSTANCE = new TLogController();

        private SingletonHolder() {
        }
    }

    public static final TLogController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addModuleFilter(Map<String, LogLevel> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            getInstance().addModuleFilter(str, map.get(str));
        }
    }

    @Override // com.taobao.tao.log.ITLogController
    public boolean checkLogLength(String str) {
        return false;
    }

    public void cleanModuleFilter() {
        this.moduleFilter.clear();
        TLog.loge(TAG, "", String.format("cleanModuleFilter", new Object[0]));
    }

    public void closeLog() {
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.setLogLevel(LogLevel.L.getIndex());
                TLogNative.appenderClose();
                TTraceLog.release();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.taobao.tao.log.ITLogController
    public String compress(String str) {
        return null;
    }

    @Override // com.taobao.tao.log.ITLogController
    public void destroyLog(boolean z) {
    }

    @Override // com.taobao.tao.log.ITLogController
    public byte[] ecrypted(byte[] bArr) {
        return new byte[0];
    }

    @Override // com.taobao.tao.log.ITLogController
    public byte[] ecrypted(byte[] bArr, int i, int i2) {
        return new byte[0];
    }

    @Override // com.taobao.tao.log.ITLogController
    public LogLevel getLogLevel(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.logLevel;
        }
        LogLevel logLevel = this.moduleFilter.get(str);
        return logLevel == null ? this.logLevel : logLevel;
    }

    @Override // com.taobao.tao.log.ITLogController
    public boolean isFilter(LogLevel logLevel, String str) {
        LogLevel logLevel2 = this.logLevel;
        if (logLevel2 != null && logLevel != null && str != null) {
            if (logLevel2.getIndex() <= logLevel.getIndex()) {
                return true;
            }
            int indexOf = str.indexOf(".");
            if (indexOf >= 0 && indexOf < str.length()) {
                String substring = str.substring(0, indexOf);
                if (!TextUtils.isEmpty(substring) && this.moduleFilter.size() > 0 && this.moduleFilter.get(substring) != null && this.moduleFilter.get(substring).getIndex() <= logLevel.getIndex()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.taobao.tao.log.ITLogController
    public boolean isOpenLog() {
        return true;
    }

    @Override // com.taobao.tao.log.ITLogController
    public void openLog(boolean z) {
    }

    public void resumeLog(Context context, LogLevel logLevel) {
        if (TLogInitializer.getInstance().getInitState() != 2) {
            return;
        }
        try {
            String logCacheDir = TLogInitializer.getInstance().getLogCacheDir(context);
            File file = TLogInitializer.getInstance().logDir;
            String appkey = TLogInitializer.getInstance().getAppkey();
            String nameprefix = TLogInitializer.getInstance().getNameprefix();
            long logMaxSize = TLogInitializer.getInstance().getLogMaxSize();
            long buffersize = TLogInitializer.getInstance().getBuffersize();
            boolean isUseZstd = TLogInitializer.getInstance().isUseZstd();
            int zstdLevel = TLogInitializer.getInstance().getZstdLevel();
            Log.e(TAG, "resumeLog. logLevel:" + logLevel + " logDir:" + file.getAbsolutePath() + " namePrefix:" + nameprefix + " appKey:" + appkey + " cacheDir:" + logCacheDir + " maxFileSize:" + logMaxSize);
            TLogNative.appenderOpen(logLevel.getIndex(), logCacheDir, file.getAbsolutePath(), nameprefix, appkey, logMaxSize, buffersize, isUseZstd, zstdLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.log.ITLogController
    @Deprecated
    public void setEndTime(long j) {
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.setLogLevel(logLevel.getIndex());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.taobao.tao.log.ITLogController
    public void setModuleFilter(Map<String, LogLevel> map) {
        addModuleFilter(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateAsyncConfig() {
        if (this.moduleFilter == null || this.logLevel == null || !TLogNative.isSoOpen()) {
            return;
        }
        try {
            TLogNative.setLogLevel(this.logLevel.getIndex());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    private TLogController() {
        this.logLevel = LogLevel.E;
        this.moduleFilter = new ConcurrentHashMap();
    }

    @Override // com.taobao.tao.log.ITLogController
    public void setLogLevel(String str) {
        updateLogLevel(TLogUtils.convertLogLevel(str));
    }

    public void addModuleFilter(String str, LogLevel logLevel) {
        if (str == null) {
            return;
        }
        TLog.loge(TAG, "", String.format("addModuleFilter: %s-%s", str, logLevel.getName()));
        this.moduleFilter.put(str, logLevel);
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.addModuleFilter(str, logLevel.getIndex());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
