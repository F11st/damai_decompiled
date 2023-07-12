package com.taobao.accs.utl.syncps;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import com.taobao.aranger.ARanger;
import java.io.RandomAccessFile;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SyncChannelSwitch {
    public static final String FILE_CONN_SERVICES = "conn_services.lock";
    public static final String FILE_SCS = "scs.lock";
    private static final String TAG = "SyncChannelSwitch";
    private static Context mContext;

    private static void checkContext(Context context) {
        if (mContext != null) {
            return;
        }
        if (context == null) {
            context = ARanger.getContext();
            Objects.requireNonNull(context, "context is NULL");
        }
        mContext = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #4 {all -> 0x0094, blocks: (B:7:0x001d, B:9:0x002c, B:15:0x003e, B:20:0x005a, B:22:0x0060, B:28:0x006c, B:33:0x0087), top: B:73:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087 A[Catch: all -> 0x0094, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0094, blocks: (B:7:0x001d, B:9:0x002c, B:15:0x003e, B:20:0x005a, B:22:0x0060, B:28:0x006c, B:33:0x0087), top: B:73:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getOrSetValueInProcessLock(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "SyncChannelSwitch"
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            r1 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = "accs"
            java.io.File r4 = r11.getDir(r4, r1)     // Catch: java.lang.Throwable -> L96
            r3.<init>(r4, r12)     // Catch: java.lang.Throwable -> L96
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L96
            java.lang.String r5 = "rw"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L96
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch: java.lang.Throwable -> L94
            java.nio.channels.FileLock r2 = r3.lock()     // Catch: java.lang.Throwable -> L94
            boolean r3 = com.taobao.accs.utl.UtilityImpl.isMainProcessAlive(r11)     // Catch: java.lang.Throwable -> L94
            r5 = 1
            if (r3 == 0) goto L34
            boolean r3 = com.taobao.accs.utl.UtilityImpl.isChannelProcessAlive(r11)     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L34
            r3 = 1
            goto L35
        L34:
            r3 = 0
        L35:
            r6 = 3
            java.lang.String r7 = "val"
            r8 = 2
            java.lang.String r9 = "file"
            r10 = 4
            if (r3 == 0) goto L5a
            java.lang.String r11 = read(r11, r4)     // Catch: java.lang.Throwable -> L94
            java.lang.String r3 = "read from"
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L94
            r10[r1] = r9     // Catch: java.lang.Throwable -> L94
            r10[r5] = r12     // Catch: java.lang.Throwable -> L94
            r10[r8] = r7     // Catch: java.lang.Throwable -> L94
            r10[r6] = r11     // Catch: java.lang.Throwable -> L94
            com.taobao.accs.utl.ALog.e(r0, r3, r10)     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L56
            r2.release()     // Catch: java.io.IOException -> L56
        L56:
            r4.close()     // Catch: java.io.IOException -> L59
        L59:
            return r11
        L5a:
            boolean r3 = com.taobao.accs.utl.UtilityImpl.isMainProcess(r11)     // Catch: java.lang.Throwable -> L94
            if (r3 != 0) goto L69
            boolean r3 = com.taobao.accs.utl.UtilityImpl.isChannelProcess(r11)     // Catch: java.lang.Throwable -> L94
            if (r3 == 0) goto L67
            goto L69
        L67:
            r3 = 0
            goto L6a
        L69:
            r3 = 1
        L6a:
            if (r3 == 0) goto L87
            java.lang.String r3 = "write to"
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L94
            r10[r1] = r9     // Catch: java.lang.Throwable -> L94
            r10[r5] = r12     // Catch: java.lang.Throwable -> L94
            r10[r8] = r7     // Catch: java.lang.Throwable -> L94
            r10[r6] = r13     // Catch: java.lang.Throwable -> L94
            com.taobao.accs.utl.ALog.e(r0, r3, r10)     // Catch: java.lang.Throwable -> L94
            write(r11, r4, r13)     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L83
            r2.release()     // Catch: java.io.IOException -> L83
        L83:
            r4.close()     // Catch: java.io.IOException -> La9
            goto La9
        L87:
            java.lang.String r11 = read(r11, r4)     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L90
            r2.release()     // Catch: java.io.IOException -> L90
        L90:
            r4.close()     // Catch: java.io.IOException -> L93
        L93:
            return r11
        L94:
            r11 = move-exception
            goto L98
        L96:
            r11 = move-exception
            r4 = r2
        L98:
            java.lang.String r12 = "getChannelEnabledImpl"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Laa
            com.taobao.accs.utl.ALog.e(r0, r12, r11, r1)     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto La6
            r2.release()     // Catch: java.io.IOException -> La5
            goto La6
        La5:
        La6:
            if (r4 == 0) goto La9
            goto L83
        La9:
            return r13
        Laa:
            r11 = move-exception
            if (r2 == 0) goto Lb2
            r2.release()     // Catch: java.io.IOException -> Lb1
            goto Lb2
        Lb1:
        Lb2:
            if (r4 == 0) goto Lb7
            r4.close()     // Catch: java.io.IOException -> Lb7
        Lb7:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.syncps.SyncChannelSwitch.getOrSetValueInProcessLock(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String read(Context context, RandomAccessFile randomAccessFile) {
        checkContext(context);
        return readFromFile(randomAccessFile);
    }

    private static String readFromFile(RandomAccessFile randomAccessFile) {
        try {
            String readLine = randomAccessFile.readLine();
            ALog.i(TAG, "readFromFile", "line", readLine);
            return readLine;
        } catch (Throwable th) {
            ALog.e(TAG, "readFromFile", th, new Object[0]);
            return null;
        }
    }

    private static void saveToFile(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.seek(0L);
            randomAccessFile.write(str.getBytes());
            ALog.i(TAG, "saveToFile success", new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "saveToFile", th, new Object[0]);
        }
    }

    private static void write(Context context, RandomAccessFile randomAccessFile, String str) {
        checkContext(context);
        saveToFile(randomAccessFile, str);
    }
}
