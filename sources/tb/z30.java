package tb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class z30 {
    private static transient /* synthetic */ IpChange $ipChange;
    int[] a = {Color.parseColor("#FF9e6c"), Color.parseColor("#ffc088")};
    int[] b = {Color.parseColor("#FF92ba"), Color.parseColor("#ffb0de")};
    int[] c = {Color.parseColor("#a3a3ff"), Color.parseColor("#a8c2ff")};
    int[] d;
    int[][] e;

    public z30() {
        int[] iArr = {Color.parseColor("#7fcfff"), Color.parseColor("#7ce3ef")};
        this.d = iArr;
        this.e = new int[][]{this.a, this.b, this.c, iArr};
    }

    public static z30 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-720859983") ? (z30) ipChange.ipc$dispatch("-720859983", new Object[0]) : new z30();
    }

    public View b(Context context, Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643655932")) {
            return (View) ipChange.ipc$dispatch("643655932", new Object[]{this, context, day});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.copy_common_calendar_day_view, (ViewGroup) null);
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
        } else if (i == 1) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        } else if (i == 2) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById2.setPadding(k62.a(context, 3.0f), 0, 0, 0);
            findViewById2.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.copy_common_calendar_day_long_select_bg_left);
            findViewById.setBackgroundResource(R$drawable.copy_common_calendar_day_select_bg);
        } else if (i == 3) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById2.setPadding(0, 0, k62.a(context, 3.0f), 0);
            findViewById2.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.copy_common_calendar_day_long_select_bg_right);
            findViewById.setBackgroundResource(R$drawable.copy_common_calendar_day_select_bg);
        } else if (i == 4) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
        }
        if (day.showType == 0) {
            Resources resources = context.getResources();
            int i2 = R$color.color_999999;
            textView.setTextColor(resources.getColor(i2));
            textView2.setTextColor(context.getResources().getColor(i2));
        } else {
            textView.setTextColor(context.getResources().getColor(R$color.color_000000));
            textView2.setTextColor(context.getResources().getColor(R$color.color_666666));
        }
        ImageView imageView = (ImageView) inflate.findViewById(R$id.tv_day_tag_holiday);
        int i3 = day.dayType;
        if (i3 == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R$drawable.copy_calendar_icon_workday);
        } else if (i3 == 2) {
            imageView.setVisibility(0);
            imageView.setImageResource(R$drawable.copy_calendar_icon_holiday);
        } else {
            imageView.setVisibility(8);
        }
        int i4 = R$id.calendar_day_tip_rl;
        inflate.findViewById(i4).setVisibility(8);
        if (day.showType != 0) {
            int i5 = R$id.calendar_day_tip;
            TextView textView3 = (TextView) inflate.findViewById(i5);
            if (!TextUtils.isEmpty(day.tip)) {
                inflate.findViewById(i4).setVisibility(0);
                textView3.setText(day.tip);
            }
            if (day.tipBg != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(k62.a(context, 4.0f));
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColors(this.e[day.tipBg.toIndex()]);
                inflate.findViewById(i5).setBackground(gradientDrawable);
                ((TextView) inflate.findViewById(R$id.calendar_day_tip_arrow)).setTextColor(this.e[day.tipBg.toIndex()][0]);
            }
        }
        return inflate;
    }
}
