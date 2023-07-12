package tb;

import android.graphics.Bitmap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.seat.bean.HeadBean;
import cn.damai.seat.listener.seatui.OnJpgRegionUiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class g61 implements OnJpgRegionUiListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnJpgRegionUiListener a;

    public void a(OnJpgRegionUiListener onJpgRegionUiListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392791877")) {
            ipChange.ipc$dispatch("-392791877", new Object[]{this, onJpgRegionUiListener});
        } else {
            this.a = onJpgRegionUiListener;
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void onFail(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453474170")) {
            ipChange.ipc$dispatch("-1453474170", new Object[]{this, Integer.valueOf(i), str, str2, str3});
            return;
        }
        OnJpgRegionUiListener onJpgRegionUiListener = this.a;
        if (onJpgRegionUiListener != null) {
            onJpgRegionUiListener.onFail(i, str, (i == 111 || i == 222) ? "麦麦开小差了，请稍后重试哦" : "麦麦开小差了，请稍后重试哦", str3);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showHeadView(HeadBean headBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1769366059")) {
            ipChange.ipc$dispatch("1769366059", new Object[]{this, headBean});
            return;
        }
        OnJpgRegionUiListener onJpgRegionUiListener = this.a;
        if (onJpgRegionUiListener != null) {
            onJpgRegionUiListener.showHeadView(headBean);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void showPriceList(List<? extends PriceLevel> list, PriceLevel priceLevel, g92 g92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362439765")) {
            ipChange.ipc$dispatch("1362439765", new Object[]{this, list, priceLevel, g92Var});
            return;
        }
        OnJpgRegionUiListener onJpgRegionUiListener = this.a;
        if (onJpgRegionUiListener != null) {
            onJpgRegionUiListener.showPriceList(list, priceLevel, g92Var);
        }
    }

    @Override // cn.damai.seat.listener.seatui.OnJpgRegionUiListener
    public void showRegionUi(Bitmap bitmap, List<Region> list, PriceLevel priceLevel, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713418429")) {
            ipChange.ipc$dispatch("1713418429", new Object[]{this, bitmap, list, priceLevel, Boolean.valueOf(z)});
            return;
        }
        OnJpgRegionUiListener onJpgRegionUiListener = this.a;
        if (onJpgRegionUiListener != null) {
            onJpgRegionUiListener.showRegionUi(bitmap, list, priceLevel, z);
        }
    }

    @Override // cn.damai.seat.listener.seatui.ApiType
    public void toast(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745322536")) {
            ipChange.ipc$dispatch("-745322536", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        OnJpgRegionUiListener onJpgRegionUiListener = this.a;
        if (onJpgRegionUiListener != null) {
            onJpgRegionUiListener.toast(i);
        }
    }
}
