package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        public static boolean a(@NotNull JavaMethod javaMethod) {
            b41.i(javaMethod, "this");
            return javaMethod.getAnnotationParameterDefaultValue() != null;
        }
    }

    @Nullable
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    @NotNull
    JavaType getReturnType();

    @NotNull
    List<JavaValueParameter> getValueParameters();
}
