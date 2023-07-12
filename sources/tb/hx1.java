package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hx1 {
    @NotNull
    public static final hx1 INSTANCE = new hx1();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        static {
            int[] iArr = new int[ProtoBuf$Modality.values().length];
            iArr[ProtoBuf$Modality.FINAL.ordinal()] = 1;
            iArr[ProtoBuf$Modality.OPEN.ordinal()] = 2;
            iArr[ProtoBuf$Modality.ABSTRACT.ordinal()] = 3;
            iArr[ProtoBuf$Modality.SEALED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Modality.values().length];
            iArr2[Modality.FINAL.ordinal()] = 1;
            iArr2[Modality.OPEN.ordinal()] = 2;
            iArr2[Modality.ABSTRACT.ordinal()] = 3;
            iArr2[Modality.SEALED.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            iArr3[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[ProtoBuf$Class.Kind.values().length];
            iArr4[ProtoBuf$Class.Kind.CLASS.ordinal()] = 1;
            iArr4[ProtoBuf$Class.Kind.INTERFACE.ordinal()] = 2;
            iArr4[ProtoBuf$Class.Kind.ENUM_CLASS.ordinal()] = 3;
            iArr4[ProtoBuf$Class.Kind.ENUM_ENTRY.ordinal()] = 4;
            iArr4[ProtoBuf$Class.Kind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr4[ProtoBuf$Class.Kind.OBJECT.ordinal()] = 6;
            iArr4[ProtoBuf$Class.Kind.COMPANION_OBJECT.ordinal()] = 7;
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[ClassKind.values().length];
            iArr5[ClassKind.CLASS.ordinal()] = 1;
            iArr5[ClassKind.INTERFACE.ordinal()] = 2;
            iArr5[ClassKind.ENUM_CLASS.ordinal()] = 3;
            iArr5[ClassKind.ENUM_ENTRY.ordinal()] = 4;
            iArr5[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
            iArr5[ClassKind.OBJECT.ordinal()] = 6;
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[ProtoBuf$TypeParameter.Variance.values().length];
            iArr6[ProtoBuf$TypeParameter.Variance.IN.ordinal()] = 1;
            iArr6[ProtoBuf$TypeParameter.Variance.OUT.ordinal()] = 2;
            iArr6[ProtoBuf$TypeParameter.Variance.INV.ordinal()] = 3;
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[ProtoBuf$Type.Argument.Projection.values().length];
            iArr7[ProtoBuf$Type.Argument.Projection.IN.ordinal()] = 1;
            iArr7[ProtoBuf$Type.Argument.Projection.OUT.ordinal()] = 2;
            iArr7[ProtoBuf$Type.Argument.Projection.INV.ordinal()] = 3;
            iArr7[ProtoBuf$Type.Argument.Projection.STAR.ordinal()] = 4;
            $EnumSwitchMapping$6 = iArr7;
            int[] iArr8 = new int[Variance.values().length];
            iArr8[Variance.IN_VARIANCE.ordinal()] = 1;
            iArr8[Variance.OUT_VARIANCE.ordinal()] = 2;
            iArr8[Variance.INVARIANT.ordinal()] = 3;
            $EnumSwitchMapping$7 = iArr8;
        }
    }

    private hx1() {
    }

    @NotNull
    public final ClassKind a(@Nullable ProtoBuf$Class.Kind kind) {
        switch (kind == null ? -1 : a.$EnumSwitchMapping$3[kind.ordinal()]) {
            case 1:
                return ClassKind.CLASS;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
            default:
                return ClassKind.CLASS;
        }
    }

    @NotNull
    public final Modality b(@Nullable ProtoBuf$Modality protoBuf$Modality) {
        int i = protoBuf$Modality == null ? -1 : a.$EnumSwitchMapping$0[protoBuf$Modality.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return Modality.FINAL;
                    }
                    return Modality.SEALED;
                }
                return Modality.ABSTRACT;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    @NotNull
    public final Variance c(@NotNull ProtoBuf$Type.Argument.Projection projection) {
        b41.i(projection, "projection");
        int i = a.$EnumSwitchMapping$6[projection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException(b41.r("Only IN, OUT and INV are supported. Actual argument: ", projection));
                }
                return Variance.INVARIANT;
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }

    @NotNull
    public final Variance d(@NotNull ProtoBuf$TypeParameter.Variance variance) {
        b41.i(variance, "variance");
        int i = a.$EnumSwitchMapping$5[variance.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return Variance.INVARIANT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return Variance.OUT_VARIANCE;
        }
        return Variance.IN_VARIANCE;
    }
}
