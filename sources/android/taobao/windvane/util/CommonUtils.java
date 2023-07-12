package android.taobao.windvane.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileFilter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CommonUtils {
    private static final String TAG = "CommonUtils";
    private static String currentProcessName = "";
    private static Boolean isMainProcess;

    public static Bitmap base64ToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.replace(' ', '+'), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean canWriteFile(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.createNewFile();
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(str.getBytes());
            randomAccessFile.close();
            if (file.exists()) {
                file.delete();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            File file2 = new File(str2);
            if (file2.exists()) {
                file2.delete();
            }
            return false;
        }
    }

    public static int compareVer(String str, String str2) {
        if (str == null) {
            str = "0";
        }
        if (str2 == null) {
            str2 = "0";
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int i = length > length2 ? length : length2;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length && i2 < length2) {
                int i3 = toInt(split[i2]);
                int i4 = toInt(split2[i2]);
                if (i3 != i4) {
                    return i3 - i4;
                }
            } else {
                int i5 = length > length2 ? toInt(split[i2]) : toInt(split2[i2]) * (-1);
                if (i5 != 0) {
                    return i5;
                }
            }
        }
        return 0;
    }

    public static String formatDate(long j) {
        return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH).format(new Date(j));
    }

    public static File getExternalCacheDir(Context context) {
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    if (!externalCacheDir.exists()) {
                        externalCacheDir.mkdirs();
                    }
                    return externalCacheDir;
                }
            } catch (Exception unused) {
            }
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: android.taobao.windvane.util.CommonUtils.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            TaoLog.d("HomePageNetwork", "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            TaoLog.d("HomePageNetwork", "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static String getProcessName(Context context) {
        String str;
        try {
            str = currentProcessName;
        } catch (Exception e) {
            TaoLog.e("getProcessName error", e.toString());
        }
        if (str == null || str.length() <= 0) {
            if (context == null) {
                return null;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    currentProcessName = runningAppProcessInfo.processName;
                }
            }
            return currentProcessName;
        }
        return currentProcessName;
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        try {
            th.printStackTrace(new PrintWriter(stringWriter));
        } catch (Throwable unused) {
        }
        return stringWriter.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getTotalRAM() {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1f
            java.lang.String r2 = "/proc/meminfo"
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1f
            java.lang.String r0 = r1.readLine()     // Catch: java.io.IOException -> L18 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L13
            goto L29
        L13:
            r1 = move-exception
            r1.printStackTrace()
            goto L29
        L18:
            r2 = move-exception
            goto L21
        L1a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L4c
        L1f:
            r2 = move-exception
            r1 = r0
        L21:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L29
            r1.close()     // Catch: java.io.IOException -> L13
        L29:
            if (r0 == 0) goto L48
            java.lang.String r1 = "kB"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r1 = "MemTotal:"
            java.lang.String r0 = r0.replace(r1, r2)
            java.lang.String r0 = r0.trim()     // Catch: java.lang.NumberFormatException -> L44
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L44
            int r0 = r0 / 1000
            return r0
        L44:
            r0 = move-exception
            r0.printStackTrace()
        L48:
            r0 = 1024(0x400, float:1.435E-42)
            return r0
        L4b:
            r0 = move-exception
        L4c:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r1 = move-exception
            r1.printStackTrace()
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.util.CommonUtils.getTotalRAM():int");
    }

    public static boolean hasSDCardMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.equals("mounted");
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 0) != null;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isHtml(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("text/html");
    }

    public static boolean isImage(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("image");
    }

    public static boolean isLowendPhone() {
        int numCores = getNumCores();
        int totalRAM = getTotalRAM();
        TaoLog.d("HomePageNetwork", "processorCore = " + numCores + " ram = " + totalRAM + " MB");
        return numCores == 1 && totalRAM < 800;
    }

    public static boolean isMainProcess(Context context) {
        if (isMainProcess == null) {
            isMainProcess = Boolean.valueOf(context != null && TextUtils.equals(getProcessName(context), context.getPackageName()));
        }
        return isMainProcess.booleanValue();
    }

    public static boolean isPicture(String str) {
        if (str != null && -1 != str.lastIndexOf(".")) {
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            String[] strArr = {"png", "jpeg", "jpg", "webp"};
            for (int i = 0; i < 4; i++) {
                if (strArr[i].equals(substring)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String parseCharset(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("charset")) == -1 || str.indexOf("=", indexOf) == -1) {
            return "";
        }
        String substring = str.substring(str.indexOf("=", indexOf) + 1);
        int indexOf2 = substring.indexOf(";");
        if (indexOf2 != -1) {
            substring = substring.substring(0, indexOf2).trim();
        }
        return substring.trim();
    }

    public static long parseDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
            return simpleDateFormat.parse(str.trim()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long parseMaxAge(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("max-age=") == -1) {
            return 0L;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(8);
        for (int i = 0; i < substring.length() && Character.isDigit(substring.charAt(i)); i++) {
            sb.append(substring.charAt(i));
        }
        try {
            return Long.parseLong(sb.toString()) * 1000;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String parseMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(";");
        if (indexOf == -1) {
            return str.trim();
        }
        return str.substring(0, indexOf).trim();
    }

    public static int toInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
