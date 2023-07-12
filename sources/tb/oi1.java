package tb;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class oi1 implements NameResolver {
    @NotNull
    private final ProtoBuf$StringTable a;
    @NotNull
    private final ProtoBuf$QualifiedNameTable b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public oi1(@NotNull ProtoBuf$StringTable protoBuf$StringTable, @NotNull ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        b41.i(protoBuf$StringTable, "strings");
        b41.i(protoBuf$QualifiedNameTable, "qualifiedNames");
        this.a = protoBuf$StringTable;
        this.b = protoBuf$QualifiedNameTable;
    }

    private final Triple<List<String>, List<String>, Boolean> a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            ProtoBuf$QualifiedNameTable.QualifiedName qualifiedName = this.b.getQualifiedName(i);
            String string = this.a.getString(qualifiedName.getShortName());
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            b41.f(kind);
            int i2 = a.$EnumSwitchMapping$0[kind.ordinal()];
            if (i2 == 1) {
                linkedList2.addFirst(string);
            } else if (i2 == 2) {
                linkedList.addFirst(string);
            } else if (i2 == 3) {
                linkedList2.addFirst(string);
                z = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        String Z;
        String Z2;
        Triple<List<String>, List<String>, Boolean> a2 = a(i);
        List<String> component1 = a2.component1();
        Z = CollectionsKt___CollectionsKt.Z(a2.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return Z;
        }
        StringBuilder sb = new StringBuilder();
        Z2 = CollectionsKt___CollectionsKt.Z(component1, "/", null, null, 0, null, null, 62, null);
        sb.append(Z2);
        sb.append(r10.DIR);
        sb.append(Z);
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getString(int i) {
        String string = this.a.getString(i);
        b41.h(string, "strings.getString(index)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return a(i).getThird().booleanValue();
    }
}
