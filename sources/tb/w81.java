package tb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.view.SimpleTitleLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class w81 implements SimpleTitleLayout.LeftActionView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private View b;
    private TextView c;
    private TextView d;
    private int e;

    public w81(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_back_btn_right_city_select, (ViewGroup) null);
        this.b = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        this.d = (TextView) this.b.findViewById(R$id.id_btr_city_icon);
        this.c = (TextView) this.b.findViewById(R$id.id_btr_city_name);
        this.b.setOnClickListener(onClickListener);
        this.e = Color.parseColor("#5F6672");
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992789306")) {
            ipChange.ipc$dispatch("1992789306", new Object[]{this, str});
        } else {
            this.c.setText(str);
        }
    }

    @Override // cn.damai.uikit.view.SimpleTitleLayout.LeftActionView
    public View getLeftView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-461073848") ? (View) ipChange.ipc$dispatch("-461073848", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.uikit.view.SimpleTitleLayout.LeftActionView
    public void switchMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "409653641")) {
            ipChange.ipc$dispatch("409653641", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.c.setTextColor(-16777216);
            this.d.setTextColor(this.e);
        } else {
            this.c.setTextColor(-1);
            this.d.setTextColor(-1);
        }
    }
}
