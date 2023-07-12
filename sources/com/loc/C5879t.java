package com.loc;

import android.content.Context;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import tb.b43;
import tb.t43;
import tb.z33;

/* compiled from: Taobao */
/* renamed from: com.loc.t */
/* loaded from: classes10.dex */
public final class C5879t {
    private static volatile EnumC5881b a = EnumC5881b.Unknow;
    private static volatile EnumC5883d b = EnumC5883d.Unknow;
    private static volatile String c = "";
    private static volatile String d = "";
    private static volatile long e = -1;
    private static volatile EnumC5880a f = EnumC5880a.Unknow;
    private static volatile long g = -1;
    private static volatile String h = "";
    private static volatile String i = "";
    private static volatile long j = 0;
    private static volatile long k = 0;
    private static volatile boolean l = false;
    private static volatile boolean m = true;

    /* compiled from: Taobao */
    /* renamed from: com.loc.t$a */
    /* loaded from: classes10.dex */
    public enum EnumC5880a {
        Unknow(-1),
        NotAgree(0),
        DidAgree(1);
        
        private int d;

        EnumC5880a(int i) {
            this.d = i;
        }

        public static EnumC5880a a(int i) {
            EnumC5880a enumC5880a = NotAgree;
            if (i == enumC5880a.a()) {
                return enumC5880a;
            }
            EnumC5880a enumC5880a2 = DidAgree;
            return i == enumC5880a2.a() ? enumC5880a2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.t$b */
    /* loaded from: classes10.dex */
    public enum EnumC5881b {
        Unknow(-1),
        NotContain(0),
        DidContain(1);
        
        private int d;

        EnumC5881b(int i) {
            this.d = i;
        }

        public static EnumC5881b a(int i) {
            EnumC5881b enumC5881b = NotContain;
            if (i == enumC5881b.a()) {
                return enumC5881b;
            }
            EnumC5881b enumC5881b2 = DidContain;
            return i == enumC5881b2.a() ? enumC5881b2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.t$c */
    /* loaded from: classes10.dex */
    public enum EnumC5882c {
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

        EnumC5882c(int i) {
            this.j = i;
        }

        public final int a() {
            return this.j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.loc.t$d */
    /* loaded from: classes10.dex */
    public enum EnumC5883d {
        Unknow(-1),
        NotShow(0),
        DidShow(1);
        
        private int d;

        EnumC5883d(int i) {
            this.d = i;
        }

        public static EnumC5883d a(int i) {
            EnumC5883d enumC5883d = NotShow;
            if (i == enumC5883d.a()) {
                return enumC5883d;
            }
            EnumC5883d enumC5883d2 = DidShow;
            return i == enumC5883d2.a() ? enumC5883d2 : Unknow;
        }

        public final int a() {
            return this.d;
        }
    }

    public static synchronized s1 a(final Context context, u1 u1Var) {
        boolean z;
        synchronized (C5879t.class) {
            s1 s1Var = null;
            if (context == null || u1Var == null) {
                return new s1(EnumC5882c.IllegalArgument, u1Var);
            }
            if (!l) {
                s(context);
                l = true;
            }
            if (b != EnumC5883d.DidShow) {
                if (b == EnumC5883d.Unknow) {
                    s1Var = new s1(EnumC5882c.ShowUnknowCode, u1Var);
                } else if (b == EnumC5883d.NotShow) {
                    s1Var = new s1(EnumC5882c.ShowNoShowCode, u1Var);
                }
                z = false;
            } else {
                z = true;
            }
            if (z && a != EnumC5881b.DidContain) {
                if (a == EnumC5881b.Unknow) {
                    s1Var = new s1(EnumC5882c.InfoUnknowCode, u1Var);
                } else if (a == EnumC5881b.NotContain) {
                    s1Var = new s1(EnumC5882c.InfoNotContainCode, u1Var);
                }
                z = false;
            }
            if (z && f != EnumC5880a.DidAgree) {
                if (f == EnumC5880a.Unknow) {
                    s1Var = new s1(EnumC5882c.AgreeUnknowCode, u1Var);
                } else if (f == EnumC5880a.NotAgree) {
                    s1Var = new s1(EnumC5882c.AgreeNotAgreeCode, u1Var);
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
                    C5866o0.f().d(new ck() { // from class: com.loc.t.2
                        @Override // com.loc.ck
                        public final void a() {
                            if (z2) {
                                Iterator it = C5879t.m(C5879t.t(context)).iterator();
                                while (it.hasNext()) {
                                    C5879t.g(context, ((File) it.next()).getName());
                                }
                            }
                            C5879t.r(context);
                            C5879t.h(context, jSONObject, j2);
                            boolean p = C5879t.p(context, jSONObject);
                            if (p) {
                                C5879t.o(context, C5879t.l(j2));
                            }
                            if (z2) {
                                C5879t.n(context);
                            }
                            if (p) {
                                return;
                            }
                            C5879t.g(context, C5879t.l(j2));
                        }
                    });
                } catch (Throwable unused) {
                }
            } else if (m) {
                C5866o0.f().d(new ck() { // from class: com.loc.t.1
                    @Override // com.loc.ck
                    public final void a() {
                        Iterator it = C5879t.m(C5879t.t(context)).iterator();
                        while (it.hasNext()) {
                            C5879t.g(context, ((File) it.next()).getName());
                        }
                        C5879t.n(context);
                    }
                });
            }
            m = false;
            String j3 = C5846l.j(context);
            if (j3 == null || j3.length() <= 0) {
                s1Var = new s1(EnumC5882c.InvaildUserKeyCode, u1Var);
                Log.e(u1Var.a(), String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(s1Var.a.a()), s1Var.b));
            }
            if (z) {
                s1Var = new s1(EnumC5882c.SuccessCode, u1Var);
            } else {
                Log.e(u1Var.a(), String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", Integer.valueOf(s1Var.a.a()), s1Var.b));
            }
            return s1Var;
        }
    }

    private static synchronized void e(Context context, EnumC5880a enumC5880a, u1 u1Var) {
        synchronized (C5879t.class) {
            if (context == null || u1Var == null) {
                return;
            }
            if (!l) {
                s(context);
                l = true;
            }
            if (enumC5880a != f) {
                f = enumC5880a;
                h = u1Var.a();
                i = u1Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                g = currentTimeMillis;
                j = currentTimeMillis;
                r(context);
            }
        }
    }

    private static synchronized void f(Context context, EnumC5883d enumC5883d, EnumC5881b enumC5881b, u1 u1Var) {
        synchronized (C5879t.class) {
            if (context == null || u1Var == null) {
                return;
            }
            if (!l) {
                s(context);
                l = true;
            }
            Boolean bool = Boolean.FALSE;
            if (enumC5883d != b) {
                bool = Boolean.TRUE;
                b = enumC5883d;
            }
            if (enumC5881b != a) {
                bool = Boolean.TRUE;
                a = enumC5881b;
            }
            if (bool.booleanValue()) {
                c = u1Var.a();
                d = u1Var.e();
                long currentTimeMillis = System.currentTimeMillis();
                e = currentTimeMillis;
                j = currentTimeMillis;
                r(context);
            }
        }
    }

    static /* synthetic */ void g(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String t = t(context);
            File file = new File(t + "/" + str);
            if (file.exists()) {
                String u = u(context);
                File file2 = new File(u + "/" + str);
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                file.renameTo(file2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void h(Context context, JSONObject jSONObject, long j2) {
        byte[] m2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            m2 = b43.m(context, jSONObject.toString().getBytes());
            String l2 = l(j2);
            String t = t(context);
            File file = new File(t + "/" + l2);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(m2);
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

    public static void i(Context context, boolean z, u1 u1Var) {
        e(context, z ? EnumC5880a.DidAgree : EnumC5880a.NotAgree, u1Var);
    }

    public static void j(Context context, boolean z, boolean z2, u1 u1Var) {
        f(context, z2 ? EnumC5883d.DidShow : EnumC5883d.NotShow, z ? EnumC5881b.DidContain : EnumC5881b.NotContain, u1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(long j2) {
        return String.format("%d-%s", Long.valueOf(j2), "privacy.data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<File> m(String str) {
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

    static /* synthetic */ void n(Context context) {
        String[] split;
        try {
            Iterator<File> it = m(u(context)).iterator();
            while (it.hasNext()) {
                File next = it.next();
                String name = next.getName();
                if (name.endsWith("-privacy.data") && (((split = name.split("-")) != null || split.length == 2) && Long.parseLong(split[0]) > 0)) {
                    FileInputStream fileInputStream = new FileInputStream(next);
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    if (p(context, new JSONObject(new String(b43.q(context, bArr))))) {
                    }
                }
                next.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static /* synthetic */ void o(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            String t = t(context);
            File file = new File(t + "/" + str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(Context context, JSONObject jSONObject) {
        try {
            z33 z33Var = new z33();
            z33Var.m = context;
            z33Var.l = jSONObject;
            new bg();
            t43 c2 = bg.c(z33Var);
            if (c2 != null) {
                JSONObject jSONObject2 = new JSONObject(v1.g(c2.a));
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
    public static synchronized void r(Context context) {
        synchronized (C5879t.class) {
            if (context == null) {
                return;
            }
            if (!l) {
                s(context);
                l = true;
            }
            b43.d(context, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", Integer.valueOf(a.a()), Integer.valueOf(b.a()), Long.valueOf(e), c, d, Integer.valueOf(f.a()), Long.valueOf(g), h, i, Long.valueOf(j), Long.valueOf(k)));
        }
    }

    private static void s(Context context) {
        if (context == null) {
            return;
        }
        String str = null;
        try {
            str = b43.c(context, "AMap.privacy.data", "AMap.privacy.data");
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
            a = EnumC5881b.a(Integer.parseInt(split[0]));
            b = EnumC5883d.a(Integer.parseInt(split[1]));
            e = Long.parseLong(split[2]);
            d = split[3];
            d = split[4];
            f = EnumC5880a.a(Integer.parseInt(split[5]));
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
    public static String t(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Upload";
    }

    private static String u(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        return absolutePath + "/AMap/Privacy/Reload";
    }
}
