package tb;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ve0 {
    @Ingore
    private static boolean hasCheckdb;
    @Column("_id")
    public long _id = -1;

    public void delete() {
        Variables.n().k().h(this);
    }

    public void store() {
        Variables.n().k().r(this);
    }
}
