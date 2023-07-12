package cn.damai.homepage.v2.feed;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.commonbusiness.discover.viewholder.VotePanel;
import cn.damai.homepage.R$id;
import cn.damai.uikit.tag.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.m62;
import tb.mu0;
import tb.ux0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class VoteViewHolder extends BaseViewHolder<VoteInfoBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private VoteInfoBean mBean;
    private VotePanel mPanel;
    private View mRoot;
    private ImageView mTopImg;
    private DMCategroyTagView mVoteTag;
    private View mVoteTagNew;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements VotePanel.VoteActionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        @Nullable
        public Activity getActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-872124572")) {
                return (Activity) ipChange.ipc$dispatch("-872124572", new Object[]{this});
            }
            Context context = this.a;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return null;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void onVoteInfoUpdate(@NonNull VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-154522778")) {
                ipChange.ipc$dispatch("-154522778", new Object[]{this, voteInfoBean});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteActionListener
        public void showActivityLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1349008891")) {
                ipChange.ipc$dispatch("1349008891", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            Activity activity = getActivity();
            if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                if (z) {
                    baseActivity.startProgressDialog();
                } else {
                    baseActivity.stopProgressDialog();
                }
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "823364535")) {
                ipChange.ipc$dispatch("823364535", new Object[]{this, voteInfoBean});
            } else {
                ux0.i().f(ux0.g(VoteViewHolder.this.getComponentActions()), "", "", "", "12", voteInfoBean.id, VoteViewHolder.this.getData().getIndex());
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-447187041")) {
                ipChange.ipc$dispatch("-447187041", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            } else {
                ux0.i().k(ux0.g(VoteViewHolder.this.getComponentActions()), view, "", "", "", "12", voteInfoBean.id, VoteViewHolder.this.getData().getIndex());
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
        public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "656250579")) {
                ipChange.ipc$dispatch("656250579", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            } else {
                ux0.i().m(ux0.g(VoteViewHolder.this.getComponentActions()), "", "", "", "12", voteBean.id, VoteViewHolder.this.getData().getIndex());
            }
        }
    }

    public VoteViewHolder(View view) {
        super(view);
        this.mRoot = view.findViewById(R$id.item_feed_vote_ui);
        this.mTopImg = (ImageView) view.findViewById(R$id.item_feed_vote_top_img);
        this.mVoteTag = (DMCategroyTagView) view.findViewById(R$id.item_vote_tag);
        this.mVoteTagNew = view.findViewById(R$id.item_vote_tag_img);
        this.mPanel = new VotePanel((ViewGroup) view.findViewById(R$id.item_vote_layout_id), getActionListener(view.getContext()));
    }

    private VotePanel.VoteActionListener getActionListener(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "51819380") ? (VotePanel.VoteActionListener) ipChange.ipc$dispatch("51819380", new Object[]{this, context}) : new a(context);
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NonNull IItem<ItemValue> iItem) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602159301")) {
            ipChange.ipc$dispatch("1602159301", new Object[]{this, iItem});
        } else if (this.mBean == getValue()) {
        } else {
            VoteInfoBean value = getValue();
            this.mBean = value;
            this.mRoot.setBackground(value.getVoteBgDrawable());
            if (TextUtils.isEmpty(this.mBean.activityTag)) {
                this.mVoteTag.setVisibility(8);
                this.mVoteTagNew.setVisibility(8);
            } else if ("投票".equals(this.mBean.activityTag)) {
                this.mVoteTagNew.setVisibility(0);
                this.mVoteTag.setVisibility(8);
            } else {
                this.mVoteTagNew.setVisibility(8);
                this.mVoteTag.setVisibility(0);
                this.mVoteTag.setTagName(this.mBean.activityTag);
                this.mVoteTag.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            }
            String str = this.mBean.feedBackground;
            if (TextUtils.isEmpty(str)) {
                this.mTopImg.setVisibility(8);
                i = m62.a(mu0.a(), 37.0f);
            } else {
                this.mTopImg.setVisibility(0);
                int a2 = m62.a(mu0.a(), 82.0f);
                cn.damai.common.image.a.b().f(str, (DisplayMetrics.getwidthPixels(m62.b(mu0.a())) - (m62.a(mu0.a(), 21.0f) * 2)) / 2, m62.a(mu0.a(), 90.0f)).g(this.mTopImg);
                i = a2;
            }
            View i2 = this.mPanel.i();
            ViewGroup.LayoutParams layoutParams = i2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i;
                i2.setLayoutParams(layoutParams);
            }
            this.mPanel.d(this.mBean, getRankInModule());
        }
    }
}
