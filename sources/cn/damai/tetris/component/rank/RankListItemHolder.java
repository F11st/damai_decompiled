package cn.damai.tetris.component.rank;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.login.LoginManager;
import cn.damai.tetris.component.rank.RankListItemHolder;
import cn.damai.tetris.component.rank.bean.RankItemBean;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.jvm.JvmField;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cs;
import tb.k50;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankListItemHolder extends BaseViewHolder<RankItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static HashMap<Long, Boolean> u = new HashMap<>();
    @Nullable
    private final OnItemClickListener<RankItemBean> a;
    @JvmField
    @Nullable
    public RankItemBean b;
    @NotNull
    private final DMPosterView c;
    @NotNull
    private final TextView d;
    @NotNull
    private final TextView e;
    @NotNull
    private final TextView f;
    @NotNull
    private final View g;
    @NotNull
    private final TextView h;
    @NotNull
    private final DMDigitTextView i;
    @NotNull
    private final TextView j;
    @NotNull
    private final TextView k;
    @NotNull
    private final DMDigitTextView l;
    @NotNull
    private final SeeAnimateView m;
    @NotNull
    private final TextView n;
    private final int o;
    private final int p;
    @NotNull
    private final Context q;
    @NotNull
    private DMCommonTagView r;
    @NotNull
    private final TextView s;
    @NotNull
    private final TextView t;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final HashMap<Long, Boolean> a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "186216691") ? (HashMap) ipChange.ipc$dispatch("186216691", new Object[]{this}) : RankListItemHolder.u;
        }

        public final void b(@NotNull HashMap<Long, Boolean> hashMap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "410869551")) {
                ipChange.ipc$dispatch("410869551", new Object[]{this, hashMap});
                return;
            }
            b41.i(hashMap, "<set-?>");
            RankListItemHolder.u = hashMap;
        }
    }

    public RankListItemHolder(@Nullable View view, @Nullable OnItemClickListener<RankItemBean> onItemClickListener) {
        super(view);
        this.a = onItemClickListener;
        View findViewById = this.itemView.findViewById(R$id.poster);
        b41.h(findViewById, "itemView.findViewById(R.id.poster)");
        this.c = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.tv_order);
        b41.h(findViewById2, "itemView.findViewById(R.id.tv_order)");
        this.d = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R$id.tv_title);
        b41.h(findViewById3, "itemView.findViewById(R.id.tv_title)");
        this.e = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.tv_desc);
        b41.h(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.f = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.tv_desc_num);
        b41.h(findViewById5, "itemView.findViewById(R.id.tv_desc_num)");
        this.h = (TextView) findViewById5;
        View findViewById6 = this.itemView.findViewById(R$id.view);
        b41.h(findViewById6, "itemView.findViewById(R.id.view)");
        this.g = findViewById6;
        View findViewById7 = this.itemView.findViewById(R$id.tv_price_num);
        b41.h(findViewById7, "itemView.findViewById(R.id.tv_price_num)");
        this.i = (DMDigitTextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R$id.tv_price);
        b41.h(findViewById8, "itemView.findViewById(R.id.tv_price)");
        this.j = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R$id.tv_venue);
        b41.h(findViewById9, "itemView.findViewById(R.id.tv_venue)");
        this.k = (TextView) findViewById9;
        View findViewById10 = this.itemView.findViewById(R$id.tv_venue_dis);
        b41.h(findViewById10, "itemView.findViewById(R.id.tv_venue_dis)");
        this.l = (DMDigitTextView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R$id.tv_time);
        b41.h(findViewById11, "itemView.findViewById(R.id.tv_time)");
        this.n = (TextView) findViewById11;
        View findViewById12 = this.itemView.findViewById(R$id.wanna_2_see_icon);
        b41.h(findViewById12, "itemView.findViewById(R.id.wanna_2_see_icon)");
        SeeAnimateView seeAnimateView = (SeeAnimateView) findViewById12;
        this.m = seeAnimateView;
        View findViewById13 = this.itemView.findViewById(R$id.id_h_project_promotion_tag);
        b41.h(findViewById13, "itemView.findViewById(R.…_h_project_promotion_tag)");
        this.r = (DMCommonTagView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R$id.id_h_project_rec_prefix_tv);
        b41.h(findViewById14, "itemView.findViewById(R.…_h_project_rec_prefix_tv)");
        this.s = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R$id.id_h_project_rec_postfix_tv);
        b41.h(findViewById15, "itemView.findViewById(R.…h_project_rec_postfix_tv)");
        this.t = (TextView) findViewById15;
        seeAnimateView.setCancelImage();
        seeAnimateView.setOnClickListener(new View.OnClickListener() { // from class: tb.yy1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RankListItemHolder.d(RankListItemHolder.this, view2);
            }
        });
        this.itemView.setOnClickListener(this);
        Context context = this.itemView.getContext();
        b41.h(context, "itemView.context");
        this.q = context;
        this.o = m62.a(mu0.a(), 72.0f);
        this.p = m62.a(mu0.a(), 102.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RankListItemHolder rankListItemHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251188546")) {
            ipChange.ipc$dispatch("-251188546", new Object[]{rankListItemHolder, view});
            return;
        }
        b41.i(rankListItemHolder, "this$0");
        rankListItemHolder.l();
    }

    private final String i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "755398891")) {
            return (String) ipChange.ipc$dispatch("755398891", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        RankItemBean rankItemBean = this.b;
        if (rankItemBean == null) {
            return "";
        }
        if (!TextUtils.isEmpty(rankItemBean.cityName)) {
            sb.append(rankItemBean.cityName);
            if (!TextUtils.isEmpty(rankItemBean.venueName)) {
                sb.append("·");
                sb.append(rankItemBean.venueName);
            }
            if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
                sb.append("·距你");
            }
        } else if (!TextUtils.isEmpty(rankItemBean.venueName)) {
            sb.append(rankItemBean.venueName);
            if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
                sb.append("·距你");
            }
        } else if (!TextUtils.isEmpty(rankItemBean.getDistance())) {
            sb.append("距你");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "locationDes.toString()");
        return sb2;
    }

    private final String j(int i) {
        boolean p;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190214950")) {
            return (String) ipChange.ipc$dispatch("1190214950", new Object[]{this, Integer.valueOf(i)});
        }
        if (i <= 0) {
            return i + "";
        } else if (i >= 10000) {
            try {
                String valueOf = String.valueOf(((int) ((i / 10000) * 10)) / 10.0f);
                p = o.p(valueOf, "0", false, 2, null);
                if (p) {
                    valueOf = valueOf.substring(0, valueOf.length() - 2);
                    b41.h(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                return valueOf + (char) 19975;
            } catch (Exception unused) {
                return "";
            }
        } else {
            return i + "";
        }
    }

    private final SpannableStringBuilder k(String str) {
        boolean K;
        boolean K2;
        int Z;
        int Z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939896128")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("-1939896128", new Object[]{this, str});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        K = StringsKt__StringsKt.K(str, "【", false, 2, null);
        if (K) {
            Z2 = StringsKt__StringsKt.Z(str, "【", 0, false, 6, null);
            spannableStringBuilder.setSpan(new ImageSpan(mu0.a(), R$drawable.symbol_name_left, 1), Z2, Z2 + 1, 18);
        }
        K2 = StringsKt__StringsKt.K(str, "】", false, 2, null);
        if (K2) {
            Z = StringsKt__StringsKt.Z(str, "】", 0, false, 6, null);
            spannableStringBuilder.setSpan(new ImageSpan(mu0.a(), R$drawable.symbol_name_right, 1), Z, Z + 1, 18);
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(@org.jetbrains.annotations.Nullable cn.damai.tetris.component.rank.bean.RankItemBean r11, int r12) {
        /*
            Method dump skipped, instructions count: 786
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.tetris.component.rank.RankListItemHolder.a(cn.damai.tetris.component.rank.bean.RankItemBean, int):void");
    }

    public final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504789225")) {
            ipChange.ipc$dispatch("-1504789225", new Object[]{this});
            return;
        }
        final RankItemBean rankItemBean = this.b;
        if (rankItemBean == null) {
            return;
        }
        if (LoginManager.k().q()) {
            int i = !b41.d(u.get(Long.valueOf(rankItemBean.id)), Boolean.TRUE) ? 1 : 0;
            FollowRequest followRequest = new FollowRequest();
            followRequest.operateType = String.valueOf(i);
            followRequest.targetId = String.valueOf(rankItemBean.id);
            followRequest.targetType = "7";
            followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.tetris.component.rank.RankListItemHolder$wantSeeClick$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(@NotNull String str, @NotNull String str2) {
                    OnItemClickListener onItemClickListener;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-871926525")) {
                        ipChange2.ipc$dispatch("-871926525", new Object[]{this, str, str2});
                        return;
                    }
                    b41.i(str, "errorCode");
                    b41.i(str2, "errorMsg");
                    FollowDataBean followDataBean = new FollowDataBean();
                    followDataBean.setStatus(0);
                    onItemClickListener = this.a;
                    if (onItemClickListener != null) {
                        onItemClickListener.onWantSeeClick(this.b, RankItemBean.this.index, followDataBean);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(@NotNull FollowDataBean followDataBean) {
                    OnItemClickListener onItemClickListener;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-461358851")) {
                        ipChange2.ipc$dispatch("-461358851", new Object[]{this, followDataBean});
                        return;
                    }
                    b41.i(followDataBean, "followDataBean");
                    RankListItemHolder.Companion.a().put(Long.valueOf(RankItemBean.this.id), Boolean.valueOf(followDataBean.getStatus() > 0));
                    this.updateFollowState(followDataBean);
                    onItemClickListener = this.a;
                    if (onItemClickListener != null) {
                        onItemClickListener.onWantSeeClick(this.b, RankItemBean.this.index, followDataBean);
                    }
                }
            });
            return;
        }
        DMNav.from(this.q).forResult(4097).toUri(cs.f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1743251443")) {
            ipChange.ipc$dispatch("-1743251443", new Object[]{this, view});
            return;
        }
        b41.i(view, "v");
        OnItemClickListener<RankItemBean> onItemClickListener = this.a;
        if (onItemClickListener != null) {
            RankItemBean rankItemBean = this.b;
            b41.f(rankItemBean);
            onItemClickListener.onItemClick(rankItemBean, rankItemBean.index);
        }
    }

    public final void updateFollowState(@NotNull FollowDataBean followDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1803518598")) {
            ipChange.ipc$dispatch("-1803518598", new Object[]{this, followDataBean});
            return;
        }
        b41.i(followDataBean, "bean");
        RankItemBean rankItemBean = this.b;
        if (rankItemBean == null) {
            return;
        }
        u.put(Long.valueOf(rankItemBean.id), Boolean.valueOf(followDataBean.getStatus() > 0));
        if (b41.d(u.get(Long.valueOf(rankItemBean.id)), Boolean.TRUE)) {
            this.m.setFollowImage();
            this.m.clickAnimate();
            return;
        }
        this.m.setCancelImage();
        this.m.cancelAnimate();
    }
}
