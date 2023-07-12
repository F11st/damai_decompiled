package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$id;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.g41;
import tb.qd2;
import tb.u12;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ForwardCommentViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;
    public TextView x;
    public TextView y;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        a(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "874930325")) {
                ipChange.ipc$dispatch("874930325", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, this.a.forwardId);
            DMNav.from(ForwardCommentViewHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        b(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1308746602")) {
                ipChange.ipc$dispatch("-1308746602", new Object[]{this, view});
                return;
            }
            DynamicFeedData dynamicFeedData = this.a;
            String str = dynamicFeedData.forwardTargetId;
            if (dynamicFeedData.forwardTargetType.intValue() != 20 && this.a.forwardTargetDataType != 1) {
                Bundle bundle = new Bundle();
                bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                DMNav.from(ForwardCommentViewHolder.this.w).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
            } else if (this.a.forwardViewStatus == 0) {
                ToastUtil.i("该商品已下架");
            } else {
                Bundle bundle2 = new Bundle();
                try {
                    bundle2.putLong(IssueConstants.ProjectID, Long.parseLong(str));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                qd2.a(ForwardCommentViewHolder.this.w, this.a.schema, bundle2);
            }
        }
    }

    public ForwardCommentViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_content_wrapper);
        this.x = (TextView) view.findViewById(R$id.tv_comment);
        this.v = (NineGridlayout) view.findViewById(R$id.ninelayout);
        TextView textView = (TextView) view.findViewById(R$id.user_feed_fabuquanzi);
        ImageView imageView = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        this.y = (TextView) view.findViewById(R$id.feeds_item_playtitle);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ed  */
    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x(cn.damai.user.userprofile.bean.FeedMergeDataDO r6) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.user.userprofile.cuser.view.ForwardCommentViewHolder.x(cn.damai.user.userprofile.bean.FeedMergeDataDO):void");
    }
}
