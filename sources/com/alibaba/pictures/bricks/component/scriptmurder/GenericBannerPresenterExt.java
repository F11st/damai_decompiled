package com.alibaba.pictures.bricks.component.scriptmurder;

import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt;
import com.alibaba.pictures.bricks.util.DMRGBUtil;
import com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProvider;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.AbsPresenter;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class GenericBannerPresenterExt extends BaseBannerPresenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3501a Companion = new C3501a(null);
    @NotNull
    public static final String MSG_BANNER_ATTACHED = "EventBus://business/notification/msg_banner_attached";
    @NotNull
    public static final String MSG_BANNER_BG_UPDATE = "EventBus://business/notification/msg_banner_bg_update";
    @NotNull
    public static final String MSG_BANNER_DETACHED = "EventBus://business/notification/msg_banner_detached";
    @NotNull
    public static final String PRE_STICKY_HEADER = "EventBus://business/";
    @Nullable
    private GenericItem<ItemValue> lastItem;
    @NotNull
    private String totalSize;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerPresenterExt$a */
    /* loaded from: classes7.dex */
    public static final class C3501a {
        private C3501a() {
        }

        public /* synthetic */ C3501a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenericBannerPresenterExt(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
        this.totalSize = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-5  reason: not valid java name */
    public static final void m159init$lambda10$lambda9$lambda8$lambda7$lambda5(Object obj, final GenericBannerPresenterExt genericBannerPresenterExt, final GenericItem genericItem, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1387316362")) {
            ipChange.ipc$dispatch("-1387316362", new Object[]{obj, genericBannerPresenterExt, genericItem, successEvent});
            return;
        }
        b41.i(obj, "$it1");
        b41.i(genericBannerPresenterExt, "this$0");
        b41.i(genericItem, "$item");
        if ((successEvent != null ? successEvent.bitmap : null) == null) {
            return;
        }
        DMRGBUtil.f(1.0f, successEvent.bitmap, (String) obj, new DMRGBUtil.OnFetchColorListener() { // from class: tb.kt0
            @Override // com.alibaba.pictures.bricks.util.DMRGBUtil.OnFetchColorListener
            public final void onFetchColor(int i) {
                GenericBannerPresenterExt.m160init$lambda10$lambda9$lambda8$lambda7$lambda5$lambda4(GenericBannerPresenterExt.this, genericItem, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-5$lambda-4  reason: not valid java name */
    public static final void m160init$lambda10$lambda9$lambda8$lambda7$lambda5$lambda4(GenericBannerPresenterExt genericBannerPresenterExt, GenericItem genericItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458624073")) {
            ipChange.ipc$dispatch("458624073", new Object[]{genericBannerPresenterExt, genericItem, Integer.valueOf(i)});
            return;
        }
        b41.i(genericBannerPresenterExt, "this$0");
        b41.i(genericItem, "$item");
        V view = genericBannerPresenterExt.getView();
        b41.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
        ((GenericBannerViewExt) view).setBgColor(i);
        HashMap hashMap = new HashMap();
        hashMap.put("color", Integer.valueOf(i));
        EventDispatcher eventDispatcher = genericItem.getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(MSG_BANNER_BG_UPDATE, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: init$lambda-10$lambda-9$lambda-8$lambda-7$lambda-6  reason: not valid java name */
    public static final void m161init$lambda10$lambda9$lambda8$lambda7$lambda6(FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416222902")) {
            ipChange.ipc$dispatch("-1416222902", new Object[]{failEvent});
            return;
        }
        Log.e(AbsPresenter.TAG, "DMImageCreator.FailEvent: " + failEvent.resultCode);
    }

    public final void disPatch(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773303994")) {
            ipChange.ipc$dispatch("1773303994", new Object[]{this, str});
            return;
        }
        b41.i(str, "msg");
        EventDispatcher eventDispatcher = ((GenericItem) getItem()).getPageContext().getEventDispatcher();
        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(str, null);
        }
    }

    @Nullable
    public final GenericItem<ItemValue> getLastItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-404385567") ? (GenericItem) ipChange.ipc$dispatch("-404385567", new Object[]{this}) : this.lastItem;
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.component.banner.base.BaseBannerContract.Presenter
    public void onPageChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1372699465")) {
            ipChange.ipc$dispatch("1372699465", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onPageChanged(i);
        V view = getView();
        b41.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
        ((GenericBannerViewExt) view).updateImgLength(this.totalSize, String.valueOf(i + 1));
    }

    public final void setLastItem(@Nullable GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146429541")) {
            ipChange.ipc$dispatch("-146429541", new Object[]{this, genericItem});
        } else {
            this.lastItem = genericItem;
        }
    }

    @Override // com.alient.onearch.adapter.component.banner.base.BaseBannerPresenter, com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull final GenericItem<ItemValue> genericItem) {
        Node node;
        List<Node> children;
        Node node2;
        List<Node> children2;
        Node node3;
        JSONObject data;
        Node node4;
        List<Node> children3;
        List<Node> children4;
        Node node5;
        JSONObject data2;
        final Object obj;
        ImageLoaderProvider proxy;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2075690582")) {
            ipChange.ipc$dispatch("2075690582", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init(genericItem);
        if (this.lastItem == genericItem) {
            return;
        }
        this.lastItem = genericItem;
        IContainer<ModelValue> container = genericItem.getContainer();
        ModelValue property = container != null ? container.getProperty() : null;
        b41.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
        List<Node> children5 = property.getChildren();
        if (children5 != null) {
            if (children5.isEmpty()) {
                children5 = null;
            }
            if (children5 != null && (node4 = children5.get(0)) != null && (children3 = node4.getChildren()) != null) {
                for (Node node6 : children3) {
                    if (node6.getType() == 9994 && (children4 = node6.getChildren()) != null) {
                        if (children4.isEmpty()) {
                            children4 = null;
                        }
                        if (children4 != null) {
                            String valueOf = String.valueOf(children4.size());
                            this.totalSize = valueOf;
                            V view = getView();
                            b41.g(view, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
                            ((GenericBannerViewExt) view).updateImgLength(valueOf, "1");
                            if (children4.isEmpty()) {
                                children4 = null;
                            }
                            if (children4 != null && (node5 = children4.get(0)) != null && (data2 = node5.getData()) != null && (obj = data2.get("url")) != null && (proxy = ImageLoaderProviderProxy.getProxy()) != null) {
                                b41.g(obj, "null cannot be cast to non-null type kotlin.String");
                                proxy.load((String) obj, new IImageSuccListener() { // from class: tb.mt0
                                    @Override // com.alient.oneservice.image.IImageSuccListener
                                    public final void onSuccess(SuccessEvent successEvent) {
                                        GenericBannerPresenterExt.m159init$lambda10$lambda9$lambda8$lambda7$lambda5(obj, this, genericItem, successEvent);
                                    }
                                }, new IImageFailListener() { // from class: tb.lt0
                                    @Override // com.alient.oneservice.image.IImageFailListener
                                    public final void onFail(FailEvent failEvent) {
                                        GenericBannerPresenterExt.m161init$lambda10$lambda9$lambda8$lambda7$lambda6(failEvent);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
        IContainer<ModelValue> container2 = genericItem.getContainer();
        ModelValue property2 = container2 != null ? container2.getProperty() : null;
        b41.g(property2, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
        List<Node> children6 = property2.getChildren();
        if (children6 != null) {
            if (!(!children6.isEmpty() && children6.size() >= 2)) {
                children6 = null;
            }
            if (children6 == null || (node = children6.get(1)) == null || (children = node.getChildren()) == null) {
                return;
            }
            if (children.isEmpty()) {
                children = null;
            }
            if (children == null || (node2 = children.get(0)) == null || (children2 = node2.getChildren()) == null) {
                return;
            }
            List<Node> list = children2.isEmpty() ? null : children2;
            if (list == null || (node3 = list.get(0)) == null || (data = node3.getData()) == null) {
                return;
            }
            Object parseObject = JSON.parseObject(data.toJSONString(), ShopInfoBean.class);
            V view2 = getView();
            b41.g(view2, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.scriptmurder.GenericBannerViewExt");
            b41.h(parseObject, "shopInfoBean");
            ((GenericBannerViewExt) view2).showOrderTitle((ShopInfoBean) parseObject);
        }
    }
}
