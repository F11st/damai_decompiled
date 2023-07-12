package cn.damai.tetris.component.discover.mvp;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.BigVoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.tetris.component.discover.mvp.BigVoteContract;
import cn.damai.tetris.core.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ja;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BigVoteView extends AbsView<BigVoteContract.Presenter> implements BigVoteContract.View<BigVoteContract.Presenter> {
    private static transient /* synthetic */ IpChange $ipChange;
    private BigVoteViewHolder mHolder;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1838817779")) {
                return (Activity) ipChange.ipc$dispatch("1838817779", new Object[]{this});
            }
            ja context = BigVoteView.this.getContext();
            if (context != null) {
                return context.getActivity();
            }
            return null;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-575798667")) {
                ipChange.ipc$dispatch("-575798667", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-578679030")) {
                ipChange.ipc$dispatch("-578679030", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof BaseActivity) {
                if (z) {
                    ((BaseActivity) activity).startProgressDialog();
                } else {
                    ((BaseActivity) activity).stopProgressDialog();
                }
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-295838970")) {
                ipChange.ipc$dispatch("-295838970", new Object[]{this, voteInfoBean});
                return;
            }
            BigVoteContract.Presenter presenter = BigVoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4CancelVoteClick(voteInfoBean);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "36315056")) {
                ipChange.ipc$dispatch("36315056", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
                return;
            }
            BigVoteContract.Presenter presenter = BigVoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4VoteCardExposure(view, voteInfoBean, i);
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-619942876")) {
                ipChange.ipc$dispatch("-619942876", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
                return;
            }
            BigVoteContract.Presenter presenter = BigVoteView.this.getPresenter();
            if (presenter != null) {
                presenter.ut4VoteClick(voteInfoBean, voteBean, i);
            }
        }
    }

    public BigVoteView(View view) {
        super(view);
        this.mHolder = new BigVoteViewHolder(view, new a());
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigVoteContract.View
    public void setData(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922847997")) {
            ipChange.ipc$dispatch("-1922847997", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        } else {
            this.mHolder.a(voteInfoBean, i);
        }
    }

    @Override // cn.damai.tetris.core.AbsView, cn.damai.tetris.core.IView
    public void setPresenter(BigVoteContract.Presenter presenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590741421")) {
            ipChange.ipc$dispatch("1590741421", new Object[]{this, presenter});
        } else {
            super.setPresenter((BigVoteView) presenter);
        }
    }
}
