package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ni1;
import tb.z60;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ResolutionScope {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(ResolutionScope resolutionScope, z60 z60Var, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z60Var = z60.ALL;
                }
                Function1<ni1, Boolean> function12 = function1;
                if ((i & 2) != 0) {
                    function12 = MemberScope.Companion.a();
                }
                return resolutionScope.getContributedDescriptors(z60Var, function12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void b(@NotNull ResolutionScope resolutionScope, @NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation) {
            b41.i(resolutionScope, "this");
            b41.i(ni1Var, "name");
            b41.i(lookupLocation, "location");
            resolutionScope.getContributedFunctions(ni1Var, lookupLocation);
        }
    }

    @Nullable
    ClassifierDescriptor getContributedClassifier(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull z60 z60Var, @NotNull Function1<? super ni1, Boolean> function1);

    @NotNull
    Collection<? extends FunctionDescriptor> getContributedFunctions(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);

    void recordLookup(@NotNull ni1 ni1Var, @NotNull LookupLocation lookupLocation);
}
