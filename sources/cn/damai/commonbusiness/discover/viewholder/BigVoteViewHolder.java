package cn.damai.commonbusiness.discover.viewholder;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class BigVoteViewHolder extends BaseViewHolder<VoteInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private VotePanel a;
    private View b;
    private VoteInfoBean c;

    public BigVoteViewHolder(View view, VotePanel.VoteActionListener voteActionListener) {
        super(view);
        this.b = view.findViewById(R$id.item_feed_vote_ui);
        this.a = new VotePanel((ViewGroup) view.findViewById(R$id.item_vote_layout_id), voteActionListener);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: c */
    public void a(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162471831")) {
            ipChange.ipc$dispatch("-1162471831", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        } else if (voteInfoBean == null || this.c == voteInfoBean) {
        } else {
            this.c = voteInfoBean;
            this.a.e(voteInfoBean, i, 1);
        }
    }
}
