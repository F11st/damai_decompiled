package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface LookupTracker {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker$a */
    /* loaded from: classes3.dex */
    public static final class C8324a implements LookupTracker {
        @NotNull
        public static final C8324a INSTANCE = new C8324a();

        private C8324a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3) {
            b41.i(str, "filePath");
            b41.i(position, "position");
            b41.i(str2, "scopeFqName");
            b41.i(scopeKind, "scopeKind");
            b41.i(str3, "name");
        }
    }

    boolean getRequiresPosition();

    void record(@NotNull String str, @NotNull Position position, @NotNull String str2, @NotNull ScopeKind scopeKind, @NotNull String str3);
}
