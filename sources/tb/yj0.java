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
    public static final AbstractC9990d<ProtoBuf$Class.Kind> CLASS_KIND;
    public static final C9988b DECLARES_DEFAULT_VALUE;
    public static final C9988b DEFINITELY_NOT_NULL_TYPE;
    public static final C9988b HAS_ANNOTATIONS;
    public static final C9988b HAS_CONSTANT;
    public static final C9988b HAS_GETTER;
    public static final C9988b HAS_SETTER;
    public static final C9988b IS_CONST;
    public static final C9988b IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final C9988b IS_CROSSINLINE;
    public static final C9988b IS_DATA;
    public static final C9988b IS_DELEGATED;
    public static final C9988b IS_EXPECT_CLASS;
    public static final C9988b IS_EXPECT_FUNCTION;
    public static final C9988b IS_EXPECT_PROPERTY;
    public static final C9988b IS_EXTERNAL_ACCESSOR;
    public static final C9988b IS_EXTERNAL_CLASS;
    public static final C9988b IS_EXTERNAL_FUNCTION;
    public static final C9988b IS_EXTERNAL_PROPERTY;
    public static final C9988b IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES;
    public static final C9988b IS_FUN_INTERFACE;
    public static final C9988b IS_INFIX;
    public static final C9988b IS_INLINE;
    public static final C9988b IS_INLINE_ACCESSOR;
    public static final C9988b IS_INLINE_CLASS;
    public static final C9988b IS_INNER;
    public static final C9988b IS_LATEINIT;
    public static final C9988b IS_NEGATED;
    public static final C9988b IS_NOINLINE;
    public static final C9988b IS_NOT_DEFAULT;
    public static final C9988b IS_NULL_CHECK_PREDICATE;
    public static final C9988b IS_OPERATOR;
    public static final C9988b IS_SECONDARY;
    public static final C9988b IS_SUSPEND;
    public static final C9988b IS_TAILREC;
    public static final C9988b IS_UNSIGNED;
    public static final C9988b IS_VAR;
    public static final AbstractC9990d<ProtoBuf$MemberKind> MEMBER_KIND;
    public static final AbstractC9990d<ProtoBuf$Modality> MODALITY;
    public static final C9988b SUSPEND_TYPE;
    public static final AbstractC9990d<ProtoBuf$Visibility> VISIBILITY;

    /* compiled from: Taobao */
    /* renamed from: tb.yj0$b */
    /* loaded from: classes3.dex */
    public static class C9988b extends AbstractC9990d<Boolean> {
        public C9988b(int i) {
            super(i, 1);
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", gn1.TYPE_OPEN_URL_METHOD_GET));
        }

        @Override // tb.yj0.AbstractC9990d
        @NotNull
        /* renamed from: g */
        public Boolean d(int i) {
            Boolean valueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // tb.yj0.AbstractC9990d
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
    /* renamed from: tb.yj0$c */
    /* loaded from: classes3.dex */
    public static class C9989c<E extends Internal.EnumLite> extends AbstractC9990d<E> {
        private final E[] c;

        public C9989c(int i, E[] eArr) {
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

        @Override // tb.yj0.AbstractC9990d
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

        @Override // tb.yj0.AbstractC9990d
        /* renamed from: i */
        public int e(E e) {
            return e.getNumber() << this.a;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yj0$d */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9990d<E> {
        public final int a;
        public final int b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/Internal$EnumLite;>(Ltb/yj0$d<*>;[TE;)Ltb/yj0$d<TE;>; */
        public static AbstractC9990d a(AbstractC9990d abstractC9990d, Internal.EnumLite[] enumLiteArr) {
            return new C9989c(abstractC9990d.a + abstractC9990d.b, enumLiteArr);
        }

        public static C9988b b(AbstractC9990d<?> abstractC9990d) {
            return new C9988b(abstractC9990d.a + abstractC9990d.b);
        }

        public static C9988b c() {
            return new C9988b(0);
        }

        public abstract E d(int i);

        public abstract int e(E e);

        private AbstractC9990d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    static {
        C9988b c = AbstractC9990d.c();
        SUSPEND_TYPE = c;
        DEFINITELY_NOT_NULL_TYPE = AbstractC9990d.b(c);
        C9988b c2 = AbstractC9990d.c();
        HAS_ANNOTATIONS = c2;
        AbstractC9990d<ProtoBuf$Visibility> a = AbstractC9990d.a(c2, ProtoBuf$Visibility.values());
        VISIBILITY = a;
        AbstractC9990d<ProtoBuf$Modality> a2 = AbstractC9990d.a(a, ProtoBuf$Modality.values());
        MODALITY = a2;
        AbstractC9990d<ProtoBuf$Class.Kind> a3 = AbstractC9990d.a(a2, ProtoBuf$Class.Kind.values());
        CLASS_KIND = a3;
        C9988b b = AbstractC9990d.b(a3);
        IS_INNER = b;
        C9988b b2 = AbstractC9990d.b(b);
        IS_DATA = b2;
        C9988b b3 = AbstractC9990d.b(b2);
        IS_EXTERNAL_CLASS = b3;
        C9988b b4 = AbstractC9990d.b(b3);
        IS_EXPECT_CLASS = b4;
        C9988b b5 = AbstractC9990d.b(b4);
        IS_INLINE_CLASS = b5;
        IS_FUN_INTERFACE = AbstractC9990d.b(b5);
        C9988b b6 = AbstractC9990d.b(a);
        IS_SECONDARY = b6;
        IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES = AbstractC9990d.b(b6);
        AbstractC9990d<ProtoBuf$MemberKind> a4 = AbstractC9990d.a(a2, ProtoBuf$MemberKind.values());
        MEMBER_KIND = a4;
        C9988b b7 = AbstractC9990d.b(a4);
        IS_OPERATOR = b7;
        C9988b b8 = AbstractC9990d.b(b7);
        IS_INFIX = b8;
        C9988b b9 = AbstractC9990d.b(b8);
        IS_INLINE = b9;
        C9988b b10 = AbstractC9990d.b(b9);
        IS_TAILREC = b10;
        C9988b b11 = AbstractC9990d.b(b10);
        IS_EXTERNAL_FUNCTION = b11;
        C9988b b12 = AbstractC9990d.b(b11);
        IS_SUSPEND = b12;
        C9988b b13 = AbstractC9990d.b(b12);
        IS_EXPECT_FUNCTION = b13;
        IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES = AbstractC9990d.b(b13);
        C9988b b14 = AbstractC9990d.b(a4);
        IS_VAR = b14;
        C9988b b15 = AbstractC9990d.b(b14);
        HAS_GETTER = b15;
        C9988b b16 = AbstractC9990d.b(b15);
        HAS_SETTER = b16;
        C9988b b17 = AbstractC9990d.b(b16);
        IS_CONST = b17;
        C9988b b18 = AbstractC9990d.b(b17);
        IS_LATEINIT = b18;
        C9988b b19 = AbstractC9990d.b(b18);
        HAS_CONSTANT = b19;
        C9988b b20 = AbstractC9990d.b(b19);
        IS_EXTERNAL_PROPERTY = b20;
        C9988b b21 = AbstractC9990d.b(b20);
        IS_DELEGATED = b21;
        IS_EXPECT_PROPERTY = AbstractC9990d.b(b21);
        C9988b b22 = AbstractC9990d.b(c2);
        DECLARES_DEFAULT_VALUE = b22;
        C9988b b23 = AbstractC9990d.b(b22);
        IS_CROSSINLINE = b23;
        IS_NOINLINE = AbstractC9990d.b(b23);
        C9988b b24 = AbstractC9990d.b(a2);
        IS_NOT_DEFAULT = b24;
        C9988b b25 = AbstractC9990d.b(b24);
        IS_EXTERNAL_ACCESSOR = b25;
        IS_INLINE_ACCESSOR = AbstractC9990d.b(b25);
        C9988b c3 = AbstractC9990d.c();
        IS_NEGATED = c3;
        IS_NULL_CHECK_PREDICATE = AbstractC9990d.b(c3);
        IS_UNSIGNED = AbstractC9990d.c();
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
