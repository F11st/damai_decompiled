package com.alibaba.security.common.d;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class n {
    private static final String a = "n";
    private static n c = null;
    private static final String d = "armeabi-v7a";
    private static final String e = "arm64-v8a";
    private final Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements FileFilter {
        String a;

        public a(String str) {
            this.a = "";
            this.a = str;
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return file.getName().startsWith(this.a);
        }
    }

    private n(Context context) {
        this.b = context;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n(context);
            }
            nVar = c;
        }
        return nVar;
    }

    public final boolean a(String str) {
        File filesDir;
        String str2 = str + "_bak";
        if (a(this.b.getFilesDir().toString(), str2, str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String str3 = File.separator;
            sb.append(str3);
            sb.append(SolidMonitor.CHECK_TYPE_LIB + str + ".so");
            File file = new File(filesDir.toString() + str3 + sb.toString());
            if (file.exists()) {
                try {
                    System.load(file.toString());
                    return true;
                } catch (UnsatisfiedLinkError e2) {
                    com.alibaba.security.common.c.a.d(a, e2.toString());
                }
            } else {
                com.alibaba.security.common.c.a.a(a, String.format(Locale.ENGLISH, "error can't find %1$s lib in plugins_lib", str));
            }
        } else {
            String.format(Locale.ENGLISH, "error copy %1$s lib fail", str);
        }
        return false;
    }

    private void a(File file, String str) {
        try {
            for (File file2 : file.listFiles(new a(str))) {
                a(file2);
            }
        } catch (Exception e2) {
            com.alibaba.security.common.c.a.d(a, e2.toString());
        }
    }

    private void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            } else if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
                file.delete();
                return;
            } else {
                return;
            }
        }
        com.alibaba.security.common.c.a.a(a, "File to be delete is not found");
    }

    private boolean a(String str, String str2, String str3) {
        String concat;
        String cpu_abi = Build.getCPU_ABI();
        String str4 = SolidMonitor.CHECK_TYPE_LIB + str3 + ".so";
        if (DeviceUtils.ABI_X86.equals(cpu_abi)) {
            concat = "lib/armeabi-v7a/".concat(String.valueOf(str4));
        } else if (cpu_abi.startsWith("armeabi")) {
            concat = "lib/armeabi-v7a/".concat(String.valueOf(str4));
        } else if (!cpu_abi.startsWith("arm64")) {
            return false;
        } else {
            concat = "lib/arm64-v8a/".concat(String.valueOf(str4));
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str5 = File.separator;
            sb.append(str5);
            sb.append(str2);
            File file = new File(sb.toString());
            File file2 = new File(file.toString() + str5 + str4);
            a(file, SolidMonitor.CHECK_TYPE_LIB.concat(String.valueOf(str3)));
            file.mkdirs();
            return a(concat, file2);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(String str, File file) {
        InputStream resourceAsStream = n.class.getClassLoader().getResourceAsStream(str);
        if (resourceAsStream != null) {
            boolean a2 = a(resourceAsStream, file);
            try {
                resourceAsStream.close();
                return a2;
            } catch (IOException unused) {
                return a2;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.BufferedOutputStream] */
    private static boolean a(InputStream inputStream, File file) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    bufferedInputStream = new BufferedInputStream(inputStream);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream((File) file);
                        try {
                            file = new BufferedOutputStream(fileOutputStream2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                        file.write(bArr, 0, read);
                                    } else {
                                        file.flush();
                                        fileOutputStream2.flush();
                                        fileOutputStream2.close();
                                        bufferedInputStream.close();
                                        file.close();
                                        return true;
                                    }
                                }
                            } catch (FileNotFoundException e2) {
                                fileOutputStream = fileOutputStream2;
                                e = e2;
                                file = file;
                                com.alibaba.security.common.c.a.d(a, e.toString());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                return false;
                            } catch (IOException e3) {
                                fileOutputStream = fileOutputStream2;
                                e = e3;
                                file = file;
                                com.alibaba.security.common.c.a.d(a, e.toString());
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                fileOutputStream = fileOutputStream2;
                                th = th;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                        com.alibaba.security.common.c.a.d(a, e4.toString());
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e5) {
                            fileOutputStream = fileOutputStream2;
                            e = e5;
                            file = 0;
                        } catch (IOException e6) {
                            fileOutputStream = fileOutputStream2;
                            e = e6;
                            file = 0;
                        } catch (Throwable th2) {
                            fileOutputStream = fileOutputStream2;
                            th = th2;
                            file = 0;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        file = 0;
                    } catch (IOException e8) {
                        e = e8;
                        file = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        file = 0;
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    file = 0;
                    bufferedInputStream = null;
                } catch (IOException e10) {
                    e = e10;
                    file = 0;
                    bufferedInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    file = 0;
                    bufferedInputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (IOException e11) {
            com.alibaba.security.common.c.a.d(a, e11.toString());
            return false;
        }
    }
}
