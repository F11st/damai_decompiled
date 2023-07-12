package cn.damai.commonbusiness.wannasee.viewholder;

import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView;
import cn.damai.rank.RankSquareCMSActivity;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.component.project.TimerView;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jn1;
import tb.m62;
import tb.mu0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeeProjectViewHolder extends RecyclerView.ViewHolder implements WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private DMPosterView a;
    @NotNull
    private TextView b;
    @NotNull
    private ViewGroup c;
    @NotNull
    private TextView d;
    @NotNull
    private View e;
    @NotNull
    private ViewGroup f;
    @NotNull
    private TextView g;
    @NotNull
    private TextView h;
    @NotNull
    private TextView i;
    @NotNull
    private TextView j;
    @NotNull
    private View k;
    @NotNull
    private ViewGroup l;
    @NotNull
    private TextView m;
    @NotNull
    private TextView n;
    @NotNull
    private DMCommonTagView o;
    @NotNull
    private ViewGroup p;
    @NotNull
    private TextView q;
    @NotNull
    private TextView r;
    @NotNull
    private WantSeeRecommendView s;
    private int t;
    private int u;
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, wt2> v;
    @Nullable
    private ProjectItemBean w;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.wannasee.viewholder.WantSeeProjectViewHolder$a */
    /* loaded from: classes.dex */
    public static final class View$OnAttachStateChangeListenerC0987a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC0987a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1855494136")) {
                ipChange.ipc$dispatch("-1855494136", new Object[]{this, view});
                return;
            }
            WantSeeProjectViewHolder.this.l();
            ProjectItemBean projectItemBean = WantSeeProjectViewHolder.this.w;
            if (projectItemBean != null) {
                WantSeeProjectViewHolder wantSeeProjectViewHolder = WantSeeProjectViewHolder.this;
                if (wantSeeProjectViewHolder.i(projectItemBean)) {
                    wantSeeProjectViewHolder.k(projectItemBean);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-594933115")) {
                ipChange.ipc$dispatch("-594933115", new Object[]{this, view});
            } else {
                WantSeeProjectViewHolder.this.l();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantSeeProjectViewHolder(@NotNull ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_hor_project_card_view, viewGroup, false));
        b41.i(viewGroup, "parent");
        View findViewById = this.itemView.findViewById(R$id.id_h_project_poster);
        b41.h(findViewById, "itemView.findViewById(R.id.id_h_project_poster)");
        this.a = (DMPosterView) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.id_h_project_title);
        b41.h(findViewById2, "itemView.findViewById(R.id.id_h_project_title)");
        this.b = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R$id.id_h_project_score_layout);
        b41.h(findViewById3, "itemView.findViewById(R.…d_h_project_score_layout)");
        this.c = (ViewGroup) findViewById3;
        View findViewById4 = this.itemView.findViewById(R$id.id_h_project_score);
        b41.h(findViewById4, "itemView.findViewById(R.id.id_h_project_score)");
        this.d = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R$id.id_h_project_pending_price);
        b41.h(findViewById5, "itemView.findViewById(R.…_h_project_pending_price)");
        this.e = findViewById5;
        View findViewById6 = this.itemView.findViewById(R$id.id_h_project_price_layout);
        b41.h(findViewById6, "itemView.findViewById(R.…d_h_project_price_layout)");
        this.f = (ViewGroup) findViewById6;
        View findViewById7 = this.itemView.findViewById(R$id.id_h_project_price);
        b41.h(findViewById7, "itemView.findViewById(R.id.id_h_project_price)");
        this.g = (TextView) findViewById7;
        View findViewById8 = this.itemView.findViewById(R$id.id_h_project_address);
        b41.h(findViewById8, "itemView.findViewById(R.id.id_h_project_address)");
        this.h = (TextView) findViewById8;
        View findViewById9 = this.itemView.findViewById(R$id.id_h_project_date);
        b41.h(findViewById9, "itemView.findViewById(R.id.id_h_project_date)");
        this.i = (TextView) findViewById9;
        View findViewById10 = this.itemView.findViewById(R$id.id_h_project_action_tip);
        b41.h(findViewById10, "itemView.findViewById(R.….id_h_project_action_tip)");
        this.j = (TextView) findViewById10;
        View findViewById11 = this.itemView.findViewById(R$id.id_h_project_line1);
        b41.h(findViewById11, "itemView.findViewById(R.id.id_h_project_line1)");
        this.k = findViewById11;
        View findViewById12 = this.itemView.findViewById(R$id.id_h_project_rec_layout);
        b41.h(findViewById12, "itemView.findViewById(R.….id_h_project_rec_layout)");
        this.l = (ViewGroup) findViewById12;
        View findViewById13 = this.itemView.findViewById(R$id.id_h_project_rec_prefix_tv);
        b41.h(findViewById13, "itemView.findViewById(R.…_h_project_rec_prefix_tv)");
        this.m = (TextView) findViewById13;
        View findViewById14 = this.itemView.findViewById(R$id.id_h_project_rec_postfix_tv);
        b41.h(findViewById14, "itemView.findViewById(R.…h_project_rec_postfix_tv)");
        this.n = (TextView) findViewById14;
        View findViewById15 = this.itemView.findViewById(R$id.id_h_project_promotion_tag);
        b41.h(findViewById15, "itemView.findViewById(R.…_h_project_promotion_tag)");
        this.o = (DMCommonTagView) findViewById15;
        View findViewById16 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_layout);
        b41.h(findViewById16, "itemView.findViewById(R.…ct_rec_count_down_layout)");
        this.p = (ViewGroup) findViewById16;
        View findViewById17 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_day);
        b41.h(findViewById17, "itemView.findViewById(R.…oject_rec_count_down_day)");
        this.q = (TextView) findViewById17;
        View findViewById18 = this.itemView.findViewById(R$id.id_h_project_rec_count_down_hour_m_s);
        b41.h(findViewById18, "itemView.findViewById(R.…_rec_count_down_hour_m_s)");
        this.r = (TextView) findViewById18;
        View findViewById19 = this.itemView.findViewById(R$id.id_h_project_want_see_rec_layout);
        b41.h(findViewById19, "itemView.findViewById(R.…ject_want_see_rec_layout)");
        this.s = (WantSeeRecommendView) findViewById19;
        this.t = m62.a(this.itemView.getContext(), 76.0f);
        this.u = m62.a(this.itemView.getContext(), 102.0f);
        this.l.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0987a());
    }

    private final CharSequence f(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672813656")) {
            return (CharSequence) ipChange.ipc$dispatch("1672813656", new Object[]{this, projectItemBean});
        }
        StringBuilder sb = new StringBuilder();
        String str = projectItemBean.cityName;
        if (str != null) {
            b41.h(str, RankSquareCMSActivity.PRESET_CITY_NAME);
            sb.append(str);
        }
        String str2 = projectItemBean.venueName;
        if (str2 != null) {
            b41.h(str2, "venueName");
            if (sb.length() > 0) {
                sb.append("·");
            }
            sb.append(str2);
        }
        String str3 = projectItemBean.formattedDistance;
        if (str3 != null) {
            b41.h(str3, "formattedDistance");
            if (sb.length() > 0) {
                sb.append("·距你");
            }
            sb.append(str3);
        }
        return sb;
    }

    private final CharSequence g(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "860923128")) {
            return (CharSequence) ipChange.ipc$dispatch("860923128", new Object[]{this, projectItemBean});
        }
        String str = projectItemBean.liveStartTime;
        String str2 = str == null || str.length() == 0 ? projectItemBean.showTime : projectItemBean.liveStartTime;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            return "时间待定";
        }
        b41.h(str2, "s");
        return str2;
    }

    private final CharSequence h(ProjectItemBean projectItemBean) {
        int Z;
        int Z2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1381193242")) {
            return (CharSequence) ipChange.ipc$dispatch("-1381193242", new Object[]{this, projectItemBean});
        }
        String str = projectItemBean.name;
        try {
            if (!TextUtils.isEmpty(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                Z = StringsKt__StringsKt.Z(spannableStringBuilder, "【", 0, false, 6, null);
                if (Z >= 0) {
                    spannableStringBuilder.setSpan(new ImageSpan(mu0.a(), R$drawable.symbol_name_left, 1), Z, Z + 1, 18);
                }
                Z2 = StringsKt__StringsKt.Z(spannableStringBuilder, "】", 0, false, 6, null);
                if (Z2 >= 0) {
                    spannableStringBuilder.setSpan(new ImageSpan(mu0.a(), R$drawable.symbol_name_right, 1), Z2, Z2 + 1, 18);
                }
                return spannableStringBuilder;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2035835308") ? ((Boolean) ipChange.ipc$dispatch("2035835308", new Object[]{this, projectItemBean})).booleanValue() : b41.d("1", projectItemBean.recommendHintType) && projectItemBean.getCountDownTimeMills() > 0 && projectItemBean.tempDeviceBootTime > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-617223809")) {
            ipChange.ipc$dispatch("-617223809", new Object[]{this, projectItemBean});
            return;
        }
        this.l.setVisibility(0);
        this.p.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setText(projectItemBean.recommendHintTitle);
        long countDownTimeMills = projectItemBean.getCountDownTimeMills() - (SystemClock.elapsedRealtime() - projectItemBean.tempDeviceBootTime);
        if (countDownTimeMills > 0) {
            WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(countDownTimeMills, 1000L, this);
            this.l.setTag(weakRefCountDownTimer);
            weakRefCountDownTimer.start();
            TimerView.C3490a dateResult = TimerView.getDateResult(countDownTimeMills);
            b41.h(dateResult, "getDateResult(countDownMsSurplus)");
            this.q.setText(dateResult.a);
            this.r.setText(dateResult.b + jn1.CONDITION_IF_MIDDLE + dateResult.c + jn1.CONDITION_IF_MIDDLE + dateResult.d);
            return;
        }
        this.q.setText("00");
        this.r.setText("00:00:00");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-484999566")) {
            ipChange.ipc$dispatch("-484999566", new Object[]{this});
            return;
        }
        Object tag = this.l.getTag();
        if (tag == null || !(tag instanceof WeakRefCountDownTimer)) {
            return;
        }
        ((WeakRefCountDownTimer) tag).cancel();
        this.l.setTag(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x022b, code lost:
        r13 = r12.recommendHintType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x022d, code lost:
        if (r13 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0233, code lost:
        switch(r13.hashCode()) {
            case 50: goto L75;
            case 51: goto L73;
            case 52: goto L50;
            default: goto L96;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x023c, code lost:
        if (r13.equals("4") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0244, code lost:
        if (r13.equals("3") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x024c, code lost:
        if (r12.ifIsNewMarketTag() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x024e, code lost:
        r13 = r12.gotTopTag(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0252, code lost:
        if (r13 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0258, code lost:
        if (r13.isWednesdayDiscount() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x025a, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
        r11.o.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x026e, code lost:
        if (android.text.TextUtils.isEmpty(r13.shortTag) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0270, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(r13.shortTag);
        r11.o.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0284, code lost:
        r13 = r11.o;
        r0 = r12.recommendHintLabel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0288, code lost:
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x028e, code lost:
        if (r0.length() != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0291, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0292, code lost:
        if (r4 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0294, code lost:
        r0 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0297, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0298, code lost:
        r13.setVisibility(r0);
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_PREFERENTIAL).setTagName(r12.recommendHintLabel);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02ad, code lost:
        if (r13.equals("2") != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02b4, code lost:
        if (r12.ifIsNewMarketTag() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02b6, code lost:
        r13 = r12.gotTopTag(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02ba, code lost:
        if (r13 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02c0, code lost:
        if (r13.isWednesdayDiscount() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02c2, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION_WEDNESDAY_DISCOUNT);
        r11.o.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02d5, code lost:
        if (android.text.TextUtils.isEmpty(r13.shortTag) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02d7, code lost:
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_NEWPROMOTION).setTagName(r13.shortTag);
        r11.o.setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ea, code lost:
        r13 = r11.o;
        r0 = r12.recommendHintLabel;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ee, code lost:
        if (r0 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f4, code lost:
        if (r0.length() != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02f7, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02f8, code lost:
        if (r4 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02fa, code lost:
        r0 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x02fd, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02fe, code lost:
        r13.setVisibility(r0);
        r11.o.setTagType(cn.damai.uikit.tag.DMTagType.TAG_TYPE_MEMBER).setTagName(r12.recommendHintLabel);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x030f, code lost:
        r11.o.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0314, code lost:
        r11.l.setVisibility(0);
        r11.n.setVisibility(0);
        r11.p.setVisibility(8);
        r11.m.setText(r12.recommendHintTitle);
        r11.n.setText(r12.recommendHintDesc);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0354, code lost:
        if (r13.equals("0") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01fb, code lost:
        if (r13.equals("7") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0205, code lost:
        if (r13.equals("6") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x020f, code lost:
        if (r13.equals("5") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0217, code lost:
        if (r13.equals("4") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x021f, code lost:
        if (r13.equals("3") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0227, code lost:
        if (r13.equals("2") == false) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(@org.jetbrains.annotations.Nullable cn.damai.commonbusiness.search.bean.ProjectItemBean r12, int r13) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.wannasee.viewholder.WantSeeProjectViewHolder.e(cn.damai.commonbusiness.search.bean.ProjectItemBean, int):void");
    }

    public final void j(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751361446")) {
            ipChange.ipc$dispatch("751361446", new Object[]{this, function4});
        } else {
            this.v = function4;
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700067358")) {
            ipChange.ipc$dispatch("1700067358", new Object[]{this});
            return;
        }
        this.q.setText("00");
        this.r.setText("00:00:00");
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1353860240")) {
            ipChange.ipc$dispatch("-1353860240", new Object[]{this, Long.valueOf(j)});
            return;
        }
        TimerView.C3490a dateResult = TimerView.getDateResult(j);
        b41.h(dateResult, "getDateResult(millisUntilFinished)");
        this.q.setText(dateResult.a);
        this.r.setText(dateResult.b + jn1.CONDITION_IF_MIDDLE + dateResult.c + jn1.CONDITION_IF_MIDDLE + dateResult.d);
    }
}
