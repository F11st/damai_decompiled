package tb;

import java.util.List;
import kotlin.collections.C8212k;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ix2 {
    @NotNull
    public static final C9291a Companion = new C9291a(null);
    @NotNull
    private static final ix2 b;
    @NotNull
    private final List<ProtoBuf$VersionRequirement> a;

    /* compiled from: Taobao */
    /* renamed from: tb.ix2$a */
    /* loaded from: classes3.dex */
    public static final class C9291a {
        private C9291a() {
        }

        public /* synthetic */ C9291a(k50 k50Var) {
            this();
        }

        @NotNull
        public final ix2 a(@NotNull ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            b41.i(protoBuf$VersionRequirementTable, "table");
            if (protoBuf$VersionRequirementTable.getRequirementCount() == 0) {
                return b();
            }
            List<ProtoBuf$VersionRequirement> requirementList = protoBuf$VersionRequirementTable.getRequirementList();
            b41.h(requirementList, "table.requirementList");
            return new ix2(requirementList, null);
        }

        @NotNull
        public final ix2 b() {
            return ix2.b;
        }
    }

    static {
        List g;
        g = C8214m.g();
        b = new ix2(g);
    }

    private ix2(List<ProtoBuf$VersionRequirement> list) {
        this.a = list;
    }

    public /* synthetic */ ix2(List list, k50 k50Var) {
        this(list);
    }

    @Nullable
    public final ProtoBuf$VersionRequirement b(int i) {
        return (ProtoBuf$VersionRequirement) C8212k.S(this.a, i);
    }
}
