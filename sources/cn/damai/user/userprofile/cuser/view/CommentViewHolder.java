package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsAdapter;
import cn.damai.user.userprofile.bean.CommentFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.WatchFeedData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.cs;
import tb.g41;
import tb.kv2;
import tb.lu2;
import tb.qd2;
import tb.t60;
import tb.u12;
import tb.wh2;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CommentViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public TextView A;
    public TextView B;
    public View C;
    public View D;
    Activity w;
    public RelativeLayout x;
    public TextView y;
    public ImageView z;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentFeedData a;
        final /* synthetic */ FeedMergeDataDO b;

        a(CommentFeedData commentFeedData, FeedMergeDataDO feedMergeDataDO) {
            this.a = commentFeedData;
            this.b = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1549316300")) {
                ipChange.ipc$dispatch("-1549316300", new Object[]{this, view});
            } else if (this.a != null) {
                if (CommentViewHolder.this.j() == FeedsAdapter.G) {
                    Bundle bundle = new Bundle();
                    CommentFeedData commentFeedData = this.a;
                    if (commentFeedData instanceof WatchFeedData) {
                        bundle.putString("contentId", ((WatchFeedData) commentFeedData).contentId);
                    }
                    DMNav.from(CommentViewHolder.this.w).withExtras(bundle).toUri(INavUri.page(cs.DISCOVER_CONTENT_DETAIL));
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(g41.ISSUE_PARAM_COMMENT_ID, this.a.bizId);
                    DMNav.from(CommentViewHolder.this.w).needLogin().withExtras(bundle2).toUri(NavUri.b("commentdetail"));
                }
                HashMap hashMap = new HashMap();
                CommentFeedData commentFeedData2 = this.a;
                if (commentFeedData2 != null) {
                    hashMap.put("content_id", commentFeedData2.bizId);
                    hashMap.put("content_type", this.b.bizType);
                    hashMap.put("circle_id", CommentViewHolder.this.u);
                }
                CommentViewHolder commentViewHolder = CommentViewHolder.this;
                Activity activity = commentViewHolder.w;
                String str = commentViewHolder.q;
                kv2.f(activity, str, lu2.DYNAMIC, "dynamic_" + CommentViewHolder.this.itemView.getTag(), true, CommentViewHolder.this.t, hashMap);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        Bundle a = new Bundle();
        final /* synthetic */ FeedMergeDataDO b;
        final /* synthetic */ CommentFeedData c;

        b(FeedMergeDataDO feedMergeDataDO, CommentFeedData commentFeedData) {
            this.b = feedMergeDataDO;
            this.c = commentFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "561974069")) {
                ipChange.ipc$dispatch("561974069", new Object[]{this, view});
            } else if (this.b.getSubType().intValue() != 20 && this.c.targetDataType != 1 && this.b.getSubType().intValue() != FeedsAdapter.t && this.b.getSubType().intValue() != FeedsAdapter.u) {
                if (this.b.getSubType().intValue() == 22 || this.c.targetDataType == 2) {
                    this.a.putString(RepertoireDetailFragment.REPERTOIREID, this.c.targetId);
                    DMNav.from(CommentViewHolder.this.w).withExtras(this.a).toUri(NavUri.b(u12.REPERTOITE));
                }
            } else {
                CommentFeedData commentFeedData = this.c;
                if (commentFeedData.viewStatus == 0) {
                    ToastUtil.i("该商品已下架");
                    return;
                }
                try {
                    this.a.putLong(IssueConstants.ProjectID, Long.parseLong(commentFeedData.targetId));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                qd2.a(CommentViewHolder.this.w, this.c.schema, this.a);
            }
        }
    }

    public CommentViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        this.x = (RelativeLayout) view.findViewById(R$id.ll_itemcell);
        this.y = (TextView) view.findViewById(R$id.tv_comment);
        this.v = (NineGridlayout) view.findViewById(R$id.ninelayout);
        TextView textView = (TextView) view.findViewById(R$id.user_feed_fabuquanzi);
        this.z = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        this.A = (TextView) view.findViewById(R$id.feeds_item_playtitle);
        this.B = (TextView) view.findViewById(R$id.feeds_item_subtitle);
        this.C = view.findViewById(R$id.feed_unclick_tag);
        this.D = view.findViewById(R$id.iv_comment_luxury);
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        List<WatchFeedData> list;
        WatchFeedData watchFeedData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52571496")) {
            ipChange.ipc$dispatch("52571496", new Object[]{this, feedMergeDataDO});
            return;
        }
        Log.e("titleRatingBar", "updateData cvh ");
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if ((list2 == null || list2.size() <= 0) && ((list = feedMergeDataDO.watchData) == null || list.size() <= 0)) {
            return;
        }
        List<CommentFeedData> list3 = feedMergeDataDO.commentData;
        if (list3 != null) {
            watchFeedData = list3.get(0);
        } else {
            watchFeedData = feedMergeDataDO.watchData.get(0);
        }
        if (this.y == null) {
            return;
        }
        if (this.A != null && !wh2.j(watchFeedData.comment)) {
            this.A.setText(watchFeedData.comment);
        }
        if (this.z != null && !wh2.j(watchFeedData.targetImg)) {
            DMImageCreator k = cn.damai.common.image.a.b().c(watchFeedData.targetImg).k(new DMRoundedCornersBitmapProcessor(t60.a(this.w, 3.0f), 0));
            int i = R$drawable.uikit_user_default_icon;
            k.i(i).c(i).g(this.z);
        }
        if (!wh2.j(watchFeedData.targetName)) {
            this.A.setText(watchFeedData.targetName);
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        if (wh2.j(watchFeedData.targetDesc)) {
            String l = l(watchFeedData.targetCityName, watchFeedData.targetShowTime, watchFeedData.targetPlace);
            if (!wh2.j(l)) {
                this.B.setText(l);
            } else if (!wh2.j(watchFeedData.targetDesc)) {
                this.B.setText(watchFeedData.targetDesc);
            }
        } else {
            this.B.setText(watchFeedData.targetDesc);
        }
        if (wh2.j(watchFeedData.comment)) {
            this.y.setText("发表评论");
        } else {
            this.y.setText(watchFeedData.comment);
        }
        View view = this.C;
        if (view != null) {
            view.setVisibility(8);
            if ((feedMergeDataDO.getSubType().intValue() == 20 || watchFeedData.targetDataType == 1 || feedMergeDataDO.getSubType().intValue() == FeedsAdapter.t || feedMergeDataDO.getSubType().intValue() == FeedsAdapter.u) && watchFeedData.viewStatus == 0) {
                this.C.setVisibility(0);
            }
        }
        this.itemView.setOnClickListener(new a(watchFeedData, feedMergeDataDO));
        this.x.setOnClickListener(new b(feedMergeDataDO, watchFeedData));
        if (watchFeedData instanceof WatchFeedData) {
            WatchFeedData watchFeedData2 = (WatchFeedData) watchFeedData;
            if (watchFeedData2.imgs == null && watchFeedData2.videoInfo == null) {
                NineGridlayout nineGridlayout = this.v;
                if (nineGridlayout != null) {
                    nineGridlayout.setVisibility(8);
                }
            } else {
                this.v.setVisibility(0);
                r((ArrayList) watchFeedData2.imgs, this.w, ((int) yr2.d(this.w)) - yr2.a(this.w, 42.0f), watchFeedData2.videoInfo);
            }
            View view2 = this.D;
            if (view2 != null) {
                if (watchFeedData2.feature) {
                    view2.setVisibility(0);
                } else {
                    view2.setVisibility(8);
                }
            }
            if (getItemViewType() == FeedsAdapter.G) {
                if (wh2.j(watchFeedData2.title)) {
                    this.y.setText("发表评论");
                } else {
                    this.y.setText(watchFeedData2.title);
                }
            }
        }
    }
}
