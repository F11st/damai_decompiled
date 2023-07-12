package android.taobao.windvane.file;

import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FileAccesser {
    public static boolean deleteFile(String str) {
        if (str == null) {
            return false;
        }
        return deleteFile(new File(str), true);
    }

    public static boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] read(java.io.File r5) {
        /*
            r0 = 0
            boolean r1 = r5.exists()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            if (r1 != 0) goto L8
            return r0
        L8:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            java.nio.channels.FileChannel r5 = r1.getChannel()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2d
            long r2 = r5.size()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L4b
            int r3 = (int) r2     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L4b
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r3)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L4b
            r5.read(r2)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L4b
            byte[] r0 = r2.array()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L24
        L24:
            r5.close()     // Catch: java.io.IOException -> L27
        L27:
            return r0
        L28:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L4c
        L2d:
            r5 = r0
            goto L36
        L2f:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L4c
        L34:
            r5 = r0
            r1 = r5
        L36:
            java.lang.String r2 = "FileAccesser"
            java.lang.String r3 = "read loacl file failed"
            android.taobao.windvane.util.TaoLog.w(r2, r3)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.io.IOException -> L44
            goto L45
        L44:
        L45:
            if (r5 == 0) goto L4a
            r5.close()     // Catch: java.io.IOException -> L4a
        L4a:
            return r0
        L4b:
            r0 = move-exception
        L4c:
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L52
            goto L53
        L52:
        L53:
            if (r5 == 0) goto L58
            r5.close()     // Catch: java.io.IOException -> L58
        L58:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.file.FileAccesser.read(java.io.File):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
        r6.delete();
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean write(java.io.File r6, java.nio.ByteBuffer r7) throws android.taobao.windvane.file.NotEnoughSpace {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r6.exists()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 != 0) goto L15
            java.io.File r2 = r6.getParentFile()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            if (r2 != 0) goto Lf
            return r1
        Lf:
            r2.mkdirs()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r6.createNewFile()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
        L15:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L46
            java.nio.channels.FileChannel r0 = r2.getChannel()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            r7.position(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            r0.write(r7)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            r7 = 1
            r0.force(r7)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            r2.close()     // Catch: java.io.IOException -> L2c
            goto L30
        L2c:
            r6 = move-exception
            r6.printStackTrace()
        L30:
            r0.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r6 = move-exception
            r6.printStackTrace()
        L38:
            return r7
        L39:
            r6 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L7d
        L3e:
            r7 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L48
        L43:
            r6 = move-exception
            r2 = r0
            goto L7d
        L46:
            r7 = move-exception
            r2 = r0
        L48:
            java.lang.String r3 = r7.getMessage()     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto L5f
            java.lang.String r4 = "ENOSPC"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> L7c
            if (r3 != 0) goto L57
            goto L5f
        L57:
            android.taobao.windvane.file.NotEnoughSpace r6 = new android.taobao.windvane.file.NotEnoughSpace     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = "not enouth space in flash"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L7c
            throw r6     // Catch: java.lang.Throwable -> L7c
        L5f:
            if (r6 == 0) goto L64
            r6.delete()     // Catch: java.lang.Throwable -> L7c
        L64:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L71
            r0.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r6 = move-exception
            r6.printStackTrace()
        L71:
            if (r2 == 0) goto L7b
            r2.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r6 = move-exception
            r6.printStackTrace()
        L7b:
            return r1
        L7c:
            r6 = move-exception
        L7d:
            if (r0 == 0) goto L87
            r0.close()     // Catch: java.io.IOException -> L83
            goto L87
        L83:
            r7 = move-exception
            r7.printStackTrace()
        L87:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L8d
            goto L91
        L8d:
            r7 = move-exception
            r7.printStackTrace()
        L91:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.file.FileAccesser.write(java.io.File, java.nio.ByteBuffer):boolean");
    }

    public static boolean deleteFile(File file) {
        return deleteFile(file, true);
    }

    public static boolean deleteFile(File file, boolean z) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                try {
                    for (File file2 : file.listFiles()) {
                        if (file2.isDirectory()) {
                            deleteFile(file2, true);
                        } else {
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                try {
                    return file.delete();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return false;
    }

    public static byte[] read(String str) {
        if (str == null) {
            return null;
        }
        return read(new File(str));
    }

    public static boolean write(String str, ByteBuffer byteBuffer) throws NotEnoughSpace {
        if (str == null) {
            return false;
        }
        return write(new File(str), byteBuffer);
    }
}
