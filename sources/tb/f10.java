package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f10 extends wy {
    public f10() {
        this.d = "branch";
    }

    @Override // tb.wy
    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        List<wy> list = this.a;
        if (list != null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Object b = this.a.get(i).b(hyVar, dXRuntimeContext);
                if (b != null) {
                    arrayList.add(b.toString());
                }
            }
            return arrayList;
        }
        return null;
    }
}
