package tb;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLine;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketMainUiModel;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketSubUiModel;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.seat.R$string;
import cn.damai.seat.bean.ItemSeatV2;
import cn.damai.seat.bean.SeatGroup;
import cn.damai.seat.bean.Tuple;
import cn.damai.seat.bean.biz.Price;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class f92 extends eb {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.f92$a */
    /* loaded from: classes7.dex */
    public class C9132a implements Comparator<SeatNew> {
        private static transient /* synthetic */ IpChange $ipChange;

        C9132a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(SeatNew seatNew, SeatNew seatNew2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "324476982")) {
                return ((Integer) ipChange.ipc$dispatch("324476982", new Object[]{this, seatNew, seatNew2})).intValue();
            }
            return (seatNew.sid + "").compareTo(seatNew2.sid + "");
        }
    }

    public static boolean A(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280856987")) {
            return ((Boolean) ipChange.ipc$dispatch("-280856987", new Object[]{list})).booleanValue();
        }
        if (!cb2.d(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isSalable()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    public static PriceLevel B(List<? extends PriceLevel> list, PriceLevel priceLevel) {
        int indexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1697391638")) {
            return (PriceLevel) ipChange.ipc$dispatch("-1697391638", new Object[]{list, priceLevel});
        }
        if (cb2.d(list) || priceLevel == null || (indexOf = list.indexOf(priceLevel)) < 0) {
            return null;
        }
        PriceLevel priceLevel2 = list.get(indexOf);
        if (priceLevel2.isSalable()) {
            return priceLevel2;
        }
        return null;
    }

    @Nullable
    public static Region C(String str, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1210951691")) {
            return (Region) ipChange.ipc$dispatch("-1210951691", new Object[]{str, regionData});
        }
        if (regionData == null || !regionData.checkBaseValid()) {
            return null;
        }
        Iterator<Region> it = regionData.ri.regionList.iterator();
        while (it.hasNext()) {
            Region next = it.next();
            if (TextUtils.equals(next.id + "", str)) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public static PriceLevel D(long j) {
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255311013")) {
            return (PriceLevel) ipChange.ipc$dispatch("255311013", new Object[]{Long.valueOf(j)});
        }
        lk1 b = mk1.a().b(j);
        if (b == null || (priceBean = b.d) == null) {
            return null;
        }
        return new Price(priceBean);
    }

    public static List<PriceLevel> E(List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052110230")) {
            return (List) ipChange.ipc$dispatch("-1052110230", new Object[]{list});
        }
        ArrayList arrayList = new ArrayList();
        if (!cb2.d(list)) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static void F(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "100190936")) {
            ipChange.ipc$dispatch("100190936", new Object[]{textView, str});
            return;
        }
        textView.setText(str);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public static String G(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831734894")) {
            return (String) ipChange.ipc$dispatch("-1831734894", new Object[]{list});
        }
        if (cb2.d(list)) {
            return "";
        }
        ArrayList<SeatNew> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C9132a());
        StringBuilder sb = new StringBuilder();
        for (SeatNew seatNew : arrayList) {
            sb.append(seatNew.sid);
        }
        return sb.toString();
    }

    private static void H(List<SeatNew> list, PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050960700")) {
            ipChange.ipc$dispatch("-2050960700", new Object[]{list, priceLevel});
        } else if (cb2.d(list) || priceLevel == null) {
        } else {
            List<SubPrice> subPriceList = priceLevel.getSubPriceList();
            if (cb2.d(subPriceList)) {
                return;
            }
            Collections.sort(list, new np1(subPriceList));
        }
    }

    public static long c(long j, long j2) {
        PerformBean performBean;
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895425427")) {
            return ((Long) ipChange.ipc$dispatch("1895425427", new Object[]{Long.valueOf(j), Long.valueOf(j2)})).longValue();
        }
        lk1 b = mk1.a().b(j);
        if (b == null || (performBean = b.c) == null || (priceBean = b.d) == null || performBean.performId != j2) {
            return -1L;
        }
        List<PriceBean> list = performBean.skuList;
        if (cb2.d(list)) {
            return -1L;
        }
        for (int i = 0; i < list.size(); i++) {
            long j3 = list.get(i).skuId;
            long j4 = priceBean.skuId;
            if (j3 == j4) {
                return j4;
            }
        }
        return -1L;
    }

    public static double d(List<SeatNew> list) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899071885")) {
            return ((Double) ipChange.ipc$dispatch("899071885", new Object[]{list})).doubleValue();
        }
        double d = 0.0d;
        if (!cb2.d(list)) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SeatNew seatNew = list.get(i);
                if (seatNew.isPackaged) {
                    if (!arrayList.contains(Long.valueOf(seatNew.packageCombinedId))) {
                        arrayList.add(Long.valueOf(seatNew.packageCombinedId));
                        f = seatNew.seatTaoPiaoValue;
                    }
                } else {
                    f = seatNew.seatValue;
                }
                d += f;
            }
        }
        return d;
    }

    public static String e(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380444711")) {
            return (String) ipChange.ipc$dispatch("-380444711", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (SeatNew seatNew : list) {
            long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            sb.append(seatNew.kanTaiId);
            sb.append(JSMethod.NOT_SET);
            sb.append(seatNew.sid);
            sb.append(JSMethod.NOT_SET);
            sb.append(j);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Nullable
    public static List<SeatCalcParams> f(ArrayMap<String, ArrayList<SeatGroup>> arrayMap, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-101811277")) {
            return (List) ipChange.ipc$dispatch("-101811277", new Object[]{arrayMap, longSparseArray});
        }
        if (cb2.c(arrayMap)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < arrayMap.size(); i++) {
            ArrayList<SeatGroup> valueAt = arrayMap.valueAt(i);
            if (!cb2.d(valueAt)) {
                for (int i2 = 0; i2 < valueAt.size(); i2++) {
                    PriceLine priceLine = longSparseArray.get(valueAt.get(i2).priceId);
                    if (priceLine == null) {
                        return null;
                    }
                    SeatCalcParams seatCalcParams = new SeatCalcParams(priceLine.getPriceId() + "", (int) (priceLine.originalPrice() * 100.0f), 1);
                    int indexOf = arrayList.indexOf(seatCalcParams);
                    if (indexOf >= 0) {
                        ((SeatCalcParams) arrayList.get(indexOf)).count++;
                    } else {
                        arrayList.add(seatCalcParams);
                    }
                }
                continue;
            }
        }
        return arrayList;
    }

    @Nullable
    public static List<Region> g(List<Region> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878597066")) {
            return (List) ipChange.ipc$dispatch("1878597066", new Object[]{list});
        }
        if (cb2.d(list)) {
            return null;
        }
        return new ArrayList(list);
    }

    public static List<PriceLevel> h(List<PriceLevel> list, Region region) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "43046569")) {
            return (List) ipChange.ipc$dispatch("43046569", new Object[]{list, region});
        }
        if (!cb2.d(list) && region != null && !cb2.d(region.priceLevelIdList)) {
            Iterator<PriceLevel> it = list.iterator();
            while (it.hasNext()) {
                if (!region.priceLevelIdList.contains(Long.valueOf(it.next().getPriceId()))) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private static Price i(List<Price> list, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1952433914")) {
            return (Price) ipChange.ipc$dispatch("1952433914", new Object[]{list, Long.valueOf(j)});
        }
        if (cb2.d(list)) {
            return null;
        }
        for (Price price : list) {
            if (price.getPriceId() == j) {
                return price;
            }
        }
        return null;
    }

    @Nullable
    public static Region j(RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683499067")) {
            return (Region) ipChange.ipc$dispatch("683499067", new Object[]{regionData});
        }
        if (regionData == null || !regionData.checkBaseValid()) {
            return null;
        }
        return regionData.ri.regionList.get(0);
    }

    public static long k(@Nullable TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285986281")) {
            return ((Long) ipChange.ipc$dispatch("-285986281", new Object[]{tbParams})).longValue();
        }
        if (tbParams == null) {
            return -1L;
        }
        return tbParams.itemId;
    }

    @Nullable
    public static List<SeatNew> l(Map<Long, List<SeatNew>> map, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1957817507")) {
            return (List) ipChange.ipc$dispatch("1957817507", new Object[]{map, Long.valueOf(j)});
        }
        if (cb2.f(map)) {
            return null;
        }
        return map.get(Long.valueOf(j));
    }

    public static long m(@Nullable TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723720715")) {
            return ((Long) ipChange.ipc$dispatch("-723720715", new Object[]{tbParams})).longValue();
        }
        if (tbParams == null) {
            return -1L;
        }
        return tbParams.performId;
    }

    public static PriceLevel n(@Nullable PriceBean priceBean, @Nullable List<? extends PriceLevel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875644779")) {
            return (PriceLevel) ipChange.ipc$dispatch("1875644779", new Object[]{priceBean, list});
        }
        if (priceBean == null || cb2.d(list)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            PriceLevel priceLevel = list.get(i);
            if (priceLevel.getPriceId() == priceBean.priceId) {
                return priceLevel;
            }
        }
        return null;
    }

    public static long o(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770529850")) {
            return ((Long) ipChange.ipc$dispatch("-1770529850", new Object[]{priceLevel})).longValue();
        }
        if (priceLevel == null) {
            return -1L;
        }
        return priceLevel.getPriceId();
    }

    @Nullable
    public static String p(String str, long j, boolean z) {
        lk1 b;
        PerformBean performBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469181155")) {
            return (String) ipChange.ipc$dispatch("-469181155", new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)});
        }
        if (z || eb.b(str) || (b = mk1.a().b(j)) == null || (performBean = b.c) == null) {
            return null;
        }
        return eb.a(performBean);
    }

    public static String q(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1444222336")) {
            return (String) ipChange.ipc$dispatch("1444222336", new Object[]{seatNew});
        }
        String str = seatNew.rn;
        String str2 = "";
        if (str != null && !str.trim().equals("")) {
            if (wh2.h(str)) {
                str2 = "" + str + cm2.b(mu0.a(), R$string.damai_cinemaseat_row);
            } else {
                str2 = "" + str;
            }
        }
        String str3 = seatNew.sn;
        if (TextUtils.isEmpty(str3)) {
            return str2;
        }
        if (wh2.h(str3)) {
            return str2 + str3 + cm2.b(mu0.a(), R$string.damai_cinemaseat_number);
        }
        return str2 + str3;
    }

    public static List<ItemSeatV2> r(List<SeatNew> list, HashMap<String, Region> hashMap, List<Price> list2) {
        Region region;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2052449436")) {
            return (List) ipChange.ipc$dispatch("2052449436", new Object[]{list, hashMap, list2});
        }
        LongSparseArray longSparseArray = null;
        if (cb2.d(list)) {
            return null;
        }
        ArrayList<ItemSeatV2> arrayList = new ArrayList();
        for (SeatNew seatNew : list) {
            if (hashMap != null && (region = hashMap.get(seatNew.kanTaiId)) != null) {
                seatNew.kanTaiName = region.name;
            }
            if (seatNew.isPackaged) {
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                }
                long j = seatNew.packageCombinedId;
                ItemSeatV2 itemSeatV2 = (ItemSeatV2) longSparseArray.get(j);
                if (itemSeatV2 == null) {
                    ItemSeatV2 itemSeatV22 = new ItemSeatV2(seatNew, true);
                    longSparseArray.put(j, itemSeatV22);
                    arrayList.add(itemSeatV22);
                } else {
                    itemSeatV2.addPackageSeat(seatNew);
                }
            } else {
                arrayList.add(new ItemSeatV2(seatNew, false));
            }
        }
        if (arrayList.size() > 0) {
            for (ItemSeatV2 itemSeatV23 : arrayList) {
                if (itemSeatV23.isPackageSeat) {
                    H(itemSeatV23.seatList, i(list2, itemSeatV23.priceId));
                }
            }
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public static int s(PriceLevel priceLevel) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "573109929")) {
            return ((Integer) ipChange.ipc$dispatch("573109929", new Object[]{priceLevel})).intValue();
        }
        if (priceLevel != null && ((priceLevel.isTaoPiao() || priceLevel.isFreeCombineTiaoPiao()) && !cb2.d(priceLevel.getSubPriceList()))) {
            for (SubPrice subPrice : priceLevel.getSubPriceList()) {
                i += subPrice.count;
            }
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [S, java.lang.Integer] */
    private static List<TicketSubUiModel> t(@NonNull List<SeatNew> list, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152757333")) {
            return (List) ipChange.ipc$dispatch("152757333", new Object[]{list, longSparseArray});
        }
        LongSparseArray longSparseArray2 = new LongSparseArray();
        ArrayList arrayList = new ArrayList();
        for (SeatNew seatNew : list) {
            boolean z = seatNew.isPackaged;
            long j = z ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            if (!z || !arrayList.contains(Long.valueOf(seatNew.packageCombinedId))) {
                if (seatNew.isPackaged) {
                    arrayList.add(Long.valueOf(seatNew.packageCombinedId));
                }
                Tuple tuple = (Tuple) longSparseArray2.get(j);
                if (tuple == null) {
                    longSparseArray2.put(j, new Tuple(seatNew, 1));
                } else {
                    S s = tuple.second;
                    Integer num = (Integer) s;
                    tuple.second = Integer.valueOf(((Integer) s).intValue() + 1);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < longSparseArray2.size(); i++) {
            long keyAt = longSparseArray2.keyAt(i);
            Tuple tuple2 = (Tuple) longSparseArray2.valueAt(i);
            SeatNew seatNew2 = (SeatNew) tuple2.first;
            int intValue = ((Integer) tuple2.second).intValue();
            PriceLine priceLine = longSparseArray.get(keyAt);
            String priceTitle = priceLine != null ? priceLine.getPriceTitle() : null;
            double d = (seatNew2.isPackaged ? seatNew2.seatTaoPiaoValue : seatNew2.seatValue) * intValue;
            String c = wh2.c(d);
            TicketSubUiModel ticketSubUiModel = new TicketSubUiModel();
            ticketSubUiModel.count = intValue + "";
            ticketSubUiModel.skuName = priceTitle;
            ticketSubUiModel.amount = d + "";
            ticketSubUiModel.amountText = "¥" + c;
            arrayList2.add(ticketSubUiModel);
        }
        return arrayList2;
    }

    public static int u(PriceLevel priceLevel, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "143196733") ? ((Integer) ipChange.ipc$dispatch("143196733", new Object[]{priceLevel, Integer.valueOf(i)})).intValue() : s(priceLevel) * i;
    }

    public static int v(List<SeatNew> list, long j) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1425266398")) {
            return ((Integer) ipChange.ipc$dispatch("1425266398", new Object[]{list, Long.valueOf(j)})).intValue();
        }
        if (!cb2.d(list)) {
            Iterator<SeatNew> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().priceLevel == j) {
                    i++;
                }
            }
        }
        return i;
    }

    @Nullable
    public static List<TicketMainUiModel> w(List<SeatNew> list, LongSparseArray<PriceLine> longSparseArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-515706785")) {
            return (List) ipChange.ipc$dispatch("-515706785", new Object[]{list, longSparseArray});
        }
        if (cb2.d(list) || cb2.e(longSparseArray)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        TicketMainUiModel ticketMainUiModel = new TicketMainUiModel();
        ticketMainUiModel.moduleTitle = "商品原价";
        double d = d(list);
        ticketMainUiModel.moduleTotalAmt = d + "";
        ticketMainUiModel.moduleType = "1";
        ticketMainUiModel.moduleTotalAmtText = "¥" + wh2.c(d);
        ticketMainUiModel.moduleDetailVOList = t(list, longSparseArray);
        arrayList.add(ticketMainUiModel);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean x(java.util.List<? extends cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel> r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.f92.$ipChange
            java.lang.String r1 = "521458288"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L1b:
            boolean r0 = tb.cb2.d(r5)
            if (r0 != 0) goto L3e
            java.util.Iterator r5 = r5.iterator()
        L25:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L3e
            java.lang.Object r0 = r5.next()
            cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel r0 = (cn.damai.commonbusiness.seatbiz.seat.qilin.bean.PriceLevel) r0
            boolean r1 = r0.isFreeCombineTiaoPiao()
            if (r1 != 0) goto L3d
            boolean r0 = r0.isTaoPiao()
            if (r0 == 0) goto L25
        L3d:
            return r4
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.f92.x(java.util.List):boolean");
    }

    public static boolean y(List<Region> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122413123")) {
            return ((Boolean) ipChange.ipc$dispatch("1122413123", new Object[]{list, str})).booleanValue();
        }
        if (cb2.d(list)) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            Region region = list.get(i);
            if (TextUtils.equals(region.vid, str)) {
                return region.state == 1;
            }
        }
        return false;
    }

    public static boolean z(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814927927")) {
            return ((Boolean) ipChange.ipc$dispatch("-1814927927", new Object[]{list})).booleanValue();
        }
        if (!cb2.d(list)) {
            String str = null;
            for (int i = 0; i < list.size(); i++) {
                SeatNew seatNew = list.get(i);
                if (str == null) {
                    str = seatNew.rn;
                } else if (!TextUtils.equals(str, seatNew.rn)) {
                    return true;
                }
            }
        }
        return false;
    }
}
