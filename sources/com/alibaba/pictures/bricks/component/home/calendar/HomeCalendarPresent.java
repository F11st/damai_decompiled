package com.alibaba.pictures.bricks.component.home.calendar;

import android.view.View;
import com.alibaba.pictures.bricks.bean.HomeCalendarBean;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract;
import com.alibaba.pictures.bricks.onearch.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeCalendarPresent extends AbsPresenter<GenericItem<ItemValue>, HomeCalendarModel, HomeCalendarView> implements HomeCalendarContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C3467a Companion = new C3467a(null);
    private static int DISPATCH_INDEX;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarPresent$a */
    /* loaded from: classes7.dex */
    public static final class C3467a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3467a() {
        }

        public /* synthetic */ C3467a(k50 k50Var) {
            this();
        }

        public final void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-447716524")) {
                ipChange.ipc$dispatch("-447716524", new Object[]{this, Integer.valueOf(i)});
            } else {
                HomeCalendarPresent.DISPATCH_INDEX = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCalendarPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2132183242") ? ((Boolean) ipChange.ipc$dispatch("2132183242", new Object[]{this})).booleanValue() : (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) ? false : true;
    }

    @Override // com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract.Present
    public void expose(@NotNull HomeCalendarBean homeCalendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1965649927")) {
            ipChange.ipc$dispatch("-1965649927", new Object[]{this, homeCalendarBean});
            return;
        }
        b41.i(homeCalendarBean, "bean");
        View renderView = ((HomeCalendarView) getView()).getRenderView();
        Action itemAction = getItemAction();
        UserTrackProviderProxy.expose(renderView, itemAction != null ? itemAction.getTrackInfo() : null);
    }

    @Override // com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract.Present
    public void onClick(@NotNull HomeCalendarBean homeCalendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-160902052")) {
            ipChange.ipc$dispatch("-160902052", new Object[]{this, homeCalendarBean});
            return;
        }
        b41.i(homeCalendarBean, "bean");
        Action action = new Action();
        action.setActionType(1);
        Action itemAction = getItemAction();
        action.setActionUrl(itemAction != null ? itemAction.getActionUrl() : null);
        NavProviderProxy.getProxy().toUri(((GenericItem) getItem()).getPageContext().getActivity(), action);
        Action itemAction2 = getItemAction();
        UserTrackProviderProxy.click(itemAction2 != null ? itemAction2.getTrackInfo() : null, true);
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter
    public void responsiveLayoutStateChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1104268655")) {
            ipChange.ipc$dispatch("-1104268655", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.responsiveLayoutStateChanged(z);
        ((HomeCalendarView) getView()).changeScreenMode(isLargeScreenMode());
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279253596")) {
            ipChange.ipc$dispatch("1279253596", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((HomeCalendarPresent) genericItem);
        ((HomeCalendarModel) getModel()).getValue().type = genericItem.getType();
        ((HomeCalendarModel) getModel()).getValue().dispatchIndex = DISPATCH_INDEX;
        if (b41.d(((HomeCalendarModel) getModel()).getValue().cardType, "PERFORMANCE_DISPATCH")) {
            DISPATCH_INDEX++;
        }
        HomeCalendarBean value = ((HomeCalendarModel) getModel()).getValue();
        b41.h(value, "model.value");
        ((HomeCalendarView) getView()).bindView(value);
    }
}
