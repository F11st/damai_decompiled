package com.taobao.monitor.network;

import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.monitor.procedure.f;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.hw0;
import tb.pb1;
import tb.qf2;
import tb.rc;
import tb.rf0;
import tb.vj1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a implements ProcedureImpl.IProcedureLifeCycle {
    public static String a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", hw0.a);
            jSONObject.put("topic", fVar.v());
            jSONObject.put("headers", b(fVar));
            jSONObject.put("value", g(fVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        pb1.d("ProcedureLifecycleImpl", jSONObject2);
        return jSONObject2;
    }

    private static JSONObject b(f fVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("X-timestamp", fVar.u()).put("X-appId", hw0.b).put("X-appKey", hw0.c).put("X-appBuild", hw0.d).put("X-appPatch", hw0.f).put("X-channel", hw0.g).put("X-utdid", hw0.h).put("X-brand", hw0.i).put("X-deviceModel", hw0.j).put("X-os", hw0.k).put("X-osVersion", hw0.l).put("X-userId", hw0.m).put("X-userNick", hw0.n).put("X-session", hw0.o).put("X-processName", hw0.p).put("X-appVersion", hw0.e).put("X-launcherMode", hw0.r);
        return jSONObject;
    }

    private static void c(JSONObject jSONObject, Map<String, ?> map) throws Exception {
        d(jSONObject, map, 2);
    }

    private static void d(JSONObject jSONObject, Map<String, ?> map, int i) throws Exception {
        if (map == null || i <= 0) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            f(jSONObject, entry.getKey(), entry.getValue(), i);
        }
    }

    private static void e(JSONObject jSONObject, String str, Object obj) throws Exception {
        f(jSONObject, str, obj, 2);
    }

    private static void f(JSONObject jSONObject, String str, Object obj, int i) throws Exception {
        if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            jSONObject.put(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            jSONObject.put(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            jSONObject.put(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            jSONObject.put(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Character) {
            jSONObject.put(str, ((Character) obj).charValue());
        } else if (obj instanceof Short) {
            jSONObject.put(str, ((Short) obj).shortValue());
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() != 0) {
                JSONObject jSONObject2 = new JSONObject();
                d(jSONObject2, map, i - 1);
                jSONObject.put(str, jSONObject2);
            }
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static JSONObject g(f fVar) throws Exception {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Map<String, Object> m = fVar.m();
        if (m == null || m.size() == 0) {
            z = false;
        } else {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                e(jSONObject2, entry.getKey(), entry.getValue());
            }
            z = true;
        }
        List<rc> h = fVar.h();
        if (h != null && h.size() != 0) {
            JSONObject jSONObject3 = new JSONObject();
            for (rc rcVar : h) {
                Map<String, Object> f = rcVar.f();
                JSONObject jSONObject4 = new JSONObject();
                if (f != null && f.size() != 0) {
                    c(jSONObject4, f);
                }
                Map<String, Object> a = rcVar.a();
                if (a != null && a.size() != 0) {
                    JSONObject jSONObject5 = new JSONObject();
                    c(jSONObject5, a);
                    jSONObject4.put("abtest", jSONObject5);
                }
                Map<String, Object> g = rcVar.g();
                if (g != null && g.size() != 0) {
                    JSONObject jSONObject6 = new JSONObject();
                    c(jSONObject6, g);
                    jSONObject4.put("stages", jSONObject6);
                }
                jSONObject3.put(rcVar.e(), jSONObject4);
            }
            jSONObject2.put("bizTags", jSONObject3);
            pb1.a("ProcedureLifecycleImpl", "properties", jSONObject2);
            z = true;
        }
        if (z) {
            jSONObject.put("properties", jSONObject2);
        }
        Map<String, Object> r = fVar.r();
        JSONObject jSONObject7 = new JSONObject();
        if (r != null && r.size() != 0) {
            c(jSONObject7, r);
        }
        Map<String, Integer> i = fVar.i();
        if (i != null && i.size() != 0) {
            c(jSONObject7, i);
        }
        if (i.size() != 0 || r.size() != 0) {
            jSONObject.put("stats", jSONObject7);
            pb1.a("ProcedureLifecycleImpl", "stats", jSONObject7);
        }
        List<rf0> k = fVar.k();
        if (k != null && k.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (rf0 rf0Var : k) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("timestamp", rf0Var.c());
                jSONObject8.put("name", rf0Var.a());
                c(jSONObject8, rf0Var.b());
                jSONArray.put(jSONObject8);
            }
            jSONObject.put("events", jSONArray);
            pb1.a("ProcedureLifecycleImpl", "events", jSONArray);
        }
        List<qf2> q = fVar.q();
        if (q != null && q.size() != 0) {
            JSONObject jSONObject9 = new JSONObject();
            for (qf2 qf2Var : q) {
                jSONObject9.put(qf2Var.a(), qf2Var.b());
            }
            jSONObject.put("stages", jSONObject9);
            pb1.a("ProcedureLifecycleImpl", "stages", jSONObject9);
        }
        List<f> s = fVar.s();
        if (s != null && s.size() != 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (f fVar2 : s) {
                JSONObject g2 = g(fVar2);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put(fVar2.v(), g2);
                jSONArray2.put(jSONObject10);
            }
            jSONObject.put("subProcedures", jSONArray2);
            pb1.a("ProcedureLifecycleImpl", "subProcedures", jSONArray2);
        }
        return jSONObject;
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void begin(f fVar) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void end(f fVar) {
        vj1.b().send(fVar.v(), a(fVar));
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void event(f fVar, rf0 rf0Var) {
    }

    @Override // com.taobao.monitor.procedure.ProcedureImpl.IProcedureLifeCycle
    public void stage(f fVar, qf2 qf2Var) {
    }
}
