package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface JavaValueParameter extends JavaAnnotationOwner {
    @Nullable
    ni1 getName();

    @NotNull
    JavaType getType();

    boolean isVararg();
}
