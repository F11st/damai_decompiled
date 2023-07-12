package tb;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashSet;
import java.util.Set;
import tb.n22;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class n22<T extends n22> extends d30<T> {
    private String h;
    private String i;

    /* JADX INFO: Access modifiers changed from: protected */
    public n22(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.d30
    public void a(Set<String> set, Set<String> set2) {
        if (set == null) {
            set = new HashSet<>(2);
        }
        set.add("name");
        set.add("version");
        super.a(set, set2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.d30
    public void b(DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        if (dimensionValueSet == null) {
            dimensionValueSet = DimensionValueSet.create();
        }
        String str = this.h;
        if (str != null) {
            dimensionValueSet.setValue("name", str);
        } else {
            dimensionValueSet.setValue("name", "-");
        }
        String str2 = this.i;
        if (str2 != null) {
            dimensionValueSet.setValue("version", str2);
        } else {
            dimensionValueSet.setValue("version", "-");
        }
        super.b(dimensionValueSet, measureValueSet);
    }
}
