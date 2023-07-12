package tb;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceSummary;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class ik1 extends g52 {
    private static transient /* synthetic */ IpChange $ipChange;
    protected final List<Region> b;
    protected final PriceInfo c;
    private final ArrayMap<String, Region> d = new ArrayMap<>();

    public ik1(List<Region> list, PriceInfo priceInfo) {
        this.b = list;
        this.c = priceInfo;
        if (cb2.d(list)) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            Region region = this.b.get(i);
            this.d.put(region.vid, region);
        }
    }

    @Nullable
    public PriceSummary f(@Nullable ArrayList<PriceSummary> arrayList, @Nullable PriceLevel priceLevel) {
        long j;
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672037583")) {
            return (PriceSummary) ipChange.ipc$dispatch("1672037583", new Object[]{this, arrayList, priceLevel});
        }
        if (!cb2.d(arrayList) && priceLevel != null) {
            if (priceLevel.isFreeCombineTiaoPiao()) {
                HashSet<Long> subPriceIds = priceLevel.getSubPriceIds();
                if (subPriceIds != null) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        PriceSummary priceSummary = arrayList.get(size);
                        try {
                            j2 = Long.parseLong(priceSummary.priceId);
                        } catch (Exception unused) {
                            j2 = 0;
                        }
                        if (subPriceIds.contains(Long.valueOf(j2))) {
                            return priceSummary;
                        }
                    }
                }
            } else {
                Iterator<PriceSummary> it = arrayList.iterator();
                while (it.hasNext()) {
                    PriceSummary next = it.next();
                    try {
                        j = Long.parseLong(next.priceId);
                    } catch (Exception unused2) {
                        j = 0;
                    }
                    if (j == priceLevel.getPriceId()) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public ArrayList<PriceSummary> g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134175717")) {
            return (ArrayList) ipChange.ipc$dispatch("2134175717", new Object[]{this, str});
        }
        PriceInfo priceInfo = this.c;
        if (priceInfo == null || cb2.f(priceInfo.standColor)) {
            return null;
        }
        return this.c.standColor.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Region h(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "248973599") ? (Region) ipChange.ipc$dispatch("248973599", new Object[]{this, str}) : this.d.get(str);
    }
}
