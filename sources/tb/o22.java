package tb;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class o22 extends n22<o22> {
    private String j;

    private o22(String str) {
        super("ResourceUse", str);
    }

    public static o22 f(String str) {
        return new o22(str);
    }

    public void g(Set<String> set, Set<String> set2) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        hashSet.add("action");
        HashSet hashSet2 = new HashSet();
        if (set2 != null) {
            hashSet2.addAll(set2);
        }
        a(hashSet, hashSet2);
    }

    public void h() {
        DimensionValueSet create = DimensionValueSet.create();
        String str = this.j;
        if (str != null) {
            create.setValue("action", str);
        } else {
            create.setValue("action", "-");
        }
        b(create, null);
    }
}
