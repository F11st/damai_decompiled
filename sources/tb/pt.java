package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pt extends wy {
    public pt() {
        this.d = "branch";
    }

    @Override // tb.wy
    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        int size = this.a.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                Object b = this.a.get(i).b(hyVar, dXRuntimeContext);
                if (b != null) {
                    return b;
                }
            }
            return null;
        }
        return null;
    }
}
