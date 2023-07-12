package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.data.C7537a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bt;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.processor.b */
/* loaded from: classes11.dex */
public class C7549b implements IPerfProcessor {
    protected Context a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, C7537a>> f22a;

    public C7549b(Context context) {
        this.a = context;
    }

    public static String a(C7537a c7537a) {
        return String.valueOf(c7537a.production) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + c7537a.clientInterfaceId;
    }

    private String b(C7537a c7537a) {
        String str;
        int i = c7537a.production;
        String str2 = c7537a.clientInterfaceId;
        if (i <= 0 || TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = String.valueOf(i) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str2;
        }
        File externalFilesDir = this.a.getExternalFilesDir("perf");
        if (externalFilesDir == null) {
            AbstractC7535b.d("cannot get folder when to write perf");
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return new File(externalFilesDir, str).getAbsolutePath();
    }

    private String c(C7537a c7537a) {
        String b = b(c7537a);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b + i;
            if (bt.m708a(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC7550c
    public void a() {
        bt.a(this.a, "perf", "perfUploading");
        File[] m709a = bt.m709a(this.a, "perfUploading");
        if (m709a == null || m709a.length <= 0) {
            return;
        }
        for (File file : m709a) {
            if (file != null) {
                List<String> a = C7552e.a(this.a, file.getAbsolutePath());
                file.delete();
                a(a);
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC7551d
    /* renamed from: a */
    public void mo594a(C7537a c7537a) {
        if ((c7537a instanceof PerfClientReport) && this.f22a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) c7537a;
            String a = a((C7537a) perfClientReport);
            String a2 = C7552e.a(perfClientReport);
            HashMap<String, C7537a> hashMap = this.f22a.get(a);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a2);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a2, perfClientReport);
            this.f22a.put(a, hashMap);
        }
    }

    public void a(List<String> list) {
        bt.a(this.a, list);
    }

    public void a(C7537a[] c7537aArr) {
        String c = c(c7537aArr[0]);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        C7552e.a(c, c7537aArr);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC7551d
    public void b() {
        HashMap<String, HashMap<String, C7537a>> hashMap = this.f22a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f22a.keySet()) {
                HashMap<String, C7537a> hashMap2 = this.f22a.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    C7537a[] c7537aArr = new C7537a[hashMap2.size()];
                    hashMap2.values().toArray(c7537aArr);
                    a(c7537aArr);
                }
            }
        }
        this.f22a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, C7537a>> hashMap) {
        this.f22a = hashMap;
    }
}
