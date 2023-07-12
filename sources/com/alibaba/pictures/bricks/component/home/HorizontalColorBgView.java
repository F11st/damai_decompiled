package com.alibaba.pictures.bricks.component.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.home.HorizontalColorBgContract;
import com.alibaba.pictures.bricks.component.home.HorizontalColorBgView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.onearch.adapter.component.horizontal.GenericHorizontalView;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HorizontalColorBgView extends GenericHorizontalView implements HorizontalColorBgContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RoundRadiusImageView bgImg;
    @NotNull
    private final View itemView;
    @NotNull
    private final TextView subTitle;
    @NotNull
    private final View subTitleImg;
    @NotNull
    private final ImageView titlePic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalColorBgView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.bricks_horizontal_layout_title);
        b41.h(findViewById, "itemView.findViewById(R.…_horizontal_layout_title)");
        this.titlePic = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.bricks_horizontal_layout_more);
        b41.h(findViewById2, "itemView.findViewById(R.…s_horizontal_layout_more)");
        this.subTitle = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.bricks_horizontal_layout_moreimg);
        b41.h(findViewById3, "itemView.findViewById(R.…orizontal_layout_moreimg)");
        this.subTitleImg = findViewById3;
        View findViewById4 = view.findViewById(R$id.bricks_horizontal_layout_bg);
        b41.h(findViewById4, "itemView.findViewById(R.…cks_horizontal_layout_bg)");
        this.bgImg = (RoundRadiusImageView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-13$lambda-12  reason: not valid java name */
    public static final void m120bindView$lambda13$lambda12(Object obj, HorizontalColorBgView horizontalColorBgView, View view) {
        Action action;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736273701")) {
            ipChange.ipc$dispatch("-736273701", new Object[]{obj, horizontalColorBgView, view});
            return;
        }
        b41.i(obj, "$this_apply");
        b41.i(horizontalColorBgView, "this$0");
        Action action2 = new Action();
        action2.setActionType(1);
        action2.setActionUrl((String) obj);
        NavProviderProxy.getProxy().toUri(horizontalColorBgView.itemView.getContext(), action2);
        P presenter = horizontalColorBgView.getPresenter();
        b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.HorizontalColorBgPresent");
        Map<String, Action> componentActions = ((HorizontalColorBgPresent) presenter).getComponentActions();
        if (componentActions == null || (action = componentActions.get("item")) == null) {
            return;
        }
        action.getTrackInfo().setSpmd("all");
        UserTrackProviderProxy.click(action.getTrackInfo(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-3$lambda-1  reason: not valid java name */
    public static final void m121bindView$lambda3$lambda1(Object obj, HorizontalColorBgView horizontalColorBgView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1498426360")) {
            ipChange.ipc$dispatch("1498426360", new Object[]{obj, horizontalColorBgView, successEvent});
            return;
        }
        b41.i(obj, "$this_apply");
        b41.i(horizontalColorBgView, "this$0");
        if ((successEvent != null ? successEvent.drawable : null) != null) {
            Log.d("debugtitle", ' ' + obj + " === success: ");
            horizontalColorBgView.titlePic.setVisibility(0);
            horizontalColorBgView.titlePic.setImageDrawable(successEvent.drawable);
            return;
        }
        horizontalColorBgView.titlePic.setImageDrawable(horizontalColorBgView.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        horizontalColorBgView.titlePic.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-3$lambda-2  reason: not valid java name */
    public static final void m122bindView$lambda3$lambda2(HorizontalColorBgView horizontalColorBgView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786839938")) {
            ipChange.ipc$dispatch("786839938", new Object[]{horizontalColorBgView, failEvent});
            return;
        }
        b41.i(horizontalColorBgView, "this$0");
        horizontalColorBgView.titlePic.setImageDrawable(horizontalColorBgView.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
        horizontalColorBgView.titlePic.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-7$lambda-5  reason: not valid java name */
    public static final void m123bindView$lambda7$lambda5(Object obj, HorizontalColorBgView horizontalColorBgView, SuccessEvent successEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-726993032")) {
            ipChange.ipc$dispatch("-726993032", new Object[]{obj, horizontalColorBgView, successEvent});
            return;
        }
        b41.i(obj, "$this_apply");
        b41.i(horizontalColorBgView, "this$0");
        if ((successEvent != null ? successEvent.bitmap : null) != null) {
            Log.d("debugtitle", ' ' + obj + " === success: ");
            horizontalColorBgView.titlePic.setVisibility(0);
            horizontalColorBgView.bgImg.setImageBitmap(successEvent.bitmap);
            return;
        }
        horizontalColorBgView.bgImg.setImageBitmap(null);
        horizontalColorBgView.bgImg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-7$lambda-6  reason: not valid java name */
    public static final void m124bindView$lambda7$lambda6(HorizontalColorBgView horizontalColorBgView, FailEvent failEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680313342")) {
            ipChange.ipc$dispatch("-680313342", new Object[]{horizontalColorBgView, failEvent});
            return;
        }
        b41.i(horizontalColorBgView, "this$0");
        horizontalColorBgView.bgImg.setImageBitmap(null);
        horizontalColorBgView.bgImg.setVisibility(8);
    }

    @Override // com.alibaba.pictures.bricks.component.home.HorizontalColorBgContract.View
    public void bindView(@Nullable JSONObject jSONObject) {
        final Object obj;
        Action action;
        final Object obj2;
        final Object obj3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500830894")) {
            ipChange.ipc$dispatch("1500830894", new Object[]{this, jSONObject});
            return;
        }
        this.titlePic.setVisibility(8);
        if ((jSONObject != null ? jSONObject.get("title") : null) == null) {
            this.titlePic.setImageDrawable(this.itemView.getContext().getDrawable(R$drawable.bricks_horicard_bg_titlepic));
            this.titlePic.setVisibility(0);
        }
        if (jSONObject != null && (obj3 = jSONObject.get("title")) != null) {
            ImageLoaderProviderProxy.getProxy().load((String) obj3, new IImageSuccListener() { // from class: tb.lz0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    HorizontalColorBgView.m121bindView$lambda3$lambda1(obj3, this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.iz0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    HorizontalColorBgView.m122bindView$lambda3$lambda2(HorizontalColorBgView.this, failEvent);
                }
            });
        }
        if (jSONObject != null && (obj2 = jSONObject.get("backgroundPic")) != null) {
            ImageLoaderProviderProxy.getProxy().load((String) obj2, new IImageSuccListener() { // from class: tb.kz0
                @Override // com.alient.oneservice.image.IImageSuccListener
                public final void onSuccess(SuccessEvent successEvent) {
                    HorizontalColorBgView.m123bindView$lambda7$lambda5(obj2, this, successEvent);
                }
            }, new IImageFailListener() { // from class: tb.jz0
                @Override // com.alient.oneservice.image.IImageFailListener
                public final void onFail(FailEvent failEvent) {
                    HorizontalColorBgView.m124bindView$lambda7$lambda6(HorizontalColorBgView.this, failEvent);
                }
            });
        }
        this.subTitle.setVisibility(8);
        this.subTitleImg.setVisibility(8);
        if (jSONObject == null || (obj = jSONObject.get("schema")) == null) {
            return;
        }
        if (((String) obj).length() == 0) {
            this.subTitle.setVisibility(8);
            this.subTitleImg.setVisibility(8);
            return;
        }
        this.subTitle.setVisibility(0);
        this.subTitleImg.setVisibility(0);
        P presenter = getPresenter();
        b41.g(presenter, "null cannot be cast to non-null type com.alibaba.pictures.bricks.component.home.HorizontalColorBgPresent");
        Map<String, Action> componentActions = ((HorizontalColorBgPresent) presenter).getComponentActions();
        if (componentActions != null && (action = componentActions.get("item")) != null) {
            action.getTrackInfo().setSpmd("all");
            UserTrackProviderProxy.expose(this.subTitle, action.getTrackInfo());
        }
        Object obj4 = jSONObject.get("all");
        if (obj4 != null) {
            TextView textView = this.subTitle;
            b41.g(obj4, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj4;
            String str2 = Boolean.valueOf(str.length() == 0).booleanValue() ? null : str;
            if (str2 == null) {
                str2 = "全部";
            }
            textView.setText(str2);
        }
        this.subTitle.setOnClickListener(new View.OnClickListener() { // from class: tb.hz0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HorizontalColorBgView.m120bindView$lambda13$lambda12(obj, this, view);
            }
        });
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1708425210") ? (View) ipChange.ipc$dispatch("1708425210", new Object[]{this}) : this.itemView;
    }

    @Override // com.alient.onearch.adapter.component.horizontal.GenericHorizontalView, com.alient.onearch.adapter.component.horizontal.GenericHorizontalContract.View
    public void initRecyclerSettings(@Nullable RecyclerView.RecycledViewPool recycledViewPool, @Nullable Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278672176")) {
            ipChange.ipc$dispatch("-278672176", new Object[]{this, recycledViewPool, map});
        } else {
            super.initRecyclerSettings(recycledViewPool, map);
        }
    }
}
