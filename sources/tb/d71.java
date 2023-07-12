package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tb.c71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class d71 implements JvmTypeFactory<c71> {
    @NotNull
    public static final d71 INSTANCE = new d71();

    /* compiled from: Taobao */
    /* renamed from: tb.d71$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C9030a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private d71() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: a */
    public c71 boxType(@NotNull c71 c71Var) {
        b41.i(c71Var, "possiblyPrimitiveType");
        if (c71Var instanceof c71.C8993d) {
            c71.C8993d c8993d = (c71.C8993d) c71Var;
            if (c8993d.i() != null) {
                String f = t61.c(c8993d.i().getWrapperFqName()).f();
                b41.h(f, "byFqNameWithoutInnerClas…apperFqName).internalName");
                return createObjectType(f);
            }
            return c71Var;
        }
        return c71Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: b */
    public c71 createFromString(@NotNull String str) {
        JvmPrimitiveType jvmPrimitiveType;
        c71 c8992c;
        b41.i(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType == null) {
            if (charAt == 'V') {
                return new c71.C8993d(null);
            }
            if (charAt == '[') {
                String substring = str.substring(1);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                c8992c = new c71.C8990a(createFromString(substring));
            } else {
                if (charAt == 'L') {
                    StringsKt__StringsKt.P(str, b90.TokenSEM, false, 2, null);
                }
                String substring2 = str.substring(1, str.length() - 1);
                b41.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                c8992c = new c71.C8992c(substring2);
            }
            return c8992c;
        }
        return new c71.C8993d(jvmPrimitiveType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: c */
    public c71.C8992c createObjectType(@NotNull String str) {
        b41.i(str, "internalName");
        return new c71.C8992c(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: d */
    public c71 createPrimitiveType(@NotNull PrimitiveType primitiveType) {
        b41.i(primitiveType, "primitiveType");
        switch (C9030a.$EnumSwitchMapping$0[primitiveType.ordinal()]) {
            case 1:
                return c71.Companion.a();
            case 2:
                return c71.Companion.c();
            case 3:
                return c71.Companion.b();
            case 4:
                return c71.Companion.h();
            case 5:
                return c71.Companion.f();
            case 6:
                return c71.Companion.e();
            case 7:
                return c71.Companion.g();
            case 8:
                return c71.Companion.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: e */
    public c71 getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    @NotNull
    /* renamed from: f */
    public String toString(@NotNull c71 c71Var) {
        String desc;
        b41.i(c71Var, "type");
        if (c71Var instanceof c71.C8990a) {
            return b41.r(jn1.ARRAY_START_STR, toString(((c71.C8990a) c71Var).i()));
        }
        if (c71Var instanceof c71.C8993d) {
            JvmPrimitiveType i = ((c71.C8993d) c71Var).i();
            return (i == null || (desc = i.getDesc()) == null) ? "V" : desc;
        } else if (c71Var instanceof c71.C8992c) {
            return qb1.LEVEL_L + ((c71.C8992c) c71Var).i() + b90.TokenSEM;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
