package tb;

import com.taobao.android.dinamicx.model.DXLongSparseArray;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ty {
    private DXLongSparseArray<wy> a;
    private Stack<wy> b = new Stack<>();
    private k10 c;

    public ty(k10 k10Var) {
        this.c = k10Var;
    }

    public wy a(long j) {
        DXLongSparseArray<wy> dXLongSparseArray = this.a;
        if (dXLongSparseArray != null) {
            return dXLongSparseArray.get(j);
        }
        return null;
    }

    public DXLongSparseArray<wy> b() {
        return this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
        r17.a.put(r8, r11);
        r6 = r6 + 1;
        r2 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(int r18, tb.C9787ut r19, com.taobao.android.dinamicx.DXRuntimeContext r20) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ty.c(int, tb.ut, com.taobao.android.dinamicx.DXRuntimeContext):boolean");
    }
}
