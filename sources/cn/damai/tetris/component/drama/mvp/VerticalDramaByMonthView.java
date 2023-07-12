package cn.damai.tetris.component.drama.mvp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.DramaMonthBean;
import cn.damai.tetris.component.drama.bean.DramaV1Bean;
import cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract;
import cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder;
import cn.damai.tetris.component.drama.viewholder.FocusUiCall;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.ja;
import tb.mg;
import tb.mu0;
import tb.mx2;
import tb.wh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VerticalDramaByMonthView extends AbsView<VerticalDramaByMonthContract.Presenter> implements VerticalDramaByMonthContract.View<VerticalDramaByMonthContract.Presenter>, View.OnClickListener, DramaCardHorViewHolder.OnDramaItemClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_SHOW_COUNT = 5;
    private LinearLayout mDramaListContainer;
    private DramaMonthBean mMonthBean;
    private View mNoMoreV;
    private mg mPanel;
    private int mPos;
    private String mSectionId;
    private View mShowMoreBtn;
    private List<DramaV1Bean> mTotalList;

    public VerticalDramaByMonthView(View view) {
        super(view);
        this.mDramaListContainer = (LinearLayout) view.findViewById(R$id.drama_list_container);
        this.mShowMoreBtn = view.findViewById(R$id.drama_show_more);
        this.mNoMoreV = view.findViewById(R$id.drama_no_more);
        this.mShowMoreBtn.setOnClickListener(this);
        this.mPanel = new mg(view);
    }

    @SuppressLint({"ViewTag", "NewApi"})
    private void bindDramaList(List<DramaV1Bean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506911300")) {
            ipChange.ipc$dispatch("506911300", new Object[]{this, list});
            return;
        }
        check2ShowNoMore();
        int childCount = this.mDramaListContainer.getChildCount();
        int e = wh2.e(list);
        if (e > childCount) {
            int i = e - childCount;
            for (int i2 = 0; i2 < i; i2++) {
                DramaCardHorViewHolder dramaCardHorViewHolder = new DramaCardHorViewHolder(mu0.a(), this.mDramaListContainer, this);
                dramaCardHorViewHolder.itemView.setTag(R$id.holder_id, dramaCardHorViewHolder);
                this.mDramaListContainer.addView(dramaCardHorViewHolder.itemView);
            }
        } else if (e < childCount) {
            this.mDramaListContainer.removeViews(e, childCount - e);
        }
        if (cb2.d(list)) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            DramaV1Bean dramaV1Bean = list.get(i3);
            View childAt = this.mDramaListContainer.getChildAt(i3);
            if (childAt != null) {
                Object tag = childAt.getTag(R$id.holder_id);
                if (tag instanceof DramaCardHorViewHolder) {
                    ((DramaCardHorViewHolder) tag).a(dramaV1Bean, i3);
                }
                VerticalDramaByMonthContract.Presenter presenter = getPresenter();
                if (presenter != null) {
                    presenter.exposeItem(childAt, dramaV1Bean, i3);
                }
            }
        }
    }

    private void check2ShowNoMore() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "971512306")) {
            ipChange.ipc$dispatch("971512306", new Object[]{this});
        } else if (this.mMonthBean != null) {
            boolean z2 = wh2.e(this.mTotalList) > 5;
            DramaMonthBean dramaMonthBean = this.mMonthBean;
            if (!dramaMonthBean.isLastTab || (!dramaMonthBean.isExpand && z2)) {
                z = false;
            }
            this.mNoMoreV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647535520")) {
            ipChange.ipc$dispatch("-1647535520", new Object[]{this, view});
        } else if (view.getId() == R$id.drama_show_more) {
            this.mShowMoreBtn.setVisibility(8);
            DramaMonthBean dramaMonthBean = this.mMonthBean;
            if (dramaMonthBean != null) {
                dramaMonthBean.isExpand = true;
                getPresenter().utShowAllClick(this, this.mMonthBean, this.mPos);
            }
            bindDramaList(this.mTotalList);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder.OnDramaItemClickListener
    public void onDramaItemClick(DramaV1Bean dramaV1Bean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1097408134")) {
            ipChange.ipc$dispatch("-1097408134", new Object[]{this, dramaV1Bean, Integer.valueOf(i)});
            return;
        }
        DramaMonthBean dramaMonthBean = this.mMonthBean;
        if (dramaMonthBean != null) {
            dramaV1Bean.tempLabelName = dramaMonthBean.labelName;
        }
        getPresenter().itemClick(this, dramaV1Bean, i);
    }

    @Override // cn.damai.tetris.component.drama.viewholder.DramaCardHorViewHolder.OnDramaItemClickListener
    public void onFocusClick(FocusUiCall focusUiCall, DramaV1Bean dramaV1Bean, int i) {
        ja context;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1043133070")) {
            ipChange.ipc$dispatch("1043133070", new Object[]{this, focusUiCall, dramaV1Bean, Integer.valueOf(i)});
        } else if (this.mMonthBean == null || dramaV1Bean == null || (context = getContext()) == null) {
        } else {
            getPresenter().utFocusClick(this, dramaV1Bean, i);
            xr.c(context.a(), new Message(mx2.TYPE_CLICK_FOCUS, new mx2(focusUiCall, this.mSectionId, dramaV1Bean)));
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.VerticalDramaByMonthContract.View
    public void setData(DramaMonthBean dramaMonthBean, String str, int i) {
        List<DramaV1Bean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1506632474")) {
            ipChange.ipc$dispatch("1506632474", new Object[]{this, dramaMonthBean, str, Integer.valueOf(i)});
        } else if (dramaMonthBean == null) {
        } else {
            this.mMonthBean = dramaMonthBean;
            this.mPos = i;
            this.mSectionId = str;
            this.mPanel.f(dramaMonthBean.labelName);
            this.mPanel.d(false);
            List<DramaV1Bean> list2 = dramaMonthBean.content;
            this.mTotalList = list2;
            boolean z = dramaMonthBean.isExpand;
            boolean z2 = wh2.e(list2) > 5;
            if (z) {
                this.mShowMoreBtn.setVisibility(8);
            } else if (z2) {
                this.mShowMoreBtn.setVisibility(0);
            } else {
                this.mShowMoreBtn.setVisibility(8);
            }
            if (z) {
                list = this.mTotalList;
            } else if (z2) {
                list = new ArrayList(this.mTotalList).subList(0, 5);
            } else {
                list = this.mTotalList;
            }
            bindDramaList(list);
        }
    }
}
