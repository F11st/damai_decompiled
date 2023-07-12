package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ix2 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final ix2 b;
    @NotNull
    private final List<ProtoBuf$VersionRequirement> a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
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
        g = kotlin.collections.m.g();
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
        return (ProtoBuf$VersionRequirement) kotlin.collections.k.S(this.a, i);
    }
}
