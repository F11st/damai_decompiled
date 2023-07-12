package tb;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vk extends r1 {
    public vk() {
        new Rect();
    }

    @Override // tb.r1, com.alibaba.android.vlayout.a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (cVar.c) {
            cVar.a = getRange().e().intValue();
        } else {
            cVar.a = getRange().d().intValue();
        }
    }
}
