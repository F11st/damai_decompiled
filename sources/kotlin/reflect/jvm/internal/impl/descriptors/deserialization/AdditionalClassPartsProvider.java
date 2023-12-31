package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface AdditionalClassPartsProvider {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a implements AdditionalClassPartsProvider {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor) {
            List g;
            b41.i(classDescriptor, "classDescriptor");
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull ni1 ni1Var, @NotNull ClassDescriptor classDescriptor) {
            List g;
            b41.i(ni1Var, "name");
            b41.i(classDescriptor, "classDescriptor");
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<ni1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor) {
            List g;
            b41.i(classDescriptor, "classDescriptor");
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider
        @NotNull
        public Collection<z71> getSupertypes(@NotNull ClassDescriptor classDescriptor) {
            List g;
            b41.i(classDescriptor, "classDescriptor");
            g = m.g();
            return g;
        }
    }

    @NotNull
    Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<SimpleFunctionDescriptor> getFunctions(@NotNull ni1 ni1Var, @NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<ni1> getFunctionsNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    Collection<z71> getSupertypes(@NotNull ClassDescriptor classDescriptor);
}
