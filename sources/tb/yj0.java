package tb;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class yj0 {
    public static final d<ProtoBuf$Class.Kind> CLASS_KIND;
    public static final b DECLARES_DEFAULT_VALUE;
    public static final b DEFINITELY_NOT_NULL_TYPE;
    public static final b HAS_ANNOTATIONS;
    public static final b HAS_CONSTANT;
    public static final b HAS_GETTER;
    public static final b HAS_SETTER;
    public static final b IS_CONST;
    public static final b IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final b IS_CROSSINLINE;
    public static final b IS_DATA;
    public static final b IS_DELEGATED;
    public static final b IS_EXPECT_CLASS;
    public static final b IS_EXPECT_FUNCTION;
    public static final b IS_EXPECT_PROPERTY;
    public static final b IS_EXTERNAL_ACCESSOR;
    public static final b IS_EXTERNAL_CLASS;
    public static final b IS_EXTERNAL_FUNCTION;
    public static final b IS_EXTERNAL_PROPERTY;
    public static final b IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final b IS_FUN_INTERFACE;
    public static final b IS_INFIX;
    public static final b IS_INLINE;
    public static final b IS_INLINE_ACCESSOR;
    public static final b IS_INLINE_CLASS;
    public static final b IS_INNER;
    public static final b IS_LATEINIT;
    public static final b IS_NEGATED;
    public static final b IS_NOINLINE;
    public static final b IS_NOT_DEFAULT;
    public static final b IS_NULL_CHECK_PREDICATE;
    public static final b IS_OPERATOR;
    public static final b IS_SECONDARY;
    public static final b IS_SUSPEND;
    public static final b IS_TAILREC;
    public static final b IS_UNSIGNED;
    public static final b IS_VAR;
    public static final d<ProtoBuf$MemberKind> MEMBER_KIND;
    public static final d<ProtoBuf$Modality> MODALITY;
    public static final b SUSPEND_TYPE;
    public static final d<ProtoBuf$Visibility> VISIBILITY;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class b extends d<Boolean> {
        public b(int i) {
            super(i, 1);
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", gn1.TYPE_OPEN_URL_METHOD_GET));
        }

        @Override // tb.yj0.d
        @NotNull
        /* renamed from: g */
        public Boolean d(int i) {
            Boolean valueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // tb.yj0.d
        /* renamed from: h */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class c<E extends Internal.EnumLite> extends d<E> {
        private final E[] c;

        public c(int i, E[] eArr) {
            super(i, g(eArr));
            this.c = eArr;
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(@NotNull E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // tb.yj0.d
        @Nullable
        /* renamed from: h */
        public E d(int i) {
            E[] eArr;
            int i2 = this.a;
            int i3 = (i & (((1 << this.b) - 1) << i2)) >> i2;
            for (E e : this.c) {
                if (e.getNumber() == i3) {
                    return e;
                }
            }
            return null;
        }

        @Override // tb.yj0.d
        /* renamed from: i */
        public int e(E e) {
            return e.getNumber() << this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class d<E> {
        public final int a;
        public final int b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Ltb/yj0$d<*>;[TE;)Ltb/yj0$d<TE;>; */
        public static d a(d dVar, Internal.EnumLite[] enumLiteArr) {
            return new c(dVar.a + dVar.b, enumLiteArr);
        }

        public static b b(d<?> dVar) {
            return new b(dVar.a + dVar.b);
        }

        public static b c() {
            return new b(0);
        }

        public abstract E d(int i);

        public abstract int e(E e);

        private d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static {
        b c2 = d.c();
        SUSPEND_TYPE = c2;
        DEFINITELY_NOT_NULL_TYPE = d.b(c2);
        b c3 = d.c();
        HAS_ANNOTATIONS = c3;
        d<ProtoBuf$Visibility> a2 = d.a(c3, ProtoBuf$Visibility.values());
        VISIBILITY = a2;
        d<ProtoBuf$Modality> a3 = d.a(a2, ProtoBuf$Modality.values());
        MODALITY = a3;
        d<ProtoBuf$Class.Kind> a4 = d.a(a3, ProtoBuf$Class.Kind.values());
        CLASS_KIND = a4;
        b b2 = d.b(a4);
        IS_INNER = b2;
        b b3 = d.b(b2);
        IS_DATA = b3;
        b b4 = d.b(b3);
        IS_EXTERNAL_CLASS = b4;
        b b5 = d.b(b4);
        IS_EXPECT_CLASS = b5;
        b b6 = d.b(b5);
        IS_INLINE_CLASS = b6;
        IS_FUN_INTERFACE = d.b(b6);
        b b7 = d.b(a2);
        IS_SECONDARY = b7;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = d.b(b7);
        d<ProtoBuf$MemberKind> a5 = d.a(a3, ProtoBuf$MemberKind.values());
        MEMBER_KIND = a5;
        b b8 = d.b(a5);
        IS_OPERATOR = b8;
        b b9 = d.b(b8);
        IS_INFIX = b9;
        b b10 = d.b(b9);
        IS_INLINE = b10;
        b b11 = d.b(b10);
        IS_TAILREC = b11;
        b b12 = d.b(b11);
        IS_EXTERNAL_FUNCTION = b12;
        b b13 = d.b(b12);
        IS_SUSPEND = b13;
        b b14 = d.b(b13);
        IS_EXPECT_FUNCTION = b14;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = d.b(b14);
        b b15 = d.b(a5);
        IS_VAR = b15;
        b b16 = d.b(b15);
        HAS_GETTER = b16;
        b b17 = d.b(b16);
        HAS_SETTER = b17;
        b b18 = d.b(b17);
        IS_CONST = b18;
        b b19 = d.b(b18);
        IS_LATEINIT = b19;
        b b20 = d.b(b19);
        HAS_CONSTANT = b20;
        b b21 = d.b(b20);
        IS_EXTERNAL_PROPERTY = b21;
        b b22 = d.b(b21);
        IS_DELEGATED = b22;
        IS_EXPECT_PROPERTY = d.b(b22);
        b b23 = d.b(c3);
        DECLARES_DEFAULT_VALUE = b23;
        b b24 = d.b(b23);
        IS_CROSSINLINE = b24;
        IS_NOINLINE = d.b(b24);
        b b25 = d.b(a3);
        IS_NOT_DEFAULT = b25;
        b b26 = d.b(b25);
        IS_EXTERNAL_ACCESSOR = b26;
        IS_INLINE_ACCESSOR = d.b(b26);
        b c4 = d.c();
        IS_NEGATED = c4;
        IS_NULL_CHECK_PREDICATE = d.b(c4);
        IS_UNSIGNED = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 1
            r2 = 0
            r3 = 2
            if (r5 == r1) goto L2b
            if (r5 == r3) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r2] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r2] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r2] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r2] = r4
        L2f:
            java.lang.String r2 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r1] = r2
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r3] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r3] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r3] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r3] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r3] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.yj0.a(int):void");
    }

    public static int b(boolean z, @NotNull ProtoBuf$Visibility protoBuf$Visibility, @NotNull ProtoBuf$Modality protoBuf$Modality, boolean z2, boolean z3, boolean z4) {
        if (protoBuf$Visibility == null) {
            a(10);
        }
        if (protoBuf$Modality == null) {
            a(11);
        }
        return HAS_ANNOTATIONS.e(Boolean.valueOf(z)) | MODALITY.e(protoBuf$Modality) | VISIBILITY.e(protoBuf$Visibility) | IS_NOT_DEFAULT.e(Boolean.valueOf(z2)) | IS_EXTERNAL_ACCESSOR.e(Boolean.valueOf(z3)) | IS_INLINE_ACCESSOR.e(Boolean.valueOf(z4));
    }
}
