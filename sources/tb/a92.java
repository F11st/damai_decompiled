package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a92 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String a = mu0.a().getFilesDir().getAbsolutePath();
    public static String b = "damai";
    public static String c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String str = File.separator;
        sb.append(str);
        sb.append(b);
        sb.append(str);
        sb.append("1111.zip");
        c = a + str + b + str + "1111";
    }

    public static File a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748775906")) {
            return (File) ipChange.ipc$dispatch("-1748775906", new Object[]{str});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-316726102") ? (String) ipChange.ipc$dispatch("-316726102", new Object[0]) : a;
    }

    public static String c(File file) throws IOException {
        FileInputStream fileInputStream;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218953023")) {
            return (String) ipChange.ipc$dispatch("218953023", new Object[]{file});
        }
        String str2 = "";
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    str = new String(bArr);
                } catch (FileNotFoundException e) {
                    e = e;
                }
                try {
                    fileInputStream.close();
                    fileInputStream.close();
                    return str;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    str2 = str;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        }
    }

    public static void d(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223373532")) {
            ipChange.ipc$dispatch("1223373532", new Object[]{file});
        } else if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    d(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }
}
