package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.event.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.C8205f0;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8220r;
import kotlin.collections.C8225w;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.AbstractC9135fc;
import tb.al1;
import tb.b41;
import tb.b81;
import tb.dj;
import tb.el1;
import tb.er2;
import tb.f70;
import tb.fd2;
import tb.gx1;
import tb.h70;
import tb.hj;
import tb.hp0;
import tb.hx1;
import tb.ix1;
import tb.ix2;
import tb.j70;
import tb.jx1;
import tb.k70;
import tb.l1;
import tb.le1;
import tb.m1;
import tb.ni1;
import tb.ow2;
import tb.p21;
import tb.pi1;
import tb.q21;
import tb.qj;
import tb.ty1;
import tb.we0;
import tb.x60;
import tb.yj0;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor extends l1 implements DeserializedDescriptor {
    @NotNull
    private final ProtoBuf$Class e;
    @NotNull
    private final AbstractC9135fc f;
    @NotNull
    private final SourceElement g;
    @NotNull
    private final hj h;
    @NotNull
    private final Modality i;
    @NotNull
    private final f70 j;
    @NotNull
    private final ClassKind k;
    @NotNull
    private final j70 l;
    @NotNull
    private final le1 m;
    @NotNull
    private final DeserializedClassTypeConstructor n;
    @NotNull
    private final ScopesHolderForClass<DeserializedClassMemberScope> o;
    @Nullable
    private final EnumEntryClassDescriptors p;
    @NotNull
    private final DeclarationDescriptor q;
    @NotNull
    private final NullableLazyValue<ClassConstructorDescriptor> r;
    @NotNull
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> s;
    @NotNull
    private final NullableLazyValue<ClassDescriptor> t;
    @NotNull
    private final NotNullLazyValue<Collection<ClassDescriptor>> u;
    @NotNull
    private final NullableLazyValue<p21<fd2>> v;
    @NotNull
    private final gx1.C9189a w;
    @NotNull
    private final Annotations x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class DeserializedClassMemberScope extends DeserializedMemberScope {
        @NotNull
        private final b81 f;
        @NotNull
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> g;
        @NotNull
        private final NotNullLazyValue<Collection<z71>> h;
        final /* synthetic */ DeserializedClassDescriptor i;

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$a */
        /* loaded from: classes3.dex */
        public static final class C8512a extends el1 {
            final /* synthetic */ List<D> a;

            C8512a(List<D> list) {
                this.a = list;
            }

            @Override // tb.gp1
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                b41.i(callableMemberDescriptor, "fakeOverride");
                OverridingUtil.L(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // tb.el1
            protected void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                b41.i(callableMemberDescriptor, "fromSuper");
                b41.i(callableMemberDescriptor2, "fromCurrent");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DeserializedClassMemberScope(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, tb.b81 r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                tb.b41.i(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                tb.b41.i(r9, r0)
                r7.i = r8
                tb.j70 r2 = r8.s()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.t()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                tb.b41.h(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.t()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                tb.b41.h(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.t()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                tb.b41.h(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.t()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                tb.b41.h(r0, r1)
                tb.j70 r8 = r8.s()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.g()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.C8212k.q(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L5b:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L73
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                tb.ni1 r6 = tb.pi1.b(r8, r6)
                r1.add(r6)
                goto L5b
            L73:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r6.<init>()
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f = r9
                tb.j70 r8 = r7.j()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>()
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.g = r8
                tb.j70 r8 = r7.j()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>()
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.h = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, tb.b81):void");
        }

        private final <D extends CallableMemberDescriptor> void u(ni1 ni1Var, Collection<? extends D> collection, List<D> list) {
            j().c().m().getOverridingUtil().w(ni1Var, collection, new ArrayList(list), v(), new C8512a(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeserializedClassDescriptor v() {
            return this.i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super ni1, Boolean> function1) {
            b41.i(collection, "result");
            b41.i(function1, "nameFilter");
            EnumEntryClassDescriptors enumEntryClassDescriptors = v().p;
            Collection<ClassDescriptor> d = enumEntryClassDescriptors == null ? null : enumEntryClassDescriptors.d();
            if (d == null) {
                d = C8214m.g();
            }
            collection.addAll(d);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void e(@NotNull ni1 ni1Var, @NotNull List<SimpleFunctionDescriptor> list) {
            b41.i(ni1Var, "name");
            b41.i(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (z71 z71Var : this.h.invoke()) {
                arrayList.addAll(z71Var.getMemberScope().getContributedFunctions(ni1Var, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(j().c().c().getFunctions(ni1Var, this.i));
            u(ni1Var, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void f(@NotNull ni1 ni1Var, @NotNull List<PropertyDescriptor> list) {
            b41.i(ni1Var, "name");
            b41.i(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (z71 z71Var : this.h.invoke()) {
                arrayList.addAll(z71Var.getMemberScope().getContributedVariables(ni1Var, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            u(ni1Var, arrayList, list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        protected hj g(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            hj d = this.i.h.d(ni1Var);
            b41.h(d, "classId.createNestedClassId(name)");
            return d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            ClassDescriptor f;
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            recordLookup(ni1Var, lookupLocation);
            EnumEntryClassDescriptors enumEntryClassDescriptors = v().p;
            return (enumEntryClassDescriptors == null || (f = enumEntryClassDescriptors.f(ni1Var)) == null) ? super.getContributedClassifier(ni1Var, lookupLocation) : f;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
            b41.i(z60Var, "kindFilter");
            b41.i(function1, "nameFilter");
            return this.g.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            recordLookup(ni1Var, lookupLocation);
            return super.getContributedFunctions(ni1Var, lookupLocation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            recordLookup(ni1Var, lookupLocation);
            return super.getContributedVariables(ni1Var, lookupLocation);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @Nullable
        public Set<ni1> m() {
            List<z71> supertypes = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z71 z71Var : supertypes) {
                Set<ni1> classifierNames = z71Var.getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                C8220r.v(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<ni1> n() {
            List<z71> supertypes = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z71 z71Var : supertypes) {
                C8220r.v(linkedHashSet, z71Var.getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(j().c().c().getFunctionsNames(this.i));
            return linkedHashSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        public Set<ni1> o() {
            List<z71> supertypes = v().n.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (z71 z71Var : supertypes) {
                C8220r.v(linkedHashSet, z71Var.getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected boolean r(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
            b41.i(simpleFunctionDescriptor, Subject.FUNCTION);
            return j().c().s().isFunctionAvailable(this.i, simpleFunctionDescriptor);
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            ow2.a(j().c().o(), lookupLocation, v(), ni1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class DeserializedClassTypeConstructor extends m1 {
        @NotNull
        private final NotNullLazyValue<List<TypeParameterDescriptor>> d;
        final /* synthetic */ DeserializedClassDescriptor e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeserializedClassTypeConstructor(final DeserializedClassDescriptor deserializedClassDescriptor) {
            super(deserializedClassDescriptor.s().h());
            b41.i(deserializedClassDescriptor, "this$0");
            this.e = deserializedClassDescriptor;
            this.d = deserializedClassDescriptor.s().h().createLazyValue(new Function0<List<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.d(DeserializedClassDescriptor.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public Collection<z71> f() {
            int q;
            List m0;
            List A0;
            int q2;
            hp0 b;
            List<ProtoBuf$Type> l = jx1.l(this.e.t(), this.e.s().j());
            DeserializedClassDescriptor deserializedClassDescriptor = this.e;
            q = C8215n.q(l, 10);
            ArrayList arrayList = new ArrayList(q);
            for (ProtoBuf$Type protoBuf$Type : l) {
                arrayList.add(deserializedClassDescriptor.s().i().q(protoBuf$Type));
            }
            m0 = CollectionsKt___CollectionsKt.m0(arrayList, this.e.s().c().c().getSupertypes(this.e));
            ArrayList<NotFoundClasses.C8294b> arrayList2 = new ArrayList();
            Iterator it = m0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ClassifierDescriptor declarationDescriptor = ((z71) it.next()).c().getDeclarationDescriptor();
                NotFoundClasses.C8294b c8294b = declarationDescriptor instanceof NotFoundClasses.C8294b ? (NotFoundClasses.C8294b) declarationDescriptor : null;
                if (c8294b != null) {
                    arrayList2.add(c8294b);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter i = this.e.s().c().i();
                DeserializedClassDescriptor deserializedClassDescriptor2 = this.e;
                q2 = C8215n.q(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(q2);
                for (NotFoundClasses.C8294b c8294b2 : arrayList2) {
                    hj h = DescriptorUtilsKt.h(c8294b2);
                    String b2 = (h == null || (b = h.b()) == null) ? null : b.b();
                    if (b2 == null) {
                        b2 = c8294b2.getName().b();
                    }
                    arrayList3.add(b2);
                }
                i.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList3);
            }
            A0 = CollectionsKt___CollectionsKt.A0(m0);
            return A0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return this.d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        @NotNull
        public SupertypeLoopChecker j() {
            return SupertypeLoopChecker.C8298a.INSTANCE;
        }

        @Override // tb.m1
        @NotNull
        /* renamed from: q */
        public DeserializedClassDescriptor p() {
            return this.e;
        }

        @NotNull
        public String toString() {
            String ni1Var = this.e.getName().toString();
            b41.h(ni1Var, "name.toString()");
            return ni1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class EnumEntryClassDescriptors {
        @NotNull
        private final Map<ni1, ProtoBuf$EnumEntry> a;
        @NotNull
        private final MemoizedFunctionToNullable<ni1, ClassDescriptor> b;
        @NotNull
        private final NotNullLazyValue<Set<ni1>> c;
        final /* synthetic */ DeserializedClassDescriptor d;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor deserializedClassDescriptor) {
            int q;
            int e;
            int a;
            b41.i(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            List<ProtoBuf$EnumEntry> enumEntryList = deserializedClassDescriptor.t().getEnumEntryList();
            b41.h(enumEntryList, "classProto.enumEntryList");
            q = C8215n.q(enumEntryList, 10);
            e = C8225w.e(q);
            a = ty1.a(e, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(a);
            for (Object obj : enumEntryList) {
                linkedHashMap.put(pi1.b(deserializedClassDescriptor.s().g(), ((ProtoBuf$EnumEntry) obj).getName()), obj);
            }
            this.a = linkedHashMap;
            StorageManager h = this.d.s().h();
            final DeserializedClassDescriptor deserializedClassDescriptor2 = this.d;
            this.b = h.createMemoizedFunctionWithNullableValues(new Function1<ni1, ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final ClassDescriptor invoke(@NotNull ni1 ni1Var) {
                    Map map;
                    NotNullLazyValue notNullLazyValue;
                    b41.i(ni1Var, "name");
                    map = DeserializedClassDescriptor.EnumEntryClassDescriptors.this.a;
                    final ProtoBuf$EnumEntry protoBuf$EnumEntry = (ProtoBuf$EnumEntry) map.get(ni1Var);
                    if (protoBuf$EnumEntry == null) {
                        return null;
                    }
                    final DeserializedClassDescriptor deserializedClassDescriptor3 = deserializedClassDescriptor2;
                    DeserializedClassDescriptor.EnumEntryClassDescriptors enumEntryClassDescriptors = DeserializedClassDescriptor.EnumEntryClassDescriptors.this;
                    StorageManager h2 = deserializedClassDescriptor3.s().h();
                    notNullLazyValue = enumEntryClassDescriptors.c;
                    return we0.f(h2, deserializedClassDescriptor3, ni1Var, notNullLazyValue, new k70(deserializedClassDescriptor3.s().h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final List<? extends AnnotationDescriptor> invoke() {
                            List<? extends AnnotationDescriptor> A0;
                            A0 = CollectionsKt___CollectionsKt.A0(DeserializedClassDescriptor.this.s().c().d().loadEnumEntryAnnotations(DeserializedClassDescriptor.this.x(), protoBuf$EnumEntry));
                            return A0;
                        }
                    }), SourceElement.NO_SOURCE);
                }
            });
            this.c = this.d.s().h().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<? extends ni1> invoke() {
                    Set<? extends ni1> e2;
                    e2 = DeserializedClassDescriptor.EnumEntryClassDescriptors.this.e();
                    return e2;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<ni1> e() {
            Set<ni1> i;
            HashSet hashSet = new HashSet();
            for (z71 z71Var : this.d.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.C8500a.a(z71Var.getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf$Function> functionList = this.d.t().getFunctionList();
            b41.h(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = this.d;
            for (ProtoBuf$Function protoBuf$Function : functionList) {
                hashSet.add(pi1.b(deserializedClassDescriptor.s().g(), protoBuf$Function.getName()));
            }
            List<ProtoBuf$Property> propertyList = this.d.t().getPropertyList();
            b41.h(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = this.d;
            for (ProtoBuf$Property protoBuf$Property : propertyList) {
                hashSet.add(pi1.b(deserializedClassDescriptor2.s().g(), protoBuf$Property.getName()));
            }
            i = C8205f0.i(hashSet, hashSet);
            return i;
        }

        @NotNull
        public final Collection<ClassDescriptor> d() {
            Set<ni1> keySet = this.a.keySet();
            ArrayList arrayList = new ArrayList();
            for (ni1 ni1Var : keySet) {
                ClassDescriptor f = f(ni1Var);
                if (f != null) {
                    arrayList.add(f);
                }
            }
            return arrayList;
        }

        @Nullable
        public final ClassDescriptor f(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return this.b.invoke(ni1Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(@NotNull j70 j70Var, @NotNull ProtoBuf$Class protoBuf$Class, @NotNull NameResolver nameResolver, @NotNull AbstractC9135fc abstractC9135fc, @NotNull SourceElement sourceElement) {
        super(j70Var.h(), pi1.a(nameResolver, protoBuf$Class.getFqName()).j());
        Annotations al1Var;
        b41.i(j70Var, "outerContext");
        b41.i(protoBuf$Class, "classProto");
        b41.i(nameResolver, "nameResolver");
        b41.i(abstractC9135fc, "metadataVersion");
        b41.i(sourceElement, "sourceElement");
        this.e = protoBuf$Class;
        this.f = abstractC9135fc;
        this.g = sourceElement;
        this.h = pi1.a(nameResolver, protoBuf$Class.getFqName());
        hx1 hx1Var = hx1.INSTANCE;
        this.i = hx1Var.b(yj0.MODALITY.d(protoBuf$Class.getFlags()));
        this.j = ix1.a(hx1Var, yj0.VISIBILITY.d(protoBuf$Class.getFlags()));
        ClassKind a = hx1Var.a(yj0.CLASS_KIND.d(protoBuf$Class.getFlags()));
        this.k = a;
        List<ProtoBuf$TypeParameter> typeParameterList = protoBuf$Class.getTypeParameterList();
        b41.h(typeParameterList, "classProto.typeParameterList");
        ProtoBuf$TypeTable typeTable = protoBuf$Class.getTypeTable();
        b41.h(typeTable, "classProto.typeTable");
        er2 er2Var = new er2(typeTable);
        ix2.C9291a c9291a = ix2.Companion;
        ProtoBuf$VersionRequirementTable versionRequirementTable = protoBuf$Class.getVersionRequirementTable();
        b41.h(versionRequirementTable, "classProto.versionRequirementTable");
        j70 a2 = j70Var.a(this, typeParameterList, nameResolver, er2Var, c9291a.a(versionRequirementTable), abstractC9135fc);
        this.l = a2;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.m = a == classKind ? new StaticScopeForKotlinEnum(a2.h(), this) : MemberScope.C8499b.INSTANCE;
        this.n = new DeserializedClassTypeConstructor(this);
        this.o = ScopesHolderForClass.Companion.a(this, a2.h(), a2.c().m().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        this.p = a == classKind ? new EnumEntryClassDescriptors(this) : null;
        DeclarationDescriptor e = j70Var.e();
        this.q = e;
        this.r = a2.h().createNullableLazyValue(new Function0<ClassConstructorDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$primaryConstructor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ClassConstructorDescriptor invoke() {
                ClassConstructorDescriptor p;
                p = DeserializedClassDescriptor.this.p();
                return p;
            }
        });
        this.s = a2.h().createLazyValue(new Function0<Collection<? extends ClassConstructorDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$constructors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends ClassConstructorDescriptor> invoke() {
                Collection<? extends ClassConstructorDescriptor> n;
                n = DeserializedClassDescriptor.this.n();
                return n;
            }
        });
        this.t = a2.h().createNullableLazyValue(new Function0<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$companionObjectDescriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ClassDescriptor invoke() {
                ClassDescriptor m;
                m = DeserializedClassDescriptor.this.m();
                return m;
            }
        });
        this.u = a2.h().createLazyValue(new Function0<Collection<? extends ClassDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$sealedSubclasses$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Collection<? extends ClassDescriptor> invoke() {
                Collection<? extends ClassDescriptor> r;
                r = DeserializedClassDescriptor.this.r();
                return r;
            }
        });
        this.v = a2.h().createNullableLazyValue(new Function0<p21<fd2>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$inlineClassRepresentation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final p21<fd2> invoke() {
                p21<fd2> o;
                o = DeserializedClassDescriptor.this.o();
                return o;
            }
        });
        NameResolver g = a2.g();
        er2 j = a2.j();
        DeserializedClassDescriptor deserializedClassDescriptor = e instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e : null;
        this.w = new gx1.C9189a(protoBuf$Class, g, j, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.w : null);
        if (!yj0.HAS_ANNOTATIONS.d(protoBuf$Class.getFlags()).booleanValue()) {
            al1Var = Annotations.Companion.b();
        } else {
            al1Var = new al1(a2.h(), new Function0<List<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$annotations$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends AnnotationDescriptor> invoke() {
                    List<? extends AnnotationDescriptor> A0;
                    A0 = CollectionsKt___CollectionsKt.A0(DeserializedClassDescriptor.this.s().c().d().loadClassAnnotations(DeserializedClassDescriptor.this.x()));
                    return A0;
                }
            });
        }
        this.x = al1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDescriptor m() {
        if (this.e.hasCompanionObjectName()) {
            ClassifierDescriptor contributedClassifier = u().getContributedClassifier(pi1.b(this.l.g(), this.e.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<ClassConstructorDescriptor> n() {
        List k;
        List m0;
        List m02;
        List<ClassConstructorDescriptor> q = q();
        k = C8214m.k(getUnsubstitutedPrimaryConstructor());
        m0 = CollectionsKt___CollectionsKt.m0(q, k);
        m02 = CollectionsKt___CollectionsKt.m0(m0, this.l.c().c().getConstructors(this));
        return m02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p21<fd2> o() {
        ni1 name;
        Object obj = null;
        if (q21.b(this)) {
            if (this.e.hasInlineClassUnderlyingPropertyName()) {
                name = pi1.b(this.l.g(), this.e.getInlineClassUnderlyingPropertyName());
            } else if (!this.f.c(1, 5, 1)) {
                ClassConstructorDescriptor unsubstitutedPrimaryConstructor = getUnsubstitutedPrimaryConstructor();
                if (unsubstitutedPrimaryConstructor != null) {
                    List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                    b41.h(valueParameters, "constructor.valueParameters");
                    name = ((ValueParameterDescriptor) C8212k.P(valueParameters)).getName();
                    b41.h(name, "{\n                // Bef…irst().name\n            }");
                } else {
                    throw new IllegalStateException(b41.r("Inline class has no primary constructor: ", this).toString());
                }
            } else {
                throw new IllegalStateException(b41.r("Inline class has no underlying property name in metadata: ", this).toString());
            }
            ProtoBuf$Type f = jx1.f(this.e, this.l.j());
            fd2 o = f == null ? null : TypeDeserializer.o(this.l.i(), f, false, 2, null);
            if (o == null) {
                Iterator<T> it = u().getContributedVariables(name, NoLookupLocation.FROM_DESERIALIZATION).iterator();
                Object obj2 = null;
                boolean z = false;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (((PropertyDescriptor) next).getExtensionReceiverParameter() == null) {
                            if (z) {
                                break;
                            }
                            obj2 = next;
                            z = true;
                        }
                    } else if (z) {
                        obj = obj2;
                    }
                }
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
                if (propertyDescriptor != null) {
                    o = (fd2) propertyDescriptor.getType();
                } else {
                    throw new IllegalStateException(b41.r("Inline class has no underlying property: ", this).toString());
                }
            }
            return new p21<>(name, o);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassConstructorDescriptor p() {
        Object obj;
        if (this.k.isSingleton()) {
            dj i = x60.i(this, SourceElement.NO_SOURCE);
            i.A(getDefaultType());
            return i;
        }
        List<ProtoBuf$Constructor> constructorList = this.e.getConstructorList();
        b41.h(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!yj0.IS_SECONDARY.d(((ProtoBuf$Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) obj;
        if (protoBuf$Constructor == null) {
            return null;
        }
        return s().f().m(protoBuf$Constructor, true);
    }

    private final List<ClassConstructorDescriptor> q() {
        int q;
        List<ProtoBuf$Constructor> constructorList = this.e.getConstructorList();
        b41.h(constructorList, "classProto.constructorList");
        ArrayList<ProtoBuf$Constructor> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            Boolean d = yj0.IS_SECONDARY.d(((ProtoBuf$Constructor) obj).getFlags());
            b41.h(d, "IS_SECONDARY.get(it.flags)");
            if (d.booleanValue()) {
                arrayList.add(obj);
            }
        }
        q = C8215n.q(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(q);
        for (ProtoBuf$Constructor protoBuf$Constructor : arrayList) {
            MemberDeserializer f = s().f();
            b41.h(protoBuf$Constructor, AdvanceSetting.NETWORK_TYPE);
            arrayList2.add(f.m(protoBuf$Constructor, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<ClassDescriptor> r() {
        List g;
        if (this.i != Modality.SEALED) {
            g = C8214m.g();
            return g;
        }
        List<Integer> sealedSubclassFqNameList = this.e.getSealedSubclassFqNameList();
        b41.h(sealedSubclassFqNameList, "fqNames");
        if (!sealedSubclassFqNameList.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer num : sealedSubclassFqNameList) {
                h70 c = s().c();
                NameResolver g2 = s().g();
                b41.h(num, "index");
                ClassDescriptor b = c.b(pi1.a(g2, num.intValue()));
                if (b != null) {
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return qj.INSTANCE.a(this, false);
    }

    private final DeserializedClassMemberScope u() {
        return this.o.c(this.l.c().m().getKotlinTypeRefiner());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.wg1
    @NotNull
    public MemberScope b(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this.o.c(b81Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.t.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return this.s.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.l.i().k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public p21<fd2> getInlineClassRepresentation() {
        return this.v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        return this.k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return this.u.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    @NotNull
    public SourceElement getSource() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.r.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public f70 getVisibility() {
        return this.j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return yj0.CLASS_KIND.d(this.e.getFlags()) == ProtoBuf$Class.Kind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        Boolean d = yj0.IS_DATA.d(this.e.getFlags());
        b41.h(d, "IS_DATA.get(classProto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        Boolean d = yj0.IS_EXPECT_CLASS.d(this.e.getFlags());
        b41.h(d, "IS_EXPECT_CLASS.get(classProto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        Boolean d = yj0.IS_EXTERNAL_CLASS.d(this.e.getFlags());
        b41.h(d, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        Boolean d = yj0.IS_FUN_INTERFACE.d(this.e.getFlags());
        b41.h(d, "IS_FUN_INTERFACE.get(classProto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        Boolean d = yj0.IS_INLINE_CLASS.d(this.e.getFlags());
        b41.h(d, "IS_INLINE_CLASS.get(classProto.flags)");
        return d.booleanValue() && this.f.e(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean d = yj0.IS_INNER.d(this.e.getFlags());
        b41.h(d, "IS_INNER.get(classProto.flags)");
        return d.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        Boolean d = yj0.IS_INLINE_CLASS.d(this.e.getFlags());
        b41.h(d, "IS_INLINE_CLASS.get(classProto.flags)");
        return d.booleanValue() && this.f.c(1, 4, 2);
    }

    @NotNull
    public final j70 s() {
        return this.l;
    }

    @NotNull
    public final ProtoBuf$Class t() {
        return this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(isExpect() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @NotNull
    public final AbstractC9135fc v() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    /* renamed from: w */
    public le1 getStaticScope() {
        return this.m;
    }

    @NotNull
    public final gx1.C9189a x() {
        return this.w;
    }

    public final boolean y(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return u().k().contains(ni1Var);
    }
}
