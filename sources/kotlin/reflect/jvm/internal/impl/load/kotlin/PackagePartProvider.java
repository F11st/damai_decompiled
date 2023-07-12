package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PackagePartProvider {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider$a */
    /* loaded from: classes3.dex */
    public static final class C8376a implements PackagePartProvider {
        @NotNull
        public static final C8376a INSTANCE = new C8376a();

        private C8376a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        @NotNull
        public List<String> findPackageParts(@NotNull String str) {
            List<String> g;
            b41.i(str, "packageFqName");
            g = C8214m.g();
            return g;
        }
    }

    @NotNull
    List<String> findPackageParts(@NotNull String str);
}
