package com.youku.arch.ntk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.C7825a;
import com.youku.arch.ntk.a.C7827a;
import com.youku.arch.ntk.a.C7829c;
import com.youku.arch.ntk.a.C7832f;
import com.youku.arch.ntk.a.C7833g;
import com.youku.arch.ntk.a.C7834h;
import com.youku.arch.ntk.a.C7835i;
import com.youku.arch.ntk.a.C7836j;
import com.youku.arch.ntk.a.C7838l;
import com.youku.arch.ntk.b.C7842b;
import com.youku.arch.ntk.b.C7845c;
import com.youku.arch.ntk.b.C7848d;
import com.youku.arch.ntk.b.C7852e;
import com.youku.arch.ntk.b.C7854f;
import com.youku.arch.ntk.c.C7858a;
import com.youku.arch.ntk.c.C7859b;
import com.youku.b.a.C7892a;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.n83;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.b */
/* loaded from: classes2.dex */
public class C7839b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "b";
    private ExecutorService b;
    private volatile boolean c;
    private ConcurrentHashMap<String, Long> d;
    private C7832f e;
    private C7859b f;
    private C7857c g;
    private C7833g h;
    private boolean i;
    private C7825a.InterfaceC7826a j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.ntk.b$a */
    /* loaded from: classes2.dex */
    public static class C7840a {
        private static final C7839b a = new C7839b();
    }

    private C7839b() {
        this.b = Executors.newSingleThreadExecutor();
        this.d = new ConcurrentHashMap<>();
        this.g = new C7857c();
        this.i = false;
        this.j = new C7825a.InterfaceC7826a() { // from class: com.youku.arch.ntk.b.1
            Pattern a = Pattern.compile("\\d+");
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C7834h c7834h) {
        C7835i c7835i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423352699")) {
            ipChange.ipc$dispatch("-423352699", new Object[]{this, c7834h});
        } else if (c7834h == null) {
            C7892a.a(a, "error! ntk reqinfo is null!");
        } else {
            NtkWrapper.a().a(this.j);
            C7832f c7832f = new C7832f();
            this.e = c7832f;
            c7832f.b = c7834h;
            this.f = new C7859b();
            if (this.g.a(this.e) < 0 || (c7835i = this.e.a) == null || c7835i.f == null) {
                return;
            }
            this.h = new C7833g();
            a(this.e.a.f);
            d();
        }
    }

    private void a(JSONObject[] jSONObjectArr) {
        C7829c[] c7829cArr;
        C7836j[] c7836jArr;
        C7838l[] c7838lArr;
        C7836j[] c7836jArr2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440076316")) {
            ipChange.ipc$dispatch("440076316", new Object[]{this, jSONObjectArr});
        } else if (jSONObjectArr != null) {
            for (JSONObject jSONObject : jSONObjectArr) {
                try {
                    int intValue = jSONObject.getInteger("type").intValue();
                    C7833g c7833g = new C7833g();
                    if (intValue == 0) {
                        C7842b.a().a(c7833g, jSONObject, this.e);
                        C7833g c7833g2 = this.h;
                        if (c7833g2 != null && (c7829cArr = c7833g.a) != null) {
                            if (c7833g2.a != null) {
                                ArrayList arrayList = new ArrayList(Arrays.asList(this.h.a));
                                arrayList.addAll(Arrays.asList(c7833g.a));
                                this.h.a = (C7829c[]) arrayList.toArray(new C7829c[0]);
                            } else {
                                c7833g2.a = c7829cArr;
                            }
                        }
                    } else if (intValue == 1) {
                        C7848d.a().a(c7833g, jSONObject, this.e);
                        C7833g c7833g3 = this.h;
                        if (c7833g3 != null && (c7836jArr = c7833g.b) != null) {
                            if (c7833g3.b != null) {
                                ArrayList arrayList2 = new ArrayList(Arrays.asList(this.h.b));
                                arrayList2.addAll(Arrays.asList(c7833g.b));
                                this.h.b = (C7836j[]) arrayList2.toArray(new C7836j[0]);
                            } else {
                                c7833g3.b = c7836jArr;
                            }
                        }
                    } else if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4) {
                                C7845c.a().a(c7833g, jSONObject, this.e);
                                C7833g c7833g4 = this.h;
                                if (c7833g4 != null && (c7836jArr2 = c7833g.b) != null) {
                                    if (c7833g4.b != null) {
                                        ArrayList arrayList3 = new ArrayList(Arrays.asList(this.h.b));
                                        arrayList3.addAll(Arrays.asList(c7833g.b));
                                        this.h.b = (C7836j[]) arrayList3.toArray(new C7836j[0]);
                                    } else {
                                        c7833g4.b = c7836jArr2;
                                    }
                                }
                            } else if (intValue != 5) {
                                C7892a.b(a, "ntk task type error. no type " + intValue + " exists");
                            }
                        }
                        C7852e.a().a(c7833g, jSONObject, this.e);
                        if (this.h != null && !c7833g.d.isEmpty()) {
                            this.h.d.addAll(c7833g.d);
                        }
                    } else {
                        C7833g c7833g5 = this.h;
                        if (c7833g5 != null) {
                            c7833g.b = c7833g5.b;
                        }
                        C7854f.a().a(c7833g, jSONObject, this.e);
                        C7833g c7833g6 = this.h;
                        if (c7833g6 != null && (c7838lArr = c7833g.c) != null) {
                            if (c7833g6.c != null) {
                                ArrayList arrayList4 = new ArrayList(Arrays.asList(this.h.c));
                                arrayList4.addAll(Arrays.asList(c7833g.c));
                                this.h.c = (C7838l[]) arrayList4.toArray(new C7838l[0]);
                            } else {
                                c7833g6.c = c7838lArr;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static C7839b b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-918735214") ? (C7839b) ipChange.ipc$dispatch("-918735214", new Object[0]) : C7840a.a;
    }

    private void d() {
        C7832f c7832f;
        C7834h c7834h;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102081410")) {
            ipChange.ipc$dispatch("-1102081410", new Object[]{this});
            return;
        }
        C7833g c7833g = this.h;
        if (c7833g == null || (c7834h = (c7832f = this.e).b) == null) {
            return;
        }
        c7833g.h = c7834h.u;
        c7833g.e = c7834h.e;
        c7833g.g = c7834h.v;
        c7833g.f = c7834h.w;
        c7833g.j = c7834h.t;
        c7833g.n = c7834h.j;
        c7833g.p = c7834h.o;
        c7833g.k = c7834h.c;
        c7833g.l = c7834h.d;
        c7833g.r = c7834h.l;
        c7833g.m = c7834h.i;
        c7833g.o = c7834h.n;
        c7833g.q = c7834h.h;
        if (c7832f.a != null) {
            c7833g.s = "" + this.e.a.e;
        }
        a(this.e.b, this.h);
    }

    public C7827a a(C7834h c7834h, C7833g c7833g) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114186793")) {
            return (C7827a) ipChange.ipc$dispatch("-1114186793", new Object[]{this, c7834h, c7833g});
        }
        C7858a.a(c7833g);
        String str = (c7834h == null || c7834h.b != 1) ? "http://connectivity.youku.com/ana_data/recieve" : "http://106.11.46.130/ana_data/recieve";
        C7827a c7827a = new C7827a();
        InputStream inputStream = null;
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (c7834h != null && c7834h.b == 1) {
                httpURLConnection.setRequestProperty(BizTime.HOST, "pre-connectivity.youku.com");
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            if (url.getProtocol().equals("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new n83());
            }
            httpURLConnection.connect();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                String jSONString = JSON.toJSONString(c7833g);
                dataOutputStream.writeBytes(JSON.toJSONString(jSONString));
                String str2 = a;
                C7892a.a(str2, "result:" + jSONString);
                dataOutputStream.flush();
                dataOutputStream.close();
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                C7827a c7827a2 = (C7827a) JSON.parseObject(stringBuffer.toString(), C7827a.class);
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
                return c7827a2;
            } catch (JSONException e) {
                c7827a.a = -102;
                e.printStackTrace();
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
                return c7827a;
            } catch (IOException e2) {
                e2.printStackTrace();
                c7827a.a = -101;
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
                return c7827a;
            }
        } catch (IOException e3) {
            c7827a.a = -103;
            e3.printStackTrace();
            return c7827a;
        }
    }

    public C7833g a(C7834h c7834h, C7835i c7835i) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809041427")) {
            return (C7833g) ipChange.ipc$dispatch("809041427", new Object[]{this, c7834h, c7835i});
        }
        if (this.c) {
            str = a;
            str2 = "previous ntk inspect progress is running. exit.";
        } else if (c7834h != null && c7835i != null) {
            String str3 = a;
            C7892a.b(str3, "start inspectNetworkInternal:" + c7834h.t);
            this.c = true;
            C7832f c7832f = new C7832f();
            this.e = c7832f;
            c7832f.a = c7835i;
            c7832f.b = c7834h;
            NtkWrapper.a().a(this.j);
            this.f = new C7859b();
            if (c7835i.f != null) {
                this.h = new C7833g();
                a(c7835i.f);
            }
            this.c = false;
            C7892a.b(str3, "finish inspectNetworkInternal:" + c7834h.t);
            return this.h;
        } else {
            str = a;
            str2 = "empty parameters, exit.";
        }
        C7892a.b(str, str2);
        return null;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1102170779") ? ((Boolean) ipChange.ipc$dispatch("-1102170779", new Object[]{this})).booleanValue() : this.i;
    }
}
