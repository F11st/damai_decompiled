package tb;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a71 {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends a71 {
        @NotNull
        private final Field a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Field field) {
            super(null);
            b41.i(field, "field");
            this.a = field;
        }

        @Override // tb.a71
        @NotNull
        public String a() {
            StringBuilder sb = new StringBuilder();
            String name = this.a.getName();
            b41.h(name, "field.name");
            sb.append(n61.a(name));
            sb.append("()");
            Class<?> type = this.a.getType();
            b41.h(type, "field.type");
            sb.append(ReflectClassUtilKt.b(type));
            return sb.toString();
        }

        @NotNull
        public final Field b() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b extends a71 {
        @NotNull
        private final Method a;
        @Nullable
        private final Method b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method method, @Nullable Method method2) {
            super(null);
            b41.i(method, "getterMethod");
            this.a = method;
            this.b = method2;
        }

        @Override // tb.a71
        @NotNull
        public String a() {
            String b;
            b = RuntimeTypeMapperKt.b(this.a);
            return b;
        }

        @NotNull
        public final Method b() {
            return this.a;
        }

        @Nullable
        public final Method c() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends a71 {
        private final String a;
        @NotNull
        private final PropertyDescriptor b;
        @NotNull
        private final ProtoBuf$Property c;
        @NotNull
        private final JvmProtoBuf.JvmPropertySignature d;
        @NotNull
        private final NameResolver e;
        @NotNull
        private final er2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull PropertyDescriptor propertyDescriptor, @NotNull ProtoBuf$Property protoBuf$Property, @NotNull JvmProtoBuf.JvmPropertySignature jvmPropertySignature, @NotNull NameResolver nameResolver, @NotNull er2 er2Var) {
            super(null);
            String str;
            b41.i(propertyDescriptor, "descriptor");
            b41.i(protoBuf$Property, "proto");
            b41.i(jvmPropertySignature, SocialOperation.GAME_SIGNATURE);
            b41.i(nameResolver, "nameResolver");
            b41.i(er2Var, "typeTable");
            this.b = propertyDescriptor;
            this.c = protoBuf$Property;
            this.d = jvmPropertySignature;
            this.e = nameResolver;
            this.f = er2Var;
            if (jvmPropertySignature.hasGetter()) {
                StringBuilder sb = new StringBuilder();
                JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                b41.h(getter, "signature.getter");
                sb.append(nameResolver.getString(getter.getName()));
                JvmProtoBuf.JvmMethodSignature getter2 = jvmPropertySignature.getGetter();
                b41.h(getter2, "signature.getter");
                sb.append(nameResolver.getString(getter2.getDesc()));
                str = sb.toString();
            } else {
                w61.a d = b71.d(b71.INSTANCE, protoBuf$Property, nameResolver, er2Var, false, 8, null);
                if (d != null) {
                    String d2 = d.d();
                    str = n61.a(d2) + c() + "()" + d.e();
                } else {
                    throw new KotlinReflectionInternalError("No field signature for property: " + propertyDescriptor);
                }
            }
            this.a = str;
        }

        private final String c() {
            String str;
            DeclarationDescriptor containingDeclaration = this.b.getContainingDeclaration();
            b41.h(containingDeclaration, "descriptor.containingDeclaration");
            if (b41.d(this.b.getVisibility(), e70.INTERNAL) && (containingDeclaration instanceof DeserializedClassDescriptor)) {
                ProtoBuf$Class t = ((DeserializedClassDescriptor) containingDeclaration).t();
                GeneratedMessageLite.c<ProtoBuf$Class, Integer> cVar = JvmProtoBuf.classModuleName;
                b41.h(cVar, "JvmProtoBuf.classModuleName");
                Integer num = (Integer) fx1.a(t, cVar);
                if (num == null || (str = this.e.getString(num.intValue())) == null) {
                    str = lu2.MAIN;
                }
                return "$" + qi1.a(str);
            } else if (b41.d(this.b.getVisibility(), e70.PRIVATE) && (containingDeclaration instanceof PackageFragmentDescriptor)) {
                PropertyDescriptor propertyDescriptor = this.b;
                Objects.requireNonNull(propertyDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
                DeserializedContainerSource containerSource = ((p70) propertyDescriptor).getContainerSource();
                if (containerSource instanceof z61) {
                    z61 z61Var = (z61) containerSource;
                    if (z61Var.b() != null) {
                        return "$" + z61Var.d().b();
                    }
                    return "";
                }
                return "";
            } else {
                return "";
            }
        }

        @Override // tb.a71
        @NotNull
        public String a() {
            return this.a;
        }

        @NotNull
        public final PropertyDescriptor b() {
            return this.b;
        }

        @NotNull
        public final NameResolver d() {
            return this.e;
        }

        @NotNull
        public final ProtoBuf$Property e() {
            return this.c;
        }

        @NotNull
        public final JvmProtoBuf.JvmPropertySignature f() {
            return this.d;
        }

        @NotNull
        public final er2 g() {
            return this.f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class d extends a71 {
        @NotNull
        private final JvmFunctionSignature.c a;
        @Nullable
        private final JvmFunctionSignature.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull JvmFunctionSignature.c cVar, @Nullable JvmFunctionSignature.c cVar2) {
            super(null);
            b41.i(cVar, "getterSignature");
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // tb.a71
        @NotNull
        public String a() {
            return this.a.a();
        }

        @NotNull
        public final JvmFunctionSignature.c b() {
            return this.a;
        }

        @Nullable
        public final JvmFunctionSignature.c c() {
            return this.b;
        }
    }

    private a71() {
    }

    @NotNull
    public abstract String a();

    public /* synthetic */ a71(k50 k50Var) {
        this();
    }
}
