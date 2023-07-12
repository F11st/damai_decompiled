package kotlin.reflect.jvm.internal.impl.builtins;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hj;
import tb.ni1;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class UnsignedType {
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    @NotNull
    private final hj arrayClassId;
    @NotNull
    private final hj classId;
    @NotNull
    private final ni1 typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        hj e = hj.e("kotlin/UByte");
        b41.h(e, "fromString(\"kotlin/UByte\")");
        UBYTE = new UnsignedType("UBYTE", 0, e);
        hj e2 = hj.e("kotlin/UShort");
        b41.h(e2, "fromString(\"kotlin/UShort\")");
        USHORT = new UnsignedType("USHORT", 1, e2);
        hj e3 = hj.e("kotlin/UInt");
        b41.h(e3, "fromString(\"kotlin/UInt\")");
        UINT = new UnsignedType("UINT", 2, e3);
        hj e4 = hj.e("kotlin/ULong");
        b41.h(e4, "fromString(\"kotlin/ULong\")");
        ULONG = new UnsignedType("ULONG", 3, e4);
        $VALUES = $values();
    }

    private UnsignedType(String str, int i, hj hjVar) {
        this.classId = hjVar;
        ni1 j = hjVar.j();
        b41.h(j, "classId.shortClassName");
        this.typeName = j;
        this.arrayClassId = new hj(hjVar.h(), ni1.f(b41.r(j.b(), "Array")));
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    @NotNull
    public final hj getArrayClassId() {
        return this.arrayClassId;
    }

    @NotNull
    public final hj getClassId() {
        return this.classId;
    }

    @NotNull
    public final ni1 getTypeName() {
        return this.typeName;
    }
}
