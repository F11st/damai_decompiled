package com.youku.network.a;

import android.text.TextUtils;
import anet.channel.request.ByteArrayEntry;
import anetwork.channel.Header;
import anetwork.channel.Param;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.tao.log.TLog;
import com.ut.device.UTDevice;
import com.youku.android.antiflow.IAntiFlowManager;
import com.youku.httpcommunication.C7925b;
import com.youku.httpcommunication.C7926c;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.C8010f;
import com.youku.network.f.C8011a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.c22;
import tb.mh2;
import tb.sb;

/* compiled from: Taobao */
/* renamed from: com.youku.network.a.d */
/* loaded from: classes3.dex */
public class C7978d<I extends Request, O extends Response> extends AbstractC7975a<I, O> {
    private C7984c a;
    private IAntiFlowManager b;

    public C7978d(IAntiFlowManager iAntiFlowManager) {
        this.b = iAntiFlowManager;
    }

    private List<Param> a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                arrayList.add(new mh2(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    private Request b(C7984c c7984c) {
        this.a = c7984c;
        String antiCookie = this.b.getAntiCookie(c7984c.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            c7984c.a(IRequestConst.COOKIE, antiCookie);
        }
        List<Header> b = b(c7984c.k());
        List<Param> a = a(c7984c.l());
        c22 c22Var = new c22(c7984c.e());
        c22Var.setConnectTimeout(c7984c.f());
        c22Var.setMethod(c7984c.h());
        c22Var.setReadTimeout(c7984c.g());
        c22Var.setFollowRedirects(c7984c.i());
        c22Var.setCharset(c7984c.n());
        if (b != null && b.size() > 0) {
            c22Var.setHeaders(b);
            for (Header header : b) {
                if (IRequestConst.COOKIE.equalsIgnoreCase(header.getName()) && !TextUtils.isEmpty(header.getValue())) {
                    c22Var.setExtProperty("KeepCustomCookie", "true");
                }
            }
        }
        c22Var.setRetryTime(c7984c.j());
        if (a != null && a.size() > 0) {
            c22Var.setParams(a);
        }
        if (!TextUtils.isEmpty(c7984c.m())) {
            c22Var.setBodyEntry(new ByteArrayEntry(c7984c.m().getBytes()));
        }
        if (c7984c.L() != null) {
            C8010f L = c7984c.L();
            ByteArrayEntry byteArrayEntry = new ByteArrayEntry(L.a);
            byteArrayEntry.setContentType(L.b);
            c22Var.setBodyEntry(byteArrayEntry);
        }
        return c22Var;
    }

    private C8004d b(O o) {
        C8004d a = C8004d.a();
        a.b(o.getStatusCode());
        a.a(o.getBytedata());
        a.a(o.getConnHeadFields());
        a.a(o.getDesc());
        a.a(o.getError());
        a.a(o.getStatisticData());
        return a;
    }

    private List<Header> b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null && C7926c.b(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                arrayList.add(new sb(key, value));
            }
        }
        if (C7925b.b) {
            String utdid = UTDevice.getUtdid(C7925b.a);
            sb sbVar = new sb(HttpHeaderConstant.X_UTDID, utdid);
            String str = C8011a.a;
            TLog.logd(str, "x-utdid:" + utdid);
            arrayList.add(sbVar);
        }
        return arrayList;
    }

    public I a(C7984c c7984c) {
        return (I) b(c7984c);
    }

    public C8004d a(O o) {
        return b((C7978d<I, O>) o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.network.a.InterfaceC7976b
    public /* bridge */ /* synthetic */ C8004d a(Object obj) {
        return a((C7978d<I, O>) ((Response) obj));
    }
}
