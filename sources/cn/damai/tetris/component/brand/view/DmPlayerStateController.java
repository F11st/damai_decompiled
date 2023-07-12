package cn.damai.tetris.component.brand.view;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.video.opt.PlayOptHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DmPlayerStateController extends RecyclerView.OnScrollListener implements PlayOptHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;
    private View b;
    private DMVideoPlayer c;
    private int d;
    private boolean e = true;

    @RequiresApi(api = 12)
    public DmPlayerStateController(RecyclerView recyclerView, View view, DMVideoPlayer dMVideoPlayer) {
        this.a = recyclerView;
        this.b = view;
        this.c = dMVideoPlayer;
        recyclerView.addOnScrollListener(this);
        this.d = m62.a(mu0.a(), 46.0f);
    }

    public void a(DMVideoPlayer dMVideoPlayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-612701130")) {
            ipChange.ipc$dispatch("-612701130", new Object[]{this, dMVideoPlayer});
        } else {
            this.c = dMVideoPlayer;
        }
    }

    @Override // cn.damai.player.video.opt.PlayOptHelper
    public boolean isOutConditionSupportPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912254913")) {
            return ((Boolean) ipChange.ipc$dispatch("-1912254913", new Object[]{this})).booleanValue();
        }
        if (this.a.getScrollState() == 0 && this.b.getParent() == this.a) {
            int height = this.c.getHeight();
            int top = this.b.getTop() + this.d;
            int i = height + top;
            int height2 = this.a.getHeight();
            if (height > height2) {
                return top >= 0 ? ((float) top) <= ((float) height2) * 0.5f : ((float) i) >= ((float) height2) * 0.5f;
            }
            int i2 = (int) (height * 0.3333333f);
            return top >= (-i2) && i <= height2 + i2;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098957568")) {
            ipChange.ipc$dispatch("-2098957568", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (this.e && i == 0) {
            this.c.autoPlay();
        }
    }
}
