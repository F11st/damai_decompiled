package tb;

import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gy {
    private DXLongSparseArray<Map<String, Integer>> a;
    private k10 b;

    public gy(k10 k10Var) {
        this.b = k10Var;
    }

    public DXLongSparseArray<Map<String, Integer>> a() {
        return this.a;
    }

    public boolean b(int i, C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        if (i == 0) {
            return true;
        }
        int c = c9787ut.c();
        short h = c9787ut.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_COUNT_ERROR, "totalSize < 0"));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        for (int i2 = 0; i2 < h; i2++) {
            long g = c9787ut.g();
            byte d = c9787ut.d();
            if (d <= 0) {
                dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "count <= 0"));
                return false;
            }
            HashMap hashMap = new HashMap(d);
            int i3 = 0;
            while (i3 < d) {
                hashMap.put(this.b.getString(c9787ut.g()), Integer.valueOf(c9787ut.f()));
                i3++;
                c = c;
            }
            this.a.put(g, hashMap);
        }
        if (c9787ut.c() - c != i) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "reader.getPos() - startPos != length"));
            return false;
        }
        return true;
    }
}
