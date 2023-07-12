package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PackagePartProvider {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements PackagePartProvider {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
        @NotNull
        public List<String> findPackageParts(@NotNull String str) {
            List<String> g;
            b41.i(str, "packageFqName");
            g = m.g();
            return g;
        }
    }

    @NotNull
    List<String> findPackageParts(@NotNull String str);
}
