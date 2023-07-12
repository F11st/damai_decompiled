package cn.damai.tetris.component.discover.mvp;

import android.view.View;
import cn.damai.commonbusiness.discover.bean.HeadFixedBean;
import cn.damai.commonbusiness.discover.bean.HeadFixedWrapBean;
import cn.damai.commonbusiness.discover.viewholder.HeadFixedViewHolder;
import cn.damai.tetris.component.discover.mvp.HeadFixedContract;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HeadFixedView extends AbsView<HeadFixedContract.Presenter> implements HeadFixedContract.View<HeadFixedContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HeadFixedViewHolder mViewHolder;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.discover.mvp.HeadFixedView$a */
    /* loaded from: classes7.dex */
    public class C1819a implements OnItemBindListener<HeadFixedBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1819a() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, HeadFixedBean headFixedBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-445930925")) {
                ipChange.ipc$dispatch("-445930925", new Object[]{this, view, headFixedBean, Integer.valueOf(i)});
                return;
            }
            HeadFixedContract.Presenter presenter = HeadFixedView.this.getPresenter();
            if (presenter != null) {
                presenter.exposeItem(view, headFixedBean, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(HeadFixedBean headFixedBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1608986498")) {
                ipChange.ipc$dispatch("-1608986498", new Object[]{this, headFixedBean, Integer.valueOf(i)});
                return;
            }
            HeadFixedContract.Presenter presenter = HeadFixedView.this.getPresenter();
            if (presenter != null) {
                presenter.itemClick(headFixedBean, i);
            }
        }
    }

    public HeadFixedView(View view) {
        super(view);
        this.mViewHolder = new HeadFixedViewHolder(view, new C1819a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.HeadFixedContract.View
    public void setData(HeadFixedWrapBean headFixedWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208446655")) {
            ipChange.ipc$dispatch("1208446655", new Object[]{this, headFixedWrapBean, Integer.valueOf(i)});
        } else {
            this.mViewHolder.a(headFixedWrapBean, i);
        }
    }
}
