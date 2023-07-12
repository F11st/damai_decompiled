package com.youku.arch.ntk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.ntk.a;
import com.youku.arch.ntk.a.f;
import com.youku.arch.ntk.a.g;
import com.youku.arch.ntk.a.h;
import com.youku.arch.ntk.a.i;
import com.youku.arch.ntk.a.j;
import com.youku.arch.ntk.a.l;
import com.youku.arch.ntk.b.d;
import com.youku.arch.ntk.b.e;
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
/* loaded from: classes2.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "b";
    private ExecutorService b;
    private volatile boolean c;
    private ConcurrentHashMap<String, Long> d;
    private f e;
    private com.youku.arch.ntk.c.b f;
    private c g;
    private g h;
    private boolean i;
    private a.InterfaceC0365a j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class a {
        private static final b a = new b();
    }

    private b() {
        this.b = Executors.newSingleThreadExecutor();
        this.d = new ConcurrentHashMap<>();
        this.g = new c();
        this.i = false;
        this.j = new a.InterfaceC0365a() { // from class: com.youku.arch.ntk.b.1
            Pattern a = Pattern.compile("\\d+");
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        i iVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423352699")) {
            ipChange.ipc$dispatch("-423352699", new Object[]{this, hVar});
        } else if (hVar == null) {
            com.youku.b.a.a.a(a, "error! ntk reqinfo is null!");
        } else {
            NtkWrapper.a().a(this.j);
            f fVar = new f();
            this.e = fVar;
            fVar.b = hVar;
            this.f = new com.youku.arch.ntk.c.b();
            if (this.g.a(this.e) < 0 || (iVar = this.e.a) == null || iVar.f == null) {
                return;
            }
            this.h = new g();
            a(this.e.a.f);
            d();
        }
    }

    private void a(JSONObject[] jSONObjectArr) {
        com.youku.arch.ntk.a.c[] cVarArr;
        j[] jVarArr;
        l[] lVarArr;
        j[] jVarArr2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440076316")) {
            ipChange.ipc$dispatch("440076316", new Object[]{this, jSONObjectArr});
        } else if (jSONObjectArr != null) {
            for (JSONObject jSONObject : jSONObjectArr) {
                try {
                    int intValue = jSONObject.getInteger("type").intValue();
                    g gVar = new g();
                    if (intValue == 0) {
                        com.youku.arch.ntk.b.b.a().a(gVar, jSONObject, this.e);
                        g gVar2 = this.h;
                        if (gVar2 != null && (cVarArr = gVar.a) != null) {
                            if (gVar2.a != null) {
                                ArrayList arrayList = new ArrayList(Arrays.asList(this.h.a));
                                arrayList.addAll(Arrays.asList(gVar.a));
                                this.h.a = (com.youku.arch.ntk.a.c[]) arrayList.toArray(new com.youku.arch.ntk.a.c[0]);
                            } else {
                                gVar2.a = cVarArr;
                            }
                        }
                    } else if (intValue == 1) {
                        d.a().a(gVar, jSONObject, this.e);
                        g gVar3 = this.h;
                        if (gVar3 != null && (jVarArr = gVar.b) != null) {
                            if (gVar3.b != null) {
                                ArrayList arrayList2 = new ArrayList(Arrays.asList(this.h.b));
                                arrayList2.addAll(Arrays.asList(gVar.b));
                                this.h.b = (j[]) arrayList2.toArray(new j[0]);
                            } else {
                                gVar3.b = jVarArr;
                            }
                        }
                    } else if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4) {
                                com.youku.arch.ntk.b.c.a().a(gVar, jSONObject, this.e);
                                g gVar4 = this.h;
                                if (gVar4 != null && (jVarArr2 = gVar.b) != null) {
                                    if (gVar4.b != null) {
                                        ArrayList arrayList3 = new ArrayList(Arrays.asList(this.h.b));
                                        arrayList3.addAll(Arrays.asList(gVar.b));
                                        this.h.b = (j[]) arrayList3.toArray(new j[0]);
                                    } else {
                                        gVar4.b = jVarArr2;
                                    }
                                }
                            } else if (intValue != 5) {
                                com.youku.b.a.a.b(a, "ntk task type error. no type " + intValue + " exists");
                            }
                        }
                        e.a().a(gVar, jSONObject, this.e);
                        if (this.h != null && !gVar.d.isEmpty()) {
                            this.h.d.addAll(gVar.d);
                        }
                    } else {
                        g gVar5 = this.h;
                        if (gVar5 != null) {
                            gVar.b = gVar5.b;
                        }
                        com.youku.arch.ntk.b.f.a().a(gVar, jSONObject, this.e);
                        g gVar6 = this.h;
                        if (gVar6 != null && (lVarArr = gVar.c) != null) {
                            if (gVar6.c != null) {
                                ArrayList arrayList4 = new ArrayList(Arrays.asList(this.h.c));
                                arrayList4.addAll(Arrays.asList(gVar.c));
                                this.h.c = (l[]) arrayList4.toArray(new l[0]);
                            } else {
                                gVar6.c = lVarArr;
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

    public static b b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-918735214") ? (b) ipChange.ipc$dispatch("-918735214", new Object[0]) : a.a;
    }

    private void d() {
        f fVar;
        h hVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102081410")) {
            ipChange.ipc$dispatch("-1102081410", new Object[]{this});
            return;
        }
        g gVar = this.h;
        if (gVar == null || (hVar = (fVar = this.e).b) == null) {
            return;
        }
        gVar.h = hVar.u;
        gVar.e = hVar.e;
        gVar.g = hVar.v;
        gVar.f = hVar.w;
        gVar.j = hVar.t;
        gVar.n = hVar.j;
        gVar.p = hVar.o;
        gVar.k = hVar.c;
        gVar.l = hVar.d;
        gVar.r = hVar.l;
        gVar.m = hVar.i;
        gVar.o = hVar.n;
        gVar.q = hVar.h;
        if (fVar.a != null) {
            gVar.s = "" + this.e.a.e;
        }
        a(this.e.b, this.h);
    }

    public com.youku.arch.ntk.a.a a(h hVar, g gVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114186793")) {
            return (com.youku.arch.ntk.a.a) ipChange.ipc$dispatch("-1114186793", new Object[]{this, hVar, gVar});
        }
        com.youku.arch.ntk.c.a.a(gVar);
        String str = (hVar == null || hVar.b != 1) ? "http://connectivity.youku.com/ana_data/recieve" : "http://106.11.46.130/ana_data/recieve";
        com.youku.arch.ntk.a.a aVar = new com.youku.arch.ntk.a.a();
        InputStream inputStream = null;
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (hVar != null && hVar.b == 1) {
                httpURLConnection.setRequestProperty(BizTime.HOST, "pre-connectivity.youku.com");
            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            if (url.getProtocol().equals("https")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new n83());
            }
            httpURLConnection.connect();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                String jSONString = JSON.toJSONString(gVar);
                dataOutputStream.writeBytes(JSON.toJSONString(jSONString));
                String str2 = a;
                com.youku.b.a.a.a(str2, "result:" + jSONString);
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
                com.youku.arch.ntk.a.a aVar2 = (com.youku.arch.ntk.a.a) JSON.parseObject(stringBuffer.toString(), com.youku.arch.ntk.a.a.class);
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
                return aVar2;
            } catch (JSONException e) {
                aVar.a = -102;
                e.printStackTrace();
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
                return aVar;
            } catch (IOException e2) {
                e2.printStackTrace();
                aVar.a = -101;
                try {
                    inputStream.close();
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
                return aVar;
            }
        } catch (IOException e3) {
            aVar.a = -103;
            e3.printStackTrace();
            return aVar;
        }
    }

    public g a(h hVar, i iVar) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809041427")) {
            return (g) ipChange.ipc$dispatch("809041427", new Object[]{this, hVar, iVar});
        }
        if (this.c) {
            str = a;
            str2 = "previous ntk inspect progress is running. exit.";
        } else if (hVar != null && iVar != null) {
            String str3 = a;
            com.youku.b.a.a.b(str3, "start inspectNetworkInternal:" + hVar.t);
            this.c = true;
            f fVar = new f();
            this.e = fVar;
            fVar.a = iVar;
            fVar.b = hVar;
            NtkWrapper.a().a(this.j);
            this.f = new com.youku.arch.ntk.c.b();
            if (iVar.f != null) {
                this.h = new g();
                a(iVar.f);
            }
            this.c = false;
            com.youku.b.a.a.b(str3, "finish inspectNetworkInternal:" + hVar.t);
            return this.h;
        } else {
            str = a;
            str2 = "empty parameters, exit.";
        }
        com.youku.b.a.a.b(str, str2);
        return null;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1102170779") ? ((Boolean) ipChange.ipc$dispatch("-1102170779", new Object[]{this})).booleanValue() : this.i;
    }
}
