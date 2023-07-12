package cn.damai.seat.support.combine;

import android.graphics.Color;
import androidx.collection.ArrayMap;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.PriceManagerImpl;
import cn.damai.seat.listener.OnTListener;
import cn.damai.seat.listener.OnTMainThreadListener;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.r92;
import tb.t82;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SeatCombineTask implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int areaInfoVersion;
    private final long itemId;
    private final SeatBox mBox;
    private final OnTListener<List<String>> mListener;
    private final SeatStateParent mParent;
    private IPriceManager mPriceManager;
    private final long performId;

    public SeatCombineTask(long j, long j2, int i, SeatBox seatBox, IPriceManager iPriceManager, SeatStateParent seatStateParent, OnTListener<List<String>> onTListener) {
        this.itemId = j;
        this.performId = j2;
        this.areaInfoVersion = i;
        this.mBox = seatBox;
        this.mPriceManager = iPriceManager == null ? PriceManagerImpl.emptyManager() : iPriceManager;
        this.mParent = seatStateParent;
        this.mListener = new OnTMainThreadListener(onTListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        PriceLine findSalablePriceLine;
        boolean z;
        SeatStateChild seatStateChild;
        List<SeatNew> list;
        boolean z2;
        int length;
        int size;
        IpChange ipChange = $ipChange;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1567598206")) {
            ipChange.ipc$dispatch("-1567598206", new Object[]{this});
            return;
        }
        SeatBox seatBox = this.mBox;
        if (seatBox == null || cb2.c(seatBox.seatNewMap) || this.mParent == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = null;
        boolean isCompress = this.mParent.isCompress();
        ArrayList arrayList = new ArrayList();
        ArrayMap<String, List<SeatNew>> arrayMap = this.mBox.seatNewMap;
        int i = 0;
        while (i < arrayMap.size()) {
            String keyAt = arrayMap.keyAt(i);
            SeatStateChild child = this.mParent.getChild(keyAt);
            if (child != null) {
                arrayList.add(keyAt);
                List<SeatNew> valueAt = arrayMap.valueAt(i);
                if (!cb2.d(valueAt)) {
                    if (isCompress && (length = child.getLength()) != (size = valueAt.size())) {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append("area_");
                        sb.append(keyAt);
                        sb.append("_seat_");
                        sb.append(size);
                        sb.append("_state_");
                        sb.append(length);
                        sb.append(",");
                    }
                    int i2 = 0;
                    while (i2 < valueAt.size()) {
                        SeatNew seatNew = valueAt.get(i2);
                        seatNew.isSelected = z3;
                        boolean z4 = seatNew.isPackaged;
                        long j = z4 ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
                        if (z4) {
                            findSalablePriceLine = this.mPriceManager.findSalablePackagePriceLevel(j);
                        } else {
                            findSalablePriceLine = this.mPriceManager.findSalablePriceLine(j);
                        }
                        if (findSalablePriceLine == null) {
                            seatNew.state = 8;
                            z = isCompress;
                            seatStateChild = child;
                            list = valueAt;
                        } else {
                            seatNew.state = child.getState(seatNew);
                            if (z4) {
                                List<SubPrice> subPriceList = ((PriceLevel) findSalablePriceLine).getSubPriceList();
                                if (!cb2.d(subPriceList)) {
                                    Iterator<SubPrice> it = subPriceList.iterator();
                                    while (it.hasNext()) {
                                        SubPrice next = it.next();
                                        Iterator<SubPrice> it2 = it;
                                        z = isCompress;
                                        seatStateChild = child;
                                        list = valueAt;
                                        if (seatNew.priceLevel == next.priceId) {
                                            seatNew.seatColor = next.colorInt();
                                            z2 = true;
                                            break;
                                        }
                                        isCompress = z;
                                        it = it2;
                                        child = seatStateChild;
                                        valueAt = list;
                                    }
                                }
                                z = isCompress;
                                seatStateChild = child;
                                list = valueAt;
                                z2 = false;
                                if (!z2) {
                                    seatNew.seatColor = Color.parseColor("#000000");
                                }
                                seatNew.seatTaoPiaoValue = findSalablePriceLine.originalPrice();
                            } else {
                                z = isCompress;
                                seatStateChild = child;
                                list = valueAt;
                                seatNew.seatColor = findSalablePriceLine.colorInt();
                                seatNew.seatValue = findSalablePriceLine.originalPrice();
                            }
                        }
                        i2++;
                        isCompress = z;
                        child = seatStateChild;
                        valueAt = list;
                        z3 = false;
                    }
                }
            }
            i++;
            isCompress = isCompress;
            z3 = false;
        }
        if (sb != null) {
            String str = this.itemId + "";
            t82.h(str, this.performId + "", "version_" + this.areaInfoVersion + JSMethod.NOT_SET + sb.toString());
        }
        if (AppConfig.v()) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            r92.f("SeatCombineTask:座位合成" + arrayList.size() + "个区域" + this.mBox.getTotalSeatCount() + "个座位耗时" + currentTimeMillis2 + "ms," + JSON.toJSONString(arrayList));
        }
        this.mListener.call(arrayList);
    }
}
