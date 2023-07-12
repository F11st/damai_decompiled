package com.alibaba.pictures.bricks.component.text;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.component.text.FoldTextView;
import com.alibaba.pictures.bricks.component.text.FoldTextViewContract;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.alient.onearch.adapter.view.AbsPresenter;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.event.EventHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FoldTextViewPresent extends AbsPresenter<GenericItem<ItemValue>, FoldTextViewModel, FoldTextViewView> implements FoldTextViewContract.Present {
    private static transient /* synthetic */ IpChange $ipChange;
    public FoldTextView curentView;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements FoldTextView.OnChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alibaba.pictures.bricks.component.text.FoldTextView.OnChangeListener
        public void onChanged(int i) {
            TrackInfo trackInfo;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363799409")) {
                ipChange.ipc$dispatch("1363799409", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            Map<String, Action> actions = FoldTextViewPresent.this.getActions();
            if (actions != null) {
                FoldTextViewPresent foldTextViewPresent = FoldTextViewPresent.this;
                Action action = actions.get("item");
                if (action == null || (trackInfo = action.getTrackInfo()) == null) {
                    return;
                }
                b41.h(trackInfo, "trackInfo");
                HashMap<String, String> args = trackInfo.getArgs();
                b41.h(args, "args");
                args.put("state", String.valueOf(i));
                UserTrackProviderProxy.click(foldTextViewPresent.getCurentView(), trackInfo, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldTextViewPresent(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "287850669") ? ((Integer) ipChange.ipc$dispatch("287850669", new Object[]{this, context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private final DisplayMetrics getScreenInfo(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328305282")) {
            return (DisplayMetrics) ipChange.ipc$dispatch("-328305282", new Object[]{this, activity});
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoAction() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895876787")) {
            return ((Boolean) ipChange.ipc$dispatch("-1895876787", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoClickTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765616960")) {
            return ((Boolean) ipChange.ipc$dispatch("-765616960", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.alient.onearch.adapter.view.ViewCard
    public boolean enableAutoExposeTrack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774933672")) {
            return ((Boolean) ipChange.ipc$dispatch("1774933672", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @NotNull
    public final FoldTextView getCurentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852137979")) {
            return (FoldTextView) ipChange.ipc$dispatch("-1852137979", new Object[]{this});
        }
        FoldTextView foldTextView = this.curentView;
        if (foldTextView != null) {
            return foldTextView;
        }
        b41.A("curentView");
        return null;
    }

    public final void setCurentView(@NotNull FoldTextView foldTextView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447256293")) {
            ipChange.ipc$dispatch("-447256293", new Object[]{this, foldTextView});
            return;
        }
        b41.i(foldTextView, "<set-?>");
        this.curentView = foldTextView;
    }

    @Nullable
    public final String stripHtml(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22446432")) {
            return (String) ipChange.ipc$dispatch("-22446432", new Object[]{this, str});
        }
        b41.i(str, "content");
        return new Regex("<.*?>").replace(str, "");
    }

    @Override // com.alient.onearch.adapter.view.AbsPresenter, com.youku.arch.v3.view.AbsPresenter, com.youku.arch.v3.view.IContract.Presenter
    public void init(@NotNull GenericItem<ItemValue> genericItem) {
        DisplayMetrics screenInfo;
        DisplayMetrics screenInfo2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1963043151")) {
            ipChange.ipc$dispatch("1963043151", new Object[]{this, genericItem});
            return;
        }
        b41.i(genericItem, "item");
        super.init((FoldTextViewPresent) genericItem);
        Integer num = null;
        if (this.curentView == null) {
            setCurentView(((FoldTextViewView) getView()).getTextView());
            getCurentView().setChangeListener(new a());
            FoldTextView textView = ((FoldTextViewView) getView()).getTextView();
            Activity activity = genericItem.getPageContext().getActivity();
            if (activity != null && (screenInfo2 = getScreenInfo(activity)) != null) {
                num = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(screenInfo2));
            }
            b41.f(num);
            int intValue = num.intValue();
            Activity activity2 = genericItem.getPageContext().getActivity();
            b41.f(activity2);
            textView.initWidth(intValue - dip2px(activity2, 24.0f));
            int i = R$color.bricks_white;
            textView.setCloseColorId(i);
            textView.setExpandColorId(i);
            textView.setMaxLines(3);
            textView.setExpandMaxLine(9);
            textView.showFoldText(Html.fromHtml(stripHtml(((FoldTextViewModel) getModel()).getDesc())));
            textView.setTag(((FoldTextViewModel) getModel()).getDesc());
        } else if (!b41.d(getCurentView(), ((FoldTextViewView) getView()).getTextView()) || getCurentView().getTag() == null || getCurentView().getTag().toString().equals(((FoldTextViewModel) getModel()).getDesc())) {
        } else {
            FoldTextView textView2 = ((FoldTextViewView) getView()).getTextView();
            Activity activity3 = genericItem.getPageContext().getActivity();
            if (activity3 != null && (screenInfo = getScreenInfo(activity3)) != null) {
                num = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(screenInfo));
            }
            b41.f(num);
            int intValue2 = num.intValue();
            Activity activity4 = genericItem.getPageContext().getActivity();
            b41.f(activity4);
            textView2.initWidth(intValue2 - dip2px(activity4, 24.0f));
            int i2 = R$color.bricks_white;
            textView2.setCloseColorId(i2);
            textView2.setExpandColorId(i2);
            textView2.setMaxLines(3);
            textView2.setExpandMaxLine(9);
            textView2.showFoldText(Html.fromHtml(stripHtml(((FoldTextViewModel) getModel()).getDesc())));
            textView2.setTag(((FoldTextViewModel) getModel()).getDesc());
        }
    }
}
