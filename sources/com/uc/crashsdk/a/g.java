package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.taobao.weex.common.Constants;
import com.uc.crashsdk.JNIBridge;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class g {
    static final /* synthetic */ boolean a = true;
    private static Context b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static boolean h;
    private static final Object i = new Object();
    private static final char[] j = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) {
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
                            a(fileInputStream2);
                            a(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void b(File file) {
        a(file, "");
    }

    public static String c(File file) {
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
                byte[] bArr = new byte[256];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                a(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                try {
                    a(th, false);
                    return str;
                } finally {
                    a(fileInputStream2);
                }
            }
            return str;
        }
        return "";
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static byte[] e(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (file.exists()) {
            try {
                bArr = new byte[(int) file.length()];
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th, false);
                    return null;
                } finally {
                    a(fileInputStream);
                }
            }
        }
        return null;
    }

    public static boolean f() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean g() {
        int indexOf;
        String i2 = i();
        if (!a(i2) && (indexOf = i2.indexOf(" root ")) > 0) {
            String substring = i2.substring(0, indexOf);
            if (substring.contains(Constants.Name.X) || substring.contains("s")) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        return a(f) ? "" : f;
    }

    public static String i() {
        l();
        return a(g) ? "" : g;
    }

    public static void j() {
        f.a(0, new e(800), 15000L);
    }

    public static void k() {
        if (com.uc.crashsdk.b.d && h) {
            JNIBridge.set(123, f);
            JNIBridge.set(124, g);
        }
    }

    private static void l() {
        String trim;
        int indexOf;
        int indexOf2;
        if (h) {
            return;
        }
        synchronized (i) {
            if (h) {
                return;
            }
            String a2 = a(new String[]{"sh", "-c", "type su"});
            if (!a(a2) && (indexOf = (trim = a2.trim()).indexOf(32)) > 0 && trim.contains("/su") && (indexOf2 = trim.indexOf(47, indexOf + 1)) > 0) {
                String substring = trim.substring(indexOf2);
                f = substring;
                String a3 = a(new String[]{"ls", "-l", substring});
                if (!a(a3)) {
                    g = a3.trim();
                }
            }
            h = true;
            k();
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String d() {
        String str = e;
        return str != null ? str : "";
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = digest[i3];
                char[] cArr = j;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }

    public static String b() {
        return c;
    }

    public static String a(File file, int i2, boolean z) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[i2];
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                return new String(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            if (z) {
                try {
                    a(th, false);
                } finally {
                    a(fileInputStream);
                }
            }
            return null;
        }
        return null;
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static long c(String str) {
        if (a(str)) {
            return 0L;
        }
        try {
            long parseLong = Long.parseLong(str.trim());
            if (parseLong < 0) {
                return 0L;
            }
            return parseLong;
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static String c() {
        return d;
    }

    public static ArrayList<String> a(File file, int i2) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2, 512);
                int i3 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i3++;
                        if (i2 > 0 && i3 >= i2) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        try {
                            a(th, false);
                            a(fileReader);
                            a(bufferedReader);
                            return arrayList;
                        } catch (Throwable th2) {
                            a(fileReader);
                            a(bufferedReader);
                            throw th2;
                        }
                    }
                }
                a(fileReader2);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
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
            a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                a(th, false);
                return false;
            } finally {
                a(fileOutputStream2);
            }
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str, 0, str.length());
            a(fileWriter);
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            try {
                a(th, false);
                return false;
            } finally {
                a(fileWriter2);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r2.toLowerCase().startsWith("http") != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r2, java.lang.String r3, boolean r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L2a
            java.lang.String r2 = com.uc.crashsdk.a.b.a(r2)
            boolean r0 = a(r2)
            if (r0 == 0) goto L17
            goto L2a
        L17:
            if (r4 == 0) goto L29
            java.lang.String r2 = r2.trim()
            java.lang.String r4 = r2.toLowerCase()
            java.lang.String r0 = "http"
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L2a
        L29:
            r1 = r2
        L2a:
            if (r1 != 0) goto L2d
            goto L2e
        L2d:
            r3 = r1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.g.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.M()) {
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (b != null) {
            a.b("mContext is existed");
        }
        b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj == null || !(obj instanceof String)) {
                return;
            }
            e = (String) obj;
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static Context a() {
        return b;
    }

    public static void a(int i2) {
        if (i2 != 800) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        l();
    }

    private static String a(String[] strArr) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 512);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return sb.toString().trim();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                a(th, false);
                return null;
            } finally {
                a(bufferedReader);
                a(inputStreamReader);
            }
        }
    }
}
