package cn.damai.category.discountticket.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.irecycler.OnLoadMoreListener;
import cn.damai.uikit.irecycler.widget.LoadMoreFooterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UpLoadMorePanel implements OnLoadMoreListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATE_EMPTY = 19;
    public static final int STATE_LOADING_MORE = 18;
    public static final int STATE_NONE = 20;
    private View a;
    private IRecyclerView b;
    private LoadMoreEventListener c;
    private int d = 20;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface LoadMoreEventListener {
        void startLoadMore();
    }

    public UpLoadMorePanel(Context context, IRecyclerView iRecyclerView, LoadMoreEventListener loadMoreEventListener) {
        this.b = iRecyclerView;
        this.c = loadMoreEventListener;
        iRecyclerView.setOnLoadMoreListener(this);
        this.a = LayoutInflater.from(context).inflate(R$layout.common_footer_empty_new, (ViewGroup) null);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, t60.a(context, 110.0f)));
        iRecyclerView.addFooterView(this.a);
        this.a.setVisibility(8);
    }

    private void a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "563908902")) {
            ipChange.ipc$dispatch("563908902", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153490461")) {
            ipChange.ipc$dispatch("-1153490461", new Object[]{this});
            return;
        }
        a(20);
        this.a.setVisibility(8);
        this.b.getLoadMoreFooterView().setVisibility(8);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301175614")) {
            ipChange.ipc$dispatch("-301175614", new Object[]{this});
            return;
        }
        a(19);
        this.a.setVisibility(0);
        this.b.getLoadMoreFooterView().setVisibility(8);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.GONE);
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "709148736")) {
            ipChange.ipc$dispatch("709148736", new Object[]{this});
            return;
        }
        a(18);
        this.a.setVisibility(8);
        this.b.getLoadMoreFooterView().setVisibility(0);
        this.b.setLoadMoreStatus(LoadMoreFooterView.Status.LOADING);
    }

    @Override // cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666818752")) {
            ipChange.ipc$dispatch("1666818752", new Object[]{this, view});
        } else if (this.d == 20 && this.c != null) {
            d();
            this.c.startLoadMore();
        }
    }
}
