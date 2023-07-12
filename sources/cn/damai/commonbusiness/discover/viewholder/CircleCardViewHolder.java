package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.CircleBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.tetris.component.home.widget.banner.sub.RoundRadiusImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CircleCardViewHolder extends BaseViewHolderV2<CircleBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView c;
    private final TextView d;
    private LinearLayout e;
    private final RoundRadiusImageView f;
    private final ImageView g;
    private final int h;
    private OnItemBindListener<CircleBean> i;

    public CircleCardViewHolder(ViewGroup viewGroup, OnItemBindListener<CircleBean> onItemBindListener) {
        super(LayoutInflater.from(mu0.a()).inflate(R$layout.item_circle_card, viewGroup, false));
        this.h = m62.a(mu0.a(), 35.0f);
        m62.a(mu0.a(), 14.0f);
        this.i = onItemBindListener;
        this.e = (LinearLayout) this.itemView.findViewById(R$id.circle_card_layout);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_circle_title);
        this.d = (TextView) this.itemView.findViewById(R$id.tv_circle_sub);
        this.f = (RoundRadiusImageView) this.itemView.findViewById(R$id.iv_circle_pic);
        this.g = (ImageView) this.itemView.findViewById(R$id.iv_circle_action_icon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: d */
    public void c(CircleBean circleBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2058045549")) {
            ipChange.ipc$dispatch("2058045549", new Object[]{this, circleBean, Integer.valueOf(i)});
        } else if (circleBean == null) {
        } else {
            int a = DisplayMetrics.getwidthPixels(q60.b(mu0.a())) - q60.a(mu0.a(), 36.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = a / 2;
            if (i != 0 && i != 1) {
                layoutParams.leftMargin = q60.a(mu0.a(), 0.0f);
            } else {
                layoutParams.leftMargin = q60.a(mu0.a(), 12.0f);
            }
            this.c.setText(TextUtils.isEmpty(circleBean.name) ? "" : circleBean.name);
            this.d.setText(TextUtils.isEmpty(circleBean.dynamicEffect) ? "" : circleBean.dynamicEffect);
            a b = a.b();
            String str = circleBean.headImage;
            int i2 = this.h;
            b.f(str, i2, i2).g(this.f);
            this.g.setVisibility(circleBean.hasActivity ? 0 : 8);
            this.itemView.setOnClickListener(this);
            this.i.exposeItem(this.itemView, circleBean, i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnItemBindListener<CircleBean> onItemBindListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1035011704")) {
            ipChange.ipc$dispatch("1035011704", new Object[]{this, view});
            return;
        }
        T t = this.a;
        if (t == 0 || (onItemBindListener = this.i) == null) {
            return;
        }
        onItemBindListener.onItemClick((CircleBean) t, this.b);
    }
}
