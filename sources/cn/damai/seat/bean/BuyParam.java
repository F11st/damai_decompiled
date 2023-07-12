package cn.damai.seat.bean;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCombineInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BuyParam implements IBuyParam, Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 882;
    public int count;
    public long itemId;
    public long skuId;

    public BuyParam(long j, long j2, int i) {
        this.itemId = j;
        this.skuId = j2;
        this.count = i;
    }

    public static void bindItemId(@NonNull List<TicketCombineInfo> list, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "241648522")) {
            ipChange.ipc$dispatch("241648522", new Object[]{list, Long.valueOf(j)});
            return;
        }
        for (TicketCombineInfo ticketCombineInfo : list) {
            ticketCombineInfo.itemId = j + "";
        }
    }

    public static String concatBuyParams(@NonNull List<? extends IBuyParam> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184908497")) {
            return (String) ipChange.ipc$dispatch("1184908497", new Object[]{list});
        }
        StringBuilder sb = new StringBuilder();
        for (IBuyParam iBuyParam : list) {
            String itemId = iBuyParam.getItemId();
            String count = iBuyParam.getCount();
            String skuId = iBuyParam.getSkuId();
            sb.append(itemId);
            sb.append(JSMethod.NOT_SET);
            sb.append(count);
            sb.append(JSMethod.NOT_SET);
            sb.append(skuId);
            sb.append(",");
        }
        String sb2 = sb.toString();
        return sb2.length() > 1 ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    @Nullable
    public static List<BuyParam> toBuyParamList(long j, ArrayMap<String, ArrayList<SeatGroup>> arrayMap, IPriceManager iPriceManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428817220")) {
            return (List) ipChange.ipc$dispatch("1428817220", new Object[]{Long.valueOf(j), arrayMap, iPriceManager});
        }
        if (cb2.c(arrayMap) || iPriceManager == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arrayMap.size(); i++) {
            ArrayList<SeatGroup> valueAt = arrayMap.valueAt(i);
            if (!cb2.d(valueAt)) {
                for (int i2 = 0; i2 < valueAt.size(); i2++) {
                    BuyParam buyParam = new BuyParam(j, iPriceManager.getBuySkuId(valueAt.get(i2).priceId), 1);
                    int indexOf = arrayList.indexOf(buyParam);
                    if (indexOf >= 0) {
                        ((BuyParam) arrayList.get(indexOf)).count++;
                    } else {
                        arrayList.add(buyParam);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "439119253") ? ((Boolean) ipChange.ipc$dispatch("439119253", new Object[]{this, obj})).booleanValue() : (obj instanceof BuyParam) && this.skuId == ((BuyParam) obj).skuId;
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "263456421")) {
            return (String) ipChange.ipc$dispatch("263456421", new Object[]{this});
        }
        return this.count + "";
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032925806")) {
            return (String) ipChange.ipc$dispatch("1032925806", new Object[]{this});
        }
        return this.itemId + "";
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.IBuyParam
    public String getSkuId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667896366")) {
            return (String) ipChange.ipc$dispatch("667896366", new Object[]{this});
        }
        return this.skuId + "";
    }
}
