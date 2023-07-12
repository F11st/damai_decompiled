package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.kn1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class UtExtra<Extra> implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String errorCode;
    public final String errorMsg;
    public final TbParams mParams;
    public final kn1<Extra> option;
    public final boolean success;

    public UtExtra(boolean z, TbParams tbParams, kn1<Extra> kn1Var, String str, String str2) {
        this.success = z;
        this.mParams = tbParams;
        this.option = kn1Var;
        this.errorCode = str;
        this.errorMsg = str2;
    }

    public static <Extra> UtExtra<Extra> fail(TbParams tbParams, kn1<Extra> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "680785954") ? (UtExtra) ipChange.ipc$dispatch("680785954", new Object[]{tbParams, kn1Var, str, str2}) : new UtExtra<>(false, tbParams, kn1Var, str, str2);
    }

    public static <Extra> UtExtra<Extra> success(TbParams tbParams, kn1<Extra> kn1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "178243855") ? (UtExtra) ipChange.ipc$dispatch("178243855", new Object[]{tbParams, kn1Var}) : new UtExtra<>(true, tbParams, kn1Var, null, null);
    }
}
