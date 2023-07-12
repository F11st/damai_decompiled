package cn.damai.trade.newtradeorder.ui.orderdetail.bean;

import android.content.Context;
import androidx.core.content.ContextCompat;
import cn.damai.trade.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrderDetailProgressBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String nodeName;
    public int nodeStatus;
    public List<OrderDetailProgressChild> orderProgressItems;

    public int getColor(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599959638")) {
            return ((Integer) ipChange.ipc$dispatch("599959638", new Object[]{this, context})).intValue();
        }
        int i = this.nodeStatus;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return ContextCompat.getColor(context, R$color.color_999999);
                }
                return ContextCompat.getColor(context, R$color.color_FF2D79);
            }
            return ContextCompat.getColor(context, R$color.color_FF2D79);
        }
        return ContextCompat.getColor(context, R$color.color_999999);
    }

    public boolean noStartNode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1976758695") ? ((Boolean) ipChange.ipc$dispatch("-1976758695", new Object[]{this})).booleanValue() : this.nodeStatus == 1;
    }
}
