package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class j11 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CACHE = "damaitdplay/cache";
    public static final String CACHE2 = "damaitdplay/imagecache";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class b implements Comparator<File> {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1271169077") ? ((Integer) ipChange.ipc$dispatch("-1271169077", new Object[]{this, file, file2})).intValue() : file.lastModified() > file2.lastModified() ? 1 : 0;
        }
    }

    private static void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753322590")) {
            ipChange.ipc$dispatch("-753322590", new Object[]{context});
            return;
        }
        try {
            File[] listFiles = new File(context.getFilesDir() + File.separator).listFiles();
            if (listFiles.length > 400) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    arrayList.add(file);
                }
                Collections.sort(arrayList, new b());
                int size = arrayList.size() - 200;
                for (int i = 0; i < size; i++) {
                    ((File) arrayList.get(i)).delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        String absolutePath;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861153209")) {
            return (String) ipChange.ipc$dispatch("1861153209", new Object[]{context});
        }
        if (Environment.getExternalStorageState().equals("mounted") && ir1.i(mr1.STORAGE)) {
            absolutePath = context.getExternalCacheDir().getAbsolutePath();
        } else {
            absolutePath = context.getCacheDir().getAbsolutePath();
        }
        File file = new File(absolutePath + File.separator + CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String c(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316666811")) {
            return (String) ipChange.ipc$dispatch("1316666811", new Object[]{str, context});
        }
        String str2 = "";
        if (str != null) {
            String str3 = th2.c(str) + ".jpeg";
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        a(context);
                        File file = new File(b(context));
                        if (file.exists() && file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                file2.delete();
                            }
                        } else {
                            file.mkdirs();
                        }
                        str2 = b(context) + File.separator + str3;
                        File file3 = new File(str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                        try {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            e = e;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return str2;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception unused2) {
            }
        }
        return str2;
    }

    public static String d(String str, Bitmap bitmap, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834925059")) {
            return (String) ipChange.ipc$dispatch("1834925059", new Object[]{str, bitmap, context});
        }
        String str2 = "";
        if (bitmap != null && str != null) {
            String str3 = th2.c(str) + ".jpeg";
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        a(context);
                        File file = new File(b(context));
                        if (file.exists() && file.isDirectory()) {
                            for (File file2 : file.listFiles()) {
                                file2.delete();
                            }
                        } else {
                            file.mkdirs();
                        }
                        str2 = b(context) + File.separator + str3;
                        File file3 = new File(str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                        try {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            e = e;
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return str2;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused2) {
            }
        }
        return str2;
    }
}
