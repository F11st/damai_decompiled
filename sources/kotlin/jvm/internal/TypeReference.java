package kotlin.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.k50;
import tb.k71;
import tb.s61;

/* compiled from: Taobao */
@SinceKotlin(version = "1.4")
/* loaded from: classes3.dex */
public final class TypeReference implements KType {
    @NotNull
    public static final C8235a Companion = new C8235a(null);
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    @NotNull
    private final KClassifier a;
    @NotNull
    private final List<k71> b;
    @Nullable
    private final KType c;
    private final int d;

    /* compiled from: Taobao */
    /* renamed from: kotlin.jvm.internal.TypeReference$a */
    /* loaded from: classes3.dex */
    public static final class C8235a {
        private C8235a() {
        }

        public /* synthetic */ C8235a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.jvm.internal.TypeReference$b */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8236b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(k71 k71Var) {
        String valueOf;
        if (k71Var.d() == null) {
            return jn1.MUL;
        }
        KType c = k71Var.c();
        TypeReference typeReference = c instanceof TypeReference ? (TypeReference) c : null;
        if (typeReference == null || (valueOf = typeReference.c(true)) == null) {
            valueOf = String.valueOf(k71Var.c());
        }
        int i = C8236b.$EnumSwitchMapping$0[k71Var.d().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return "in " + valueOf;
            } else if (i == 3) {
                return "out " + valueOf;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return valueOf;
    }

    private final String c(boolean z) {
        String name;
        KClassifier classifier = getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class<?> b = kClass != null ? s61.b(kClass) : null;
        if (b == null) {
            name = getClassifier().toString();
        } else if ((this.d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (b.isArray()) {
            name = d(b);
        } else if (z && b.isPrimitive()) {
            KClassifier classifier2 = getClassifier();
            b41.g(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = s61.c((KClass) classifier2).getName();
        } else {
            name = b.getName();
        }
        String str = name + (getArguments().isEmpty() ? "" : CollectionsKt___CollectionsKt.Z(getArguments(), AVFSCacheConstants.COMMA_SEP, jn1.L, jn1.G, 0, null, new Function1<k71, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull k71 k71Var) {
                String b2;
                b41.i(k71Var, AdvanceSetting.NETWORK_TYPE);
                b2 = TypeReference.this.b(k71Var);
                return b2;
            }
        }, 24, null)) + (isMarkedNullable() ? "?" : "");
        KType kType = this.c;
        if (kType instanceof TypeReference) {
            String c = ((TypeReference) kType).c(true);
            if (b41.d(c, str)) {
                return str;
            }
            if (b41.d(c, str + jn1.CONDITION_IF)) {
                return str + '!';
            }
            return '(' + str + ".." + c + ')';
        }
        return str;
    }

    private final String d(Class<?> cls) {
        return b41.d(cls, boolean[].class) ? "kotlin.BooleanArray" : b41.d(cls, char[].class) ? "kotlin.CharArray" : b41.d(cls, byte[].class) ? "kotlin.ByteArray" : b41.d(cls, short[].class) ? "kotlin.ShortArray" : b41.d(cls, int[].class) ? "kotlin.IntArray" : b41.d(cls, float[].class) ? "kotlin.FloatArray" : b41.d(cls, long[].class) ? "kotlin.LongArray" : b41.d(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (b41.d(getClassifier(), typeReference.getClassifier()) && b41.d(getArguments(), typeReference.getArguments()) && b41.d(this.c, typeReference.c) && this.d == typeReference.d) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> g;
        g = C8214m.g();
        return g;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<k71> getArguments() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public KClassifier getClassifier() {
        return this.a;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.valueOf(this.d).hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.d & 1) != 0;
    }

    @NotNull
    public String toString() {
        return c(false) + " (Kotlin reflection is not available)";
    }
}
