package tb;

import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class oq0 {
    @NotNull
    public static final oq0 INSTANCE = new oq0();

    private oq0() {
    }

    public final int a(@NotNull String str) {
        b41.i(str, "direction");
        if (b41.d(str, Constants.Value.HORIZONTAL)) {
            return 0;
        }
        b41.d(str, LiveBundleLayout.TYPE_VERTICAL);
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069 A[ORIG_RETURN, RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.lz1<tb.hs0> b(@org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r14 = this;
            r0 = 1
            r1 = 0
            if (r15 != 0) goto L6
        L4:
            r2 = 0
            goto L12
        L6:
            int r2 = r15.length()
            if (r2 <= 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 != r0) goto L4
            r2 = 1
        L12:
            if (r2 == 0) goto L69
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "{"
            java.lang.String r4 = ""
            r2 = r15
            java.lang.String r8 = kotlin.text.g.z(r2, r3, r4, r5, r6, r7)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "}"
            java.lang.String r10 = ""
            java.lang.String r2 = kotlin.text.g.z(r8, r9, r10, r11, r12, r13)
            java.lang.String r3 = ","
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 0
            r6 = 6
            java.util.List r2 = kotlin.text.g.t0(r2, r3, r4, r5, r6, r7)
            tb.hs0$b r3 = tb.hs0.Companion
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            tb.hs0 r1 = r3.d(r1)
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            tb.hs0 r0 = r3.d(r0)
            r4 = 2
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            tb.hs0 r4 = r3.d(r4)
            r5 = 3
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            tb.hs0 r2 = r3.d(r2)
            tb.lz1 r3 = new tb.lz1
            r3.<init>(r0, r2, r1, r4)
            goto L6a
        L69:
            r3 = 0
        L6a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.oq0.b(java.lang.String):tb.lz1");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0079 A[ORIG_RETURN, RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Rect c(@org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r14 = this;
            r0 = 1
            r1 = 0
            if (r15 != 0) goto L6
        L4:
            r2 = 0
            goto L12
        L6:
            int r2 = r15.length()
            if (r2 <= 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 != r0) goto L4
            r2 = 1
        L12:
            if (r2 == 0) goto L79
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "{"
            java.lang.String r4 = ""
            r2 = r15
            java.lang.String r8 = kotlin.text.g.z(r2, r3, r4, r5, r6, r7)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "}"
            java.lang.String r10 = ""
            java.lang.String r2 = kotlin.text.g.z(r8, r9, r10, r11, r12, r13)
            java.lang.String r3 = ","
            java.lang.String[] r3 = new java.lang.String[]{r3}
            r4 = 0
            r6 = 6
            java.util.List r2 = kotlin.text.g.t0(r2, r3, r4, r5, r6, r7)
            tb.hs0$b r3 = tb.hs0.Companion
            java.lang.Object r1 = r2.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            tb.hs0 r1 = r3.d(r1)
            int r1 = r1.d()
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            tb.hs0 r0 = r3.d(r0)
            int r0 = r0.d()
            r4 = 2
            java.lang.Object r4 = r2.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            tb.hs0 r4 = r3.d(r4)
            int r4 = r4.d()
            r5 = 3
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            tb.hs0 r2 = r3.d(r2)
            int r2 = r2.d()
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>(r0, r1, r2, r4)
            goto L7a
        L79:
            r3 = 0
        L7a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.oq0.c(java.lang.String):android.graphics.Rect");
    }

    public final int d(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return hs0.Companion.d(str).d();
    }
}
