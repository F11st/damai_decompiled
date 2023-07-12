package com.youku.android.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Keep;
import com.taomai.android.h5container.api.TaoMaiFilePlugin;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OPRUtils {
    private static final String TAG = "OPR_v2_OPRUtils";
    private static Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OPRPhoneLevel {
        public static final String OPR_PHONE_LEVEL_HIGH = "1001";
        public static final String OPR_PHONE_LEVEL_LOW = "1003";
        public static final String OPR_PHONE_LEVEL_MEDIUM = "1002";
        public static final String OPR_PHONE_LEVEL_UNKNOWN = "0";
    }

    public static String getApsConfig(String str, String str2, String str3) {
        return ApsConfigUtils.getInstance().getConfig(str, str2, str3);
    }

    public static String getCurrentPhoneLevel() {
        long totalMemory = getTotalMemory();
        int i = (totalMemory > 4194304L ? 1 : (totalMemory == 4194304L ? 0 : -1));
        String str = (i <= 0 || Build.VERSION.SDK_INT <= 24) ? OPRPhoneLevel.OPR_PHONE_LEVEL_LOW : (i <= 0 || totalMemory > TaoMaiFilePlugin.FILE_MAX_SIZE) ? "1001" : OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM;
        Log.d(TAG, "getCurrentPhoneLevel: " + str + ", totalMem: " + totalMemory);
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getShader(java.lang.String r10) {
        /*
            java.lang.String r0 = "@"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 != 0) goto Lbe
            android.content.Context r2 = com.youku.android.utils.OPRUtils.mContext
            if (r2 != 0) goto L13
            goto Lbe
        L13:
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.youku.android.barrage.R.C7798raw.shaders
            java.io.InputStream r2 = r2.openRawResource(r3)
            r3 = 0
            int r4 = r2.available()     // Catch: java.io.IOException -> L34
            byte[] r4 = new byte[r4]     // Catch: java.io.IOException -> L34
            r2.read(r4)     // Catch: java.io.IOException -> L34
            java.lang.String r5 = new java.lang.String     // Catch: java.io.IOException -> L34
            java.lang.String r6 = "utf-8"
            r5.<init>(r4, r6)     // Catch: java.io.IOException -> L34
            r2.close()     // Catch: java.io.IOException -> L32
            goto L39
        L32:
            r2 = move-exception
            goto L36
        L34:
            r2 = move-exception
            r5 = r3
        L36:
            r2.printStackTrace()
        L39:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 != 0) goto Lb9
            java.lang.String r2 = com.youku.android.utils.EncryptUtils.base64Decrypt(r5)
            java.io.BufferedReader r4 = new java.io.BufferedReader
            java.io.StringReader r5 = new java.io.StringReader
            r5.<init>(r2)
            r4.<init>(r5)
            r2 = 0
            r5 = 0
            r6 = 0
        L50:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            if (r7 != 0) goto Lb7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.<init>()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.append(r0)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.append(r10)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r8 = " START"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            boolean r7 = r3.equals(r7)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r8 = 1
            if (r7 == 0) goto L77
            r5 = 1
            goto L7a
        L77:
            if (r5 != r8) goto L7a
            r6 = 1
        L7a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.<init>()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.append(r0)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.append(r10)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r9 = " END"
            r7.append(r9)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            boolean r7 = r3.equals(r7)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            if (r7 == 0) goto L95
            r5 = 0
        L95:
            if (r5 != r8) goto Lb7
            if (r6 != r8) goto Lb7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.<init>()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r7.append(r3)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r8 = "\n"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            r1.append(r7)     // Catch: java.lang.Throwable -> Lae java.io.IOException -> Lb3
            goto Lb7
        Lae:
            r7 = move-exception
            r7.printStackTrace()
            goto Lb7
        Lb3:
            r7 = move-exception
            r7.printStackTrace()
        Lb7:
            if (r3 != 0) goto L50
        Lb9:
            java.lang.String r10 = r1.toString()
            return r10
        Lbe:
            java.lang.String r10 = "OPR_v2_OPRUtils"
            java.lang.String r0 = "key is null or mContext is null"
            android.util.Log.e(r10, r0)
            java.lang.String r10 = ""
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.android.utils.OPRUtils.getShader(java.lang.String):java.lang.String");
    }

    public static long getTotalMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) mContext.getSystemService("activity")).getMemoryInfo(memoryInfo);
        Log.d(TAG, "getTotalMemory totalMem: " + memoryInfo.totalMem);
        return memoryInfo.totalMem;
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
