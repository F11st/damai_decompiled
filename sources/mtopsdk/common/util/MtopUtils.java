package mtopsdk.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.IOException;
import java.lang.Character;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.xstate.XState;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONObject;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class MtopUtils {
    public static final int MTOP_BIZID = 4099;
    private static final String TAG = "mtopsdk.MtopUtils";
    private static volatile Context mContext = null;
    private static volatile String mProcessName = null;
    private static final int mask = Integer.MAX_VALUE;
    private static AtomicInteger counter = new AtomicInteger();
    public static final List<String> apiWhiteList = Collections.singletonList("mtop.common.gettimestamp$*");
    private static final char[] UPPER_CASE_ENCRYPT_CHARS = {qb1.LEVEL_E, 'T', YKUpsConvert.CHAR_A, 'O', qb1.LEVEL_I, 'N', 'S', 'R', 'H', qb1.LEVEL_L, qb1.LEVEL_D, 'C', 'U', 'M', YKUpsConvert.CHAR_F, 'P', 'G', qb1.LEVEL_W, 'Y', 'B', qb1.LEVEL_V, 'K', 'X', 'J', 'Q', 'Z'};
    private static final char[] LOWER_CASE_ENCRYPT_CHARS = {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l', 'd', 'c', 'u', 'm', 'f', 'p', 'g', 'w', 'y', 'b', 'v', 'k', 'x', 'j', 'q', 'z'};
    private static final char[] NUMBER_ENCRYPT_CHARS = {'8', '6', '1', '5', YKUpsConvert.CHAR_NINE, '2', '3', YKUpsConvert.CHAR_ZERO, '4', '7'};

    public static String caesarEncrypt(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = UPPER_CASE_ENCRYPT_CHARS[charAt - 'A'];
            } else if (charAt >= 'a' && charAt <= 'z') {
                charAt = LOWER_CASE_ENCRYPT_CHARS[charAt - 'a'];
            } else if (charAt >= '0' && charAt <= '9') {
                charAt = NUMBER_ENCRYPT_CHARS[charAt - '0'];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static long convertTimeFormatGMT2Long(String str) {
        if (StringUtils.isBlank(str)) {
            return -1L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception unused) {
            TBSdkLog.e(TAG, "[convertTimeFormatGMT2Long]parse gmt timeformat error");
        }
        if (date != null) {
            return date.getTime() / 1000;
        }
        return -1L;
    }

    public static String convertUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(WVUtils.URL_SEPARATOR)) {
                str = "http:" + str;
            }
            try {
                int indexOf = str.indexOf("?");
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                } else {
                    int indexOf2 = str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                    if (indexOf2 != -1) {
                        str = str.substring(0, indexOf2);
                    }
                }
                return str;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static int createIntSeqNo() {
        return counter.incrementAndGet() & Integer.MAX_VALUE;
    }

    public static Context getContext() {
        if (mContext == null) {
            synchronized (MtopUtils.class) {
                if (mContext == null) {
                    try {
                        Class<?> cls = Class.forName("android.app.ActivityThread");
                        Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                        mContext = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        TBSdkLog.e(TAG, "getContext through reflection error.");
                    }
                }
            }
        }
        return mContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        mtopsdk.common.util.MtopUtils.mProcessName = r2.processName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (mtopsdk.common.util.TBSdkLog.isLogEnable(mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        mtopsdk.common.util.TBSdkLog.i(mtopsdk.common.util.MtopUtils.TAG, "get current processName succeed,processName=" + mtopsdk.common.util.MtopUtils.mProcessName);
     */
    @android.annotation.TargetApi(3)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCurrentProcessName(android.content.Context r4) {
        /*
            if (r4 != 0) goto L5
            java.lang.String r4 = mtopsdk.common.util.MtopUtils.mProcessName
            return r4
        L5:
            java.lang.String r0 = mtopsdk.common.util.MtopUtils.mProcessName
            if (r0 != 0) goto L6e
            java.lang.Class<mtopsdk.common.util.MtopUtils> r0 = mtopsdk.common.util.MtopUtils.class
            monitor-enter(r0)
            java.lang.String r1 = mtopsdk.common.util.MtopUtils.mProcessName     // Catch: java.lang.Throwable -> L6b
            if (r1 != 0) goto L69
            int r1 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            java.lang.String r2 = "activity"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            java.util.List r4 = r4.getRunningAppProcesses()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            if (r4 == 0) goto L69
            int r2 = r4.size()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            if (r2 <= 0) goto L69
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
        L2c:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            if (r2 == 0) goto L69
            java.lang.Object r2 = r4.next()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            int r3 = r2.pid     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            if (r3 != r1) goto L2c
            java.lang.String r4 = r2.processName     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            mtopsdk.common.util.MtopUtils.mProcessName = r4     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            mtopsdk.common.util.TBSdkLog$LogEnable r4 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            boolean r4 = mtopsdk.common.util.TBSdkLog.isLogEnable(r4)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            if (r4 == 0) goto L69
            java.lang.String r4 = "mtopsdk.MtopUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            r1.<init>()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            java.lang.String r2 = "get current processName succeed,processName="
            r1.append(r2)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            java.lang.String r2 = mtopsdk.common.util.MtopUtils.mProcessName     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            r1.append(r2)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            mtopsdk.common.util.TBSdkLog.i(r4, r1)     // Catch: java.lang.Exception -> L61 java.lang.Throwable -> L6b
            goto L69
        L61:
            r4 = move-exception
            java.lang.String r1 = "mtopsdk.MtopUtils"
            java.lang.String r2 = "get current processName failed."
            mtopsdk.common.util.TBSdkLog.e(r1, r2, r4)     // Catch: java.lang.Throwable -> L6b
        L69:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            goto L6e
        L6b:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            throw r4
        L6e:
            java.lang.String r4 = mtopsdk.common.util.MtopUtils.mProcessName
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.getCurrentProcessName(android.content.Context):java.lang.String");
    }

    @TargetApi(4)
    public static boolean isApkDebug(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e(TAG, "[isApkDebug] context is null!");
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isAppOpenMock(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e(TAG, "[isAppOpenMock] context is null!");
            return false;
        }
        try {
            byte[] readFile = readFile(context.getFilesDir().getCanonicalPath() + "/mock/openMock.json");
            if (readFile != null) {
                try {
                    return new JSONObject(new String(readFile)).getBoolean("openMock");
                } catch (Exception e) {
                    TBSdkLog.e(TAG, "[isAppOpenMock]parse openMock flag error in isOpenMock.json .", e);
                }
            }
            return false;
        } catch (IOException e2) {
            TBSdkLog.e(TAG, "[isAppOpenMock] parse ExternalFilesDir/mock/openMock.json filePath error.", e2);
            return false;
        }
    }

    public static final boolean isContainChineseCharacter(String str) {
        char[] charArray;
        Character.UnicodeBlock of;
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            try {
                of = Character.UnicodeBlock.of(c);
            } catch (Throwable unused) {
                if (c < 19968) {
                    continue;
                } else if (c <= 40959) {
                    return true;
                }
            }
            if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCurrentProcessBackground(Context context) {
        if (SwitchConfig.getInstance().getProcessBgMethodNew()) {
            boolean z = false;
            if (context == null) {
                return false;
            }
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                            if (runningAppProcessInfo.importance >= 400) {
                                z = true;
                            }
                            TBSdkLog.e(TAG, "get current process is background succeed, result=" + z);
                        }
                    }
                }
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "get current process whether background exception, " + th.getMessage());
            }
            return z;
        }
        return XState.isAppBackground();
    }

    @TargetApi(3)
    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r5 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        if (r5 == null) goto L21;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x006a: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:42:0x0071, block:B:38:0x006a */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0071: IF  (r5 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:44:0x0076, block:B:42:0x0071 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] readFile(java.lang.String r9) {
        /*
            java.lang.String r0 = "mtopsdk.MtopUtils"
            r1 = 1
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L35 java.io.FileNotFoundException -> L4f
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L35 java.io.FileNotFoundException -> L4f
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L35 java.io.FileNotFoundException -> L4f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.io.FileNotFoundException -> L4f
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L33
            r4.<init>()     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L33
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L51
        L18:
            int r7 = r5.read(r6)     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L51
            r8 = -1
            if (r7 == r8) goto L23
            r4.write(r6, r2, r7)     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L51
            goto L18
        L23:
            byte[] r3 = r4.toByteArray()     // Catch: java.lang.Throwable -> L2e java.io.FileNotFoundException -> L51
            r4.close()     // Catch: java.io.IOException -> L2a
        L2a:
            r5.close()     // Catch: java.io.IOException -> L68
            goto L68
        L2e:
            r6 = move-exception
            goto L38
        L30:
            r6 = move-exception
            r4 = r3
            goto L38
        L33:
            r4 = r3
            goto L51
        L35:
            r6 = move-exception
            r4 = r3
            r5 = r4
        L38:
            java.lang.String r7 = "readFile error.filePath={%s}"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L69
            r1[r2] = r9     // Catch: java.lang.Throwable -> L69
            java.lang.String r9 = java.lang.String.format(r7, r1)     // Catch: java.lang.Throwable -> L69
            mtopsdk.common.util.TBSdkLog.w(r0, r9, r6)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L4c
            r4.close()     // Catch: java.io.IOException -> L4b
            goto L4c
        L4b:
        L4c:
            if (r5 == 0) goto L68
            goto L2a
        L4f:
            r4 = r3
            r5 = r4
        L51:
            java.lang.String r6 = "readFile error.filePath={%s} is not found."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L69
            r1[r2] = r9     // Catch: java.lang.Throwable -> L69
            java.lang.String r9 = java.lang.String.format(r6, r1)     // Catch: java.lang.Throwable -> L69
            mtopsdk.common.util.TBSdkLog.w(r0, r9)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L65
            r4.close()     // Catch: java.io.IOException -> L64
            goto L65
        L64:
        L65:
            if (r5 == 0) goto L68
            goto L2a
        L68:
            return r3
        L69:
            r9 = move-exception
            if (r4 == 0) goto L71
            r4.close()     // Catch: java.io.IOException -> L70
            goto L71
        L70:
        L71:
            if (r5 == 0) goto L76
            r5.close()     // Catch: java.io.IOException -> L76
        L76:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.readFile(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r2 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.Serializable readObject(java.io.File r7, java.lang.String r8) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L2e
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L2e
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L2e
            if (r2 != 0) goto Ld
            return r0
        Ld:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L2e
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L2b
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L2b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2b
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r3 = r1.readObject()     // Catch: java.lang.Throwable -> L2b
            java.io.Serializable r3 = (java.io.Serializable) r3     // Catch: java.lang.Throwable -> L2b
            r1.close()     // Catch: java.lang.Throwable -> L29
        L25:
            r2.close()     // Catch: java.io.IOException -> L49
            goto L49
        L29:
            r0 = move-exception
            goto L32
        L2b:
            r1 = move-exception
            r3 = r0
            goto L31
        L2e:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L31:
            r0 = r1
        L32:
            java.lang.String r1 = "mtopsdk.MtopUtils"
            java.lang.String r4 = "readObject error.fileDir={%s},fileName={%s}"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            r5[r6] = r7     // Catch: java.lang.Throwable -> L4a
            r7 = 1
            r5[r7] = r8     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L4a
            mtopsdk.common.util.TBSdkLog.w(r1, r7, r0)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L49
            goto L25
        L49:
            return r3
        L4a:
            r7 = move-exception
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L50
        L50:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.readObject(java.io.File, java.lang.String):java.io.Serializable");
    }

    public static String urlDecode(String str, String str2) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (Exception e) {
            TBSdkLog.e(TAG, "[urlDecode] URLDecoder decode error. input=" + str + ", charset= " + str2, e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean writeObject(java.io.Serializable r9, java.io.File r10, java.lang.String r11) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            boolean r3 = r10.exists()     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto Lc
            r10.mkdirs()     // Catch: java.lang.Throwable -> L50
        Lc:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r4.<init>()     // Catch: java.lang.Throwable -> L50
            r4.append(r11)     // Catch: java.lang.Throwable -> L50
            java.util.Random r5 = new java.util.Random     // Catch: java.lang.Throwable -> L50
            r5.<init>()     // Catch: java.lang.Throwable -> L50
            r6 = 10
            int r5 = r5.nextInt(r6)     // Catch: java.lang.Throwable -> L50
            r4.append(r5)     // Catch: java.lang.Throwable -> L50
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L50
            r3.<init>(r10, r4)     // Catch: java.lang.Throwable -> L50
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L4e
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4e
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L49
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L49
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L49
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L49
            r2.writeObject(r9)     // Catch: java.lang.Throwable -> L49
            r2.flush()     // Catch: java.lang.Throwable -> L49
            r2.close()     // Catch: java.lang.Throwable -> L49
            r4.close()     // Catch: java.io.IOException -> L47
            goto L6e
        L47:
            goto L6e
        L49:
            r2 = move-exception
            r8 = r4
            r4 = r2
            r2 = r8
            goto L53
        L4e:
            r4 = move-exception
            goto L53
        L50:
            r3 = move-exception
            r4 = r3
            r3 = r2
        L53:
            java.lang.String r5 = "mtopsdk.MtopUtils"
            java.lang.String r6 = "writeObject error.fileDir={%s},fileName={%s},object={%s}"
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L7a
            r7[r1] = r10     // Catch: java.lang.Throwable -> L7a
            r7[r0] = r11     // Catch: java.lang.Throwable -> L7a
            r0 = 2
            r7[r0] = r9     // Catch: java.lang.Throwable -> L7a
            java.lang.String r9 = java.lang.String.format(r6, r7)     // Catch: java.lang.Throwable -> L7a
            mtopsdk.common.util.TBSdkLog.w(r5, r9, r4)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6d
        L6d:
            r0 = 0
        L6e:
            if (r0 == 0) goto L79
            java.io.File r9 = new java.io.File
            r9.<init>(r10, r11)
            boolean r0 = r3.renameTo(r9)
        L79:
            return r0
        L7a:
            r9 = move-exception
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L80
        L80:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.MtopUtils.writeObject(java.io.Serializable, java.io.File, java.lang.String):boolean");
    }
}
