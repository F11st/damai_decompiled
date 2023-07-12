package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletSouvenIrCustomView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    private boolean isCheck;
    View parent;
    private TextView ticklet_detail_item_tip;
    private ImageView ticklet_item_image;

    public TickletSouvenIrCustomView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122875565")) {
            ipChange.ipc$dispatch("1122875565", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_souvenir_custom_view, this);
        this.parent = inflate;
        this.ticklet_item_image = (ImageView) inflate.findViewById(R$id.ticklet_item_icon);
        this.ticklet_detail_item_tip = (TextView) this.parent.findViewById(R$id.ticklet_content);
    }

    public boolean isCheck() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-247279122") ? ((Boolean) ipChange.ipc$dispatch("-247279122", new Object[]{this})).booleanValue() : this.isCheck;
    }

    public void setCheck(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075295944")) {
            ipChange.ipc$dispatch("-1075295944", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isCheck = z;
        }
    }

    public void setIconStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "535650408")) {
            ipChange.ipc$dispatch("535650408", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            this.ticklet_item_image.setImageResource(R$drawable.ticklet_souvenir_custom_press_icon);
        } else {
            this.ticklet_item_image.setImageResource(R$drawable.ticklet_souvenir_custom_unpress_icon);
        }
        setCheck(z);
    }

    public void update(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-536676559")) {
            ipChange.ipc$dispatch("-536676559", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        this.ticklet_detail_item_tip.setText(str);
        if (z) {
            this.ticklet_item_image.setImageResource(R$drawable.ticklet_souvenir_custom_press_icon);
        } else {
            this.ticklet_item_image.setImageResource(R$drawable.ticklet_souvenir_custom_unpress_icon);
        }
    }

    public TickletSouvenIrCustomView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletSouvenIrCustomView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isCheck = true;
        this.context = context;
        initView();
    }
}
