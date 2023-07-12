package cn.damai.seat.listener;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface OnPerformListener {
    void doNetWork(boolean z);

    void onNetFail(String str, String str2);

    void onPerformChanged(TbParams tbParams, boolean z);

    void onPriceChangedOnly();
}
