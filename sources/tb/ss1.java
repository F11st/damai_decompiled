package tb;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.jvm.JvmField;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ss1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static final a INSTANCE = new a();
        @JvmField
        @Nullable
        public static final Method addSuppressed;
        @JvmField
        @Nullable
        public static final Method getSuppressed;

        /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[LOOP:0: B:3:0x0015->B:13:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EDGE_INSN: B:24:0x0043->B:15:0x0043 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                tb.ss1$a r0 = new tb.ss1$a
                r0.<init>()
                tb.ss1.a.INSTANCE = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                tb.b41.h(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = tb.b41.d(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                tb.b41.h(r7, r8)
                java.lang.Object r7 = kotlin.collections.e.M(r7)
                boolean r7 = tb.b41.d(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                tb.ss1.a.addSuppressed = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = tb.b41.d(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                tb.ss1.a.getSuppressed = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.ss1.a.<clinit>():void");
        }

        private a() {
        }
    }

    public void a(@NotNull Throwable th, @NotNull Throwable th2) {
        b41.i(th, "cause");
        b41.i(th2, "exception");
        Method method = a.addSuppressed;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    @NotNull
    public Random b() {
        return new qh0();
    }

    @Nullable
    public md1 c(@NotNull MatchResult matchResult, @NotNull String str) {
        b41.i(matchResult, "matchResult");
        b41.i(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
