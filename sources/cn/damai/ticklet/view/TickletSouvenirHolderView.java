package cn.damai.ticklet.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.damai.common.image.a;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletSouvenirHolderView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private View partent;
    private ImageView souvenir_placeholer_image;

    public TickletSouvenirHolderView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "767583752")) {
            ipChange.ipc$dispatch("767583752", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_souvenir_holder_layout, this);
        this.partent = inflate;
        this.souvenir_placeholer_image = (ImageView) inflate.findViewById(R$id.souvenir_placeholer_image);
    }

    public void update(TicketSouvenirBean ticketSouvenirBean, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1278848386")) {
            ipChange.ipc$dispatch("-1278848386", new Object[]{this, ticketSouvenirBean, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (ticketSouvenirBean == null) {
        } else {
            if (!TextUtils.isEmpty(ticketSouvenirBean.nextImageUrl)) {
                a.b().e(ticketSouvenirBean.nextImageUrl).c(R$drawable.uikit_default_image_bg_grey).g(this.souvenir_placeholer_image);
            } else {
                this.souvenir_placeholer_image.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    public TickletSouvenirHolderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletSouvenirHolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
