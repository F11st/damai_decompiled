package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CombGiftView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView imageIcon;

    public CombGiftView(Context context) {
        this(context, null);
    }

    public void setData(GiftInfoBean giftInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923197309")) {
            ipChange.ipc$dispatch("923197309", new Object[]{this, giftInfoBean});
        } else if (giftInfoBean == null || TextUtils.isEmpty(giftInfoBean.icon)) {
        } else {
            DagoImageLoader.getInstance().showDefault(getContext(), giftInfoBean.icon, this.imageIcon);
        }
    }

    public CombGiftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CombGiftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_comb_gift, (ViewGroup) this, true);
        this.imageIcon = (ImageView) findViewById(R.id.gift_icon);
    }
}
