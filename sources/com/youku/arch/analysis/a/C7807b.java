package com.youku.arch.analysis.a;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ntk.dns.DnsEngine;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.analysis.a.b */
/* loaded from: classes11.dex */
public class C7807b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String a = "b";
    private C7806a b;
    private volatile HashMap<String, Object> c;
    private volatile HashMap<String, List<String>> d;
    private HashMap<String, Long> e;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.analysis.a.b$a */
    /* loaded from: classes11.dex */
    private static class C7808a {
        private static final C7807b a = new C7807b();
    }

    private C7807b() {
        this.b = new C7806a();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.e = new HashMap<>();
    }

    public static C7807b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1190285713") ? (C7807b) ipChange.ipc$dispatch("1190285713", new Object[0]) : C7808a.a;
    }

    public List<String> a(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030902804")) {
            return (List) ipChange.ipc$dispatch("1030902804", new Object[]{this, str, Integer.valueOf(i)});
        }
        String[] lookUp = DnsEngine.getInstance().lookUp(str);
        ArrayList arrayList = new ArrayList();
        if (lookUp != null) {
            for (String str2 : lookUp) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }
}
