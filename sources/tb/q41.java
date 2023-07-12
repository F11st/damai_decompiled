package tb;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class q41 extends ss1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.q41$a */
    /* loaded from: classes3.dex */
    public static final class C9595a {
        @NotNull
        public static final C9595a INSTANCE = new C9595a();
        @JvmField
        @Nullable
        public static final Integer sdkVersion;

        /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
        static {
            /*
                tb.q41$a r0 = new tb.q41$a
                r0.<init>()
                tb.q41.C9595a.INSTANCE = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L1f
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L1f
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L1f
                if (r2 == 0) goto L1f
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L1f
                goto L20
            L1f:
                r1 = r0
            L20:
                if (r1 == 0) goto L2e
                int r2 = r1.intValue()
                if (r2 <= 0) goto L2a
                r2 = 1
                goto L2b
            L2a:
                r2 = 0
            L2b:
                if (r2 == 0) goto L2e
                r0 = r1
            L2e:
                tb.q41.C9595a.sdkVersion = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.q41.C9595a.<clinit>():void");
        }

        private C9595a() {
        }
    }

    private final boolean d(int i) {
        Integer num = C9595a.sdkVersion;
        return num == null || num.intValue() >= i;
    }

    @Override // tb.ss1
    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        b41.i(th, "cause");
        b41.i(th2, "exception");
        if (d(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
