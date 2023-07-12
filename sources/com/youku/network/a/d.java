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
import com.youku.network.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.c22;
import tb.mh2;
import tb.sb;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class d<I extends Request, O extends Response> extends a<I, O> {
    private com.youku.network.c a;
    private IAntiFlowManager b;

    public d(IAntiFlowManager iAntiFlowManager) {
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

    private Request b(com.youku.network.c cVar) {
        this.a = cVar;
        String antiCookie = this.b.getAntiCookie(cVar.k().get(IRequestConst.COOKIE));
        if (!TextUtils.isEmpty(antiCookie)) {
            cVar.a(IRequestConst.COOKIE, antiCookie);
        }
        List<Header> b = b(cVar.k());
        List<Param> a = a(cVar.l());
        c22 c22Var = new c22(cVar.e());
        c22Var.setConnectTimeout(cVar.f());
        c22Var.setMethod(cVar.h());
        c22Var.setReadTimeout(cVar.g());
        c22Var.setFollowRedirects(cVar.i());
        c22Var.setCharset(cVar.n());
        if (b != null && b.size() > 0) {
            c22Var.setHeaders(b);
            for (Header header : b) {
                if (IRequestConst.COOKIE.equalsIgnoreCase(header.getName()) && !TextUtils.isEmpty(header.getValue())) {
                    c22Var.setExtProperty("KeepCustomCookie", "true");
                }
            }
        }
        c22Var.setRetryTime(cVar.j());
        if (a != null && a.size() > 0) {
            c22Var.setParams(a);
        }
        if (!TextUtils.isEmpty(cVar.m())) {
            c22Var.setBodyEntry(new ByteArrayEntry(cVar.m().getBytes()));
        }
        if (cVar.L() != null) {
            f L = cVar.L();
            ByteArrayEntry byteArrayEntry = new ByteArrayEntry(L.a);
            byteArrayEntry.setContentType(L.b);
            c22Var.setBodyEntry(byteArrayEntry);
        }
        return c22Var;
    }

    private com.youku.network.d b(O o) {
        com.youku.network.d a = com.youku.network.d.a();
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
            if (entry != null && com.youku.httpcommunication.c.b(entry.getKey())) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (IRequestConst.USER_AGENT.equalsIgnoreCase(key)) {
                    value = a(value);
                }
                arrayList.add(new sb(key, value));
            }
        }
        if (com.youku.httpcommunication.b.b) {
            String utdid = UTDevice.getUtdid(com.youku.httpcommunication.b.a);
            sb sbVar = new sb(HttpHeaderConstant.X_UTDID, utdid);
            String str = com.youku.network.f.a.a;
            TLog.logd(str, "x-utdid:" + utdid);
            arrayList.add(sbVar);
        }
        return arrayList;
    }

    public I a(com.youku.network.c cVar) {
        return (I) b(cVar);
    }

    public com.youku.network.d a(O o) {
        return b((d<I, O>) o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.youku.network.a.b
    public /* bridge */ /* synthetic */ com.youku.network.d a(Object obj) {
        return a((d<I, O>) ((Response) obj));
    }
}
