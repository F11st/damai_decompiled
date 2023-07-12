package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.bean.SeatProfile;
import cn.damai.seat.listener.seatui.OnJpgSeatUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class h61 implements OnJpgSeatUiListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnJpgSeatUiListener a;

    public void a(OnJpgSeatUiListener onJpgSeatUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1095357671")) {
            ipChange.ipc$dispatch("-1095357671", new Object[]{this, onJpgSeatUiListener});
        } else {
            this.a = onJpgSeatUiListener;
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void onFail(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1668262423")) {
            ipChange.ipc$dispatch("1668262423", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.onFail(i, str, (i == 111 || i == 222) ? "麦麦开小差了，请稍后重试哦" : "麦麦开小差了，请稍后重试哦", str3);
        }
    }

    @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
    public void onSelectSeatChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1603407727")) {
            ipChange.ipc$dispatch("1603407727", new Object[]{this});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.onSelectSeatChanged();
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showHeadView(HeadBean headBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2424772")) {
            ipChange.ipc$dispatch("-2424772", new Object[]{this, headBean});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.showHeadView(headBean);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, g92 g92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548659558")) {
            ipChange.ipc$dispatch("548659558", new Object[]{this, list, priceLevel, g92Var});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.showPriceList(list, priceLevel, g92Var);
        }
    }

    @Override // cn.damai.seat.listener.seatui.OnJpgSeatUiListener
    public void showSeatUi(SeatProfile seatProfile, g92 g92Var, PriceLevel priceLevel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520215668")) {
            ipChange.ipc$dispatch("-1520215668", new Object[]{this, seatProfile, g92Var, priceLevel, Boolean.valueOf(z)});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.showSeatUi(seatProfile, g92Var, priceLevel, z);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void toast(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-761870489")) {
            ipChange.ipc$dispatch("-761870489", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        OnJpgSeatUiListener onJpgSeatUiListener = this.a;
        if (onJpgSeatUiListener != null) {
            onJpgSeatUiListener.toast(i);
        }
    }
}
