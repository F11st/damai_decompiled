package tb;

import com.youku.arch.v3.data.Constants;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class j70 {
    @NotNull
    private final h70 a;
    @NotNull
    private final NameResolver b;
    @NotNull
    private final DeclarationDescriptor c;
    @NotNull
    private final er2 d;
    @NotNull
    private final ix2 e;
    @NotNull
    private final AbstractC9135fc f;
    @Nullable
    private final DeserializedContainerSource g;
    @NotNull
    private final TypeDeserializer h;
    @NotNull
    private final MemberDeserializer i;

    public j70(@NotNull h70 h70Var, @NotNull NameResolver nameResolver, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @NotNull AbstractC9135fc abstractC9135fc, @Nullable DeserializedContainerSource deserializedContainerSource, @Nullable TypeDeserializer typeDeserializer, @NotNull List<ProtoBuf$TypeParameter> list) {
        String presentableString;
        b41.i(h70Var, Constants.COMPONENT);
        b41.i(nameResolver, "nameResolver");
        b41.i(declarationDescriptor, "containingDeclaration");
        b41.i(er2Var, "typeTable");
        b41.i(ix2Var, "versionRequirementTable");
        b41.i(abstractC9135fc, "metadataVersion");
        b41.i(list, "typeParameters");
        this.a = h70Var;
        this.b = nameResolver;
        this.c = declarationDescriptor;
        this.d = er2Var;
        this.e = ix2Var;
        this.f = abstractC9135fc;
        this.g = deserializedContainerSource;
        this.h = new TypeDeserializer(this, typeDeserializer, list, "Deserializer for \"" + declarationDescriptor.getName() + jn1.QUOTE, (deserializedContainerSource == null || (presentableString = deserializedContainerSource.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.i = new MemberDeserializer(this);
    }

    public static /* synthetic */ j70 b(j70 j70Var, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, er2 er2Var, ix2 ix2Var, AbstractC9135fc abstractC9135fc, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver = j70Var.b;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            er2Var = j70Var.d;
        }
        er2 er2Var2 = er2Var;
        if ((i & 16) != 0) {
            ix2Var = j70Var.e;
        }
        ix2 ix2Var2 = ix2Var;
        if ((i & 32) != 0) {
            abstractC9135fc = j70Var.f;
        }
        return j70Var.a(declarationDescriptor, list, nameResolver2, er2Var2, ix2Var2, abstractC9135fc);
    }

    @NotNull
    public final j70 a(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<ProtoBuf$TypeParameter> list, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull ix2 ix2Var, @NotNull AbstractC9135fc abstractC9135fc) {
        b41.i(declarationDescriptor, "descriptor");
        b41.i(list, "typeParameterProtos");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        ix2 ix2Var2 = ix2Var;
        b41.i(ix2Var2, "versionRequirementTable");
        b41.i(abstractC9135fc, "metadataVersion");
        h70 h70Var = this.a;
        if (!jx2.b(abstractC9135fc)) {
            ix2Var2 = this.e;
        }
        return new j70(h70Var, nameResolver, declarationDescriptor, er2Var, ix2Var2, abstractC9135fc, this.g, this.h, list);
    }

    @NotNull
    public final h70 c() {
        return this.a;
    }

    @Nullable
    public final DeserializedContainerSource d() {
        return this.g;
    }

    @NotNull
    public final DeclarationDescriptor e() {
        return this.c;
    }

    @NotNull
    public final MemberDeserializer f() {
        return this.i;
    }

    @NotNull
    public final NameResolver g() {
        return this.b;
    }

    @NotNull
    public final StorageManager h() {
        return this.a.u();
    }

    @NotNull
    public final TypeDeserializer i() {
        return this.h;
    }

    @NotNull
    public final er2 j() {
        return this.d;
    }

    @NotNull
    public final ix2 k() {
        return this.e;
    }
}
