package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.f2;
import tb.i62;
import tb.k50;
import tb.lh;
import tb.ni1;
import tb.xd2;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeIntersectionScope extends f2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final MemberScope a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MemberScope a(@NotNull String str, @NotNull Collection<? extends z71> collection) {
            int q;
            b41.i(str, "message");
            b41.i(collection, "types");
            q = n.q(collection, 10);
            ArrayList arrayList = new ArrayList(q);
            for (z71 z71Var : collection) {
                arrayList.add(z71Var.getMemberScope());
            }
            xd2<MemberScope> b = i62.b(arrayList);
            MemberScope b2 = lh.Companion.b(str, b);
            return b.size() <= 1 ? b2 : new TypeIntersectionScope(str, b2, null);
        }
    }

    private TypeIntersectionScope(String str, MemberScope memberScope) {
        this.a = memberScope;
    }

    public /* synthetic */ TypeIntersectionScope(String str, MemberScope memberScope, k50 k50Var) {
        this(str, memberScope);
    }

    @JvmStatic
    @NotNull
    public static final MemberScope c(@NotNull String str, @NotNull Collection<? extends z71> collection) {
        return Companion.a(str, collection);
    }

    @Override // tb.f2
    @NotNull
    protected MemberScope b() {
        return this.a;
    }

    @Override // tb.f2, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List m0;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        Collection<DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(z60Var, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((DeclarationDescriptor) obj) instanceof CallableDescriptor) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        m0 = CollectionsKt___CollectionsKt.m0(OverridingUtilsKt.a((List) pair.component1(), new Function1<CallableDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedDescriptors$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CallableDescriptor invoke(@NotNull CallableDescriptor callableDescriptor) {
                b41.i(callableDescriptor, "$this$selectMostSpecificInEachOverridableGroup");
                return callableDescriptor;
            }
        }), (List) pair.component2());
        return m0;
    }

    @Override // tb.f2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return OverridingUtilsKt.a(super.getContributedFunctions(ni1Var, lookupLocation), new Function1<SimpleFunctionDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedFunctions$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CallableDescriptor invoke(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
                b41.i(simpleFunctionDescriptor, "$this$selectMostSpecificInEachOverridableGroup");
                return simpleFunctionDescriptor;
            }
        });
    }

    @Override // tb.f2, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return OverridingUtilsKt.a(super.getContributedVariables(ni1Var, lookupLocation), new Function1<PropertyDescriptor, CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$getContributedVariables$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CallableDescriptor invoke(@NotNull PropertyDescriptor propertyDescriptor) {
                b41.i(propertyDescriptor, "$this$selectMostSpecificInEachOverridableGroup");
                return propertyDescriptor;
            }
        });
    }
}
