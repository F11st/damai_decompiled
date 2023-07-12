package com.youku.arch.ntk.interfere;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.analysis.a.C7806a;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.C7829c;
import com.youku.arch.ntk.a.C7830d;
import com.youku.arch.ntk.a.C7833g;
import com.youku.arch.ntk.a.C7836j;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.d01;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.interfere.g */
/* loaded from: classes2.dex */
public class C7868g {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.g$a */
    /* loaded from: classes2.dex */
    public class C7869a {
        private static transient /* synthetic */ IpChange $ipChange;
        public int a;
        public int b;
        public int c;
        public int d;
        public String e;
        public int f;
        public List<C7872d> g;

        public C7869a(int i, int i2, int i3, String str, int i4, List<C7872d> list) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = str;
            this.f = i4;
            this.g = list;
        }

        public C7870b a() {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1688075600")) {
                return (C7870b) ipChange.ipc$dispatch("1688075600", new Object[]{this});
            }
            C7870b c7870b = new C7870b();
            c7870b.a = this.e;
            c7870b.b = this.b;
            int i = this.a;
            if (i == 2) {
                c7870b.b = 3;
            } else if (i == 3) {
                c7870b.b = 4;
            } else if (i == 4) {
                c7870b.b = 2;
            }
            if (i > 0) {
                if (this.g != null) {
                    StringBuilder sb = new StringBuilder();
                    for (C7872d c7872d : this.g) {
                        sb.append("ip:");
                        sb.append(c7872d.b);
                        sb.append(",");
                        sb.append("dnsType:");
                        sb.append(c7872d.c);
                        sb.append(",");
                        sb.append("errorCode:");
                        sb.append(c7872d.d);
                        sb.append(";");
                    }
                    str = sb.toString();
                } else {
                    str = null;
                }
                c7870b.c = str;
            }
            return c7870b;
        }

        public void a(C7869a c7869a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1480645477")) {
                ipChange.ipc$dispatch("-1480645477", new Object[]{this, c7869a});
                return;
            }
            this.a = c7869a.a;
            this.b = c7869a.b;
            this.c = c7869a.c;
            this.e = c7869a.e;
            this.f = c7869a.f;
            this.g = c7869a.g;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.g$b */
    /* loaded from: classes2.dex */
    public class C7870b {
        public String a;
        public int b;
        public String c;

        public C7870b() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.g$c */
    /* loaded from: classes2.dex */
    private static class C7871c {
        private static final C7868g a = new C7868g();
    }

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.interfere.g$d */
    /* loaded from: classes2.dex */
    public class C7872d {
        public String a;
        public String b;
        public int c;
        public int d;

        public C7872d() {
        }
    }

    private C7868g() {
    }

    private C7869a a(C7869a c7869a, C7869a c7869a2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234735746")) {
            return (C7869a) ipChange.ipc$dispatch("-1234735746", new Object[]{this, c7869a, c7869a2});
        }
        if (c7869a2 != null) {
            if (c7869a != null && c7869a.g.size() > 0) {
                c7869a2.g.addAll(c7869a.g);
            }
            return c7869a2;
        }
        return c7869a;
    }

    private C7869a a(String str, String[] strArr, int i, int i2) {
        String str2;
        int i3;
        int i4;
        int i5;
        C7830d[] c7830dArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218727495")) {
            return (C7869a) ipChange.ipc$dispatch("-218727495", new Object[]{this, str, strArr, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        C7833g c7833g = new C7833g();
        int[] iArr = new int[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6].contains(".")) {
                iArr[i6] = 0;
            } else {
                iArr[i6] = 1;
            }
        }
        NtkWrapper.a().inspect_ext_resolve(c7833g, str, strArr, iArr, i > 5000 ? 5000 : i);
        String str3 = null;
        ArrayList arrayList = new ArrayList();
        C7836j[] c7836jArr = c7833g.b;
        if (c7836jArr.length > 0) {
            i3 = 0;
            for (C7830d c7830d : c7836jArr[0].a) {
                C7872d c7872d = new C7872d();
                c7872d.a = str;
                c7872d.b = c7830d.a;
                c7872d.c = i2;
                c7872d.d = Integer.parseInt(c7830d.b);
                arrayList.add(c7872d);
                String str4 = c7830d.b;
                if (Integer.parseInt(str4) > 0) {
                    str3 = c7830d.a;
                } else {
                    i3 = Integer.parseInt(str4);
                }
            }
            str2 = str3;
        } else {
            str2 = null;
            i3 = 0;
        }
        if (str2 != null) {
            i4 = 0;
            i5 = 0;
        } else {
            i4 = 1;
            i5 = 1;
        }
        return new C7869a(i4, i5, i3, str2, i2, arrayList);
    }

    public static C7868g a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005483311") ? (C7868g) ipChange.ipc$dispatch("-2005483311", new Object[0]) : C7871c.a;
    }

    private List<String> a(C7836j c7836j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "943730088")) {
            return (List) ipChange.ipc$dispatch("943730088", new Object[]{this, c7836j});
        }
        ArrayList arrayList = new ArrayList();
        if (c7836j != null && c7836j.a != null) {
            while (true) {
                C7830d[] c7830dArr = c7836j.a;
                if (i >= c7830dArr.length) {
                    break;
                }
                if (C7806a.a(c7830dArr[i].a)) {
                    arrayList.add(c7836j.a[i].a);
                }
                i++;
            }
        }
        return arrayList;
    }

    private List<String> a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317021696")) {
            return (List) ipChange.ipc$dispatch("-317021696", new Object[]{this, str});
        }
        ArrayList arrayList = new ArrayList();
        C7833g c7833g = new C7833g();
        NtkWrapper.a().inspect_dns(c7833g, str, 3000);
        C7829c[] c7829cArr = c7833g.a;
        if (c7829cArr != null) {
            for (C7829c c7829c : c7829cArr) {
                if (C7806a.a(c7829c.a)) {
                    arrayList.add(c7829c.a);
                }
            }
        }
        return arrayList;
    }

    private List<String> b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12744065")) {
            return (List) ipChange.ipc$dispatch("12744065", new Object[]{this, str});
        }
        ArrayList<d01.C9027a> a = d01.a(str);
        ArrayList arrayList = new ArrayList();
        if (a != null) {
            Iterator<d01.C9027a> it = a.iterator();
            while (it.hasNext()) {
                d01.C9027a next = it.next();
                if (next.c() == 80) {
                    String b = next.b();
                    if (!TextUtils.isEmpty(b) && !arrayList.contains(b)) {
                        arrayList.add(next.b());
                    }
                }
            }
        }
        return arrayList;
    }

    private List<String> c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "342509826")) {
            return (List) ipChange.ipc$dispatch("342509826", new Object[]{this, str});
        }
        C7833g c7833g = new C7833g();
        NtkWrapper.a().inspect_resolve(c7833g, str, new String[]{"223.5.5.5"}, new int[]{4}, 0);
        ArrayList arrayList = new ArrayList();
        if (c7833g.b.length > 1) {
            int i = 0;
            while (true) {
                C7836j[] c7836jArr = c7833g.b;
                if (i >= c7836jArr.length) {
                    break;
                }
                arrayList.addAll(a(c7836jArr[i]));
                i++;
            }
            return arrayList.size() > 5 ? arrayList.subList(0, 5) : arrayList;
        }
        return arrayList;
    }

    private boolean d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535640904")) {
            return ((Boolean) ipChange.ipc$dispatch("1535640904", new Object[]{this, str})).booleanValue();
        }
        try {
            boolean z = InetAddress.getByName(str) instanceof Inet6Address;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public C7869a a(final String str, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316574603")) {
            return (C7869a) ipChange.ipc$dispatch("-316574603", new Object[]{this, str, Integer.valueOf(i)});
        }
        final C7869a c7869a = new C7869a(4, 0, 0, null, 0, null);
        c7869a.d = 0;
        if (Integer.parseInt(ApasServiceManager.getInstance().getConfig("speed_test", "enable_ups_error_detect", "1")) <= 0) {
            c7869a.a = 2;
            return c7869a;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.youku.arch.ntk.interfere.NtkNetworkDetector$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "879133654")) {
                    ipChange2.ipc$dispatch("879133654", new Object[]{this});
                } else {
                    C7868g.this.a(str, i, c7869a);
                }
            }
        });
        thread.start();
        try {
            thread.join(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c7869a;
    }

    public void a(String str, int i, C7869a c7869a) {
        String str2 = "";
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799708631")) {
            ipChange.ipc$dispatch("799708631", new Object[]{this, str, Integer.valueOf(i), c7869a});
            return;
        }
        try {
            str2 = new URL(str).getHost();
            str = "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            if (!d(str)) {
                str = "";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            c7869a.a(a(str2, new String[]{str}, i, 0));
        } else if (TextUtils.isEmpty(str2)) {
            c7869a.a = 3;
        } else {
            c7869a.d = 1;
            List<String> b = b(str2);
            C7869a c7869a2 = null;
            if (b.size() > 0) {
                c7869a.d = 2;
                c7869a2 = a(str2, (String[]) b.toArray(new String[0]), i, 1);
                c7869a.a(c7869a2);
                if (c7869a2 != null && c7869a2.a == 0) {
                    return;
                }
            }
            c7869a.d = 3;
            List<String> c = c(str2);
            if (c.size() > 0) {
                c7869a.d = 4;
                c7869a2 = a(c7869a2, a(str2, (String[]) c.toArray(new String[0]), i, 2));
                c7869a.a(c7869a2);
                if (c7869a2 != null && c7869a2.a == 0) {
                    return;
                }
            }
            c7869a.d = 5;
            List<String> a = a(str2);
            if (a.size() > 0) {
                c7869a.d = 6;
                c7869a.a(a(c7869a2, a(str2, (String[]) a.toArray(new String[0]), i, 3)));
                return;
            }
            c7869a.a = 1;
            c7869a.b = 1;
        }
    }
}
