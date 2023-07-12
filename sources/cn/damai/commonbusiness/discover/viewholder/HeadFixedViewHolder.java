package cn.damai.commonbusiness.discover.viewholder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.HeadFixedBean;
import cn.damai.commonbusiness.discover.bean.HeadFixedWrapBean;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class HeadFixedViewHolder extends BaseViewHolderV2<HeadFixedWrapBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final List<View> c;
    private final List<View> d;
    private final List<Integer> e;
    private final List<Integer> f;
    private TextView g;
    private OnItemBindListener<HeadFixedBean> h;

    public HeadFixedViewHolder(View view, OnItemBindListener<HeadFixedBean> onItemBindListener) {
        super(view);
        ArrayList arrayList = new ArrayList(3);
        this.c = arrayList;
        ArrayList arrayList2 = new ArrayList(3);
        this.d = arrayList2;
        ArrayList arrayList3 = new ArrayList(3);
        this.e = arrayList3;
        ArrayList arrayList4 = new ArrayList(3);
        this.f = arrayList4;
        this.g = (TextView) view.findViewById(R$id.tv_comment_title);
        View findViewById = view.findViewById(R$id.comment_1_ui);
        View findViewById2 = view.findViewById(R$id.comment_2_ui);
        View findViewById3 = view.findViewById(R$id.comment_3_ui);
        arrayList.add(findViewById);
        arrayList.add(findViewById2);
        arrayList.add(findViewById3);
        arrayList3.add(0);
        arrayList3.add(Integer.valueOf(R$drawable.item_topic_icon));
        arrayList3.add(Integer.valueOf(R$drawable.item_comment_icon));
        arrayList3.add(Integer.valueOf(R$drawable.item_vote_icon));
        View findViewById4 = view.findViewById(R$id.fixed_1_ui);
        View findViewById5 = view.findViewById(R$id.fixed_2_ui);
        View findViewById6 = view.findViewById(R$id.fixed_3_ui);
        arrayList2.add(findViewById4);
        arrayList2.add(findViewById5);
        arrayList2.add(findViewById6);
        arrayList4.add(Integer.valueOf(R$drawable.icon_fixed_guan_yan_tuan));
        arrayList4.add(Integer.valueOf(R$drawable.icon_fixed_xing_ying_hua));
        arrayList4.add(Integer.valueOf(R$drawable.icon_fixed_x_wen));
        this.h = onItemBindListener;
    }

    private void d(HeadFixedWrapBean headFixedWrapBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409487021")) {
            ipChange.ipc$dispatch("-1409487021", new Object[]{this, headFixedWrapBean});
            return;
        }
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            HeadFixedBean headFixedBean = (HeadFixedBean) cb2.b(headFixedWrapBean.commentList, i);
            View view = this.c.get(i);
            ImageView imageView = (ImageView) view.findViewById(R$id.iv_comment_icon);
            TextView textView = (TextView) view.findViewById(R$id.tv_comment_title);
            TextView textView2 = (TextView) view.findViewById(R$id.tv_comment_sub_title);
            ImageView imageView2 = (ImageView) view.findViewById(R$id.iv_comment_action);
            view.setTag(headFixedBean);
            if (headFixedBean == null) {
                view.setVisibility(8);
            } else {
                textView.setText(TextUtils.isEmpty(headFixedBean.name) ? "" : headFixedBean.name);
                textView2.setText(TextUtils.isEmpty(headFixedBean.subTitle) ? "" : headFixedBean.subTitle);
                imageView2.setVisibility(headFixedBean.hasActivity ? 0 : 8);
                view.setOnClickListener(this);
                C0504a.b().loadinto(headFixedBean.iconUrl, imageView);
                this.h.exposeItem(view, headFixedBean, i);
            }
        }
    }

    private void e(HeadFixedWrapBean headFixedWrapBean) {
        int i;
        int parseColor;
        HeadFixedWrapBean headFixedWrapBean2 = headFixedWrapBean;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1587247144")) {
            ipChange.ipc$dispatch("1587247144", new Object[]{this, headFixedWrapBean2});
            return;
        }
        int a = l62.a(mu0.a(), 108.0f);
        int a2 = l62.a(mu0.a(), 66.0f);
        int a3 = l62.a(mu0.a(), 45.0f);
        int a4 = l62.a(mu0.a(), 45.0f);
        int size = this.d.size();
        while (i2 < size) {
            HeadFixedBean headFixedBean = (HeadFixedBean) cb2.b(headFixedWrapBean2.circleList, i2);
            View view = this.d.get(i2);
            Integer num = this.f.get(i2);
            view.setTag(headFixedBean);
            ImageView imageView = (ImageView) view.findViewById(R$id.fixed_bg_img);
            TextView textView = (TextView) view.findViewById(R$id.fixed_sub_title);
            TextView textView2 = (TextView) view.findViewById(R$id.fixed_sub2_title);
            ImageView imageView2 = (ImageView) view.findViewById(R$id.fixed_sub_img);
            int i3 = i2 == 0 ? a : a4;
            int i4 = i2 == 0 ? a2 : a3;
            if (i2 == 0) {
                i = a;
                parseColor = -1;
            } else {
                i = a;
                parseColor = Color.parseColor("#9C9CA5");
            }
            textView.setTextColor(parseColor);
            if (headFixedBean == null) {
                textView.setText("");
                if (textView2 != null) {
                    textView2.setText("");
                }
                imageView2.setImageDrawable(null);
                view.setOnClickListener(null);
                imageView.setImageResource(R$drawable.img_corners_4_gradient_placeholder);
            } else {
                textView.setText(headFixedBean.subTitle);
                if (textView2 != null) {
                    textView2.setText(headFixedBean.redirectName);
                }
                if (num != null) {
                    imageView2.setImageResource(num.intValue());
                }
                headFixedBean.pos = i2;
                view.setOnClickListener(this);
                C0504a.b().f(headFixedBean.getIndexBgImgUrl(i2), i3, i4).i(R$drawable.img_corners_4_gradient_placeholder).g(imageView);
            }
            if (headFixedBean != null) {
                this.h.exposeItem(view, headFixedBean, i2);
            }
            i2++;
            headFixedWrapBean2 = headFixedWrapBean;
            a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: f */
    public void c(HeadFixedWrapBean headFixedWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-518549871")) {
            ipChange.ipc$dispatch("-518549871", new Object[]{this, headFixedWrapBean, Integer.valueOf(i)});
        } else if (headFixedWrapBean == null || cb2.d(headFixedWrapBean.markets)) {
        } else {
            CardTitleBean cardTitleBean = headFixedWrapBean.mTitleBean;
            if (cardTitleBean != null) {
                this.g.setText(TextUtils.isEmpty(cardTitleBean.title) ? "演出动态" : headFixedWrapBean.mTitleBean.title);
            }
            d(headFixedWrapBean);
            e(headFixedWrapBean);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525771406")) {
            ipChange.ipc$dispatch("-525771406", new Object[]{this, view});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof HeadFixedBean) {
            HeadFixedBean headFixedBean = (HeadFixedBean) tag;
            this.h.onItemClick(headFixedBean, headFixedBean.pos);
        }
    }
}
