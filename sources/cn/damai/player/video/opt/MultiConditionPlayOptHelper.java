package cn.damai.player.video.opt;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.player.video.ProxyVideoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MultiConditionPlayOptHelper extends RecyclerView.OnScrollListener implements PlayOptHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;
    private View b;
    private ProxyVideoView c;
    private int d;
    private boolean e = true;

    @RequiresApi(api = 12)
    public MultiConditionPlayOptHelper(RecyclerView recyclerView, View view, ProxyVideoView proxyVideoView) {
        this.a = recyclerView;
        this.b = view;
        this.c = proxyVideoView;
        recyclerView.addOnScrollListener(this);
        this.d = m62.a(mu0.a(), 46.0f);
    }

    public void a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1177642642")) {
            ipChange.ipc$dispatch("1177642642", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.e = z;
        }
    }

    @Override // cn.damai.player.video.opt.PlayOptHelper
    public boolean isOutConditionSupportPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101887741")) {
            return ((Boolean) ipChange.ipc$dispatch("101887741", new Object[]{this})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "683923586")) {
            ipChange.ipc$dispatch("683923586", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else if (this.e && i == 0) {
            this.c.autoPlay();
        }
    }
}
