package com.alibaba.motu.tbrest.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class AppUtils {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface ReaderListener {
        boolean onReadLine(String str);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                LogUtil.e("close.", e);
            }
        }
    }

    public static String dumpMeminfo(Context context) {
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Integer num = null;
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                num = Integer.valueOf((int) (memoryInfo.threshold >> 10));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JavaTotal:");
            sb.append(Runtime.getRuntime().totalMemory());
            sb.append(" JavaFree:");
            sb.append(Runtime.getRuntime().freeMemory());
            sb.append(" NativeHeap:");
            sb.append(Debug.getNativeHeapSize());
            sb.append(" NativeAllocated:");
            sb.append(Debug.getNativeHeapAllocatedSize());
            sb.append(" NativeFree:");
            sb.append(Debug.getNativeHeapFreeSize());
            sb.append(" threshold:");
            if (num != null) {
                str = num + " KB";
            } else {
                str = "not valid";
            }
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            LogUtil.e("dumpMeminfo", e);
            return "";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:1|2|3|4|5|6|7|(14:9|10|11|12|13|(1:15)|16|(1:18)|19|(1:21)|22|(1:24)|26|27)|31|10|11|12|13|(0)|16|(0)|19|(0)|22|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x018c, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x018d, code lost:
        com.alibaba.motu.tbrest.utils.LogUtil.e("getSizes", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[Catch: Exception -> 0x018c, TRY_ENTER, TryCatch #0 {Exception -> 0x018c, blocks: (B:16:0x005d, B:19:0x0069, B:20:0x00ad, B:22:0x00b3, B:23:0x00f7, B:25:0x00fd, B:26:0x0141, B:28:0x0147), top: B:34:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3 A[Catch: Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:16:0x005d, B:19:0x0069, B:20:0x00ad, B:22:0x00b3, B:23:0x00f7, B:25:0x00fd, B:26:0x0141, B:28:0x0147), top: B:34:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd A[Catch: Exception -> 0x018c, TryCatch #0 {Exception -> 0x018c, blocks: (B:16:0x005d, B:19:0x0069, B:20:0x00ad, B:22:0x00b3, B:23:0x00f7, B:25:0x00fd, B:26:0x0141, B:28:0x0147), top: B:34:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0147 A[Catch: Exception -> 0x018c, TRY_LEAVE, TryCatch #0 {Exception -> 0x018c, blocks: (B:16:0x005d, B:19:0x0069, B:20:0x00ad, B:22:0x00b3, B:23:0x00f7, B:25:0x00fd, B:26:0x0141, B:28:0x0147), top: B:34:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String dumpStorage(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.tbrest.utils.AppUtils.dumpStorage(android.content.Context):java.lang.String");
    }

    public static String dumpThread(Thread thread) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
            sb.append(String.format("\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
            StackTraceElement[] stackTrace = thread.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
            }
        } catch (Exception e) {
            LogUtil.e("dumpThread", e);
        }
        return sb.toString();
    }

    public static String getGMT8Time(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            LogUtil.e("getGMT8Time", e);
            return "";
        }
    }

    public static String getMeminfo() {
        return readFully(new File("/proc/meminfo")).trim();
    }

    public static String getMyProcessNameByAppProcessInfo(Context context) {
        if (context != null) {
            int myPid = Process.myPid();
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String getMyProcessNameByCmdline() {
        try {
            return readLine("/proc/self/cmdline").trim();
        } catch (Exception e) {
            LogUtil.e("get my process name by cmd line failure .", e);
            return null;
        }
    }

    public static String getMyStatus() {
        return readFully(new File("/proc/self/status")).trim();
    }

    private static long[] getSizes(String str) {
        long blockSizeLong;
        long blockCountLong;
        long freeBlocksLong;
        long availableBlocksLong;
        long[] jArr = {-1, -1, -1};
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                blockCountLong = statFs.getBlockCount();
                freeBlocksLong = statFs.getFreeBlocks();
                availableBlocksLong = statFs.getAvailableBlocks();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
                freeBlocksLong = statFs.getFreeBlocksLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
            }
            jArr[0] = blockCountLong * blockSizeLong;
            jArr[1] = freeBlocksLong * blockSizeLong;
            jArr[2] = blockSizeLong * availableBlocksLong;
        } catch (Exception e) {
            LogUtil.e("getSizes", e);
        }
        return jArr;
    }

    public static Boolean isBackgroundRunning(Context context) {
        try {
            if (Integer.parseInt(readLine("/proc/self/oom_adj").trim()) == 0) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String readFully(File file) {
        FileInputStream fileInputStream;
        Exception e;
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
                inputStreamReader = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(r1);
                closeQuietly(fileInputStream);
                throw th;
            }
            try {
                char[] cArr = new char[4096];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e4) {
                e = e4;
                LogUtil.e("readFully.", e);
                closeQuietly(inputStreamReader);
                closeQuietly(fileInputStream);
                return sb.toString();
            }
            closeQuietly(inputStreamReader);
            closeQuietly(fileInputStream);
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            r1 = file;
        }
    }

    public static String readLine(String str) {
        return readLine(new File(str));
    }

    public static String readLineAndDel(File file) {
        try {
            String readLine = readLine(file);
            file.delete();
            return readLine;
        } catch (Exception e) {
            LogUtil.e("readLineAndDel", e);
            return null;
        }
    }

    public static List<String> readLines(File file, int i) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i2++;
                        arrayList.add(readLine);
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        LogUtil.e("readLine", e);
                        closeQuietly(bufferedReader);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                closeQuietly(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
        return arrayList;
    }

    public static boolean writeFile(File file, String str) {
        return writeFile(file, str, false);
    }

    public static String readLine(File file) {
        List<String> readLines = readLines(file, 1);
        return !readLines.isEmpty() ? readLines.get(0) : "";
    }

    public static boolean writeFile(File file, String str, boolean z) {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file, z);
                try {
                    fileWriter2.write(str);
                    fileWriter2.flush();
                    closeQuietly(fileWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileWriter = fileWriter2;
                    LogUtil.e("writeFile", e);
                    closeQuietly(fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    closeQuietly(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static void readLine(File file, ReaderListener readerListener) {
        String readLine;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                do {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            closeQuietly(bufferedReader2);
                            return;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        LogUtil.e("readLine", e);
                        closeQuietly(bufferedReader);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (!readerListener.onReadLine(readLine));
                closeQuietly(bufferedReader2);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
