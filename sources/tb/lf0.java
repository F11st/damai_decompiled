package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class lf0 extends fn<wt2> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final lf0 a(@NotNull String str) {
            b41.i(str, "message");
            return new b(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends lf0 {
        @NotNull
        private final String b;

        public b(@NotNull String str) {
            b41.i(str, "message");
            this.b = str;
        }

        @Override // tb.fn
        @NotNull
        /* renamed from: d */
        public fd2 a(@NotNull ModuleDescriptor moduleDescriptor) {
            b41.i(moduleDescriptor, "module");
            fd2 j = kf0.j(this.b);
            b41.h(j, "createErrorType(message)");
            return j;
        }

        @Override // tb.fn
        @NotNull
        public String toString() {
            return this.b;
        }
    }

    public lf0() {
        super(wt2.INSTANCE);
    }

    @Override // tb.fn
    @NotNull
    /* renamed from: c */
    public wt2 b() {
        throw new UnsupportedOperationException();
    }
}
