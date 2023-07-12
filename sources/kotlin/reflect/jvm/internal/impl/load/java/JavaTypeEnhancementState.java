package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;
import tb.k50;
import tb.k51;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class JavaTypeEnhancementState {
    @NotNull
    public static final C8330a Companion = new C8330a(null);
    @NotNull
    private static final JavaTypeEnhancementState d = new JavaTypeEnhancementState(k51.b(null, 1, null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    @NotNull
    private final Jsr305Settings a;
    @NotNull
    private final Function1<hp0, ReportLevel> b;
    private final boolean c;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState$a */
    /* loaded from: classes3.dex */
    public static final class C8330a {
        private C8330a() {
        }

        public /* synthetic */ C8330a(k50 k50Var) {
            this();
        }

        @NotNull
        public final JavaTypeEnhancementState a() {
            return JavaTypeEnhancementState.d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaTypeEnhancementState(@NotNull Jsr305Settings jsr305Settings, @NotNull Function1<? super hp0, ? extends ReportLevel> function1) {
        b41.i(jsr305Settings, "jsr305");
        b41.i(function1, "getReportLevelForAnnotation");
        this.a = jsr305Settings;
        this.b = function1;
        this.c = jsr305Settings.d() || function1.invoke(k51.e()) == ReportLevel.IGNORE;
    }

    public final boolean b() {
        return this.c;
    }

    @NotNull
    public final Function1<hp0, ReportLevel> c() {
        return this.b;
    }

    @NotNull
    public final Jsr305Settings d() {
        return this.a;
    }
}
