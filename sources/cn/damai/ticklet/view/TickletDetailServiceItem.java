package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
public class TickletDetailServiceItem extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    View parent;
    private TextView ticklet_detail_service_item_title;
    private DMIconFontTextView tiklet_detail_service_item_icon;

    public TickletDetailServiceItem(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280314391")) {
            ipChange.ipc$dispatch("280314391", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_detail_service_item_layout, this);
        this.parent = inflate;
        this.ticklet_detail_service_item_title = (TextView) inflate.findViewById(R$id.ticklet_detail_service_item_title);
        this.tiklet_detail_service_item_icon = (DMIconFontTextView) this.parent.findViewById(R$id.tiklet_detail_service_item_icon);
    }

    public void update(String str, int i, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1979209027")) {
            ipChange.ipc$dispatch("1979209027", new Object[]{this, str, Integer.valueOf(i), onClickListener});
            return;
        }
        py2.F(this.ticklet_detail_service_item_title, str);
        if (i != 0) {
            this.tiklet_detail_service_item_icon.setVisibility(0);
            this.tiklet_detail_service_item_icon.setText(this.context.getResources().getString(i));
        } else {
            this.tiklet_detail_service_item_icon.setVisibility(8);
        }
        setOnClickListener(onClickListener);
    }

    public TickletDetailServiceItem(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletDetailServiceItem(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
