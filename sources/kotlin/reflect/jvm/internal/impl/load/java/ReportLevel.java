package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.NotNull;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    @NotNull
    public static final C8332a Companion = new C8332a(null);
    @NotNull
    private final String description;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.ReportLevel$a */
    /* loaded from: classes3.dex */
    public static final class C8332a {
        private C8332a() {
        }

        public /* synthetic */ C8332a(k50 k50Var) {
            this();
        }
    }

    ReportLevel(String str) {
        this.description = str;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
