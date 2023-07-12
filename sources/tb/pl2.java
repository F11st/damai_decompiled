package tb;

import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class pl2 extends ve0 {
    @Ingore
    public static final String TAG_ACCESS = "access";
    @Ingore
    public static final String TAG_ACCESSSUBTYPE = "sub_access";
    @Ingore
    public static final String TAG_COMMITTIME = "commit_time";
    @Ingore
    public static final String TAG_MODULE = "module";
    @Ingore
    public static final String TAG_MONITOR_POINT = "monitor_point";
    @Column("module")
    public String a;
    @Column(TAG_MONITOR_POINT)
    public String b;
    @Column(TAG_COMMITTIME)
    public long c;
    @Column(TAG_ACCESS)
    public String d;
    @Column(TAG_ACCESSSUBTYPE)
    public String e;

    /* JADX INFO: Access modifiers changed from: protected */
    public pl2() {
    }

    public String toString() {
        return "TempEvent{}";
    }

    public pl2(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = System.currentTimeMillis() / 1000;
        this.d = str3;
        this.e = str4;
    }
}
