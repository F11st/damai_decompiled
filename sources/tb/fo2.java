package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;

/* compiled from: Taobao */
@TableName("timestamp_config")
/* loaded from: classes5.dex */
public class fo2 extends ve0 {
    @Column("namespace")
    public String a;
    @Column("timestamp")
    public String b;

    public fo2() {
    }

    public fo2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
