package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class rp0 extends GivenFunctionsMemberScope {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rp0(@NotNull StorageManager storageManager, @NotNull qp0 qp0Var) {
        super(storageManager, qp0Var);
        b41.i(storageManager, "storageManager");
        b41.i(qp0Var, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @NotNull
    protected List<FunctionDescriptor> b() {
        List<FunctionDescriptor> e;
        List<FunctionDescriptor> e2;
        List<FunctionDescriptor> g;
        int i = a.$EnumSwitchMapping$0[((qp0) e()).o().ordinal()];
        if (i == 1) {
            e = kotlin.collections.l.e(sp0.Factory.a((qp0) e(), false));
            return e;
        } else if (i != 2) {
            g = kotlin.collections.m.g();
            return g;
        } else {
            e2 = kotlin.collections.l.e(sp0.Factory.a((qp0) e(), true));
            return e2;
        }
    }
}
