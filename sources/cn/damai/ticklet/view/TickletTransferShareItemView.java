package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.py2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferShareItemView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View partent;
    ImageView ticklet_online_tip;
    TextView ticklet_tip_text;
    DMIconFontTextView transfer_image;

    public TickletTransferShareItemView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885897260")) {
            ipChange.ipc$dispatch("885897260", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_transfer_share_item_view, this);
        this.partent = inflate;
        this.transfer_image = (DMIconFontTextView) inflate.findViewById(R$id.transfer_share_channer_icon);
        this.ticklet_online_tip = (ImageView) this.partent.findViewById(R$id.ticklet_online_tip);
        this.ticklet_tip_text = (TextView) this.partent.findViewById(R$id.ticklet_tip_text);
    }

    public void update(boolean z, String str, String str2, String str3, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149913345")) {
            ipChange.ipc$dispatch("-149913345", new Object[]{this, Boolean.valueOf(z), str, str2, str3, onClickListener});
            return;
        }
        if (z) {
            this.ticklet_online_tip.setVisibility(8);
            this.ticklet_tip_text.setTextColor(Color.parseColor("#666666"));
        } else {
            this.ticklet_online_tip.setVisibility(0);
            this.ticklet_tip_text.setTextColor(Color.parseColor("#99999999"));
        }
        py2.F(this.ticklet_tip_text, str3);
        this.transfer_image.setTextColor(Color.parseColor(str2));
        this.transfer_image.setText(str);
        if (onClickListener == null || !z) {
            return;
        }
        setOnClickListener(onClickListener);
    }

    public TickletTransferShareItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTransferShareItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
