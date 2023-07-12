package tb;

import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yx1 implements TBSwipeRefreshLayout.OnPullRefreshListener {
    public static final long DXRECYCLERLAYOUT_ONPULLTOREFRESH = 3436304507723682587L;
    protected hy a = new hy(DXRECYCLERLAYOUT_ONPULLTOREFRESH);
    private DXRecyclerLayout b;
    private TBSwipeRefreshLayout.OnPullRefreshListener c;

    public yx1(DXRecyclerLayout dXRecyclerLayout) {
        this.b = dXRecyclerLayout;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.OnPullRefreshListener
    public void onPullDistance(int i) {
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.c;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onPullDistance(i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.OnPullRefreshListener
    public void onRefresh() {
        DXRecyclerLayout dXRecyclerLayout = this.b;
        if (dXRecyclerLayout != null) {
            dXRecyclerLayout.postEvent(this.a);
        }
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.c;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefresh();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout.OnPullRefreshListener
    public void onRefreshStateChanged(TBAbsRefreshHeader.RefreshState refreshState, TBAbsRefreshHeader.RefreshState refreshState2) {
        TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.c;
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefreshStateChanged(refreshState, refreshState2);
        }
    }
}
