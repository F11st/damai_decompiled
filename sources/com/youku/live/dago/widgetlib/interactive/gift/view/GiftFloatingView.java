package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftFloatingView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView imageIcon;

    public GiftFloatingView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918945126")) {
            ipChange.ipc$dispatch("918945126", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void setData(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1590826072")) {
            ipChange.ipc$dispatch("1590826072", new Object[]{this, giftInfoBean});
        } else {
            DagoImageLoader.getInstance().showDefault(getContext(), giftInfoBean.icon, this.imageIcon);
        }
    }

    public GiftFloatingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GiftFloatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_gift_anim_item, (ViewGroup) this, true);
        this.imageIcon = (ImageView) findViewById(R.id.gift_icon);
    }
}
