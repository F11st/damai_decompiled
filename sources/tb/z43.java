package tb;

import android.os.Process;
import com.taobao.weex.annotation.JSMethod;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z43 {
    private static final Random a = new Random();

    public static String a(File file) {
        return l(file);
    }

    public static String b(j43 j43Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(j43Var.a.a);
        sb.append(JSMethod.NOT_SET);
        sb.append(j43Var.a.d);
        sb.append(JSMethod.NOT_SET);
        sb.append(j43Var.a.e);
        sb.append(JSMethod.NOT_SET);
        sb.append((int) j43Var.a.b);
        sb.append(JSMethod.NOT_SET);
        sb.append(Process.myPid());
        sb.append(JSMethod.NOT_SET);
        sb.append(a.nextInt(10000));
        sb.append(JSMethod.NOT_SET);
        u23.c();
        sb.append(u23.e());
        return sb.toString();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                w63.c("efs.util.file", "safe close error", th);
            }
        }
    }

    public static void d(File file, File file2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            w63.c("efs.util.file", "error when copy", e);
                            c(fileInputStream);
                            c(fileOutputStream);
                            i(file);
                        } catch (Throwable th) {
                            th = th;
                            c(fileInputStream);
                            c(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        c(fileInputStream);
                        c(fileOutputStream);
                        throw th;
                    }
                }
                c(fileInputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        c(fileOutputStream);
        i(file);
    }

    public static boolean e(File file, String str) {
        return f(file, str.getBytes());
    }

    public static boolean f(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            c(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                w63.c("efs.util.file", "write file error, filename is " + file.getName(), th);
                c(fileOutputStream2);
                return false;
            } catch (Throwable th3) {
                c(fileOutputStream2);
                throw th3;
            }
        }
    }

    public static byte[] g(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        return bArr;
    }

    public static j43 h(String str) {
        String[] split = str.split(JSMethod.NOT_SET);
        if (split.length != 7) {
            w63.b("efs.util.file", "File name error, name is ".concat(str), null);
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        j43 j43Var = new j43(str2, Byte.valueOf(split[3]).byteValue());
        j43Var.d(str3);
        j43Var.c(byteValue);
        return j43Var;
    }

    public static void i(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                i(file2);
            }
        }
        file.delete();
    }

    public static long j(File file) {
        long j = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                j += j(file2);
            }
            return j;
        }
        return 0 + file.length();
    }

    public static List<File> k(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(k(file2));
            }
        }
        return arrayList;
    }

    private static String l(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                c(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                try {
                    w63.c("efs.util.file", "read file error", th);
                    return str;
                } finally {
                    c(fileInputStream2);
                }
            }
            return str;
        }
        return "";
    }
}
