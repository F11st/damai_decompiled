package com.alibaba.pictures.bricks.component.home.welfare;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerContract;
import com.alibaba.pictures.ut.ClickCat;
import com.alibaba.pictures.ut.DogCat;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeWelfareContainerView extends GenericHorizontalView implements HomeWelfareContainerContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ImageView bgLayout;
    @NotNull
    private final View itemView;
    private final TextView welfareDesc;
    private final View welfareDescIcon;
    private final LinearLayout welfareDescParent;
    private final ImageView welfareTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeWelfareContainerView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.bgLayout = (ImageView) view.findViewById(R$id.bricks_welfare_layout);
        this.welfareTitle = (ImageView) view.findViewById(R$id.bricks_welfare_title);
        this.welfareDesc = (TextView) view.findViewById(R$id.welfare_desc);
        this.welfareDescParent = (LinearLayout) view.findViewById(R$id.welfare_desc_parent);
        this.welfareDescIcon = view.findViewById(R$id.welfare_desc_right_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-5$lambda-4$lambda-2$lambda-1  reason: not valid java name */
    public static final void m148bindView$lambda10$lambda5$lambda4$lambda2$lambda1(JSONObject jSONObject, String str, HomeWelfareContainerView homeWelfareContainerView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334600465")) {
            ipChange.ipc$dispatch("-1334600465", new Object[]{jSONObject, str, homeWelfareContainerView, view});
            return;
        }
        b41.i(jSONObject, "$this_actionNode");
        b41.i(str, "$this_url");
        b41.i(homeWelfareContainerView, "this$0");
        JSONObject jSONObject2 = jSONObject.getJSONObject("trackInfo");
        if (jSONObject2 != null) {
            ClickCat d = DogCat.INSTANCE.d();
            P presenter = homeWelfareContainerView.getPresenter();
            b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerPresent");
            d.n(((GenericItem) ((HomeWelfareContainerPresent) presenter).getItem()).getPageContext().getPageName()).r(jSONObject2.getString("spmc"), jSONObject2.getString("spmd")).j();
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(str);
        NavProviderProxy.getProxy().toUri(homeWelfareContainerView.itemView.getContext(), action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-6  reason: not valid java name */
    public static final void m149bindView$lambda10$lambda6(HomeWelfareContainerView homeWelfareContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956171395")) {
            ipChange.ipc$dispatch("-1956171395", new Object[]{homeWelfareContainerView, successEvent});
            return;
        }
        b41.i(homeWelfareContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeWelfareContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_welfare_bg);
        } else {
            homeWelfareContainerView.bgLayout.setBackground(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-7  reason: not valid java name */
    public static final void m150bindView$lambda10$lambda7(HomeWelfareContainerView homeWelfareContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748546335")) {
            ipChange.ipc$dispatch("1748546335", new Object[]{homeWelfareContainerView, failEvent});
            return;
        }
        b41.i(homeWelfareContainerView, "this$0");
        homeWelfareContainerView.bgLayout.setBackgroundResource(R$drawable.bricks_welfare_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-8  reason: not valid java name */
    public static final void m151bindView$lambda10$lambda8(HomeWelfareContainerView homeWelfareContainerView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1094337793")) {
            ipChange.ipc$dispatch("-1094337793", new Object[]{homeWelfareContainerView, successEvent});
            return;
        }
        b41.i(homeWelfareContainerView, "this$0");
        Drawable drawable = successEvent.drawable;
        if (drawable == null) {
            homeWelfareContainerView.welfareTitle.setImageResource(R$drawable.bricks_welfare_title);
            return;
        }
        homeWelfareContainerView.welfareTitle.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = homeWelfareContainerView.welfareTitle.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int width = successEvent.bitmap.getWidth();
        s60 s60Var = s60.INSTANCE;
        Context context = homeWelfareContainerView.itemView.getContext();
        b41.h(context, "itemView.context");
        layoutParams.width = (width * s60Var.b(context, 14)) / successEvent.bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-10$lambda-9  reason: not valid java name */
    public static final void m152bindView$lambda10$lambda9(HomeWelfareContainerView homeWelfareContainerView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655911133")) {
            ipChange.ipc$dispatch("655911133", new Object[]{homeWelfareContainerView, failEvent});
            return;
        }
        b41.i(homeWelfareContainerView, "this$0");
        homeWelfareContainerView.welfareTitle.setImageResource(R$drawable.bricks_welfare_title);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    @Override // com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindView(@org.jetbrains.annotations.Nullable com.alibaba.fastjson.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerView.bindView(com.alibaba.fastjson.JSONObject):void");
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806492661") ? (View) ipChange.ipc$dispatch("-806492661", new Object[]{this}) : this.itemView;
    }
}
