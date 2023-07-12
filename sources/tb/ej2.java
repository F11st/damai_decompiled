package tb;

import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ej2 {
    @JvmField
    @NotNull
    public static final hp0 KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME = new hp0("kotlin.suspend");
    @JvmField
    @NotNull
    public static final wf KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME_CALLABLE_ID;

    static {
        hp0 hp0Var = C8277c.BUILT_INS_PACKAGE_FQ_NAME;
        ni1 f = ni1.f("suspend");
        b41.h(f, "identifier(\"suspend\")");
        KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME_CALLABLE_ID = new wf(hp0Var, f);
    }
}
