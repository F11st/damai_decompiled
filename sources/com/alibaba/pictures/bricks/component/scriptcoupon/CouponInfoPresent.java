package com.alibaba.pictures.bricks.component.scriptcoupon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.bean.CouponInfoBean;
import com.alibaba.pictures.bricks.bean.TicketNote;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoContract;
import com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.page.GenericFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jt1;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponInfoPresent extends AbsPresenter<GenericItem<ItemValue>, CouponInfoModel, CouponInfoView> implements CouponInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_KEY_SHARE = "share";
    @NotNull
    public static final String BANNER_HIDDEN = "0";
    @NotNull
    public static final String BANNER_SHOW = "1";
    @NotNull
    private static final String BANNER_STATUS = "BannerStatus";
    @NotNull
    public static final String CHANGE_BAR_EVENT = "EventBus://business/BannerStatus";
    public static final int COUPON_TOP_BANNER_TYPE = 7521;
    @NotNull
    public static final C3498a Companion = new C3498a(null);
    @NotNull
    public static final String NO_BANNER = "-1";
    @NotNull
    private String currentBannerStatus;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoPresent$a */
    /* loaded from: classes7.dex */
    public static final class C3498a {
        private C3498a() {
        }

        public /* synthetic */ C3498a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoPresent$b */
    /* loaded from: classes7.dex */
    public static final class C3499b implements CouponInfoViewHolder.OnScriptCouponInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C3499b() {
        }

        @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder.OnScriptCouponInfoListener
        public void onScriptCouponMoreBtnClick(@NotNull View view, @NotNull CouponInfoBean couponInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1220751361")) {
                ipChange.ipc$dispatch("1220751361", new Object[]{this, view, couponInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(couponInfoBean, "bean");
            List<TicketNote> serviceNoteList = couponInfoBean.getServiceNoteList();
            if (serviceNoteList != null) {
                new jt1().d(view, serviceNoteList, "服务说明");
            }
        }

        @Override // com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoViewHolder.OnScriptCouponInfoListener
        public void onScriptCouponViewExpose(@NotNull View view, @NotNull CouponInfoBean couponInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1432314489")) {
                ipChange.ipc$dispatch("1432314489", new Object[]{this, view, couponInfoBean});
                return;
            }
            b41.i(view, "itemView");
            b41.i(couponInfoBean, "bean");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.currentBannerStatus = "";
    }

    public final void disPatch(@NotNull String str, @NotNull HashMap<String, Object> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766547663")) {
            ipChange.ipc$dispatch("1766547663", new Object[]{this, str, hashMap});
            return;
        }
        b41.i(str, "msg");
        b41.i(hashMap, "arg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, hashMap);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704376592")) {
            return ((Boolean) ipChange.ipc$dispatch("704376592", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1394427133")) {
            return ((Boolean) ipChange.ipc$dispatch("-1394427133", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-538312507")) {
            return ((Boolean) ipChange.ipc$dispatch("-538312507", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @NotNull
    public final String getCurrentBannerStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1268954189") ? (String) ipChange.ipc$dispatch("1268954189", new Object[]{this}) : this.currentBannerStatus;
    }

    public final void setCurrentBannerStatus(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1937403703")) {
            ipChange.ipc$dispatch("-1937403703", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.currentBannerStatus = str;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull final GenericItem<ItemValue> genericItem) {
        Action action;
        RecyclerView recyclerView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38073236")) {
            ipChange.ipc$dispatch("-38073236", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((CouponInfoPresent) genericItem);
        final CouponInfoViewHolder viewHolder = ((CouponInfoView) getView()).getViewHolder();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Iterator<T> it = genericItem.getComponent().getModule().getComponents().iterator();
        while (it.hasNext()) {
            IComponent iComponent = (IComponent) it.next();
            if (iComponent.getType() == 7521) {
                List<IItem<ItemValue>> items = iComponent.getItems();
                if (!(items == null || items.isEmpty())) {
                    ref$BooleanRef.element = true;
                }
            }
        }
        if (!ref$BooleanRef.element && !b41.d(this.currentBannerStatus, "-1")) {
            HashMap<String, Object> hashMap = new HashMap<>();
            this.currentBannerStatus = "-1";
            hashMap.put("bannerStatus", "-1");
            disPatch(CHANGE_BAR_EVENT, hashMap);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        Bundle bundle = genericItem.getPageContext().getBundle();
        if (bundle != null) {
            ref$IntRef.element = Integer.valueOf(bundle.getInt("offset")).intValue();
        }
        if (!ref$BooleanRef.element) {
            viewHolder.e(ref$IntRef.element);
        } else {
            viewHolder.e(0);
        }
        GenericFragment fragment = genericItem.getPageContext().getFragment();
        if (fragment != null && (recyclerView = fragment.getRecyclerView()) != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(ref$IntRef, ref$BooleanRef, viewHolder, this, genericItem) { // from class: com.alibaba.pictures.bricks.component.scriptcoupon.CouponInfoPresent$init$3
                private static transient /* synthetic */ IpChange $ipChange;
                private int a;
                @NotNull
                private final HashMap<String, Object> b = new HashMap<>();
                final /* synthetic */ Ref$BooleanRef c;
                final /* synthetic */ CouponInfoViewHolder d;
                final /* synthetic */ CouponInfoPresent e;
                final /* synthetic */ GenericItem<ItemValue> f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.c = ref$BooleanRef;
                    this.d = viewHolder;
                    this.e = this;
                    this.f = genericItem;
                    this.a = ref$IntRef.element;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView2, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1833372191")) {
                        ipChange2.ipc$dispatch("-1833372191", new Object[]{this, recyclerView2, Integer.valueOf(i), Integer.valueOf(i2)});
                        return;
                    }
                    b41.i(recyclerView2, "recyclerView");
                    super.onScrolled(recyclerView2, i, i2);
                    if (this.c.element) {
                        this.b.put("hasTopBanner", Boolean.TRUE);
                    } else {
                        this.b.put("hasTopBanner", Boolean.FALSE);
                        this.a = 0;
                    }
                    if (this.d.itemView.getTop() < this.a) {
                        if (b41.d(this.e.getCurrentBannerStatus(), "0")) {
                            return;
                        }
                        Activity activity = this.f.getPageContext().getActivity();
                        if (activity != null) {
                            this.d.itemView.setBackgroundColor(ContextCompat.getColor(activity, 17170443));
                        }
                        this.e.setCurrentBannerStatus("0");
                        this.b.put("bannerStatus", this.e.getCurrentBannerStatus());
                        this.e.disPatch(CouponInfoPresent.CHANGE_BAR_EVENT, this.b);
                    } else if (b41.d(this.e.getCurrentBannerStatus(), "1")) {
                    } else {
                        Activity activity2 = this.f.getPageContext().getActivity();
                        if (activity2 != null) {
                            Ref$BooleanRef ref$BooleanRef2 = this.c;
                            CouponInfoViewHolder couponInfoViewHolder = this.d;
                            if (ref$BooleanRef2.element) {
                                couponInfoViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(activity2, 17170445));
                            } else {
                                couponInfoViewHolder.itemView.setBackgroundColor(ContextCompat.getColor(activity2, R$color.bricks_825542));
                            }
                        }
                        this.e.setCurrentBannerStatus("1");
                        this.b.put("bannerStatus", this.e.getCurrentBannerStatus());
                        this.e.disPatch(CouponInfoPresent.CHANGE_BAR_EVENT, this.b);
                    }
                }
            });
        }
        viewHolder.d(new C3499b());
        viewHolder.b(((CouponInfoModel) getModel()).getValue());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("value", ((CouponInfoModel) getModel()).getValue());
        Map<String, Action> actions = getActions();
        if (actions != null && (action = actions.get("share")) != null) {
            hashMap2.put("share", action);
        }
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent("EventBus://business/notification/scriptMurder/get_header_info", hashMap2);
        }
    }
}
