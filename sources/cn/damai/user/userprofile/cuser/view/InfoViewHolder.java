package cn.damai.user.userprofile.cuser.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import cn.damai.user.userprofile.bean.CommentFeedData;
import cn.damai.user.userprofile.bean.DynamicFeedData;
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
import tb.qd2;
import tb.u12;
import tb.wh2;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class InfoViewHolder extends FeedsWraperHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity w;
    public TextView x;
    public TextView y;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.InfoViewHolder$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2777a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DynamicFeedData a;

        View$OnClickListenerC2777a(DynamicFeedData dynamicFeedData) {
            this.a = dynamicFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "678677289")) {
                ipChange.ipc$dispatch("678677289", new Object[]{this, view});
            } else if (!"5".equals(this.a.circleTargetType)) {
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, this.a.circleTargetId);
                bundle.putString("usertype", this.a.circleTargetType);
                bundle.putBoolean("circle", true);
                DMNav.from(InfoViewHolder.this.w).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString(RepertoireDetailFragment.REPERTOIREID, this.a.circleTargetId);
                bundle2.putBoolean("circle", true);
                DMNav.from(InfoViewHolder.this.w).withExtras(bundle2).toUri(NavUri.b(u12.REPERTOITE));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.InfoViewHolder$b */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2778b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentFeedData a;
        final /* synthetic */ FeedMergeDataDO b;

        View$OnClickListenerC2778b(CommentFeedData commentFeedData, FeedMergeDataDO feedMergeDataDO) {
            this.a = commentFeedData;
            this.b = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1504999638")) {
                ipChange.ipc$dispatch("-1504999638", new Object[]{this, view});
            } else if (this.a != null) {
                Bundle bundle = new Bundle();
                bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, this.a.bizId);
                DMNav.from(InfoViewHolder.this.w).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
                HashMap hashMap = new HashMap();
                CommentFeedData commentFeedData = this.a;
                if (commentFeedData != null) {
                    hashMap.put("content_id", commentFeedData.bizId);
                    hashMap.put("content_type", this.b.bizType);
                    hashMap.put("circle_id", InfoViewHolder.this.u);
                }
                InfoViewHolder infoViewHolder = InfoViewHolder.this;
                Activity activity = infoViewHolder.w;
                String str = infoViewHolder.q;
                kv2.e(activity, str, "circle", "circle_" + InfoViewHolder.this.itemView.getTag(), true, null, hashMap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.InfoViewHolder$c */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2779c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentFeedData a;

        View$OnClickListenerC2779c(CommentFeedData commentFeedData) {
            this.a = commentFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "606290731")) {
                ipChange.ipc$dispatch("606290731", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            try {
                bundle.putLong(IssueConstants.ProjectID, Long.parseLong(this.a.targetId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            qd2.a(InfoViewHolder.this.w, this.a.schema, bundle);
            HashMap hashMap = new HashMap();
            CommentFeedData commentFeedData = this.a;
            if (commentFeedData != null) {
                hashMap.put("item_id", commentFeedData.targetId);
                hashMap.put("circle_id", InfoViewHolder.this.u);
            }
            InfoViewHolder infoViewHolder = InfoViewHolder.this;
            Activity activity = infoViewHolder.w;
            String str = infoViewHolder.q;
            kv2.e(activity, str, "circle", "circle_item_" + InfoViewHolder.this.itemView.getTag(), true, null, hashMap);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.userprofile.cuser.view.InfoViewHolder$d */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2780d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WatchFeedData a;

        View$OnClickListenerC2780d(WatchFeedData watchFeedData) {
            this.a = watchFeedData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1577386196")) {
                ipChange.ipc$dispatch("-1577386196", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            WatchFeedData watchFeedData = this.a;
            if (watchFeedData.targetDataType == 1) {
                try {
                    bundle.putLong(IssueConstants.ProjectID, Long.parseLong(watchFeedData.targetId));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                qd2.a(InfoViewHolder.this.w, this.a.schema, bundle);
            } else {
                bundle.putString(RepertoireDetailFragment.REPERTOIREID, watchFeedData.targetId);
                DMNav.from(InfoViewHolder.this.w).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
            }
            HashMap hashMap = new HashMap();
            WatchFeedData watchFeedData2 = this.a;
            if (watchFeedData2 != null) {
                hashMap.put("item_id", watchFeedData2.targetId);
                hashMap.put("circle_id", InfoViewHolder.this.u);
            }
            InfoViewHolder infoViewHolder = InfoViewHolder.this;
            Activity activity = infoViewHolder.w;
            String str = infoViewHolder.q;
            kv2.e(activity, str, "circle", "circle_item_" + InfoViewHolder.this.itemView.getTag(), true, null, hashMap);
        }
    }

    public InfoViewHolder(View view, Activity activity, String str) {
        super(view, activity, str);
        this.w = activity;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_content_wrapper);
        this.x = (TextView) view.findViewById(R$id.tv_comment);
        this.v = (NineGridlayout) view.findViewById(R$id.ninelayout);
        this.y = (TextView) view.findViewById(R$id.user_feed_fabuquanzi);
        ImageView imageView = (ImageView) view.findViewById(R$id.feeds_item_playimg);
        int i = R$id.feeds_item_playtitle;
        TextView textView = (TextView) view.findViewById(i);
        TextView textView2 = (TextView) view.findViewById(i);
    }

    @NonNull
    private String A(CommentFeedData commentFeedData) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "33665708")) {
            return (String) ipChange.ipc$dispatch("33665708", new Object[]{this, commentFeedData});
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList();
        if (!wh2.j(commentFeedData.targetCityName)) {
            arrayList.add(commentFeedData.targetCityName);
        }
        if (!wh2.j(commentFeedData.targetShowTime)) {
            arrayList.add(commentFeedData.targetShowTime);
        }
        if (!wh2.j(commentFeedData.targetPlace)) {
            arrayList.add(commentFeedData.targetPlace);
        }
        if (arrayList.size() > 0) {
            for (String str : arrayList) {
                stringBuffer.append(str);
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(" | ");
                    i++;
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // cn.damai.user.userprofile.cuser.view.FeedsWraperHolder
    public void x(FeedMergeDataDO feedMergeDataDO) {
        List<WatchFeedData> list;
        WatchFeedData watchFeedData;
        List<CommentFeedData> list2;
        List<DynamicFeedData> list3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-169013603")) {
            ipChange.ipc$dispatch("-169013603", new Object[]{this, feedMergeDataDO});
            return;
        }
        Log.e("titleRatingBar", "updateData ivh ");
        if (feedMergeDataDO != null && (list3 = feedMergeDataDO.dynamicData) != null && list3.size() > 0) {
            DynamicFeedData dynamicFeedData = feedMergeDataDO.dynamicData.get(0);
            if (dynamicFeedData == null) {
                return;
            }
            if (dynamicFeedData.imgs != null) {
                r((ArrayList) dynamicFeedData.imgs, this.w, ((int) yr2.d(this.w)) - yr2.a(this.w, 42.0f), dynamicFeedData.videoInfo);
            } else {
                NineGridlayout nineGridlayout = this.v;
                if (nineGridlayout != null) {
                    nineGridlayout.setVisibility(8);
                }
            }
            if (wh2.j(dynamicFeedData.comment)) {
                this.x.setText("分享图片");
            } else {
                this.x.setText(dynamicFeedData.comment);
            }
            v(dynamicFeedData.circleName, R$id.user_feed_fabuquanzi);
            TextView textView = this.y;
            if (textView != null) {
                textView.setOnClickListener(new View$OnClickListenerC2777a(dynamicFeedData));
            }
            if (TextUtils.isEmpty(dynamicFeedData.havanaIdStr)) {
                return;
            }
            String str = dynamicFeedData.userNick;
            String str2 = dynamicFeedData.userImg;
            Activity activity = this.w;
            h(str, str2, activity, feedMergeDataDO.bizTime + feedMergeDataDO.title, String.valueOf(dynamicFeedData.havanaIdStr), dynamicFeedData.vtag, dynamicFeedData.userBtag);
        } else if (feedMergeDataDO != null && (list2 = feedMergeDataDO.commentData) != null && list2.size() > 0) {
            CommentFeedData commentFeedData = feedMergeDataDO.commentData.get(0);
            if (commentFeedData == null) {
                return;
            }
            if (!wh2.j(commentFeedData.comment)) {
                this.x.setText(commentFeedData.comment);
                this.itemView.setOnClickListener(new View$OnClickListenerC2778b(commentFeedData, feedMergeDataDO));
            }
            if (!TextUtils.isEmpty(commentFeedData.havanaIdStr)) {
                String str3 = commentFeedData.userNick;
                String str4 = commentFeedData.userImg;
                Activity activity2 = this.w;
                h(str3, str4, activity2, feedMergeDataDO.bizTime + feedMergeDataDO.title, String.valueOf(commentFeedData.havanaIdStr), commentFeedData.vtag, commentFeedData.userBtag);
            }
            View view = this.itemView;
            int i = R$id.feeds_item_project;
            if (view.findViewById(i) != null) {
                if (wh2.j(commentFeedData.targetName)) {
                    this.itemView.findViewById(i).setVisibility(8);
                } else {
                    this.itemView.findViewById(i).setVisibility(0);
                    v(commentFeedData.targetName, R$id.mine_user_feed_mid_text);
                    v(A(commentFeedData), R$id.mine_user_feed_mid_text2);
                    View view2 = this.itemView;
                    int i2 = R$id.mine_user_feed_propic;
                    if (view2.findViewById(i2) != null) {
                        DMImageCreator c = C0504a.b().c(commentFeedData.targetImg);
                        int i3 = R$drawable.uikit_default_image_bg_gradient;
                        c.i(i3).c(i3).g((ImageView) this.itemView.findViewById(i2));
                    }
                }
            }
            View$OnClickListenerC2779c view$OnClickListenerC2779c = new View$OnClickListenerC2779c(commentFeedData);
            View view3 = this.itemView;
            int i4 = R$id.mine_user_feed_wrapper;
            if (view3.findViewById(i4) != null) {
                this.itemView.findViewById(i4).setOnClickListener(view$OnClickListenerC2779c);
            }
        } else if (feedMergeDataDO == null || (list = feedMergeDataDO.watchData) == null || list.size() <= 0 || (watchFeedData = feedMergeDataDO.watchData.get(0)) == null) {
        } else {
            if (watchFeedData.imgs != null) {
                r((ArrayList) watchFeedData.imgs, this.w, ((int) yr2.d(this.w)) - yr2.a(this.w, 42.0f), watchFeedData.videoInfo);
            } else {
                NineGridlayout nineGridlayout2 = this.v;
                if (nineGridlayout2 != null) {
                    nineGridlayout2.setVisibility(8);
                }
            }
            if (wh2.j(watchFeedData.comment)) {
                this.x.setText("分享图片");
            } else {
                this.x.setText(watchFeedData.comment);
            }
            if (!TextUtils.isEmpty(watchFeedData.havanaIdStr)) {
                String str5 = watchFeedData.userNick;
                String str6 = watchFeedData.userImg;
                Activity activity3 = this.w;
                h(str5, str6, activity3, feedMergeDataDO.bizTime + feedMergeDataDO.title, String.valueOf(watchFeedData.havanaIdStr), watchFeedData.vtag, watchFeedData.userBtag);
            }
            View view4 = this.itemView;
            int i5 = R$id.feeds_item_project;
            if (view4.findViewById(i5) != null) {
                if (wh2.j(watchFeedData.targetName)) {
                    this.itemView.findViewById(i5).setVisibility(8);
                } else {
                    this.itemView.findViewById(i5).setVisibility(0);
                    v(watchFeedData.targetName, R$id.mine_user_feed_mid_text);
                    v(A(watchFeedData), R$id.mine_user_feed_mid_text2);
                    View view5 = this.itemView;
                    int i6 = R$id.mine_user_feed_propic;
                    if (view5.findViewById(i6) != null) {
                        DMImageCreator c2 = C0504a.b().c(watchFeedData.targetImg);
                        int i7 = R$drawable.uikit_default_image_bg_gradient;
                        c2.i(i7).c(i7).g((ImageView) this.itemView.findViewById(i6));
                    }
                }
            }
            View$OnClickListenerC2780d view$OnClickListenerC2780d = new View$OnClickListenerC2780d(watchFeedData);
            View view6 = this.itemView;
            int i8 = R$id.mine_user_feed_wrapper;
            if (view6.findViewById(i8) != null) {
                this.itemView.findViewById(i8).setOnClickListener(view$OnClickListenerC2780d);
            }
        }
    }
}
