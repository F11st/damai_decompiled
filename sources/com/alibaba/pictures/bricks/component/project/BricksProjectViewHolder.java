package com.alibaba.pictures.bricks.component.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.Daojishi;
import com.alibaba.pictures.bricks.component.project.bean.ProjectBuyStatus;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.n91;
import tb.pd2;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BricksProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private ViewGroup A;
    private long B;
    private long C;
    private Daojishi D;
    public View a;
    public DMPosterView b;
    public TextView c;
    public TextView d;
    public TextView e;
    private FlowLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TimerView m;
    private int n;
    private Context o;
    private View p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private LinearLayout u;
    private TextView v;
    private TextView w;
    private View x;
    private ImageView y;
    private View.OnClickListener z;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum PageType {
        INIT_PAGE,
        SEARCH_PAGE,
        CATEGORY_PAGE,
        MINE_COLLECT
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC3483a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC3483a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "382764519")) {
                ipChange.ipc$dispatch("382764519", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = null;
            try {
                projectItemBean = (ProjectItemBean) view.getTag();
            } catch (Exception unused) {
            }
            if (projectItemBean == null) {
                return;
            }
            if (BricksProjectViewHolder.this.z != null) {
                this.a.onClick(view);
            }
            pd2.a(BricksProjectViewHolder.this.o, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder$b */
    /* loaded from: classes7.dex */
    public class View$OnAttachStateChangeListenerC3484b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC3484b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "646699918")) {
                ipChange.ipc$dispatch("646699918", new Object[]{this, view});
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1168132981")) {
                ipChange.ipc$dispatch("-1168132981", new Object[]{this, view});
                return;
            }
            Object tag = BricksProjectViewHolder.this.m.getTag();
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                BricksProjectViewHolder.this.m.setTag(null);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder$c */
    /* loaded from: classes7.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC3485c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnGlobalLayoutListenerC3485c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1716369204")) {
                ipChange.ipc$dispatch("-1716369204", new Object[]{this});
                return;
            }
            if (BricksProjectViewHolder.this.f.getChildAt(0) != null) {
                int height = BricksProjectViewHolder.this.f.getChildAt(0).getHeight();
                if (BricksProjectViewHolder.this.f.getHeight() > height) {
                    BricksProjectViewHolder.this.A.setPadding(0, 0, 0, (BricksProjectViewHolder.this.f.getHeight() - height) + s60.INSTANCE.b(BricksProjectViewHolder.this.o, 3));
                } else {
                    BricksProjectViewHolder.this.A.setPadding(0, 0, 0, 0);
                }
            } else {
                BricksProjectViewHolder.this.A.setPadding(0, 0, 0, 0);
            }
            BricksProjectViewHolder.this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public BricksProjectViewHolder(Context context, LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.bricks_search_list_project, (ViewGroup) null));
        this.n = 0;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.o = context;
        o(this.itemView);
    }

    private void A(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-247551844")) {
            ipChange.ipc$dispatch("-247551844", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.e.setText(str);
        } else {
            this.e.setText("时间待定");
        }
    }

    private void B(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88301751")) {
            ipChange.ipc$dispatch("88301751", new Object[]{this, textView, list, str});
            return;
        }
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            textView.setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i = 0; i < size; i++) {
            try {
                Matcher matcher = Pattern.compile(list.get(i)).matcher(str);
                while (matcher.find()) {
                    int start = matcher.start();
                    this.n = start;
                    if (start == -1) {
                        break;
                    } else if (start >= 0) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(this.o, R$color.color_FF2D79));
                        int i2 = this.n;
                        spannableStringBuilder.setSpan(foregroundColorSpan, i2, list.get(i).length() + i2, 18);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        textView.setGravity(16);
        textView.setText(spannableStringBuilder);
    }

    private void f(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1204785417")) {
            ipChange.ipc$dispatch("-1204785417", new Object[]{this, projectItemBean});
            return;
        }
        for (MarketTagBean marketTagBean : projectItemBean.marketPromotionTags) {
            marketTagBean.addMarketTagView(this.f, false);
        }
    }

    private void g(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283191280")) {
            ipChange.ipc$dispatch("-283191280", new Object[]{this, projectItemBean});
            return;
        }
        if (!TextUtils.isEmpty(projectItemBean.discountRate)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, projectItemBean.discountRate + "折起");
        }
        List<String> list = projectItemBean.promotionTags;
        if (list != null && list.size() > 0) {
            for (String str : projectItemBean.promotionTags) {
                h(DMTagType.TAG_TYPE_PREFERENTIAL, str);
            }
        }
        if (!TextUtils.isEmpty(projectItemBean.getVipMark())) {
            h(DMTagType.TAG_TYPE_MEMBER, projectItemBean.getVipMark());
        }
        String couponTag = projectItemBean.getCouponTag();
        if (!TextUtils.isEmpty(couponTag)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, couponTag);
        }
        String activityTag = projectItemBean.getActivityTag();
        if (!TextUtils.isEmpty(activityTag)) {
            h(DMTagType.TAG_TYPE_PREFERENTIAL, activityTag);
        }
        String privilegeTag = projectItemBean.getPrivilegeTag();
        if (TextUtils.isEmpty(privilegeTag)) {
            return;
        }
        h(DMTagType.TAG_TYPE_PREFERENTIAL, privilegeTag);
    }

    private void h(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "742147190")) {
            ipChange.ipc$dispatch("742147190", new Object[]{this, dMTagType, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(this.o);
            dMCommonTagView.adjustTagHeight(false);
            dMCommonTagView.setTagType(dMTagType).setTagName(str);
            this.f.addView(dMCommonTagView);
        }
    }

    @SuppressLint({"NewApi"})
    private void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569983522")) {
            ipChange.ipc$dispatch("-1569983522", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.space);
        this.a = findViewById;
        findViewById.setVisibility(0);
        this.b = (DMPosterView) view.findViewById(R$id.poster);
        this.c = (TextView) view.findViewById(R$id.tv_project_name);
        this.d = (TextView) view.findViewById(R$id.tv_project_city);
        this.e = (TextView) view.findViewById(R$id.tv_project_time);
        this.u = (LinearLayout) view.findViewById(R$id.ll_project_right);
        this.t = (LinearLayout) view.findViewById(R$id.ll_score_follow);
        this.k = (TextView) view.findViewById(R$id.tv_project_follow_desc);
        this.r = (TextView) view.findViewById(R$id.layout_score);
        this.s = (TextView) view.findViewById(R$id.layout_score_preifx);
        this.v = (TextView) view.findViewById(R$id.tv_project_rank);
        this.w = (TextView) view.findViewById(R$id.tv_project_rank_mark);
        this.f = (FlowLayout) view.findViewById(R$id.fl_sales2);
        this.p = view.findViewById(R$id.ll_child_price);
        this.g = (TextView) view.findViewById(R$id.tv_fuhao);
        this.h = (TextView) view.findViewById(R$id.tv_project_price);
        this.i = (TextView) view.findViewById(R$id.tv_project_price_label);
        this.j = (TextView) view.findViewById(R$id.tv_project_price_confirm);
        this.q = (TextView) view.findViewById(R$id.tv_yixiajia);
        this.l = (TextView) view.findViewById(R$id.tv_project_dis);
        this.x = view.findViewById(R$id.ll_search_bottom_div);
        TimerView timerView = (TimerView) view.findViewById(R$id.ll_timer);
        this.m = timerView;
        timerView.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC3484b());
        this.A = (ViewGroup) view.findViewById(R$id.ll_price);
    }

    private void p(ProjectItemBean projectItemBean, PageType pageType, boolean z) {
        View findViewById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352782311")) {
            ipChange.ipc$dispatch("352782311", new Object[]{this, projectItemBean, pageType, Boolean.valueOf(z)});
        } else if (projectItemBean == null) {
        } else {
            if (this.itemView.getId() == R$id.inner_project_wrapper && (findViewById = this.itemView.findViewById(R$id.inner_project_layout)) != null) {
                if (projectItemBean.isReferItem) {
                    findViewById.setBackgroundResource(R$drawable.bricks_item_top_card_bg_r6);
                } else {
                    findViewById.setBackgroundResource(R$drawable.bricks_list_bg_radius);
                }
            }
            this.itemView.setTag(projectItemBean);
            this.b.setImageUrl(projectItemBean.verticalPic);
            this.b.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.b.setCategoryTagName(projectItemBean.getCategoryNameCompat());
            if (TextUtils.isEmpty(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if ("1".equals(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if ("2".equals(projectItemBean.liveStatus)) {
                this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            } else {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            }
            y(pageType, projectItemBean.cityName, projectItemBean.name, projectItemBean.highlightWord);
            r(projectItemBean.itemScore, projectItemBean, pageType);
            if (!TextUtils.isEmpty(projectItemBean.liveStartTime)) {
                A(projectItemBean.liveStartTime);
            } else {
                A(projectItemBean.showTime);
            }
            t(projectItemBean.isLiveProject(), projectItemBean.cityName, projectItemBean.venueName);
            if (z && !TextUtils.isEmpty(projectItemBean.formattedDistance)) {
                this.l.setVisibility(0);
                this.l.setText(projectItemBean.formattedDistance);
            } else {
                this.l.setVisibility(8);
            }
            q(projectItemBean);
            if (pageType != null && pageType == PageType.MINE_COLLECT) {
                z(projectItemBean.formattedPriceStr, projectItemBean.promotionPrice, projectItemBean.displayStatus, projectItemBean.showStatus, false);
            } else {
                z(projectItemBean.priceLow, projectItemBean.promotionPrice, projectItemBean.displayStatus, projectItemBean.showStatus, true);
            }
            ProjectBuyStatus projectBuyStatus = projectItemBean.showStatus;
            if (projectBuyStatus != null && !TextUtils.isEmpty(projectBuyStatus.id) && "2".equals(projectItemBean.showStatus.id)) {
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                this.b.setImageViewMaskVisibility(0);
                this.b.setLabelType(null);
            } else {
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.b.setImageViewMaskVisibility(8);
                ImageView imageView = this.y;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.b.removeView(this.y);
                }
                if (projectItemBean.isHotProject()) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                } else if (!TextUtils.isEmpty(projectItemBean.brandOptimizationTag) && !projectItemBean.brandOptimizationTag.equals("NEW_SHELF")) {
                    if (projectItemBean.brandOptimizationTag.equals("HIGHEST_HEAT")) {
                        this.b.setLabelType(DMLabelType.LABEL_TYPE_HIGHEST_HOT);
                    } else if (projectItemBean.brandOptimizationTag.equals("ON_SOON")) {
                        this.b.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                    } else if (projectItemBean.isSoldOut()) {
                        this.b.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                    } else {
                        this.b.setLabelType(null);
                    }
                } else if (!TextUtils.isEmpty(projectItemBean.brandOptimizationTag) && projectItemBean.brandOptimizationTag.equals("NEW_SHELF") && (projectItemBean.gotPostTag() == null || this.b.getLabelView() == null)) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                } else if (projectItemBean.isSoldOut()) {
                    this.b.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                } else if (!TextUtils.isEmpty(projectItemBean.atmosphericPic)) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    layoutParams.rightMargin = s60.INSTANCE.b(this.o, 14);
                    ImageView imageView2 = new ImageView(this.o);
                    this.y = imageView2;
                    imageView2.setVisibility(0);
                    this.b.addView(this.y, layoutParams);
                    ImageLoaderProviderProxy.getProxy().loadinto(projectItemBean.atmosphericPic, this.y);
                } else if (projectItemBean.gotPostTag() != null && this.b.getLabelView() != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 80;
                    layoutParams2.rightMargin = s60.INSTANCE.b(this.o, 14);
                    ImageView imageView3 = new ImageView(this.o);
                    this.y = imageView3;
                    imageView3.setVisibility(0);
                    this.y.setImageResource(R$drawable.bricks_icon_market_earlybird);
                    this.b.addView(this.y, layoutParams2);
                    this.b.setLabelType(null);
                } else {
                    this.b.setLabelType(null);
                }
            }
            this.m.setVisibility(8);
            Object tag = this.m.getTag();
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                this.m.setTag(null);
            }
            if (projectItemBean.isSnapUp()) {
                long j = this.B;
                if (j > 0) {
                    long j2 = projectItemBean.upTime;
                    if (j2 > j) {
                        long elapsedRealtime = (j2 - this.C) - SystemClock.elapsedRealtime();
                        Log.e("countDownMs", "使用 countDownMsSurplus=" + elapsedRealtime + " bean.upTime=" + projectItemBean.upTime + " timeDiff=" + this.C + " SystemClock.elapsedRealtime()=" + SystemClock.elapsedRealtime());
                        this.m.setPerformTime(projectItemBean.onSaleTime);
                        if (this.D != null && elapsedRealtime > 0) {
                            WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(elapsedRealtime, 1000L, this.m);
                            weakRefCountDownTimer.start();
                            this.m.setTag(weakRefCountDownTimer);
                        } else {
                            this.m.setTimeUp();
                        }
                        this.m.setVisibility(0);
                    }
                }
            }
            if (this.f.getVisibility() != 0 || this.f.getChildCount() <= 0) {
                return;
            }
            this.f.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC3485c());
        }
    }

    private void q(ProjectItemBean projectItemBean) {
        CommonTagBean commonTagBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725754339")) {
            ipChange.ipc$dispatch("-1725754339", new Object[]{this, projectItemBean});
        } else if (projectItemBean == null) {
        } else {
            this.f.removeAllViews();
            if (projectItemBean.ifIsNewMarketTag()) {
                f(projectItemBean);
            } else {
                g(projectItemBean);
            }
            List<CommonTagBean> list = projectItemBean.commonTags;
            if (list != null && list.size() > 0 && (commonTagBean = projectItemBean.commonTags.get(0)) != null && commonTagBean.id == 1 && !TextUtils.isEmpty(commonTagBean.name)) {
                h(DMTagType.TAG_TYPE_SERVICES, commonTagBean.name);
            }
            if (projectItemBean.isSelectSeat()) {
                h(DMTagType.TAG_TYPE_SERVICES, "可选座");
            }
            if (this.f.getChildCount() > 0) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            if (TextUtils.isEmpty(projectItemBean.displayStatus)) {
                return;
            }
            this.f.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(double r7, com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean r9, com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder.PageType r10) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder.$ipChange
            java.lang.String r1 = "-2107916928"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L21
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r6
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r2[r3] = r7
            r7 = 2
            r2[r7] = r9
            r7 = 3
            r2[r7] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L21:
            r0 = 8
            if (r10 == 0) goto L2f
            com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder$PageType r1 = com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder.PageType.MINE_COLLECT
            if (r10 != r1) goto L2f
            android.widget.TextView r10 = r6.k
            r10.setVisibility(r0)
            goto L4d
        L2f:
            boolean r10 = r9.isFollowStatus()
            if (r10 == 0) goto L48
            com.alibaba.pictures.dolores.login.DoloresLoginHandler$a r10 = com.alibaba.pictures.dolores.login.DoloresLoginHandler.Companion
            com.alibaba.pictures.dolores.login.DoloresLoginHandler r10 = r10.a()
            boolean r10 = r10.c()
            if (r10 == 0) goto L48
            android.widget.TextView r10 = r6.k
            r10.setVisibility(r4)
            r10 = 1
            goto L4e
        L48:
            android.widget.TextView r10 = r6.k
            r10.setVisibility(r0)
        L4d:
            r10 = 0
        L4e:
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 == 0) goto L69
            android.widget.TextView r1 = r6.r
            r1.setVisibility(r4)
            android.widget.TextView r1 = r6.s
            r1.setVisibility(r4)
            android.widget.TextView r1 = r6.r
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1.setText(r7)
            r7 = 1
            goto L74
        L69:
            android.widget.TextView r7 = r6.r
            r7.setVisibility(r0)
            android.widget.TextView r7 = r6.s
            r7.setVisibility(r0)
            r7 = 0
        L74:
            java.lang.String r8 = r9.showTag
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L7f
            java.lang.String r8 = r9.showTag
            goto L93
        L7f:
            com.alibaba.pictures.bricks.component.project.bean.RankingListBean r8 = r9.rankingList
            if (r8 == 0) goto L86
            java.lang.String r8 = r8.title
            goto L93
        L86:
            java.lang.String r8 = r9.actores
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L91
            java.lang.String r8 = r9.actores
            goto L93
        L91:
            java.lang.String r8 = ""
        L93:
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto La4
            android.widget.TextView r9 = r6.v
            r9.setText(r8)
            android.widget.TextView r8 = r6.v
            r8.setVisibility(r4)
            goto Laa
        La4:
            android.widget.TextView r8 = r6.v
            r8.setVisibility(r0)
            r3 = 0
        Laa:
            if (r7 == 0) goto Lb4
            if (r3 == 0) goto Lb4
            android.widget.TextView r8 = r6.w
            r8.setVisibility(r4)
            goto Lb9
        Lb4:
            android.widget.TextView r8 = r6.w
            r8.setVisibility(r0)
        Lb9:
            if (r7 != 0) goto Lc6
            if (r3 != 0) goto Lc6
            if (r10 == 0) goto Lc0
            goto Lc6
        Lc0:
            android.widget.LinearLayout r7 = r6.t
            r7.setVisibility(r0)
            goto Lcb
        Lc6:
            android.widget.LinearLayout r7 = r6.t
            r7.setVisibility(r4)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder.r(double, com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean, com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder$PageType):void");
    }

    private void t(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445886580")) {
            ipChange.ipc$dispatch("1445886580", new Object[]{this, Boolean.valueOf(z), str, str2});
        } else if (z) {
            this.d.setText(str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "城市待定";
            }
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = this.d;
                textView.setText(str + " | " + str2);
                return;
            }
            TextView textView2 = this.d;
            textView2.setText(str + " | 场馆待定");
        }
    }

    private void y(PageType pageType, String str, String str2, List<String> list) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242972806")) {
            ipChange.ipc$dispatch("-242972806", new Object[]{this, pageType, str, str2, list});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = "【" + str + "】";
        }
        if (n91.a(list) > 0) {
            B(this.c, list, str3 + str2);
            return;
        }
        this.c.setText(str3 + str2);
    }

    private void z(String str, String str2, String str3, ProjectBuyStatus projectBuyStatus, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756372526")) {
            ipChange.ipc$dispatch("-756372526", new Object[]{this, str, str2, str3, projectBuyStatus, Boolean.valueOf(z)});
            return;
        }
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        this.h.setText("");
        this.g.setVisibility(8);
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (!TextUtils.isEmpty(str) && !str.equals("待定") && !str.equals("价格待定")) {
                this.g.setVisibility(0);
                this.h.setText(str);
                this.i.setVisibility(z ? 0 : 8);
                return;
            }
            this.g.setVisibility(8);
            this.j.setVisibility(0);
        }
    }

    public void C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-402771412")) {
            ipChange.ipc$dispatch("-402771412", new Object[]{this});
            return;
        }
        this.itemView.findViewById(R$id.inner_project_gap).setVisibility(0);
        View findViewById = this.itemView.findViewById(R$id.inner_project_wrapper);
        s60 s60Var = s60.INSTANCE;
        findViewById.setPadding(s60Var.b(this.o, 9), 0, s60Var.b(this.o, 9), 0);
    }

    public View i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-626627876") ? (View) ipChange.ipc$dispatch("-626627876", new Object[]{this}) : this.x;
    }

    public View j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1681750154") ? (View) ipChange.ipc$dispatch("-1681750154", new Object[]{this}) : this.a;
    }

    public void k(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984032670")) {
            ipChange.ipc$dispatch("-984032670", new Object[]{this, projectItemBean});
        } else {
            l(projectItemBean, null);
        }
    }

    public void l(ProjectItemBean projectItemBean, PageType pageType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461893200")) {
            ipChange.ipc$dispatch("-1461893200", new Object[]{this, projectItemBean, pageType});
        } else {
            m(projectItemBean, pageType, true);
        }
    }

    public void m(ProjectItemBean projectItemBean, PageType pageType, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925996836")) {
            ipChange.ipc$dispatch("1925996836", new Object[]{this, projectItemBean, pageType, Boolean.valueOf(z)});
        } else {
            p(projectItemBean, pageType, z);
        }
    }

    public void n(ProjectItemBean projectItemBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-440195918")) {
            ipChange.ipc$dispatch("-440195918", new Object[]{this, projectItemBean, Boolean.valueOf(z)});
        } else {
            m(projectItemBean, null, z);
        }
    }

    public void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1678368680")) {
            ipChange.ipc$dispatch("1678368680", new Object[]{this});
        } else {
            this.itemView.findViewById(R$id.inner_project_layout).setBackgroundResource(R$drawable.bricks_list_bg_radius);
        }
    }

    public void u(Daojishi daojishi) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408773103")) {
            ipChange.ipc$dispatch("408773103", new Object[]{this, daojishi});
            return;
        }
        this.D = daojishi;
        if (daojishi != null) {
            this.B = daojishi.serverTime;
            this.C = daojishi.diffTime;
        }
    }

    public void v(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461155464")) {
            ipChange.ipc$dispatch("-1461155464", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014462040")) {
            ipChange.ipc$dispatch("1014462040", new Object[]{this, onClickListener});
            return;
        }
        this.z = onClickListener;
        View view = this.itemView;
        if (view != null) {
            view.setOnClickListener(new View$OnClickListenerC3483a(onClickListener));
        }
    }

    public void x(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-607553584")) {
            ipChange.ipc$dispatch("-607553584", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        DMPosterView dMPosterView = this.b;
        if (dMPosterView != null) {
            dMPosterView.getLayoutParams().height = i2;
            this.b.getLayoutParams().width = i;
        }
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i2);
        }
    }

    public BricksProjectViewHolder(Context context, View view) {
        super(view);
        this.n = 0;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.o = context;
        o(this.itemView);
    }
}
