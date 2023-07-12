package com.xiaomi.push;

import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.weex.annotation.JSMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cr {

    /* renamed from: a  reason: collision with other field name */
    private long f172a;

    /* renamed from: a  reason: collision with other field name */
    public String f173a;

    /* renamed from: b  reason: collision with other field name */
    public String f175b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private String i;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<da> f174a = new ArrayList<>();
    private double a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cr(String str) {
        this.f173a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f172a = System.currentTimeMillis();
        this.f174a.add(new da(str, -1));
        this.f173a = cv.m750a();
        this.f175b = str;
    }

    private synchronized void c(String str) {
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f191a, str)) {
                it.remove();
            }
        }
    }

    public synchronized cr a(JSONObject jSONObject) {
        this.f173a = jSONObject.optString("net");
        this.b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.a = jSONObject.getDouble("pct");
        this.f172a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString(IRequestConst.ISP);
        this.f = jSONObject.optString(TbAuthConstants.IP);
        this.f175b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new da().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            String a = bp.a(new String[]{this.e, this.c, this.d, this.g, this.f}, JSMethod.NOT_SET);
            this.i = a;
            return a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m741a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f175b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = a(true).iterator();
            while (it.hasNext()) {
                ct a = ct.a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.m749a(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f174a.size();
        da[] daVarArr = new da[size];
        this.f174a.toArray(daVarArr);
        Arrays.sort(daVarArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            da daVar = daVarArr[i];
            if (z) {
                substring = daVar.f191a;
            } else {
                int indexOf = daVar.f191a.indexOf(":");
                substring = indexOf != -1 ? daVar.f191a.substring(0, indexOf) : daVar.f191a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m742a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f173a);
        jSONObject.put(RemoteMessageConst.TTL, this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f172a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put(IRequestConst.ISP, this.e);
        jSONObject.put(TbAuthConstants.IP, this.f);
        jSONObject.put("host", this.f175b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d) {
        this.a = d;
    }

    public void a(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(da daVar) {
        c(daVar.f191a);
        this.f174a.add(daVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m743a(String str) {
        a(new da(str));
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cq(i, j, j2, exc));
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r4, com.xiaomi.push.cq r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.da> r0 = r3.f174a     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.da r1 = (com.xiaomi.push.da) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f191a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cr.a(java.lang.String, com.xiaomi.push.cq):void");
    }

    public synchronized void a(String[] strArr) {
        int i;
        int size = this.f174a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f174a.get(size).f191a, strArr[i])) {
                        this.f174a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<da> it = this.f174a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = it.next().a;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        while (i < strArr.length) {
            a(new da(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m744a() {
        return TextUtils.equals(this.f173a, cv.m750a());
    }

    public boolean a(cr crVar) {
        return TextUtils.equals(this.f173a, crVar.f173a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f172a < this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f172a;
        return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.b && this.f173a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f173a);
        sb.append(StringUtils.LF);
        sb.append(a());
        Iterator<da> it = this.f174a.iterator();
        while (it.hasNext()) {
            sb.append(StringUtils.LF);
            sb.append(it.next().toString());
        }
        sb.append(StringUtils.LF);
        return sb.toString();
    }
}
