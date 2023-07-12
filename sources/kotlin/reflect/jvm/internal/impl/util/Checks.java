package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ki;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class Checks {
    @Nullable
    private final ni1 a;
    @Nullable
    private final Regex b;
    @Nullable
    private final Collection<ni1> c;
    @NotNull
    private final Function1<FunctionDescriptor, String> d;
    @NotNull
    private final Check[] e;

    /* JADX WARN: Multi-variable type inference failed */
    private Checks(ni1 ni1Var, Regex regex, Collection<ni1> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.a = ni1Var;
        this.b = regex;
        this.c = collection;
        this.d = function1;
        this.e = checkArr;
    }

    @NotNull
    public final ki a(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        Check[] checkArr = this.e;
        int length = checkArr.length;
        int i = 0;
        while (i < length) {
            Check check = checkArr[i];
            i++;
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new ki.b(invoke);
            }
        }
        String invoke2 = this.d.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new ki.b(invoke2);
        }
        return ki.c.INSTANCE;
    }

    public final boolean b(@NotNull FunctionDescriptor functionDescriptor) {
        b41.i(functionDescriptor, "functionDescriptor");
        if (this.a == null || b41.d(functionDescriptor.getName(), this.a)) {
            if (this.b != null) {
                String b = functionDescriptor.getName().b();
                b41.h(b, "functionDescriptor.name.asString()");
                if (!this.b.matches(b)) {
                    return false;
                }
            }
            Collection<ni1> collection = this.c;
            return collection == null || collection.contains(functionDescriptor.getName());
        }
        return false;
    }

    public /* synthetic */ Checks(ni1 ni1Var, Check[] checkArr, Function1 function1, int i, k50 k50Var) {
        this(ni1Var, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.2
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull FunctionDescriptor functionDescriptor) {
                b41.i(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(@NotNull ni1 ni1Var, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this(ni1Var, (Regex) null, (Collection<ni1>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        b41.i(ni1Var, "name");
        b41.i(checkArr, "checks");
        b41.i(function1, "additionalChecks");
    }

    public /* synthetic */ Checks(Regex regex, Check[] checkArr, Function1 function1, int i, k50 k50Var) {
        this(regex, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.3
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull FunctionDescriptor functionDescriptor) {
                b41.i(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(@NotNull Regex regex, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this((ni1) null, regex, (Collection<ni1>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        b41.i(regex, "regex");
        b41.i(checkArr, "checks");
        b41.i(function1, "additionalChecks");
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i, k50 k50Var) {
        this(collection, checkArr, (i & 4) != 0 ? new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.Checks.4
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Void invoke(@NotNull FunctionDescriptor functionDescriptor) {
                b41.i(functionDescriptor, "$this$null");
                return null;
            }
        } : function1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Checks(@NotNull Collection<ni1> collection, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        this((ni1) null, (Regex) null, collection, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        b41.i(collection, "nameList");
        b41.i(checkArr, "checks");
        b41.i(function1, "additionalChecks");
    }
}
