package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.C8203e0;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.hp0;
import tb.k50;
import tb.ni1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    @NotNull
    public static final C8266a Companion = new C8266a(null);
    @JvmField
    @NotNull
    public static final Set<PrimitiveType> NUMBER_TYPES;
    @NotNull
    private final Lazy arrayTypeFqName$delegate;
    @NotNull
    private final ni1 arrayTypeName;
    @NotNull
    private final Lazy typeFqName$delegate;
    @NotNull
    private final ni1 typeName;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$a */
    /* loaded from: classes3.dex */
    public static final class C8266a {
        private C8266a() {
        }

        public /* synthetic */ C8266a(k50 k50Var) {
            this();
        }
    }

    static {
        PrimitiveType primitiveType;
        PrimitiveType primitiveType2;
        PrimitiveType primitiveType3;
        PrimitiveType primitiveType4;
        PrimitiveType primitiveType5;
        PrimitiveType primitiveType6;
        Set<PrimitiveType> g;
        g = C8203e0.g(r0, primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6);
        NUMBER_TYPES = g;
    }

    PrimitiveType(String str) {
        Lazy a;
        Lazy a2;
        ni1 f = ni1.f(str);
        b41.h(f, "identifier(typeName)");
        this.typeName = f;
        ni1 f2 = ni1.f(b41.r(str, "Array"));
        b41.h(f2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = f2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        a = C8177b.a(lazyThreadSafetyMode, new Function0<hp0>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$typeFqName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final hp0 invoke() {
                hp0 c = C8277c.BUILT_INS_PACKAGE_FQ_NAME.c(PrimitiveType.this.getTypeName());
                b41.h(c, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
                return c;
            }
        });
        this.typeFqName$delegate = a;
        a2 = C8177b.a(lazyThreadSafetyMode, new Function0<hp0>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$arrayTypeFqName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final hp0 invoke() {
                hp0 c = C8277c.BUILT_INS_PACKAGE_FQ_NAME.c(PrimitiveType.this.getArrayTypeName());
                b41.h(c, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
                return c;
            }
        });
        this.arrayTypeFqName$delegate = a2;
    }

    @NotNull
    public final hp0 getArrayTypeFqName() {
        return (hp0) this.arrayTypeFqName$delegate.getValue();
    }

    @NotNull
    public final ni1 getArrayTypeName() {
        return this.arrayTypeName;
    }

    @NotNull
    public final hp0 getTypeFqName() {
        return (hp0) this.typeFqName$delegate.getValue();
    }

    @NotNull
    public final ni1 getTypeName() {
        return this.typeName;
    }
}
