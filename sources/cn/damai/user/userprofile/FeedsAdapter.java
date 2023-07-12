package cn.damai.user.userprofile;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.ArticleFeedData;
import cn.damai.user.userprofile.bean.DynamicFeedData;
import cn.damai.user.userprofile.bean.FeedMergeDataDO;
import cn.damai.user.userprofile.bean.FeedsData;
import cn.damai.user.userprofile.bean.FeedsResponse;
import cn.damai.user.userprofile.bean.FollowFeedData;
import cn.damai.user.userprofile.bean.WatchFeedData;
import cn.damai.user.userprofile.cuser.view.ArticleHolder;
import cn.damai.user.userprofile.cuser.view.CommentViewHolder;
import cn.damai.user.userprofile.cuser.view.FeedsWraperHolder;
import cn.damai.user.userprofile.cuser.view.FollowProjListHolder;
import cn.damai.user.userprofile.cuser.view.FollowUserListHolder;
import cn.damai.user.userprofile.cuser.view.FollowViewHolder;
import cn.damai.user.userprofile.cuser.view.ForwardArticleHolder;
import cn.damai.user.userprofile.cuser.view.ForwardCommentViewHolder;
import cn.damai.user.userprofile.cuser.view.ForwardInfoViewHolder;
import cn.damai.user.userprofile.cuser.view.InfoViewHolder;
import com.alibaba.security.common.track.model.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.g41;
import tb.kv2;
import tb.lu2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FeedsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int A = 45;
    public static int B = 46;
    public static int C = 49;
    public static int D = 20;
    public static int E = 40;
    public static int F = 86;
    public static int G = 97;
    public static int m = 11;
    public static int n = 12;
    public static int o = 13;
    public static int p = 14;
    public static int q = 15;
    public static int r = 22;
    public static int s = 30;
    public static int t = 53;
    public static int u = 56;
    public static int v = 122;
    public static int w = 111;
    public static int x = 153;
    public static int y = 41;
    public static int z = 44;
    private Context b;
    private List<FeedMergeDataDO> c;
    private View d;
    boolean e;
    String f;
    String g;
    int i;
    String j;
    String l;
    private String a = "";
    boolean h = false;
    boolean k = false;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        a(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-779194969")) {
                ipChange.ipc$dispatch("-779194969", new Object[]{this, view});
                return;
            }
            FeedsAdapter.this.f(this.a.dynamicData.get(0).url);
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        b(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1332095400")) {
                ipChange.ipc$dispatch("1332095400", new Object[]{this, view});
                return;
            }
            WatchFeedData watchFeedData = this.a.watchData.get(0);
            String str = watchFeedData.url;
            Bundle bundle = new Bundle();
            bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, watchFeedData.bizId);
            DMNav.from(FeedsAdapter.this.b).needLogin().withExtras(bundle).toUri(NavUri.b("commentdetail"));
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FeedMergeDataDO a;
        final /* synthetic */ RecyclerView.ViewHolder b;

        c(FeedMergeDataDO feedMergeDataDO, RecyclerView.ViewHolder viewHolder) {
            this.a = feedMergeDataDO;
            this.b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-851581527")) {
                ipChange.ipc$dispatch("-851581527", new Object[]{this, view});
                return;
            }
            FeedsAdapter.this.f(this.a.articleData.get(0).url);
            FeedsAdapter.this.k(this.b, this.a);
        }
    }

    public FeedsAdapter(Context context, FeedsResponse feedsResponse, View view, String str) {
        this.b = context;
        this.d = view;
        this.j = str;
        if (feedsResponse != null) {
            FeedsData feedsData = feedsResponse.data;
        }
    }

    private RecyclerView.ViewHolder d(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "376876304") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("376876304", new Object[]{this, viewGroup, Integer.valueOf(i)}) : e(viewGroup, i);
    }

    private RecyclerView.ViewHolder e(ViewGroup viewGroup, int i) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1380863312")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-1380863312", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        Log.d("getViewHolder", "viewtype: " + i);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R$layout.user_feeds_item_wrapper, viewGroup, false);
        if (i != r && i != t && i != u && i != F && i != G) {
            int i4 = A;
            if (i != i4 && i != (i2 = B)) {
                int i5 = y;
                if ((i >= i5 && i <= z) || i == (i3 = C)) {
                    linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_follow_item, (ViewGroup) null));
                    return new FollowViewHolder(linearLayout, (Activity) this.b, this.j);
                } else if (i == n) {
                    linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_zhuanfa, (ViewGroup) null));
                    return new ForwardInfoViewHolder(linearLayout, (Activity) this.b, this.j);
                } else if (i != o && i != q) {
                    int i6 = D;
                    if ((i >= i5 + i6 && i <= z + i6) || i == i3 + i6) {
                        linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_feeds_cell_follow_user, (ViewGroup) null));
                        return new FollowUserListHolder(linearLayout, (Activity) this.b, this.j);
                    } else if (i != i4 + i6 && i != i2 + i6) {
                        if (i == s) {
                            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_article, (ViewGroup) null));
                            return new ArticleHolder(linearLayout, (Activity) this.b, this.j);
                        } else if (i == p) {
                            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_zhuanfa_article_item, (ViewGroup) null));
                            return new ForwardArticleHolder(linearLayout, (Activity) this.b, this.j);
                        } else if (i == w) {
                            InfoViewHolder infoViewHolder = new InfoViewHolder(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_quanzi, (ViewGroup) null), (Activity) this.b, this.j);
                            infoViewHolder.k = true;
                            boolean z2 = this.h;
                            if (z2) {
                                infoViewHolder.u(z2, this.i);
                            }
                            return infoViewHolder;
                        } else if (i != v && i != x) {
                            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item, (ViewGroup) linearLayout, false));
                            InfoViewHolder infoViewHolder2 = new InfoViewHolder(linearLayout, (Activity) this.b, this.j);
                            infoViewHolder2.k = false;
                            return infoViewHolder2;
                        } else {
                            InfoViewHolder infoViewHolder3 = new InfoViewHolder(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_quanzi_comment, (ViewGroup) null), (Activity) this.b, this.j);
                            infoViewHolder3.k = true;
                            boolean z3 = this.h;
                            if (z3) {
                                infoViewHolder3.u(z3, this.i);
                            }
                            return infoViewHolder3;
                        }
                    } else {
                        linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_feeds_cell_follow_user, (ViewGroup) null));
                        return new FollowProjListHolder(linearLayout, (Activity) this.b, this.j);
                    }
                } else {
                    linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.user_list_item_zhuanfa_comment, (ViewGroup) null));
                    return new ForwardCommentViewHolder(linearLayout, (Activity) this.b, this.j);
                }
            }
            linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_like_item, (ViewGroup) null));
            return new FollowViewHolder(linearLayout, (Activity) this.b, this.j);
        }
        linearLayout.addView(LayoutInflater.from(this.b).inflate(R$layout.cuser_feeds_item, (ViewGroup) null));
        return new CommentViewHolder(linearLayout, (Activity) this.b, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659445054")) {
            ipChange.ipc$dispatch("-1659445054", new Object[]{this, str});
        } else if (!wh2.j(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(a.c.d));
        } else {
            Log.d("netlog", "url is null");
        }
    }

    private void g(RecyclerView.ViewHolder viewHolder, int i, FeedMergeDataDO feedMergeDataDO) {
        List<WatchFeedData> list;
        List<DynamicFeedData> list2;
        List<ArticleFeedData> list3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1654653441")) {
            ipChange.ipc$dispatch("-1654653441", new Object[]{this, viewHolder, Integer.valueOf(i), feedMergeDataDO});
        } else if (getItemViewType(i) != m && getItemViewType(i) != n && getItemViewType(i) != o && getItemViewType(i) != w && getItemViewType(i) != t && getItemViewType(i) != u && getItemViewType(i) != x && getItemViewType(i) != q) {
            if (getItemViewType(i) != s || feedMergeDataDO == null || (list3 = feedMergeDataDO.articleData) == null || list3.size() <= 0) {
                return;
            }
            viewHolder.itemView.setOnClickListener(new c(feedMergeDataDO, viewHolder));
        } else if (feedMergeDataDO != null && (list2 = feedMergeDataDO.dynamicData) != null && list2.size() > 0) {
            viewHolder.itemView.setOnClickListener(new a(feedMergeDataDO, viewHolder));
        } else if (feedMergeDataDO == null || (list = feedMergeDataDO.watchData) == null || list.size() <= 0) {
        } else {
            viewHolder.itemView.setOnClickListener(new b(feedMergeDataDO, viewHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(RecyclerView.ViewHolder viewHolder, FeedMergeDataDO feedMergeDataDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265375923")) {
            ipChange.ipc$dispatch("265375923", new Object[]{this, viewHolder, feedMergeDataDO});
        } else if (!this.k) {
            HashMap hashMap = new HashMap();
            if (feedMergeDataDO != null) {
                hashMap.put("content_id", kv2.b(feedMergeDataDO));
                hashMap.put("content_type", feedMergeDataDO.bizType);
                List<DynamicFeedData> list = feedMergeDataDO.dynamicData;
                if (list != null && list.get(0) != null) {
                    hashMap.put("circle_id", feedMergeDataDO.dynamicData.get(0).circleId);
                }
            }
            Context context = this.b;
            String str = this.j;
            kv2.e(context, str, lu2.DYNAMIC, "dynamic_" + viewHolder.itemView.getTag(), true, new HashMap(), hashMap);
        } else {
            HashMap hashMap2 = new HashMap();
            if (feedMergeDataDO != null) {
                hashMap2.put("content_id", kv2.b(feedMergeDataDO));
                hashMap2.put("content_type", feedMergeDataDO.bizType);
                hashMap2.put("circle_id", this.l);
            }
            Context context2 = this.b;
            String str2 = this.j;
            kv2.e(context2, str2, "circle", "circle_" + viewHolder.itemView.getTag(), true, new HashMap(), hashMap2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659184982")) {
            return ((Integer) ipChange.ipc$dispatch("659184982", new Object[]{this})).intValue();
        }
        List<FeedMergeDataDO> list = this.c;
        int size = list != null ? list.size() : 0;
        Log.d("getItemCount", "getItemCount : " + size);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676545283")) {
            return ((Integer) ipChange.ipc$dispatch("-676545283", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        Log.e("getItemViewType", " -------- getItemViewType: " + i);
        List<FeedMergeDataDO> list = this.c;
        if (list == null || i < 0) {
            return 0;
        }
        FeedMergeDataDO feedMergeDataDO = list.get(i);
        if (feedMergeDataDO == null || wh2.j(feedMergeDataDO.bizType)) {
            return i;
        }
        if (!feedMergeDataDO.bizType.startsWith("6.") && !feedMergeDataDO.bizType.startsWith("7.")) {
            if ("4".equals(feedMergeDataDO.bizType)) {
                List<FollowFeedData> list2 = feedMergeDataDO.followData;
                if (list2 == null || list2.size() <= 0) {
                    return i;
                }
                FollowFeedData followFeedData = feedMergeDataDO.followData.get(0);
                if (feedMergeDataDO.followData.size() == 1) {
                    i2 = E;
                    i3 = followFeedData.subBizType;
                } else {
                    i2 = E + followFeedData.subBizType;
                    i3 = D;
                }
                return i2 + i3;
            }
            int parseFloat = (int) (Float.parseFloat(feedMergeDataDO.bizType) * 10.0f);
            return this.k ? parseFloat + 100 : parseFloat;
        } else if (this.k) {
            return w;
        } else {
            return m;
        }
    }

    public void h(boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "731325649")) {
            ipChange.ipc$dispatch("731325649", new Object[]{this, Boolean.valueOf(z2)});
        }
    }

    public void i(boolean z2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-771341225")) {
            ipChange.ipc$dispatch("-771341225", new Object[]{this, Boolean.valueOf(z2), Integer.valueOf(i)});
            return;
        }
        this.h = true;
        this.i = i;
    }

    public void j(FeedsResponse feedsResponse, boolean z2, boolean z3, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-625594766")) {
            ipChange.ipc$dispatch("-625594766", new Object[]{this, feedsResponse, Boolean.valueOf(z2), Boolean.valueOf(z3), str, str2});
            return;
        }
        this.k = z2;
        this.e = z3;
        this.f = str;
        this.g = str2;
        FeedsData feedsData = feedsResponse.data;
        if (feedsData == null) {
            return;
        }
        this.l = feedsData.circleId;
        if (feedsData.feedMergeDataList == null) {
            feedsData.feedMergeDataList = new ArrayList();
        }
        this.c = feedsResponse.data.feedMergeDataList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869973021")) {
            ipChange.ipc$dispatch("-1869973021", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        List<FeedMergeDataDO> list = this.c;
        if (list == null) {
            return;
        }
        FeedMergeDataDO feedMergeDataDO = i < list.size() ? this.c.get(i) : null;
        FeedsWraperHolder feedsWraperHolder = (FeedsWraperHolder) viewHolder;
        feedsWraperHolder.z(false, "");
        feedsWraperHolder.t(this.d);
        if (i == 0 && feedMergeDataDO != null) {
            feedsWraperHolder.z(true, feedMergeDataDO.year);
            this.a = feedMergeDataDO.year;
        } else if (!this.k && feedMergeDataDO != null && !wh2.j(feedMergeDataDO.year) && i - 1 >= 0 && this.c.get(i2) != null) {
            this.a = this.c.get(i2).year;
            Log.d("year", "lastyear: " + this.a + " , yearxx : " + feedMergeDataDO.year);
            if (!"".equals(this.a) && feedMergeDataDO.year.equals(this.a)) {
                feedsWraperHolder.z(false, "");
            } else {
                feedsWraperHolder.z(true, feedMergeDataDO.year);
                Log.d("year", "lastyearxx: " + this.a);
            }
        }
        if (feedMergeDataDO != null) {
            if (!(viewHolder instanceof FollowViewHolder) && !(viewHolder instanceof FollowProjListHolder) && !(viewHolder instanceof FollowUserListHolder)) {
                feedMergeDataDO.enablePraise = true;
                feedMergeDataDO.enableComment = true;
                feedMergeDataDO.enableForward = true;
            } else {
                feedMergeDataDO.enablePraise = false;
                feedMergeDataDO.enableComment = false;
                feedMergeDataDO.enableForward = false;
            }
        }
        feedsWraperHolder.y(feedMergeDataDO, this.e, this.l, this.f, this.g);
        viewHolder.itemView.setTag(Integer.valueOf(i));
        Log.e("titleRatingBar", "instanceof " + viewHolder);
        if (viewHolder instanceof FeedsWraperHolder) {
            FeedsWraperHolder feedsWraperHolder2 = (FeedsWraperHolder) viewHolder;
            if (feedMergeDataDO != null) {
                feedsWraperHolder2.x(feedMergeDataDO);
            }
        }
        g(viewHolder, i, feedMergeDataDO);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "737826675")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("737826675", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        FeedsWraperHolder feedsWraperHolder = (FeedsWraperHolder) d(viewGroup, i);
        feedsWraperHolder.setType(i);
        return feedsWraperHolder;
    }
}
