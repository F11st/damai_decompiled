package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Check {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.util.Check$a */
    /* loaded from: classes3.dex */
    public static final class C8556a {
        @Nullable
        public static String a(@NotNull Check check, @NotNull FunctionDescriptor functionDescriptor) {
            b41.i(check, "this");
            b41.i(functionDescriptor, "functionDescriptor");
            if (check.check(functionDescriptor)) {
                return null;
            }
            return check.getDescription();
        }
    }

    boolean check(@NotNull FunctionDescriptor functionDescriptor);

    @NotNull
    String getDescription();

    @Nullable
    String invoke(@NotNull FunctionDescriptor functionDescriptor);
}
