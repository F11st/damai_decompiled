package com.youku.httpcommunication;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class c {
    public static String a;
    static volatile boolean b;
    private static final String[] c;
    private static String[] d;
    private static int e;
    private static final String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    static {
        try {
            a = Environment.getExternalStorageDirectory().getPath() + "/youku/cacheData/";
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String[] strArr = {"statis.api.3g.youku.com", "api.mobile.youku.com", "openapi.youku.com", "count.atm.youku.com", "v2html.atm.youku.com", "account.youku.com", "v.youku.com", "c.yes.youku.com", "www.youku.com", "iku.youku.com", "myes.youku.com", "iyes.youku.com", "valf.atm.youku.com", "cm.miaozhen.atm.youku.com", "tip.soku.com", "pcclient.relay.youku.com", "ups.youku.com", "huodong.m.taobao.com"};
        c = strArr;
        d = strArr;
        e = 0;
        b = false;
        f = System.getProperty("line.separator");
    }

    public static void a() {
        if (b) {
            return;
        }
        b = true;
        new Thread() { // from class: com.youku.httpcommunication.Utils$1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(30L));
                } catch (Exception unused) {
                }
                OrangeConfig.getInstance().registerListener(new String[]{"arch_common_config"}, new OrangeConfigListenerV1() { // from class: com.youku.httpcommunication.Utils$1.1
                    @Override // com.taobao.orange.OrangeConfigListenerV1
                    public void onConfigUpdate(String str, boolean z) {
                        String[] strArr;
                        OrangeConfig orangeConfig = OrangeConfig.getInstance();
                        strArr = c.c;
                        String[] unused2 = c.d = orangeConfig.getConfig("arch_common_config", "accs_whitelist", TextUtils.join(",", strArr)).split(",");
                    }
                });
            }
        }.start();
    }

    public static void a(File file, File file2) {
        if (file == null) {
            return;
        }
        File[] listFiles = file.listFiles();
        int i = e;
        if (i == 0) {
            if (listFiles == null) {
                return;
            }
            int i2 = 0;
            for (File file3 : listFiles) {
                i2 = (int) (i2 + file3.length());
            }
            e = i2;
        } else if (file2 != null) {
            e = (int) (i + file2.length());
            com.youku.httpcommunication.a.b("HttpCommunication.Utils", "cacheData after add file " + e);
        }
        if (e < 10485760 || listFiles == null) {
            return;
        }
        int length = (int) ((listFiles.length * 0.4d) + 1.0d);
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        try {
            Arrays.sort(listFiles, new a());
        } catch (Exception e2) {
            com.youku.httpcommunication.a.a("HttpCommunication.Utils", "NetworkUtils", e2);
        }
        for (int i3 = 0; i3 < length; i3++) {
            listFiles[i3].delete();
        }
        e = 0;
        a(file, null);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : d) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void b() {
        if (c()) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public static boolean b(String str) {
        return !c(str);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT < 8;
    }

    public static boolean c(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return str;
        }
    }

    public static boolean d() {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) b.a.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (connectivityManager == null) {
            com.youku.httpcommunication.a.b("NetWorkState", "Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    com.youku.httpcommunication.a.b("NetWorkState", "Availabel");
                    return true;
                }
            }
        }
        return false;
    }
}
