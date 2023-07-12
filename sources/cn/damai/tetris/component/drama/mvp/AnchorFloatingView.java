package cn.damai.tetris.component.drama.mvp;

import android.view.View;
import android.widget.LinearLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.drama.bean.AnchorBean;
import cn.damai.tetris.component.drama.bean.AnchorEvent;
import cn.damai.tetris.component.drama.bean.AnchorList;
import cn.damai.tetris.component.drama.mvp.AnchorFloatingContract;
import cn.damai.tetris.component.drama.viewholder.AnchorViewHolder;
import cn.damai.tetris.component.drama.viewholder.OnItemClickListener;
import cn.damai.tetris.core.AbsView;
import cn.damai.tetris.core.msg.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.ja;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AnchorFloatingView extends AbsView<AnchorFloatingContract.Presenter> implements AnchorFloatingContract.View<AnchorFloatingContract.Presenter>, OnItemClickListener<AnchorBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout mAnchorGroup;
    private AnchorList mAnchorList;

    public AnchorFloatingView(View view) {
        super(view);
        this.mAnchorGroup = (LinearLayout) view.findViewById(R$id.anchor_horizontal_group);
    }

    private void bindAnchorGroup(AnchorList anchorList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348503129")) {
            ipChange.ipc$dispatch("1348503129", new Object[]{this, anchorList});
            return;
        }
        List<AnchorBean> list = anchorList.result;
        this.mAnchorGroup.removeAllViews();
        if (cb2.d(list)) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnchorViewHolder anchorViewHolder = new AnchorViewHolder(this.mAnchorGroup, this);
            View view = anchorViewHolder.itemView;
            view.setTag(R$id.holder_id, anchorViewHolder);
            anchorViewHolder.a(list.get(i), i);
            this.mAnchorGroup.addView(view);
        }
    }

    private void postEvent(int i, AnchorEvent anchorEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455419961")) {
            ipChange.ipc$dispatch("455419961", new Object[]{this, Integer.valueOf(i), anchorEvent});
            return;
        }
        ja context = getContext();
        if (context != null) {
            xr.c(context.a(), new Message(i, anchorEvent));
        }
    }

    public void notifyItemChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1172944192")) {
            ipChange.ipc$dispatch("1172944192", new Object[]{this});
            return;
        }
        int childCount = this.mAnchorGroup.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.mAnchorGroup.getChildAt(i);
                if (childAt != null) {
                    Object tag = childAt.getTag(R$id.holder_id);
                    if (tag instanceof AnchorViewHolder) {
                        ((AnchorViewHolder) tag).e();
                    }
                }
            }
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.AnchorFloatingContract.View
    public void setData(AnchorList anchorList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800056501")) {
            ipChange.ipc$dispatch("-1800056501", new Object[]{this, anchorList, Integer.valueOf(i)});
        } else if (anchorList == null) {
        } else {
            postEvent(52, new AnchorEvent(this));
            this.mAnchorList = anchorList;
            bindAnchorGroup(anchorList);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    public void onItemClick(AnchorBean anchorBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76553165")) {
            ipChange.ipc$dispatch("-76553165", new Object[]{this, anchorBean, Integer.valueOf(i)});
            return;
        }
        AnchorList anchorList = this.mAnchorList;
        if (anchorList != null) {
            anchorList.setSelectBean(anchorBean);
            notifyItemChanged();
            postEvent(51, new AnchorEvent(anchorBean));
            getPresenter().utClick(this, anchorBean, i);
        }
    }
}
