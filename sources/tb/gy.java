package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
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

    public boolean b(int i, ut utVar, DXRuntimeContext dXRuntimeContext) {
        if (i == 0) {
            return true;
        }
        int c = utVar.c();
        short h = utVar.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", com.taobao.android.dinamicx.e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_COUNT_ERROR, "totalSize < 0"));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        for (int i2 = 0; i2 < h; i2++) {
            long g = utVar.g();
            byte d = utVar.d();
            if (d <= 0) {
                dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", com.taobao.android.dinamicx.e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "count <= 0"));
                return false;
            }
            HashMap hashMap = new HashMap(d);
            int i3 = 0;
            while (i3 < d) {
                hashMap.put(this.b.getString(utVar.g()), Integer.valueOf(utVar.f()));
                i3++;
                c = c;
            }
            this.a.put(g, hashMap);
        }
        if (utVar.c() - c != i) {
            dXRuntimeContext.getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", com.taobao.android.dinamicx.e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_ERROR, "reader.getPos() - startPos != length"));
            return false;
        }
        return true;
    }
}
