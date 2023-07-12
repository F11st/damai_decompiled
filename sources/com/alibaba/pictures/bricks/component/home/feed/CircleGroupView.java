package com.alibaba.pictures.bricks.component.home.feed;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.CircleCard;
import com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract;
import com.alibaba.pictures.bricks.component.home.feed.CircleGroupView;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.AvatarRecyclerView;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.bb2;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CircleGroupView extends AbsView<GenericItem<ItemValue>, CircleGroupModel, CircleGroupPresent> implements CircleGroupContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleGroupView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-0  reason: not valid java name */
    public static final void m134bindView$lambda0(CircleGroupView circleGroupView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1127051250")) {
            ipChange.ipc$dispatch("1127051250", new Object[]{circleGroupView, view});
            return;
        }
        b41.i(circleGroupView, "this$0");
        ((CircleGroupPresent) circleGroupView.getPresenter()).onClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bindView$lambda-1  reason: not valid java name */
    public static final void m135bindView$lambda1(CircleGroupView circleGroupView, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1517779247")) {
            ipChange.ipc$dispatch("-1517779247", new Object[]{circleGroupView, view});
            return;
        }
        b41.i(circleGroupView, "this$0");
        ((CircleGroupPresent) circleGroupView.getPresenter()).onClick();
    }

    private final List<AvatarRecyclerView.AvatarItem> toAvatarList(List<String> list, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1634125603")) {
            return (List) ipChange.ipc$dispatch("-1634125603", new Object[]{this, list, Integer.valueOf(i)});
        }
        if (bb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new AvatarRecyclerView.C3565b(str));
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        if (arrayList.size() > 0) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    @Override // com.alibaba.pictures.bricks.component.home.feed.CircleGroupContract.View
    public void bindView(@NotNull CircleCard circleCard) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754099438")) {
            ipChange.ipc$dispatch("754099438", new Object[]{this, circleCard});
            return;
        }
        b41.i(circleCard, "bean");
        if (TextUtils.isEmpty(circleCard.name)) {
            return;
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.si
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleGroupView.m134bindView$lambda0(CircleGroupView.this, view);
            }
        });
        View findViewById = this.itemView.findViewById(R$id.homepage_waterflow_circle_title);
        b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        textView.setText(circleCard.name);
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().getTextSize() * textView.getText().length(), 0.0f, Color.parseColor("#FF6785"), Color.parseColor("#FFB57B"), Shader.TileMode.CLAMP));
        if (!TextUtils.isEmpty(circleCard.title)) {
            View findViewById2 = this.itemView.findViewById(R$id.homepage_waterflow_circle_title_subtitle);
            b41.g(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(circleCard.title);
        }
        if (!TextUtils.isEmpty(circleCard.subTitle)) {
            View findViewById3 = this.itemView.findViewById(R$id.homepage_waterflow_circle_title_fansnum);
            b41.g(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById3).setText(circleCard.subTitle);
        }
        if (!bb2.d(circleCard.headImgList)) {
            View findViewById4 = this.itemView.findViewById(R$id.homepage_waterflow_circle_avatar_view);
            b41.h(findViewById4, "itemView.findViewById(R.…rflow_circle_avatar_view)");
            AvatarRecyclerView avatarRecyclerView = (AvatarRecyclerView) findViewById4;
            avatarRecyclerView.setHeight(14);
            AvatarRecyclerView.AvatarAdapter adapter = avatarRecyclerView.getAdapter();
            if (adapter != null) {
                List<String> list = circleCard.headImgList;
                b41.h(list, "bean.headImgList");
                adapter.c(toAvatarList(list, 3));
            }
        }
        if (!bb2.d(circleCard.contentImgList)) {
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_circle_ll);
            linearLayout.removeAllViews();
            int i2 = 0;
            for (String str : circleCard.contentImgList) {
                View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.circle_card_img_item, (ViewGroup) linearLayout, false);
                b41.h(inflate, "from(itemView.context)\n …_item, scrollView, false)");
                linearLayout.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: tb.ti
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CircleGroupView.m135bindView$lambda1(CircleGroupView.this, view);
                    }
                });
                s60 s60Var = s60.INSTANCE;
                Context context = this.itemView.getContext();
                b41.h(context, "itemView.context");
                int b = s60Var.b(context, 3);
                if (i2 == 0) {
                    Context context2 = this.itemView.getContext();
                    b41.h(context2, "itemView.context");
                    i = s60Var.b(context2, 9);
                } else {
                    i = 0;
                }
                int i3 = R$id.circle_card_img_item_img;
                ViewGroup.LayoutParams layoutParams = inflate.findViewById(i3).getLayoutParams();
                b41.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams) layoutParams).setMargins(i, 0, b, 0);
                ImageLoaderProviderProxy.loadinto(str, (ImageView) inflate.findViewById(i3));
                i2++;
            }
        }
        if (TextUtils.isEmpty(circleCard.backgroundImg)) {
            return;
        }
        ImageLoaderProviderProxy.loadinto(circleCard.backgroundImg, (ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image));
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2110196540") ? (View) ipChange.ipc$dispatch("-2110196540", new Object[]{this}) : this.itemView;
    }
}
