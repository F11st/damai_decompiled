package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gx1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface AnnotationAndConstantLoader<A, C> {
    @NotNull
    List<A> loadCallableAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadClassAnnotations(@NotNull gx1.C9189a c9189a);

    @NotNull
    List<A> loadEnumEntryAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$EnumEntry protoBuf$EnumEntry);

    @NotNull
    List<A> loadExtensionReceiverParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind);

    @NotNull
    List<A> loadPropertyBackingFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property);

    @Nullable
    C loadPropertyConstant(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull z71 z71Var);

    @NotNull
    List<A> loadPropertyDelegateFieldAnnotations(@NotNull gx1 gx1Var, @NotNull ProtoBuf$Property protoBuf$Property);

    @NotNull
    List<A> loadTypeAnnotations(@NotNull ProtoBuf$Type protoBuf$Type, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadTypeParameterAnnotations(@NotNull ProtoBuf$TypeParameter protoBuf$TypeParameter, @NotNull NameResolver nameResolver);

    @NotNull
    List<A> loadValueParameterAnnotations(@NotNull gx1 gx1Var, @NotNull MessageLite messageLite, @NotNull AnnotatedCallableKind annotatedCallableKind, int i, @NotNull ProtoBuf$ValueParameter protoBuf$ValueParameter);
}
