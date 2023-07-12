package com.uc.webview.export.cyclone.update;

import android.content.Context;
import android.os.Looper;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class Utils {
    private static final String TAG = "UpdateService";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface LogHelper {
        void print(String str, String str2, Throwable th);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class StatKey {
        public static final String DOWNLOAD = "sdk_dl";
        public static final String DOWNLOAD_EXCEPTION = "sdk_dl_e";
        public static final String DOWNLOAD_EXISTS = "sdk_dl_x";
        public static final String DOWNLOAD_FAILED = "sdk_dl_f";
        public static final String DOWNLOAD_RECOVERED = "sdk_dl_r";
        public static final String DOWNLOAD_SUCCESS = "sdk_dl_s";
        public static final String UCM = "sdk_ucm";
        public static final String UCM_DISK_MB = "sdk_ucm_dm";
        public static final String UCM_DISK_PERCENT = "sdk_ucm_dp";
        public static final String UCM_EXCEPTION_CHECK = "sdk_ucm_en";
        public static final String UCM_EXCEPTION_DOWNLOAD = "sdk_ucm_e1";
        public static final String UCM_EXCEPTION_UPDATE = "sdk_dec7z";
        public static final String UCM_EXISTS = "sdk_ucm_e";
        public static final String UCM_FAILED_DOWNLOAD = "sdk_dec7z_s";
        public static final String UCM_LAST_EXCEPTION = "sdk_ucm_le";
        public static final String UCM_OLD = "sdk_ucm_old";
        public static final String UCM_PERCENT = "sdk_ucm_p";
        public static final String UCM_RECOVERED = "sdk_ucm_f";
        public static final String UCM_SUCCESS = "sdk_ucm_s";
        public static final String UCM_SUCCESS_NOT_CORE_DOWNLAOD = "sdk_ucm_so";
        public static final String UCM_WIFI = "sdk_ucm_wifi";
    }

    Utils() {
    }

    public static void deleteAll(File file, LogHelper logHelper) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteAll(file2, logHelper);
            }
        }
        if (logHelper != null) {
            logHelper.print(TAG, "delete [" + file.getAbsolutePath() + jn1.ARRAY_END_STR, null);
        }
        file.delete();
    }

    public static File getDownloadDir(Context context, String str) {
        File cacheDir = context.getApplicationContext().getCacheDir();
        return new File(cacheDir, "ucbsup_" + getUrlHash(str));
    }

    public static File getExtractDir(File file, String str, long j, long j2) {
        return new File(file, getUrlHash(str) + "/" + (String.valueOf(j) + JSMethod.NOT_SET + j2));
    }

    public static String getUrlHash(String str) {
        return String.valueOf(str.hashCode()).replace('-', '_');
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
