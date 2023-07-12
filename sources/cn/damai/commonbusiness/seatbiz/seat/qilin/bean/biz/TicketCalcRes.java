package cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TicketCalcRes implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CODE_20100002 = "20100002";
    public static final String CODE_20100003 = "20100003";
    public static final String CODE_2010001 = "2010001";
    public String errorCode;
    public String errorLevel;
    public String errorMsg;
    public TicketCalcBean model;
    public boolean success;

    public static boolean isCodeBlockBuyNow(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-862670661") ? ((Boolean) ipChange.ipc$dispatch("-862670661", new Object[]{str})).booleanValue() : TextUtils.equals(CODE_2010001, str) || TextUtils.equals(CODE_20100002, str) || TextUtils.equals(CODE_20100003, str);
    }

    public boolean isBizSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1374972639") ? ((Boolean) ipChange.ipc$dispatch("-1374972639", new Object[]{this})).booleanValue() : this.success && this.model != null;
    }
}
