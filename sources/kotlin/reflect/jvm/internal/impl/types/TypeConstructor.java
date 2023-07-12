package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b81;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeConstructor extends TypeConstructorMarker {
    @NotNull
    kotlin.reflect.jvm.internal.impl.builtins.b getBuiltIns();

    @Nullable
    ClassifierDescriptor getDeclarationDescriptor();

    @NotNull
    List<TypeParameterDescriptor> getParameters();

    @NotNull
    Collection<z71> getSupertypes();

    boolean isDenotable();

    @NotNull
    TypeConstructor refine(@NotNull b81 b81Var);
}
