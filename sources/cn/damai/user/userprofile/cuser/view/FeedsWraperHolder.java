package cn.damai.user.userprofile.cuser.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$string;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.ClickGrayImageView;
import cn.damai.uikit.view.DMRatingBar;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsAdapter;
import cn.damai.user.userprofile.FeedsViewModel;
import cn.damai.user.userprofile.UserIndexActivity;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.CommentFeedData;
import cn.damai.user.userprofile.bean.DeleteRequest;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.InteractionFeedData;
import cn.damai.user.userprofile.bean.PraiseRequest;
import cn.damai.user.userprofile.bean.VideoInfo;
import cn.damai.user.userprofile.bean.WatchFeedData;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tb.cs;
import tb.g41;
import tb.kf2;
import tb.kv2;
import tb.lu2;
import tb.qd2;
import tb.t60;
import tb.u12;
import tb.wh2;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FeedsWraperHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQ_CDOE_EDIT = 10002;
    public static final int REQ_CDOE_PUGLISH = 10001;
    public View a;
    public TextView b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public DMRatingBar h;
    public DMRatingBar i;
    public TextView j;
    public boolean k;
    private Activity l;
    private View m;
    private int n;
    private boolean o;
    boolean p;
    String q;
    String r;
    String s;
    boolean t;
    String u;
    public NineGridlayout v;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2001715432")) {
                ipChange.ipc$dispatch("2001715432", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(FeedsViewModel.ARG_USERID, this.a);
            DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        b(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1824275196")) {
                ipChange.ipc$dispatch("1824275196", new Object[]{this, view});
            } else {
                FeedsWraperHolder.this.w(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a(c cVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "952676453")) {
                    ipChange.ipc$dispatch("952676453", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                ShareManager.E().C();
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1922257476")) {
                    ipChange.ipc$dispatch("1922257476", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                c cVar = c.this;
                FeedsWraperHolder.this.p(cVar.a);
                dialogInterface.dismiss();
                ShareManager.E().C();
            }
        }

        c(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-359401731")) {
                ipChange.ipc$dispatch("-359401731", new Object[]{this, view});
            } else {
                new DMDialog(FeedsWraperHolder.this.l).v("注意").q("确定要删除该数据吗?").n("确定", new b()).i("取消", new a(this)).show();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        d(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1751888638")) {
                ipChange.ipc$dispatch("1751888638", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            try {
                if (FeedsWraperHolder.this.i(this.a) != null) {
                    bundle.putString("targetId", FeedsWraperHolder.this.i(this.a));
                }
                if ("2.20".equals(this.a.bizType)) {
                    i = 20;
                } else if ("2.22".equals(this.a.bizType)) {
                    i = 22;
                } else if ("1.1".equals(this.a.bizType)) {
                    i = 23;
                } else {
                    if (!"1.2".equals(this.a.bizType) && !"1.3".equals(this.a.bizType) && !"1.5".equals(this.a.bizType)) {
                        i = "5.32".equals(this.a.bizType) ? 32 : 0;
                    }
                    i = 24;
                }
                bundle.putInt("targetType", i);
                bundle.putInt("type", 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).toUri(NavUri.b("report"));
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        e(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            try {
                if (AndroidInstantRuntime.support(ipChange, "-431788289")) {
                    ipChange.ipc$dispatch("-431788289", new Object[]{this, view});
                    return;
                }
                try {
                    List<WatchFeedData> list = this.a.watchData;
                    if (list != null && list.size() > 0) {
                        WatchFeedData watchFeedData = this.a.watchData.get(0);
                        Bundle bundle = new Bundle();
                        bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
                        bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
                        bundle.putInt(g41.ISSUE_PARAM_GRADES, watchFeedData.getValue());
                        bundle.putString("text", watchFeedData.comment);
                        bundle.putStringArrayList("images", (ArrayList) watchFeedData.imgs);
                        bundle.putString("circleId", watchFeedData.circleId);
                        bundle.putString("circleName", watchFeedData.circleName);
                        DMNav.from(FeedsWraperHolder.this.l).withExtras(bundle).forResult(10002).toUri(NavUri.b("issue"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                ShareManager.E().C();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        f(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-504174847")) {
                ipChange.ipc$dispatch("-504174847", new Object[]{this, view});
                return;
            }
            Activity activity = FeedsWraperHolder.this.getActivity();
            DMNav.from(activity).withExtras(FeedsWraperHolder.this.k(this.a)).needLogin().forResult(10001).toUri(NavUri.b("issue"));
            if (this.a != null) {
                FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                if (feedsWraperHolder.p) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", "大家说");
                    hashMap.put("evaluate_id", FeedsWraperHolder.this.i(this.a));
                    hashMap.put("content_type", this.a.bizType);
                    hashMap.put("content_id", FeedsWraperHolder.this.i(this.a));
                    cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                    cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "forward_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.TRUE));
                    return;
                }
                if (!feedsWraperHolder.k) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("content_id", FeedsWraperHolder.this.i(this.a));
                    hashMap2.put("content_type", this.a.bizType);
                    hashMap2.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
                    String str = FeedsWraperHolder.this.q;
                    kv2.e(activity, str, lu2.DYNAMIC, "forward_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap2);
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("content_id", FeedsWraperHolder.this.i(this.a));
                hashMap3.put("content_type", this.a.bizType);
                hashMap3.put("circle_id", FeedsWraperHolder.this.u);
                hashMap3.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
                String str2 = FeedsWraperHolder.this.q;
                kv2.e(activity, str2, "circle", "forward_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap3);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class g implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;

        g(FeedMergeDataDO feedMergeDataDO) {
            this.a = feedMergeDataDO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommentFeedData commentFeedData;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1607115522")) {
                ipChange.ipc$dispatch("1607115522", new Object[]{this, view});
                return;
            }
            FeedMergeDataDO feedMergeDataDO = this.a;
            if (feedMergeDataDO == null) {
                return;
            }
            List<CommentFeedData> list = feedMergeDataDO.commentData;
            if (list != null && list.size() > 0 && (commentFeedData = this.a.commentData.get(0)) != null) {
                Bundle bundle = new Bundle();
                bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, commentFeedData.bizId);
                DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
            }
            List<WatchFeedData> list2 = this.a.watchData;
            if (list2 == null || list2.size() <= 0) {
                if (!wh2.j(FeedsWraperHolder.this.m(this.a))) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("url", FeedsWraperHolder.this.m(this.a) + "#commentlist");
                    DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle2).toUri(NavUri.b(a.c.d));
                }
            } else {
                WatchFeedData watchFeedData = this.a.watchData.get(0);
                if (watchFeedData != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(g41.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
                    DMNav.from(FeedsWraperHolder.this.l).needLogin().withExtras(bundle3).toUri(NavUri.b("commentdetail"));
                }
            }
            FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
            if (feedsWraperHolder.p) {
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", "大家说");
                hashMap.put("evaluate_id", FeedsWraperHolder.this.i(this.a));
                hashMap.put("content_type", this.a.bizType);
                hashMap.put("content_id", FeedsWraperHolder.this.i(this.a));
                cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "comment_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.TRUE));
                return;
            }
            if (!feedsWraperHolder.k) {
                HashMap hashMap2 = new HashMap();
                FeedMergeDataDO feedMergeDataDO2 = this.a;
                if (feedMergeDataDO2 != null) {
                    hashMap2.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO2));
                    hashMap2.put("content_type", this.a.bizType);
                    hashMap2.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
                }
                Activity activity = FeedsWraperHolder.this.l;
                String str = FeedsWraperHolder.this.q;
                kv2.e(activity, str, lu2.DYNAMIC, "comment_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap2);
                return;
            }
            HashMap hashMap3 = new HashMap();
            FeedMergeDataDO feedMergeDataDO3 = this.a;
            if (feedMergeDataDO3 != null) {
                hashMap3.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO3));
                hashMap3.put("content_type", this.a.bizType);
                hashMap3.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
            }
            hashMap3.put("circle_id", FeedsWraperHolder.this.u);
            Activity activity2 = FeedsWraperHolder.this.l;
            String str2 = FeedsWraperHolder.this.q;
            kv2.e(activity2, str2, "circle", "comment_" + FeedsWraperHolder.this.itemView.getTag(), true, null, hashMap3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ VideoInfo b;
        final /* synthetic */ ArrayList c;

        h(FeedsWraperHolder feedsWraperHolder, Activity activity, VideoInfo videoInfo, ArrayList arrayList) {
            this.a = activity;
            this.b = videoInfo;
            this.c = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1534728964")) {
                ipChange.ipc$dispatch("1534728964", new Object[]{this, view});
                return;
            }
            if (view instanceof ClickGrayImageView) {
                ClickGrayImageView clickGrayImageView = (ClickGrayImageView) view;
                if (clickGrayImageView.getTag() != null) {
                    try {
                        i = Integer.parseInt(clickGrayImageView.getTag() + "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Activity activity = this.a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            Bundle bundle = new Bundle();
            if (this.b != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                cn.damai.commonbusiness.imagebrowse.bean.VideoInfo videoInfo = new cn.damai.commonbusiness.imagebrowse.bean.VideoInfo();
                videoInfo.setPicUrl(this.b.coverUrl);
                videoInfo.setVideoUrl(this.b.url);
                videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                arrayList.add(videoInfo);
                bundle.putParcelableArrayList("video_info", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = this.c;
            if (arrayList3 != null) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl((String) it.next());
                    arrayList2.add(picInfo);
                }
            }
            bundle.putParcelableArrayList("pic_info", arrayList2);
            bundle.putInt("position", i);
            DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b("videobrowse"));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class i {
        private static transient /* synthetic */ IpChange $ipChange;
        private CommentFeedData a;
        private String b;
        private String c;
        private String d;
        private String e;

        public i(CommentFeedData commentFeedData) {
            this.a = commentFeedData;
        }

        public String a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-682027553") ? (String) ipChange.ipc$dispatch("-682027553", new Object[]{this}) : this.e;
        }

        public String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "658627229") ? (String) ipChange.ipc$dispatch("658627229", new Object[]{this}) : this.c;
        }

        public String c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1480446900") ? (String) ipChange.ipc$dispatch("1480446900", new Object[]{this}) : this.b;
        }

        public String d() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "826652043") ? (String) ipChange.ipc$dispatch("826652043", new Object[]{this}) : this.d;
        }

        public i e() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-512677418")) {
                return (i) ipChange.ipc$dispatch("-512677418", new Object[]{this});
            }
            CommentFeedData commentFeedData = this.a;
            this.c = commentFeedData.comment;
            this.d = commentFeedData.url;
            if (!wh2.j(commentFeedData.userNick)) {
                this.b = this.a.userNick + "@大麦";
            } else {
                this.b = FeedsWraperHolder.this.r + "@大麦";
            }
            if (!wh2.j(this.a.targetImg)) {
                this.e = this.a.targetImg;
            } else if (!wh2.j(this.a.userImg)) {
                this.e = this.a.userImg;
            } else {
                this.e = FeedsWraperHolder.this.s;
            }
            return this;
        }
    }

    public FeedsWraperHolder(View view, Activity activity, String str) {
        super(view);
        this.k = false;
        this.o = false;
        this.p = false;
        this.l = activity;
        this.q = str;
        this.a = view.findViewById(R$id.feeds_item_wrapper_ll);
        this.b = (TextView) view.findViewById(R$id.feeds_item_wrapper_year);
        this.c = view.findViewById(R$id.feeds_interact_parent);
        this.d = (TextView) view.findViewById(R$id.user_feeds_commenttv);
        this.e = (TextView) view.findViewById(R$id.user_feeds_zantv);
        this.g = (TextView) view.findViewById(R$id.feeds_item_more);
        this.f = (TextView) view.findViewById(R$id.user_feeds_zanicon);
        this.h = (DMRatingBar) view.findViewById(R$id.bar_rating);
        this.i = (DMRatingBar) view.findViewById(R$id.bar_rating_title);
        this.j = (TextView) view.findViewById(R$id.bar_rating_title_desc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488426101")) {
            return (String) ipChange.ipc$dispatch("488426101", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).bizId;
        }
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).bizId;
        }
        List<ArticleFeedData> list3 = feedMergeDataDO.articleData;
        if (list3 != null && list3.get(0) != null) {
            return feedMergeDataDO.articleData.get(0).bizId;
        }
        List<WatchFeedData> list4 = feedMergeDataDO.watchData;
        if (list4 == null || list4.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).bizId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970461162")) {
            return (String) ipChange.ipc$dispatch("-1970461162", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).url;
        }
        List<ArticleFeedData> list2 = feedMergeDataDO.articleData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.articleData.get(0).url;
        }
        List<CommentFeedData> list3 = feedMergeDataDO.commentData;
        if (list3 != null && list3.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).url;
        }
        List<WatchFeedData> list4 = feedMergeDataDO.watchData;
        if (list4 == null || list4.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).url;
    }

    private String n(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352519051")) {
            return (String) ipChange.ipc$dispatch("352519051", new Object[]{this, feedMergeDataDO});
        }
        List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
        if (list != null && list.get(0) != null) {
            return feedMergeDataDO.dynamicData.get(0).havanaIdStr;
        }
        List<CommentFeedData> list2 = feedMergeDataDO.commentData;
        if (list2 != null && list2.get(0) != null) {
            return feedMergeDataDO.commentData.get(0).havanaIdStr;
        }
        List<WatchFeedData> list3 = feedMergeDataDO.watchData;
        if (list3 == null || list3.get(0) == null) {
            return null;
        }
        return feedMergeDataDO.watchData.get(0).havanaIdStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295635414")) {
            ipChange.ipc$dispatch("1295635414", new Object[]{this, feedMergeDataDO});
            return;
        }
        DeleteRequest deleteRequest = new DeleteRequest();
        List<ArticleFeedData> list = feedMergeDataDO.articleData;
        if (list != null && list.get(0) != null) {
            deleteRequest.articleId = feedMergeDataDO.articleData.get(0).bizId;
            deleteRequest.commentId = "";
        } else {
            deleteRequest.commentId = i(feedMergeDataDO);
            deleteRequest.articleId = "";
        }
        deleteRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) { // from class: cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1374628710")) {
                    ipChange2.ipc$dispatch("1374628710", new Object[]{this, str, str2});
                    return;
                }
                Log.d("netlog", "delect comment : " + str);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(JSONObject jSONObject) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "282056487")) {
                    ipChange2.ipc$dispatch("282056487", new Object[]{this, jSONObject});
                } else if (jSONObject == null || FeedsWraperHolder.this.l == null) {
                } else {
                    ((UserIndexActivity) FeedsWraperHolder.this.l).refresh();
                }
            }
        });
    }

    private void q(final FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918563577")) {
            ipChange.ipc$dispatch("918563577", new Object[]{this, feedMergeDataDO});
            return;
        }
        if (!feedMergeDataDO.enableForward) {
            this.itemView.findViewById(R$id.user_feeds_zhuanfaicon).setVisibility(8);
            this.itemView.findViewById(R$id.user_feeds_zhuanfatv).setVisibility(8);
        } else {
            new f(feedMergeDataDO);
        }
        if (!feedMergeDataDO.enableComment) {
            this.itemView.findViewById(R$id.user_feeds_commenticon).setVisibility(8);
            this.d.setVisibility(8);
        } else {
            View view = this.itemView;
            int i2 = R$id.user_feeds_commenticon;
            view.findViewById(i2).setVisibility(0);
            this.d.setVisibility(0);
            if (getItemViewType() == FeedsAdapter.G) {
                this.d.setVisibility(8);
                this.itemView.findViewById(i2).setVisibility(8);
            }
            if (feedMergeDataDO.commentNum == 0) {
                this.d.setText("回复");
            } else {
                TextView textView = this.d;
                textView.setText(feedMergeDataDO.commentNum + "");
            }
            g gVar = new g(feedMergeDataDO);
            this.itemView.findViewById(i2).setOnClickListener(gVar);
            this.d.setOnClickListener(gVar);
        }
        if (!feedMergeDataDO.enablePraise) {
            this.itemView.findViewById(R$id.user_feeds_zanicon).setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        View view2 = this.itemView;
        int i3 = R$id.user_feeds_zanicon;
        view2.findViewById(i3).setVisibility(0);
        this.e.setVisibility(0);
        if (feedMergeDataDO.praiseNum == 0) {
            this.e.setText("赞");
        } else {
            TextView textView2 = this.e;
            textView2.setText(feedMergeDataDO.praiseNum + "");
        }
        if (feedMergeDataDO.hasPraised) {
            this.f.setTextColor(this.l.getResources().getColor(R$color.color_FF1268));
            this.f.setText(this.l.getResources().getString(R$string.iconfont_dianzanmian_));
        } else {
            this.f.setTextColor(this.l.getResources().getColor(R$color.color_nozan));
            this.f.setText(this.l.getResources().getString(R$string.iconfont_dianzan_));
        }
        this.o = feedMergeDataDO.hasPraised;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-576561405")) {
                    ipChange2.ipc$dispatch("-576561405", new Object[]{this, view3});
                } else if (FeedsWraperHolder.this.i(feedMergeDataDO) == null) {
                } else {
                    if (!LoginManager.k().q()) {
                        DMNav.from(FeedsWraperHolder.this.l).toUri(NavUri.b("login"));
                        return;
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, "scaleX", 0.3f, 1.0f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view3, "scaleY", 0.3f, 1.0f);
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, "alpha", 0.5f, 1.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(1000L);
                    animatorSet.setInterpolator(new kf2(0.3f));
                    animatorSet.playTogether(ofFloat3, ofFloat, ofFloat2);
                    animatorSet.start();
                    PraiseRequest praiseRequest = new PraiseRequest();
                    praiseRequest.targetId = FeedsWraperHolder.this.i(feedMergeDataDO);
                    praiseRequest.targetType = "1";
                    if (feedMergeDataDO.articleData != null) {
                        praiseRequest.targetType = "2";
                    }
                    praiseRequest.operate = FeedsWraperHolder.this.o ? "1" : "0";
                    if (feedMergeDataDO.praiseNum == 0 && FeedsWraperHolder.this.o) {
                        return;
                    }
                    praiseRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) { // from class: cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.8.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(String str, String str2) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "141697462")) {
                                ipChange3.ipc$dispatch("141697462", new Object[]{this, str, str2});
                            } else {
                                FeedsWraperHolder.this.o = false;
                            }
                        }

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onSuccess(JSONObject jSONObject) {
                            FeedsWraperHolder feedsWraperHolder;
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-841628297")) {
                                ipChange3.ipc$dispatch("-841628297", new Object[]{this, jSONObject});
                            } else if (jSONObject != null) {
                                if (FeedsWraperHolder.this.o) {
                                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                    FeedMergeDataDO feedMergeDataDO2 = feedMergeDataDO;
                                    int i4 = feedMergeDataDO2.praiseNum - 1;
                                    feedMergeDataDO2.praiseNum = i4;
                                    if (i4 < 0) {
                                        feedMergeDataDO2.praiseNum = 0;
                                    }
                                    if (feedMergeDataDO2.praiseNum == 0) {
                                        FeedsWraperHolder.this.e.setText("赞");
                                    } else {
                                        FeedsWraperHolder.this.e.setText(feedMergeDataDO.praiseNum + "");
                                    }
                                    FeedsWraperHolder feedsWraperHolder2 = FeedsWraperHolder.this;
                                    TextView textView3 = feedsWraperHolder2.e;
                                    Resources resources = feedsWraperHolder2.l.getResources();
                                    int i5 = R$color.color_nozan;
                                    textView3.setTextColor(resources.getColor(i5));
                                    FeedsWraperHolder feedsWraperHolder3 = FeedsWraperHolder.this;
                                    feedsWraperHolder3.f.setTextColor(feedsWraperHolder3.l.getResources().getColor(i5));
                                    FeedsWraperHolder feedsWraperHolder4 = FeedsWraperHolder.this;
                                    feedsWraperHolder4.f.setText(feedsWraperHolder4.l.getResources().getString(R$string.iconfont_dianzan_));
                                } else {
                                    AnonymousClass8 anonymousClass82 = AnonymousClass8.this;
                                    feedMergeDataDO.praiseNum++;
                                    FeedsWraperHolder.this.e.setText(feedMergeDataDO.praiseNum + "");
                                    FeedsWraperHolder feedsWraperHolder5 = FeedsWraperHolder.this;
                                    TextView textView4 = feedsWraperHolder5.e;
                                    Resources resources2 = feedsWraperHolder5.l.getResources();
                                    int i6 = R$color.color_FF1268;
                                    textView4.setTextColor(resources2.getColor(i6));
                                    FeedsWraperHolder feedsWraperHolder6 = FeedsWraperHolder.this;
                                    feedsWraperHolder6.f.setTextColor(feedsWraperHolder6.l.getResources().getColor(i6));
                                    FeedsWraperHolder feedsWraperHolder7 = FeedsWraperHolder.this;
                                    feedsWraperHolder7.f.setText(feedsWraperHolder7.l.getResources().getString(R$string.iconfont_dianzanmian_));
                                }
                                FeedsWraperHolder.this.o = !feedsWraperHolder.o;
                            }
                        }
                    });
                    FeedsWraperHolder feedsWraperHolder = FeedsWraperHolder.this;
                    if (feedsWraperHolder.p) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("titlelabel", "大家说");
                        hashMap.put("evaluate_id", FeedsWraperHolder.this.i(feedMergeDataDO));
                        hashMap.put("content_type", feedMergeDataDO.bizType);
                        hashMap.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO));
                        cn.damai.common.user.b bVar = new cn.damai.common.user.b();
                        cn.damai.common.user.c.e().x(bVar.e("brand", "evaluate_list", "likes_" + FeedsWraperHolder.this.itemView.getTag(), hashMap, Boolean.FALSE));
                    } else if (!feedsWraperHolder.k) {
                        HashMap hashMap2 = new HashMap();
                        FeedMergeDataDO feedMergeDataDO2 = feedMergeDataDO;
                        if (feedMergeDataDO2 != null) {
                            hashMap2.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO2));
                            hashMap2.put("content_type", feedMergeDataDO.bizType);
                            hashMap2.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
                        }
                        Activity activity = FeedsWraperHolder.this.l;
                        String str = FeedsWraperHolder.this.q;
                        kv2.e(activity, str, lu2.DYNAMIC, "dynamic_likes_" + FeedsWraperHolder.this.itemView.getTag(), false, null, hashMap2);
                    } else {
                        HashMap hashMap3 = new HashMap();
                        FeedMergeDataDO feedMergeDataDO3 = feedMergeDataDO;
                        if (feedMergeDataDO3 != null) {
                            hashMap3.put("content_id", FeedsWraperHolder.this.i(feedMergeDataDO3));
                            hashMap3.put("content_type", feedMergeDataDO.bizType);
                            hashMap3.put(u12.VIEW_TYPE, FeedsWraperHolder.this.t ? "1" : "0");
                        }
                        hashMap3.put("circle_id", FeedsWraperHolder.this.u);
                        Activity activity2 = FeedsWraperHolder.this.l;
                        String str2 = FeedsWraperHolder.this.q;
                        kv2.e(activity2, str2, "circle", "circle_likes_" + FeedsWraperHolder.this.itemView.getTag(), false, null, hashMap3);
                    }
                }
            }
        };
        this.itemView.findViewById(i3).setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
    }

    private void s(FeedMergeDataDO feedMergeDataDO, DMRatingBar dMRatingBar) {
        List<WatchFeedData> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397726620")) {
            ipChange.ipc$dispatch("-397726620", new Object[]{this, feedMergeDataDO, dMRatingBar});
        } else if (dMRatingBar == null) {
        } else {
            int i2 = this.n;
            if ((i2 == FeedsAdapter.t || i2 == FeedsAdapter.u || i2 == FeedsAdapter.x) && (list = feedMergeDataDO.watchData) != null && list.size() > 0 && feedMergeDataDO.watchData.get(0) != null) {
                float value = feedMergeDataDO.watchData.get(0).getValue();
                Log.e("titleRatingBar", "============  mark: " + value);
                if (value > 0.0f) {
                    dMRatingBar.setVisibility(0);
                    dMRatingBar.setStarMark(value / 2.0f);
                    TextView textView = this.j;
                    if (textView != null) {
                        textView.setVisibility(0);
                        this.j.setText(feedMergeDataDO.watchData.get(0).getValueDesc());
                        return;
                    }
                    return;
                }
                Log.e("titleRatingBar", "============  mark:  mark gone 11111");
                dMRatingBar.setVisibility(8);
                TextView textView2 = this.j;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    return;
                }
                return;
            }
            Log.e("titleRatingBar", "============  mark:  mark gone 11111  mark gone 2222");
            dMRatingBar.setVisibility(8);
            TextView textView3 = this.j;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w(cn.damai.user.userprofile.bean.FeedMergeDataDO r11) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.w(cn.damai.user.userprofile.bean.FeedMergeDataDO):void");
    }

    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-993556639") ? (Activity) ipChange.ipc$dispatch("-993556639", new Object[]{this}) : this.l;
    }

    public void h(String str, String str2, Activity activity, String str3, String str4, int i2, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-779440507")) {
            ipChange.ipc$dispatch("-779440507", new Object[]{this, str, str2, activity, str3, str4, Integer.valueOf(i2), str5});
        } else if (this.k) {
            View view = this.itemView;
            int i3 = R$id.feeds_item_header;
            ImageView imageView = (ImageView) view.findViewById(i3);
            if (imageView == null) {
                return;
            }
            DMImageCreator k = cn.damai.common.image.a.b().c(str2).k(new yq(t60.a(activity, 1.0f), this.l.getResources().getColor(R$color.color_6black)));
            int i4 = R$drawable.uikit_user_default_icon;
            k.i(i4).c(i4).g(imageView);
            v(str, R$id.feeds_item_name);
            v(str3, R$id.feeds_item_date);
            this.itemView.findViewById(i3).setOnClickListener(new a(str4));
            View view2 = this.itemView;
            int i5 = R$id.user_b_tag;
            if (view2.findViewById(i5) != null) {
                if (!wh2.j(str5)) {
                    this.itemView.findViewById(i5).setVisibility(0);
                    if (str5.equals(InteractionFeedData.USER_BTAG_OFFICIAL)) {
                        ((ImageView) this.itemView.findViewById(i5)).setImageDrawable(this.l.getResources().getDrawable(R$drawable.feeds_user_tag_offical));
                        return;
                    } else if (str5.equals(InteractionFeedData.USER_BTAG_FANS)) {
                        ((ImageView) this.itemView.findViewById(i5)).setImageDrawable(this.l.getResources().getDrawable(R$drawable.feeds_user_tag_fans));
                        return;
                    } else {
                        this.itemView.findViewById(i5).setVisibility(8);
                        return;
                    }
                }
                this.itemView.findViewById(i5).setVisibility(8);
            }
        }
    }

    public int j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1952953989") ? ((Integer) ipChange.ipc$dispatch("1952953989", new Object[]{this})).intValue() : this.n;
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0266  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Bundle k(cn.damai.user.userprofile.bean.FeedMergeDataDO r12) {
        /*
            Method dump skipped, instructions count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.user.userprofile.cuser.view.FeedsWraperHolder.k(cn.damai.user.userprofile.bean.FeedMergeDataDO):android.os.Bundle");
    }

    public String l(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660990677")) {
            return (String) ipChange.ipc$dispatch("1660990677", new Object[]{this, str, str2, str3});
        }
        if (wh2.j(str)) {
            return "";
        }
        if (wh2.j(str2)) {
            return str;
        }
        String str4 = str + " / " + str2;
        if (wh2.j(str3)) {
            return str4;
        }
        return str + " / " + str2 + " / " + str3;
    }

    public void o(Bundle bundle, String str, int i2, int i3, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946332998")) {
            ipChange.ipc$dispatch("-946332998", new Object[]{this, bundle, str, Integer.valueOf(i2), Integer.valueOf(i3), str2});
        } else if (i2 != 9) {
            switch (i2) {
                case 1:
                    bundle.putString(FeedsViewModel.ARG_USERID, str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
                    return;
                case 2:
                    bundle.putString("artistid", str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
                    return;
                case 3:
                    bundle.putString(FeedsViewModel.ARG_USERID, str);
                    bundle.putString("usertype", "3");
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
                    return;
                case 4:
                    bundle.putString("brandid", str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
                    return;
                case 5:
                    bundle.putString(RepertoireDetailFragment.REPERTOIREID, str);
                    DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(u12.REPERTOITE));
                    return;
                case 6:
                    if (i3 == 0) {
                        return;
                    }
                    try {
                        bundle.putLong(IssueConstants.ProjectID, Long.parseLong(str));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                    qd2.a(this.l, str2, bundle);
                    return;
                default:
                    return;
            }
        } else {
            bundle.putString(FeedsViewModel.ARG_USERID, str);
            bundle.putString("usertype", "9");
            DMNav.from(this.l).withExtras(bundle).toUri(NavUri.b(cs.ARTISTID_THEME));
        }
    }

    public void r(ArrayList<String> arrayList, Activity activity, int i2, cn.damai.user.userprofile.bean.VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-693376614")) {
            ipChange.ipc$dispatch("-693376614", new Object[]{this, arrayList, activity, Integer.valueOf(i2), videoInfo});
            return;
        }
        NineGridlayout nineGridlayout = this.v;
        if (nineGridlayout != null) {
            nineGridlayout.setVisibility(0);
            this.v.setRadius(t60.a(activity, 6.0f));
            this.v.setGap(t60.a(activity, 3.0f));
            ArrayList arrayList2 = new ArrayList();
            String str = "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0";
            if (videoInfo != null) {
                String str2 = (arrayList == null || arrayList.size() <= 0) ? "" : "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0";
                NineGridlayout.Image image = new NineGridlayout.Image(videoInfo.coverUrl + str2);
                image.setShowPlay(true);
                arrayList2.add(image);
            }
            if (arrayList != null && arrayList.size() > 0) {
                if (arrayList2.size() <= 0 && (arrayList2.size() != 0 || arrayList.size() <= 1)) {
                    str = "";
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    NineGridlayout.Image image2 = new NineGridlayout.Image(it.next() + str);
                    image2.setShowPlay(false);
                    arrayList2.add(image2);
                }
            }
            if (arrayList2.size() > 0) {
                this.v.setTotalWidth(i2);
                this.v.updateImages(arrayList2);
                h hVar = new h(this, activity, videoInfo, arrayList);
                this.v.setListener(hVar);
                this.v.setOnClickListener(hVar);
                return;
            }
            this.v.setVisibility(8);
        }
    }

    public void setType(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313262733")) {
            ipChange.ipc$dispatch("-313262733", new Object[]{this, Integer.valueOf(i2)});
        } else {
            this.n = i2;
        }
    }

    public void t(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101056367")) {
            ipChange.ipc$dispatch("1101056367", new Object[]{this, view});
        } else {
            this.m = view;
        }
    }

    public void u(boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917270754")) {
            ipChange.ipc$dispatch("917270754", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i2)});
        } else {
            this.p = true;
        }
    }

    public void v(String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320946532")) {
            ipChange.ipc$dispatch("-320946532", new Object[]{this, str, Integer.valueOf(i2)});
        } else if (this.itemView.findViewById(i2) != null) {
            if (wh2.j(str)) {
                this.itemView.findViewById(i2).setVisibility(8);
                return;
            }
            this.itemView.findViewById(i2).setVisibility(0);
            ((TextView) this.itemView.findViewById(i2)).setText(str);
        }
    }

    public void x(FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226421456")) {
            ipChange.ipc$dispatch("-1226421456", new Object[]{this, feedMergeDataDO});
        }
    }

    public void y(FeedMergeDataDO feedMergeDataDO, boolean z, String str, String str2, String str3) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636252806")) {
            ipChange.ipc$dispatch("1636252806", new Object[]{this, feedMergeDataDO, Boolean.valueOf(z), str, str2, str3});
            return;
        }
        Log.e("titleRatingBar", "updateInfo ======= parent ");
        if (feedMergeDataDO == null) {
            return;
        }
        this.t = z;
        this.u = str;
        this.r = str2;
        this.s = str3;
        if (i(feedMergeDataDO) != null && (textView = this.g) != null) {
            textView.setVisibility(0);
            this.g.setOnClickListener(new b(feedMergeDataDO));
        } else {
            TextView textView2 = this.g;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            textView3.setText(feedMergeDataDO.year);
        }
        v(feedMergeDataDO.bizTime, R$id.feeds_item_date);
        v(feedMergeDataDO.title, R$id.feeds_item_title);
        Log.e("titleRatingBar", "============  mark:  titleRatingBar: " + this.i + " , cb : " + this.h);
        s(feedMergeDataDO, this.h);
        s(feedMergeDataDO, this.i);
        View view = this.c;
        if (view == null) {
            return;
        }
        if (!feedMergeDataDO.enableComment && !feedMergeDataDO.enableForward && !feedMergeDataDO.enablePraise) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        q(feedMergeDataDO);
    }

    public void z(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282129734")) {
            ipChange.ipc$dispatch("1282129734", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        View view = this.a;
        if (view == null || this.b == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
            this.b.setText(str);
            return;
        }
        view.setVisibility(8);
    }
}
