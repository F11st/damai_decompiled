package com.taobao.slide.core;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsException;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OConstant;
import com.taobao.slide.api.SlideConfig;
import com.taobao.slide.api.SlideSubscriber;
import com.taobao.slide.model.AppDO;
import com.taobao.slide.model.PeaDO;
import com.taobao.slide.model.PodDO;
import com.taobao.slide.model.ResultDO;
import com.taobao.slide.model.TraceDO;
import com.taobao.slide.task.DispatchTask;
import com.taobao.slide.task.PushTask;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import tb.da1;
import tb.gn1;
import tb.hh1;
import tb.il2;
import tb.ki2;
import tb.m42;
import tb.mh1;
import tb.nl;
import tb.u21;
import tb.uc;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b {
    private Context a;
    private SlideConfig b;
    private a<AppDO> c;
    private AppDO d;
    private Map<ki2, SlideSubscriber> e = new ConcurrentHashMap();

    public b(Context context, SlideConfig slideConfig) {
        this.a = context;
        this.b = slideConfig;
        this.c = new a<>(new File(this.a.getFilesDir(), String.format("Slide_%s", slideConfig.getEnv().name())));
    }

    private String a(String str, String str2) {
        return String.format("%s[%s]", str, str2);
    }

    private int g(String str) {
        int i = 0;
        for (Map.Entry<ki2, SlideSubscriber> entry : this.e.entrySet()) {
            if (k(str, entry.getKey().a, entry.getValue().e())) {
                i++;
            }
        }
        return i;
    }

    private void i(List<PodDO> list, Map<ki2, SlideSubscriber> map, boolean z) {
        if (list != null && !list.isEmpty()) {
            m42.g("Engine", "match start", "check", Boolean.valueOf(z));
            for (PodDO podDO : list) {
                j(podDO, map, z);
            }
            for (Map.Entry<ki2, SlideSubscriber> entry : map.entrySet()) {
                SlideSubscriber value = entry.getValue();
                if (value.d() != null && value.d().size() != 0) {
                    HashMap hashMap = new HashMap(value.d());
                    value.b();
                    DispatchTask dispatchTask = new DispatchTask(value, hashMap);
                    Handler c = value.c();
                    if (c != null) {
                        c.post(dispatchTask);
                    } else {
                        il2.a(dispatchTask);
                    }
                }
            }
            m42.g("Engine", "match end", new Object[0]);
            return;
        }
        m42.k("Engine", "match not any update pods", new Object[0]);
    }

    private boolean j(PodDO podDO, Map<ki2, SlideSubscriber> map, boolean z) {
        com.taobao.slide.control.a aVar;
        com.taobao.slide.control.a aVar2;
        String str;
        Iterator<Map.Entry<ki2, SlideSubscriber>> it;
        boolean z2;
        com.taobao.slide.control.a aVar3;
        int i = 2;
        m42.i("Engine", "match start", "pod", podDO);
        if (!podDO.isValid()) {
            m42.k("Engine", a("pod invalid", podDO.name), "pod", podDO);
            return false;
        }
        boolean isEmpty = TextUtils.isEmpty(podDO.control);
        String str2 = Constants.KEY_CONTROL;
        if (isEmpty) {
            aVar = null;
        } else {
            aVar = com.taobao.slide.control.a.b(podDO.control);
            if (aVar.e()) {
                m42.k("Engine", a("pod fail", podDO.name), Constants.KEY_CONTROL, podDO.control);
                return false;
            }
        }
        Iterator<Map.Entry<ki2, SlideSubscriber>> it2 = map.entrySet().iterator();
        boolean z3 = false;
        int i2 = 0;
        while (it2.hasNext()) {
            Map.Entry<ki2, SlideSubscriber> next = it2.next();
            String[] strArr = next.getKey().a;
            SlideSubscriber value = next.getValue();
            SlideSubscriber.Type e = value.e();
            if (!k(podDO.name, strArr, e)) {
                Object[] objArr = new Object[i];
                objArr[0] = "pod";
                objArr[1] = podDO;
                m42.i("Engine", "match end", objArr);
            } else {
                Iterator<PeaDO> it3 = podDO.peas.iterator();
                while (it3.hasNext()) {
                    PeaDO next2 = it3.next();
                    Iterator<PeaDO> it4 = it3;
                    it = it2;
                    m42.i("Engine", a("pea start", podDO.name), "pea", next2);
                    i2++;
                    if (!next2.isValid()) {
                        z2 = z3;
                        aVar2 = aVar;
                        u21.a(f(), podDO.name, podDO.ver, 1041, next2.etag);
                        m42.e("Engine", a("pea invalid", next2.etag), "pea", next2);
                    } else {
                        aVar2 = aVar;
                        z2 = z3;
                        if (z && podDO.isNotified(next2.etag)) {
                            m42.g("Engine", a("pea already notified", next2.etag), "pea", next2);
                        } else {
                            if (TextUtils.isEmpty(next2.control)) {
                                aVar3 = null;
                            } else {
                                aVar3 = com.taobao.slide.control.a.b(next2.control);
                                if (aVar3.e()) {
                                    m42.k("Engine", a("pea fail", podDO.name), str2, next2.control);
                                    it3 = it4;
                                    it2 = it;
                                    z3 = z2;
                                    aVar = aVar2;
                                }
                            }
                            if (!TextUtils.isEmpty(next2.condition)) {
                                aVar3 = com.taobao.slide.control.a.b(next2.condition);
                                if (!aVar3.e()) {
                                    m42.k("Engine", a("pea fail", podDO.name), "condition", next2.condition);
                                    it3 = it4;
                                    it2 = it;
                                    z3 = z2;
                                    aVar = aVar2;
                                }
                            }
                            m42.i("Engine", a("pea success", podDO.name), new Object[0]);
                            str = str2;
                            com.taobao.slide.control.a aVar4 = aVar3;
                            ResultDO resultDO = new ResultDO(podDO.name, podDO.ver, podDO.extra, next2.extra, next2.resources, next2.etag);
                            resultDO.statData.d = f();
                            resultDO.statData.e = podDO.stat;
                            m42.g("Engine", a("pea match", podDO.name), "subscriber", String.format("%s->%s", Arrays.toString(strArr), e));
                            value.a(podDO.name, resultDO);
                            podDO.latestPeaIndex = i2 - 1;
                            if (!podDO.isNotified(next2.etag)) {
                                m42.g("Engine", "pea notify", "pod", podDO.name);
                                if (podDO.stat != 0) {
                                    u21.b(f(), podDO.name, podDO.ver, 0, next2.etag);
                                } else {
                                    m42.e("Engine", "match stat closed!!", new Object[0]);
                                }
                                podDO.addNotify(next2.etag);
                            }
                            if (aVar4 != null && aVar4.b) {
                                u21.a(f(), podDO.name, podDO.ver, 1042, next2.etag);
                            }
                            z3 = true;
                            str2 = str;
                            it2 = it;
                            aVar = aVar2;
                            i = 2;
                        }
                    }
                    it3 = it4;
                    it2 = it;
                    z3 = z2;
                    aVar = aVar2;
                }
                aVar2 = aVar;
                str = str2;
                it = it2;
                str2 = str;
                it2 = it;
                aVar = aVar2;
                i = 2;
            }
        }
        com.taobao.slide.control.a aVar5 = aVar;
        boolean z4 = z3;
        if (aVar5 != null && aVar5.b) {
            u21.a(f(), podDO.name, podDO.ver, 1042, "pea");
        }
        m42.i("Engine", "match end", "pod", podDO);
        return z4;
    }

    private boolean k(String str, String[] strArr, SlideSubscriber.Type type) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (type == SlideSubscriber.Type.EXACT) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (type == SlideSubscriber.Type.PREFIX) {
                if (str.startsWith(str2)) {
                    return true;
                }
            } else if (Pattern.matches(str2, str)) {
                return true;
            }
        }
        return false;
    }

    private void q(List<PodDO> list, PodDO podDO) {
        PodDO podDO2 = this.d.getPodMap().get(podDO.name);
        if (podDO2 == null) {
            this.d.pods.add(podDO);
            list.add(podDO);
            m42.g("Engine", "process add", "name", podDO.name, "version", podDO.ver);
        } else if (nl.h(podDO.ver, podDO2.ver)) {
            Set<String> set = podDO2.notified;
            if (set != null && set.size() > 0) {
                podDO.notified = new HashSet(podDO2.notified);
            }
            this.d.pods.remove(podDO2);
            this.d.pods.add(podDO);
            list.add(podDO);
            m42.g("Engine", "process update", "name", podDO.name, "version", podDO.ver, "oldversion", podDO2.ver);
        }
        this.d.buildPodMap();
    }

    public SlideConfig b() {
        return this.b;
    }

    public Context c() {
        return this.a;
    }

    public AppDO d() {
        return this.d;
    }

    public String e() {
        AppDO appDO = this.d;
        return appDO == null ? "" : appDO.dig;
    }

    public String f() {
        AppDO appDO = this.d;
        return appDO == null ? "0" : appDO.version;
    }

    public void h() {
        try {
            AppDO b = this.c.b("ALIBABA.SLIDE");
            this.d = b;
            if (b == null) {
                m42.k("Engine", "init no local index file", new Object[0]);
                return;
            }
            m42.g("Engine", UCCore.LEGACY_EVENT_INIT, "curAppDO", b);
            this.d.buildPodMap();
            mh1.a(new uc());
            i(this.d.pods, this.e, false);
            o();
        } catch (Throwable th) {
            if (this.d == null) {
                hh1.a(hh1.POINT_CACHE, gn1.TYPE_OPEN_URL_METHOD_GET);
            }
            m42.d("Engine", UCCore.LEGACY_EVENT_INIT, th, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:3:0x001e, B:5:0x002a, B:8:0x002f, B:9:0x0035, B:11:0x003b, B:12:0x0045, B:14:0x0060, B:16:0x0071, B:18:0x0081, B:13:0x0051), top: B:23:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:3:0x001e, B:5:0x002a, B:8:0x002f, B:9:0x0035, B:11:0x003b, B:12:0x0045, B:14:0x0060, B:16:0x0071, B:18:0x0081, B:13:0x0051), top: B:23:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(com.taobao.slide.model.AppDO r7, boolean r8) {
        /*
            r6 = this;
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "newAppDO"
            r2 = 0
            r0[r2] = r1
            r1 = 1
            r0[r1] = r7
            r3 = 2
            java.lang.String r4 = "fromGateway"
            r0[r3] = r4
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r3 = 3
            r0[r3] = r8
            java.lang.String r8 = "Engine"
            java.lang.String r3 = "process"
            tb.m42.g(r8, r3, r0)
            r7.buildPodMap()     // Catch: java.lang.Throwable -> L85
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L85
            r0.<init>()     // Catch: java.lang.Throwable -> L85
            com.taobao.slide.model.AppDO r4 = r6.d     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L51
            java.util.List<com.taobao.slide.model.PodDO> r4 = r4.pods     // Catch: java.lang.Throwable -> L85
            if (r4 != 0) goto L2f
            goto L51
        L2f:
            java.util.List<com.taobao.slide.model.PodDO> r4 = r7.pods     // Catch: java.lang.Throwable -> L85
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L85
        L35:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L85
            if (r5 == 0) goto L45
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L85
            com.taobao.slide.model.PodDO r5 = (com.taobao.slide.model.PodDO) r5     // Catch: java.lang.Throwable -> L85
            r6.q(r0, r5)     // Catch: java.lang.Throwable -> L85
            goto L35
        L45:
            com.taobao.slide.model.AppDO r4 = r6.d     // Catch: java.lang.Throwable -> L85
            java.lang.String r5 = r7.version     // Catch: java.lang.Throwable -> L85
            r4.version = r5     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r7.dig     // Catch: java.lang.Throwable -> L85
            r4.dig = r7     // Catch: java.lang.Throwable -> L85
            r7 = 0
            goto L60
        L51:
            java.lang.String r4 = "process not exist before"
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L85
            tb.m42.g(r8, r4, r5)     // Catch: java.lang.Throwable -> L85
            r6.d = r7     // Catch: java.lang.Throwable -> L85
            java.util.List<com.taobao.slide.model.PodDO> r7 = r7.pods     // Catch: java.lang.Throwable -> L85
            r0.addAll(r7)     // Catch: java.lang.Throwable -> L85
            r7 = 1
        L60:
            java.util.Map<tb.ki2, com.taobao.slide.api.SlideSubscriber> r4 = r6.e     // Catch: java.lang.Throwable -> L85
            r6.i(r0, r4, r1)     // Catch: java.lang.Throwable -> L85
            com.taobao.slide.core.a<com.taobao.slide.model.AppDO> r0 = r6.c     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = "ALIBABA.SLIDE"
            com.taobao.slide.model.AppDO r4 = r6.d     // Catch: java.lang.Throwable -> L85
            boolean r0 = r0.c(r1, r4)     // Catch: java.lang.Throwable -> L85
            if (r0 != 0) goto L7f
            java.lang.String r0 = "process save local fail"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L85
            tb.m42.k(r8, r0, r1)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = "slide_cache"
            java.lang.String r1 = "save"
            tb.hh1.a(r0, r1)     // Catch: java.lang.Throwable -> L85
        L7f:
            if (r7 == 0) goto L8b
            r6.o()     // Catch: java.lang.Throwable -> L85
            goto L8b
        L85:
            r7 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]
            tb.m42.d(r8, r3, r7, r0)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.slide.core.b.l(com.taobao.slide.model.AppDO, boolean):void");
    }

    public void m(PodDO podDO) {
        m42.g("Engine", "process", "pushPod", podDO);
        if (this.d == null) {
            m42.e("Engine", "process receive push befeore init", "pushPod", podDO);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        q(arrayList, podDO);
        i(arrayList, this.e, false);
        if (this.c.c("ALIBABA.SLIDE", this.d)) {
            return;
        }
        m42.k("Engine", "process save local fail", new Object[0]);
        hh1.a(hh1.POINT_CACHE, "save");
    }

    public void n(List<String> list) throws AccsException {
        TraceDO traceDO = new TraceDO();
        TraceDO.Device device = new TraceDO.Device();
        device.app_key = b().getAppKey();
        device.app_ver = com.taobao.slide.control.a.d("app_ver");
        device.did_hash = com.taobao.slide.control.a.d("did_hash");
        device.m_brand = com.taobao.slide.control.a.d(OConstant.CANDIDATE_BRAND);
        device.m_model = com.taobao.slide.control.a.d(OConstant.CANDIDATE_MODEL);
        device.m_vendor = com.taobao.slide.control.a.d("m_vendor");
        device.os_ver = com.taobao.slide.control.a.d(OConstant.CANDIDATE_OSVER);
        traceDO.device = device;
        AppDO d = d();
        if (d.isValid()) {
            traceDO.ver = d.version;
            traceDO.pods = new ArrayList();
            for (String str : list) {
                PodDO podDO = d.getPodMap().get(str);
                TraceDO.PodData podData = new TraceDO.PodData();
                if (podDO == null) {
                    m42.e("Engine", "PushTask trace pod not exist", "name", str);
                } else {
                    String str2 = podDO.name;
                    podData.name = str2;
                    podData.byPush = podDO.pushType;
                    podData.ver = podDO.ver;
                    podData.selectedPea = podDO.latestPeaIndex;
                    podData.subs = g(str2);
                    traceDO.pods.add(podData);
                }
            }
        } else {
            m42.e("Engine", "PushTask trace appdo invalid", new Object[0]);
        }
        JSONObject jSONObject = (JSONObject) ((JSONObject) JSON.toJSON(traceDO)).get("device");
        for (da1 da1Var : com.taobao.slide.control.a.c()) {
            jSONObject.put(da1Var.b(), (Object) da1Var.c());
            m42.g("Engine", "PushTask trace add custom prop", "key", da1Var.b(), "value", da1Var.c());
        }
        String jSONString = JSON.toJSONString(traceDO);
        m42.g("Engine", "PushTask trace", "data", jSONString);
        ACCSClient.getAccsClient().sendData(new ACCSManager.AccsRequest(null, "slider", jSONString.getBytes(), null));
    }

    public void o() throws AccsException {
        Set<PodDO> set = PushTask.waitingPods;
        if (set != null && set.size() > 0) {
            m42.g("Engine", "processWaitingPush", "pushPods", set.toString());
            for (PodDO podDO : set) {
                m(podDO);
            }
            set.clear();
        }
        Set<String> set2 = PushTask.waitingTracePod;
        if (set2 == null || set2.size() <= 0) {
            return;
        }
        m42.g("Engine", "processWaitingPush", "push trace", set2.toString());
        n(new ArrayList(set2));
        set2.clear();
    }

    public void p(ki2 ki2Var, SlideSubscriber slideSubscriber) {
        if (ki2Var != null && !this.e.containsKey(ki2Var)) {
            m42.c("Engine", "subscribe", "subKey", ki2Var.toString(), "subscriber", slideSubscriber.e());
            this.e.put(ki2Var, slideSubscriber);
            ArrayList arrayList = new ArrayList(ki2Var.a.length);
            AppDO appDO = this.d;
            if (appDO != null && appDO.getPodMap() != null) {
                for (String str : ki2Var.a) {
                    PodDO podDO = this.d.getPodMap().get(str);
                    if (podDO != null) {
                        arrayList.add(podDO);
                    }
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put(ki2Var, slideSubscriber);
            i(arrayList, hashMap, false);
            return;
        }
        m42.k("Engine", "subscribe already exist", new Object[0]);
    }
}
