package cn.damai.tetris.component.drama.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.jm1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DramaV2Bean implements IDramaBean, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String headPic;
    public String id;
    public String ipvuv;
    public String itemScore;
    public String itemScoreDefault;
    public String itemStar;
    public int mustSeePos = -1;
    public String name;

    @Override // cn.damai.tetris.component.drama.bean.IDramaBean
    public String getDramaId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1176023342") ? (String) ipChange.ipc$dispatch("1176023342", new Object[]{this}) : this.id;
    }

    public long getIpvuvValue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1985652791") ? ((Long) ipChange.ipc$dispatch("-1985652791", new Object[]{this})).longValue() : jm1.k(this.ipvuv, -1L);
    }

    public double getScoreValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1357537979")) {
            return ((Double) ipChange.ipc$dispatch("-1357537979", new Object[]{this})).doubleValue();
        }
        if (TextUtils.isEmpty(this.itemScore)) {
            return -1.0d;
        }
        try {
            return Double.parseDouble(this.itemScore);
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0d;
        }
    }
}
