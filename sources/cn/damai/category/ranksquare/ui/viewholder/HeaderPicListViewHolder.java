package cn.damai.category.ranksquare.ui.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;
import tb.m91;
import tb.mu0;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HeaderPicListViewHolder extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int IMAGE_MARGIN;
    private final int IMAGE_SCALE;
    private final int MAX;
    private final int ORIGINAL;

    public HeaderPicListViewHolder(Context context) {
        super(context);
        this.ORIGINAL = 0;
        this.IMAGE_SCALE = 16;
        this.IMAGE_MARGIN = 10;
        this.MAX = 3;
    }

    public void setData(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078171263")) {
            ipChange.ipc$dispatch("-2078171263", new Object[]{this, list});
        } else if (!m91.a(list)) {
            removeAllViews();
            for (int i = 3; i >= 0; i--) {
                View inflate = LayoutInflater.from(getContext()).inflate(R$layout.square_header_pic, (ViewGroup) null);
                DMImageCreator f = a.b().h(mu0.a()).f(list.get(i), m62.a(mu0.a(), 16.0f), m62.a(mu0.a(), 16.0f));
                int i2 = R$drawable.uikit_user_default_icon_trans_white;
                f.i(i2).c(i2).k(new yq()).g((ImageView) inflate.findViewById(R$id.image_buy_user));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                if (i > 0) {
                    layoutParams.setMargins(m62.a(getContext(), i * 10), 0, 0, 0);
                }
                addView(inflate, layoutParams);
            }
        }
    }

    public HeaderPicListViewHolder(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ORIGINAL = 0;
        this.IMAGE_SCALE = 16;
        this.IMAGE_MARGIN = 10;
        this.MAX = 3;
    }
}
