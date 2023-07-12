package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class fk2 extends com.taobao.android.dinamicx.expression.parser.a {
    public static final String PARSER_TAG = "theme";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_GRADIENT = "gradient";
    public static final String TYPE_SIZE = "size";
    public static final String TYPE_STRING = "string";

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(java.lang.Object[] r6, com.taobao.android.dinamicx.DXRuntimeContext r7) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto Lc9
            int r1 = r6.length
            r2 = 3
            if (r1 >= r2) goto L9
            goto Lc9
        L9:
            if (r7 == 0) goto L2a
            java.lang.Object r1 = r7.getDxUserContext()
            boolean r1 = r1 instanceof java.util.Map
            if (r1 == 0) goto L2a
            java.lang.Object r7 = r7.getDxUserContext()
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r1 = "dianmicContextKeyPresenter"
            java.lang.Object r7 = r7.get(r1)
            boolean r1 = r7 instanceof com.alibaba.android.ultron.trade.presenter.a
            if (r1 == 0) goto L2a
            com.alibaba.android.ultron.trade.presenter.a r7 = (com.alibaba.android.ultron.trade.presenter.a) r7
            tb.km2 r7 = r7.getThemeManager()
            goto L2b
        L2a:
            r7 = r0
        L2b:
            r1 = 0
            r2 = r6[r1]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 1
            r3 = r6[r3]
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4 = 2
            r6 = r6[r4]
            java.lang.String r6 = java.lang.String.valueOf(r6)
            if (r7 == 0) goto L47
            java.util.List r7 = r7.c(r3)
            goto L48
        L47:
            r7 = r0
        L48:
            java.lang.String r3 = "gradient"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L68
            android.graphics.drawable.GradientDrawable r7 = tb.rk.a(r7)
            if (r7 == 0) goto L57
            return r7
        L57:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto Lc9
            java.lang.String r7 = "\\|"
            java.lang.String[] r6 = r6.split(r7)
            android.graphics.drawable.GradientDrawable r6 = tb.rk.c(r6)
            return r6
        L68:
            java.lang.String r3 = "color"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L88
            if (r7 == 0) goto L7f
            int r2 = r7.size()
            if (r2 <= 0) goto L7f
            java.lang.Object r7 = r7.get(r1)
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L7f:
            r7 = -1
            int r1 = tb.rk.e(r0, r7)
            if (r1 == r7) goto L87
            return r0
        L87:
            return r6
        L88:
            java.lang.String r3 = "size"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto La9
            if (r7 == 0) goto La8
            int r0 = r7.size()
            if (r0 <= 0) goto La8
            java.lang.Object r7 = r7.get(r1)
            java.lang.String r7 = (java.lang.String) r7
            boolean r0 = tb.d90.b(r7)
            if (r0 == 0) goto La8
            java.lang.String r6 = tb.d90.a(r7)
        La8:
            return r6
        La9:
            java.lang.String r3 = "string"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto Lc9
            if (r7 == 0) goto Lc0
            int r2 = r7.size()
            if (r2 <= 0) goto Lc0
            java.lang.Object r7 = r7.get(r1)
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        Lc0:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto Lc7
            goto Lc8
        Lc7:
            r6 = r0
        Lc8:
            return r6
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.fk2.a(java.lang.Object[], com.taobao.android.dinamicx.DXRuntimeContext):java.lang.Object");
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception e) {
            vt2.b("theme", String.valueOf(objArr), e.toString(), String.valueOf(dXRuntimeContext));
            return null;
        }
    }
}
