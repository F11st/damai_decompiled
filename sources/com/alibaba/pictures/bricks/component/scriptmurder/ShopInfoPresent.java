package com.alibaba.pictures.bricks.component.scriptmurder;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.alibaba.pictures.bricks.bean.BottomAction;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoContract;
import com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder;
import com.alibaba.pictures.bricks.view.BottomActionDialog;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ShopInfoPresent extends AbsPresenter<GenericItem<ItemValue>, ShopInfoModel, ShopInfoView> implements ShopInfoContract.Present {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ACTION_KEY_REPORT = "report";
    @NotNull
    public static final String ACTION_KEY_SHARE = "share";
    @NotNull
    public static final String ACTION_TO_AUTH = "certification";
    @NotNull
    public static final String ACTION_TO_CALL = "telephone";
    @NotNull
    public static final String ACTION_TO_EVALUATE = "score";
    @NotNull
    public static final String ACTION_TO_MAP = "map";
    @NotNull
    public static final String ACTION_TO_SHOP_INFO = "detail";
    @NotNull
    public static final C3505a Companion = new C3505a(null);

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoPresent$a */
    /* loaded from: classes7.dex */
    public static final class C3505a {
        private C3505a() {
        }

        public /* synthetic */ C3505a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoPresent$b */
    /* loaded from: classes7.dex */
    public static final class C3506b implements ShopInfoViewHolder.OnShopInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ GenericItem<ItemValue> b;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoPresent$b$a */
        /* loaded from: classes7.dex */
        public static final class C3507a implements BottomActionDialog.OnActionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ Activity a;
            final /* synthetic */ Ref$ObjectRef<Action> b;
            final /* synthetic */ View c;

            C3507a(Activity activity, Ref$ObjectRef<Action> ref$ObjectRef, View view) {
                this.a = activity;
                this.b = ref$ObjectRef;
                this.c = view;
            }

            @Override // com.alibaba.pictures.bricks.view.BottomActionDialog.OnActionListener
            public void onClick(@NotNull BottomAction bottomAction, @NotNull View view, @NotNull Dialog dialog) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-601845616")) {
                    ipChange.ipc$dispatch("-601845616", new Object[]{this, bottomAction, view, dialog});
                    return;
                }
                b41.i(bottomAction, "action");
                b41.i(view, "v");
                b41.i(dialog, "dialog");
                dialog.dismiss();
                ap2.INSTANCE.h(this.a, bottomAction.getExtra());
                Action action = this.b.element;
                if (action != null) {
                    View view2 = this.c;
                    TrackInfo trackInfo = action.getTrackInfo();
                    if (trackInfo != null) {
                        b41.h(trackInfo, "trackInfo");
                        UserTrackProviderProxy.click(view2, trackInfo, true);
                    }
                }
            }
        }

        C3506b(GenericItem<ItemValue> genericItem) {
            this.b = genericItem;
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onEvaluateEntranceBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-708776908")) {
                ipChange.ipc$dispatch("-708776908", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(shopInfoBean, "bean");
            ShopInfoPresent.this.dispatchActionQueryClick(this.b, "score", view);
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopAuthBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2101819579")) {
                ipChange.ipc$dispatch("-2101819579", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(shopInfoBean, "bean");
            ShopInfoPresent.this.dispatchActionQueryClick(this.b, ShopInfoPresent.ACTION_TO_AUTH, view);
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopInfoEntranceClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1010243949")) {
                ipChange.ipc$dispatch("1010243949", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(shopInfoBean, "bean");
            if (shopInfoBean.isShopOpened()) {
                ShopInfoPresent.this.dispatchActionQueryClick(this.b, "detail", view);
            }
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopInfoViewExpose(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1552947102")) {
                ipChange.ipc$dispatch("-1552947102", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "itemView");
            b41.i(shopInfoBean, "bean");
        }

        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopMapBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "74160457")) {
                ipChange.ipc$dispatch("74160457", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(shopInfoBean, "bean");
            ShopInfoPresent.this.dispatchActionQueryClick(this.b, "map", view);
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [T, com.alient.oneservice.nav.Action] */
        @Override // com.alibaba.pictures.bricks.component.scriptmurder.ShopInfoViewHolder.OnShopInfoListener
        public void onShopPhoneBtnClick(@NotNull View view, @NotNull ShopInfoBean shopInfoBean) {
            IpChange ipChange = $ipChange;
            boolean z = true;
            if (AndroidInstantRuntime.support(ipChange, "-1064953993")) {
                ipChange.ipc$dispatch("-1064953993", new Object[]{this, view, shopInfoBean});
                return;
            }
            b41.i(view, "view");
            b41.i(shopInfoBean, "bean");
            Activity activity = this.b.getPageContext().getActivity();
            if (activity != null) {
                ShopInfoPresent shopInfoPresent = ShopInfoPresent.this;
                if (activity.isFinishing()) {
                    return;
                }
                ArrayList<BottomAction> arrayList = null;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ?? action = shopInfoPresent.getAction("telephone");
                if (action != 0) {
                    ref$ObjectRef.element = action;
                    arrayList = ap2.INSTANCE.a(action.getActionUrl());
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    z = false;
                }
                ArrayList<BottomAction> callActionList = z ? shopInfoBean.getCallActionList() : arrayList;
                if (callActionList != null) {
                    new BottomActionDialog(activity, callActionList, new C3507a(activity, ref$ObjectRef, view), 0, 8, null).show();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopInfoPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchActionQueryClick(GenericItem<ItemValue> genericItem, String str, View view) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209466605")) {
            ipChange.ipc$dispatch("209466605", new Object[]{this, genericItem, str, view});
            return;
        }
        Activity activity = genericItem.getPageContext().getActivity();
        if (activity == null || (action = getAction(str)) == null) {
            return;
        }
        TrackInfo trackInfo = action.getTrackInfo();
        if (trackInfo != null) {
            b41.h(trackInfo, "trackInfo");
            UserTrackProviderProxy.click(view, trackInfo, true);
        }
        NavProviderProxy.getProxy().toUri(activity, action);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884965791")) {
            return ((Boolean) ipChange.ipc$dispatch("-884965791", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-272811564")) {
            return ((Boolean) ipChange.ipc$dispatch("-272811564", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-127968236")) {
            return ((Boolean) ipChange.ipc$dispatch("-127968236", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031219899")) {
            ipChange.ipc$dispatch("1031219899", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((ShopInfoPresent) genericItem);
        ShopInfoViewHolder viewHolder = ((ShopInfoView) getView()).getViewHolder();
        viewHolder.l(new C3506b(genericItem));
        viewHolder.k(((ShopInfoModel) getModel()).getValue());
        HashMap hashMap = new HashMap();
        hashMap.put("value", ((ShopInfoModel) getModel()).getValue());
        Map<String, Action> actions = getActions();
        if (actions != null) {
            Action action = actions.get("share");
            if (action != null) {
                hashMap.put("share", action);
            }
            Action action2 = actions.get("report");
            if (action2 != null) {
                hashMap.put("report", action2);
            }
        }
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent("EventBus://business/notification/scriptMurder/get_header_info", hashMap);
        }
    }
}
