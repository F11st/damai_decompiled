package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import cn.damai.tetris.component.drama.bean.FilterBean;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.component.drama.mvp.FilterContract;
import cn.damai.tetris.component.drama.viewholder.FilterViewHolder;
import cn.damai.tetris.componentplugin.C1985a;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.ja;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FilterView extends AbsView<FilterContract.Presenter> implements FilterContract.View<FilterContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private FilterViewHolder viewHolder;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.drama.mvp.FilterView$a */
    /* loaded from: classes7.dex */
    public class C1824a implements FilterViewHolder.OnItemExposeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1824a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemExposeListener
        public void onSortTypeExpose(View view, List<FilterMainBean> list, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-284048255")) {
                ipChange.ipc$dispatch("-284048255", new Object[]{this, view, list, Integer.valueOf(i)});
                return;
            }
            FilterContract.Presenter presenter = FilterView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeSortType(view, list, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.FilterViewHolder.OnItemExposeListener
        public void onTagTypeExpose(View view, List<FilterTagBean> list, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-205230475")) {
                ipChange.ipc$dispatch("-205230475", new Object[]{this, view, list, Integer.valueOf(i)});
                return;
            }
            FilterContract.Presenter presenter = FilterView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeTagType(view, list, i);
            }
        }
    }

    public FilterView(View view) {
        super(view);
        FilterViewHolder filterViewHolder = new FilterViewHolder(view, null);
        this.viewHolder = filterViewHolder;
        filterViewHolder.l(new C1824a());
    }

    @Override // cn.damai.tetris.component.drama.mvp.FilterContract.View
    public void setData(FilterBean filterBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1547813533")) {
            ipChange.ipc$dispatch("-1547813533", new Object[]{this, filterBean, Integer.valueOf(i)});
            return;
        }
        ja context = getContext();
        if (context != null) {
            this.viewHolder.m(new C1985a.C1986a(context));
            xr.c(context.a(), new Message(2050, new C1985a(this.viewHolder)));
        }
        this.viewHolder.a(filterBean, i);
    }
}
