package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.data.Constants;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.AbstractC9135fc;
import tb.b41;
import tb.ex1;
import tb.h70;
import tb.hj;
import tb.hp0;
import tb.n70;
import tb.ni1;
import tb.o70;
import tb.oi1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class DeserializedPackageFragmentImpl extends n70 {
    @NotNull
    private final AbstractC9135fc h;
    @Nullable
    private final DeserializedContainerSource i;
    @NotNull
    private final oi1 j;
    @NotNull
    private final ex1 k;
    @Nullable
    private ProtoBuf$PackageFragment l;
    private MemberScope m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(@NotNull hp0 hp0Var, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ProtoBuf$PackageFragment protoBuf$PackageFragment, @NotNull AbstractC9135fc abstractC9135fc, @Nullable DeserializedContainerSource deserializedContainerSource) {
        super(hp0Var, storageManager, moduleDescriptor);
        b41.i(hp0Var, "fqName");
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "module");
        b41.i(protoBuf$PackageFragment, "proto");
        b41.i(abstractC9135fc, "metadataVersion");
        this.h = abstractC9135fc;
        this.i = deserializedContainerSource;
        ProtoBuf$StringTable strings = protoBuf$PackageFragment.getStrings();
        b41.h(strings, "proto.strings");
        ProtoBuf$QualifiedNameTable qualifiedNames = protoBuf$PackageFragment.getQualifiedNames();
        b41.h(qualifiedNames, "proto.qualifiedNames");
        oi1 oi1Var = new oi1(strings, qualifiedNames);
        this.j = oi1Var;
        this.k = new ex1(protoBuf$PackageFragment, oi1Var, abstractC9135fc, new Function1<hj, SourceElement>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$classDataFinder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final SourceElement invoke(@NotNull hj hjVar) {
                DeserializedContainerSource deserializedContainerSource2;
                b41.i(hjVar, AdvanceSetting.NETWORK_TYPE);
                deserializedContainerSource2 = DeserializedPackageFragmentImpl.this.i;
                if (deserializedContainerSource2 == null) {
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    b41.h(sourceElement, "NO_SOURCE");
                    return sourceElement;
                }
                return deserializedContainerSource2;
            }
        });
        this.l = protoBuf$PackageFragment;
    }

    @Override // tb.n70
    public void f(@NotNull h70 h70Var) {
        b41.i(h70Var, Constants.COMPONENT);
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this.l;
        if (protoBuf$PackageFragment != null) {
            this.l = null;
            ProtoBuf$Package protoBuf$Package = protoBuf$PackageFragment.getPackage();
            b41.h(protoBuf$Package, "proto.`package`");
            this.m = new o70(this, protoBuf$Package, this.j, this.h, this.i, h70Var, b41.r("scope of ", this), new Function0<Collection<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$initialize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Collection<? extends ni1> invoke() {
                    int q;
                    Collection<hj> a = DeserializedPackageFragmentImpl.this.d().a();
                    ArrayList<hj> arrayList = new ArrayList();
                    for (Object obj : a) {
                        hj hjVar = (hj) obj;
                        if ((hjVar.l() || ClassDeserializer.Companion.a().contains(hjVar)) ? false : true) {
                            arrayList.add(obj);
                        }
                    }
                    q = C8215n.q(arrayList, 10);
                    ArrayList arrayList2 = new ArrayList(q);
                    for (hj hjVar2 : arrayList) {
                        arrayList2.add(hjVar2.j());
                    }
                    return arrayList2;
                }
            });
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope = this.m;
        if (memberScope == null) {
            b41.A("_memberScope");
            return null;
        }
        return memberScope;
    }

    @Override // tb.n70
    @NotNull
    /* renamed from: h */
    public ex1 d() {
        return this.k;
    }
}
