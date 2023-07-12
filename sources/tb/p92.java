package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.listener.seatui.OnSeatUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class p92 implements OnSeatUiListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnSeatUiListener a;

    public void a(OnSeatUiListener onSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496791545")) {
            ipChange.ipc$dispatch("-496791545", new Object[]{this, onSeatUiListener});
        } else {
            this.a = onSeatUiListener;
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void onFail(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380369346")) {
            ipChange.ipc$dispatch("380369346", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.onFail(i, str, (i == 111 || i == 222) ? "麦麦开小差了，请稍后重试哦" : "麦麦开小差了，请稍后重试哦", str3);
        }
    }

    @Override // cn.damai.seat.listener.seatui.OnSeatUiListener
    public void onSelectSeatChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222333658")) {
            ipChange.ipc$dispatch("1222333658", new Object[]{this});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.onSelectSeatChanged();
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showHeadView(HeadBean headBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030591335")) {
            ipChange.ipc$dispatch("1030591335", new Object[]{this, headBean});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.showHeadView(headBean);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, g92 g92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1387498385")) {
            ipChange.ipc$dispatch("1387498385", new Object[]{this, list, priceLevel, g92Var});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.showPriceList(list, priceLevel, g92Var);
        }
    }

    @Override // cn.damai.seat.listener.seatui.OnSeatUiListener
    public void showSeatUi(s92 s92Var, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2000765454")) {
            ipChange.ipc$dispatch("-2000765454", new Object[]{this, s92Var, Boolean.valueOf(z)});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.showSeatUi(s92Var, z);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void toast(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605505052")) {
            ipChange.ipc$dispatch("1605505052", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        OnSeatUiListener onSeatUiListener = this.a;
        if (onSeatUiListener != null) {
            onSeatUiListener.toast(i);
        }
    }
}
