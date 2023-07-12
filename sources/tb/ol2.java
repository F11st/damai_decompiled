package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.TableName;

/* compiled from: Taobao */
@TableName("counter_temp")
/* loaded from: classes6.dex */
public class ol2 extends pl2 {
    @Column("arg")
    public String f;
    @Column("value")
    public double g;

    public ol2(String str, String str2, String str3, double d, String str4, String str5) {
        super(str, str2, str4, str5);
        this.f = str3;
        this.g = d;
    }

    @Override // tb.pl2
    public String toString() {
        return "TempCounter{arg='" + this.f + "', value=" + this.g + '}';
    }

    public ol2() {
    }
}
