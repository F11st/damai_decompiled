package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.util.Base64;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.eb;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes.dex */
public class H5Privilege implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public int quantity;
    public String skuIds;

    public H5Privilege(String str, String str2, int i) {
        this.id = str;
        this.skuIds = str2;
        this.quantity = i;
    }

    @Nullable
    @Deprecated
    public static String toH5Privilege(@Nullable String str, PerformBean performBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "371427234")) {
            return (String) ipChange.ipc$dispatch("371427234", new Object[]{str, performBean});
        }
        if (eb.b(str)) {
            return null;
        }
        try {
            return new String(Base64.encode(JSON.toJSONString(new H5Privilege(str, eb.a(performBean), performBean.limitQuantity)).getBytes("utf-8"), 2), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
