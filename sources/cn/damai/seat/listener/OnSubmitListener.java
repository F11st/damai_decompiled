package cn.damai.seat.listener;

import android.os.Bundle;
import androidx.annotation.Nullable;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnSubmitListener extends OnPriceBarListener {
    void doNetWork(boolean z, boolean z2);

    void onOpenPurchase(@Nullable Bundle bundle);

    void onSubmitFailed(String str, String str2, String str3);

    void onSubmitSuccess(String str, OrderAfterChooseSeatInfo orderAfterChooseSeatInfo);

    void seatPreLockFailed();
}
