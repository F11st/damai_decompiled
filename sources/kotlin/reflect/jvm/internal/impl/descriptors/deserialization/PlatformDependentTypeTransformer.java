package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;
import tb.hj;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer$a */
    /* loaded from: classes3.dex */
    public static final class C8310a implements PlatformDependentTypeTransformer {
        @NotNull
        public static final C8310a INSTANCE = new C8310a();

        private C8310a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        @NotNull
        public fd2 transformPlatformType(@NotNull hj hjVar, @NotNull fd2 fd2Var) {
            b41.i(hjVar, "classId");
            b41.i(fd2Var, "computedType");
            return fd2Var;
        }
    }

    @NotNull
    fd2 transformPlatformType(@NotNull hj hjVar, @NotNull fd2 fd2Var);
}
