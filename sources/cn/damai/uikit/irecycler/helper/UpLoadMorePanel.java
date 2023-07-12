package cn.damai.uikit.irecycler.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UpLoadMorePanel implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATE_EMPTY = 19;
    public static final int STATE_LOADING_MORE = 18;
    public static final int STATE_NONE = 20;
    private View a;
    private DamaiRootRecyclerView b;
    private LoadMoreEventListener c;
    private int d = 20;
    private boolean e = true;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface LoadMoreEventListener {
        void startLoadMore();
    }

    public UpLoadMorePanel(Context context, DamaiRootRecyclerView damaiRootRecyclerView, LoadMoreEventListener loadMoreEventListener) {
        this.b = damaiRootRecyclerView;
        this.c = loadMoreEventListener;
        damaiRootRecyclerView.setLoadMoreEnabled(true);
        this.b.setOnLoadMoreListener(this);
        this.a = LayoutInflater.from(context).inflate(R$layout.damai_pageview_footer_empty, (ViewGroup) null);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, q60.a(context, 60.0f)));
        damaiRootRecyclerView.addFooterView(this.a);
        this.a.setVisibility(8);
    }

    public static void b(DamaiRootRecyclerView damaiRootRecyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707280828")) {
            ipChange.ipc$dispatch("707280828", new Object[]{damaiRootRecyclerView});
        } else if (damaiRootRecyclerView != null) {
            View loadMoreFooterView = damaiRootRecyclerView.getLoadMoreFooterView();
            if (loadMoreFooterView != null) {
                loadMoreFooterView.setBackgroundColor(0);
            }
            LinearLayout footerContainer = damaiRootRecyclerView.getFooterContainer();
            if (footerContainer != null) {
                int childCount = footerContainer.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    footerContainer.getChildAt(i).setBackgroundColor(0);
                }
            }
        }
    }

    private void c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252501145")) {
            ipChange.ipc$dispatch("1252501145", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626608516")) {
            ipChange.ipc$dispatch("-1626608516", new Object[]{this});
        } else {
            b(this.b);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786888726")) {
            ipChange.ipc$dispatch("786888726", new Object[]{this});
            return;
        }
        c(20);
        this.a.setVisibility(8);
        this.b.getLoadMoreFooterView().setVisibility(8);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    public void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376207490")) {
            ipChange.ipc$dispatch("-1376207490", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.e = z;
        d();
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1977869651")) {
            ipChange.ipc$dispatch("-1977869651", new Object[]{this});
            return;
        }
        c(18);
        this.a.setVisibility(8);
        this.b.getLoadMoreFooterView().setVisibility(0);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701024718")) {
            ipChange.ipc$dispatch("-701024718", new Object[]{this});
            return;
        }
        c(19);
        this.a.setVisibility(0);
        this.b.getLoadMoreFooterView().setVisibility(8);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843153229")) {
            ipChange.ipc$dispatch("-843153229", new Object[]{this, view});
        } else if (this.d == 20 && this.e && this.c != null) {
            f();
            this.c.startLoadMore();
        }
    }
}
