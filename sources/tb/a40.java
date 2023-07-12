package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a40 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static a40 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2068005089") ? (a40) ipChange.ipc$dispatch("2068005089", new Object[0]) : new a40();
    }

    public View b(Context context, DayEntity dayEntity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "303236042")) {
            return (View) ipChange.ipc$dispatch("303236042", new Object[]{this, context, dayEntity});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.sku_calendar_day_view, (ViewGroup) null);
        if (dayEntity == null) {
            return inflate;
        }
        View findViewById = inflate.findViewById(R$id.layout_day);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_day);
        TextView textView2 = (TextView) inflate.findViewById(R$id.top_tag);
        TextView textView3 = (TextView) inflate.findViewById(R$id.bottom_tag);
        textView.setText(dayEntity.day + "");
        if (TextUtils.isEmpty(dayEntity.bottomTag)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(dayEntity.bottomTag);
        }
        if (dayEntity.hasPerform) {
            if (dayEntity.hasPermission) {
                textView.setTextColor(context.getResources().getColor(R$color.color_000000));
                if (dayEntity.isSelected) {
                    if (dayEntity.isSeePage) {
                        findViewById.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg_red);
                    } else {
                        findViewById.setBackgroundResource(R$drawable.ncov_sku_calendar_day_select_bg);
                    }
                } else {
                    findViewById.setBackgroundResource(R$drawable.ncov_sku_calendar_day_bg);
                }
            } else {
                textView.setTextColor(context.getResources().getColor(R$color.color_cccccc));
            }
        } else {
            textView.setTextColor(context.getResources().getColor(R$color.color_cccccc));
        }
        if (dayEntity.validTag()) {
            textView2.setVisibility(0);
            textView2.setText(dayEntity.getValidTag());
            if (!dayEntity.isPositive()) {
                textView2.setTextColor(context.getResources().getColor(R$color.color_6A7A99));
            } else {
                textView2.setTextColor(context.getResources().getColor(R$color.color_FF2869));
            }
        } else {
            textView2.setVisibility(8);
        }
        return inflate;
    }
}
