package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class o70 extends DeserializedMemberScope {
    @NotNull
    private final PackageFragmentDescriptor f;
    @NotNull
    private final String g;
    @NotNull
    private final hp0 h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public o70(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r17, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r19, @org.jetbrains.annotations.NotNull tb.fc r20, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r21, @org.jetbrains.annotations.NotNull tb.h70 r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends java.util.Collection<tb.ni1>> r24) {
        /*
            r16 = this;
            r6 = r16
            r14 = r17
            r15 = r23
            java.lang.String r0 = "packageDescriptor"
            tb.b41.i(r14, r0)
            java.lang.String r0 = "proto"
            r1 = r18
            tb.b41.i(r1, r0)
            java.lang.String r0 = "nameResolver"
            r2 = r19
            tb.b41.i(r2, r0)
            java.lang.String r0 = "metadataVersion"
            r3 = r20
            tb.b41.i(r3, r0)
            java.lang.String r0 = "components"
            r4 = r22
            tb.b41.i(r4, r0)
            java.lang.String r0 = "debugName"
            tb.b41.i(r15, r0)
            java.lang.String r0 = "classNames"
            r5 = r24
            tb.b41.i(r5, r0)
            tb.er2 r10 = new tb.er2
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r0 = r18.getTypeTable()
            java.lang.String r7 = "proto.typeTable"
            tb.b41.h(r0, r7)
            r10.<init>(r0)
            tb.ix2$a r0 = tb.ix2.Companion
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r7 = r18.getVersionRequirementTable()
            java.lang.String r8 = "proto.versionRequirementTable"
            tb.b41.h(r7, r8)
            tb.ix2 r11 = r0.a(r7)
            r7 = r22
            r8 = r17
            r9 = r19
            r12 = r20
            r13 = r21
            tb.j70 r2 = r7.a(r8, r9, r10, r11, r12, r13)
            java.util.List r3 = r18.getFunctionList()
            java.lang.String r0 = "proto.functionList"
            tb.b41.h(r3, r0)
            java.util.List r4 = r18.getPropertyList()
            java.lang.String r0 = "proto.propertyList"
            tb.b41.h(r4, r0)
            java.util.List r7 = r18.getTypeAliasList()
            java.lang.String r0 = "proto.typeAliasList"
            tb.b41.h(r7, r0)
            r0 = r16
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r6.f = r14
            r6.g = r15
            tb.hp0 r0 = r17.getFqName()
            r6.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o70.<init>(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, tb.fc, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource, tb.h70, java.lang.String, kotlin.jvm.functions.Function0):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    protected void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(collection, "result");
        b41.i(function1, "nameFilter");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    protected hj g(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return new hj(this.h, ni1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        recordLookup(ni1Var, lookupLocation);
        return super.getContributedClassifier(ni1Var, lookupLocation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @Nullable
    public Set<ni1> m() {
        Set<ni1> d;
        d = kotlin.collections.e0.d();
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    public Set<ni1> n() {
        Set<ni1> d;
        d = kotlin.collections.e0.d();
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @NotNull
    public Set<ni1> o() {
        Set<ni1> d;
        d = kotlin.collections.e0.d();
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean q(@NotNull ni1 ni1Var) {
        boolean z;
        b41.i(ni1Var, "name");
        if (super.q(ni1Var)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> k = j().c().k();
        if (!(k instanceof Collection) || !((Collection) k).isEmpty()) {
            for (ClassDescriptorFactory classDescriptorFactory : k) {
                if (classDescriptorFactory.shouldCreateClass(this.h, ni1Var)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        ow2.b(j().c().o(), lookupLocation, this.f, ni1Var);
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    /* renamed from: s */
    public List<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List<DeclarationDescriptor> m0;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        Collection<DeclarationDescriptor> d = d(z60Var, function1, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> k = j().c().k();
        ArrayList arrayList = new ArrayList();
        for (ClassDescriptorFactory classDescriptorFactory : k) {
            kotlin.collections.r.v(arrayList, classDescriptorFactory.getAllContributedClassesIfPossible(this.h));
        }
        m0 = CollectionsKt___CollectionsKt.m0(d, arrayList);
        return m0;
    }

    @NotNull
    public String toString() {
        return this.g;
    }
}
