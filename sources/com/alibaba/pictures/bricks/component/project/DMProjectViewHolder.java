package com.alibaba.pictures.bricks.component.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
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
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.DMProjectItemBean;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.moimage.MoImageExtensionsKt;
import com.alibaba.pictures.moimage.MoImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.eh0;
import tb.n91;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class DMProjectViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private View a;
    @Nullable
    private DMPosterView b;
    @Nullable
    private TextView c;
    @Nullable
    private TextView d;
    @Nullable
    private TextView e;
    @Nullable
    private FlowLayout f;
    @Nullable
    private TextView g;
    @Nullable
    private TextView h;
    @Nullable
    private TextView i;
    @Nullable
    private TextView j;
    @Nullable
    private TextView k;
    @Nullable
    private TextView l;
    @Nullable
    private TimerView m;
    private int n;
    @NotNull
    private Context o;
    @Nullable
    private View p;
    @Nullable
    private TextView q;
    @Nullable
    private TextView r;
    @Nullable
    private TextView s;
    @Nullable
    private LinearLayout t;
    @Nullable
    private LinearLayout u;
    @Nullable
    private TextView v;
    @Nullable
    private TextView w;
    @Nullable
    private View x;
    @Nullable
    private MoImageView y;
    @Nullable
    private ViewGroup z;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum PageType {
        INIT_PAGE,
        SEARCH_PAGE,
        CATEGORY_PAGE,
        MINE_COLLECT
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMLabelType.values().length];
            iArr[DMLabelType.LABEL_TYPE_HIGHEST_HOT.ordinal()] = 1;
            iArr[DMLabelType.LABEL_TYPE_NEW_SALE.ordinal()] = 2;
            iArr[DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE.ordinal()] = 3;
            iArr[DMLabelType.LABEL_TYPE_DOUBLE_11.ordinal()] = 4;
            iArr[DMLabelType.LABEL_TYPE_ZAO_NIAO.ordinal()] = 5;
            iArr[DMLabelType.LABEL_TYPE_BUYING.ordinal()] = 6;
            iArr[DMLabelType.LABEL_TYPE_UPCOMING_BUY.ordinal()] = 7;
            iArr[DMLabelType.LABEL_TYPE_TOUR.ordinal()] = 8;
            iArr[DMLabelType.LABEL_TYPE_SOLD_OUT.ordinal()] = 9;
            iArr[DMLabelType.LABEL_TYPE_ALL_SELL_OUT.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "878652831")) {
                ipChange.ipc$dispatch("878652831", new Object[]{this, view});
            } else {
                b41.i(view, "v");
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1599682980")) {
                ipChange.ipc$dispatch("-1599682980", new Object[]{this, view});
                return;
            }
            b41.i(view, "v");
            TimerView timerView = DMProjectViewHolder.this.m;
            Object tag = timerView != null ? timerView.getTag() : null;
            WeakRefCountDownTimer weakRefCountDownTimer = tag instanceof WeakRefCountDownTimer ? (WeakRefCountDownTimer) tag : null;
            if (weakRefCountDownTimer != null) {
                DMProjectViewHolder dMProjectViewHolder = DMProjectViewHolder.this;
                weakRefCountDownTimer.cancel();
                TimerView timerView2 = dMProjectViewHolder.m;
                if (timerView2 == null) {
                    return;
                }
                timerView2.setTag(null);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FlowLayout a;
        final /* synthetic */ DMProjectViewHolder b;

        c(FlowLayout flowLayout, DMProjectViewHolder dMProjectViewHolder) {
            this.a = flowLayout;
            this.b = dMProjectViewHolder;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onGlobalLayout() {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.c.$ipChange
                java.lang.String r1 = "-573291195"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L14
                java.lang.Object[] r2 = new java.lang.Object[r3]
                r2[r4] = r5
                r0.ipc$dispatch(r1, r2)
                return
            L14:
                com.alibaba.pictures.bricks.view.FlowLayout r0 = r5.a
                android.view.View r0 = r0.getChildAt(r4)
                if (r0 == 0) goto L52
                int r0 = r0.getHeight()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                com.alibaba.pictures.bricks.view.FlowLayout r1 = r5.a
                int r2 = r0.intValue()
                int r1 = r1.getHeight()
                if (r1 <= r2) goto L31
                goto L32
            L31:
                r3 = 0
            L32:
                if (r3 == 0) goto L35
                goto L36
            L35:
                r0 = 0
            L36:
                if (r0 == 0) goto L52
                com.alibaba.pictures.bricks.view.FlowLayout r1 = r5.a
                com.alibaba.pictures.bricks.component.project.DMProjectViewHolder r2 = r5.b
                int r0 = r0.intValue()
                int r1 = r1.getHeight()
                int r1 = r1 - r0
                tb.s60 r0 = tb.s60.INSTANCE
                android.content.Context r2 = com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.a(r2)
                r3 = 3
                int r0 = r0.b(r2, r3)
                int r1 = r1 + r0
                goto L53
            L52:
                r1 = 0
            L53:
                com.alibaba.pictures.bricks.component.project.DMProjectViewHolder r0 = r5.b
                android.view.ViewGroup r0 = com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.c(r0)
                if (r0 == 0) goto L5e
                r0.setPadding(r4, r4, r4, r1)
            L5e:
                com.alibaba.pictures.bricks.view.FlowLayout r0 = r5.a
                android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
                r0.removeOnGlobalLayoutListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.c.onGlobalLayout():void");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DMProjectViewHolder(@NotNull Context context, @NotNull View view) {
        super(view);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(view, "view");
        this.o = context;
        View view2 = this.itemView;
        b41.h(view2, "itemView");
        j(view2);
    }

    private final void d(DMProjectItemBean dMProjectItemBean) {
        DMProjectItemBean.ProjectTagModel projectTagModel;
        List<CommonTagBean> list;
        DMProjectItemBean.ProjectTagModel projectTagModel2;
        List<MarketTagBean> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1998908553")) {
            ipChange.ipc$dispatch("1998908553", new Object[]{this, dMProjectItemBean});
            return;
        }
        if (dMProjectItemBean != null && (projectTagModel2 = dMProjectItemBean.tagModel) != null && (list2 = projectTagModel2.marketPromotionTags) != null) {
            for (MarketTagBean marketTagBean : list2) {
                marketTagBean.addMarketTagView(this.f, false);
            }
        }
        if (dMProjectItemBean == null || (projectTagModel = dMProjectItemBean.tagModel) == null || (list = projectTagModel.commonTags) == null) {
            return;
        }
        for (CommonTagBean commonTagBean : list) {
            e(DMTagType.TAG_TYPE_SERVICES, commonTagBean.name);
        }
    }

    private final void e(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1971696959")) {
            ipChange.ipc$dispatch("1971696959", new Object[]{this, dMTagType, str});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        DMCommonTagView dMCommonTagView = new DMCommonTagView(this.o);
        dMCommonTagView.adjustTagHeight(false);
        dMCommonTagView.setTagType(dMTagType).setTagName(str);
        FlowLayout flowLayout = this.f;
        if (flowLayout != null) {
            flowLayout.addView(dMCommonTagView);
        }
    }

    private final void f(DMProjectItemBean dMProjectItemBean) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2115882124")) {
            ipChange.ipc$dispatch("-2115882124", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean == null) {
        } else {
            MoImageView moImageView = this.y;
            if (moImageView != null) {
                if (moImageView != null) {
                    moImageView.setVisibility(8);
                }
                DMPosterView dMPosterView = this.b;
                if (dMPosterView != null) {
                    dMPosterView.removeView(this.y);
                }
            }
            DMPosterView dMPosterView2 = this.b;
            if (dMPosterView2 != null) {
                dMPosterView2.setLabelType(null);
            }
            DMProjectItemBean.PosterTag posterTag = dMProjectItemBean.bottomLeft;
            DMLabelType convertType2Label = DMLabelType.convertType2Label(posterTag != null ? posterTag.type : null);
            switch (convertType2Label == null ? -1 : a.$EnumSwitchMapping$0[convertType2Label.ordinal()]) {
                case 1:
                    DMPosterView dMPosterView3 = this.b;
                    if (dMPosterView3 != null) {
                        dMPosterView3.setLabelType(DMLabelType.LABEL_TYPE_HIGHEST_HOT);
                        return;
                    }
                    return;
                case 2:
                    DMPosterView dMPosterView4 = this.b;
                    if (dMPosterView4 != null) {
                        dMPosterView4.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                        return;
                    }
                    return;
                case 3:
                    DMPosterView dMPosterView5 = this.b;
                    if (dMPosterView5 != null) {
                        dMPosterView5.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                        return;
                    }
                    return;
                case 4:
                    DMProjectItemBean.PosterTag posterTag2 = dMProjectItemBean.bottomLeft;
                    String str = posterTag2 != null ? posterTag2.tag : null;
                    if (str != null && str.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 80;
                    s60 s60Var = s60.INSTANCE;
                    layoutParams.rightMargin = s60Var.b(this.o, 14);
                    MoImageView moImageView2 = new MoImageView(this.o, null, 0, 6, null);
                    moImageView2.setVisibility(0);
                    this.y = moImageView2;
                    DMPosterView dMPosterView6 = this.b;
                    if (dMPosterView6 != null) {
                        dMPosterView6.addView(moImageView2, layoutParams);
                    }
                    MoImageView moImageView3 = this.y;
                    if (moImageView3 != null) {
                        Integer valueOf = Integer.valueOf(s60Var.b(this.o, 16));
                        DMProjectItemBean.PosterTag posterTag3 = dMProjectItemBean.bottomLeft;
                        MoImageExtensionsKt.a(moImageView3, valueOf, posterTag3 != null ? posterTag3.tag : null);
                        return;
                    }
                    return;
                case 5:
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 80;
                    layoutParams2.rightMargin = s60.INSTANCE.b(this.o, 14);
                    MoImageView moImageView4 = new MoImageView(this.o, null, 0, 6, null);
                    moImageView4.setVisibility(0);
                    moImageView4.setImageResource(R$drawable.bricks_icon_market_earlybird);
                    this.y = moImageView4;
                    DMPosterView dMPosterView7 = this.b;
                    if (dMPosterView7 != null) {
                        dMPosterView7.addView(moImageView4, layoutParams2);
                        return;
                    }
                    return;
                case 6:
                    DMPosterView dMPosterView8 = this.b;
                    if (dMPosterView8 != null) {
                        dMPosterView8.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                        return;
                    }
                    return;
                case 7:
                    DMPosterView dMPosterView9 = this.b;
                    if (dMPosterView9 != null) {
                        dMPosterView9.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                        return;
                    }
                    return;
                case 8:
                    DMPosterView dMPosterView10 = this.b;
                    if (dMPosterView10 != null) {
                        dMPosterView10.setLabelType(DMLabelType.LABEL_TYPE_TOUR);
                        return;
                    }
                    return;
                case 9:
                    DMPosterView dMPosterView11 = this.b;
                    if (dMPosterView11 != null) {
                        dMPosterView11.setLabelType(DMLabelType.LABEL_TYPE_SOLD_OUT);
                        return;
                    }
                    return;
                case 10:
                    DMPosterView dMPosterView12 = this.b;
                    if (dMPosterView12 != null) {
                        dMPosterView12.setLabelType(DMLabelType.LABEL_TYPE_ALL_SELL_OUT);
                        return;
                    }
                    return;
                default:
                    DMPosterView dMPosterView13 = this.b;
                    if (dMPosterView13 != null) {
                        dMPosterView13.setLabelType(null);
                        return;
                    }
                    return;
            }
        }
    }

    private final void g(DMProjectItemBean dMProjectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939968484")) {
            ipChange.ipc$dispatch("-939968484", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean == null) {
        } else {
            TimerView timerView = this.m;
            if (timerView != null) {
                timerView.setVisibility(8);
            }
            TimerView timerView2 = this.m;
            Object tag = timerView2 != null ? timerView2.getTag() : null;
            if (tag instanceof WeakRefCountDownTimer) {
                ((WeakRefCountDownTimer) tag).cancel();
                TimerView timerView3 = this.m;
                if (timerView3 != null) {
                    timerView3.setTag(null);
                }
            }
            Long calSnapUpCountDownTime = dMProjectItemBean.calSnapUpCountDownTime(Long.valueOf(TimeSyncer.INSTANCE.g()));
            b41.h(calSnapUpCountDownTime, "countDownMsSurplus");
            if (calSnapUpCountDownTime.longValue() > 0) {
                TimerView timerView4 = this.m;
                if (timerView4 != null) {
                    DMProjectItemBean.SnapUpInfo snapUpInfo = dMProjectItemBean.snapUpInfo;
                    String str = snapUpInfo != null ? snapUpInfo.onSaleTime : null;
                    if (str == null) {
                        str = "";
                    }
                    timerView4.setPerformTime(str, "");
                }
                WeakRefCountDownTimer weakRefCountDownTimer = new WeakRefCountDownTimer(calSnapUpCountDownTime.longValue(), 1000L, this.m);
                weakRefCountDownTimer.start();
                TimerView timerView5 = this.m;
                if (timerView5 != null) {
                    timerView5.setVisibleGoneAfterTimeout();
                }
                TimerView timerView6 = this.m;
                if (timerView6 != null) {
                    timerView6.markBricksStyle();
                }
                TimerView timerView7 = this.m;
                if (timerView7 != null) {
                    timerView7.setTag(weakRefCountDownTimer);
                }
                TimerView timerView8 = this.m;
                if (timerView8 == null) {
                    return;
                }
                timerView8.setVisibility(0);
                return;
            }
            TimerView timerView9 = this.m;
            if (timerView9 != null) {
                timerView9.setTimeUp();
            }
            TimerView timerView10 = this.m;
            if (timerView10 == null) {
                return;
            }
            timerView10.setVisibility(8);
        }
    }

    public static /* synthetic */ void i(DMProjectViewHolder dMProjectViewHolder, DMProjectItemBean dMProjectItemBean, PageType pageType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            pageType = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        dMProjectViewHolder.h(dMProjectItemBean, pageType, z);
    }

    @SuppressLint({"NewApi"})
    private final void j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569395147")) {
            ipChange.ipc$dispatch("-569395147", new Object[]{this, view});
            return;
        }
        View findViewById = view.findViewById(R$id.space);
        this.a = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
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
        TimerView timerView = (TimerView) view.findViewById(R$id.dm_project_timer_view);
        this.m = timerView;
        if (timerView != null) {
            timerView.addOnAttachStateChangeListener(new b());
        }
        this.z = (ViewGroup) view.findViewById(R$id.ll_price);
    }

    private final void k(DMProjectItemBean dMProjectItemBean, PageType pageType, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1367183404")) {
            ipChange.ipc$dispatch("1367183404", new Object[]{this, dMProjectItemBean, pageType, Boolean.valueOf(z)});
        } else if (dMProjectItemBean == null) {
        } else {
            this.itemView.setTag(dMProjectItemBean);
            DMPosterView dMPosterView = this.b;
            if (dMPosterView != null) {
                dMPosterView.setImageUrl(dMProjectItemBean.verticalPic);
            }
            DMPosterView dMPosterView2 = this.b;
            if (dMPosterView2 != null) {
                dMPosterView2.setVideoIconVisibility(dMProjectItemBean.needShowPosterVideoTag() ? 0 : 8);
            }
            DMProjectItemBean.PosterTag posterTag = dMProjectItemBean.topRight;
            if (posterTag != null) {
                DMPosterView dMPosterView3 = this.b;
                if (dMPosterView3 != null) {
                    dMPosterView3.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                }
                if (TextUtils.equals("201", posterTag.type)) {
                    DMPosterView dMPosterView4 = this.b;
                    if (dMPosterView4 != null) {
                        dMPosterView4.setCategoryTagName(posterTag.tag);
                    }
                } else if (TextUtils.equals("202", posterTag.type)) {
                    DMPosterView dMPosterView5 = this.b;
                    if (dMPosterView5 != null) {
                        dMPosterView5.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                    }
                    DMPosterView dMPosterView6 = this.b;
                    if (dMPosterView6 != null) {
                        dMPosterView6.setCategoryTagName("");
                    }
                } else if (TextUtils.equals("203", posterTag.type)) {
                    DMPosterView dMPosterView7 = this.b;
                    if (dMPosterView7 != null) {
                        dMPosterView7.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
                    }
                    DMPosterView dMPosterView8 = this.b;
                    if (dMPosterView8 != null) {
                        dMPosterView8.setCategoryTagName("");
                    }
                } else {
                    DMPosterView dMPosterView9 = this.b;
                    if (dMPosterView9 != null) {
                        dMPosterView9.setCategoryTagName("");
                    }
                }
            } else {
                DMPosterView dMPosterView10 = this.b;
                if (dMPosterView10 != null) {
                    dMPosterView10.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                }
                DMPosterView dMPosterView11 = this.b;
                if (dMPosterView11 != null) {
                    dMPosterView11.setCategoryTagName("");
                }
            }
            p(pageType, dMProjectItemBean.cityName, dMProjectItemBean.name, dMProjectItemBean.highlightWord);
            m(Double.valueOf(dMProjectItemBean.itemScore), dMProjectItemBean, pageType);
            r(dMProjectItemBean.showTime);
            n(Boolean.valueOf(dMProjectItemBean.judgeIsLiveProject()), dMProjectItemBean.cityName, dMProjectItemBean.venueName);
            if (z) {
                TextView textView = this.l;
                if (textView != null) {
                    eh0.b(textView, dMProjectItemBean.formattedDistance, 0, 2, null);
                }
            } else {
                TextView textView2 = this.l;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            l(dMProjectItemBean);
            q(dMProjectItemBean, Boolean.TRUE);
            f(dMProjectItemBean);
            g(dMProjectItemBean);
            DMPosterView dMPosterView12 = this.b;
            if (dMPosterView12 != null) {
                dMPosterView12.setImageViewMaskVisibility(dMProjectItemBean.judgeIdXiaJiaProject() ? 0 : 8);
            }
            FlowLayout flowLayout = this.f;
            if (flowLayout != null) {
                FlowLayout flowLayout2 = (flowLayout.getVisibility() != 0 || flowLayout.getChildCount() <= 0) ? false : false ? flowLayout : null;
                if (flowLayout2 != null) {
                    ViewGroup viewGroup = this.z;
                    if (viewGroup != null) {
                        viewGroup.setPadding(0, 0, 0, 0);
                    }
                    flowLayout2.getViewTreeObserver().addOnGlobalLayoutListener(new c(flowLayout2, this));
                }
            }
        }
    }

    private final void l(DMProjectItemBean dMProjectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547225105")) {
            ipChange.ipc$dispatch("-547225105", new Object[]{this, dMProjectItemBean});
        } else if (dMProjectItemBean == null) {
        } else {
            FlowLayout flowLayout = this.f;
            if (flowLayout != null) {
                flowLayout.removeAllViews();
            }
            d(dMProjectItemBean);
            FlowLayout flowLayout2 = this.f;
            if (flowLayout2 != null) {
                if (flowLayout2.getChildCount() > 0) {
                    flowLayout2.setVisibility(0);
                } else {
                    flowLayout2.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m(java.lang.Double r6, com.alibaba.pictures.bricks.component.project.bean.DMProjectItemBean r7, com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.PageType r8) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.project.DMProjectViewHolder.m(java.lang.Double, com.alibaba.pictures.bricks.component.project.bean.DMProjectItemBean, com.alibaba.pictures.bricks.component.project.DMProjectViewHolder$PageType):void");
    }

    private final void n(Boolean bool, String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1137633206")) {
            ipChange.ipc$dispatch("1137633206", new Object[]{this, bool, str, str2});
            return;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "场馆待定";
        }
        if (b41.d(bool, Boolean.TRUE)) {
            TextView textView = this.d;
            if (textView == null) {
                return;
            }
            textView.setText(str2);
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            str = "城市待定";
        }
        TextView textView2 = this.d;
        if (textView2 == null) {
            return;
        }
        textView2.setText(str + " | " + str2);
    }

    private final void p(PageType pageType, String str, String str2, List<String> list) {
        String str3;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1205575564")) {
            ipChange.ipc$dispatch("1205575564", new Object[]{this, pageType, str, str2, list});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            str3 = "";
        } else {
            str3 = (char) 12304 + str + (char) 12305;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        if (n91.a(list) > 0) {
            s(this.c, list, sb2);
            return;
        }
        TextView textView = this.c;
        if (textView == null) {
            return;
        }
        textView.setText(sb2);
    }

    private final void q(DMProjectItemBean dMProjectItemBean, Boolean bool) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1557670008")) {
            ipChange.ipc$dispatch("1557670008", new Object[]{this, dMProjectItemBean, bool});
        } else if (dMProjectItemBean == null) {
        } else {
            TextView textView = this.q;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view = this.p;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.i;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.g;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            String str = dMProjectItemBean.priceShowText;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                TextView textView6 = this.h;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.h;
                if (textView7 == null) {
                    return;
                }
                textView7.setText("");
            } else if (b41.d(str, "已下架")) {
                View view2 = this.p;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                TextView textView8 = this.q;
                if (textView8 == null) {
                    return;
                }
                textView8.setVisibility(0);
            } else if (!b41.d(str, "待定") && !b41.d(str, "价格待定")) {
                TextView textView9 = this.g;
                if (textView9 != null) {
                    textView9.setVisibility(0);
                }
                TextView textView10 = this.h;
                if (textView10 != null) {
                    textView10.setVisibility(0);
                }
                TextView textView11 = this.h;
                if (textView11 != null) {
                    textView11.setText(str);
                }
                TextView textView12 = this.i;
                if (textView12 == null) {
                    return;
                }
                textView12.setVisibility(b41.d(bool, Boolean.TRUE) ? 0 : 8);
            } else {
                TextView textView13 = this.j;
                if (textView13 == null) {
                    return;
                }
                textView13.setVisibility(0);
            }
        }
    }

    private final void r(String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-85616973")) {
            ipChange.ipc$dispatch("-85616973", new Object[]{this, str});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            TextView textView = this.e;
            if (textView == null) {
                return;
            }
            textView.setText(str);
            return;
        }
        TextView textView2 = this.e;
        if (textView2 == null) {
            return;
        }
        textView2.setText("时间待定");
    }

    private final void s(TextView textView, List<String> list, String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "972242574")) {
            ipChange.ipc$dispatch("972242574", new Object[]{this, textView, list, str});
        } else if (textView != null) {
            if (str == null || str.length() == 0) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (z) {
                textView.setText(str);
                return;
            }
            int size = list.size();
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
    }

    @JvmOverloads
    public final void h(@Nullable DMProjectItemBean dMProjectItemBean, @Nullable PageType pageType, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1573804777")) {
            ipChange.ipc$dispatch("1573804777", new Object[]{this, dMProjectItemBean, pageType, Boolean.valueOf(z)});
        } else {
            k(dMProjectItemBean, pageType, z);
        }
    }

    public final void o(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697786023")) {
            ipChange.ipc$dispatch("-1697786023", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        DMPosterView dMPosterView = this.b;
        if (dMPosterView != null) {
            dMPosterView.getLayoutParams().width = i;
            dMPosterView.getLayoutParams().height = i2;
        }
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setMinimumHeight(i2);
        }
    }
}
