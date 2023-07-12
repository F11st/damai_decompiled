package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fs {
    private static AssetManager b = null;
    private static Resources c = null;
    private static Resources d = null;
    private static boolean e = true;
    private static Context f = null;
    private static String g = "amap_resource";
    private static String h = "1_0_0";
    private static String j = ".jar";
    private static String k = g + h + j;
    private static String i = ".png";
    private static String l = g + h + i;
    private static String m = "";
    private static String n = m + k;
    private static Resources.Theme o = null;
    private static Resources.Theme p = null;
    private static Field q = null;
    private static Field r = null;
    private static Activity s = null;
    public static int a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.fs$a */
    /* loaded from: classes10.dex */
    public static class C4548a implements FilenameFilter {
        C4548a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(fs.h);
            sb.append(fs.j);
            return str.startsWith(fs.g) && !str.endsWith(sb.toString());
        }
    }

    public static boolean a(Context context) {
        try {
            f = context;
            File b2 = b(context);
            if (b2 != null) {
                m = b2.getAbsolutePath() + "/";
            }
            n = m + k;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (e) {
            if (c(context)) {
                AssetManager a2 = a(n);
                b = a2;
                c = a(context, a2);
                return true;
            }
            return false;
        }
        return true;
    }

    private static void e() {
        File[] listFiles = new File(m).listFiles(new C4548a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }

    private static File b(Context context) {
        File filesDir;
        try {
            if (context == null) {
                if (context != null) {
                    context.getFilesDir();
                }
                return null;
            }
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    if (!Environment.getExternalStorageDirectory().canWrite()) {
                        filesDir = context.getFilesDir();
                    } else {
                        filesDir = context.getExternalFilesDir("LBS");
                    }
                } else {
                    filesDir = context.getFilesDir();
                }
                if (filesDir == null) {
                    context.getFilesDir();
                }
                return filesDir;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (0 == 0) {
                    return context.getFilesDir();
                }
                return null;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean c(Context context) {
        d(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(l);
            if (b(inputStream)) {
                return true;
            }
            e();
            OutputStream a2 = a(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    hd.c(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                hd.c(th, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        hd.c(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                return false;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        hd.c(e4, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
            }
        }
    }

    private static void d(Context context) {
        m = context.getFilesDir().getAbsolutePath();
        n = m + "/" + k;
    }

    public static Resources a() {
        Resources resources = c;
        return resources == null ? f.getResources() : resources;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    private static boolean b(InputStream inputStream) throws IOException {
        File file = new File(n);
        long length = file.length();
        int available = inputStream.available();
        if (file.exists() && length == available) {
            inputStream.close();
            return true;
        }
        return false;
    }

    private static AssetManager a(String str) {
        Class<?> cls;
        AssetManager assetManager;
        AssetManager assetManager2 = null;
        try {
            cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            return assetManager;
        } catch (Throwable th2) {
            th = th2;
            assetManager2 = assetManager;
            hd.c(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager2;
        }
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(m, k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    public static View a(Context context, int i2, ViewGroup viewGroup) {
        XmlResourceParser xml = a().getXml(i2);
        if (!e) {
            return LayoutInflater.from(context).inflate(xml, viewGroup);
        }
        try {
            int i3 = a;
            if (i3 == -1) {
                i3 = 0;
            }
            return LayoutInflater.from(new fr(context, i3, fs.class.getClassLoader())).inflate(xml, viewGroup);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                hd.c(th, "ResourcesUtil", "selfInflate(Activity activity, int resource, ViewGroup root)");
                xml.close();
                return null;
            } finally {
                xml.close();
            }
        }
    }
}
