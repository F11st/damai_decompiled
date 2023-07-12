package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.C8212k;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface BuiltInsLoader {
    @NotNull
    public static final Companion Companion = Companion.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();
        @NotNull
        private static final Lazy<BuiltInsLoader> b;

        static {
            Lazy<BuiltInsLoader> a2;
            a2 = C8177b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<BuiltInsLoader>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion$Instance$2
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final BuiltInsLoader invoke() {
                    ServiceLoader load = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
                    b41.h(load, "implementations");
                    BuiltInsLoader builtInsLoader = (BuiltInsLoader) C8212k.Q(load);
                    if (builtInsLoader != null) {
                        return builtInsLoader;
                    }
                    throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
                }
            });
            b = a2;
        }

        private Companion() {
        }

        @NotNull
        public final BuiltInsLoader a() {
            return b.getValue();
        }
    }

    @NotNull
    PackageFragmentProvider createPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull Iterable<? extends ClassDescriptorFactory> iterable, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, boolean z);
}
