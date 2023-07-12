package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.j.C4211a;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.j.EnumC4213c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.l.C4231b;
import com.alipay.sdk.m.l.C4232c;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.q.C4283f;
import com.alipay.sdk.m.r.C4288b;
import com.alipay.sdk.m.r.EnumC4287a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.t.C4296a;
import com.alipay.sdk.m.u.C4299b;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4305h;
import com.alipay.sdk.m.u.C4313i;
import com.alipay.sdk.m.u.C4316l;
import com.alipay.sdk.m.u.C4318n;
import com.alipay.sdk.m.x.C4337a;
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
    public static final Object h = C4305h.class;
    public static long i;
    public Activity a;
    public C4337a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, C4130c> g = new HashMap();

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.PayTask$a */
    /* loaded from: classes12.dex */
    public class RunnableC4128a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public RunnableC4128a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5Pay = PayTask.this.h5Pay(new C4293a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            C4302e.d(C4230a.z, "inc finished: " + h5Pay.getResultCode());
            this.c.onPayResult(h5Pay);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.PayTask$b */
    /* loaded from: classes10.dex */
    public class C4129b implements C4305h.InterfaceC4312g {
        public C4129b() {
        }

        @Override // com.alipay.sdk.m.u.C4305h.InterfaceC4312g
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.C4305h.InterfaceC4312g
        public void b() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.app.PayTask$c */
    /* loaded from: classes12.dex */
    public class C4130c {
        public String a;
        public String b;
        public String c;
        public String d;

        public C4130c() {
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

        public /* synthetic */ C4130c(PayTask payTask, RunnableC4128a runnableC4128a) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        C4295b.d().a(this.a);
        this.b = new C4337a(activity, C4337a.j);
    }

    private C4305h.InterfaceC4312g b() {
        return new C4129b();
    }

    private String c(C4293a c4293a, C4288b c4288b) {
        String[] c = c4288b.c();
        Intent intent = new Intent(this.a, H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", c[0]);
        if (c.length == 2) {
            bundle.putString(HttpIntent.COOKIE, c[1]);
        }
        intent.putExtras(bundle);
        C4293a.C4294a.a(c4293a, intent);
        this.a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                C4302e.a(e);
                return C4212b.a();
            }
        }
        String d = C4212b.d();
        return TextUtils.isEmpty(d) ? C4212b.a() : d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        r0 = r6.c();
        r11 = com.alipay.sdk.m.j.C4212b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.m.u.C4318n.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(com.alipay.sdk.m.s.C4293a r10, com.alipay.sdk.m.r.C4288b r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.d(com.alipay.sdk.m.s.a, com.alipay.sdk.m.r.b, java.lang.String):java.lang.String");
    }

    private String e(C4293a c4293a, String str) {
        showLoading();
        EnumC4213c enumC4213c = null;
        try {
            try {
                JSONObject c = new C4283f().a(c4293a, this.a.getApplicationContext(), str).c();
                String optString = c.optString("end_code", null);
                List<C4288b> a = C4288b.a(c.optJSONObject(C4232c.c).optJSONObject(C4232c.d));
                for (int i2 = 0; i2 < a.size(); i2++) {
                    if (a.get(i2).a() == EnumC4287a.Update) {
                        C4288b.a(a.get(i2));
                    }
                }
                j(c4293a, c);
                dismissLoading();
                C4218a.a(this.a, c4293a, str, c4293a.d);
                for (int i3 = 0; i3 < a.size(); i3++) {
                    C4288b c4288b = a.get(i3);
                    if (c4288b.a() == EnumC4287a.WapPay) {
                        String c2 = c(c4293a, c4288b);
                        dismissLoading();
                        C4218a.a(this.a, c4293a, str, c4293a.d);
                        return c2;
                    } else if (c4288b.a() == EnumC4287a.OpenWeb) {
                        String d = d(c4293a, c4288b, optString);
                        dismissLoading();
                        C4218a.a(this.a, c4293a, str, c4293a.d);
                        return d;
                    }
                }
                dismissLoading();
                C4218a.a(this.a, c4293a, str, c4293a.d);
            } catch (IOException e) {
                EnumC4213c b = EnumC4213c.b(EnumC4213c.NETWORK_ERROR.b());
                C4218a.a(c4293a, "net", e);
                dismissLoading();
                C4218a.a(this.a, c4293a, str, c4293a.d);
                enumC4213c = b;
            }
            if (enumC4213c == null) {
                enumC4213c = EnumC4213c.b(EnumC4213c.FAILED.b());
            }
            return C4212b.a(enumC4213c.b(), enumC4213c.a(), "");
        }
    }

    private synchronized String f(C4293a c4293a, String str, boolean z) {
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
            C4211a.a(substring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            C4211a.a("");
        }
        if (str.contains(C4230a.v)) {
            C4230a.w = true;
        }
        if (C4230a.w) {
            if (str.startsWith(C4230a.x)) {
                str = str.substring(str.indexOf(C4230a.x) + 53);
            } else if (str.startsWith(C4230a.y)) {
                str = str.substring(str.indexOf(C4230a.y) + 52);
            }
        }
        C4302e.d(C4230a.z, "pay prepared: " + str);
        g = g(str, c4293a);
        C4302e.d(C4230a.z, "pay raw result: " + g);
        C4313i.a(c4293a, this.a.getApplicationContext(), g);
        C4218a.a(c4293a, C4226b.l, C4226b.V, "" + SystemClock.elapsedRealtime());
        C4218a.a(c4293a, C4226b.l, C4226b.W, C4316l.a(g, C4316l.a) + "|" + C4316l.a(g, C4316l.b));
        if (!C4245a.D().s()) {
            C4245a.D().a(c4293a, this.a.getApplicationContext(), false, 3);
        }
        dismissLoading();
        C4218a.b(this.a.getApplicationContext(), c4293a, str, c4293a.d);
        C4302e.d(C4230a.z, "pay returning: " + g);
        return g;
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                C4295b.d().a(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - i < C4245a.D().d()) {
                    return false;
                }
                i = elapsedRealtime;
                C4245a.D().a(C4293a.h(), context.getApplicationContext(), false, 4);
                return true;
            } catch (Exception e) {
                C4302e.a(e);
                return false;
            }
        }
    }

    private String g(String str, C4293a c4293a) {
        EnumC4213c enumC4213c;
        String a = c4293a.a(str);
        if (a.contains("paymethod=\"expressGateway\"")) {
            return e(c4293a, a);
        }
        List<C4245a.C4247b> l = C4245a.D().l();
        if (!C4245a.D().h || l == null) {
            l = C4211a.d;
        }
        if (C4318n.a(c4293a, (Context) this.a, l, true)) {
            C4305h c4305h = new C4305h(this.a, c4293a, b());
            C4302e.d(C4230a.z, "pay inner started: " + a);
            String a2 = c4305h.a(a, false);
            if (!TextUtils.isEmpty(a2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("resultStatus={");
                sb.append(EnumC4213c.ACTIVITY_NOT_START_EXIT.b());
                sb.append("}");
                if (a2.contains(sb.toString())) {
                    C4318n.a("alipaySdk", C4231b.q, this.a, c4293a);
                    if (C4245a.D().A()) {
                        a2 = c4305h.a(a, true);
                    } else {
                        a2 = a2.replace("resultStatus={" + enumC4213c.b() + "}", "resultStatus={" + EnumC4213c.CANCELED.b() + "}");
                    }
                }
            }
            C4302e.d(C4230a.z, "pay inner raw result: " + a2);
            c4305h.a();
            boolean w = C4245a.D().w();
            if (!TextUtils.equals(a2, "failed") && !TextUtils.equals(a2, C4305h.k) && (!w || !c4293a.e())) {
                if (TextUtils.isEmpty(a2)) {
                    return C4212b.a();
                }
                if (a2.contains(PayResultActivity.b)) {
                    C4218a.a(c4293a, C4226b.l, C4226b.k0);
                    return a(c4293a, a, l, a2, this.a);
                }
                return a2;
            }
            C4218a.a(c4293a, C4226b.l, C4226b.i0);
            return e(c4293a, a);
        }
        C4218a.a(c4293a, C4226b.l, C4226b.j0);
        return e(c4293a, a);
    }

    private String h(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    private String i(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(C4316l.a));
        String str2 = map.get("result");
        C4130c remove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = remove != null ? remove.a() : "";
        strArr[1] = remove != null ? remove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a = a(C4318n.a("&callBackUrl=\"", "\"", str2), C4318n.a("&call_back_url=\"", "\"", str2), C4318n.a(C4230a.t, "\"", str2), URLDecoder.decode(C4318n.a(C4230a.u, "&", str2), "utf-8"), URLDecoder.decode(C4318n.a("&callBackUrl=", "&", str2), "utf-8"), C4318n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
        }
        if (remove != null) {
            String b = equals ? remove.b() : remove.c();
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
        }
        return remove != null ? C4245a.D().r() : "";
    }

    private void j(C4293a c4293a, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(C4296a.j);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            C4296a.a(C4295b.d().b()).a(optString, optString2);
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, C4226b.P, th);
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
        C4337a c4337a = this.b;
        if (c4337a != null) {
            c4337a.a();
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
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + C4318n.a("<request_token>", "</request_token>", C4318n.b(trim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (trim.startsWith("https://mclient.alipay.com/service/rest.htm") || trim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String trim3 = trim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(trim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + C4318n.a("<request_token>", "</request_token>", C4318n.b(trim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((trim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || trim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((trim.contains("alipay.wap.create.direct.pay.by.user") || trim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(trim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.a));
                    return C4293a.C + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String a = C4318n.a("?", "", str);
                    if (!TextUtils.isEmpty(a)) {
                        Map<String, String> b = C4318n.b(a);
                        StringBuilder sb = new StringBuilder();
                        if (k(false, true, C4226b.B0, sb, b, C4226b.B0, "alipay_trade_no")) {
                            k(true, false, "pay_phase_id", sb, b, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = b.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(b.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(b.get("sid")) || !TextUtils.isEmpty(b.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (k(true, true, "extern_token", sb, b, "extern_token", "cid", "sid", "s_id")) {
                                k(true, false, "appenv", sb, b, "appenv");
                                sb.append("&pay_channel_id=\"alipay_sdk\"");
                                C4130c c4130c = new C4130c(this, null);
                                c4130c.b(b.get("return_url"));
                                c4130c.c(b.get("show_url"));
                                c4130c.a(b.get("pay_order_id"));
                                String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                                this.g.put(str3, c4130c);
                                return str3;
                            }
                            return "";
                        }
                    }
                }
                if (!trim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !trim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !trim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (C4245a.D().h() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(trim).find()) {
                        Uri parse = Uri.parse(trim);
                        String queryParameter = parse.getQueryParameter("return_url");
                        String queryParameter2 = parse.getQueryParameter("show_url");
                        String queryParameter3 = parse.getQueryParameter("pay_order_id");
                        String a2 = a(parse.getQueryParameter("trade_nos"), parse.getQueryParameter("alipay_trade_no"));
                        String a3 = a(parse.getQueryParameter("payPhaseId"), parse.getQueryParameter("pay_phase_id"), parse.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = parse.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(parse.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(parse.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(parse.getQueryParameter("s_id")) ? "tb" : "";
                        String a4 = a(strArr);
                        String a5 = a(parse.getQueryParameter("extern_token"), parse.getQueryParameter("cid"), parse.getQueryParameter("sid"), parse.getQueryParameter("s_id"));
                        String a6 = a(parse.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5)) {
                            String format = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", a2, a3, a4, a5, a6, a(this.a));
                            C4130c c4130c2 = new C4130c(this, null);
                            c4130c2.b(queryParameter);
                            c4130c2.c(queryParameter2);
                            c4130c2.a(queryParameter3);
                            c4130c2.d(a2);
                            this.g.put(format, c4130c2);
                            return format;
                        }
                    }
                }
                String a7 = a(this.a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", trim);
                jSONObject2.put("bizcontext", a7);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            C4302e.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return C4313i.a(new C4293a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.11";
    }

    public synchronized H5PayResultModel h5Pay(C4293a c4293a, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        String[] split = f(c4293a, str, z).split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            int indexOf = str2.indexOf("={");
            if (indexOf >= 0) {
                String substring = str2.substring(0, indexOf);
                hashMap.put(substring, h(str2, substring));
            }
        }
        if (hashMap.containsKey(C4316l.a)) {
            h5PayResultModel.setResultCode(hashMap.get(C4316l.a));
        }
        h5PayResultModel.setReturnUrl(i(str, hashMap));
        if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
            C4218a.b(c4293a, C4226b.l, C4226b.n0, "");
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (C4299b.a()) {
            return C4212b.b();
        }
        return f(new C4293a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
            C4302e.d(C4230a.z, "intercepted: " + fetchOrderInfoFromH5PayUrl);
            new Thread(new RunnableC4128a(fetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String f;
        C4293a c4293a;
        if (C4299b.a()) {
            c4293a = null;
            f = C4212b.b();
        } else {
            C4293a c4293a2 = new C4293a(this.a, str, "payV2");
            f = f(c4293a2, str, z);
            c4293a = c4293a2;
        }
        return C4316l.a(c4293a, f);
    }

    public void showLoading() {
        C4337a c4337a = this.b;
        if (c4337a != null) {
            c4337a.d();
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
            com.alipay.sdk.m.u.C4302e.a(r6)
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
            com.alipay.sdk.m.u.C4302e.a(r6)
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

    public static String a(C4293a c4293a, String str, List<C4245a.C4247b> list, String str2, Activity activity) {
        C4318n.C4321c a = C4318n.a(c4293a, activity, list);
        if (a == null || a.a(c4293a) || a.a() || !TextUtils.equals(a.a.packageName, PayResultActivity.d)) {
            return str2;
        }
        C4302e.b(C4230a.z, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.c;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, valueOf);
        C4293a.C4294a.a(c4293a, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                C4302e.b(C4230a.z, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                C4302e.b(C4230a.z, "PayTask interrupted");
                return C4212b.a();
            }
        }
        String str3 = PayResultActivity.C4127b.b;
        C4302e.b(C4230a.z, "PayTask ret: " + str3);
        return str3;
    }
}
