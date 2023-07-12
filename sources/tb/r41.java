package tb;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class r41 extends q41 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static final a INSTANCE = new a();
        @JvmField
        @Nullable
        public static final Integer sdkVersion;

        /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
        static {
            /*
                tb.r41$a r0 = new tb.r41$a
                r0.<init>()
                tb.r41.a.INSTANCE = r0
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
                tb.r41.a.sdkVersion = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.r41.a.<clinit>():void");
        }

        private a() {
        }
    }

    private final boolean d(int i) {
        Integer num = a.sdkVersion;
        return num == null || num.intValue() >= i;
    }

    @Override // tb.ss1
    @NotNull
    public Random b() {
        return d(24) ? new vs1() : super.b();
    }

    @Override // tb.ss1
    @Nullable
    public md1 c(@NotNull MatchResult matchResult, @NotNull String str) {
        b41.i(matchResult, "matchResult");
        b41.i(str, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher != null) {
            n31 n31Var = new n31(matcher.start(str), matcher.end(str) - 1);
            if (n31Var.getStart().intValue() >= 0) {
                String group = matcher.group(str);
                b41.h(group, "matcher.group(name)");
                return new md1(group, n31Var);
            }
            return null;
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
