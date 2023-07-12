package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.C8203e0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.le1;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MemberScope extends ResolutionScope {
    @NotNull
    public static final Companion Companion = Companion.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();
        @NotNull
        private static final Function1<ni1, Boolean> b = new Function1<ni1, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Companion$ALL_NAME_FILTER$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ni1 ni1Var) {
                b41.i(ni1Var, AdvanceSetting.NETWORK_TYPE);
                return Boolean.TRUE;
            }
        };

        private Companion() {
        }

        @NotNull
        public final Function1<ni1, Boolean> a() {
            return b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$a */
    /* loaded from: classes3.dex */
    public static final class C8498a {
        public static void a(@NotNull MemberScope memberScope, @NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            b41.i(memberScope, "this");
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            ResolutionScope.C8500a.b(memberScope, ni1Var, lookupLocation);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$b */
    /* loaded from: classes3.dex */
    public static final class C8499b extends le1 {
        @NotNull
        public static final C8499b INSTANCE = new C8499b();

        private C8499b() {
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getClassifierNames() {
            Set<ni1> d;
            d = C8203e0.d();
            return d;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getFunctionNames() {
            Set<ni1> d;
            d = C8203e0.d();
            return d;
        }

        @Override // tb.le1, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<ni1> getVariableNames() {
            Set<ni1> d;
            d = C8203e0.d();
            return d;
        }
    }

    @Nullable
    Set<ni1> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    @NotNull
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<ni1> getFunctionNames();

    @NotNull
    Set<ni1> getVariableNames();
}
