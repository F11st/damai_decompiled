package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.rs1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PlatformDependentDeclarationFilter {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter$a */
    /* loaded from: classes3.dex */
    public static final class C8308a implements PlatformDependentDeclarationFilter {
        @NotNull
        public static final C8308a INSTANCE = new C8308a();

        private C8308a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            b41.i(classDescriptor, "classDescriptor");
            b41.i(simpleFunctionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter$b */
    /* loaded from: classes3.dex */
    public static final class C8309b implements PlatformDependentDeclarationFilter {
        @NotNull
        public static final C8309b INSTANCE = new C8309b();

        private C8309b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter
        public boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            b41.i(classDescriptor, "classDescriptor");
            b41.i(simpleFunctionDescriptor, "functionDescriptor");
            return !simpleFunctionDescriptor.getAnnotations().hasAnnotation(rs1.a());
        }
    }

    boolean isFunctionAvailable(@NotNull ClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor simpleFunctionDescriptor);
}
