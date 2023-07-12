package tb;

import android.util.Log;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.template.loader.binary.IDXStringSupport;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k10 implements IDXStringSupport {
    private DXLongSparseArray<String> a;

    public boolean a(int i, C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        if (i == 0) {
            return true;
        }
        int b = c9787ut.b();
        short h = c9787ut.h();
        if (h < 0) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_COUNT_ERROR));
            return false;
        }
        this.a = new DXLongSparseArray<>(h);
        for (int i2 = 0; i2 < h; i2++) {
            long g = c9787ut.g();
            short h2 = c9787ut.h();
            if (c9787ut.c() + h2 <= b) {
                this.a.put(g, new String(c9787ut.a(), c9787ut.c(), (int) h2));
                c9787ut.j(h2);
            } else {
                dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_ERROR));
                Log.e("StringLoader_TMTEST", "read string over");
                return false;
            }
        }
        return true;
    }

    @Override // com.taobao.android.dinamicx.template.loader.binary.IDXStringSupport
    public String getString(long j) {
        DXLongSparseArray<String> dXLongSparseArray = this.a;
        if (dXLongSparseArray != null && dXLongSparseArray.get(j) != null) {
            return this.a.get(j);
        }
        if (DinamicXEngine.x()) {
            Log.e("StringLoader_TMTEST", "getString null:" + j);
            return null;
        }
        return null;
    }
}
