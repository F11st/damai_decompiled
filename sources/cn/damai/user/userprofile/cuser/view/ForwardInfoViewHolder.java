package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ForwardInfoViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;
    public TextView x;

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
            if (AndroidInstantRuntime.support(ipChange, "-220717720")) {
                ipChange.ipc$dispatch("-220717720", new Object[]{this, view});
            } else if (this.a.requestSuccess.booleanValue() && !wh2.j(this.a.originalUrl)) {
                Bundle bundle = new Bundle();
                bundle.putString("url", this.a.originalUrl);
                DMNav.from(ForwardInfoViewHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b(a.c.d));
            }
        }
    }

    public ForwardInfoViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_content_wrapper);
        this.x = (TextView) view.findViewById(R$id.tv_comment);
        this.v = (NineGridlayout) view.findViewById(R$id.ninelayout);
        TextView textView = (TextView) view.findViewById(R$id.user_feed_fabuquanzi);
        ImageView imageView = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        int i = R$id.feeds_item_playtitle;
        TextView textView2 = (TextView) view.findViewById(i);
        TextView textView3 = (TextView) view.findViewById(i);
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        DynamicFeedData dynamicFeedData;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784279708")) {
            ipChange.ipc$dispatch("784279708", new Object[]{this, feedMergeDataDO});
            return;
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list == null || list.size() <= 0 || (dynamicFeedData = feedMergeDataDO.dynamicData.get(0)) == null) {
            return;
        }
        if (dynamicFeedData.forwardImgs != null) {
            r((ArrayList) dynamicFeedData.forwardImgs, this.w, ((int) yr2.d(this.w)) - yr2.a(this.w, 60.0f), dynamicFeedData.videoInfo);
        } else {
            NineGridlayout nineGridlayout = this.v;
            if (nineGridlayout != null) {
                nineGridlayout.setVisibility(8);
            }
        }
        if (!wh2.j(dynamicFeedData.comment)) {
            this.x.setText(dynamicFeedData.comment);
        }
        v(dynamicFeedData.circleName, R$id.user_feed_fabuquanzi);
        if (dynamicFeedData.requestSuccess.booleanValue()) {
            ((TextView) this.itemView.findViewById(R$id.tv_comment_text)).setText(Html.fromHtml(dynamicFeedData.forwardUserNick + ":  <font color='#111111'>" + dynamicFeedData.forwardComment + "</font>"));
        } else {
            v("内容已删除", R$id.tv_comment_text);
        }
        this.itemView.findViewById(R$id.ll_forward).setOnClickListener(new a(dynamicFeedData));
    }
}
