package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.event.Subject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.q;
import kotlin.collections.r;
import kotlin.collections.w;
import kotlin.collections.x;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.ge1;
import tb.hj;
import tb.j70;
import tb.kk;
import tb.le1;
import tb.ni1;
import tb.pi1;
import tb.tg2;
import tb.ty1;
import tb.wt2;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends le1 {
    static final /* synthetic */ KProperty<Object>[] e = {a12.i(new PropertyReference1Impl(a12.b(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), a12.i(new PropertyReference1Impl(a12.b(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    @NotNull
    private final j70 a;
    @NotNull
    private final Implementation b;
    @NotNull
    private final NotNullLazyValue c;
    @NotNull
    private final NullableLazyValue d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Implementation {
        void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

        @NotNull
        Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

        @NotNull
        Set<ni1> getFunctionNames();

        @Nullable
        TypeAliasDescriptor getTypeAliasByName(@NotNull ni1 ni1Var);

        @NotNull
        Set<ni1> getTypeAliasNames();

        @NotNull
        Set<ni1> getVariableNames();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class NoReorderImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] o = {a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "allProperties", "getAllProperties()Ljava/util/List;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a12.i(new PropertyReference1Impl(a12.b(NoReorderImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        private final List<ProtoBuf$Function> a;
        @NotNull
        private final List<ProtoBuf$Property> b;
        @NotNull
        private final List<ProtoBuf$TypeAlias> c;
        @NotNull
        private final NotNullLazyValue d;
        @NotNull
        private final NotNullLazyValue e;
        @NotNull
        private final NotNullLazyValue f;
        @NotNull
        private final NotNullLazyValue g;
        @NotNull
        private final NotNullLazyValue h;
        @NotNull
        private final NotNullLazyValue i;
        @NotNull
        private final NotNullLazyValue j;
        @NotNull
        private final NotNullLazyValue k;
        @NotNull
        private final NotNullLazyValue l;
        @NotNull
        private final NotNullLazyValue m;
        final /* synthetic */ DeserializedMemberScope n;

        public NoReorderImplementation(@NotNull final DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            b41.i(deserializedMemberScope, "this$0");
            b41.i(list, "functionList");
            b41.i(list2, "propertyList");
            b41.i(list3, "typeAliasList");
            this.n = deserializedMemberScope;
            this.a = list;
            this.b = list2;
            this.c = deserializedMemberScope.j().c().g().getTypeAliasesAllowed() ? list3 : m.g();
            this.d = deserializedMemberScope.j().h().createLazyValue(new Function0<List<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$declaredFunctions$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends SimpleFunctionDescriptor> invoke() {
                    List<? extends SimpleFunctionDescriptor> o2;
                    o2 = DeserializedMemberScope.NoReorderImplementation.this.o();
                    return o2;
                }
            });
            this.e = deserializedMemberScope.j().h().createLazyValue(new Function0<List<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$declaredProperties$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends PropertyDescriptor> invoke() {
                    List<? extends PropertyDescriptor> r;
                    r = DeserializedMemberScope.NoReorderImplementation.this.r();
                    return r;
                }
            });
            this.f = deserializedMemberScope.j().h().createLazyValue(new Function0<List<? extends TypeAliasDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$allTypeAliases$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends TypeAliasDescriptor> invoke() {
                    List<? extends TypeAliasDescriptor> s;
                    s = DeserializedMemberScope.NoReorderImplementation.this.s();
                    return s;
                }
            });
            this.g = deserializedMemberScope.j().h().createLazyValue(new Function0<List<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$allFunctions$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends SimpleFunctionDescriptor> invoke() {
                    List w;
                    List m;
                    List<? extends SimpleFunctionDescriptor> m0;
                    w = DeserializedMemberScope.NoReorderImplementation.this.w();
                    m = DeserializedMemberScope.NoReorderImplementation.this.m();
                    m0 = CollectionsKt___CollectionsKt.m0(w, m);
                    return m0;
                }
            });
            this.h = deserializedMemberScope.j().h().createLazyValue(new Function0<List<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$allProperties$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final List<? extends PropertyDescriptor> invoke() {
                    List x;
                    List n;
                    List<? extends PropertyDescriptor> m0;
                    x = DeserializedMemberScope.NoReorderImplementation.this.x();
                    n = DeserializedMemberScope.NoReorderImplementation.this.n();
                    m0 = CollectionsKt___CollectionsKt.m0(x, n);
                    return m0;
                }
            });
            this.i = deserializedMemberScope.j().h().createLazyValue(new Function0<Map<ni1, ? extends TypeAliasDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$typeAliasesByName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<ni1, ? extends TypeAliasDescriptor> invoke() {
                    List v;
                    int q;
                    int e;
                    int a;
                    v = DeserializedMemberScope.NoReorderImplementation.this.v();
                    q = n.q(v, 10);
                    e = w.e(q);
                    a = ty1.a(e, 16);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(a);
                    for (Object obj : v) {
                        ni1 name = ((TypeAliasDescriptor) obj).getName();
                        b41.h(name, "it.name");
                        linkedHashMap.put(name, obj);
                    }
                    return linkedHashMap;
                }
            });
            this.j = deserializedMemberScope.j().h().createLazyValue(new Function0<Map<ni1, ? extends List<? extends SimpleFunctionDescriptor>>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$functionsByName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<ni1, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
                    List t;
                    t = DeserializedMemberScope.NoReorderImplementation.this.t();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : t) {
                        ni1 name = ((SimpleFunctionDescriptor) obj).getName();
                        b41.h(name, "it.name");
                        Object obj2 = linkedHashMap.get(name);
                        if (obj2 == null) {
                            obj2 = new ArrayList();
                            linkedHashMap.put(name, obj2);
                        }
                        ((List) obj2).add(obj);
                    }
                    return linkedHashMap;
                }
            });
            this.k = deserializedMemberScope.j().h().createLazyValue(new Function0<Map<ni1, ? extends List<? extends PropertyDescriptor>>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$propertiesByName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Map<ni1, ? extends List<? extends PropertyDescriptor>> invoke() {
                    List u;
                    u = DeserializedMemberScope.NoReorderImplementation.this.u();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : u) {
                        ni1 name = ((PropertyDescriptor) obj).getName();
                        b41.h(name, "it.name");
                        Object obj2 = linkedHashMap.get(name);
                        if (obj2 == null) {
                            obj2 = new ArrayList();
                            linkedHashMap.put(name, obj2);
                        }
                        ((List) obj2).add(obj);
                    }
                    return linkedHashMap;
                }
            });
            this.l = deserializedMemberScope.j().h().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$functionNames$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<? extends ni1> invoke() {
                    List<MessageLite> list4;
                    Set<? extends ni1> i;
                    DeserializedMemberScope.NoReorderImplementation noReorderImplementation = DeserializedMemberScope.NoReorderImplementation.this;
                    list4 = noReorderImplementation.a;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    DeserializedMemberScope deserializedMemberScope2 = noReorderImplementation.n;
                    for (MessageLite messageLite : list4) {
                        linkedHashSet.add(pi1.b(deserializedMemberScope2.a.g(), ((ProtoBuf$Function) messageLite).getName()));
                    }
                    i = f0.i(linkedHashSet, deserializedMemberScope.n());
                    return i;
                }
            });
            this.m = deserializedMemberScope.j().h().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$NoReorderImplementation$variableNames$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<? extends ni1> invoke() {
                    List<MessageLite> list4;
                    Set<? extends ni1> i;
                    DeserializedMemberScope.NoReorderImplementation noReorderImplementation = DeserializedMemberScope.NoReorderImplementation.this;
                    list4 = noReorderImplementation.b;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    DeserializedMemberScope deserializedMemberScope2 = noReorderImplementation.n;
                    for (MessageLite messageLite : list4) {
                        linkedHashSet.add(pi1.b(deserializedMemberScope2.a.g(), ((ProtoBuf$Property) messageLite).getName()));
                    }
                    i = f0.i(linkedHashSet, deserializedMemberScope.o());
                    return i;
                }
            });
        }

        private final Map<ni1, TypeAliasDescriptor> A() {
            return (Map) tg2.a(this.i, this, o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> m() {
            Set<ni1> n = this.n.n();
            ArrayList arrayList = new ArrayList();
            for (ni1 ni1Var : n) {
                r.v(arrayList, p(ni1Var));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> n() {
            Set<ni1> o2 = this.n.o();
            ArrayList arrayList = new ArrayList();
            for (ni1 ni1Var : o2) {
                r.v(arrayList, q(ni1Var));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> o() {
            List<ProtoBuf$Function> list = this.a;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                SimpleFunctionDescriptor n = deserializedMemberScope.a.f().n((ProtoBuf$Function) messageLite);
                if (!deserializedMemberScope.r(n)) {
                    n = null;
                }
                if (n != null) {
                    arrayList.add(n);
                }
            }
            return arrayList;
        }

        private final List<SimpleFunctionDescriptor> p(ni1 ni1Var) {
            List<SimpleFunctionDescriptor> w = w();
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : w) {
                if (b41.d(((DeclarationDescriptor) obj).getName(), ni1Var)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.e(ni1Var, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<PropertyDescriptor> q(ni1 ni1Var) {
            List<PropertyDescriptor> x = x();
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : x) {
                if (b41.d(((DeclarationDescriptor) obj).getName(), ni1Var)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.f(ni1Var, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> r() {
            List<ProtoBuf$Property> list = this.b;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                PropertyDescriptor p = deserializedMemberScope.a.f().p((ProtoBuf$Property) messageLite);
                if (p != null) {
                    arrayList.add(p);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TypeAliasDescriptor> s() {
            List<ProtoBuf$TypeAlias> list = this.c;
            DeserializedMemberScope deserializedMemberScope = this.n;
            ArrayList arrayList = new ArrayList();
            for (MessageLite messageLite : list) {
                TypeAliasDescriptor q = deserializedMemberScope.a.f().q((ProtoBuf$TypeAlias) messageLite);
                if (q != null) {
                    arrayList.add(q);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> t() {
            return (List) tg2.a(this.g, this, o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> u() {
            return (List) tg2.a(this.h, this, o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<TypeAliasDescriptor> v() {
            return (List) tg2.a(this.f, this, o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<SimpleFunctionDescriptor> w() {
            return (List) tg2.a(this.d, this, o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<PropertyDescriptor> x() {
            return (List) tg2.a(this.e, this, o[1]);
        }

        private final Map<ni1, Collection<SimpleFunctionDescriptor>> y() {
            return (Map) tg2.a(this.j, this, o[6]);
        }

        private final Map<ni1, Collection<PropertyDescriptor>> z() {
            return (Map) tg2.a(this.k, this, o[7]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            b41.i(collection, "result");
            b41.i(z60Var, "kindFilter");
            b41.i(function1, "nameFilter");
            b41.i(lookupLocation, "location");
            if (z60Var.a(z60.Companion.i())) {
                for (Object obj : u()) {
                    ni1 name = ((PropertyDescriptor) obj).getName();
                    b41.h(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (z60Var.a(z60.Companion.d())) {
                for (Object obj2 : t()) {
                    ni1 name2 = ((SimpleFunctionDescriptor) obj2).getName();
                    b41.h(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            List g;
            List g2;
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            if (!getFunctionNames().contains(ni1Var)) {
                g2 = m.g();
                return g2;
            }
            Collection<SimpleFunctionDescriptor> collection = y().get(ni1Var);
            if (collection != null) {
                return collection;
            }
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            List g;
            List g2;
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            if (!getVariableNames().contains(ni1Var)) {
                g2 = m.g();
                return g2;
            }
            Collection<PropertyDescriptor> collection = z().get(ni1Var);
            if (collection != null) {
                return collection;
            }
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getFunctionNames() {
            return (Set) tg2.a(this.l, this, o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return A().get(ni1Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getTypeAliasNames() {
            List<ProtoBuf$TypeAlias> list = this.c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.n;
            for (MessageLite messageLite : list) {
                linkedHashSet.add(pi1.b(deserializedMemberScope.a.g(), ((ProtoBuf$TypeAlias) messageLite).getName()));
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getVariableNames() {
            return (Set) tg2.a(this.m, this, o[9]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class OptimizedImplementation implements Implementation {
        static final /* synthetic */ KProperty<Object>[] j = {a12.i(new PropertyReference1Impl(a12.b(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), a12.i(new PropertyReference1Impl(a12.b(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull
        private final Map<ni1, byte[]> a;
        @NotNull
        private final Map<ni1, byte[]> b;
        @NotNull
        private final Map<ni1, byte[]> c;
        @NotNull
        private final MemoizedFunctionToNotNull<ni1, Collection<SimpleFunctionDescriptor>> d;
        @NotNull
        private final MemoizedFunctionToNotNull<ni1, Collection<PropertyDescriptor>> e;
        @NotNull
        private final MemoizedFunctionToNullable<ni1, TypeAliasDescriptor> f;
        @NotNull
        private final NotNullLazyValue g;
        @NotNull
        private final NotNullLazyValue h;
        final /* synthetic */ DeserializedMemberScope i;

        public OptimizedImplementation(@NotNull DeserializedMemberScope deserializedMemberScope, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
            Map<ni1, byte[]> i;
            b41.i(deserializedMemberScope, "this$0");
            b41.i(list, "functionList");
            b41.i(list2, "propertyList");
            b41.i(list3, "typeAliasList");
            this.i = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                ni1 b = pi1.b(deserializedMemberScope.a.g(), ((ProtoBuf$Function) ((MessageLite) obj)).getName());
                Object obj2 = linkedHashMap.get(b);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.a = i(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                ni1 b2 = pi1.b(deserializedMemberScope2.a.g(), ((ProtoBuf$Property) ((MessageLite) obj3)).getName());
                Object obj4 = linkedHashMap2.get(b2);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b2, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.b = i(linkedHashMap2);
            if (this.i.j().c().g().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : list3) {
                    ni1 b3 = pi1.b(deserializedMemberScope3.a.g(), ((ProtoBuf$TypeAlias) ((MessageLite) obj5)).getName());
                    Object obj6 = linkedHashMap3.get(b3);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b3, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                i = i(linkedHashMap3);
            } else {
                i = x.i();
            }
            this.c = i;
            this.d = this.i.j().h().createMemoizedFunction(new Function1<ni1, Collection<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$functions$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Collection<SimpleFunctionDescriptor> invoke(@NotNull ni1 ni1Var) {
                    Collection<SimpleFunctionDescriptor> f;
                    b41.i(ni1Var, AdvanceSetting.NETWORK_TYPE);
                    f = DeserializedMemberScope.OptimizedImplementation.this.f(ni1Var);
                    return f;
                }
            });
            this.e = this.i.j().h().createMemoizedFunction(new Function1<ni1, Collection<? extends PropertyDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$properties$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Collection<PropertyDescriptor> invoke(@NotNull ni1 ni1Var) {
                    Collection<PropertyDescriptor> g;
                    b41.i(ni1Var, AdvanceSetting.NETWORK_TYPE);
                    g = DeserializedMemberScope.OptimizedImplementation.this.g(ni1Var);
                    return g;
                }
            });
            this.f = this.i.j().h().createMemoizedFunctionWithNullableValues(new Function1<ni1, TypeAliasDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$typeAliasByName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final TypeAliasDescriptor invoke(@NotNull ni1 ni1Var) {
                    TypeAliasDescriptor h;
                    b41.i(ni1Var, AdvanceSetting.NETWORK_TYPE);
                    h = DeserializedMemberScope.OptimizedImplementation.this.h(ni1Var);
                    return h;
                }
            });
            StorageManager h = this.i.j().h();
            final DeserializedMemberScope deserializedMemberScope4 = this.i;
            this.g = h.createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$functionNames$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<? extends ni1> invoke() {
                    Map map;
                    Set<? extends ni1> i2;
                    map = DeserializedMemberScope.OptimizedImplementation.this.a;
                    i2 = f0.i(map.keySet(), deserializedMemberScope4.n());
                    return i2;
                }
            });
            StorageManager h2 = this.i.j().h();
            final DeserializedMemberScope deserializedMemberScope5 = this.i;
            this.h = h2.createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$OptimizedImplementation$variableNames$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Set<? extends ni1> invoke() {
                    Map map;
                    Set<? extends ni1> i2;
                    map = DeserializedMemberScope.OptimizedImplementation.this.b;
                    i2 = f0.i(map.keySet(), deserializedMemberScope5.o());
                    return i2;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<SimpleFunctionDescriptor> f(ni1 ni1Var) {
            Sequence i;
            List<ProtoBuf$Function> B;
            Map<ni1, byte[]> map = this.a;
            Parser<ProtoBuf$Function> parser = ProtoBuf$Function.PARSER;
            b41.h(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.i;
            byte[] bArr = map.get(ni1Var);
            if (bArr == null) {
                B = null;
            } else {
                i = SequencesKt__SequencesKt.i(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), this.i));
                B = SequencesKt___SequencesKt.B(i);
            }
            if (B == null) {
                B = m.g();
            }
            ArrayList arrayList = new ArrayList(B.size());
            for (ProtoBuf$Function protoBuf$Function : B) {
                MemberDeserializer f = deserializedMemberScope.j().f();
                b41.h(protoBuf$Function, AdvanceSetting.NETWORK_TYPE);
                SimpleFunctionDescriptor n = f.n(protoBuf$Function);
                if (!deserializedMemberScope.r(n)) {
                    n = null;
                }
                if (n != null) {
                    arrayList.add(n);
                }
            }
            deserializedMemberScope.e(ni1Var, arrayList);
            return kk.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<PropertyDescriptor> g(ni1 ni1Var) {
            Sequence i;
            List<ProtoBuf$Property> B;
            Map<ni1, byte[]> map = this.b;
            Parser<ProtoBuf$Property> parser = ProtoBuf$Property.PARSER;
            b41.h(parser, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.i;
            byte[] bArr = map.get(ni1Var);
            if (bArr == null) {
                B = null;
            } else {
                i = SequencesKt__SequencesKt.i(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(parser, new ByteArrayInputStream(bArr), this.i));
                B = SequencesKt___SequencesKt.B(i);
            }
            if (B == null) {
                B = m.g();
            }
            ArrayList arrayList = new ArrayList(B.size());
            for (ProtoBuf$Property protoBuf$Property : B) {
                MemberDeserializer f = deserializedMemberScope.j().f();
                b41.h(protoBuf$Property, AdvanceSetting.NETWORK_TYPE);
                PropertyDescriptor p = f.p(protoBuf$Property);
                if (p != null) {
                    arrayList.add(p);
                }
            }
            deserializedMemberScope.f(ni1Var, arrayList);
            return kk.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TypeAliasDescriptor h(ni1 ni1Var) {
            ProtoBuf$TypeAlias parseDelimitedFrom;
            byte[] bArr = this.c.get(ni1Var);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf$TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.i.j().c().j())) == null) {
                return null;
            }
            return this.i.j().f().q(parseDelimitedFrom);
        }

        private final Map<ni1, byte[]> i(Map<ni1, ? extends Collection<? extends AbstractMessageLite>> map) {
            int e;
            int q;
            e = w.e(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(e);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<AbstractMessageLite> iterable = (Iterable) entry.getValue();
                q = n.q(iterable, 10);
                ArrayList arrayList = new ArrayList(q);
                for (AbstractMessageLite abstractMessageLite : iterable) {
                    abstractMessageLite.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(wt2.INSTANCE);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        public void addFunctionsAndPropertiesTo(@NotNull Collection<DeclarationDescriptor> collection, @NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
            b41.i(collection, "result");
            b41.i(z60Var, "kindFilter");
            b41.i(function1, "nameFilter");
            b41.i(lookupLocation, "location");
            if (z60Var.a(z60.Companion.i())) {
                Set<ni1> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (ni1 ni1Var : variableNames) {
                    if (function1.invoke(ni1Var).booleanValue()) {
                        arrayList.addAll(getContributedVariables(ni1Var, lookupLocation));
                    }
                }
                ge1 ge1Var = ge1.INSTANCE;
                b41.h(ge1Var, "INSTANCE");
                q.u(arrayList, ge1Var);
                collection.addAll(arrayList);
            }
            if (z60Var.a(z60.Companion.d())) {
                Set<ni1> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (ni1 ni1Var2 : functionNames) {
                    if (function1.invoke(ni1Var2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(ni1Var2, lookupLocation));
                    }
                }
                ge1 ge1Var2 = ge1.INSTANCE;
                b41.h(ge1Var2, "INSTANCE");
                q.u(arrayList2, ge1Var2);
                collection.addAll(arrayList2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            List g;
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            if (getFunctionNames().contains(ni1Var)) {
                return this.d.invoke(ni1Var);
            }
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            List g;
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            if (getVariableNames().contains(ni1Var)) {
                return this.e.invoke(ni1Var);
            }
            g = m.g();
            return g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getFunctionNames() {
            return (Set) tg2.a(this.g, this, j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @Nullable
        public TypeAliasDescriptor getTypeAliasByName(@NotNull ni1 ni1Var) {
            b41.i(ni1Var, "name");
            return this.f.invoke(ni1Var);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getTypeAliasNames() {
            return this.c.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.Implementation
        @NotNull
        public Set<ni1> getVariableNames() {
            return (Set) tg2.a(this.h, this, j[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DeserializedMemberScope(@NotNull j70 j70Var, @NotNull List<ProtoBuf$Function> list, @NotNull List<ProtoBuf$Property> list2, @NotNull List<ProtoBuf$TypeAlias> list3, @NotNull final Function0<? extends Collection<ni1>> function0) {
        b41.i(j70Var, c.a);
        b41.i(list, "functionList");
        b41.i(list2, "propertyList");
        b41.i(list3, "typeAliasList");
        b41.i(function0, "classNames");
        this.a = j70Var;
        this.b = h(list, list2, list3);
        this.c = j70Var.h().createLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$classNames$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Set<? extends ni1> invoke() {
                Set<? extends ni1> E0;
                E0 = CollectionsKt___CollectionsKt.E0(function0.invoke());
                return E0;
            }
        });
        this.d = j70Var.h().createNullableLazyValue(new Function0<Set<? extends ni1>>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$classifierNamesLazy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Set<? extends ni1> invoke() {
                DeserializedMemberScope.Implementation implementation;
                Set i;
                Set<? extends ni1> i2;
                Set<ni1> m = DeserializedMemberScope.this.m();
                if (m == null) {
                    return null;
                }
                Set<ni1> k = DeserializedMemberScope.this.k();
                implementation = DeserializedMemberScope.this.b;
                i = f0.i(k, implementation.getTypeAliasNames());
                i2 = f0.i(i, m);
                return i2;
            }
        });
    }

    private final Implementation h(List<ProtoBuf$Function> list, List<ProtoBuf$Property> list2, List<ProtoBuf$TypeAlias> list3) {
        if (this.a.c().g().getPreserveDeclarationsOrdering()) {
            return new NoReorderImplementation(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    private final ClassDescriptor i(ni1 ni1Var) {
        return this.a.c().b(g(ni1Var));
    }

    private final Set<ni1> l() {
        return (Set) tg2.b(this.d, this, e[1]);
    }

    private final TypeAliasDescriptor p(ni1 ni1Var) {
        return this.b.getTypeAliasByName(ni1Var);
    }

    protected abstract void c(@NotNull Collection<DeclarationDescriptor> collection, @NotNull Function1<? super ni1, Boolean> function1);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Collection<DeclarationDescriptor> d(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1, @NotNull LookupLocation lookupLocation) {
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        b41.i(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        z60.a aVar = z60.Companion;
        if (z60Var.a(aVar.g())) {
            c(arrayList, function1);
        }
        this.b.addFunctionsAndPropertiesTo(arrayList, z60Var, function1, lookupLocation);
        if (z60Var.a(aVar.c())) {
            for (ni1 ni1Var : k()) {
                if (function1.invoke(ni1Var).booleanValue()) {
                    kk.a(arrayList, i(ni1Var));
                }
            }
        }
        if (z60Var.a(z60.Companion.h())) {
            for (ni1 ni1Var2 : this.b.getTypeAliasNames()) {
                if (function1.invoke(ni1Var2).booleanValue()) {
                    kk.a(arrayList, this.b.getTypeAliasByName(ni1Var2));
                }
            }
        }
        return kk.c(arrayList);
    }

    protected void e(@NotNull ni1 ni1Var, @NotNull List<SimpleFunctionDescriptor> list) {
        b41.i(ni1Var, "name");
        b41.i(list, "functions");
    }

    protected void f(@NotNull ni1 ni1Var, @NotNull List<PropertyDescriptor> list) {
        b41.i(ni1Var, "name");
        b41.i(list, "descriptors");
    }

    @NotNull
    protected abstract hj g(@NotNull ni1 ni1Var);

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @Nullable
    public Set<ni1> getClassifierNames() {
        return l();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        if (q(ni1Var)) {
            return i(ni1Var);
        }
        if (this.b.getTypeAliasNames().contains(ni1Var)) {
            return p(ni1Var);
        }
        return null;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return this.b.getContributedFunctions(ni1Var, lookupLocation);
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return this.b.getContributedVariables(ni1Var, lookupLocation);
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getFunctionNames() {
        return this.b.getFunctionNames();
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Set<ni1> getVariableNames() {
        return this.b.getVariableNames();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final j70 j() {
        return this.a;
    }

    @NotNull
    public final Set<ni1> k() {
        return (Set) tg2.a(this.c, this, e[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract Set<ni1> m();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<ni1> n();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract Set<ni1> o();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        return k().contains(ni1Var);
    }

    protected boolean r(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        b41.i(simpleFunctionDescriptor, Subject.FUNCTION);
        return true;
    }
}
