package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class dw2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String a = f(dw2.class);

    public static File a(Context context, String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1537301454")) {
            return (File) ipChange.ipc$dispatch("1537301454", new Object[]{context, str});
        }
        if (d()) {
            str2 = context.getExternalCacheDir() + File.separator + str;
        } else {
            str2 = context.getCacheDir().getPath() + File.separator + str;
        }
        File file = new File(str2);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            Log.i(a, str2 + " has created. " + mkdirs);
        }
        return file;
    }

    public static void b(File file, boolean z) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1617034660")) {
            ipChange.ipc$dispatch("-1617034660", new Object[]{file, Boolean.valueOf(z)});
        } else if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    b(file2, true);
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static long c(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812929152")) {
            return ((Long) ipChange.ipc$dispatch("1812929152", new Object[]{file})).longValue();
        }
        long j = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        j += c(file2);
                    }
                    return j;
                }
                return 0L;
            }
            return 0 + file.length();
        }
        return 0L;
    }

    public static boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824846481")) {
            return ((Boolean) ipChange.ipc$dispatch("1824846481", new Object[0])).booleanValue();
        }
        return Environment.getExternalStorageState().equals("mounted") && ir1.i(mr1.STORAGE);
    }

    public static boolean e(File file, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "841326597") ? ((Boolean) ipChange.ipc$dispatch("841326597", new Object[]{file, str})).booleanValue() : new File(file, str).exists();
    }

    public static String f(Class<?> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-532380543") ? (String) ipChange.ipc$dispatch("-532380543", new Object[]{cls}) : cls.getSimpleName();
    }

    public static void g(File file, String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-556969133")) {
            ipChange.ipc$dispatch("-556969133", new Object[]{file, str, bitmap});
        } else if (bitmap == null) {
        } else {
            File file2 = new File(file, str);
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
