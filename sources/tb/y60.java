package tb;

import org.jetbrains.annotations.NotNull;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class y60 {

    /* compiled from: Taobao */
    /* renamed from: tb.y60$a */
    /* loaded from: classes3.dex */
    public static final class C9951a extends y60 {
        @NotNull
        public static final C9951a INSTANCE = new C9951a();
        private static final int a;

        static {
            z60.C10015a c10015a = z60.Companion;
            a = (~(c10015a.i() | c10015a.d())) & c10015a.b();
        }

        private C9951a() {
        }

        @Override // tb.y60
        public int a() {
            return a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.y60$b */
    /* loaded from: classes3.dex */
    public static final class C9952b extends y60 {
        @NotNull
        public static final C9952b INSTANCE = new C9952b();

        private C9952b() {
        }

        @Override // tb.y60
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
