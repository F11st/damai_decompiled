package tb;

import org.jetbrains.annotations.NotNull;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class y60 {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends y60 {
        @NotNull
        public static final a INSTANCE = new a();
        private static final int a;

        static {
            z60.a aVar = z60.Companion;
            a = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        private a() {
        }

        @Override // tb.y60
        public int a() {
            return a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends y60 {
        @NotNull
        public static final b INSTANCE = new b();

        private b() {
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
