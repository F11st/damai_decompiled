package com.alibaba.pictures.bricks.component.home.calendar;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.HomeCalendarBean;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract;
import com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarView;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.DMUpMarqueeView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s60;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class HomeCalendarView extends AbsView<GenericItem<ItemValue>, HomeCalendarModel, HomeCalendarPresent> implements HomeCalendarContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final ImageView bgIv;
    @NotNull
    private final ConstraintLayout container;
    private int index;
    @NotNull
    private final View itemView;
    @NotNull
    private final DMUpMarqueeView marqueeView;
    @NotNull
    private final ImageView titleIv;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements DMUpMarqueeView.OnItemClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeCalendarBean b;

        a(HomeCalendarBean homeCalendarBean) {
            this.b = homeCalendarBean;
        }

        @Override // com.alibaba.pictures.bricks.view.DMUpMarqueeView.OnItemClickListener
        public void onItemClick(int i, @Nullable View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1493752875")) {
                ipChange.ipc$dispatch("1493752875", new Object[]{this, Integer.valueOf(i), view});
            } else {
                ((HomeCalendarPresent) HomeCalendarView.this.getPresenter()).onClick(this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1162238141")) {
                ipChange.ipc$dispatch("-1162238141", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1277275473")) {
                ipChange.ipc$dispatch("1277275473", new Object[]{this, animation});
            } else {
                b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1724156452")) {
                ipChange.ipc$dispatch("-1724156452", new Object[]{this, animation});
                return;
            }
            b41.i(animation, v.TAK_ABILITY_SHOW_POP_ANIMATION);
            View currentView = HomeCalendarView.this.marqueeView.getCurrentView();
            View findViewById = currentView.findViewById(R$id.home_calender_content_text);
            b41.h(findViewById, "currentView.findViewById…me_calender_content_text)");
            TextView textView = (TextView) findViewById;
            View findViewById2 = currentView.findViewById(R$id.home_calender_content_arrow);
            b41.h(findViewById2, "currentView.findViewById…e_calender_content_arrow)");
            ImageView imageView = (ImageView) findViewById2;
            if (b41.d(currentView.getTag(), Boolean.FALSE) && imageView.getVisibility() == 0) {
                if (imageView.getWidth() <= currentView.getWidth() - textView.getWidth()) {
                    imageView.setVisibility(0);
                    textView.setMaxWidth(currentView.getWidth() - imageView.getWidth());
                } else {
                    textView.setMaxWidth(currentView.getWidth());
                    imageView.setVisibility(8);
                }
                currentView.setTag(Boolean.TRUE);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeCalendarView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        View findViewById = view.findViewById(R$id.home_calendar_container);
        b41.h(findViewById, "itemView.findViewById(R.….home_calendar_container)");
        this.container = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R$id.home_calendar_bg);
        b41.h(findViewById2, "itemView.findViewById(R.id.home_calendar_bg)");
        this.bgIv = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.home_calendar_title);
        b41.h(findViewById3, "itemView.findViewById(R.id.home_calendar_title)");
        this.titleIv = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R$id.home_calendar_content);
        b41.h(findViewById4, "itemView.findViewById(R.id.home_calendar_content)");
        this.marqueeView = (DMUpMarqueeView) findViewById4;
        adjustWidth();
    }

    private final void adjustWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666594885")) {
            ipChange.ipc$dispatch("1666594885", new Object[]{this});
            return;
        }
        s60 s60Var = s60.INSTANCE;
        Context context = this.itemView.getContext();
        b41.h(context, "itemView.context");
        int i = DisplayMetrics.getwidthPixels(s60Var.f(context));
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        Context context2 = this.itemView.getContext();
        b41.h(context2, "itemView.context");
        int b2 = i - s60Var.b(context2, 18);
        Context context3 = this.itemView.getContext();
        b41.h(context3, "itemView.context");
        layoutParams.width = (b2 - s60Var.b(context3, 12)) / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m133bindView$lambda1(HomeCalendarView homeCalendarView, HomeCalendarBean homeCalendarBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1957023458")) {
            ipChange.ipc$dispatch("-1957023458", new Object[]{homeCalendarView, homeCalendarBean, view});
            return;
        }
        b41.i(homeCalendarView, "this$0");
        b41.i(homeCalendarBean, "$bean");
        ((HomeCalendarPresent) homeCalendarView.getPresenter()).onClick(homeCalendarBean);
    }

    private final View createView(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "432621838")) {
            return (View) ipChange.ipc$dispatch("432621838", new Object[]{this, str, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.bricks_home_calendar_content, (ViewGroup) null);
        b41.h(inflate, "from(itemView.context)\n …e_calendar_content, null)");
        View findViewById = inflate.findViewById(R$id.home_calender_content_text);
        b41.h(findViewById, "view.findViewById(R.id.home_calender_content_text)");
        TextView textView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R$id.home_calender_content_arrow);
        b41.h(findViewById2, "view.findViewById(R.id.h…e_calender_content_arrow)");
        ((ImageView) findViewById2).setVisibility(i != 7537 ? 8 : 0);
        textView.setText(str);
        inflate.setTag(Boolean.FALSE);
        return inflate;
    }

    @Override // com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract.View
    public void bindView(@NotNull final HomeCalendarBean homeCalendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148507725")) {
            ipChange.ipc$dispatch("148507725", new Object[]{this, homeCalendarBean});
            return;
        }
        b41.i(homeCalendarBean, "bean");
        ImageLoaderProviderProxy.getProxy().loadinto(homeCalendarBean.bgPic, this.bgIv);
        ImageLoaderProviderProxy.getProxy().loadinto(homeCalendarBean.titlePic, this.titleIv);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.bx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeCalendarView.m133bindView$lambda1(HomeCalendarView.this, homeCalendarBean, view);
            }
        });
        this.marqueeView.setOnItemClickListener(new a(homeCalendarBean));
        this.marqueeView.setFlipInterval(3000);
        this.marqueeView.setAnimationDuration(500L);
        ArrayList arrayList = new ArrayList();
        List<String> list = homeCalendarBean.subTitles;
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(createView(str, homeCalendarBean.type));
                }
            }
        }
        this.marqueeView.setItems(arrayList);
        Animation inAnimation = this.marqueeView.getInAnimation();
        if (inAnimation != null) {
            inAnimation.setAnimationListener(new b());
        }
    }

    @Override // com.alibaba.pictures.bricks.component.home.calendar.HomeCalendarContract.View
    public void changeScreenMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1935576293")) {
            ipChange.ipc$dispatch("1935576293", new Object[]{this, Boolean.valueOf(z)});
        } else {
            adjustWidth();
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825511248") ? (View) ipChange.ipc$dispatch("1825511248", new Object[]{this}) : this.itemView;
    }
}
