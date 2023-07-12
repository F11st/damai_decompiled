package mtopsdk.framework.filter.after;

import androidx.annotation.NonNull;
import mtopsdk.framework.filter.IAfterFilter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ErrorCodeMappingAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.ErrorCodeMappingAfterFilter";

    /* JADX WARN: Removed duplicated region for block: B:167:0x042e  */
    @Override // mtopsdk.framework.filter.IAfterFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doAfter(mtopsdk.framework.domain.MtopContext r18) {
        /*
            Method dump skipped, instructions count: 1301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.framework.filter.after.ErrorCodeMappingAfterFilter.doAfter(mtopsdk.framework.domain.MtopContext):java.lang.String");
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    @NonNull
    public String getName() {
        return TAG;
    }
}
