package tb;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ce extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    @NotNull
    public static final C9000a Companion = new C9000a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.ce$a */
    /* loaded from: classes3.dex */
    public static final class C9000a {
        private C9000a() {
        }

        public /* synthetic */ C9000a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ce a(@NotNull hp0 hp0Var, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull InputStream inputStream, boolean z) {
            be beVar;
            b41.i(hp0Var, "fqName");
            b41.i(storageManager, "storageManager");
            b41.i(moduleDescriptor, "module");
            b41.i(inputStream, "inputStream");
            try {
                be a = be.Companion.a(inputStream);
                if (a == null) {
                    b41.A("version");
                    beVar = null;
                } else {
                    beVar = a;
                }
                if (beVar.h()) {
                    ProtoBuf$PackageFragment parseFrom = ProtoBuf$PackageFragment.parseFrom(inputStream, C8906ae.INSTANCE.e());
                    xj.a(inputStream, null);
                    b41.h(parseFrom, "proto");
                    return new ce(hp0Var, storageManager, moduleDescriptor, parseFrom, a, z, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + be.INSTANCE + ", actual " + a + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    xj.a(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    private ce(hp0 hp0Var, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, be beVar, boolean z) {
        super(hp0Var, storageManager, moduleDescriptor, protoBuf$PackageFragment, beVar, null);
    }

    public /* synthetic */ ce(hp0 hp0Var, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, be beVar, boolean z, k50 k50Var) {
        this(hp0Var, storageManager, moduleDescriptor, protoBuf$PackageFragment, beVar, z);
    }

    @Override // tb.jp1, tb.t40
    @NotNull
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtilsKt.l(this);
    }
}
