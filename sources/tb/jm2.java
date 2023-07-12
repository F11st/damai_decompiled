package tb;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jm2 extends v0 {
    public static final String PARSER_TAG = "theme";
    public static final String TYPE_COLOR = "color";
    public static final String TYPE_GRADIENT = "gradient";
    public static final String TYPE_SIZE = "size";
    public static final String TYPE_STRING = "string";

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object evalWithArgs(java.util.List r6, tb.v80 r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto Lc9
            int r1 = r6.size()
            r2 = 3
            if (r1 >= r2) goto Lc
            goto Lc9
        Lc:
            if (r7 == 0) goto L2d
            java.lang.Object r1 = r7.b()
            boolean r1 = r1 instanceof java.util.Map
            if (r1 == 0) goto L2d
            java.lang.Object r7 = r7.b()
            java.util.Map r7 = (java.util.Map) r7
            java.lang.String r1 = "dianmicContextKeyPresenter"
            java.lang.Object r7 = r7.get(r1)
            boolean r1 = r7 instanceof com.alibaba.android.ultron.trade.presenter.a
            if (r1 == 0) goto L2d
            com.alibaba.android.ultron.trade.presenter.a r7 = (com.alibaba.android.ultron.trade.presenter.a) r7
            tb.km2 r7 = r7.getThemeManager()
            goto L2e
        L2d:
            r7 = r0
        L2e:
            r1 = 0
            java.lang.Object r2 = r6.get(r1)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3 = 1
            java.lang.Object r3 = r6.get(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4 = 2
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            if (r7 == 0) goto L50
            java.util.List r7 = r7.c(r3)
            goto L51
        L50:
            r7 = r0
        L51:
            java.lang.String r3 = "gradient"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L71
            android.graphics.drawable.GradientDrawable r7 = tb.rk.a(r7)
            if (r7 == 0) goto L60
            return r7
        L60:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto Lc9
            java.lang.String r7 = "\\|"
            java.lang.String[] r6 = r6.split(r7)
            android.graphics.drawable.GradientDrawable r6 = tb.rk.c(r6)
            return r6
        L71:
            java.lang.String r3 = "color"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto L91
            if (r7 == 0) goto L88
            int r2 = r7.size()
            if (r2 <= 0) goto L88
            java.lang.Object r7 = r7.get(r1)
            r0 = r7
            java.lang.String r0 = (java.lang.String) r0
        L88:
            r7 = -1
            int r1 = tb.rk.e(r0, r7)
            if (r1 == r7) goto L90
            return r0
        L90:
            return r6
        L91:
            java.lang.String r3 = "size"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 == 0) goto Lb2
            if (r7 == 0) goto Lb1
            int r0 = r7.size()
            if (r0 <= 0) goto Lb1
            java.lang.Object r7 = r7.get(r1)
            java.lang.String r7 = (java.lang.String) r7
            boolean r0 = tb.d90.b(r7)
            if (r0 == 0) goto Lb1
            java.lang.String r6 = tb.d90.a(r7)
        Lb1:
            return r6
        Lb2:
            java.lang.String r6 = "string"
            boolean r6 = r6.equalsIgnoreCase(r2)
            if (r6 == 0) goto Lc9
            if (r7 == 0) goto Lc9
            int r6 = r7.size()
            if (r6 <= 0) goto Lc9
            java.lang.Object r6 = r7.get(r1)
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.jm2.evalWithArgs(java.util.List, tb.v80):java.lang.Object");
    }
}
