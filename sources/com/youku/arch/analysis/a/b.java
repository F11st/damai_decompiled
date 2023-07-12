package com.youku.arch.analysis.a;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ntk.dns.DnsEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String a = "b";
    private com.youku.arch.analysis.a.a b;
    private volatile HashMap<String, Object> c;
    private volatile HashMap<String, List<String>> d;
    private HashMap<String, Long> e;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class a {
        private static final b a = new b();
    }

    private b() {
        this.b = new com.youku.arch.analysis.a.a();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.e = new HashMap<>();
    }

    public static b a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1190285713") ? (b) ipChange.ipc$dispatch("1190285713", new Object[0]) : a.a;
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
