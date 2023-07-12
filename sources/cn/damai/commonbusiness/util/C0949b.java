package cn.damai.commonbusiness.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.util.b */
/* loaded from: classes.dex */
public class C0949b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CALENDAR_CACHE_FILE_NAME = "dm_calender_cache";
    private static C0949b a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.InputStream r5, java.io.File r6) throws java.io.IOException {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.util.C0949b.$ipChange
            java.lang.String r1 = "1009658130"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            r5 = 1
            r2[r5] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.nio.channels.FileChannel r0 = r1.getChannel()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
        L25:
            int r2 = r5.read(r6)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            if (r2 <= 0) goto L33
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r6, r3, r2)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            r0.write(r2)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L50
            goto L25
        L33:
            r5.close()     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r5 = move-exception
            r5.printStackTrace()
        L3b:
            if (r0 == 0) goto L45
            r0.close()     // Catch: java.lang.Exception -> L41
            goto L45
        L41:
            r5 = move-exception
            r5.printStackTrace()
        L45:
            r1.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r5 = move-exception
            r5.printStackTrace()
        L4d:
            return
        L4e:
            r6 = move-exception
            goto L64
        L50:
            r6 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L5a
        L55:
            r6 = move-exception
            r1 = r0
            goto L64
        L58:
            r6 = move-exception
            r1 = r0
        L5a:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L60
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L60
            throw r2     // Catch: java.lang.Throwable -> L60
        L60:
            r6 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L64:
            if (r5 == 0) goto L6e
            r5.close()     // Catch: java.lang.Exception -> L6a
            goto L6e
        L6a:
            r5 = move-exception
            r5.printStackTrace()
        L6e:
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.lang.Exception -> L74
            goto L78
        L74:
            r5 = move-exception
            r5.printStackTrace()
        L78:
            if (r1 == 0) goto L82
            r1.close()     // Catch: java.lang.Exception -> L7e
            goto L82
        L7e:
            r5 = move-exception
            r5.printStackTrace()
        L82:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.util.C0949b.a(java.io.InputStream, java.io.File):void");
    }

    public static C0949b b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794002299")) {
            return (C0949b) ipChange.ipc$dispatch("1794002299", new Object[0]);
        }
        if (a == null) {
            synchronized (C0949b.class) {
                if (a == null) {
                    a = new C0949b();
                }
            }
        }
        return a;
    }

    public static void e(File file, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2042713471")) {
            ipChange.ipc$dispatch("-2042713471", new Object[]{file, str});
            return;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            File file3 = new File(str + File.separator + nextElement.getName());
            if (nextElement.isDirectory()) {
                if (!file3.exists()) {
                    file3.mkdirs();
                }
            } else {
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                InputStream inputStream = zipFile.getInputStream(nextElement);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileInputStream, java.io.InputStream] */
    public String c(Context context, String str) {
        BufferedReader bufferedReader;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1255340366")) {
            return (String) ipChange.ipc$dispatch("1255340366", new Object[]{this, context, str});
        }
        StringBuilder sb = new StringBuilder();
        if (context != 0) {
            ?? r1 = 0;
            r1 = 0;
            try {
                try {
                    try {
                        if (!new File(context.getFilesDir(), str).exists()) {
                            return null;
                        }
                        context = context.openFileInput(str);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(context));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = null;
                        } catch (Throwable th) {
                            th = th;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    throw th;
                                }
                            }
                            if (context != 0) {
                                context.close();
                            }
                            throw th;
                        }
                        try {
                            new String();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            bufferedReader.close();
                            if (context != 0) {
                                context.close();
                            }
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (context != 0) {
                                context.close();
                            }
                            return sb.toString();
                        }
                    } catch (IOException e5) {
                        bufferedReader = null;
                        e = e5;
                        context = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        context = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r1 = str;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        return sb.toString();
    }

    public void d(Context context, String str, String str2) {
        FileOutputStream fileOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94404749")) {
            ipChange.ipc$dispatch("-94404749", new Object[]{this, context, str, str2});
        } else if (TextUtils.isEmpty(str2) || context == null) {
        } else {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    fileOutputStream = context.openFileOutput(str, 0);
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                            try {
                                bufferedWriter2.write(str2);
                                bufferedWriter2.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (IOException e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }
}
