package com.taobao.orange.util;

import com.taobao.orange.GlobalOrange;
import com.taobao.orange.OConstant;
import com.taobao.orange.model.CheckDO;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FileUtil {
    public static final String ORANGE_DIR = "orange_config";
    private static final String TAG = "FileUtil";
    private static File targetDir = getTargetDir();
    public static AtomicInteger persistCount = new AtomicInteger(0);
    public static AtomicInteger restoreCount = new AtomicInteger(0);
    public static AtomicLong persistTime = new AtomicLong(0);
    public static AtomicLong restoreTime = new AtomicLong(0);
    public static AtomicLong ioTime = new AtomicLong(0);

    private static void cleanDir(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    cleanDir(file2);
                }
            }
        }
    }

    public static void clearCacheFile() {
        OLog.i(TAG, "clearCacheFile", new Object[0]);
        cleanDir(targetDir);
    }

    public static void deleteConfigFile(String str) {
        File file = new File(targetDir, str);
        if (file.exists()) {
            boolean delete = file.delete();
            if (OLog.isPrintLog(1)) {
                OLog.d(TAG, "deleteConfigFile", "filename", str, "result", Boolean.valueOf(delete));
            }
        }
    }

    public static File getOrangeConfigDir() {
        return targetDir;
    }

    private static File getTargetDir() {
        File file;
        File file2 = null;
        try {
            file = new File(new File(GlobalOrange.context.getFilesDir(), ORANGE_DIR), GlobalOrange.env.getDes());
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (file.exists() && file.isFile() && !file.delete()) {
                OLog.w(TAG, "getTargetDir target dir delete fail", new Object[0]);
            }
            if (!file.exists() && !file.mkdirs()) {
                OLog.w(TAG, "getTargetDir mkdirs fail", new Object[0]);
                OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "getTargetDir", OConstant.CODE_POINT_EXP_GET_TARGET_DIR, "getTargetDir mkdirs fail");
            }
            OLog.d(TAG, "getTargetDir", file.getAbsolutePath());
            return file;
        } catch (Throwable th2) {
            th = th2;
            file2 = file;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            OrangeMonitor.commitFail(OConstant.MONITOR_MODULE, OConstant.POINT_EXCEPTION, "0", OConstant.CODE_POINT_EXP_GET_TARGET_DIR, byteArrayOutputStream.toString());
            return file2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void persistObject(java.lang.Object r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.util.FileUtil.persistObject(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void persistObjectLocked(java.lang.Object r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.util.FileUtil.persistObjectLocked(java.lang.Object, java.lang.String):void");
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x00e3: MOVE  (r13 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]), block:B:42:0x00e3 */
    public static <T extends CheckDO> T restoreObject(String str) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Closeable closeable;
        if (GlobalOrange.processIsolated) {
            return (T) restoreObjectLocked(str);
        }
        if (OLog.isPrintLog(1)) {
            OLog.d(TAG, "restoreObject", "filename", str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Closeable closeable2 = null;
        try {
            try {
                File file = new File(targetDir, str);
                if (!file.exists()) {
                    if (OLog.isPrintLog(3)) {
                        OLog.w(TAG, "restoreObject not exists", "filename", str);
                    }
                    OrangeUtils.close(null);
                    OrangeUtils.close(null);
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                } catch (Exception e) {
                    e = e;
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    OrangeUtils.close(closeable2);
                    OrangeUtils.close(fileInputStream);
                    throw th;
                }
                try {
                    T t = (T) objectInputStream.readObject();
                    if (t.checkValid()) {
                        if (!OrangeMonitor.mPerformanceInfoRecordDone) {
                            restoreCount.incrementAndGet();
                            restoreTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            ioTime.addAndGet(System.currentTimeMillis() - currentTimeMillis);
                            OrangeMonitor.commitFileStatMonitor(str, true, false, 0, System.currentTimeMillis() - currentTimeMillis);
                        }
                        OrangeUtils.close(objectInputStream);
                        OrangeUtils.close(fileInputStream);
                        return t;
                    }
                    throw new RuntimeException("check not vaild:" + str);
                } catch (Exception e2) {
                    e = e2;
                    OLog.e(TAG, "restoreObject", e, new Object[0]);
                    OrangeUtils.close(objectInputStream);
                    OrangeUtils.close(fileInputStream);
                    OrangeMonitor.commitCount(OConstant.MONITOR_PRIVATE_MODULE, OConstant.POINT_RESTORE_FAIL_COUNTS, str, 1.0d);
                    OrangeMonitor.commitFileStatMonitor(str, false, false, 0, System.currentTimeMillis() - currentTimeMillis);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x00e6: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY]), block:B:40:0x00e6 */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.ObjectInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends com.taobao.orange.model.CheckDO> T restoreObjectLocked(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.orange.util.FileUtil.restoreObjectLocked(java.lang.String):com.taobao.orange.model.CheckDO");
    }
}
