package com.alibaba.android.ultron.vfw.web;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.VesselView;
import java.util.Map;
import tb.ay2;
import tb.j1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class c extends j1 {
    public static final String KEY_USE_BRIDGE = "useBridge";
    private static final Float g = Float.valueOf(375.0f);
    private VesselView c;
    private a d;
    private String e;
    private String f;

    public c(ay2 ay2Var, String str) {
        super(ay2Var);
        this.e = str;
    }

    private String f(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return str;
        }
        if (jSONObject.containsKey(KEY_USE_BRIDGE)) {
            if (Boolean.TRUE.toString().equals(jSONObject.getString(KEY_USE_BRIDGE))) {
                return str;
            }
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            if (entry != null) {
                buildUpon.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return buildUpon.build().toString();
    }

    @Override // tb.j1
    protected void d(@NonNull IDMComponent iDMComponent) {
        if (this.c == null || iDMComponent == null) {
            return;
        }
        JSONObject fields = iDMComponent.getFields();
        String str = this.e;
        if (fields != null) {
            str = f(str, fields);
        }
        if (str == null || !str.equals(this.f)) {
            this.f = str;
            a aVar = new a(this.a);
            this.d = aVar;
            aVar.a(iDMComponent);
            this.c.setVesselViewCallback(this.d);
            this.c.loadUrl(str);
            if (this.c.findViewWithTag(WebMaskView.TAG) == null) {
                this.c.setOnLoadListener(new b(new WebMaskView(this.c, str), str, this.a.k()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // tb.j1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.view.View e(@androidx.annotation.Nullable android.view.ViewGroup r5) {
        /*
            r4 = this;
            com.taobao.vessel.VesselView r0 = new com.taobao.vessel.VesselView
            tb.ay2 r1 = r4.a
            android.content.Context r1 = r1.l()
            r0.<init>(r1)
            r4.c = r0
            java.lang.String r0 = r4.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L20
            tb.ay2 r5 = r4.a
            android.content.Context r5 = r5.l()
            android.view.View r5 = tb.ny2.a(r5)
            return r5
        L20:
            java.lang.String r0 = r4.e
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = "height"
            java.lang.String r1 = r0.getQueryParameter(r1)
            java.lang.String r2 = "width"
            java.lang.String r0 = r0.getQueryParameter(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = -1
            if (r2 != 0) goto L3e
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Exception -> L3e
            goto L3f
        L3e:
            r1 = -1
        L3f:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L4a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L4a
            goto L4b
        L4a:
            r0 = -1
        L4b:
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            r2.<init>(r3, r3)
            if (r1 <= 0) goto L64
            float r1 = (float) r1
            java.lang.Float r3 = com.alibaba.android.ultron.vfw.web.c.g
            float r3 = r3.floatValue()
            float r1 = r1 / r3
            int r3 = r5.getWidth()
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            r2.height = r1
        L64:
            if (r0 <= 0) goto L7e
            r1 = 375(0x177, float:5.25E-43)
            if (r0 <= r1) goto L6c
            r0 = 375(0x177, float:5.25E-43)
        L6c:
            float r0 = (float) r0
            java.lang.Float r1 = com.alibaba.android.ultron.vfw.web.c.g
            float r1 = r1.floatValue()
            float r0 = r0 / r1
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r0 = r0 * r5
            int r5 = (int) r0
            r2.width = r5
        L7e:
            com.taobao.vessel.VesselView r5 = r4.c
            r5.setLayoutParams(r2)
            com.taobao.vessel.VesselView r5 = r4.c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.ultron.vfw.web.c.e(android.view.ViewGroup):android.view.View");
    }

    public void g() {
        VesselView vesselView = this.c;
        if (vesselView == null) {
            return;
        }
        vesselView.onDestroy();
    }
}
