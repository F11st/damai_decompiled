package tb;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class m22 extends n22<m22> {
    private String j;
    private Double k;
    private Long l;
    private String m;
    private String n;
    private String o;
    private String p;

    private m22(String str) {
        super("ResourceDownload", str);
    }

    public static m22 f(String str) {
        return new m22(str);
    }

    public void g(Set<String> set, Set<String> set2) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        hashSet.addAll(Arrays.asList("preVersion", "status", "errorCode", "errorMsg", zp0.KEY_TRIGGER));
        HashSet hashSet2 = new HashSet();
        if (set2 != null) {
            hashSet2.addAll(set2);
        }
        hashSet2.addAll(Arrays.asList("size", "costMillis"));
        a(hashSet, hashSet2);
    }

    public void h() {
        DimensionValueSet create = DimensionValueSet.create();
        String str = this.j;
        if (str != null) {
            create.setValue("preVersion", str);
        } else {
            create.setValue("preVersion", "-");
        }
        String str2 = this.m;
        if (str2 != null) {
            create.setValue("status", str2);
        } else {
            create.setValue("status", "-");
        }
        String str3 = this.n;
        if (str3 != null) {
            create.setValue("errorCode", str3);
        } else {
            create.setValue("errorCode", "-");
        }
        String str4 = this.o;
        if (str4 != null) {
            create.setValue("errorMsg", str4);
        } else {
            create.setValue("errorMsg", "-");
        }
        String str5 = this.p;
        if (str5 != null) {
            create.setValue(zp0.KEY_TRIGGER, str5);
        } else {
            create.setValue(zp0.KEY_TRIGGER, "-");
        }
        MeasureValueSet create2 = MeasureValueSet.create();
        Double d = this.k;
        if (d != null) {
            create2.setValue("size", d.doubleValue());
        } else {
            create2.setValue("size", d30.f.doubleValue());
        }
        Long l = this.l;
        if (l != null) {
            create2.setValue("costMillis", l.longValue());
        } else {
            create2.setValue("costMillis", d30.f.doubleValue());
        }
        b(create, create2);
    }
}
