package cn.damai.seat.bean;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.ShortTag;
import cn.damai.seat.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PriceBarInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean clickableV2;
    public boolean isPayFirstV2 = true;
    public int limitTotalCount;
    public int selectedCount;
    @Nullable
    public String tipMsgV2;
    public SpannableString tipSpanV2;
    @Nullable
    public String toastMsg;
    public String totalPriceTextV2;
    public List<ShortTag> usedPromotionList;

    public PriceBarInfo(String str, @Nullable String str2, boolean z) {
        this.totalPriceTextV2 = str;
        this.tipMsgV2 = str2;
        this.clickableV2 = z;
    }

    public void shouldToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1705668101")) {
            ipChange.ipc$dispatch("-1705668101", new Object[]{this, str});
        } else {
            this.toastMsg = str;
        }
    }

    public PriceBarInfo(String str, @Nullable String str2, boolean z, List<ShortTag> list) {
        this.totalPriceTextV2 = str;
        this.tipMsgV2 = str2;
        this.clickableV2 = z;
        this.usedPromotionList = list;
    }

    public PriceBarInfo(int i, int i2) {
        this.limitTotalCount = i;
        this.selectedCount = i2;
        this.clickableV2 = i2 == i;
        String str = "已选 " + this.selectedCount + "/" + this.limitTotalCount + "张";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mu0.a(), R$color.black)), 0, str.indexOf("/"), 33);
        this.tipSpanV2 = spannableString;
    }
}
