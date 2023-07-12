package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener;

import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnAreaInfoListener {
    void onFail(String str, long j, String str2, String str3);

    void onSuccess(String str, long j, long j2, RegionData regionData);
}
