package tb;

import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class cu extends com.taobao.android.dinamicx.a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_EVENT_DMAUTOJUMP = -6351583547649020464L;

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    @Override // com.taobao.android.dinamicx.IDXEventHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleEvent(tb.hy r9, java.lang.Object[] r10, com.taobao.android.dinamicx.DXRuntimeContext r11) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.cu.$ipChange
            java.lang.String r1 = "-1784193469"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 4
            r5 = 2
            r6 = 1
            r7 = 3
            if (r2 == 0) goto L1d
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r8
            r2[r6] = r9
            r2[r5] = r10
            r2[r7] = r11
            r0.ipc$dispatch(r1, r2)
            return
        L1d:
            if (r10 == 0) goto Lc1
            int r9 = r10.length
            if (r9 > 0) goto L24
            goto Lc1
        L24:
            int r9 = tb.tq.a(r10)
            if (r9 < r6) goto L33
            r9 = r10[r3]
            boolean r0 = r9 instanceof java.lang.String
            if (r0 == 0) goto L33
            java.lang.String r9 = (java.lang.String) r9
            goto L35
        L33:
            java.lang.String r9 = ""
        L35:
            int r0 = tb.tq.a(r10)
            r1 = 0
            if (r0 < r5) goto L51
            r0 = r10[r6]
            if (r0 == 0) goto L51
            boolean r2 = r0 instanceof com.alibaba.fastjson.JSONArray
            if (r2 == 0) goto L51
            com.alibaba.fastjson.JSONArray r0 = (com.alibaba.fastjson.JSONArray) r0
            int r2 = tb.t41.b(r0)
            if (r2 <= 0) goto L51
            android.os.Bundle r0 = tb.t41.a(r0)
            goto L52
        L51:
            r0 = r1
        L52:
            int r2 = tb.tq.a(r10)
            if (r2 < r7) goto L63
            r2 = r10[r5]
            if (r2 == 0) goto L63
            boolean r3 = r2 instanceof com.alibaba.fastjson.JSONArray
            if (r3 == 0) goto L63
            com.alibaba.fastjson.JSONArray r2 = (com.alibaba.fastjson.JSONArray) r2
            goto L64
        L63:
            r2 = r1
        L64:
            int r3 = tb.tq.a(r10)
            if (r3 < r4) goto L75
            r10 = r10[r7]
            if (r10 == 0) goto L75
            boolean r3 = r10 instanceof com.alibaba.fastjson.JSONArray
            if (r3 == 0) goto L75
            r1 = r10
            com.alibaba.fastjson.JSONArray r1 = (com.alibaba.fastjson.JSONArray) r1
        L75:
            if (r0 != 0) goto L7c
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L7c:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L83
            return
        L83:
            java.lang.String r10 = "damai://"
            boolean r10 = r9.contains(r10)
            if (r10 != 0) goto La8
            java.lang.String r10 = "http"
            boolean r10 = r9.contains(r10)
            if (r10 == 0) goto L94
            goto La8
        L94:
            android.content.Context r10 = r11.getContext()
            cn.damai.common.nav.DMNav r10 = cn.damai.common.nav.DMNav.from(r10)
            cn.damai.common.nav.DMNav r10 = r10.withExtras(r0)
            cn.damai.common.nav.NavUri r9 = cn.damai.common.nav.NavUri.b(r9)
            r10.toUri(r9)
            goto Lb7
        La8:
            android.content.Context r10 = r11.getContext()
            cn.damai.common.nav.DMNav r10 = cn.damai.common.nav.DMNav.from(r10)
            cn.damai.common.nav.DMNav r10 = r10.withExtras(r0)
            r10.toUri(r9)
        Lb7:
            int r9 = tb.t41.b(r2)
            if (r9 >= r7) goto Lbe
            return
        Lbe:
            tb.nd0.a(r2, r1)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.cu.handleEvent(tb.hy, java.lang.Object[], com.taobao.android.dinamicx.DXRuntimeContext):void");
    }
}
