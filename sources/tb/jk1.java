package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.PriceSummary;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class jk1 extends ik1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private PriceLevel e;
    private Map<String, HashMap<String, String>> f;
    private ArrayMap<String, String> g;
    private Map<String, List<PriceSummary>> h;

    public jk1(@Nullable PriceLevel priceLevel, PriceInfo priceInfo, List<Region> list, Map<String, HashMap<String, String>> map, ArrayMap<String, String> arrayMap) {
        super(list, priceInfo);
        this.h = new HashMap();
        this.e = priceLevel;
        this.g = arrayMap;
        try {
            j(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, HashMap<String, String>> i(Map<String, HashMap<String, String>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546970669")) {
            return (Map) ipChange.ipc$dispatch("546970669", new Object[]{this, map});
        }
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) ((map.size() / 0.75f) + 1.0f));
        for (Map.Entry<String, HashMap<String, String>> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        return hashMap;
    }

    private void j(Map<String, HashMap<String, String>> map) {
        PriceInfo priceInfo;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909344966")) {
            ipChange.ipc$dispatch("-909344966", new Object[]{this, map});
        } else if (!cb2.d(this.b) && (priceInfo = this.c) != null && priceInfo.standColor != null) {
            Map<String, HashMap<String, String>> i = i(map);
            this.f = i;
            if (cb2.f(i)) {
                return;
            }
            HashMap<String, ArrayList<PriceSummary>> hashMap = this.c.standColor;
            for (String str : this.f.keySet()) {
                HashMap<String, String> hashMap2 = this.f.get(str);
                if (!cb2.f(this.g)) {
                    ArrayList<PriceSummary> arrayList = hashMap.get(this.g.get(str));
                    if (!cb2.f(hashMap2)) {
                        for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
                            String value = entry.getValue();
                            if (cb2.d(arrayList)) {
                                entry.setValue("#DDE0E5");
                            } else {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= arrayList.size()) {
                                        z = false;
                                        break;
                                    } else if (k(value, arrayList.get(i2))) {
                                        z = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (!z) {
                                    entry.setValue("#DDE0E5");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            this.f = map;
        }
    }

    private static boolean k(String str, PriceSummary priceSummary) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "789704049")) {
            return ((Boolean) ipChange.ipc$dispatch("789704049", new Object[]{str, priceSummary})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || priceSummary == null) {
            return false;
        }
        return str.equalsIgnoreCase(priceSummary.color);
    }

    @Override // tb.g52
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679123889")) {
            ipChange.ipc$dispatch("679123889", new Object[]{this, iArr, shape});
            return;
        }
        e(shape);
        String str = shape.floorId;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(shape.rowId) || cb2.f(this.f)) {
            return;
        }
        if (this.e != null) {
            String str2 = null;
            Region h = h(str);
            if (h != null && !cb2.d(h.priceLevelIdList)) {
                if (this.e.isFreeCombineTiaoPiao()) {
                    List<PriceSummary> list = this.h.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        List<SubPrice> subPriceList = this.e.getSubPriceList();
                        ArrayList arrayList = new ArrayList();
                        if (!cb2.d(subPriceList)) {
                            for (SubPrice subPrice : subPriceList) {
                                if (h.priceLevelIdList.contains(Long.valueOf(subPrice.getPriceId()))) {
                                    arrayList.add(subPrice.getPriceId() + "");
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            ArrayList<PriceSummary> g = g(h.id + "");
                            if (!cb2.d(g)) {
                                Iterator<PriceSummary> it = g.iterator();
                                while (it.hasNext()) {
                                    PriceSummary next = it.next();
                                    if (arrayList.contains(next.priceId)) {
                                        list.add(next);
                                    }
                                }
                            }
                        }
                        this.h.put(str, list);
                    }
                    if (list.size() == 1) {
                        str2 = list.get(0).getFormatColor();
                    } else if (list.size() > 1) {
                        HashMap<String, String> hashMap = this.f.get(str);
                        if (!cb2.f(hashMap)) {
                            String str3 = hashMap.get(shape.rowId);
                            for (PriceSummary priceSummary : list) {
                                if (k(str3, priceSummary)) {
                                    str2 = priceSummary.getFormatColor();
                                }
                            }
                        }
                    }
                } else if (h.priceLevelIdList.contains(Long.valueOf(this.e.getPriceId()))) {
                    PriceSummary f = f(g(h.id + ""), this.e);
                    if (f != null) {
                        str2 = f.getFormatColor();
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                HashMap<String, String> hashMap2 = this.f.get(str);
                if (cb2.f(hashMap2)) {
                    return;
                }
                String str4 = hashMap2.get(shape.rowId);
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                iArr[0] = a(c(str4));
                iArr[1] = a(shape.strokeColor);
                return;
            }
            iArr[0] = c(str2);
            return;
        }
        HashMap<String, String> hashMap3 = this.f.get(str);
        if (hashMap3 != null) {
            String str5 = hashMap3.get(shape.rowId);
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            iArr[0] = c(str5);
        }
    }
}
