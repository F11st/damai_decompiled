package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ix1 {

    /* compiled from: Taobao */
    /* renamed from: tb.ix1$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C9290a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ProtoBuf$MemberKind.values().length];
            iArr[ProtoBuf$MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf$MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf$MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf$MemberKind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf$Visibility.values().length];
            iArr3[ProtoBuf$Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf$Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf$Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf$Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf$Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf$Visibility.LOCAL.ordinal()] = 6;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @NotNull
    public static final f70 a(@NotNull hx1 hx1Var, @Nullable ProtoBuf$Visibility protoBuf$Visibility) {
        b41.i(hx1Var, "<this>");
        switch (protoBuf$Visibility == null ? -1 : C9290a.$EnumSwitchMapping$2[protoBuf$Visibility.ordinal()]) {
            case 1:
                f70 f70Var = e70.INTERNAL;
                b41.h(f70Var, "INTERNAL");
                return f70Var;
            case 2:
                f70 f70Var2 = e70.PRIVATE;
                b41.h(f70Var2, "PRIVATE");
                return f70Var2;
            case 3:
                f70 f70Var3 = e70.PRIVATE_TO_THIS;
                b41.h(f70Var3, "PRIVATE_TO_THIS");
                return f70Var3;
            case 4:
                f70 f70Var4 = e70.PROTECTED;
                b41.h(f70Var4, "PROTECTED");
                return f70Var4;
            case 5:
                f70 f70Var5 = e70.PUBLIC;
                b41.h(f70Var5, "PUBLIC");
                return f70Var5;
            case 6:
                f70 f70Var6 = e70.LOCAL;
                b41.h(f70Var6, "LOCAL");
                return f70Var6;
            default:
                f70 f70Var7 = e70.PRIVATE;
                b41.h(f70Var7, "PRIVATE");
                return f70Var7;
        }
    }

    @NotNull
    public static final CallableMemberDescriptor.Kind b(@NotNull hx1 hx1Var, @Nullable ProtoBuf$MemberKind protoBuf$MemberKind) {
        b41.i(hx1Var, "<this>");
        int i = protoBuf$MemberKind == null ? -1 : C9290a.$EnumSwitchMapping$0[protoBuf$MemberKind.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return CallableMemberDescriptor.Kind.DECLARATION;
                    }
                    return CallableMemberDescriptor.Kind.SYNTHESIZED;
                }
                return CallableMemberDescriptor.Kind.DELEGATION;
            }
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        return CallableMemberDescriptor.Kind.DECLARATION;
    }
}
