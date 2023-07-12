package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.le1;
import tb.ni1;
import tb.tg2;
import tb.x60;
import tb.xd2;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum extends le1 {
    static final /* synthetic */ KProperty<Object>[] c = {a12.i(new PropertyReference1Impl(a12.b(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final NotNullLazyValue b;

    public StaticScopeForKotlinEnum(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor) {
        b41.i(storageManager, "storageManager");
        b41.i(classDescriptor, "containingClass");
        this.a = classDescriptor;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.b = storageManager.createLazyValue(new Function0<List<? extends SimpleFunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$functions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends SimpleFunctionDescriptor> invoke() {
                ClassDescriptor classDescriptor2;
                ClassDescriptor classDescriptor3;
                List<? extends SimpleFunctionDescriptor> j;
                classDescriptor2 = StaticScopeForKotlinEnum.this.a;
                classDescriptor3 = StaticScopeForKotlinEnum.this.a;
                j = m.j(x60.d(classDescriptor2), x60.e(classDescriptor3));
                return j;
            }
        });
    }

    private final List<SimpleFunctionDescriptor> e() {
        return (List) tg2.a(this.b, this, c[0]);
    }

    @Nullable
    public Void b(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        return null;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    /* renamed from: c */
    public List<SimpleFunctionDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1) {
        b41.i(z60Var, "kindFilter");
        b41.i(function1, "nameFilter");
        return e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    /* renamed from: d */
    public xd2<SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
        b41.i(ni1Var, "name");
        b41.i(lookupLocation, "location");
        List<SimpleFunctionDescriptor> e = e();
        xd2<SimpleFunctionDescriptor> xd2Var = new xd2<>();
        for (Object obj : e) {
            if (b41.d(((SimpleFunctionDescriptor) obj).getName(), ni1Var)) {
                xd2Var.add(obj);
            }
        }
        return xd2Var;
    }

    @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ ClassifierDescriptor getContributedClassifier(ni1 ni1Var, LookupLocation lookupLocation) {
        return (ClassifierDescriptor) b(ni1Var, lookupLocation);
    }
}
