package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;

/* compiled from: Taobao */
@TableName("onlineconfig")
/* loaded from: classes5.dex */
public class us2 extends ve0 {
    @Column("groupname")
    private String a = null;
    @Column("content")
    private String b = null;
    @Column("timestamp")
    private long c = 0;
    @Ingore
    private boolean d = false;

    public String a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.d;
    }

    public void e() {
        this.d = true;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(long j) {
        this.c = j;
    }

    public void h(String str) {
        this.a = str;
    }
}
