package tb;

import com.taobao.android.protodb.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r71 implements Iterator<n71> {
    private final String[] a;
    private int b;

    public r71(String[] strArr) {
        this.b = 0;
        this.a = strArr;
        this.b = 0;
    }

    @Override // com.taobao.android.protodb.Iterator
    /* renamed from: a */
    public n71 next() {
        int i;
        String[] strArr = this.a;
        if (strArr == null || (i = this.b) >= strArr.length) {
            return null;
        }
        this.b = i + 1;
        return new n71(strArr[i]);
    }
}
