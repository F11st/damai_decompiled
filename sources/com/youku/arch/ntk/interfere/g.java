package com.youku.arch.ntk.interfere;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.apas.remote.ApasServiceManager;
import com.youku.arch.ntk.NtkWrapper;
import com.youku.arch.ntk.a.j;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.d01;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class g {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class a {
        private static transient /* synthetic */ IpChange $ipChange;
        public int a;
        public int b;
        public int c;
        public int d;
        public String e;
        public int f;
        public List<d> g;

        public a(int i, int i2, int i3, String str, int i4, List<d> list) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.e = str;
            this.f = i4;
            this.g = list;
        }

        public b a() {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1688075600")) {
                return (b) ipChange.ipc$dispatch("1688075600", new Object[]{this});
            }
            b bVar = new b();
            bVar.a = this.e;
            bVar.b = this.b;
            int i = this.a;
            if (i == 2) {
                bVar.b = 3;
            } else if (i == 3) {
                bVar.b = 4;
            } else if (i == 4) {
                bVar.b = 2;
            }
            if (i > 0) {
                if (this.g != null) {
                    StringBuilder sb = new StringBuilder();
                    for (d dVar : this.g) {
                        sb.append("ip:");
                        sb.append(dVar.b);
                        sb.append(",");
                        sb.append("dnsType:");
                        sb.append(dVar.c);
                        sb.append(",");
                        sb.append("errorCode:");
                        sb.append(dVar.d);
                        sb.append(";");
                    }
                    str = sb.toString();
                } else {
                    str = null;
                }
                bVar.c = str;
            }
            return bVar;
        }

        public void a(a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1480645477")) {
                ipChange.ipc$dispatch("-1480645477", new Object[]{this, aVar});
                return;
            }
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class b {
        public String a;
        public int b;
        public String c;

        public b() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class c {
        private static final g a = new g();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class d {
        public String a;
        public String b;
        public int c;
        public int d;

        public d() {
        }
    }

    private g() {
    }

    private a a(a aVar, a aVar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234735746")) {
            return (a) ipChange.ipc$dispatch("-1234735746", new Object[]{this, aVar, aVar2});
        }
        if (aVar2 != null) {
            if (aVar != null && aVar.g.size() > 0) {
                aVar2.g.addAll(aVar.g);
            }
            return aVar2;
        }
        return aVar;
    }

    private a a(String str, String[] strArr, int i, int i2) {
        String str2;
        int i3;
        int i4;
        int i5;
        com.youku.arch.ntk.a.d[] dVarArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218727495")) {
            return (a) ipChange.ipc$dispatch("-218727495", new Object[]{this, str, strArr, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        com.youku.arch.ntk.a.g gVar = new com.youku.arch.ntk.a.g();
        int[] iArr = new int[strArr.length];
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6].contains(".")) {
                iArr[i6] = 0;
            } else {
                iArr[i6] = 1;
            }
        }
        NtkWrapper.a().inspect_ext_resolve(gVar, str, strArr, iArr, i > 5000 ? 5000 : i);
        String str3 = null;
        ArrayList arrayList = new ArrayList();
        j[] jVarArr = gVar.b;
        if (jVarArr.length > 0) {
            i3 = 0;
            for (com.youku.arch.ntk.a.d dVar : jVarArr[0].a) {
                d dVar2 = new d();
                dVar2.a = str;
                dVar2.b = dVar.a;
                dVar2.c = i2;
                dVar2.d = Integer.parseInt(dVar.b);
                arrayList.add(dVar2);
                String str4 = dVar.b;
                if (Integer.parseInt(str4) > 0) {
                    str3 = dVar.a;
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
        return new a(i4, i5, i3, str2, i2, arrayList);
    }

    public static g a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005483311") ? (g) ipChange.ipc$dispatch("-2005483311", new Object[0]) : c.a;
    }

    private List<String> a(j jVar) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "943730088")) {
            return (List) ipChange.ipc$dispatch("943730088", new Object[]{this, jVar});
        }
        ArrayList arrayList = new ArrayList();
        if (jVar != null && jVar.a != null) {
            while (true) {
                com.youku.arch.ntk.a.d[] dVarArr = jVar.a;
                if (i >= dVarArr.length) {
                    break;
                }
                if (com.youku.arch.analysis.a.a.a(dVarArr[i].a)) {
                    arrayList.add(jVar.a[i].a);
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
        com.youku.arch.ntk.a.g gVar = new com.youku.arch.ntk.a.g();
        NtkWrapper.a().inspect_dns(gVar, str, 3000);
        com.youku.arch.ntk.a.c[] cVarArr = gVar.a;
        if (cVarArr != null) {
            for (com.youku.arch.ntk.a.c cVar : cVarArr) {
                if (com.youku.arch.analysis.a.a.a(cVar.a)) {
                    arrayList.add(cVar.a);
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
        ArrayList<d01.a> a2 = d01.a(str);
        ArrayList arrayList = new ArrayList();
        if (a2 != null) {
            Iterator<d01.a> it = a2.iterator();
            while (it.hasNext()) {
                d01.a next = it.next();
                if (next.c() == 80) {
                    String b2 = next.b();
                    if (!TextUtils.isEmpty(b2) && !arrayList.contains(b2)) {
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
        com.youku.arch.ntk.a.g gVar = new com.youku.arch.ntk.a.g();
        NtkWrapper.a().inspect_resolve(gVar, str, new String[]{"223.5.5.5"}, new int[]{4}, 0);
        ArrayList arrayList = new ArrayList();
        if (gVar.b.length > 1) {
            int i = 0;
            while (true) {
                j[] jVarArr = gVar.b;
                if (i >= jVarArr.length) {
                    break;
                }
                arrayList.addAll(a(jVarArr[i]));
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

    public a a(final String str, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316574603")) {
            return (a) ipChange.ipc$dispatch("-316574603", new Object[]{this, str, Integer.valueOf(i)});
        }
        final a aVar = new a(4, 0, 0, null, 0, null);
        aVar.d = 0;
        if (Integer.parseInt(ApasServiceManager.getInstance().getConfig("speed_test", "enable_ups_error_detect", "1")) <= 0) {
            aVar.a = 2;
            return aVar;
        }
        Thread thread = new Thread(new Runnable() { // from class: com.youku.arch.ntk.interfere.NtkNetworkDetector$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "879133654")) {
                    ipChange2.ipc$dispatch("879133654", new Object[]{this});
                } else {
                    g.this.a(str, i, aVar);
                }
            }
        });
        thread.start();
        try {
            thread.join(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return aVar;
    }

    public void a(String str, int i, a aVar) {
        String str2 = "";
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "799708631")) {
            ipChange.ipc$dispatch("799708631", new Object[]{this, str, Integer.valueOf(i), aVar});
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
            aVar.a(a(str2, new String[]{str}, i, 0));
        } else if (TextUtils.isEmpty(str2)) {
            aVar.a = 3;
        } else {
            aVar.d = 1;
            List<String> b2 = b(str2);
            a aVar2 = null;
            if (b2.size() > 0) {
                aVar.d = 2;
                aVar2 = a(str2, (String[]) b2.toArray(new String[0]), i, 1);
                aVar.a(aVar2);
                if (aVar2 != null && aVar2.a == 0) {
                    return;
                }
            }
            aVar.d = 3;
            List<String> c2 = c(str2);
            if (c2.size() > 0) {
                aVar.d = 4;
                aVar2 = a(aVar2, a(str2, (String[]) c2.toArray(new String[0]), i, 2));
                aVar.a(aVar2);
                if (aVar2 != null && aVar2.a == 0) {
                    return;
                }
            }
            aVar.d = 5;
            List<String> a2 = a(str2);
            if (a2.size() > 0) {
                aVar.d = 6;
                aVar.a(a(aVar2, a(str2, (String[]) a2.toArray(new String[0]), i, 3)));
                return;
            }
            aVar.a = 1;
            aVar.b = 1;
        }
    }
}
