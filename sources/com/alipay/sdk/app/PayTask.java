package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.q.f;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.util.H5PayResultModel;
import com.youku.network.HttpIntent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PayTask {
    public static final Object h = h.class;
    public static long i;
    public Activity a;
    public com.alipay.sdk.m.x.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            e.d(com.alipay.sdk.m.l.a.z, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class b implements h.g {
        public b() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class c {
        public String a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    private h.g b() {
        return new b();
    }

    private String c(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] c2 = bVar.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        if (c2.length == 2) {
            bundle.putString(HttpIntent.COOKIE, c2[1]);
        }
        intent.putExtras(bundle);
        a.C0200a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.a(e);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String d = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(d) ? com.alipay.sdk.m.j.b.a() : d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        r0 = r6.c();
        r11 = com.alipay.sdk.m.j.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.m.u.n.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(com.alipay.sdk.m.s.a r10, com.alipay.sdk.m.r.b r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.d(com.alipay.sdk.m.s.a, com.alipay.sdk.m.r.b, java.lang.String):java.lang.String");
    }

    private String e(com.alipay.sdk.m.s.a aVar, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVar = null;
        try {
            try {
                JSONObject c2 = new f().a(aVar, this.a.getApplicationContext(), str).c();
                String optString = c2.optString("end_code", null);
                List<com.alipay.sdk.m.r.b> a2 = com.alipay.sdk.m.r.b.a(c2.optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    if (a2.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                        com.alipay.sdk.m.r.b.a(a2.get(i2));
                    }
                }
                j(aVar, c2);
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    com.alipay.sdk.m.r.b bVar = a2.get(i3);
                    if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                        String c3 = c(aVar, bVar);
                        dismissLoading();
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        return c3;
                    } else if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                        String d = d(aVar, bVar, optString);
                        dismissLoading();
                        com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                        return d;
                    }
                }
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            } catch (IOException e) {
                com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                com.alipay.sdk.m.k.a.a(aVar, "net", e);
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                cVar = b2;
            }
            if (cVar == null) {
                cVar = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            }
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        }
    }

    private synchronized String f(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        String g;
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String substring = str.substring(str.indexOf("payment_inst=") + 13);
            int indexOf = substring.indexOf(38);
            if (indexOf > 0) {
                substring = substring.substring(0, indexOf);
            }
            com.alipay.sdk.m.j.a.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            com.alipay.sdk.m.j.a.a("");
        }
        if (str.contains(com.alipay.sdk.m.l.a.v)) {
            com.alipay.sdk.m.l.a.w = true;
        }
        if (com.alipay.sdk.m.l.a.w) {
            if (str.startsWith(com.alipay.sdk.m.l.a.x)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.x) + 53);
            } else if (str.startsWith(com.alipay.sdk.m.l.a.y)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.l.a.y) + 52);
            }
        }
        e.d(com.alipay.sdk.m.l.a.z, "pay prepared: " + str);
        g = g(str, aVar);
        e.d(com.alipay.sdk.m.l.a.z, "pay raw result: " + g);
        i.a(aVar, this.a.getApplicationContext(), g);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.V, "" + SystemClock.elapsedRealtime());
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.W, l.a(g, l.a) + "|" + l.a(g, l.b));
        if (!com.alipay.sdk.m.m.a.D().s()) {
            com.alipay.sdk.m.m.a.D().a(aVar, this.a.getApplicationContext(), false, 3);
        }
        dismissLoading();
        com.alipay.sdk.m.k.a.b(this.a.getApplicationContext(), aVar, str, aVar.d);
        e.d(com.alipay.sdk.m.l.a.z, "pay returning: " + g);
        return g;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                com.alipay.sdk.m.s.b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < com.alipay.sdk.m.m.a.D().d()) {
                    return false;
                }
                i = elapsedRealtime;
                com.alipay.sdk.m.m.a.D().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
                return true;
            } catch (Exception e) {
                e.a(e);
                return false;
            }
        }
    }

    private String g(String str, com.alipay.sdk.m.s.a aVar) {
        com.alipay.sdk.m.j.c cVar;
        String a2 = aVar.a(str);
        if (a2.contains("paymethod=\"expressGateway\"")) {
            return e(aVar, a2);
        }
        List<a.b> l = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().h || l == null) {
            l = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, l, true)) {
            h hVar = new h(this.a, aVar, b());
            e.d(com.alipay.sdk.m.l.a.z, "pay inner started: " + a2);
            String a3 = hVar.a(a2, false);
            if (!TextUtils.isEmpty(a3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("resultStatus={");
                sb.append(com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT.b());
                sb.append("}");
                if (a3.contains(sb.toString())) {
                    n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, aVar);
                    if (com.alipay.sdk.m.m.a.D().A()) {
                        a3 = hVar.a(a2, true);
                    } else {
                        a3 = a3.replace("resultStatus={" + cVar.b() + "}", "resultStatus={" + com.alipay.sdk.m.j.c.CANCELED.b() + "}");
                    }
                }
            }
            e.d(com.alipay.sdk.m.l.a.z, "pay inner raw result: " + a3);
            hVar.a();
            boolean w = com.alipay.sdk.m.m.a.D().w();
            if (!TextUtils.equals(a3, "failed") && !TextUtils.equals(a3, h.k) && (!w || !aVar.e())) {
                if (TextUtils.isEmpty(a3)) {
                    return com.alipay.sdk.m.j.b.a();
                }
                if (a3.contains(PayResultActivity.b)) {
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
                    return a(aVar, a2, l, a3, this.a);
                }
                return a3;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return e(aVar, a2);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return e(aVar, a2);
    }

    private String h(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private String i(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(l.a));
        String str2 = map.get("result");
        c remove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = remove != null ? remove.a() : "";
        strArr[1] = remove != null ? remove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a2 = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.m.l.a.t, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.m.l.a.u, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        if (remove != null) {
            String b2 = equals ? remove.b() : remove.c();
            if (!TextUtils.isEmpty(b2)) {
                return b2;
            }
        }
        return remove != null ? com.alipay.sdk.m.m.a.D().r() : "";
    }

    private void j(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(optString, optString2);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th);
        }
    }

    private boolean k(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        } else if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        } else {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (trim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || trim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String trim2 = trim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.a));
                    return com.alipay.sdk.m.s.a.C + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String a2 = n.a("?", "", str);
                    if (!TextUtils.isEmpty(a2)) {
                        Map<String, String> b2 = n.b(a2);
                        StringBuilder sb = new StringBuilder();
                        if (k(false, true, com.alipay.sdk.m.k.b.B0, sb, b2, com.alipay.sdk.m.k.b.B0, "alipay_trade_no")) {
                            k(true, false, "pay_phase_id", sb, b2, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = b2.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(b2.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(b2.get("sid")) || !TextUtils.isEmpty(b2.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (k(true, true, "extern_token", sb, b2, "extern_token", "cid", "sid", "s_id")) {
                                k(true, false, "appenv", sb, b2, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                c cVar = new c(this, null);
                                cVar.b(b2.get("return_url"));
                                cVar.c(b2.get("show_url"));
                                cVar.a(b2.get("pay_order_id"));
                                String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                                this.g.put(str3, cVar);
                                return str3;
                            }
                            return "";
                        }
                    }
                }
                if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.m.m.a.D().h() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                        Uri parse = Uri.parse(trim);
                        String queryParameter = parse.getQueryParameter("return_url");
                        String queryParameter2 = parse.getQueryParameter("show_url");
                        String queryParameter3 = parse.getQueryParameter("pay_order_id");
                        String a3 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                        String a4 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = parse.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                        String a5 = a(strArr);
                        String a6 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        String a7 = a(parse.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a5) && !TextUtils.isEmpty(a6)) {
                            String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a3, a4, a5, a6, a7, a(this.a));
                            c cVar2 = new c(this, null);
                            cVar2.b(queryParameter);
                            cVar2.c(queryParameter2);
                            cVar2.a(queryParameter3);
                            cVar2.d(a3);
                            this.g.put(format, cVar2);
                            return format;
                        }
                    }
                }
                String a8 = a(this.a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", trim);
                jSONObject2.put("bizcontext", a8);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return i.a(new com.alipay.sdk.m.s.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.11";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        String[] split = f(aVar, str, z).split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            int indexOf = str2.indexOf("={");
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                hashMap.put(substring, h(str2, substring));
            }
        }
        if (hashMap.containsKey(l.a)) {
            h5PayResultModel.setResultCode(hashMap.get(l.a));
        }
        h5PayResultModel.setReturnUrl(i(str, hashMap));
        if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return f(new com.alipay.sdk.m.s.a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            e.d(com.alipay.sdk.m.l.a.z, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String f;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            aVar = null;
            f = com.alipay.sdk.m.j.b.b();
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.a, str, "payV2");
            f = f(aVar2, str, z);
            aVar = aVar2;
        }
        return l.a(aVar, f);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: all -> 0x005b, TryCatch #2 {all -> 0x005b, blocks: (B:11:0x001e, B:13:0x0044, B:15:0x0051, B:16:0x0056), top: B:25:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            java.lang.String r0 = "sc"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L18
            r3 = 0
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r3)     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = r6.versionName     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.packageName     // Catch: java.lang.Exception -> L16
            goto L1e
        L16:
            r6 = move-exception
            goto L1a
        L18:
            r6 = move-exception
            r2 = r1
        L1a:
            com.alipay.sdk.m.u.e.a(r6)
            r6 = r1
        L1e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "appkey"
            java.lang.String r5 = "2014052600006128"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "ty"
            java.lang.String r5 = "and_lite"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "sv"
            java.lang.String r5 = "h.a.3.8.11"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "an"
            r3.put(r4, r6)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "av"
            r3.put(r6, r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "sdk_start_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5b
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L5b
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5b
            if (r6 != 0) goto L56
            java.lang.String r6 = "h5tonative"
            r3.put(r0, r6)     // Catch: java.lang.Throwable -> L5b
        L56:
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L5b
            return r6
        L5b:
            r6 = move-exception
            com.alipay.sdk.m.u.e.a(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(android.content.Context):java.lang.String");
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(com.alipay.sdk.m.s.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        n.c a2 = n.a(aVar, activity, list);
        if (a2 == null || a2.a(aVar) || a2.a() || !TextUtils.equals(a2.a.packageName, PayResultActivity.d)) {
            return str2;
        }
        e.b(com.alipay.sdk.m.l.a.z, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.c;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, valueOf);
        a.C0200a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                e.b(com.alipay.sdk.m.l.a.z, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                e.b(com.alipay.sdk.m.l.a.z, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        e.b(com.alipay.sdk.m.l.a.z, "PayTask ret: " + str3);
        return str3;
    }
}
