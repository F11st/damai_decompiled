package cn.damai.commonbusiness.wannasee.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.wannasee.WantSeeRecommendRequest;
import cn.damai.commonbusiness.wannasee.bean.RecommendProjects;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cc0;
import tb.dc0;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeeRecommendView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Event = new a(null);
    public static final int TYPE_FOLLOW_CLICK = 3;
    public static final int TYPE_FOLLOW_SUCCESS = 4;
    public static final int TYPE_ITEM_CLICK = 2;
    public static final int TYPE_ITEM_EXPOSURE = 5;
    public static final int TYPE_REFRESH_CLICK = 1;
    private final LinearLayout container;
    private final TextView descTv;
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, wt2> onEventListener;
    @Nullable
    private Function1<? super RecommendProjects, wt2> onRefreshSuccess;
    private final DMIconFontTextView refreshTv;
    private final TextView titleTv;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ WantSeeRecommendView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m26bindData$lambda0(WantSeeRecommendView wantSeeRecommendView, RecommendProjects recommendProjects, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709814381")) {
            ipChange.ipc$dispatch("-1709814381", new Object[]{wantSeeRecommendView, recommendProjects, view});
            return;
        }
        b41.i(wantSeeRecommendView, "this$0");
        Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4 = wantSeeRecommendView.onEventListener;
        if (function4 != null) {
            function4.invoke(1, recommendProjects, Integer.valueOf(recommendProjects.index), wantSeeRecommendView.refreshTv);
        }
        Integer valueOf = Integer.valueOf(recommendProjects.recommendType);
        int i = recommendProjects.pageNo + 1;
        recommendProjects.pageNo = i;
        wantSeeRecommendView.doRefresh(valueOf, i);
    }

    private final void bindRecommend(final RecommendProjects recommendProjects) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130749672")) {
            ipChange.ipc$dispatch("2130749672", new Object[]{this, recommendProjects});
            return;
        }
        int childCount = this.container.getChildCount();
        List<ProjectItemBean> list = recommendProjects.details;
        int size = list != null ? list.size() : 0;
        int i = 0;
        while (i < childCount) {
            ProjectItemBean projectItemBean = (size <= 0 || i >= size || list == null) ? null : list.get(i);
            View childAt = this.container.getChildAt(i);
            WantSeeRecommendItemView wantSeeRecommendItemView = childAt instanceof WantSeeRecommendItemView ? (WantSeeRecommendItemView) childAt : null;
            if (wantSeeRecommendItemView != null) {
                if (projectItemBean != null) {
                    wantSeeRecommendItemView.setVisibility(0);
                    wantSeeRecommendItemView.bindData(projectItemBean, i);
                } else {
                    wantSeeRecommendItemView.setVisibility(4);
                }
                wantSeeRecommendItemView.setOnEventListener(new Function4<Integer, Object, Integer, View, wt2>() { // from class: cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView$bindRecommend$1$1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ wt2 invoke(Integer num, Object obj, Integer num2, View view) {
                        invoke(num.intValue(), obj, num2.intValue(), view);
                        return wt2.INSTANCE;
                    }

                    public final void invoke(int i2, @Nullable Object obj, int i3, @Nullable View view) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1164131042")) {
                            ipChange2.ipc$dispatch("-1164131042", new Object[]{this, Integer.valueOf(i2), obj, Integer.valueOf(i3), view});
                            return;
                        }
                        Function4<Integer, Object, Integer, View, wt2> onEventListener = WantSeeRecommendView.this.getOnEventListener();
                        if (onEventListener != null) {
                            onEventListener.invoke(Integer.valueOf(i2), recommendProjects, Integer.valueOf(i3), view);
                        }
                    }
                });
            }
            i++;
        }
    }

    private final void doRefresh(Integer num, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-185288685")) {
            ipChange.ipc$dispatch("-185288685", new Object[]{this, num, Integer.valueOf(i)});
            return;
        }
        showLoading();
        WantSeeRecommendRequest wantSeeRecommendRequest = new WantSeeRecommendRequest();
        wantSeeRecommendRequest.setRecommendType(num != null ? num.intValue() : 1);
        wantSeeRecommendRequest.setPageNo(i);
        cc0.a(wantSeeRecommendRequest).doOnKTSuccess(new Function1<RecommendProjects, wt2>() { // from class: cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView$doRefresh$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(RecommendProjects recommendProjects) {
                invoke2(recommendProjects);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecommendProjects recommendProjects) {
                IpChange ipChange2 = $ipChange;
                boolean z = true;
                if (AndroidInstantRuntime.support(ipChange2, "-1290612053")) {
                    ipChange2.ipc$dispatch("-1290612053", new Object[]{this, recommendProjects});
                    return;
                }
                b41.i(recommendProjects, AdvanceSetting.NETWORK_TYPE);
                WantSeeRecommendView.this.hideLoading();
                List<ProjectItemBean> list = recommendProjects.details;
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (z) {
                    ToastUtil.i("没有更多相似的演出啦");
                    return;
                }
                Function1<RecommendProjects, wt2> onRefreshSuccess = WantSeeRecommendView.this.getOnRefreshSuccess();
                if (onRefreshSuccess != null) {
                    onRefreshSuccess.invoke(recommendProjects);
                }
            }
        }).doOnKTFail(new Function1<dc0<RecommendProjects>, wt2>() { // from class: cn.damai.commonbusiness.wannasee.view.WantSeeRecommendView$doRefresh$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<RecommendProjects> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<RecommendProjects> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1950027760")) {
                    ipChange2.ipc$dispatch("1950027760", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                WantSeeRecommendView.this.hideLoading();
                ToastUtil.i("麦麦很忙，系统很累请稍后重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225358749")) {
            ipChange.ipc$dispatch("225358749", new Object[]{this});
            return;
        }
        Context context = getContext();
        DamaiBaseActivity damaiBaseActivity = context instanceof DamaiBaseActivity ? (DamaiBaseActivity) context : null;
        if (damaiBaseActivity == null || damaiBaseActivity.isFinishing()) {
            return;
        }
        damaiBaseActivity.hideLoading();
    }

    private final void showLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1607859304")) {
            ipChange.ipc$dispatch("-1607859304", new Object[]{this});
            return;
        }
        Context context = getContext();
        DamaiBaseActivity damaiBaseActivity = context instanceof DamaiBaseActivity ? (DamaiBaseActivity) context : null;
        if (damaiBaseActivity == null || damaiBaseActivity.isFinishing()) {
            return;
        }
        damaiBaseActivity.showLoading("");
    }

    public final void bindData(@Nullable final RecommendProjects recommendProjects) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139510476")) {
            ipChange.ipc$dispatch("-2139510476", new Object[]{this, recommendProjects});
        } else if (recommendProjects == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            this.titleTv.setText(recommendProjects.recommendTitle);
            this.descTv.setText(recommendProjects.recommendDesc);
            if (recommendProjects.recommendType == 3) {
                this.refreshTv.setVisibility(8);
                TextView textView = this.titleTv;
                Resources resources = getResources();
                int i = R$color.color_4D4D56;
                textView.setTextColor(resources.getColor(i));
                this.descTv.setTextColor(getResources().getColor(i));
                this.titleTv.setTextSize(1, 12.0f);
                this.descTv.setTextSize(1, 12.0f);
            } else {
                this.refreshTv.setVisibility(0);
                DMIconFontTextView dMIconFontTextView = this.refreshTv;
                dMIconFontTextView.setText("换一换 " + getResources().getString(R$string.iconfont_huanyihuan));
                this.refreshTv.setOnClickListener(new View.OnClickListener() { // from class: tb.m03
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WantSeeRecommendView.m26bindData$lambda0(WantSeeRecommendView.this, recommendProjects, view);
                    }
                });
                this.titleTv.setTextColor(getResources().getColor(R$color.color_2E333E));
                this.descTv.setTextColor(getResources().getColor(R$color.color_4D4D56));
                this.titleTv.setTextSize(1, 13.0f);
                this.descTv.setTextSize(1, 12.0f);
            }
            bindRecommend(recommendProjects);
        }
    }

    @Nullable
    public final Function4<Integer, Object, Integer, View, wt2> getOnEventListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-736200577") ? (Function4) ipChange.ipc$dispatch("-736200577", new Object[]{this}) : this.onEventListener;
    }

    @Nullable
    public final Function1<RecommendProjects, wt2> getOnRefreshSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1086304930") ? (Function1) ipChange.ipc$dispatch("1086304930", new Object[]{this}) : this.onRefreshSuccess;
    }

    public final void setOnEventListener(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "64740329")) {
            ipChange.ipc$dispatch("64740329", new Object[]{this, function4});
        } else {
            this.onEventListener = function4;
        }
    }

    public final void setOnRefreshSuccess(@Nullable Function1<? super RecommendProjects, wt2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974507596")) {
            ipChange.ipc$dispatch("-974507596", new Object[]{this, function1});
        } else {
            this.onRefreshSuccess = function1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R$layout.common_business_want_see_recommend_layout, (ViewGroup) this, true);
        this.titleTv = (TextView) findViewById(R$id.recommend_title);
        this.descTv = (TextView) findViewById(R$id.recommend_desc);
        this.refreshTv = (DMIconFontTextView) findViewById(R$id.recommend_refresh);
        this.container = (LinearLayout) findViewById(R$id.recommend_list_container);
    }
}
