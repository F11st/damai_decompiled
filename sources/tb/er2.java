package tb;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class er2 {
    @NotNull
    private final List<ProtoBuf$Type> a;

    public er2(@NotNull ProtoBuf$TypeTable protoBuf$TypeTable) {
        int q;
        b41.i(protoBuf$TypeTable, "typeTable");
        List<ProtoBuf$Type> typeList = protoBuf$TypeTable.getTypeList();
        if (protoBuf$TypeTable.hasFirstNullable()) {
            int firstNullable = protoBuf$TypeTable.getFirstNullable();
            List<ProtoBuf$Type> typeList2 = protoBuf$TypeTable.getTypeList();
            b41.h(typeList2, "typeTable.typeList");
            q = C8215n.q(typeList2, 10);
            ArrayList arrayList = new ArrayList(q);
            int i = 0;
            for (Object obj : typeList2) {
                int i2 = i + 1;
                if (i < 0) {
                    C8214m.p();
                }
                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
                if (i >= firstNullable) {
                    protoBuf$Type = protoBuf$Type.toBuilder().setNullable(true).build();
                }
                arrayList.add(protoBuf$Type);
                i = i2;
            }
            typeList = arrayList;
        }
        b41.h(typeList, "run {\n        val origin… else originalTypes\n    }");
        this.a = typeList;
    }

    @NotNull
    public final ProtoBuf$Type a(int i) {
        return this.a.get(i);
    }
}
