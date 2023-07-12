package com.taobao.android.ultron.datamodel.imp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.youku.arch.v3.data.Constants;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.co2;
import tb.it2;
import tb.kd0;
import tb.lx1;
import tb.ve;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ParseResponseHelper {
    private C6661a a;
    private boolean b = false;
    private Map<String, Object> c = new HashMap();
    private AsyncTask<Void, Void, ve> d;
    private volatile ve e;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes12.dex */
    public static class TemplateInfo implements Serializable {
        public String id;
        public String version;

        public TemplateInfo(String str, String str2) {
            this.id = str;
            this.version = str2;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.ultron.datamodel.imp.ParseResponseHelper$a */
    /* loaded from: classes12.dex */
    class AsyncTaskC6660a extends AsyncTask<Void, Void, ve> {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ JSONArray b;
        final /* synthetic */ it2 c;
        final /* synthetic */ String d;

        AsyncTaskC6660a(JSONObject jSONObject, JSONArray jSONArray, it2 it2Var, String str) {
            this.a = jSONObject;
            this.b = jSONArray;
            this.c = it2Var;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public ve doInBackground(Void... voidArr) {
            vt2.d("ParseResponseHelper", "parseCacheData async running");
            ParseResponseHelper parseResponseHelper = ParseResponseHelper.this;
            parseResponseHelper.e = parseResponseHelper.j(this.a, this.b);
            if (ParseResponseHelper.this.e != null) {
                this.c.g(this.d, ParseResponseHelper.this.e);
            }
            vt2.d("ParseResponseHelper", " parseCacheData done");
            return ParseResponseHelper.this.e;
        }
    }

    public ParseResponseHelper(C6661a c6661a) {
        this.a = c6661a;
    }

    private String e(String str, Map<String, JSONObject> map) {
        JSONObject jSONObject = map.get(str);
        return jSONObject != null ? jSONObject.getString("containerType") : "native";
    }

    public static List<TemplateInfo> g(Context context, String str) {
        List<String> f = it2.d(context, str).f();
        vt2.d("ParseResponseHelper", "getTemplateInfo list:" + f);
        if (f != null) {
            ArrayList arrayList = new ArrayList(f.size());
            for (String str2 : f) {
                String[] split = str2.split("_\\$_");
                if (split.length >= 1) {
                    arrayList.add(new TemplateInfo(split[0], split.length == 2 ? split[1] : null));
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ve j(JSONObject jSONObject, JSONArray jSONArray) {
        String key;
        String[] d;
        JSONArray jSONArray2;
        ve veVar = new ve();
        if (jSONObject != null && jSONArray != null && !jSONArray.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = jSONObject.getJSONObject("container");
            if (jSONObject2 != null && (jSONArray2 = jSONObject2.getJSONArray("data")) != null) {
                int size = jSONArray2.size();
                int i = 0;
                while (i < size) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                    if (jSONObject3 != null) {
                        arrayList.add(new kd0(jSONObject3));
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("type");
                        int size2 = jSONArray3.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            JSONArray jSONArray4 = jSONArray2;
                            String string = jSONArray3.getString(i2);
                            jSONObject3.toString();
                            hashMap.put(string, jSONObject3);
                            i2++;
                            jSONArray2 = jSONArray4;
                        }
                    }
                    i++;
                    jSONArray2 = jSONArray2;
                }
            }
            if (jSONArray.contains("container")) {
                veVar.f(arrayList);
                veVar.e(hashMap);
            }
            if (jSONArray.contains("data")) {
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject4 = jSONObject.getJSONObject("data");
                if (jSONObject4 != null) {
                    boolean h = h(lx1.FEATURE_TAG_ID);
                    for (Map.Entry<String, Object> entry : jSONObject4.entrySet()) {
                        if (entry != null && (key = entry.getKey()) != null) {
                            Object value = entry.getValue();
                            if (value instanceof JSONObject) {
                                if (h && (d = C6663c.d(key)) != null && d.length == 2) {
                                    jSONObject.put("tag", (Object) d[0]);
                                    jSONObject.put("id", (Object) d[1]);
                                }
                                JSONObject jSONObject5 = (JSONObject) value;
                                String string2 = jSONObject5.getString("type");
                                String string3 = jSONObject5.getString("tag");
                                String e = e(string2, hashMap);
                                JSONObject jSONObject6 = hashMap.get(string2);
                                if (jSONObject6 != null) {
                                    vt2.b("ParseResponseHelper", "createDMComponent", "type", string2, "tag", string3);
                                }
                                hashMap2.put(key, new DMComponent(jSONObject5, e, jSONObject6, m(jSONObject.getJSONObject("events"))));
                            }
                        }
                    }
                }
                veVar.d(hashMap2);
            }
        }
        return veVar;
    }

    private IDMEvent l(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        return new DMEvent(jSONObject.getString("type"), jSONObject.getJSONObject("fields"), null);
    }

    private Map<String, List<IDMEvent>> m(JSONObject jSONObject) {
        IDMEvent l;
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap(jSONObject.size());
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value instanceof JSONArray)) {
                JSONArray jSONArray = (JSONArray) value;
                ArrayList arrayList = new ArrayList(jSONArray.size());
                Iterator<Object> it = jSONArray.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof JSONObject) && (l = l((JSONObject) next)) != null) {
                        arrayList.add(l);
                    }
                }
                hashMap.put(key, arrayList);
            }
        }
        return hashMap;
    }

    public void d(String str, Object obj) {
        this.c.put(str, obj);
    }

    public Map<String, Object> f() {
        return this.c;
    }

    public boolean h(BigInteger bigInteger) {
        if (this.a.k() == null) {
            return false;
        }
        return lx1.a(new BigInteger(this.a.k()), bigInteger);
    }

    public boolean i() {
        return this.b;
    }

    public void k(JSONObject jSONObject, ve veVar) {
        vt2.b("ParseResponseHelper", "parseDataWithCache");
        C6661a c6661a = this.a;
        if (c6661a == null || jSONObject == null) {
            return;
        }
        C6662b g = c6661a.g();
        if (g == null) {
            g = new C6662b(this.a.o);
            this.a.A(g);
        }
        if (veVar != null) {
            Map<String, DMComponent> a = veVar.a();
            List<kd0> c = veVar.c();
            Map<String, JSONObject> b = veVar.b();
            if (a != null) {
                this.a.c().putAll(a);
                this.a.J("data");
            }
            if (c != null) {
                this.a.H(c);
                this.a.J("container");
                StringBuilder sb = new StringBuilder();
                sb.append("template cache info: \n");
                for (kd0 kd0Var : c) {
                    if (kd0Var != null) {
                        sb.append(kd0Var.toString());
                        sb.append(";\n");
                    }
                }
                vt2.b("ParseResponseHelper", sb.toString());
            }
            if (b != null) {
                this.a.I(b);
                this.a.J("container");
            }
        } else {
            this.a.J(null);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.b = g.e(this.a, jSONObject2);
        this.c.put("protocolVersion", this.a.getProtocolVersion());
        if (jSONObject2 == null) {
            this.c.put("reload", Boolean.TRUE);
        } else {
            this.c.put("reload", Boolean.valueOf(Boolean.TRUE.toString().equalsIgnoreCase(jSONObject2.getString("reload"))));
        }
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null || !jSONObject.containsKey("endpoint") || (jSONObject2 = jSONObject.getJSONObject("endpoint")) == null) {
            return;
        }
        String string = jSONObject2.getString("features");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.a.E(string);
        vt2.b("ParseResponseHelper", "protocol features: " + string);
    }

    public void o(JSONObject jSONObject) {
        AsyncTask<Void, Void, ve> asyncTask;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.e == null && (asyncTask = this.d) != null) {
            try {
                asyncTask.get();
            } catch (Throwable th) {
                vt2.b("ParseResponseHelper", "parseCacheAsyncTask.get()", Log.getStackTraceString(th));
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            vt2.d("ParseResponseHelper", "wait cacheDataResult time:" + currentTimeMillis2 + "ms");
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        if (this.e != null) {
            k(jSONObject, this.e);
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            vt2.d("ParseResponseHelper", "parseDataWithCache time:" + currentTimeMillis4 + "ms");
            return;
        }
        r(jSONObject);
        long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis3;
        vt2.d("ParseResponseHelper", "parseResponseWithoutCache time:" + currentTimeMillis5 + "ms");
    }

    public void p(MtopResponse mtopResponse) {
        if (mtopResponse == null) {
            return;
        }
        q(mtopResponse.getBytedata());
    }

    public void q(byte[] bArr) {
        if (this.a == null || bArr == null) {
            return;
        }
        o((JSONObject) JSON.parseObject(bArr, JSONObject.class, new Feature[0]));
    }

    public void r(JSONObject jSONObject) {
        co2.e("ParseResponse", "start");
        C6661a c6661a = this.a;
        if (c6661a == null || jSONObject == null) {
            return;
        }
        C6662b g = c6661a.g();
        if (g == null) {
            g = new C6662b(this.a.o);
            this.a.A(g);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        this.b = g.e(this.a, jSONObject2);
        this.c.put("protocolVersion", this.a.getProtocolVersion());
        if (jSONObject2 == null) {
            this.c.put("reload", Boolean.TRUE);
            return;
        }
        this.c.put("reload", Boolean.valueOf(Boolean.TRUE.toString().equalsIgnoreCase(jSONObject2.getString("reload"))));
        co2.a("ParseResponse", "end");
    }

    @SuppressLint({"StaticFieldLeak"})
    public void s(Context context, String str, final JSONObject jSONObject, boolean z, boolean z2) {
        String str2;
        boolean z3;
        JSONObject jSONObject2;
        vt2.d("ParseResponseHelper", "processCache");
        if (jSONObject == null || !z) {
            return;
        }
        JSONObject jSONObject3 = null;
        JSONObject jSONObject4 = jSONObject.getJSONObject("endpoint");
        if (jSONObject4 != null && !jSONObject4.isEmpty() && (jSONObject2 = jSONObject4.getJSONObject("meta")) != null) {
            jSONObject3 = jSONObject2.getJSONObject(Constants.TEMPLATE);
        }
        if (jSONObject3 == null) {
            return;
        }
        final it2 d = it2.d(context, str);
        boolean z4 = true;
        vt2.d("ParseResponseHelper", "processCache with cacheConfig:" + jSONObject3);
        final String string = jSONObject3.getString("id");
        final String string2 = jSONObject3.getString("version");
        if (string == null) {
            return;
        }
        if (string2 != null) {
            str2 = string + "_$_" + string2;
        } else {
            str2 = string;
        }
        final JSONArray jSONArray = jSONObject3.getJSONArray("cacheFields");
        vt2.d("ParseResponseHelper", "processCache templateKey:" + str2);
        if (TextUtils.isEmpty(str2) || jSONArray == null) {
            return;
        }
        Iterator<Object> it = jSONArray.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            } else if (!jSONObject.containsKey(it.next())) {
                z3 = true;
                break;
            }
        }
        if (z3) {
            JSONObject e = d.e(str2);
            if (e != null) {
                Iterator<Object> it2 = jSONArray.iterator();
                boolean z5 = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (!jSONObject.containsKey(next)) {
                        Object obj = e.get(next);
                        if (obj != null) {
                            jSONObject.put((String) next, obj);
                        } else {
                            z5 = true;
                        }
                    }
                }
                vt2.d("ParseResponseHelper", "processCache use cache");
                z4 = z5;
            }
            if (z4) {
                vt2.b("ParseResponseHelper", "processCache dataWrong");
                d.b(str2);
            }
        } else {
            final String str3 = str2;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.taobao.android.ultron.datamodel.imp.ParseResponseHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject5 = new JSONObject();
                    Iterator<Object> it3 = jSONArray.iterator();
                    while (it3.hasNext()) {
                        Object next2 = it3.next();
                        jSONObject5.put((String) next2, jSONObject.get(next2));
                    }
                    d.h(str3, jSONObject5);
                    vt2.d("ParseResponseHelper", "processCache save cache");
                    List<String> f = d.f();
                    if (f != null) {
                        for (String str4 : new ArrayList(f)) {
                            String[] split = str4.split("_\\$_");
                            if (split.length == 2 && TextUtils.equals(split[0], string) && !TextUtils.equals(split[1], string2)) {
                                d.b(str4);
                                d.a(str4);
                                vt2.d("ParseResponseHelper", "processCache deleteTemplateById:" + str4);
                            }
                        }
                    }
                }
            });
        }
        if (z2) {
            this.e = d.c(str2);
            if (this.e == null) {
                AsyncTaskC6660a asyncTaskC6660a = new AsyncTaskC6660a(jSONObject, jSONArray, d, str2);
                this.d = asyncTaskC6660a;
                asyncTaskC6660a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }
}
