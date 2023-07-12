package cn.damai.tetris.component.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.comment.bean.FollowStateBean;
import cn.damai.comment.request.FollowUpdateRequest;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.tetris.component.home.adapter.RecentShowAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.LiveRoomView;
import cn.damai.uikit.view.ScoreStarViewV2;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.C9826vr;
import tb.cs;
import tb.d23;
import tb.jm1;
import tb.m62;
import tb.mu0;
import tb.oy0;
import tb.t60;
import tb.wh2;
import tb.xr;
import tb.xw0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RecentShowAdapter extends RecyclerView.Adapter<RankItemViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<HomePageRecentBean.Labels.HomePageRecentItems> a;
    private final Context b;
    private String c;
    private TrackInfo d;
    private JSONObject e;
    private int f;
    private int g;
    private String h;
    private View.OnClickListener i = new View$OnClickListenerC1850a();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class RankItemViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        ImageView a;
        TextView b;
        TextView c;
        DMDigitTextView d;
        DMDigitTextView e;
        View f;
        ViewGroup g;
        DMCategroyTagView h;
        LiveRoomView i;
        LinearLayout j;
        DMDigitTextView k;
        ScoreStarViewV2 l;
        LinearLayout m;
        DMDigitTextView n;
        TextView o;
        TextView p;
        ImageView q;
        View r;
        private HashMap<String, Integer> s;

        public RankItemViewHolder() {
            super(LayoutInflater.from(RecentShowAdapter.this.b).inflate(R$layout.homepage_rank_item, (ViewGroup) null));
            this.a = (ImageView) this.itemView.findViewById(R$id.homepage_rank_item_image_normal);
            this.b = (TextView) this.itemView.findViewById(R$id.homepage_rank_item_title);
            this.c = (TextView) this.itemView.findViewById(R$id.homepage_rank_item_time);
            this.f = this.itemView.findViewById(R$id.homepage_rank_item_price_layout);
            this.g = (ViewGroup) this.itemView.findViewById(R$id.homepage_rank_item_tag_view);
            this.d = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_rank_item_price);
            DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_rank_item_price_unknown);
            this.e = dMDigitTextView;
            dMDigitTextView.setVisibility(8);
            this.h = (DMCategroyTagView) this.itemView.findViewById(R$id.homepage_rank_item_image_tag);
            this.i = (LiveRoomView) this.itemView.findViewById(R$id.homepage_rank_item_live_room);
            this.j = (LinearLayout) this.itemView.findViewById(R$id.score_ll);
            this.k = (DMDigitTextView) this.itemView.findViewById(R$id.score_text);
            this.l = (ScoreStarViewV2) this.itemView.findViewById(R$id.score_icon);
            this.m = (LinearLayout) this.itemView.findViewById(R$id.want_see_ll);
            this.n = (DMDigitTextView) this.itemView.findViewById(R$id.want_see_num_text);
            this.o = (TextView) this.itemView.findViewById(R$id.want_see_des);
            this.p = (TextView) this.itemView.findViewById(R$id.tv_want_see_btn);
            this.q = (ImageView) this.itemView.findViewById(R$id.homepage_rank_item_rank);
            this.r = this.itemView.findViewById(R$id.id_project_poster_container);
            this.itemView.setOnClickListener(RecentShowAdapter.this.i);
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(t60.a(RecentShowAdapter.this.b, 98.0f), -2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i, HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "678615390")) {
                ipChange.ipc$dispatch("678615390", new Object[]{this, Integer.valueOf(i), homePageRecentItems, view});
                return;
            }
            HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems2 = (HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i);
            if ("1".equals(homePageRecentItems2.itemShowStyle) || "2".equals(homePageRecentItems2.itemShowStyle)) {
                oy0.B().y(RecentShowAdapter.this.d, homePageRecentItems2.projectId, RecentShowAdapter.this.g, homePageRecentItems.position, homePageRecentItems2.wantSee);
            }
            f(homePageRecentItems2.projectId, homePageRecentItems2.wantSee, i);
        }

        private void f(String str, boolean z, final int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-485408314")) {
                ipChange.ipc$dispatch("-485408314", new Object[]{this, str, Boolean.valueOf(z), Integer.valueOf(i)});
            } else {
                new FollowUpdateRequest(!z, str).request(new DMMtopRequestListener<FollowStateBean>(FollowStateBean.class) { // from class: cn.damai.tetris.component.home.adapter.RecentShowAdapter.RankItemViewHolder.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                    public void onFail(String str2, String str3) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1643609503")) {
                            ipChange2.ipc$dispatch("-1643609503", new Object[]{this, str2, str3});
                            return;
                        }
                        Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + str2 + " , " + str3);
                    }

                    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                    public void onSuccess(FollowStateBean followStateBean) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1538300951")) {
                            ipChange2.ipc$dispatch("-1538300951", new Object[]{this, followStateBean});
                            return;
                        }
                        boolean isFollowed = followStateBean.isFollowed();
                        ((HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i)).wantSee = isFollowed;
                        int j = jm1.j(((HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i)).wantSeeCount, 0);
                        ((HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i)).wantSeeCount = String.valueOf(isFollowed ? j + 1 : j - 1);
                        RankItemViewHolder.this.h(isFollowed);
                        RankItemViewHolder rankItemViewHolder = RankItemViewHolder.this;
                        rankItemViewHolder.g(((HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i)).wantSeeCount);
                        if (isFollowed) {
                            xr.c("showFollowTips", (HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i));
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-571664759")) {
                ipChange.ipc$dispatch("-571664759", new Object[]{this, str});
                return;
            }
            float i = jm1.i(str, 0.0f);
            this.m.setVisibility(i <= 30.0f ? 8 : 0);
            double doubleValue = new BigDecimal(i / 10000.0f).setScale(1, RoundingMode.HALF_UP).doubleValue();
            if (i >= 10000.0f) {
                this.n.setText(String.valueOf(doubleValue));
                this.o.setText("万人想看");
                return;
            }
            this.n.setText(str);
            this.o.setText("人想看");
        }

        private Integer getImageByIndex(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2067725640")) {
                return (Integer) ipChange.ipc$dispatch("2067725640", new Object[]{this, str});
            }
            if (this.s == null) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                this.s = hashMap;
                hashMap.put("1", Integer.valueOf(R$drawable.homepage_rank_icon_0));
                this.s.put("2", Integer.valueOf(R$drawable.homepage_rank_icon_1));
                this.s.put("3", Integer.valueOf(R$drawable.homepage_rank_icon_2));
                this.s.put("4", Integer.valueOf(R$drawable.homepage_rank_icon_3));
                this.s.put("5", Integer.valueOf(R$drawable.homepage_rank_icon_4));
                this.s.put("6", Integer.valueOf(R$drawable.homepage_rank_icon_5));
                this.s.put("7", Integer.valueOf(R$drawable.homepage_rank_icon_6));
                this.s.put("8", Integer.valueOf(R$drawable.homepage_rank_icon_7));
                this.s.put("9", Integer.valueOf(R$drawable.homepage_rank_icon_8));
                this.s.put("10", Integer.valueOf(R$drawable.homepage_rank_icon_9));
            }
            return this.s.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-465172007")) {
                ipChange.ipc$dispatch("-465172007", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                this.p.setText("已想看");
                this.p.setTextColor(Color.parseColor("#5F6672"));
                this.p.setBackground(ResourcesCompat.getDrawable(RecentShowAdapter.this.b.getResources(), R$drawable.want_see_background, RecentShowAdapter.this.b.getTheme()));
            } else {
                this.p.setText("想看");
                this.p.setTextColor(Color.parseColor("#FFFFFF"));
                this.p.setBackground(ResourcesCompat.getDrawable(RecentShowAdapter.this.b.getResources(), R$drawable.want_see_background_already, RecentShowAdapter.this.b.getTheme()));
            }
        }

        public void d(final int i) {
            MarketTagBean marketTagBean;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-644265325")) {
                ipChange.ipc$dispatch("-644265325", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            final HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems = (HomePageRecentBean.Labels.HomePageRecentItems) RecentShowAdapter.this.a.get(i);
            if (homePageRecentItems == null) {
                return;
            }
            homePageRecentItems.position = i;
            if (this.a.getTag() instanceof C9826vr) {
                ((C9826vr) this.a.getTag()).cancel();
            }
            HashMap<String, String> hashMap = null;
            if (homePageRecentItems.isReferItem) {
                this.r.setBackgroundResource(R$drawable.bg_vertical_project_item_high_light);
                int a = m62.a(mu0.a(), 2.0f);
                this.r.setPadding(a, a, a, a);
            } else {
                this.r.setBackground(null);
                this.r.setPadding(0, 0, 0, 0);
            }
            DMImageCreator f = C0504a.b().f(homePageRecentItems.projectPic, t60.a(RecentShowAdapter.this.b, 98.0f), t60.a(RecentShowAdapter.this.b, 131.0f));
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            this.a.setTag(f.i(i2).c(i2).g(this.a));
            this.b.setText(homePageRecentItems.projectName);
            this.g.removeAllViews();
            if (!TextUtils.isEmpty(homePageRecentItems.priceLow) && !homePageRecentItems.priceLow.equals("价格待定") && !homePageRecentItems.priceLow.equals("待定")) {
                this.d.setText(homePageRecentItems.priceLow);
                marketTagBean = homePageRecentItems.gotTopTag(true);
                if (marketTagBean != null) {
                    DMCommonTagView addMarketTagView = marketTagBean.addMarketTagView(this.g, true);
                    if (addMarketTagView != null) {
                        addMarketTagView.setHasPandding(false);
                    }
                    addMarketTagView.setPadding(0, t60.a(this.g.getContext(), 1.5f), 0, 0);
                    addMarketTagView.setImgHeight(t60.a(this.g.getContext(), 36.666668f), t60.a(this.g.getContext(), 15.0f));
                }
                this.f.setVisibility(0);
                this.e.setVisibility(8);
            } else {
                this.f.setVisibility(8);
                this.e.setVisibility(0);
                marketTagBean = null;
            }
            if (homePageRecentItems.isLiveRoom()) {
                this.h.setVisibility(8);
                this.i.setLiveType(homePageRecentItems.getLiveType());
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
                if (TextUtils.isEmpty(homePageRecentItems.discountRate)) {
                    this.h.setTagName(homePageRecentItems.getCategoryNameCompat());
                } else {
                    this.h.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
                    this.h.setTagName(String.format("%s%s", homePageRecentItems.discountRate, "折起"));
                }
                this.h.setVisibility((TextUtils.isEmpty(homePageRecentItems.getCategoryNameCompat()) && TextUtils.isEmpty(homePageRecentItems.discountRate)) ? 8 : 0);
            }
            if (!TextUtils.isEmpty(homePageRecentItems.ranking)) {
                this.j.setVisibility(8);
                this.q.setVisibility(0);
                Integer imageByIndex = getImageByIndex(homePageRecentItems.ranking);
                if (imageByIndex != null) {
                    this.q.setImageResource(imageByIndex.intValue());
                }
            } else if (homePageRecentItems.itemScore > 0.0d) {
                this.j.setVisibility(0);
                this.q.setVisibility(8);
                this.k.setText(String.valueOf(homePageRecentItems.itemScore));
                this.l.updateView(homePageRecentItems.itemScore);
            } else {
                this.j.setVisibility(8);
                this.q.setVisibility(8);
            }
            this.c.setText(homePageRecentItems.getDesc());
            this.c.setPadding(0, "1".equals(homePageRecentItems.itemShowStyle) ? t60.a(RecentShowAdapter.this.b, 2.0f) : 0, 0, 0);
            this.c.setVisibility(0);
            this.itemView.setTag(homePageRecentItems);
            h(homePageRecentItems.wantSee);
            if ("1".equals(homePageRecentItems.itemShowStyle) || "2".equals(homePageRecentItems.itemShowStyle)) {
                this.j.setVisibility(8);
                this.q.setVisibility(8);
                g(homePageRecentItems.wantSeeCount);
            }
            this.p.setVisibility("1".equals(homePageRecentItems.itemShowStyle) ? 0 : 8);
            this.f.setVisibility("1".equals(homePageRecentItems.itemShowStyle) ? 8 : 0);
            this.p.setOnClickListener(new View.OnClickListener() { // from class: tb.jz1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecentShowAdapter.RankItemViewHolder.this.e(i, homePageRecentItems, view);
                }
            });
            try {
                if (homePageRecentItems.isReferItem && xw0.b(homePageRecentItems.projectId, xw0.c())) {
                    hashMap = xw0.a();
                }
                if (RecentShowAdapter.this.d != null) {
                    if (homePageRecentItems.trackInfo != null) {
                        RecentShowAdapter.this.d.putAll(homePageRecentItems.trackInfo);
                    }
                    if (marketTagBean != null && !TextUtils.isEmpty(marketTagBean.tag)) {
                        RecentShowAdapter.this.d.put("discount_type", (Object) marketTagBean.type);
                    }
                    RecentShowAdapter.this.d.put("index", (Object) ("tab_" + RecentShowAdapter.this.f));
                    RecentShowAdapter.this.d.put("item_id", (Object) homePageRecentItems.projectId);
                    if (!"1".equals(homePageRecentItems.itemShowStyle) && !"2".equals(homePageRecentItems.itemShowStyle)) {
                        oy0.B().F(RecentShowAdapter.this.d, this.itemView, RecentShowAdapter.this.c, homePageRecentItems.projectName, homePageRecentItems.schema, homePageRecentItems.alg, homePageRecentItems.projectId, homePageRecentItems.position, hashMap);
                        return;
                    }
                    oy0.B().G(RecentShowAdapter.this.d, this.itemView, this.p, homePageRecentItems.projectId, homePageRecentItems.position, RecentShowAdapter.this.g, hashMap);
                    return;
                }
                TrackInfo e = d23.e(RecentShowAdapter.this.h + i, RecentShowAdapter.this.e);
                if (e != null) {
                    if (marketTagBean != null && !TextUtils.isEmpty(marketTagBean.type)) {
                        e.put("discount_type", (Object) marketTagBean.type);
                    }
                    e.put("index", (Object) ("tab_" + RecentShowAdapter.this.f));
                    e.put("item_id", (Object) homePageRecentItems.projectId);
                    Map<String, String> argsMap = e.getArgsMap();
                    HashMap hashMap2 = new HashMap();
                    if (argsMap != null) {
                        hashMap2.putAll(argsMap);
                    }
                    if (hashMap != null) {
                        hashMap2.putAll(hashMap);
                    }
                    TrackProxy.a().userTrack(TrackType.expose, this.itemView, e.trackB, e.trackC, e.trackD + i, hashMap2, false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.tetris.component.home.adapter.RecentShowAdapter$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1850a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1850a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1768749497")) {
                ipChange.ipc$dispatch("-1768749497", new Object[]{this, view});
                return;
            }
            HomePageRecentBean.Labels.HomePageRecentItems homePageRecentItems = (HomePageRecentBean.Labels.HomePageRecentItems) view.getTag();
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            bundle.putString("from_page", "homepage");
            bundle.putString("projectImage", homePageRecentItems.projectPic);
            if (!TextUtils.isEmpty(homePageRecentItems.schema)) {
                DMNav.from(RecentShowAdapter.this.b).withExtras(bundle).toUri(homePageRecentItems.schema);
            } else {
                bundle.putString("id", homePageRecentItems.projectId);
                DMNav.from(RecentShowAdapter.this.b).withExtras(bundle).toUri(NavUri.b(cs.b));
            }
            HashMap<String, String> hashMap = null;
            try {
                if (homePageRecentItems.isReferItem && xw0.b(homePageRecentItems.projectId, xw0.c())) {
                    hashMap = xw0.a();
                }
                if (RecentShowAdapter.this.d != null) {
                    TrackInfo trackInfo = RecentShowAdapter.this.d;
                    trackInfo.put("index", (Object) ("tab_" + RecentShowAdapter.this.f));
                    RecentShowAdapter.this.d.put("item_id", (Object) homePageRecentItems.projectId);
                    if (!"1".equals(homePageRecentItems.itemShowStyle) && !"2".equals(homePageRecentItems.itemShowStyle)) {
                        oy0.B().m(RecentShowAdapter.this.d, RecentShowAdapter.this.c, homePageRecentItems.projectName, homePageRecentItems.schema, homePageRecentItems.scm, homePageRecentItems.projectId, homePageRecentItems.position, hashMap);
                        return;
                    }
                    oy0.B().z(RecentShowAdapter.this.d, homePageRecentItems.projectId, RecentShowAdapter.this.c, homePageRecentItems.position, RecentShowAdapter.this.g, hashMap);
                    return;
                }
                TrackInfo e = d23.e(RecentShowAdapter.this.h + homePageRecentItems.position, RecentShowAdapter.this.e);
                if (e != null) {
                    e.put("index", (Object) ("tab_" + RecentShowAdapter.this.f));
                    e.put("item_id", (Object) homePageRecentItems.projectId);
                    Map<String, String> argsMap = e.getArgsMap();
                    HashMap hashMap2 = new HashMap();
                    if (argsMap != null) {
                        hashMap2.putAll(argsMap);
                    }
                    if (hashMap != null) {
                        hashMap2.putAll(hashMap);
                    }
                    TrackProxy.ITrack a = TrackProxy.a();
                    TrackType trackType = TrackType.click;
                    String str = e.trackB;
                    String str2 = e.trackC;
                    a.userTrack(trackType, null, str, str2, e.trackD + homePageRecentItems.position, hashMap2, true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public RecentShowAdapter(Context context) {
        this.b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1624520182") ? ((Integer) ipChange.ipc$dispatch("1624520182", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@NonNull RankItemViewHolder rankItemViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464148350")) {
            ipChange.ipc$dispatch("464148350", new Object[]{this, rankItemViewHolder, Integer.valueOf(i)});
        } else {
            rankItemViewHolder.d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k */
    public RankItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1805745656") ? (RankItemViewHolder) ipChange.ipc$dispatch("1805745656", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new RankItemViewHolder();
    }

    public void l(String str, List<HomePageRecentBean.Labels.HomePageRecentItems> list, TrackInfo trackInfo, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084701640")) {
            ipChange.ipc$dispatch("2084701640", new Object[]{this, str, list, trackInfo, Integer.valueOf(i)});
            return;
        }
        this.a = list;
        this.c = str;
        this.d = trackInfo;
        this.g = i;
        notifyDataSetChanged();
    }

    public void m(String str, List<HomePageRecentBean.Labels.HomePageRecentItems> list, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944859520")) {
            ipChange.ipc$dispatch("-944859520", new Object[]{this, str, list, jSONObject});
            return;
        }
        this.a = list;
        this.c = str;
        this.e = jSONObject;
        notifyDataSetChanged();
    }

    public void n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673108362")) {
            ipChange.ipc$dispatch("-673108362", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.f = i;
        }
    }

    public void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800087381")) {
            ipChange.ipc$dispatch("1800087381", new Object[]{this, str});
        } else {
            this.h = str;
        }
    }
}
