package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FileUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void closeQuietly(Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289699557")) {
            ipChange.ipc$dispatch("289699557", new Object[]{closeable});
        } else if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int copyFile(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1731755137")) {
            return ((Integer) ipChange.ipc$dispatch("-1731755137", new Object[]{file, file2})).intValue();
        }
        if (!file.isFile() || !file2.exists()) {
            return -1;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedOutputStream = null;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = null;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedOutputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    if (file.length() != file2.length()) {
                        deleteFile(file2);
                        i = -1;
                    }
                    try {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return i;
                } catch (FileNotFoundException e6) {
                    e = e6;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return -1;
                } catch (IOException e7) {
                    e = e7;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return -1;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static File creatDir(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-995913256")) {
            return (File) ipChange.ipc$dispatch("-995913256", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static File creatFile(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930566765")) {
            return (File) ipChange.ipc$dispatch("1930566765", new Object[]{str});
        }
        if (str == null) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        return null;
    }

    public static void delete(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105662085")) {
            ipChange.ipc$dispatch("-105662085", new Object[]{file});
        } else if (file != null) {
            if (file.isFile()) {
                if (file.delete()) {
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i(FileUtils.class.getSimpleName(), "文件删除失败");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    delete(file2);
                } else {
                    file2.delete();
                }
            }
            if (file.delete()) {
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).i(FileUtils.class.getSimpleName(), "文件删除失败");
        }
    }

    public static boolean deleteDirectory(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-876287769")) {
            return ((Boolean) ipChange.ipc$dispatch("-876287769", new Object[]{str})).booleanValue();
        }
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            Boolean bool = Boolean.TRUE;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        bool = Boolean.valueOf(deleteFile(listFiles[i].getAbsolutePath()));
                        if (!bool.booleanValue()) {
                            break;
                        }
                    } else {
                        bool = Boolean.valueOf(deleteDirectory(listFiles[i].getAbsolutePath()));
                        if (!bool.booleanValue()) {
                            break;
                        }
                    }
                }
            }
            if (bool.booleanValue() && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885434422")) {
            return ((Boolean) ipChange.ipc$dispatch("885434422", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean isFileExist(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-28899464") ? ((Boolean) ipChange.ipc$dispatch("-28899464", new Object[]{str})).booleanValue() : new File(str).exists();
    }

    public static boolean isFileExists(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870178971")) {
            return ((Boolean) ipChange.ipc$dispatch("870178971", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        return file.exists() && file.isFile() && file.length() != 0;
    }

    public static boolean isFolderExist(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866654230")) {
            return ((Boolean) ipChange.ipc$dispatch("-866654230", new Object[]{str})).booleanValue();
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFile(android.content.Context r4, java.lang.String r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.FileUtils.$ipChange
            java.lang.String r1 = "-1287624085"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r4 = 1
            r2[r4] = r5
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L1a:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            java.lang.String r0 = ""
            r4.<init>(r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            if (r5 == 0) goto L6c
            r5 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
        L3c:
            java.lang.String r5 = r1.readLine()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L5f
            if (r5 == 0) goto L46
            r4.append(r5)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L5f
            goto L3c
        L46:
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L6c
        L4a:
            r5 = move-exception
            goto L51
        L4c:
            r4 = move-exception
            goto L61
        L4e:
            r0 = move-exception
            r1 = r5
            r5 = r0
        L51:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L6c
        L5a:
            r5 = move-exception
            r5.printStackTrace()
            goto L6c
        L5f:
            r4 = move-exception
            r5 = r1
        L61:
            if (r5 == 0) goto L6b
            r5.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r5 = move-exception
            r5.printStackTrace()
        L6b:
            throw r4
        L6c:
            java.lang.String r4 = r4.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.FileUtils.readFile(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String readFromFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530593302")) {
            return (String) ipChange.ipc$dispatch("530593302", new Object[]{file});
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return stringBuffer.toString();
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    public static boolean renameFile(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296753677")) {
            return ((Boolean) ipChange.ipc$dispatch("296753677", new Object[]{str, str2})).booleanValue();
        }
        if (str == null || str2 == null) {
            return false;
        }
        return new File(str).renameTo(new File(str2));
    }

    public static boolean write2File(File file, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506649189")) {
            return ((Boolean) ipChange.ipc$dispatch("1506649189", new Object[]{file, str})).booleanValue();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0097 A[Catch: Exception -> 0x0093, TRY_LEAVE, TryCatch #5 {Exception -> 0x0093, blocks: (B:42:0x008f, B:46:0x0097), top: B:55:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File writeFromInput(java.lang.String r5, java.lang.String r6, java.io.InputStream r7, int r8) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.FileUtils.$ipChange
            java.lang.String r1 = "-150486757"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L24
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            r5 = 1
            r2[r5] = r6
            r5 = 2
            r2[r5] = r7
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r2[r5] = r6
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.io.File r5 = (java.io.File) r5
            return r5
        L24:
            r0 = 0
            creatDir(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.append(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1.append(r6)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.io.File r5 = creatFile(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
        L44:
            int r2 = r7.read(r1)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            if (r2 <= 0) goto L4e
            r6.write(r1, r3, r2)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            goto L44
        L4e:
            r6.flush()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            long r1 = r5.length()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            long r3 = (long) r8
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 != 0) goto L67
            r7.close()     // Catch: java.lang.Exception -> L61
            r6.close()     // Catch: java.lang.Exception -> L61
            goto L65
        L61:
            r6 = move-exception
            r6.printStackTrace()
        L65:
            r0 = r5
            goto L8a
        L67:
            deleteFile(r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            java.lang.Exception r5 = new java.lang.Exception     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            r5.<init>()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
            throw r5     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L8b
        L70:
            r5 = move-exception
            goto L76
        L72:
            r5 = move-exception
            goto L8d
        L74:
            r5 = move-exception
            r6 = r0
        L76:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L81
            r7.close()     // Catch: java.lang.Exception -> L7f
            goto L81
        L7f:
            r5 = move-exception
            goto L87
        L81:
            if (r6 == 0) goto L8a
            r6.close()     // Catch: java.lang.Exception -> L7f
            goto L8a
        L87:
            r5.printStackTrace()
        L8a:
            return r0
        L8b:
            r5 = move-exception
            r0 = r6
        L8d:
            if (r7 == 0) goto L95
            r7.close()     // Catch: java.lang.Exception -> L93
            goto L95
        L93:
            r6 = move-exception
            goto L9b
        L95:
            if (r0 == 0) goto L9e
            r0.close()     // Catch: java.lang.Exception -> L93
            goto L9e
        L9b:
            r6.printStackTrace()
        L9e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals.FileUtils.writeFromInput(java.lang.String, java.lang.String, java.io.InputStream, int):java.io.File");
    }

    public static boolean deleteFile(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111882723")) {
            return ((Boolean) ipChange.ipc$dispatch("1111882723", new Object[]{file})).booleanValue();
        }
        Boolean bool = Boolean.FALSE;
        if (file.isFile() && file.exists()) {
            bool = Boolean.valueOf(file.delete());
        }
        return bool.booleanValue();
    }
}
