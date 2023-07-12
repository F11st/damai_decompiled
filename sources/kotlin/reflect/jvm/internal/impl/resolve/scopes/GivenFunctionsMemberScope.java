package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import tb.a12;
import tb.b41;
import tb.el1;
import tb.kk;
import tb.le1;
import tb.ni1;
import tb.tg2;
import tb.xd2;
import tb.z60;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class GivenFunctionsMemberScope extends le1 {
    static final /* synthetic */ KProperty<Object>[] c = {a12.i(new PropertyReference1Impl(a12.b(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final NotNullLazyValue b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends el1 {
        final /* synthetic */ ArrayList<DeclarationDescriptor> a;
        final /* synthetic */ GivenFunctionsMemberScope b;

        a(ArrayList<DeclarationDescriptor> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
            this.a = arrayList;
            this.b = givenFunctionsMemberScope;
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
            throw new IllegalStateException(("Conflict in scope of " + this.b.e() + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
        }
    }

    public GivenFunctionsMemberScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        b41.i(storageManager, "storageManager");
        b41.i(classDescriptor, "containingClass");
        this.a = classDescriptor;
        this.b = storageManager.createLazyValue(new Function0<List<? extends DeclarationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$allDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends DeclarationDescriptor> invoke() {
                List c2;
                List<? extends DeclarationDescriptor> m0;
                List<FunctionDescriptor> b = GivenFunctionsMemberScope.this.b();
                c2 = GivenFunctionsMemberScope.this.c(b);
                m0 = CollectionsKt___CollectionsKt.m0(b, c2);
                return m0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<DeclarationDescriptor> c(List<? extends FunctionDescriptor> list) {
        Collection<? extends CallableMemberDescriptor> g;
        ArrayList arrayList = new ArrayList(3);
        Collection<z71> supertypes = this.a.getTypeConstructor().getSupertypes();
        b41.h(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        for (z71 z71Var : supertypes) {
            r.v(arrayList2, ResolutionScope.a.a(z71Var.getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            ni1 name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ni1 ni1Var = (ni1) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof FunctionDescriptor);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list2 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.DEFAULT;
                if (booleanValue) {
                    g = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (b41.d(((FunctionDescriptor) obj6).getName(), ni1Var)) {
                            g.add(obj6);
                        }
                    }
                } else {
                    g = m.g();
                }
                overridingUtil.w(ni1Var, list2, g, this.a, new a(arrayList, this));
            }
        }
        return kk.c(arrayList);
    }

    private final List<DeclarationDescriptor> d() {
        return (List) tg2.a(this.b, this, c[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract List<FunctionDescriptor> b();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ClassDescriptor e() {
        return this.a;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        List g;
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        if (z60Var.a(z60.CALLABLES.m())) {
            return d();
        }
        g = m.g();
        return g;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        List<DeclarationDescriptor> d = d();
        xd2 xd2Var = new xd2();
        for (Object obj : d) {
            if ((obj instanceof SimpleFunctionDescriptor) && b41.d(((SimpleFunctionDescriptor) obj).getName(), ni1Var)) {
                xd2Var.add(obj);
            }
        }
        return xd2Var;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        List<DeclarationDescriptor> d = d();
        xd2 xd2Var = new xd2();
        for (Object obj : d) {
            if ((obj instanceof PropertyDescriptor) && b41.d(((PropertyDescriptor) obj).getName(), ni1Var)) {
                xd2Var.add(obj);
            }
        }
        return xd2Var;
    }
}
