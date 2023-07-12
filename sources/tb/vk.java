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

    @Override // tb.r1, com.alibaba.android.vlayout.AbstractC3289a
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.C3286c c3286c, LayoutManagerHelper layoutManagerHelper) {
        if (c3286c.c) {
            c3286c.a = getRange().e().intValue();
        } else {
            c3286c.a = getRange().d().intValue();
        }
    }
}
