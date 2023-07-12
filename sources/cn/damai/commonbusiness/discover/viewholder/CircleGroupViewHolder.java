package cn.damai.commonbusiness.discover.viewholder;

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
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.CircleCard;
import cn.damai.uikit.view.AvatarRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.cb2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CircleGroupViewHolder extends BaseViewHolder<CircleCard> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnItemClickListener<CircleCard> a;
    CircleCard b;
    int c;

    public CircleGroupViewHolder(View view, OnItemClickListener<CircleCard> onItemClickListener) {
        super(view);
        this.a = onItemClickListener;
    }

    private List<AvatarRecyclerView.AvatarItem> toAvatarList(List<String> list, int i) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-891744385")) {
            return (List) ipChange.ipc$dispatch("-891744385", new Object[]{this, list, Integer.valueOf(i)});
        }
        if (cb2.d(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(new AvatarRecyclerView.C2566b(str));
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

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: c */
    public void a(CircleCard circleCard, int i) {
        CircleCard circleCard2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922908100")) {
            ipChange.ipc$dispatch("-922908100", new Object[]{this, circleCard, Integer.valueOf(i)});
        } else if (circleCard != null && !TextUtils.isEmpty(circleCard.name)) {
            this.c = i;
            this.b = circleCard;
            this.itemView.setOnClickListener(this);
            TextView textView = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title);
            textView.setText(circleCard.name);
            textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getPaint().getTextSize() * textView.getText().length(), 0.0f, Color.parseColor("#FF6785"), Color.parseColor("#FFB57B"), Shader.TileMode.CLAMP));
            if (!TextUtils.isEmpty(circleCard.title)) {
                ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title_subtitle)).setText(circleCard.title);
            }
            if (!TextUtils.isEmpty(circleCard.subTitle)) {
                ((TextView) this.itemView.findViewById(R$id.homepage_waterflow_circle_title_fansnum)).setText(circleCard.subTitle);
            }
            if (!cb2.d(circleCard.headImgList)) {
                AvatarRecyclerView avatarRecyclerView = (AvatarRecyclerView) this.itemView.findViewById(R$id.homepage_waterflow_circle_avatar_view);
                avatarRecyclerView.setHeight(14);
                avatarRecyclerView.getAdapter().e(toAvatarList(circleCard.headImgList, 3));
            }
            if (!cb2.d(circleCard.contentImgList)) {
                LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_circle_ll);
                linearLayout.removeAllViews();
                int i2 = 0;
                for (String str : circleCard.contentImgList) {
                    View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.circle_card_img_item, (ViewGroup) linearLayout, false);
                    linearLayout.addView(inflate);
                    inflate.setOnClickListener(this);
                    int a = t60.a(this.itemView.getContext(), 3.0f);
                    int a2 = i2 == 0 ? t60.a(this.itemView.getContext(), 9.0f) : 0;
                    int i3 = R$id.circle_card_img_item_img;
                    ((FrameLayout.LayoutParams) inflate.findViewById(i3).getLayoutParams()).setMargins(a2, 0, a, 0);
                    C0504a.b().c(str).g((ImageView) inflate.findViewById(i3));
                    i2++;
                }
            }
            if (!TextUtils.isEmpty(circleCard.backgroundImg)) {
                C0504a.b().c(circleCard.backgroundImg).g((ImageView) this.itemView.findViewById(R$id.homepage_waterflow_coupon_image));
            }
            OnItemClickListener<CircleCard> onItemClickListener = this.a;
            if (onItemClickListener == null || (circleCard2 = this.b) == null) {
                return;
            }
            onItemClickListener.onEditClick(circleCard2, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CircleCard circleCard;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1126715123")) {
            ipChange.ipc$dispatch("-1126715123", new Object[]{this, view});
            return;
        }
        OnItemClickListener<CircleCard> onItemClickListener = this.a;
        if (onItemClickListener == null || (circleCard = this.b) == null) {
            return;
        }
        onItemClickListener.onItemClick(circleCard, this.c);
    }
}
