package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.db.annotation.Column;
import com.alibaba.analytics.core.db.annotation.Ingore;
import com.alibaba.analytics.core.db.annotation.TableName;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.UUID;

/* compiled from: Taobao */
@TableName("stat_register_temp")
/* loaded from: classes6.dex */
public class nf1 extends ve0 implements Reusable {
    @Column("module")
    private String a;
    @Column(pl2.TAG_MONITOR_POINT)
    private String b;
    @Column("dimensions")
    private String c;
    @Column("measures")
    private String d;
    @Ingore
    private String e;
    @Column("is_commit_detail")
    private boolean f;
    @Ingore
    private DimensionSet g;
    @Ingore
    private MeasureSet h;
    @Ingore
    private String i;

    @Deprecated
    public nf1() {
    }

    public DimensionSet a() {
        if (this.g == null && !TextUtils.isEmpty(this.c)) {
            this.g = (DimensionSet) JSON.parseObject(this.c, DimensionSet.class);
        }
        return this.g;
    }

    public MeasureSet b() {
        if (this.h == null && !TextUtils.isEmpty(this.d)) {
            this.h = (MeasureSet) JSON.parseObject(this.d, MeasureSet.class);
        }
        return this.h;
    }

    public String c() {
        return this.b;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        this.a = null;
        this.b = null;
        this.e = null;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public synchronized String d() {
        if (this.i == null) {
            this.i = UUID.randomUUID().toString() + "$" + this.a + "$" + this.b;
        }
        return this.i;
    }

    public synchronized boolean e() {
        boolean z;
        if (!this.f) {
            z = com.alibaba.appmonitor.sample.a.h().j(this.a, this.b);
        }
        return z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && nf1.class == obj.getClass()) {
            nf1 nf1Var = (nf1) obj;
            String str = this.e;
            if (str == null) {
                if (nf1Var.e != null) {
                    return false;
                }
            } else if (!str.equals(nf1Var.e)) {
                return false;
            }
            String str2 = this.a;
            if (str2 == null) {
                if (nf1Var.a != null) {
                    return false;
                }
            } else if (!str2.equals(nf1Var.a)) {
                return false;
            }
            String str3 = this.b;
            if (str3 == null) {
                if (nf1Var.b != null) {
                    return false;
                }
            } else if (!str3.equals(nf1Var.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void f() {
        this.i = null;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        this.a = (String) objArr[0];
        this.b = (String) objArr[1];
        if (objArr.length > 2) {
            this.e = (String) objArr[2];
        }
    }

    public boolean g(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        DimensionSet dimensionSet = this.g;
        boolean z = true;
        boolean valid = dimensionSet != null ? dimensionSet.valid(dimensionValueSet) : true;
        MeasureSet measureSet = this.h;
        if (measureSet != null) {
            return (valid && measureSet.valid(measureValueSet)) ? false : false;
        }
        return valid;
    }

    public String getModule() {
        return this.a;
    }

    public int hashCode() {
        String str = this.e;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.a;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public nf1(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        this.a = str;
        this.b = str2;
        this.g = dimensionSet;
        this.h = measureSet;
        this.e = null;
        this.f = z;
        if (dimensionSet != null) {
            this.c = JSON.toJSONString(dimensionSet);
        }
        this.d = JSON.toJSONString(measureSet);
    }
}
