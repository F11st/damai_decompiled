package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class la0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(com.alibaba.fastjson.JSONObject r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.la0.$ipChange
            java.lang.String r1 = "40869911"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r5 != 0) goto L1a
            return
        L1a:
            java.lang.String r0 = "richTextUrl"
            boolean r1 = r5.containsKey(r0)
            if (r1 == 0) goto L35
            com.alibaba.fastjson.JSONArray r5 = r5.getJSONArray(r0)
            int r0 = r5.size()
            if (r0 <= 0) goto L35
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r5 = r5.toString()
            goto L37
        L35:
            java.lang.String r5 = ""
        L37:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L56
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "url"
            r0.putString(r1, r5)
            android.content.Context r5 = r4.b
            cn.damai.common.nav.DMNav r5 = cn.damai.common.nav.DMNav.from(r5)
            cn.damai.common.nav.DMNav r5 = r5.withExtras(r0)
            java.lang.String r0 = "damai://webview"
            r5.toUri(r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.la0.m(com.alibaba.fastjson.JSONObject):void");
    }

    private void n(IDMComponent iDMComponent) {
        String tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898020568")) {
            ipChange.ipc$dispatch("-898020568", new Object[]{this, iDMComponent});
        } else if (iDMComponent == null || (tag = iDMComponent.getTag()) == null || !tag.equals("dmProtocol")) {
        } else {
            m(iDMComponent.getFields());
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306229795")) {
            ipChange.ipc$dispatch("1306229795", new Object[]{this, np2Var});
        } else if (np2Var == null) {
        } else {
            n(np2Var.a());
        }
    }
}
