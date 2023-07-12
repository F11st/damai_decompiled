package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@ExperimentalStdlibApi
/* renamed from: kotlin.reflect.c */
/* loaded from: classes3.dex */
public final class C8244c implements WildcardType, TypeImpl {
    @NotNull
    public static final C8245a Companion = new C8245a(null);
    @NotNull
    private static final C8244c c = new C8244c(null, null);
    @Nullable
    private final Type a;
    @Nullable
    private final Type b;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.c$a */
    /* loaded from: classes3.dex */
    public static final class C8245a {
        private C8245a() {
        }

        public /* synthetic */ C8245a(k50 k50Var) {
            this();
        }

        @NotNull
        public final C8244c a() {
            return C8244c.c;
        }
    }

    public C8244c(@Nullable Type type, @Nullable Type type2) {
        this.a = type;
        this.b = type2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getLowerBounds() {
        Type type = this.b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    @NotNull
    public String getTypeName() {
        String h;
        String h2;
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("? super ");
            h2 = TypesJVMKt.h(this.b);
            sb.append(h2);
            return sb.toString();
        }
        Type type = this.a;
        if (type == null || b41.d(type, Object.class)) {
            return "?";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("? extends ");
        h = TypesJVMKt.h(this.a);
        sb2.append(h);
        return sb2.toString();
    }

    @Override // java.lang.reflect.WildcardType
    @NotNull
    public Type[] getUpperBounds() {
        Type[] typeArr = new Type[1];
        Type type = this.a;
        if (type == null) {
            type = Object.class;
        }
        typeArr[0] = type;
        return typeArr;
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
