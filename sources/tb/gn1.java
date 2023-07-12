package tb;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class gn1 extends ib {
    public static final String KET_OPEN_URL_H5_OLD_COMPONENT = "__oldComponent";
    public static final String KEY_H5_DATA_PREFIX = "data=";
    public static final String KEY_H5_POST_DATA = "postdata";
    public static final String KEY_H5_QUERY_DATA = "querydata";
    public static final String KEY_OPEN_URL_H5_IS_POST_URL = "isPostUrl";
    public static final String TYPE_OPEN_URL_H5 = "H5";
    public static final String TYPE_OPEN_URL_METHOD_GET = "get";
    public static final String TYPE_OPEN_URL_METHOD_POST = "post";
    public static final String TYPE_OPEN_URL_NATIVE = "Native";
    public static final String TYPE_OPEN_URL_WEEX = "Weex";
    protected int j = 100;
    private int k = 204800;

    public gn1() {
        a();
    }

    private void m(String str) {
        if (str != null && str.length() >= this.k) {
            HashMap hashMap = new HashMap();
            hashMap.put("intent_size", String.valueOf(str.length()));
            mt2.a("FAIL_BINDER_TRANSATION", "intent has to many data in jump to native ", hashMap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    @Override // tb.ib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(tb.np2 r11) {
        /*
            r10 = this;
            java.lang.String r0 = "OpenUrlSubscriber"
            com.taobao.android.ultron.common.model.IDMEvent r1 = r10.e()
            if (r1 == 0) goto Lbc
            com.alibaba.fastjson.JSONObject r2 = r1.getFields()
            if (r2 != 0) goto L10
            goto Lbc
        L10:
            com.alibaba.fastjson.JSONObject r1 = r1.getFields()
            r2 = 0
            java.lang.String r1 = r1.toJSONString()     // Catch: java.lang.Exception -> L26
            java.lang.Class<com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel> r3 = com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel.class
            java.lang.Object r3 = com.alibaba.fastjson.JSON.parseObject(r1, r3)     // Catch: java.lang.Exception -> L26
            com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel r3 = (com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel) r3     // Catch: java.lang.Exception -> L26
            r10.m(r1)     // Catch: java.lang.Exception -> L25
            goto L30
        L25:
            r2 = r3
        L26:
            java.lang.String r1 = "onHandleEvent JSON.parseObject failed"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            tb.vt2.b(r0, r1)
            r3 = r2
        L30:
            if (r3 != 0) goto L33
            return
        L33:
            java.lang.String r1 = r3.getPageType()
            java.lang.String r2 = r3.getUrl()
            com.alibaba.fastjson.JSONObject r4 = r3.getParams()
            if (r1 == 0) goto Lbc
            if (r2 != 0) goto L45
            goto Lbc
        L45:
            int r5 = r10.j
            r6 = 1
            int r5 = r5 + r6
            r10.j = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "activityRequestCode"
            r11.m(r7, r5)
            r5 = -1
            int r7 = r1.hashCode()
            r8 = 2
            r9 = 0
            switch(r7) {
                case -1968751561: goto L75;
                case 2285: goto L6a;
                case 2692129: goto L5f;
                default: goto L5e;
            }
        L5e:
            goto L7f
        L5f:
            java.lang.String r7 = "Weex"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L68
            goto L7f
        L68:
            r5 = 2
            goto L7f
        L6a:
            java.lang.String r7 = "H5"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L73
            goto L7f
        L73:
            r5 = 1
            goto L7f
        L75:
            java.lang.String r7 = "Native"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L7e
            goto L7f
        L7e:
            r5 = 0
        L7f:
            switch(r5) {
                case 0: goto La5;
                case 1: goto L92;
                case 2: goto L83;
                default: goto L82;
            }
        L82:
            goto Lb3
        L83:
            java.lang.String[] r1 = new java.lang.String[r8]
            java.lang.String r3 = "跳转到weex页面"
            r1[r9] = r3
            r1[r6] = r2
            tb.vt2.b(r0, r1)
            r10.p(r2, r4)
            goto Lb3
        L92:
            java.lang.String[] r1 = new java.lang.String[r8]
            java.lang.String r5 = "跳转到h5页面"
            r1[r9] = r5
            r1[r6] = r2
            tb.vt2.b(r0, r1)
            java.lang.String r0 = r3.getMethod()
            r10.n(r2, r4, r0)
            goto Lb3
        La5:
            java.lang.String[] r1 = new java.lang.String[r8]
            java.lang.String r3 = "跳转到native页面"
            r1[r9] = r3
            r1[r6] = r2
            tb.vt2.b(r0, r1)
            r10.o(r2, r4)
        Lb3:
            com.alibaba.android.ultron.trade.presenter.IPresenter r0 = r10.c
            tb.op2 r0 = r0.getTradeEventHandler()
            r0.n(r11)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.gn1.h(tb.np2):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2;
        String string = jSONObject != null ? jSONObject.getString(KET_OPEN_URL_H5_OLD_COMPONENT) : null;
        if (TextUtils.isEmpty(str2)) {
            str2 = TYPE_OPEN_URL_METHOD_POST;
        }
        if (string == null || jSONObject == null) {
            str2 = TYPE_OPEN_URL_METHOD_GET;
        }
        if (TYPE_OPEN_URL_METHOD_GET.equals(str2)) {
            q4.c().from(this.b).forResult(this.j).toUri(str);
            return;
        }
        Bundle bundle = new Bundle();
        if (string != null) {
            try {
                String encode = Uri.encode(string);
                bundle.putString(KEY_H5_POST_DATA, KEY_H5_DATA_PREFIX + encode);
            } catch (Exception unused) {
                vt2.b("OpenUrlSubscriber", "oldComponent encode 失败", string);
            }
        }
        bundle.putBoolean(KEY_OPEN_URL_H5_IS_POST_URL, true);
        try {
            jSONObject2 = JSON.parseObject(string);
        } catch (Throwable unused2) {
            jSONObject2 = new JSONObject();
        }
        q4.c().from(this.b).forResult(this.j).withExtras(bundle).toUri(q4.c().from(this.b).createPostUri(str, jSONObject2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(String str, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            for (String str2 : jSONObject.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = jSONObject.get(str2);
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Integer) obj).intValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(str2, (String) obj);
                    }
                }
            }
        }
        q4.c().from(this.b).forResult(this.j).withExtras(bundle).toUri(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, JSONObject jSONObject) {
    }
}
