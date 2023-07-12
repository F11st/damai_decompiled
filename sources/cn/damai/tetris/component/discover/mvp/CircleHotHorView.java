package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.commonbusiness.discover.bean.CircleListWrapBean;
import cn.damai.commonbusiness.discover.viewholder.CircleHotHorViewHolder;
import cn.damai.tetris.component.discover.mvp.CircleHotHorContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CircleHotHorView extends AbsView<CircleHotHorContract.Presenter> implements CircleHotHorContract.View<CircleHotHorContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CircleHotHorViewHolder mViewHolder;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.CircleHotHorView$a */
    /* loaded from: classes7.dex */
    public class C1816a implements OnItemBindListener<CircleBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1816a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, CircleBean circleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "866386699")) {
                ipChange.ipc$dispatch("866386699", new Object[]{this, view, circleBean, Integer.valueOf(i)});
                return;
            }
            CircleHotHorContract.Presenter presenter = CircleHotHorView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeItem(view, circleBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(CircleBean circleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "344020416")) {
                ipChange.ipc$dispatch("344020416", new Object[]{this, circleBean, Integer.valueOf(i)});
                return;
            }
            CircleHotHorContract.Presenter presenter = CircleHotHorView.this.getPresenter();
            if (presenter != null) {
                presenter.itemClick(circleBean, i);
            }
        }
    }

    public CircleHotHorView(View view) {
        super(view);
        this.mViewHolder = new CircleHotHorViewHolder(view, new C1816a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.CircleHotHorContract.View
    public void setData(CircleListWrapBean circleListWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785645937")) {
            ipChange.ipc$dispatch("1785645937", new Object[]{this, circleListWrapBean, Integer.valueOf(i)});
        } else {
            this.mViewHolder.a(circleListWrapBean, i);
        }
    }
}
