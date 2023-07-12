package cn.damai.commonbusiness.wannasee.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.commonbusiness.wannasee.view.WantSeeRecommendItemView;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.qd2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class WantSeeRecommendItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Function4<? super Integer, Object, ? super Integer, ? super View, wt2> onEventListener;
    private final DMPosterView posterView;
    private final TextView titleTv;
    private final TextView wantSeeTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendItemView(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ WantSeeRecommendItemView(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindData$lambda-0  reason: not valid java name */
    public static final void m24bindData$lambda0(WantSeeRecommendItemView wantSeeRecommendItemView, ProjectItemBean projectItemBean, int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890854288")) {
            ipChange.ipc$dispatch("1890854288", new Object[]{wantSeeRecommendItemView, projectItemBean, Integer.valueOf(i), view});
            return;
        }
        b41.i(wantSeeRecommendItemView, "this$0");
        b41.i(projectItemBean, "$projectMo");
        Context context = wantSeeRecommendItemView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4 = wantSeeRecommendItemView.onEventListener;
        if (function4 != null) {
            function4.invoke(2, projectItemBean, Integer.valueOf(i), wantSeeRecommendItemView);
        }
        qd2.b(wantSeeRecommendItemView.getContext(), projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
    }

    private final void requestWantSee(final ProjectItemBean projectItemBean, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321924821")) {
            ipChange.ipc$dispatch("-321924821", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        this.wantSeeTv.setEnabled(false);
        FollowRequest followRequest = new FollowRequest();
        followRequest.targetId = projectItemBean.id;
        followRequest.operateType = projectItemBean.wantSeeStatus == 1 ? "0" : "1";
        followRequest.targetType = "7";
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.commonbusiness.wannasee.view.WantSeeRecommendItemView$requestWantSee$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(@Nullable String str, @Nullable String str2) {
                TextView textView;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2054462825")) {
                    ipChange2.ipc$dispatch("2054462825", new Object[]{this, str, str2});
                    return;
                }
                textView = WantSeeRecommendItemView.this.wantSeeTv;
                textView.setEnabled(true);
                ToastUtil.i("麦麦很忙，系统很累请稍后重试");
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(@Nullable FollowDataBean followDataBean) {
                TextView textView;
                Function4<Integer, Object, Integer, View, wt2> onEventListener;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1357740759")) {
                    ipChange2.ipc$dispatch("1357740759", new Object[]{this, followDataBean});
                    return;
                }
                textView = WantSeeRecommendItemView.this.wantSeeTv;
                textView.setEnabled(true);
                if (followDataBean != null) {
                    projectItemBean.wantSeeStatus = followDataBean.getStatus();
                    WantSeeRecommendItemView.this.setWantSeeStatus(projectItemBean, i);
                    if (followDataBean.getStatus() == 0 || (onEventListener = WantSeeRecommendItemView.this.getOnEventListener()) == null) {
                        return;
                    }
                    onEventListener.invoke(4, projectItemBean, Integer.valueOf(i), null);
                    return;
                }
                ToastUtil.i("麦麦很忙，系统很累请稍后重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setWantSeeStatus(final ProjectItemBean projectItemBean, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751993718")) {
            ipChange.ipc$dispatch("-751993718", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        if (projectItemBean.wantSeeStatus == 0) {
            this.wantSeeTv.setText("想看");
            this.wantSeeTv.setTextColor(getResources().getColor(R$color.white));
            this.wantSeeTv.setBackground(getResources().getDrawable(R$drawable.want_see_background_already));
        } else {
            this.wantSeeTv.setText("已想看");
            this.wantSeeTv.setTextColor(getResources().getColor(R$color.color_5F6672));
            this.wantSeeTv.setBackground(getResources().getDrawable(R$drawable.want_see_background));
        }
        this.wantSeeTv.setOnClickListener(new View.OnClickListener() { // from class: tb.l03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeeRecommendItemView.m25setWantSeeStatus$lambda1(ProjectItemBean.this, this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setWantSeeStatus$lambda-1  reason: not valid java name */
    public static final void m25setWantSeeStatus$lambda1(ProjectItemBean projectItemBean, WantSeeRecommendItemView wantSeeRecommendItemView, int i, View view) {
        Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "222287387")) {
            ipChange.ipc$dispatch("222287387", new Object[]{projectItemBean, wantSeeRecommendItemView, Integer.valueOf(i), view});
            return;
        }
        b41.i(projectItemBean, "$projectMo");
        b41.i(wantSeeRecommendItemView, "this$0");
        if (projectItemBean.wantSeeStatus == 0 && (function4 = wantSeeRecommendItemView.onEventListener) != null) {
            function4.invoke(3, projectItemBean, Integer.valueOf(i), wantSeeRecommendItemView.wantSeeTv);
        }
        wantSeeRecommendItemView.requestWantSee(projectItemBean, i);
    }

    public final void bindData(@NotNull final ProjectItemBean projectItemBean, final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965810270")) {
            ipChange.ipc$dispatch("965810270", new Object[]{this, projectItemBean, Integer.valueOf(i)});
            return;
        }
        b41.i(projectItemBean, "projectMo");
        this.posterView.setImageUrl(projectItemBean.verticalPic);
        this.posterView.setScoreStar(projectItemBean.itemScore, true);
        this.posterView.setCategoryTagName(projectItemBean.getCategoryNameCompat());
        this.titleTv.setText(projectItemBean.name);
        setWantSeeStatus(projectItemBean, i);
        setOnClickListener(new View.OnClickListener() { // from class: tb.k03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WantSeeRecommendItemView.m24bindData$lambda0(WantSeeRecommendItemView.this, projectItemBean, i, view);
            }
        });
        Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4 = this.onEventListener;
        if (function4 != null) {
            function4.invoke(5, projectItemBean, Integer.valueOf(i), this);
        }
    }

    @Nullable
    public final Function4<Integer, Object, Integer, View, wt2> getOnEventListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1721477140") ? (Function4) ipChange.ipc$dispatch("-1721477140", new Object[]{this}) : this.onEventListener;
    }

    public final void setOnEventListener(@Nullable Function4<? super Integer, Object, ? super Integer, ? super View, wt2> function4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414062052")) {
            ipChange.ipc$dispatch("-414062052", new Object[]{this, function4});
        } else {
            this.onEventListener = function4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WantSeeRecommendItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R$layout.common_business_want_see_recommend_item_layout, (ViewGroup) this, true);
        this.posterView = (DMPosterView) findViewById(R$id.want_see_poster);
        this.titleTv = (TextView) findViewById(R$id.want_see_recommend_title);
        this.wantSeeTv = (TextView) findViewById(R$id.want_see_btn);
    }
}
