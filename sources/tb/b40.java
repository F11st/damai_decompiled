package tb;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.category.calendar.bean.Day;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b40 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static b40 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1028178107") ? (b40) ipChange.ipc$dispatch("1028178107", new Object[0]) : new b40();
    }

    public View b(Context context, Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1145514151")) {
            return (View) ipChange.ipc$dispatch("-1145514151", new Object[]{this, context, day});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.calendar_day_view, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.view_bg);
        View findViewById2 = inflate.findViewById(R$id.view_long_select);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_day);
        TextView textView2 = (TextView) inflate.findViewById(R$id.tv_day_tag);
        if (day == null) {
            return inflate;
        }
        textView.setText(day.day + "");
        textView2.setText(day.tag);
        if (day.showType == 1) {
            textView2.setText("今天");
        }
        int i = day.selectType;
        if (i == 0) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            textView.setTextColor(context.getResources().getColor(R$color.color_000000));
            textView2.setTextColor(context.getResources().getColor(R$color.color_666666));
        } else if (i == 1) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
            Resources resources = context.getResources();
            int i2 = R$color.color_FF2D79;
            textView.setTextColor(resources.getColor(i2));
            textView2.setTextColor(context.getResources().getColor(i2));
        } else if (i == 2) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById2.setBackgroundResource(R$drawable.calendar_day_left_select_bg);
            Resources resources2 = context.getResources();
            int i3 = R$color.color_FF2D79;
            textView.setTextColor(resources2.getColor(i3));
            textView2.setTextColor(context.getResources().getColor(i3));
        } else if (i == 3) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById2.setBackgroundResource(R$drawable.calendar_day_long_select_bg);
            Resources resources3 = context.getResources();
            int i4 = R$color.color_FF2D79;
            textView.setTextColor(resources3.getColor(i4));
            textView2.setTextColor(context.getResources().getColor(i4));
        } else if (i == 4) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            findViewById2.setBackgroundResource(R$drawable.calendar_day_right_select_bg);
            Resources resources4 = context.getResources();
            int i5 = R$color.color_FF2D79;
            textView.setTextColor(resources4.getColor(i5));
            textView2.setTextColor(context.getResources().getColor(i5));
        }
        if (day.showType == 0) {
            Resources resources5 = context.getResources();
            int i6 = R$color.color_999999;
            textView.setTextColor(resources5.getColor(i6));
            textView2.setTextColor(context.getResources().getColor(i6));
        }
        return inflate;
    }
}
