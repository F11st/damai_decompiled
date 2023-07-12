package com.alibaba.pictures.bricks.component.home;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.pictures.bricks.bean.NestedBannerBean;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.onearch.adapter.view.GenericViewCard;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBannerPresent extends AbsPresenter<GenericItem<ItemValue>, NestedBannerModel, NestedBannerView> implements OnBannerListener {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.NestedBannerPresent$a */
    /* loaded from: classes7.dex */
    public static final class C3456a extends TypeReference<HashMap<String, Action>> {
        C3456a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBannerPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final HashMap<String, Action> getActions(NestedBannerBean nestedBannerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263394102")) {
            return (HashMap) ipChange.ipc$dispatch("-1263394102", new Object[]{this, nestedBannerBean});
        }
        try {
            JSONObject jSONObject = nestedBannerBean.action;
            if (jSONObject != null) {
                return (HashMap) JSON.parseObject(jSONObject.toJSONString(), new C3456a(), new Feature[0]);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Action getItemAction(NestedBannerBean nestedBannerBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666077732")) {
            return (Action) ipChange.ipc$dispatch("-666077732", new Object[]{this, nestedBannerBean});
        }
        try {
            HashMap<String, Action> actions = getActions(nestedBannerBean);
            if (actions != null) {
                return actions.get("item");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2045445051") ? ((Boolean) ipChange.ipc$dispatch("2045445051", new Object[]{this})).booleanValue() : (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) ? false : true;
    }

    private final void setScreenModeIfScreenChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447827879")) {
            ipChange.ipc$dispatch("-447827879", new Object[]{this});
            return;
        }
        boolean isLargeScreenMode = isLargeScreenMode();
        if (isLargeScreenMode != ((NestedBannerView) getView()).isLargeScreenMode()) {
            ((NestedBannerView) getView()).setScreenMode(isLargeScreenMode);
        }
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515991170")) {
            return ((Boolean) ipChange.ipc$dispatch("1515991170", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-509658330")) {
            return ((Boolean) ipChange.ipc$dispatch("-509658330", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
    public void onBannerItemClick(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
        boolean p;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1925842507")) {
            ipChange.ipc$dispatch("-1925842507", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "view");
        b41.i(nestedBannerBean, "bean");
        Activity activity = ((GenericItem) getItem()).getPageContext().getActivity();
        if (activity != null) {
            GenericViewCard genericViewCard = nestedBannerBean.temp;
            if ((genericViewCard != null ? genericViewCard.getItemAction() : null) != null) {
                genericViewCard.onItemClick(view);
                return;
            }
            Action itemAction = getItemAction(nestedBannerBean);
            if (itemAction != null) {
                NavProviderProxy.getProxy().toUri(activity, itemAction);
                TrackInfo trackInfo = itemAction.getTrackInfo();
                if (trackInfo != null) {
                    b41.h(trackInfo, "trackInfo");
                    if (trackInfo.getSpmd() != null) {
                        String spmd = trackInfo.getSpmd();
                        b41.h(spmd, "spmd");
                        p = C8604o.p(spmd, JSMethod.NOT_SET, false, 2, null);
                        if (p) {
                            trackInfo.setSpmd(trackInfo.getSpmd() + i);
                        }
                    }
                    UserTrackProviderProxy.click(view, trackInfo, true);
                }
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.OnBannerListener
    public void onBannerViewExpose(@NotNull View view, @NotNull NestedBannerBean nestedBannerBean, int i) {
        TrackInfo trackInfo;
        boolean p;
        Action itemAction;
        TrackInfo trackInfo2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102120701")) {
            ipChange.ipc$dispatch("-102120701", new Object[]{this, view, nestedBannerBean, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "view");
        b41.i(nestedBannerBean, "bean");
        GenericViewCard genericViewCard = nestedBannerBean.temp;
        if ((genericViewCard != null ? genericViewCard.getItemAction() : null) != null) {
            GenericViewCard genericViewCard2 = nestedBannerBean.temp;
            if (genericViewCard2 == null || (itemAction = genericViewCard2.getItemAction()) == null || (trackInfo2 = itemAction.getTrackInfo()) == null) {
                return;
            }
            b41.h(trackInfo2, "trackInfo");
            UserTrackProviderProxy.expose(view, trackInfo2);
            return;
        }
        Action itemAction2 = getItemAction(nestedBannerBean);
        if (itemAction2 == null || (trackInfo = itemAction2.getTrackInfo()) == null) {
            return;
        }
        b41.h(trackInfo, "trackInfo");
        if (trackInfo.getSpmd() != null) {
            String spmd = trackInfo.getSpmd();
            b41.h(spmd, "spmd");
            p = C8604o.p(spmd, JSMethod.NOT_SET, false, 2, null);
            if (p) {
                trackInfo.setSpmd(trackInfo.getSpmd() + i);
            }
        }
        UserTrackProviderProxy.expose(view, trackInfo);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter
    public void responsiveLayoutStateChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "359975938")) {
            ipChange.ipc$dispatch("359975938", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.responsiveLayoutStateChanged(z);
        setScreenModeIfScreenChanged();
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        List<IItem<ItemValue>> list;
        Node node;
        JSONObject data;
        NestedBannerBean nestedBannerBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2016375757")) {
            ipChange.ipc$dispatch("2016375757", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((NestedBannerPresent) genericItem);
        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> innerAdapter = genericItem.getComponent().getInnerAdapter();
        if (innerAdapter == null || (list = innerAdapter.data) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            IItem iItem = (IItem) it.next();
            if ((iItem instanceof GenericItem) && (node = ((GenericItem) iItem).getNode()) != null && node.getType() == 7538 && (data = node.getData()) != null && (nestedBannerBean = (NestedBannerBean) ap2.INSTANCE.j(data, NestedBannerBean.class)) != null) {
                try {
                    HashMap<String, Action> actions = getActions(nestedBannerBean);
                    if (actions != null) {
                        nestedBannerBean.temp = new GenericViewCard(this, iItem, actions, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                arrayList.add(nestedBannerBean);
            }
        }
        ((NestedBannerView) getView()).setMBannerListener(this);
        setScreenModeIfScreenChanged();
        ((NestedBannerView) getView()).bind(arrayList);
    }
}
