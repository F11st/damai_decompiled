package com.amap.api.col.s;

import android.content.Context;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bt {
    private static volatile EnumC4397b a = EnumC4397b.Unknow;
    private static volatile EnumC4399d b = EnumC4399d.Unknow;
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile long e = -1;
    private static volatile EnumC4396a f = EnumC4396a.Unknow;
    private static volatile long g = -1;
    private static volatile String h = "";
    private static volatile String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;
    private static volatile boolean m = true;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bt$a */
    /* loaded from: classes10.dex */
    public enum EnumC4396a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        
        private int d;

        EnumC4396a(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static EnumC4396a a(int i) {
            EnumC4396a enumC4396a = NotAgree;
            if (i == enumC4396a.a()) {
                return enumC4396a;
            }
            EnumC4396a enumC4396a2 = DidAgree;
            return i == enumC4396a2.a() ? enumC4396a2 : Unknow;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bt$b */
    /* loaded from: classes10.dex */
    public enum EnumC4397b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        
        private int d;

        EnumC4397b(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static EnumC4397b a(int i) {
            EnumC4397b enumC4397b = NotContain;
            if (i == enumC4397b.a()) {
                return enumC4397b;
            }
            EnumC4397b enumC4397b2 = DidContain;
            return i == enumC4397b2.a() ? enumC4397b2 : Unknow;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bt$c */
    /* loaded from: classes10.dex */
    public enum EnumC4398c {
        SuccessCode(0),
        ShowUnknowCode(555570),
        ShowNoShowCode(555571),
        InfoUnknowCode(555572),
        InfoNotContainCode(555573),
        AgreeUnknowCode(555574),
        AgreeNotAgreeCode(555575),
        InvaildUserKeyCode(10001),
        IllegalArgument(20001);
        
        private final int j;

        EnumC4398c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bt$d */
    /* loaded from: classes10.dex */
    public enum EnumC4399d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        
        private int d;

        EnumC4399d(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }

        public static EnumC4399d a(int i) {
            EnumC4399d enumC4399d = NotShow;
            if (i == enumC4399d.a()) {
                return enumC4399d;
            }
            EnumC4399d enumC4399d2 = DidShow;
            return i == enumC4399d2.a() ? enumC4399d2 : Unknow;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, JSONObject jSONObject) {
        try {
            C4404cn c4404cn = new C4404cn();
            c4404cn.b = context;
            c4404cn.a = jSONObject;
            new cz();
            dg a2 = cz.a(c4404cn);
            if (a2 != null) {
                JSONObject jSONObject2 = new JSONObject(bw.a(a2.a));
                if (jSONObject2.has("status")) {
                    return jSONObject2.getInt("status") == 1;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context) {
        synchronized (bt.class) {
            if (context == null) {
                return;
            }
            if (!l) {
                e(context);
                l = true;
            }
            co.a(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)));
        }
    }

    private static void e(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = co.a(context, "AMap.privacy.data", "AMap.privacy.data");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str == null) {
            return;
        }
        String[] split = str.split("&");
        if (split.length != 11) {
            return;
        }
        try {
            a = EnumC4397b.a(Integer.parseInt(split[0]));
            b = EnumC4399d.a(Integer.parseInt(split[1]));
            e = Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = EnumC4396a.a(Integer.parseInt(split[5]));
            g = Long.parseLong(split[6]);
            h = split[7];
            i = split[8];
            j = Long.parseLong(split[9]);
            k = Long.parseLong(split[10]);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String g(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }

    public static void a(Context context, boolean z, boolean z2, bv bvVar) {
        EnumC4399d enumC4399d;
        EnumC4397b enumC4397b;
        if (z2) {
            enumC4399d = EnumC4399d.DidShow;
        } else {
            enumC4399d = EnumC4399d.NotShow;
        }
        if (z) {
            enumC4397b = EnumC4397b.DidContain;
        } else {
            enumC4397b = EnumC4397b.NotContain;
        }
        a(context, enumC4399d, enumC4397b, bvVar);
    }

    private static synchronized void a(Context context, EnumC4399d enumC4399d, EnumC4397b enumC4397b, bv bvVar) {
        synchronized (bt.class) {
            if (context == null || bvVar == null) {
                return;
            }
            if (!l) {
                e(context);
                l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (enumC4399d != b) {
                bool = Boolean.TRUE;
                b = enumC4399d;
            }
            if (enumC4397b != a) {
                bool = Boolean.TRUE;
                a = enumC4397b;
            }
            if (bool.booleanValue()) {
                c = bvVar.b();
                d = bvVar.c();
                long currentTimeMillis = System.currentTimeMillis();
                e = currentTimeMillis;
                j = currentTimeMillis;
                d(context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j2) {
        return String.format("%d-%s", Long.valueOf(j2), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> b(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null && str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                return arrayList;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void b(Context context) {
        try {
            Iterator<File> it = b(g(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                String name = next.getName();
                if (!name.endsWith("-privacy.data")) {
                    next.delete();
                } else {
                    String[] split = name.split("-");
                    if (split == null && split.length != 2) {
                        next.delete();
                    } else if (Long.parseLong(split[0]) <= 0) {
                        next.delete();
                    } else {
                        FileInputStream fileInputStream = new FileInputStream(next);
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        if (b(context, new JSONObject(new String(co.b(context, bArr))))) {
                            next.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, boolean z, bv bvVar) {
        EnumC4396a enumC4396a;
        if (z) {
            enumC4396a = EnumC4396a.DidAgree;
        } else {
            enumC4396a = EnumC4396a.NotAgree;
        }
        a(context, enumC4396a, bvVar);
    }

    private static synchronized void a(Context context, EnumC4396a enumC4396a, bv bvVar) {
        synchronized (bt.class) {
            if (context == null || bvVar == null) {
                return;
            }
            if (!l) {
                e(context);
                l = true;
            }
            if (enumC4396a != f) {
                f = enumC4396a;
                h = bvVar.b();
                i = bvVar.c();
                long currentTimeMillis = System.currentTimeMillis();
                g = currentTimeMillis;
                j = currentTimeMillis;
                d(context);
            }
        }
    }

    public static synchronized bu a(final Context context, bv bvVar) {
        boolean z;
        synchronized (bt.class) {
            bu buVar = null;
            if (context != null && bvVar != null) {
                if (!l) {
                    e(context);
                    l = true;
                }
                if (b != EnumC4399d.DidShow) {
                    if (b == EnumC4399d.Unknow) {
                        buVar = new bu(EnumC4398c.ShowUnknowCode, bvVar);
                    } else if (b == EnumC4399d.NotShow) {
                        buVar = new bu(EnumC4398c.ShowNoShowCode, bvVar);
                    }
                    z = false;
                } else {
                    z = true;
                }
                if (z && a != EnumC4397b.DidContain) {
                    if (a == EnumC4397b.Unknow) {
                        buVar = new bu(EnumC4398c.InfoUnknowCode, bvVar);
                    } else if (a == EnumC4397b.NotContain) {
                        buVar = new bu(EnumC4398c.InfoNotContainCode, bvVar);
                    }
                    z = false;
                }
                if (z && f != EnumC4396a.DidAgree) {
                    if (f == EnumC4396a.Unknow) {
                        buVar = new bu(EnumC4398c.AgreeUnknowCode, bvVar);
                    } else if (f == EnumC4396a.NotAgree) {
                        buVar = new bu(EnumC4398c.AgreeNotAgreeCode, bvVar);
                    }
                    z = false;
                }
                if (k != j) {
                    final long j2 = j;
                    k = j;
                    try {
                        final JSONObject jSONObject = new JSONObject();
                        jSONObject.put(PrivacyDoubleListReporter.UT_KEY, a.a());
                        jSONObject.put("privacyShow", b.a());
                        jSONObject.put("showTime", e);
                        jSONObject.put("show2SDK", c);
                        jSONObject.put("show2SDKVer", d);
                        jSONObject.put("privacyAgree", f.a());
                        jSONObject.put("agreeTime", g);
                        jSONObject.put("agree2SDK", h);
                        jSONObject.put("agree2SDKVer", i);
                        final boolean z2 = m;
                        ed.a().b(new ee() { // from class: com.amap.api.col.s.bt.2
                            @Override // com.amap.api.col.s.ee
                            public final void a() {
                                if (z2) {
                                    Iterator it = bt.b(bt.f(context)).iterator();
                                    while (it.hasNext()) {
                                        bt.a(context, ((File) it.next()).getName());
                                    }
                                }
                                bt.d(context);
                                bt.a(context, jSONObject, j2);
                                boolean b2 = bt.b(context, jSONObject);
                                if (b2) {
                                    bt.b(context, bt.b(j2));
                                }
                                if (z2) {
                                    bt.b(context);
                                }
                                if (b2) {
                                    return;
                                }
                                bt.a(context, bt.b(j2));
                            }
                        });
                    } catch (Throwable unused) {
                    }
                } else if (m) {
                    ed.a().b(new ee() { // from class: com.amap.api.col.s.bt.1
                        @Override // com.amap.api.col.s.ee
                        public final void a() {
                            Iterator it = bt.b(bt.f(context)).iterator();
                            while (it.hasNext()) {
                                bt.a(context, ((File) it.next()).getName());
                            }
                            bt.b(context);
                        }
                    });
                }
                m = false;
                String f2 = bk.f(context);
                if (f2 == null || f2.length() <= 0) {
                    buVar = new bu(EnumC4398c.InvaildUserKeyCode, bvVar);
                    Log.e(bvVar.b(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(buVar.a.a()), buVar.b));
                }
                if (z) {
                    buVar = new bu(EnumC4398c.SuccessCode, bvVar);
                } else {
                    Log.e(bvVar.b(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(buVar.a.a()), buVar.b));
                }
                return buVar;
            }
            return new bu(EnumC4398c.IllegalArgument, bvVar);
        }
    }

    static /* synthetic */ void b(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String f2 = f(context);
            File file = new File(f2 + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String f2 = f(context);
            File file = new File(f2 + "/" + str);
            if (file.exists()) {
                String g2 = g(context);
                File file2 = new File(g2 + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void a(Context context, JSONObject jSONObject, long j2) {
        byte[] a2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = co.a(context, jSONObject.toString().getBytes());
            String b2 = b(j2);
            String f2 = f(context);
            File file = new File(f2 + "/" + b2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(a2);
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            fileOutputStream2 = fileOutputStream;
            th = th3;
            try {
                th.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
    }
}
