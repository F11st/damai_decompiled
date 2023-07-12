package cn.damai.homepage.splash;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.util.C0535a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* renamed from: cn.damai.homepage.splash.a */
/* loaded from: classes14.dex */
public class C1160a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WELCOME_LOCAL_CHILE_PATH = "damai/welcome";

    public static File a(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-645393311")) {
            return (File) ipChange.ipc$dispatch("-645393311", new Object[]{str});
        }
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile().exists()) {
                C0535a.e(file.getParentFile());
            }
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    private static String b(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1895380090") ? (String) ipChange.ipc$dispatch("1895380090", new Object[]{context, str}) : String.format("%s/%s/%s.dm", context.getCacheDir().getPath(), WELCOME_LOCAL_CHILE_PATH, wh2.f(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    public static void c(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        ?? r1 = "1882641768";
        if (AndroidInstantRuntime.support(ipChange, "1882641768")) {
            ipChange.ipc$dispatch("1882641768", new Object[]{context, str, str2});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        URLConnection openConnection = new URL(str).openConnection();
                        openConnection.setReadTimeout(6000);
                        r1 = openConnection.getInputStream();
                        if (r1 != 0) {
                            try {
                                File a = a(b(context, str));
                                if (!a.exists()) {
                                    try {
                                        r1.close();
                                        return;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return;
                                    }
                                }
                                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                                try {
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int read = r1.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, read);
                                    }
                                    fileOutputStream2.flush();
                                    fileOutputStream2.close();
                                    z20.A0(str2);
                                    z20.B0(str);
                                    fileOutputStream = fileOutputStream2;
                                } catch (Exception e2) {
                                    e = e2;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (r1 != 0) {
                                        r1.close();
                                        return;
                                    }
                                    return;
                                } catch (OutOfMemoryError e3) {
                                    e = e3;
                                    fileOutputStream = fileOutputStream2;
                                    e.printStackTrace();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (r1 != 0) {
                                        r1.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (r1 != 0) {
                                        r1.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                            } catch (OutOfMemoryError e6) {
                                e = e6;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        r1 = 0;
                    } catch (OutOfMemoryError e8) {
                        e = e8;
                        r1 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        r1 = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
        }
    }
}
