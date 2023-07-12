package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w61;
import tb.yj0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b71 {
    @NotNull
    public static final b71 INSTANCE = new b71();
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.protobuf.c a;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.c d = kotlin.reflect.jvm.internal.impl.protobuf.c.d();
        JvmProtoBuf.a(d);
        b41.h(d, "newInstance().apply(JvmP…f::registerAllExtensions)");
        a = d;
    }

    private b71() {
    }

    public static /* synthetic */ w61.a d(b71 b71Var, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, er2 er2Var, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return b71Var.c(protoBuf$Property, nameResolver, er2Var, z);
    }

    @JvmStatic
    public static final boolean f(@NotNull ProtoBuf$Property protoBuf$Property) {
        b41.i(protoBuf$Property, "proto");
        yj0.b a2 = v61.INSTANCE.a();
        Object extension = protoBuf$Property.getExtension(JvmProtoBuf.flags);
        b41.h(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean d = a2.d(((Number) extension).intValue());
        b41.h(d, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return d.booleanValue();
    }

    private final String g(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        if (protoBuf$Type.hasClassName()) {
            return jj.b(nameResolver.getQualifiedClassName(protoBuf$Type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<y61, ProtoBuf$Class> h(@NotNull byte[] bArr, @NotNull String[] strArr) {
        b41.i(bArr, "bytes");
        b41.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr), ProtoBuf$Class.parseFrom(byteArrayInputStream, a));
    }

    @JvmStatic
    @NotNull
    public static final Pair<y61, ProtoBuf$Class> i(@NotNull String[] strArr, @NotNull String[] strArr2) {
        b41.i(strArr, "data");
        b41.i(strArr2, "strings");
        byte[] e = mc.e(strArr);
        b41.h(e, "decodeBytes(data)");
        return h(e, strArr2);
    }

    @JvmStatic
    @NotNull
    public static final Pair<y61, ProtoBuf$Function> j(@NotNull String[] strArr, @NotNull String[] strArr2) {
        b41.i(strArr, "data");
        b41.i(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mc.e(strArr));
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr2), ProtoBuf$Function.parseFrom(byteArrayInputStream, a));
    }

    private final y61 k(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, a);
        b41.h(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new y61(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    @NotNull
    public static final Pair<y61, ProtoBuf$Package> l(@NotNull byte[] bArr, @NotNull String[] strArr) {
        b41.i(bArr, "bytes");
        b41.i(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.k(byteArrayInputStream, strArr), ProtoBuf$Package.parseFrom(byteArrayInputStream, a));
    }

    @JvmStatic
    @NotNull
    public static final Pair<y61, ProtoBuf$Package> m(@NotNull String[] strArr, @NotNull String[] strArr2) {
        b41.i(strArr, "data");
        b41.i(strArr2, "strings");
        byte[] e = mc.e(strArr);
        b41.h(e, "decodeBytes(data)");
        return l(e, strArr2);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.c a() {
        return a;
    }

    @Nullable
    public final w61.b b(@NotNull ProtoBuf$Constructor protoBuf$Constructor, @NotNull NameResolver nameResolver, @NotNull er2 er2Var) {
        int q;
        String Z;
        b41.i(protoBuf$Constructor, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Constructor, JvmProtoBuf.JvmMethodSignature> cVar = JvmProtoBuf.constructorSignature;
        b41.h(cVar, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) fx1.a(protoBuf$Constructor, cVar);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            Z = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Constructor.getValueParameterList();
            b41.h(valueParameterList, "proto.valueParameterList");
            q = kotlin.collections.n.q(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(q);
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : valueParameterList) {
                b71 b71Var = INSTANCE;
                b41.h(protoBuf$ValueParameter, AdvanceSetting.NETWORK_TYPE);
                String g = b71Var.g(jx1.n(protoBuf$ValueParameter, er2Var), nameResolver);
                if (g == null) {
                    return null;
                }
                arrayList.add(g);
            }
            Z = CollectionsKt___CollectionsKt.Z(arrayList, "", jn1.BRACKET_START_STR, ")V", 0, null, null, 56, null);
        }
        return new w61.b(string, Z);
    }

    @Nullable
    public final w61.a c(@NotNull ProtoBuf$Property protoBuf$Property, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, boolean z) {
        String g;
        b41.i(protoBuf$Property, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> cVar = JvmProtoBuf.propertySignature;
        b41.h(cVar, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fx1.a(protoBuf$Property, cVar);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? protoBuf$Property.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            g = g(jx1.k(protoBuf$Property, er2Var), nameResolver);
            if (g == null) {
                return null;
            }
        } else {
            g = nameResolver.getString(field.getDesc());
        }
        return new w61.a(nameResolver.getString(name), g);
    }

    @Nullable
    public final w61.b e(@NotNull ProtoBuf$Function protoBuf$Function, @NotNull NameResolver nameResolver, @NotNull er2 er2Var) {
        List k;
        int q;
        List<ProtoBuf$Type> m0;
        int q2;
        String Z;
        String r;
        b41.i(protoBuf$Function, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        GeneratedMessageLite.c<ProtoBuf$Function, JvmProtoBuf.JvmMethodSignature> cVar = JvmProtoBuf.methodSignature;
        b41.h(cVar, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) fx1.a(protoBuf$Function, cVar);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? protoBuf$Function.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            r = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            k = kotlin.collections.m.k(jx1.h(protoBuf$Function, er2Var));
            List<ProtoBuf$ValueParameter> valueParameterList = protoBuf$Function.getValueParameterList();
            b41.h(valueParameterList, "proto.valueParameterList");
            q = kotlin.collections.n.q(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(q);
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : valueParameterList) {
                b41.h(protoBuf$ValueParameter, AdvanceSetting.NETWORK_TYPE);
                arrayList.add(jx1.n(protoBuf$ValueParameter, er2Var));
            }
            m0 = CollectionsKt___CollectionsKt.m0(k, arrayList);
            q2 = kotlin.collections.n.q(m0, 10);
            ArrayList arrayList2 = new ArrayList(q2);
            for (ProtoBuf$Type protoBuf$Type : m0) {
                String g = INSTANCE.g(protoBuf$Type, nameResolver);
                if (g == null) {
                    return null;
                }
                arrayList2.add(g);
            }
            String g2 = g(jx1.j(protoBuf$Function, er2Var), nameResolver);
            if (g2 == null) {
                return null;
            }
            Z = CollectionsKt___CollectionsKt.Z(arrayList2, "", jn1.BRACKET_START_STR, jn1.BRACKET_END_STR, 0, null, null, 56, null);
            r = b41.r(Z, g2);
        }
        return new w61.b(nameResolver.getString(name), r);
    }
}
