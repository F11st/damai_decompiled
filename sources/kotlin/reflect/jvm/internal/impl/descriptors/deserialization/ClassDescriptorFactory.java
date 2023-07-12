package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hj;
import tb.hp0;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ClassDescriptorFactory {
    @Nullable
    ClassDescriptor createClass(@NotNull hj hjVar);

    @NotNull
    Collection<ClassDescriptor> getAllContributedClassesIfPossible(@NotNull hp0 hp0Var);

    boolean shouldCreateClass(@NotNull hp0 hp0Var, @NotNull ni1 ni1Var);
}
