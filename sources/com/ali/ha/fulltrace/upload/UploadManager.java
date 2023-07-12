package com.ali.ha.fulltrace.upload;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.ha.fulltrace.C2940a;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.ih0;
import tb.ka2;
import tb.lb1;
import tb.pp0;
import tb.vu2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UploadManager {
    public static final String HOTDATA = "hotdata";
    private Application a;
    private SharedPreferences b;
    private long c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private int g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$a */
    /* loaded from: classes17.dex */
    public class C2942a implements FileFilter {
        C2942a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile() && UploadManager.this.e(file, ".trace") > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$b */
    /* loaded from: classes17.dex */
    public class C2943b implements Comparator<File> {
        C2943b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((UploadManager.this.e(file, ".trace") - UploadManager.this.e(file2, ".trace")) > 0L ? 1 : ((UploadManager.this.e(file, ".trace") - UploadManager.this.e(file2, ".trace")) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$c */
    /* loaded from: classes17.dex */
    public class C2944c implements FileFilter {
        C2944c(UploadManager uploadManager) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(".trace");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$d */
    /* loaded from: classes17.dex */
    public class C2945d implements FileFilter {
        C2945d(UploadManager uploadManager) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().endsWith(".trace");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$e */
    /* loaded from: classes17.dex */
    public class C2946e implements FileFilter {
        C2946e() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && UploadManager.this.g(file.getName()) > 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$f */
    /* loaded from: classes17.dex */
    public class C2947f implements Comparator<File> {
        C2947f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((UploadManager.this.g(file2.getName()) - UploadManager.this.g(file.getName())) > 0L ? 1 : ((UploadManager.this.g(file2.getName()) - UploadManager.this.g(file.getName())) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$g */
    /* loaded from: classes17.dex */
    public class C2948g implements FileFilter {
        C2948g() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && UploadManager.this.g(file.getName()) > 0 && !file.getName().equals(String.valueOf(DumpManager.c));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.ali.ha.fulltrace.upload.UploadManager$h */
    /* loaded from: classes17.dex */
    private static final class C2949h {
        private static final UploadManager a = new UploadManager();
    }

    private void d(List<File> list, long j) {
        File[] listFiles;
        long j2 = j;
        int size = list.size();
        long j3 = j2 - this.l;
        long currentTimeMillis = System.currentTimeMillis();
        int i = 1;
        int i2 = size - 1;
        while (i2 > -1) {
            File file = list.get(i2);
            if (file.isDirectory() && (listFiles = file.listFiles(new C2944c(this))) != null) {
                int length = listFiles.length;
                int i3 = 0;
                while (i3 < length) {
                    File file2 = listFiles[i3];
                    if (file2.isFile()) {
                        if (j3 > 0) {
                            Object[] objArr = new Object[i];
                            objArr[0] = "total size large than MAX_CACHE_SIZE! " + j2 + " remove=" + file2.getAbsolutePath() + AltriaXLaunchTime.SPACE + file2.length() + " outSize=" + j3;
                            lb1.d("UploadManager", objArr);
                            j3 -= file2.length();
                            file2.delete();
                        } else if (file2.length() >= this.k) {
                            lb1.b("UploadManager", "file size is to large! " + file2.getAbsolutePath() + " " + file2.length());
                            file2.delete();
                        } else {
                            long e = e(file2, ".trace");
                            if (e > 0 && currentTimeMillis - e > this.i) {
                                lb1.d("UploadManager", "file date is expired! " + file2.getAbsolutePath());
                                file2.delete();
                                i3++;
                                j2 = j;
                                i = 1;
                            }
                        }
                    }
                    i3++;
                    j2 = j;
                    i = 1;
                }
            }
            i2--;
            j2 = j;
            i = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e(File file, String str) {
        String name = file.getName();
        if (TextUtils.isEmpty(str)) {
            return g(name);
        }
        int indexOf = name.indexOf(str);
        if (indexOf > 0) {
            return g(name.substring(0, indexOf));
        }
        return -1L;
    }

    public static final UploadManager f() {
        return C2949h.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    private List<File> h() {
        File[] listFiles;
        File file = new File(DumpManager.e(this.a));
        if (!file.exists() || (listFiles = file.listFiles(new C2946e())) == null || listFiles.length <= 1) {
            return null;
        }
        List asList = Arrays.asList(listFiles);
        if (asList.size() > 1) {
            Collections.sort(asList, new C2947f());
        }
        ArrayList arrayList = new ArrayList(asList);
        arrayList.remove(0);
        return arrayList;
    }

    private void k() {
        SharedPreferences a = vu2.b().a(this.a, "com.ali.fulltrace");
        this.b = a;
        long j = a.getLong("date", 0L);
        this.c = this.b.getLong("size", 0L);
        long currentTimeMillis = System.currentTimeMillis() / 86400000;
        if (currentTimeMillis != j) {
            this.b.edit().putLong("date", currentTimeMillis).putLong("size", 0L).apply();
            this.c = 0L;
        }
        this.g = 30000;
        this.h = 1048576L;
        this.i = 604800000L;
        this.j = 300000L;
        this.k = 256000L;
        this.l = 52428800L;
    }

    private void l() {
        File[] listFiles;
        String d = DumpManager.d(this.a);
        String e = DumpManager.e(this.a);
        File file = new File(d);
        if (!file.exists() || (listFiles = file.listFiles(new C2948g())) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            StringBuilder sb = new StringBuilder();
            sb.append(file2.getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append(HOTDATA);
            String str2 = e + str + file2.getName();
            if (new File(sb.toString()).exists()) {
                DumpManager.c().g(file2.getAbsolutePath(), str2);
            }
            C2940a.a(file2);
        }
    }

    private long m(List<File> list) {
        File[] listFiles;
        long j = 0;
        for (File file : list) {
            if (file.isDirectory() && (listFiles = file.listFiles(new C2945d(this))) != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        j += file2.length();
                    }
                }
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f || this.e) {
            return;
        }
        this.f = true;
        l();
        List<File> h = h();
        if (h != null && h.size() > 0) {
            d(h, m(h));
            lb1.a("start upload", new Object[0]);
            this.e = p(h);
            if (!this.e && this.d) {
                pp0.a().b().postDelayed(new Runnable() { // from class: com.ali.ha.fulltrace.upload.UploadManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UploadManager.this.n();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, this.j);
            }
            this.f = false;
            lb1.a("finish upload", new Object[0]);
            return;
        }
        lb1.d("UploadManager", "upload dir is empty !");
        this.e = true;
        this.f = false;
    }

    private boolean o(File file, String str) {
        byte[] bArr;
        GZIPOutputStream gZIPOutputStream;
        boolean a;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray;
        long j = 0;
        if (file.length() == 0) {
            return true;
        }
        try {
            boolean j2 = j();
            if (j2) {
                j = this.c + ((long) (file.length() * 0.4d));
                if (j >= this.h) {
                    lb1.g("UploadManager", "upload size larger than MAX_MOBILE_TRAFFIC! " + file.getAbsolutePath() + " " + file.length() + " " + j);
                    return false;
                }
            }
            byte[] e = C2940a.e(file);
            if (e == null) {
                lb1.b("UploadManager", "read file failed! " + file.getAbsolutePath() + " " + file.length());
                return true;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(e);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (Throwable unused) {
                        bArr = null;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    }
                } catch (Throwable unused2) {
                    gZIPOutputStream = null;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    bArr = null;
                }
            } catch (Throwable unused3) {
                bArr = null;
                gZIPOutputStream = null;
            }
            if (byteArray != null && byteArray.length != 0) {
                byte[] bArr2 = Base64.encode(byteArray, 2);
                if (bArr2 != null) {
                    try {
                    } catch (Throwable unused4) {
                        gZIPOutputStream = null;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        bArr = bArr2;
                        lb1.b("UploadManager", "gzip and base64 error!");
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e2) {
                                lb1.b("baOS close failed", e2);
                            }
                        }
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e3) {
                                lb1.b("gzipOS close failed", e3);
                            }
                        }
                        bArr2 = bArr;
                        a = ka2.a(str, new String(bArr2));
                        if (a) {
                            this.c = j;
                            this.b.edit().putLong("size", this.c).apply();
                        }
                        return a;
                    }
                    if (bArr2.length != 0) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            lb1.b("baOS close failed", e4);
                        }
                        a = ka2.a(str, new String(bArr2));
                        if (a && j2) {
                            this.c = j;
                            this.b.edit().putLong("size", this.c).apply();
                        }
                        return a;
                    }
                }
                lb1.b("UploadManager", "base64 failed!");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    lb1.b("baOS close failed", e5);
                }
                return true;
            }
            lb1.b("UploadManager", "gzip failed!");
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
                lb1.b("baOS close failed", e6);
            }
            return true;
        } catch (OutOfMemoryError unused5) {
            file.delete();
            lb1.b("UploadManager", "read file oom! " + file.getAbsolutePath() + " " + file.length());
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private boolean p(List<File> list) {
        for (File file : list) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles(new C2942a());
                if (listFiles != null && listFiles.length > 0) {
                    List asList = Arrays.asList(listFiles);
                    if (asList.size() > 1) {
                        Collections.sort(asList, new C2943b());
                    }
                    String substring = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/") + 1);
                    String num = Integer.toString((substring + ih0.g).hashCode());
                    int size = asList.size();
                    int i = 0;
                    boolean z = false;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        File file2 = (File) asList.get(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(num);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        i++;
                        sb.append(i);
                        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        sb.append(size);
                        boolean o = o(file2, sb.toString());
                        lb1.d("UploadManager", "upload file=" + file2.getAbsolutePath() + " " + o + " " + file2.length());
                        if (!o) {
                            z = o;
                            break;
                        }
                        file2.delete();
                        z = o;
                    }
                    if (!z) {
                        return false;
                    }
                    C2940a.a(file);
                } else {
                    lb1.d("UploadManager", "upload dir is empty=" + file.getAbsolutePath());
                    C2940a.a(file);
                }
            }
        }
        return true;
    }

    public void i(Application application) {
        this.a = application;
        k();
        pp0.a().b().postDelayed(new Runnable() { // from class: com.ali.ha.fulltrace.upload.UploadManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UploadManager.this.n();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, this.g);
    }

    public boolean j() {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) this.a.getSystemService("connectivity"));
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private UploadManager() {
        this.c = 0L;
        this.d = true;
        this.e = false;
        this.f = false;
        this.g = 20000;
        this.h = 1048576L;
        this.i = 604800000L;
        this.j = 300000L;
        this.k = 256000L;
        this.l = 52428800L;
    }
}
