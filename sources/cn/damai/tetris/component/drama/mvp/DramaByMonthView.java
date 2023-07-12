package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.bean.DramaWrapBean;
import cn.damai.tetris.component.drama.mvp.DramaByMonthContract;
import cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaByMonthView extends AbsView<DramaByMonthContract.Presenter> implements DramaByMonthContract.View<DramaByMonthContract.Presenter>, DramaByMonthViewHolder.OnDramaByMonthClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DramaByMonthViewHolder mViewHolder;

    public DramaByMonthView(View view) {
        super(view);
        this.mViewHolder = new DramaByMonthViewHolder(view, this);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.OnDramaByMonthClickListener
    public void expose(View view, DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "305123071")) {
            ipChange.ipc$dispatch("305123071", new Object[]{this, view, dramaV1Bean, Integer.valueOf(i)});
        } else {
            getPresenter().exposeDrama(view, dramaV1Bean, i);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.OnDramaByMonthClickListener
    public void onAllClick(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-849508419")) {
            ipChange.ipc$dispatch("-849508419", new Object[]{this, str});
        } else {
            getPresenter().onAllClick(this, str);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.OnDramaByMonthClickListener
    public void onDramaClick(DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406152291")) {
            ipChange.ipc$dispatch("406152291", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
        } else {
            getPresenter().itemClick(this, dramaV1Bean, i);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaByMonthViewHolder.OnDramaByMonthClickListener
    public void onTabClick(DramaMonthBean dramaMonthBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "798904444")) {
            ipChange.ipc$dispatch("798904444", new Object[]{this, dramaMonthBean, Integer.valueOf(i)});
        } else {
            getPresenter().onTabClick(this, dramaMonthBean, i);
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.DramaByMonthContract.View
    public void setData(DramaWrapBean dramaWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1897355462")) {
            ipChange.ipc$dispatch("1897355462", new Object[]{this, dramaWrapBean, Integer.valueOf(i)});
        } else {
            this.mViewHolder.a(dramaWrapBean, i);
        }
    }
}
