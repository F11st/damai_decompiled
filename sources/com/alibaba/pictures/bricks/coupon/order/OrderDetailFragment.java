package com.alibaba.pictures.bricks.coupon.order;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.util.ACache;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.base.BricksBaseFragment;
import com.alibaba.pictures.bricks.bean.CouponOrderInfoBean;
import com.alibaba.pictures.bricks.bean.CouponRuleBean;
import com.alibaba.pictures.bricks.coupon.fragment.NoticeFragment;
import com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment;
import com.alibaba.pictures.bricks.coupon.order.bean.ButtonStatus;
import com.alibaba.pictures.bricks.coupon.order.bean.Notice;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo;
import com.alibaba.pictures.bricks.coupon.order.request.CouponOrderDetailRequest;
import com.alibaba.pictures.bricks.listener.OnItemListener;
import com.alibaba.pictures.bricks.view.DigitTextView;
import com.alibaba.pictures.bricks.view.LinearPullToRefreshView;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.material.appbar.AppBarLayout;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.ia1;
import tb.k50;
import tb.ld;
import tb.pp2;
import tb.qo1;
import tb.rb0;
import tb.s60;
import tb.wt2;
import tb.yb1;
import tb.z13;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class OrderDetailFragment extends BricksBaseFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LOGIN_RESULT = 2001;
    @NotNull
    public static final String ORDER_ID = "orderId";
    @JvmField
    @Nullable
    public static String mPayResultOrderId;
    @JvmField
    public static boolean mPayResultState;
    @Nullable
    private OrderDetailAdapter adapter;
    @Nullable
    private LinearLayout bottonLayout;
    @Nullable
    private TextView cancelOrder;
    @Nullable
    private TextView commentDesTv;
    @Nullable
    private TextView commentTv;
    @Nullable
    private RecyclerView irc;
    @Nullable
    private String itemId;
    @Nullable
    private OrderDetailListener listener;
    @Nullable
    private LinearLayout llTipsContainer;
    @NotNull
    private final StringBuilder mBuilder = new StringBuilder();
    @Nullable
    private OrderDetail mData;
    @Nullable
    private HandlerC3516b mTimeHandler;
    @Nullable
    private Timer mTimer;
    @Nullable
    private TimerTask mTimerTask;
    @Nullable
    private String orderId;
    @Nullable
    private DigitTextView payAmountTv;
    @Nullable
    private ConstraintLayout payCardCl;
    @Nullable
    private TextView payDesTv;
    @Nullable
    private TextView payStatusTv;
    @Nullable
    private TextView paySymbolTv;
    @Nullable
    private TextView payTv;
    @Nullable
    private LinearPullToRefreshView refreshView;
    @Nullable
    private View rootView;
    @Nullable
    private NoticeFragment showNoticeFragment;
    @Nullable
    private ImageView tipsIconTv;
    @Nullable
    private TextView tipsTitleTv;
    @Nullable
    private TextView useTv;
    @NotNull
    public static final C3515a Companion = new C3515a(null);
    @JvmField
    public static boolean isOnResumeRefresh = true;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$a */
    /* loaded from: classes7.dex */
    public static final class C3515a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3515a() {
        }

        public /* synthetic */ C3515a(k50 k50Var) {
            this();
        }

        @NotNull
        public final int[] a(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "770541087")) {
                return (int[]) ipChange.ipc$dispatch("770541087", new Object[]{this, Long.valueOf(j)});
            }
            int[] iArr = new int[3];
            if (j >= 3600) {
                iArr[0] = (int) (j / ((long) ACache.TIME_HOUR));
                int i = (int) (j - (iArr[0] * ACache.TIME_HOUR));
                iArr[1] = i / 60;
                iArr[2] = i % 60;
            } else {
                iArr[0] = 0;
                long j2 = 60;
                iArr[1] = (int) (j / j2);
                iArr[2] = (int) (j % j2);
            }
            return iArr;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$b */
    /* loaded from: classes7.dex */
    public static final class HandlerC3516b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private WeakReference<OrderDetailFragment> a;

        public HandlerC3516b(@NotNull WeakReference<OrderDetailFragment> weakReference) {
            b41.i(weakReference, "reference");
            this.a = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            OrderDetail mData;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1169884601")) {
                ipChange.ipc$dispatch("-1169884601", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            OrderDetailFragment orderDetailFragment = this.a.get();
            if (message.what != 0 || orderDetailFragment == null || (mData = orderDetailFragment.getMData()) == null) {
                return;
            }
            CouponOrderInfoBean orderInfoVO = mData.getOrderInfoVO();
            if (b41.d(orderInfoVO != null ? orderInfoVO.getOrderId() : null, orderDetailFragment.getOrderId())) {
                StatusInfo statusInfo = mData.getStatusInfo();
                Long closeTime = statusInfo != null ? statusInfo.getCloseTime() : null;
                Long currentTime = statusInfo != null ? statusInfo.getCurrentTime() : null;
                if (closeTime == null || currentTime == null) {
                    return;
                }
                int[] a = OrderDetailFragment.Companion.a(statusInfo.getOverdueTime());
                String orderTips = statusInfo.getOrderTips();
                if (a.length != 3 || orderTips == null) {
                    return;
                }
                orderDetailFragment.updateTimerShow(orderTips, a[0], a[1], a[2], "");
                statusInfo.setOverdueTime(statusInfo.getOverdueTime() - 1);
                if (statusInfo.getOverdueTime() <= -1) {
                    orderDetailFragment.refresh();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$c */
    /* loaded from: classes7.dex */
    public static final class C3517c implements OnItemListener<CouponRuleBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C3517c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(OrderDetailFragment orderDetailFragment, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2033234028")) {
                ipChange.ipc$dispatch("2033234028", new Object[]{orderDetailFragment, view});
                return;
            }
            b41.i(orderDetailFragment, "this$0");
            orderDetailFragment.dismissPopLayer();
        }

        @Override // com.alibaba.pictures.bricks.listener.OnItemListener
        /* renamed from: b */
        public void onItemClick(@NotNull CouponRuleBean couponRuleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1919670194")) {
                ipChange.ipc$dispatch("-1919670194", new Object[]{this, couponRuleBean, Integer.valueOf(i)});
                return;
            }
            b41.i(couponRuleBean, "bean");
            NoticeFragment.C3513a c3513a = NoticeFragment.Companion;
            FragmentManager childFragmentManager = OrderDetailFragment.this.getChildFragmentManager();
            b41.h(childFragmentManager, "childFragmentManager");
            NoticeFragment d = c3513a.d(childFragmentManager, R$id.id_container_order_detail, couponRuleBean.getOrderInfo());
            if (d != null) {
                final OrderDetailFragment orderDetailFragment = OrderDetailFragment.this;
                orderDetailFragment.setShowNoticeFragment(d);
                d.setMCloseListener(new View.OnClickListener() { // from class: tb.ko1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OrderDetailFragment.C3517c.c(OrderDetailFragment.this, view);
                    }
                });
            }
        }

        @Override // com.alibaba.pictures.bricks.listener.OnItemListener
        /* renamed from: d */
        public void onItemExpose(@NotNull View view, @NotNull CouponRuleBean couponRuleBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-343997086")) {
                ipChange.ipc$dispatch("-343997086", new Object[]{this, view, couponRuleBean, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "itemView");
            b41.i(couponRuleBean, "bean");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$d */
    /* loaded from: classes7.dex */
    public static final class C3518d implements OnItemListener<Notice> {
        private static transient /* synthetic */ IpChange $ipChange;

        C3518d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(OrderDetailFragment orderDetailFragment, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-975250963")) {
                ipChange.ipc$dispatch("-975250963", new Object[]{orderDetailFragment, view});
                return;
            }
            b41.i(orderDetailFragment, "this$0");
            orderDetailFragment.dismissPopLayer();
        }

        @Override // com.alibaba.pictures.bricks.listener.OnItemListener
        /* renamed from: b */
        public void onItemClick(@NotNull Notice notice, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1510823385")) {
                ipChange.ipc$dispatch("-1510823385", new Object[]{this, notice, Integer.valueOf(i)});
                return;
            }
            b41.i(notice, "bean");
            NoticeFragment.C3513a c3513a = NoticeFragment.Companion;
            FragmentManager childFragmentManager = OrderDetailFragment.this.getChildFragmentManager();
            b41.h(childFragmentManager, "childFragmentManager");
            NoticeFragment c = c3513a.c(childFragmentManager, R$id.id_container_order_detail, notice);
            if (c != null) {
                final OrderDetailFragment orderDetailFragment = OrderDetailFragment.this;
                orderDetailFragment.setShowNoticeFragment(c);
                c.setMCloseListener(new View.OnClickListener() { // from class: tb.lo1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OrderDetailFragment.C3518d.c(OrderDetailFragment.this, view);
                    }
                });
            }
        }

        @Override // com.alibaba.pictures.bricks.listener.OnItemListener
        /* renamed from: d */
        public void onItemExpose(@NotNull View view, @NotNull Notice notice, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-905294061")) {
                ipChange.ipc$dispatch("-905294061", new Object[]{this, view, notice, Integer.valueOf(i)});
                return;
            }
            b41.i(view, "itemView");
            b41.i(notice, "bean");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$e */
    /* loaded from: classes7.dex */
    public static final class C3519e implements AppBarLayout.OnOffsetChangedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3519e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
            if (((r7 == null || r7.canScrollVertically(-1)) ? false : true) != false) goto L15;
         */
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onOffsetChanged(@org.jetbrains.annotations.Nullable com.google.android.material.appbar.AppBarLayout r6, int r7) {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.C3519e.$ipChange
                java.lang.String r1 = "2090090328"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L1e
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r4] = r5
                r2[r3] = r6
                r6 = 2
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r2[r6] = r7
                r0.ipc$dispatch(r1, r2)
                return
            L1e:
                com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r6 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                com.alibaba.pictures.bricks.view.LinearPullToRefreshView r6 = r6.getRefreshView()
                if (r6 != 0) goto L27
                goto L42
            L27:
                if (r7 != 0) goto L3e
                com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r7 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                androidx.recyclerview.widget.RecyclerView r7 = r7.getIrc()
                if (r7 == 0) goto L3a
                r0 = -1
                boolean r7 = r7.canScrollVertically(r0)
                if (r7 != 0) goto L3a
                r7 = 1
                goto L3b
            L3a:
                r7 = 0
            L3b:
                if (r7 == 0) goto L3e
                goto L3f
            L3e:
                r3 = 0
            L3f:
                r6.setPullToRefreshEnabled(r3)
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.C3519e.onOffsetChanged(com.google.android.material.appbar.AppBarLayout, int):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bottomViewRender(final OrderDetail orderDetail, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1269692401")) {
            ipChange.ipc$dispatch("1269692401", new Object[]{this, orderDetail, Boolean.valueOf(z)});
        } else if (z) {
            LinearLayout linearLayout = this.bottonLayout;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = this.bottonLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView = this.cancelOrder;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.payTv;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.useTv;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.commentDesTv;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.commentTv;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            String buttonStatus = orderDetail.getButtonStatus();
            if (b41.d(buttonStatus, ButtonStatus.NULL.getStatus())) {
                LinearLayout linearLayout3 = this.bottonLayout;
                if (linearLayout3 == null) {
                    return;
                }
                linearLayout3.setVisibility(8);
            } else if (b41.d(buttonStatus, ButtonStatus.GONE.getStatus())) {
                LinearLayout linearLayout4 = this.bottonLayout;
                if (linearLayout4 == null) {
                    return;
                }
                linearLayout4.setVisibility(8);
            } else if (b41.d(buttonStatus, ButtonStatus.CANCEL_PAY.getStatus())) {
                TextView textView6 = this.cancelOrder;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = this.payTv;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                }
                TextView textView8 = this.cancelOrder;
                if (textView8 != null) {
                    qo1.INSTANCE.b(textView8, getCreate(new TrackInfo()));
                }
                TextView textView9 = this.cancelOrder;
                if (textView9 != null) {
                    textView9.setOnClickListener(new View.OnClickListener() { // from class: tb.do1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OrderDetailFragment.m170bottomViewRender$lambda5(OrderDetailFragment.this, orderDetail, view);
                        }
                    });
                }
                TextView textView10 = this.payTv;
                if (textView10 != null) {
                    qo1.INSTANCE.i(textView10, getCreate(new TrackInfo()));
                }
                TextView textView11 = this.payTv;
                if (textView11 != null) {
                    textView11.setOnClickListener(new View.OnClickListener() { // from class: tb.eo1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OrderDetailFragment.m171bottomViewRender$lambda7(OrderDetailFragment.this, orderDetail, view);
                        }
                    });
                }
            } else {
                if (b41.d(buttonStatus, ButtonStatus.USE_UN_CLICK.getStatus())) {
                    TextView textView12 = this.useTv;
                    if (textView12 != null) {
                        textView12.setVisibility(0);
                    }
                    TextView textView13 = this.useTv;
                    if (textView13 != null) {
                        Resources resources = getResources();
                        int i = R$drawable.bricks_confirm_pay_bg_unclick;
                        Context context = getContext();
                        textView13.setBackground(ResourcesCompat.getDrawable(resources, i, context != null ? context.getTheme() : null));
                    }
                    TextView textView14 = this.useTv;
                    if (textView14 != null) {
                        textView14.setText("到店使用");
                    }
                    TextView textView15 = this.useTv;
                    if (textView15 != null) {
                        qo1.INSTANCE.u(textView15, getCreate(new TrackInfo()), true);
                    }
                    TextView textView16 = this.useTv;
                    if (textView16 != null) {
                        textView16.setOnClickListener(new View.OnClickListener() { // from class: tb.io1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                OrderDetailFragment.m172bottomViewRender$lambda9(OrderDetail.this, this, view);
                            }
                        });
                    }
                } else if (b41.d(buttonStatus, ButtonStatus.USE_CLICK.getStatus())) {
                    TextView textView17 = this.useTv;
                    if (textView17 != null) {
                        textView17.setVisibility(0);
                    }
                    TextView textView18 = this.useTv;
                    if (textView18 != null) {
                        Resources resources2 = getResources();
                        int i2 = R$drawable.bricks_confirm_pay_bg;
                        Context context2 = getContext();
                        textView18.setBackground(ResourcesCompat.getDrawable(resources2, i2, context2 != null ? context2.getTheme() : null));
                    }
                    TextView textView19 = this.useTv;
                    if (textView19 != null) {
                        textView19.setText("到店使用");
                    }
                    TextView textView20 = this.useTv;
                    if (textView20 != null) {
                        qo1.INSTANCE.u(textView20, getCreate(new TrackInfo()), true);
                    }
                    TextView textView21 = this.useTv;
                    if (textView21 != null) {
                        textView21.setOnClickListener(new View.OnClickListener() { // from class: tb.go1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                OrderDetailFragment.m167bottomViewRender$lambda11(OrderDetailFragment.this, orderDetail, view);
                            }
                        });
                    }
                } else if (b41.d(buttonStatus, ButtonStatus.COMMENT.getStatus())) {
                    TextView textView22 = this.commentDesTv;
                    if (textView22 != null) {
                        textView22.setVisibility(0);
                    }
                    TextView textView23 = this.commentTv;
                    if (textView23 != null) {
                        textView23.setVisibility(0);
                    }
                    TextView textView24 = this.commentTv;
                    if (textView24 != null) {
                        qo1.INSTANCE.s(textView24, getCreate(new TrackInfo()));
                    }
                    TextView textView25 = this.commentTv;
                    if (textView25 != null) {
                        textView25.setOnClickListener(new View.OnClickListener() { // from class: tb.ho1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                OrderDetailFragment.m168bottomViewRender$lambda13(OrderDetailFragment.this, orderDetail, view);
                            }
                        });
                    }
                } else if (b41.d(buttonStatus, ButtonStatus.SEE_COMMENT.getStatus())) {
                    TextView textView26 = this.useTv;
                    if (textView26 != null) {
                        textView26.setVisibility(0);
                    }
                    TextView textView27 = this.useTv;
                    if (textView27 != null) {
                        Resources resources3 = getResources();
                        int i3 = R$drawable.bricks_confirm_pay_bg;
                        Context context3 = getContext();
                        textView27.setBackground(ResourcesCompat.getDrawable(resources3, i3, context3 != null ? context3.getTheme() : null));
                    }
                    TextView textView28 = this.useTv;
                    if (textView28 != null) {
                        textView28.setText("看评价");
                    }
                    TextView textView29 = this.useTv;
                    if (textView29 != null) {
                        qo1.INSTANCE.n(textView29, getCreate(new TrackInfo()));
                    }
                    TextView textView30 = this.useTv;
                    if (textView30 != null) {
                        textView30.setOnClickListener(new View.OnClickListener() { // from class: tb.fo1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                OrderDetailFragment.m169bottomViewRender$lambda15(OrderDetailFragment.this, orderDetail, view);
                            }
                        });
                    }
                } else {
                    LinearLayout linearLayout5 = this.bottonLayout;
                    if (linearLayout5 == null) {
                        return;
                    }
                    linearLayout5.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-11  reason: not valid java name */
    public static final void m167bottomViewRender$lambda11(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236129869")) {
            ipChange.ipc$dispatch("-236129869", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        b41.i(orderDetail, "$data");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.t(view, orderDetailFragment.getCreate(new TrackInfo()), true);
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-13  reason: not valid java name */
    public static final void m168bottomViewRender$lambda13(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "102157681")) {
            ipChange.ipc$dispatch("102157681", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        b41.i(orderDetail, "$data");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.r(view, orderDetailFragment.getCreate(new TrackInfo()));
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-15  reason: not valid java name */
    public static final void m169bottomViewRender$lambda15(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440445231")) {
            ipChange.ipc$dispatch("440445231", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        b41.i(orderDetail, "$data");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.m(view, orderDetailFragment.getCreate(new TrackInfo()));
        orderDetailFragment.jumpAction(orderDetail.getButtonJumpUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-5  reason: not valid java name */
    public static final void m170bottomViewRender$lambda5(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563212772")) {
            ipChange.ipc$dispatch("-563212772", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        b41.i(orderDetail, "$data");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.a(view, orderDetailFragment.getCreate(new TrackInfo()));
        EventBus.getDefault().post(new Event("scriptOrderRefresh", "pay"));
        OrderDetailListener orderDetailListener = orderDetailFragment.listener;
        if (orderDetailListener != null) {
            orderDetailListener.cancelOrder(orderDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-7  reason: not valid java name */
    public static final void m171bottomViewRender$lambda7(OrderDetailFragment orderDetailFragment, OrderDetail orderDetail, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-224925222")) {
            ipChange.ipc$dispatch("-224925222", new Object[]{orderDetailFragment, orderDetail, view});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        b41.i(orderDetail, "$data");
        qo1 qo1Var = qo1.INSTANCE;
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        qo1Var.j(view, orderDetailFragment.getCreate(new TrackInfo()));
        EventBus.getDefault().post(new Event("scriptOrderRefresh", "pay"));
        OrderDetailListener orderDetailListener = orderDetailFragment.listener;
        if (orderDetailListener != null) {
            orderDetailListener.gotoPay(orderDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bottomViewRender$lambda-9  reason: not valid java name */
    public static final void m172bottomViewRender$lambda9(OrderDetail orderDetail, OrderDetailFragment orderDetailFragment, View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1266844660")) {
            ipChange.ipc$dispatch("-1266844660", new Object[]{orderDetail, orderDetailFragment, view});
            return;
        }
        b41.i(orderDetail, "$data");
        b41.i(orderDetailFragment, "this$0");
        String yellowTips = orderDetail.getYellowTips();
        if (yellowTips != null && yellowTips.length() != 0) {
            z = false;
        }
        if (!z) {
            Toast.makeText(orderDetailFragment.getActivity(), orderDetail.getYellowTips(), 0).show();
        } else {
            Toast.makeText(orderDetailFragment.getActivity(), "出码需要一定时间，稍等一下哦", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrackInfo getCreate(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263125476")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1263125476", new Object[]{this, trackInfo});
        }
        trackInfo.setSpma(ld.INSTANCE.a());
        trackInfo.setSpmb(pp2.PROJECT_SCRIPTKILL_ORDRR_DETAILS_PAGE);
        trackInfo.setArgs(new HashMap<>());
        trackInfo.getArgs().put("item_id", this.itemId);
        trackInfo.getArgs().put("orderid", this.orderId);
        return trackInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void headerViewRender(OrderDetail orderDetail, boolean z) {
        String totalAmount;
        String orderStatusStr;
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-885584433")) {
            ipChange.ipc$dispatch("-885584433", new Object[]{this, orderDetail, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            LinearLayout linearLayout = this.llTipsContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView2 = this.tipsTitleTv;
            if (textView2 != null) {
                textView2.setText("支付结果处理中，请稍等一下哦");
            }
        } else {
            String yellowTips = orderDetail.getYellowTips();
            if (yellowTips != null && yellowTips.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                LinearLayout linearLayout2 = this.llTipsContainer;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                TextView textView3 = this.tipsTitleTv;
                if (textView3 != null) {
                    textView3.setText(orderDetail.getYellowTips());
                }
                String yellowTipsIcon = orderDetail.getYellowTipsIcon();
                if (yellowTipsIcon != null) {
                    ImageLoaderProviderProxy.getProxy().loadinto(yellowTipsIcon, this.tipsIconTv);
                }
            } else {
                LinearLayout linearLayout3 = this.llTipsContainer;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                }
            }
        }
        StatusInfo statusInfo = orderDetail.getStatusInfo();
        if (statusInfo != null) {
            if (b41.d(statusInfo.getShowStatus(), "1") && !z) {
                ConstraintLayout constraintLayout = this.payCardCl;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
            } else {
                ConstraintLayout constraintLayout2 = this.payCardCl;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }
        }
        StatusInfo statusInfo2 = orderDetail.getStatusInfo();
        if (statusInfo2 != null && (orderStatusStr = statusInfo2.getOrderStatusStr()) != null && (textView = this.payStatusTv) != null) {
            textView.setText(orderStatusStr);
        }
        StatusInfo statusInfo3 = orderDetail.getStatusInfo();
        if (statusInfo3 != null && (totalAmount = statusInfo3.getTotalAmount()) != null) {
            DigitTextView digitTextView = this.payAmountTv;
            if (digitTextView != null) {
                digitTextView.setText(totalAmount);
            }
            DigitTextView digitTextView2 = this.payAmountTv;
            if (digitTextView2 != null) {
                digitTextView2.setVisibility(0);
            }
            TextView textView4 = this.paySymbolTv;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        }
        StatusInfo statusInfo4 = orderDetail.getStatusInfo();
        if ((statusInfo4 != null ? statusInfo4.getTotalAmount() : null) == null) {
            DigitTextView digitTextView3 = this.payAmountTv;
            if (digitTextView3 != null) {
                digitTextView3.setVisibility(8);
            }
            TextView textView5 = this.paySymbolTv;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        StatusInfo statusInfo5 = orderDetail.getStatusInfo();
        if (statusInfo5 == null || statusInfo5.getOverdueTime() <= 0) {
            return;
        }
        startTimer(0);
    }

    private final void initBottomView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099059966")) {
            ipChange.ipc$dispatch("1099059966", new Object[]{this});
            return;
        }
        View view = this.rootView;
        this.bottonLayout = view != null ? (LinearLayout) view.findViewById(R$id.order_detail_bottom) : null;
        View view2 = this.rootView;
        this.cancelOrder = view2 != null ? (TextView) view2.findViewById(R$id.tv_cancel_action) : null;
        View view3 = this.rootView;
        this.payTv = view3 != null ? (TextView) view3.findViewById(R$id.tv_pay_action) : null;
        View view4 = this.rootView;
        this.useTv = view4 != null ? (TextView) view4.findViewById(R$id.tv_use_action) : null;
        View view5 = this.rootView;
        this.commentDesTv = view5 != null ? (TextView) view5.findViewById(R$id.tv_comment_des) : null;
        View view6 = this.rootView;
        this.commentTv = view6 != null ? (TextView) view6.findViewById(R$id.tv_comment_action) : null;
    }

    private final void initHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993160796")) {
            ipChange.ipc$dispatch("1993160796", new Object[]{this});
            return;
        }
        View view = this.rootView;
        this.llTipsContainer = view != null ? (LinearLayout) view.findViewById(R$id.ll_tips_container) : null;
        View view2 = this.rootView;
        this.tipsIconTv = view2 != null ? (ImageView) view2.findViewById(R$id.iv_tips_icon) : null;
        View view3 = this.rootView;
        this.tipsTitleTv = view3 != null ? (TextView) view3.findViewById(R$id.tv_tips_title) : null;
        View view4 = this.rootView;
        this.payCardCl = view4 != null ? (ConstraintLayout) view4.findViewById(R$id.cl_pay_card) : null;
        View view5 = this.rootView;
        this.payStatusTv = view5 != null ? (TextView) view5.findViewById(R$id.tv_pay_status) : null;
        View view6 = this.rootView;
        this.paySymbolTv = view6 != null ? (TextView) view6.findViewById(R$id.tv_pay_symbol) : null;
        View view7 = this.rootView;
        this.payAmountTv = view7 != null ? (DigitTextView) view7.findViewById(R$id.tv_pay_amount) : null;
        View view8 = this.rootView;
        this.payDesTv = view8 != null ? (TextView) view8.findViewById(R$id.tv_order_state_des) : null;
    }

    private final void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539130473")) {
            ipChange.ipc$dispatch("539130473", new Object[]{this});
            return;
        }
        View view = this.rootView;
        this.irc = view != null ? (RecyclerView) view.findViewById(R$id.irc) : null;
        View view2 = this.rootView;
        LinearPullToRefreshView linearPullToRefreshView = view2 != null ? (LinearPullToRefreshView) view2.findViewById(R$id.lin_refresh_layout) : null;
        this.refreshView = linearPullToRefreshView;
        if (linearPullToRefreshView != null) {
            linearPullToRefreshView.setVisibility(8);
        }
        LinearPullToRefreshView linearPullToRefreshView2 = this.refreshView;
        if (linearPullToRefreshView2 != null) {
            linearPullToRefreshView2.setPullToRefreshEnabled(true);
        }
        LinearPullToRefreshView linearPullToRefreshView3 = this.refreshView;
        if (linearPullToRefreshView3 != null) {
            linearPullToRefreshView3.setOnRefreshListener(new LinearPullToRefreshView.OnRefreshListener() { // from class: tb.jo1
                @Override // com.alibaba.pictures.bricks.view.LinearPullToRefreshView.OnRefreshListener
                public final void onRefresh() {
                    OrderDetailFragment.m173initView$lambda0(OrderDetailFragment.this);
                }
            });
        }
        initHeaderView();
        initBottomView();
        final FragmentActivity activity = getActivity();
        if (activity != null) {
            OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(activity);
            orderDetailAdapter.e(new C3517c());
            orderDetailAdapter.d(new C3518d());
            orderDetailAdapter.b(this);
            this.adapter = orderDetailAdapter;
            RecyclerView recyclerView = this.irc;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$initView$2$2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NotNull Rect rect, @NotNull View view3, @NotNull RecyclerView recyclerView2, @NotNull RecyclerView.State state) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1187009250")) {
                            ipChange2.ipc$dispatch("-1187009250", new Object[]{this, rect, view3, recyclerView2, state});
                            return;
                        }
                        b41.i(rect, "outRect");
                        b41.i(view3, "view");
                        b41.i(recyclerView2, "parent");
                        b41.i(state, "state");
                        s60 s60Var = s60.INSTANCE;
                        FragmentActivity fragmentActivity = FragmentActivity.this;
                        b41.h(fragmentActivity, AdvanceSetting.NETWORK_TYPE);
                        rect.bottom = s60Var.a(fragmentActivity, 12.0f);
                    }
                });
            }
            RecyclerView recyclerView2 = this.irc;
            if (recyclerView2 != null) {
                recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$initView$2$3
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(@NotNull RecyclerView recyclerView3, int i, int i2) {
                        IpChange ipChange2 = $ipChange;
                        boolean z = true;
                        if (AndroidInstantRuntime.support(ipChange2, "-698353192")) {
                            ipChange2.ipc$dispatch("-698353192", new Object[]{this, recyclerView3, Integer.valueOf(i), Integer.valueOf(i2)});
                            return;
                        }
                        b41.i(recyclerView3, "recyclerView");
                        super.onScrolled(recyclerView3, i, i2);
                        LinearPullToRefreshView refreshView = OrderDetailFragment.this.getRefreshView();
                        if (refreshView == null) {
                            return;
                        }
                        RecyclerView irc = OrderDetailFragment.this.getIrc();
                        refreshView.setPullToRefreshEnabled((irc == null || irc.canScrollVertically(-1)) ? false : false);
                    }
                });
            }
            View view3 = this.rootView;
            AppBarLayout appBarLayout = view3 != null ? (AppBarLayout) view3.findViewById(R$id.appbar_layout) : null;
            if (appBarLayout != null) {
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C3519e());
            }
            RecyclerView recyclerView3 = this.irc;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(this.adapter);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
            linearLayoutManager.setOrientation(1);
            RecyclerView recyclerView4 = this.irc;
            if (recyclerView4 == null) {
                return;
            }
            recyclerView4.setLayoutManager(linearLayoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m173initView$lambda0(OrderDetailFragment orderDetailFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906555143")) {
            ipChange.ipc$dispatch("-906555143", new Object[]{orderDetailFragment});
            return;
        }
        b41.i(orderDetailFragment, "this$0");
        orderDetailFragment.refresh();
    }

    private final void stopTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1411957353")) {
            ipChange.ipc$dispatch("1411957353", new Object[]{this});
            return;
        }
        Timer timer = this.mTimer;
        if (timer == null || this.mTimerTask == null) {
            return;
        }
        b41.f(timer);
        timer.cancel();
        TimerTask timerTask = this.mTimerTask;
        b41.f(timerTask);
        timerTask.cancel();
        this.mTimer = null;
        this.mTimerTask = null;
    }

    private final void updateOrderStateMessage(String str) {
        TextView textView;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "899791931")) {
            ipChange.ipc$dispatch("899791931", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            TextView textView2 = this.payDesTv;
            if (textView2 != null) {
                textView2.setText(str);
            }
            TextView textView3 = this.payDesTv;
            if (((textView3 == null || textView3.getVisibility() != 0) ? false : false) || (textView = this.payDesTv) == null) {
                return;
            }
            textView.setVisibility(0);
        }
    }

    public final void dismissPopLayer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845130242")) {
            ipChange.ipc$dispatch("845130242", new Object[]{this});
            return;
        }
        NoticeFragment.Companion.a(getChildFragmentManager(), this.showNoticeFragment);
        this.showNoticeFragment = null;
    }

    @Nullable
    public final OrderDetailAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "453405792") ? (OrderDetailAdapter) ipChange.ipc$dispatch("453405792", new Object[]{this}) : this.adapter;
    }

    @Nullable
    public final LinearLayout getBottonLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1496970071") ? (LinearLayout) ipChange.ipc$dispatch("1496970071", new Object[]{this}) : this.bottonLayout;
    }

    @Nullable
    public final TextView getCancelOrder() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1263330412") ? (TextView) ipChange.ipc$dispatch("-1263330412", new Object[]{this}) : this.cancelOrder;
    }

    @Nullable
    public final TextView getCommentDesTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1339647883") ? (TextView) ipChange.ipc$dispatch("-1339647883", new Object[]{this}) : this.commentDesTv;
    }

    @Nullable
    public final TextView getCommentTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-323725593") ? (TextView) ipChange.ipc$dispatch("-323725593", new Object[]{this}) : this.commentTv;
    }

    @Nullable
    public final RecyclerView getIrc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1577498273") ? (RecyclerView) ipChange.ipc$dispatch("1577498273", new Object[]{this}) : this.irc;
    }

    @Nullable
    public final String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-255572744") ? (String) ipChange.ipc$dispatch("-255572744", new Object[]{this}) : this.itemId;
    }

    @Nullable
    public final OrderDetailListener getListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-641705738") ? (OrderDetailListener) ipChange.ipc$dispatch("-641705738", new Object[]{this}) : this.listener;
    }

    @Nullable
    public final LinearLayout getLlTipsContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "87495874") ? (LinearLayout) ipChange.ipc$dispatch("87495874", new Object[]{this}) : this.llTipsContainer;
    }

    @Nullable
    public final OrderDetail getMData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1141661208") ? (OrderDetail) ipChange.ipc$dispatch("-1141661208", new Object[]{this}) : this.mData;
    }

    @Nullable
    public final String getOrderId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "588120469") ? (String) ipChange.ipc$dispatch("588120469", new Object[]{this}) : this.orderId;
    }

    @Nullable
    public final DigitTextView getPayAmountTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1195231302") ? (DigitTextView) ipChange.ipc$dispatch("-1195231302", new Object[]{this}) : this.payAmountTv;
    }

    @Nullable
    public final ConstraintLayout getPayCardCl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "29555636") ? (ConstraintLayout) ipChange.ipc$dispatch("29555636", new Object[]{this}) : this.payCardCl;
    }

    @Nullable
    public final TextView getPayDesTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-391184578") ? (TextView) ipChange.ipc$dispatch("-391184578", new Object[]{this}) : this.payDesTv;
    }

    @Nullable
    public final TextView getPayStatusTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1617919148") ? (TextView) ipChange.ipc$dispatch("1617919148", new Object[]{this}) : this.payStatusTv;
    }

    @Nullable
    public final TextView getPaySymbolTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1654210758") ? (TextView) ipChange.ipc$dispatch("1654210758", new Object[]{this}) : this.paySymbolTv;
    }

    @Nullable
    public final TextView getPayTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1594199230") ? (TextView) ipChange.ipc$dispatch("1594199230", new Object[]{this}) : this.payTv;
    }

    @Nullable
    public final LinearPullToRefreshView getRefreshView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "365135132") ? (LinearPullToRefreshView) ipChange.ipc$dispatch("365135132", new Object[]{this}) : this.refreshView;
    }

    @Nullable
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-993510095") ? (View) ipChange.ipc$dispatch("-993510095", new Object[]{this}) : this.rootView;
    }

    @Nullable
    public final NoticeFragment getShowNoticeFragment() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "725163250") ? (NoticeFragment) ipChange.ipc$dispatch("725163250", new Object[]{this}) : this.showNoticeFragment;
    }

    @Nullable
    public final ImageView getTipsIconTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-707637875") ? (ImageView) ipChange.ipc$dispatch("-707637875", new Object[]{this}) : this.tipsIconTv;
    }

    @Nullable
    public final TextView getTipsTitleTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-855869658") ? (TextView) ipChange.ipc$dispatch("-855869658", new Object[]{this}) : this.tipsTitleTv;
    }

    @Nullable
    public final TextView getUseTv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1926723647") ? (TextView) ipChange.ipc$dispatch("1926723647", new Object[]{this}) : this.useTv;
    }

    public final boolean isPopLayerShowing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811715381")) {
            return ((Boolean) ipChange.ipc$dispatch("1811715381", new Object[]{this})).booleanValue();
        }
        NoticeFragment noticeFragment = this.showNoticeFragment;
        if (noticeFragment != null) {
            b41.f(noticeFragment);
            return noticeFragment.isAdded();
        }
        return false;
    }

    public final void jumpAction(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1136230628")) {
            ipChange.ipc$dispatch("1136230628", new Object[]{this, str});
            return;
        }
        if ((str == null || str.length() == 0) ? true : true) {
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(getContext(), action);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937929009")) {
            ipChange.ipc$dispatch("1937929009", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("orderId") : null;
        this.orderId = string;
        if (string != null) {
            C8604o.s(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385663411")) {
            return (View) ipChange.ipc$dispatch("1385663411", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        this.rootView = layoutInflater.inflate(R$layout.bricks_coupon_order_detail_fragment, viewGroup, false);
        initView();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1786991797")) {
            ipChange.ipc$dispatch("1786991797", new Object[]{this});
            return;
        }
        super.onPause();
        stopTimer();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1209957362")) {
            ipChange.ipc$dispatch("1209957362", new Object[]{this});
            return;
        }
        super.onResume();
        refresh();
    }

    public final void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716477617")) {
            ipChange.ipc$dispatch("1716477617", new Object[]{this});
            return;
        }
        stopTimer();
        showLoading(new String[0]);
        if (DoloresLoginHandler.Companion.a().c()) {
            rb0.C9647a c9647a = rb0.Companion;
            CouponOrderDetailRequest couponOrderDetailRequest = new CouponOrderDetailRequest();
            couponOrderDetailRequest.setOrderId(this.orderId);
            ia1 ia1Var = ia1.INSTANCE;
            AMapLocation lastKnownLocation = ia1Var.c().getLastKnownLocation();
            couponOrderDetailRequest.setLatitude(String.valueOf(lastKnownLocation != null ? Double.valueOf(lastKnownLocation.getLatitude()) : null));
            AMapLocation lastKnownLocation2 = ia1Var.c().getLastKnownLocation();
            couponOrderDetailRequest.setLongitude(String.valueOf(lastKnownLocation2 != null ? Double.valueOf(lastKnownLocation2.getLongitude()) : null));
            c9647a.b(couponOrderDetailRequest).c(getContext()).a().doOnKTSuccess(new Function1<OrderDetail, wt2>() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$2
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(OrderDetail orderDetail) {
                    invoke2(orderDetail);
                    return wt2.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:43:0x00b9, code lost:
                    if (tb.b41.d(r0 != null ? r0.getShowStatus() : null, "1") != false) goto L41;
                 */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(@org.jetbrains.annotations.NotNull com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail r10) {
                    /*
                        r9 = this;
                        com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$2.$ipChange
                        java.lang.String r1 = "1775806832"
                        boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                        r3 = 1
                        r4 = 0
                        if (r2 == 0) goto L17
                        r2 = 2
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        r2[r4] = r9
                        r2[r3] = r10
                        r0.ipc$dispatch(r1, r2)
                        return
                    L17:
                        java.lang.String r0 = "it"
                        tb.b41.i(r10, r0)
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        android.view.View r0 = r0.getRootView()
                        r1 = 0
                        if (r0 == 0) goto L2e
                        int r2 = com.alibaba.pictures.R$id.ll_page
                        android.view.View r0 = r0.findViewById(r2)
                        android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                        goto L2f
                    L2e:
                        r0 = r1
                    L2f:
                        if (r0 == 0) goto L36
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r2 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        r2.removeErrorView(r0)
                    L36:
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        r0.setMData(r10)
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail r0 = r0.getMData()
                        if (r0 == 0) goto L82
                        com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo r0 = r0.getStatusInfo()
                        if (r0 == 0) goto L82
                        java.lang.Long r0 = r0.getCurrentTime()
                        if (r0 == 0) goto L82
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r2 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        long r5 = r0.longValue()
                        com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail r0 = r2.getMData()
                        if (r0 == 0) goto L82
                        com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo r0 = r0.getStatusInfo()
                        if (r0 == 0) goto L82
                        java.lang.Long r0 = r0.getCloseTime()
                        if (r0 == 0) goto L82
                        long r7 = r0.longValue()
                        com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail r0 = r2.getMData()
                        if (r0 == 0) goto L76
                        com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo r0 = r0.getStatusInfo()
                        goto L77
                    L76:
                        r0 = r1
                    L77:
                        if (r0 != 0) goto L7a
                        goto L82
                    L7a:
                        long r7 = r7 - r5
                        r2 = 1000(0x3e8, float:1.401E-42)
                        long r5 = (long) r2
                        long r7 = r7 / r5
                        r0.setOverdueTime(r7)
                    L82:
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.view.LinearPullToRefreshView r0 = r0.getRefreshView()
                        if (r0 != 0) goto L8b
                        goto L8e
                    L8b:
                        r0.setVisibility(r4)
                    L8e:
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        java.lang.String r2 = r10.getItemId()
                        r0.setItemId(r2)
                        boolean r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.mPayResultState
                        if (r0 == 0) goto Lbc
                        java.lang.String r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.mPayResultOrderId
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r2 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        java.lang.String r2 = r2.getOrderId()
                        boolean r0 = tb.b41.d(r0, r2)
                        if (r0 == 0) goto Lbc
                        com.alibaba.pictures.bricks.coupon.order.bean.StatusInfo r0 = r10.getStatusInfo()
                        if (r0 == 0) goto Lb3
                        java.lang.String r1 = r0.getShowStatus()
                    Lb3:
                        java.lang.String r0 = "1"
                        boolean r0 = tb.b41.d(r1, r0)
                        if (r0 == 0) goto Lbc
                        goto Lbd
                    Lbc:
                        r3 = 0
                    Lbd:
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.access$headerViewRender(r0, r10, r3)
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.access$bottomViewRender(r0, r10, r3)
                        com.alient.oneservice.ut.TrackInfo r0 = new com.alient.oneservice.ut.TrackInfo
                        r0.<init>()
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r1 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailAdapter r1 = r1.getAdapter()
                        if (r1 != 0) goto Ld5
                        goto Ldd
                    Ld5:
                        tb.gt0 r2 = new tb.gt0
                        r2.<init>(r10)
                        r1.c(r2)
                    Ldd:
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r1 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailAdapter r1 = r1.getAdapter()
                        if (r1 == 0) goto Lee
                        com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment r2 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.this
                        com.alient.oneservice.ut.TrackInfo r0 = com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment.access$getCreate(r2, r0)
                        r1.a(r10, r0)
                    Lee:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$2.invoke2(com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail):void");
                }
            }).doOnKTFail(new Function1<dc0<OrderDetail>, wt2>() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$3
                private static transient /* synthetic */ IpChange $ipChange;

                /* compiled from: Taobao */
                /* renamed from: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$3$a */
                /* loaded from: classes7.dex */
                public static final class C3520a implements BricksBaseFragment.IClickListener {
                    private static transient /* synthetic */ IpChange $ipChange;
                    final /* synthetic */ OrderDetailFragment a;

                    C3520a(OrderDetailFragment orderDetailFragment) {
                        this.a = orderDetailFragment;
                    }

                    @Override // com.alibaba.pictures.bricks.base.BricksBaseFragment.IClickListener
                    public void handleClick(int i) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-758116143")) {
                            ipChange.ipc$dispatch("-758116143", new Object[]{this, Integer.valueOf(i)});
                        } else {
                            this.a.refresh();
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<OrderDetail> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<OrderDetail> dc0Var) {
                    String f;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1946198330")) {
                        ipChange2.ipc$dispatch("1946198330", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    View rootView = OrderDetailFragment.this.getRootView();
                    ViewGroup viewGroup = rootView != null ? (ViewGroup) rootView.findViewById(R$id.ll_page) : null;
                    String str = new CouponOrderDetailRequest().API_NAME;
                    String valueOf = String.valueOf(dc0Var.b());
                    String d = dc0Var.d();
                    z13.a(z13.b(str, "券订单详情接口", valueOf, d, "itemId: " + OrderDetailFragment.this.getItemId() + "  orderId：" + OrderDetailFragment.this.getOrderId()), "-4422", "券订单详情渲染错误");
                    if (viewGroup != null) {
                        OrderDetailFragment orderDetailFragment = OrderDetailFragment.this;
                        String e = dc0Var.e();
                        if (e != null && (f = dc0Var.f()) != null) {
                            orderDetailFragment.showErrorView(1, f, e, viewGroup, true, false, true, new C3520a(orderDetailFragment));
                        }
                    }
                    LogUtil.e(dc0Var.f(), new Object[0]);
                }
            }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$refresh$4
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "551886189")) {
                        ipChange2.ipc$dispatch("551886189", new Object[]{this});
                    } else {
                        OrderDetailFragment.this.stopLoading();
                    }
                }
            });
            return;
        }
        yb1.Companion.d(this, 2001);
    }

    public final void setAdapter(@Nullable OrderDetailAdapter orderDetailAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889237306")) {
            ipChange.ipc$dispatch("889237306", new Object[]{this, orderDetailAdapter});
        } else {
            this.adapter = orderDetailAdapter;
        }
    }

    public final void setBottonLayout(@Nullable LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2023058957")) {
            ipChange.ipc$dispatch("-2023058957", new Object[]{this, linearLayout});
        } else {
            this.bottonLayout = linearLayout;
        }
    }

    public final void setCancelOrder(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-534719336")) {
            ipChange.ipc$dispatch("-534719336", new Object[]{this, textView});
        } else {
            this.cancelOrder = textView;
        }
    }

    public final void setCommentDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183864977")) {
            ipChange.ipc$dispatch("-1183864977", new Object[]{this, textView});
        } else {
            this.commentDesTv = textView;
        }
    }

    public final void setCommentTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693438117")) {
            ipChange.ipc$dispatch("1693438117", new Object[]{this, textView});
        } else {
            this.commentTv = textView;
        }
    }

    public final void setIrc(@Nullable RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994933327")) {
            ipChange.ipc$dispatch("-1994933327", new Object[]{this, recyclerView});
        } else {
            this.irc = recyclerView;
        }
    }

    public final void setItemId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727912474")) {
            ipChange.ipc$dispatch("-727912474", new Object[]{this, str});
        } else {
            this.itemId = str;
        }
    }

    public final void setListener(@Nullable OrderDetailListener orderDetailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019628200")) {
            ipChange.ipc$dispatch("-1019628200", new Object[]{this, orderDetailListener});
        } else {
            this.listener = orderDetailListener;
        }
    }

    public final void setLlTipsContainer(@Nullable LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759929936")) {
            ipChange.ipc$dispatch("759929936", new Object[]{this, linearLayout});
        } else {
            this.llTipsContainer = linearLayout;
        }
    }

    public final void setMData(@Nullable OrderDetail orderDetail) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561307986")) {
            ipChange.ipc$dispatch("1561307986", new Object[]{this, orderDetail});
        } else {
            this.mData = orderDetail;
        }
    }

    public final void setOrderId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-564388223")) {
            ipChange.ipc$dispatch("-564388223", new Object[]{this, str});
        } else {
            this.orderId = str;
        }
    }

    public final void setPayAmountTv(@Nullable DigitTextView digitTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196989076")) {
            ipChange.ipc$dispatch("1196989076", new Object[]{this, digitTextView});
        } else {
            this.payAmountTv = digitTextView;
        }
    }

    public final void setPayCardCl(@Nullable ConstraintLayout constraintLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1870915278")) {
            ipChange.ipc$dispatch("-1870915278", new Object[]{this, constraintLayout});
        } else {
            this.payCardCl = constraintLayout;
        }
    }

    public final void setPayDesTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055817670")) {
            ipChange.ipc$dispatch("1055817670", new Object[]{this, textView});
        } else {
            this.payDesTv = textView;
        }
    }

    public final void setPayStatusTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1410296192")) {
            ipChange.ipc$dispatch("-1410296192", new Object[]{this, textView});
        } else {
            this.payStatusTv = textView;
        }
    }

    public final void setPaySymbolTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285256282")) {
            ipChange.ipc$dispatch("-285256282", new Object[]{this, textView});
        } else {
            this.paySymbolTv = textView;
        }
    }

    public final void setPayTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705726034")) {
            ipChange.ipc$dispatch("-1705726034", new Object[]{this, textView});
        } else {
            this.payTv = textView;
        }
    }

    public final void setRefreshView(@Nullable LinearPullToRefreshView linearPullToRefreshView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1289274298")) {
            ipChange.ipc$dispatch("1289274298", new Object[]{this, linearPullToRefreshView});
        } else {
            this.refreshView = linearPullToRefreshView;
        }
    }

    public final void setRootView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1019642319")) {
            ipChange.ipc$dispatch("1019642319", new Object[]{this, view});
        } else {
            this.rootView = view;
        }
    }

    public final void setShowNoticeFragment(@Nullable NoticeFragment noticeFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428747758")) {
            ipChange.ipc$dispatch("-428747758", new Object[]{this, noticeFragment});
        } else {
            this.showNoticeFragment = noticeFragment;
        }
    }

    public final void setTipsIconTv(@Nullable ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206125871")) {
            ipChange.ipc$dispatch("-1206125871", new Object[]{this, imageView});
        } else {
            this.tipsIconTv = imageView;
        }
    }

    public final void setTipsTitleTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788337850")) {
            ipChange.ipc$dispatch("-788337850", new Object[]{this, textView});
        } else {
            this.tipsTitleTv = textView;
        }
    }

    public final void setUseTv(@Nullable TextView textView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12596301")) {
            ipChange.ipc$dispatch("12596301", new Object[]{this, textView});
        } else {
            this.useTv = textView;
        }
    }

    public final void startTimer(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3506472")) {
            ipChange.ipc$dispatch("3506472", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            this.mTimeHandler = new HandlerC3516b(new WeakReference(this));
        }
        if (this.mTimerTask == null) {
            TimerTask timerTask = new TimerTask() { // from class: com.alibaba.pictures.bricks.coupon.order.OrderDetailFragment$startTimer$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    OrderDetailFragment.HandlerC3516b handlerC3516b;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "6145111")) {
                        ipChange2.ipc$dispatch("6145111", new Object[]{this});
                        return;
                    }
                    handlerC3516b = OrderDetailFragment.this.mTimeHandler;
                    if (handlerC3516b != null) {
                        handlerC3516b.sendEmptyMessage(i);
                    }
                }
            };
            this.mTimerTask = timerTask;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.schedule(timerTask, 0L, 1000L);
            }
        }
    }

    public final void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518936366")) {
            ipChange.ipc$dispatch("-1518936366", new Object[]{this});
            return;
        }
        hideLoading();
        LinearPullToRefreshView linearPullToRefreshView = this.refreshView;
        if (linearPullToRefreshView == null || linearPullToRefreshView == null) {
            return;
        }
        linearPullToRefreshView.onRefreshComplete();
    }

    public final void updateTimerShow(@Nullable String str, int i, int i2, int i3, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463118320")) {
            ipChange.ipc$dispatch("-1463118320", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
            return;
        }
        StringBuilder sb = this.mBuilder;
        sb.delete(0, sb.length());
        if (!TextUtils.isEmpty(str)) {
            this.mBuilder.append(str);
        }
        if (i > 0) {
            StringBuilder sb2 = this.mBuilder;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i);
            sb3.append((char) 26102);
            sb2.append(sb3.toString());
        }
        StringBuilder sb4 = this.mBuilder;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i2);
        sb5.append((char) 20998);
        sb4.append(sb5.toString());
        StringBuilder sb6 = this.mBuilder;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(i3);
        sb7.append((char) 31186);
        sb6.append(sb7.toString());
        if (!TextUtils.isEmpty(str2)) {
            this.mBuilder.append(str2);
        }
        String sb8 = this.mBuilder.toString();
        b41.h(sb8, "mBuilder.toString()");
        updateOrderStateMessage(sb8);
    }
}
