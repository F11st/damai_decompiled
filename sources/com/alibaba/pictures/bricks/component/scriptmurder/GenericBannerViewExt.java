package com.alibaba.pictures.bricks.component.scriptmurder;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.OrderItem;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alient.onearch.adapter.component.banner.base.BaseBannerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GenericBannerViewExt extends BaseBannerView {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private AlphaAnimation dismisAni;
    private int index;
    private boolean playFinished;
    @NotNull
    private AlphaAnimation showAni;
    public View titlell;
    @NotNull
    private final View view;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt$a */
    /* loaded from: classes7.dex */
    public static final class View$OnAttachStateChangeListenerC3502a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnAttachStateChangeListenerC3502a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View view) {
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768843699")) {
                ipChange.ipc$dispatch("-768843699", new Object[]{this, view});
                return;
            }
            P presenter = GenericBannerViewExt.this.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt");
            ((GenericBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_ATTACHED);
            if (GenericBannerViewExt.this.getPlayFinished() || GenericBannerViewExt.this.getIndex() == 0) {
                return;
            }
            GenericBannerViewExt.this.getTitlell().setVisibility(0);
            GenericBannerViewExt.this.getShowAni().reset();
            GenericBannerViewExt genericBannerViewExt = GenericBannerViewExt.this;
            if (genericBannerViewExt.getIndex() - 1 >= 0) {
                i = GenericBannerViewExt.this.getIndex();
            } else {
                GenericBannerViewExt genericBannerViewExt2 = GenericBannerViewExt.this;
                int index = genericBannerViewExt2.getIndex();
                genericBannerViewExt2.setIndex(index - 1);
                i = index;
            }
            genericBannerViewExt.setIndex(i);
            View titlell = GenericBannerViewExt.this.getTitlell();
            if (titlell != null) {
                titlell.startAnimation(GenericBannerViewExt.this.getShowAni());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-916086")) {
                ipChange.ipc$dispatch("-916086", new Object[]{this, view});
                return;
            }
            P presenter = GenericBannerViewExt.this.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt");
            ((GenericBannerPresenterExt) presenter).disPatch(GenericBannerPresenterExt.MSG_BANNER_DETACHED);
            AlphaAnimation showAni = GenericBannerViewExt.this.getShowAni();
            if (showAni != null) {
                showAni.cancel();
            }
            AlphaAnimation dismisAni = GenericBannerViewExt.this.getDismisAni();
            if (dismisAni != null) {
                dismisAni.cancel();
            }
            GenericBannerViewExt.this.getTitlell().setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt$b  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class animationAnimation$AnimationListenerC3503b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$ObjectRef<ArrayList<OrderItem>> b;

        animationAnimation$AnimationListenerC3503b(Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef) {
            this.b = ref$ObjectRef;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "240022199")) {
                ipChange.ipc$dispatch("240022199", new Object[]{this, animation});
                return;
            }
            GenericBannerViewExt.this.getTitlell().setVisibility(8);
            if (GenericBannerViewExt.this.getIndex() >= this.b.element.size()) {
                GenericBannerViewExt.this.setPlayFinished(true);
            } else {
                GenericBannerViewExt.this.getTitlell().startAnimation(GenericBannerViewExt.this.getShowAni());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1131823779")) {
                ipChange.ipc$dispatch("-1131823779", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1523266640")) {
                ipChange.ipc$dispatch("1523266640", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt$c  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class animationAnimation$AnimationListenerC3504c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Ref$ObjectRef<ArrayList<OrderItem>> b;

        animationAnimation$AnimationListenerC3504c(Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef) {
            this.b = ref$ObjectRef;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "933414904")) {
                ipChange.ipc$dispatch("933414904", new Object[]{this, animation});
                return;
            }
            GenericBannerViewExt.this.getTitlell().setVisibility(8);
            if (GenericBannerViewExt.this.getIndex() > this.b.element.size()) {
                return;
            }
            GenericBannerViewExt.this.getTitlell().startAnimation(GenericBannerViewExt.this.getDismisAni());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1232524412")) {
                ipChange.ipc$dispatch("1232524412", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            OrderItem orderItem;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2141242031")) {
                ipChange.ipc$dispatch("-2141242031", new Object[]{this, animation});
            } else if (GenericBannerViewExt.this.getIndex() >= this.b.element.size()) {
            } else {
                GenericBannerViewExt.this.getTitlell().setVisibility(0);
                View titlell = GenericBannerViewExt.this.getTitlell();
                Ref$ObjectRef<ArrayList<OrderItem>> ref$ObjectRef = this.b;
                GenericBannerViewExt genericBannerViewExt = GenericBannerViewExt.this;
                ArrayList<OrderItem> arrayList = ref$ObjectRef.element;
                ArrayList<OrderItem> arrayList2 = arrayList;
                if (!((arrayList2.isEmpty() ^ true) && arrayList2.size() > genericBannerViewExt.getIndex())) {
                    arrayList = null;
                }
                ArrayList<OrderItem> arrayList3 = arrayList;
                if (arrayList3 != null && (orderItem = arrayList3.get(genericBannerViewExt.getIndex())) != null) {
                    titlell.setVisibility(0);
                    TextView textView = (TextView) titlell.findViewById(R$id.common_navbar_info_title);
                    if (textView != null) {
                        textView.setText(orderItem.getNickName() + ' ' + orderItem.getText());
                    }
                    TextView textView2 = (TextView) titlell.findViewById(R$id.common_navbar_info_desc);
                    if (textView2 != null) {
                        textView2.setText(orderItem.getTime());
                    }
                }
                GenericBannerViewExt genericBannerViewExt2 = GenericBannerViewExt.this;
                genericBannerViewExt2.setIndex(genericBannerViewExt2.getIndex() + 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericBannerViewExt(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        this.showAni = new AlphaAnimation(0.0f, 1.0f);
        this.dismisAni = new AlphaAnimation(1.0f, 0.0f);
    }

    @NotNull
    public final AlphaAnimation getDismisAni() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1278916118") ? (AlphaAnimation) ipChange.ipc$dispatch("1278916118", new Object[]{this}) : this.dismisAni;
    }

    public final int getIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806591180") ? ((Integer) ipChange.ipc$dispatch("-806591180", new Object[]{this})).intValue() : this.index;
    }

    public final boolean getPlayFinished() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2111148117") ? ((Boolean) ipChange.ipc$dispatch("2111148117", new Object[]{this})).booleanValue() : this.playFinished;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    @NotNull
    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1093361210")) {
            return (RecyclerView) ipChange.ipc$dispatch("1093361210", new Object[]{this});
        }
        View findViewById = this.view.findViewById(R$id.common_top_banner_container);
        b41.g(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) findViewById;
    }

    @NotNull
    public final AlphaAnimation getShowAni() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1525857398") ? (AlphaAnimation) ipChange.ipc$dispatch("-1525857398", new Object[]{this}) : this.showAni;
    }

    @NotNull
    public final View getTitlell() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299557251")) {
            return (View) ipChange.ipc$dispatch("-299557251", new Object[]{this});
        }
        View view = this.titlell;
        if (view != null) {
            return view;
        }
        b41.A("titlell");
        return null;
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1159621332") ? (View) ipChange.ipc$dispatch("1159621332", new Object[]{this}) : this.view;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerView, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109084439")) {
            ipChange.ipc$dispatch("1109084439", new Object[]{this, recycledViewPool, map});
            return;
        }
        super.initRecyclerSettings(recycledViewPool, map);
        ((RelativeLayout) this.view.findViewById(R$id.common_top_banner_bottombg)).setBackground(new ColorDrawable(Color.parseColor("#825542")));
        View findViewById = this.view.findViewById(R$id.common_navbar_infoll);
        b41.h(findViewById, "view.findViewById<View>(R.id.common_navbar_infoll)");
        setTitlell(findViewById);
        this.view.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC3502a());
    }

    public final void setBgColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285548578")) {
            ipChange.ipc$dispatch("285548578", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((RelativeLayout) this.view.findViewById(R$id.common_top_banner_bottombg)).setBackgroundColor(i);
        }
    }

    public final void setDismisAni(@NotNull AlphaAnimation alphaAnimation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "631149274")) {
            ipChange.ipc$dispatch("631149274", new Object[]{this, alphaAnimation});
            return;
        }
        b41.i(alphaAnimation, "<set-?>");
        this.dismisAni = alphaAnimation;
    }

    public final void setIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1980467626")) {
            ipChange.ipc$dispatch("-1980467626", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.index = i;
        }
    }

    public final void setPlayFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522600017")) {
            ipChange.ipc$dispatch("-522600017", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.playFinished = z;
        }
    }

    public final void setShowAni(@NotNull AlphaAnimation alphaAnimation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738524954")) {
            ipChange.ipc$dispatch("-738524954", new Object[]{this, alphaAnimation});
            return;
        }
        b41.i(alphaAnimation, "<set-?>");
        this.showAni = alphaAnimation;
    }

    public final void setTitlell(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154746261")) {
            ipChange.ipc$dispatch("-1154746261", new Object[]{this, view});
            return;
        }
        b41.i(view, "<set-?>");
        this.titlell = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.util.ArrayList] */
    public final void showOrderTitle(@NotNull ShopInfoBean shopInfoBean) {
        OrderItem orderItem;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-995601380")) {
            ipChange.ipc$dispatch("-995601380", new Object[]{this, shopInfoBean});
            return;
        }
        b41.i(shopInfoBean, "shopInfo");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? orders = shopInfoBean.getOrders();
        ref$ObjectRef.element = orders;
        this.index = 0;
        if (orders != 0 && ((ArrayList) orders).size() != 0) {
            this.showAni.setDuration(1000L);
            this.showAni.setStartOffset(1000L);
            this.dismisAni.setDuration(1000L);
            this.dismisAni.setStartOffset(1000L);
            this.dismisAni.setFillAfter(true);
            this.dismisAni.setAnimationListener(new animationAnimation$AnimationListenerC3503b(ref$ObjectRef));
            this.showAni.setAnimationListener(new animationAnimation$AnimationListenerC3504c(ref$ObjectRef));
            View titlell = getTitlell();
            Object obj = ref$ObjectRef.element;
            ArrayList arrayList = (ArrayList) obj;
            ArrayList arrayList2 = (ArrayList) ((!(arrayList.isEmpty() ^ true) || arrayList.size() <= this.index) ? false : false ? obj : null);
            if (arrayList2 == null || (orderItem = (OrderItem) arrayList2.get(this.index)) == null) {
                return;
            }
            titlell.setVisibility(0);
            TextView textView = (TextView) titlell.findViewById(R$id.common_navbar_info_title);
            if (textView != null) {
                textView.setText(orderItem.getNickName() + ' ' + orderItem.getText());
            }
            TextView textView2 = (TextView) titlell.findViewById(R$id.common_navbar_info_desc);
            if (textView2 != null) {
                textView2.setText(orderItem.getTime());
            }
            titlell.startAnimation(this.showAni);
            return;
        }
        this.showAni.setAnimationListener(null);
        this.dismisAni.setAnimationListener(null);
        getTitlell().clearAnimation();
        getTitlell().setVisibility(8);
        this.index = 0;
        this.playFinished = false;
    }

    public final void updateImgLength(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345783583")) {
            ipChange.ipc$dispatch("-1345783583", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "size");
        b41.i(str2, "pos");
        try {
            if (Integer.parseInt(str) <= 1) {
                View findViewById = this.view.findViewById(R$id.common_img_count_info);
                if (findViewById == null) {
                    return;
                }
                findViewById.setVisibility(8);
                return;
            }
            View findViewById2 = this.view.findViewById(R$id.common_img_count_info);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            TextView textView = (TextView) this.view.findViewById(R$id.common_img_count_info_title);
            if (textView == null) {
                return;
            }
            textView.setText(str2 + r10.DIR + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
