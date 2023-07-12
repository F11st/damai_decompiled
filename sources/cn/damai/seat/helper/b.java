package cn.damai.seat.helper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.common.bean.CreateOrderExParams;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcRes;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCombineInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.live.LiveActivity;
import cn.damai.seat.bean.BuyParam;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.PriceManagerImpl;
import cn.damai.seat.bean.SeatGroup;
import cn.damai.seat.bean.SeatInfoParams;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.helper.SeatDataSubmitter;
import cn.damai.seat.helper.SeatPreLocker;
import cn.damai.seat.listener.OnPriceBarListener;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.net.OnNetBizListener;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.cb2;
import tb.f92;
import tb.jb;
import tb.mu0;
import tb.n92;
import tb.t82;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class b extends jb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ALL_REMOVED = 17;
    public static final int NONE_REMOVED = 51;
    public static final int PART_REMOVED = 34;
    private final TbParams f;
    private int g;
    public int h;
    private IPriceManager i;
    private SeatCalculator j;
    private SeatPreLocker k;
    private Map<Long, List<SeatNew>> l;
    private boolean n;
    private boolean o;
    private boolean p;
    private String q;
    private RequestHolder a = new RequestHolder();
    private final List<SeatNew> c = new ArrayList();
    private final List<SeatNew> d = new ArrayList();
    private final ArrayMap<String, ArrayList<SeatGroup>> e = new ArrayMap<>();
    private HashMap<String, Region> m = new HashMap<>();
    public final long b = System.currentTimeMillis();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnNetBizListener<TicketCalcRes> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SeatComputeListener a;

        a(SeatComputeListener seatComputeListener) {
            this.a = seatComputeListener;
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        /* renamed from: a */
        public void onNetSuccess(@NonNull TicketCalcRes ticketCalcRes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2105866501")) {
                ipChange.ipc$dispatch("2105866501", new Object[]{this, ticketCalcRes});
                return;
            }
            this.a.doNetWork(false);
            if (ticketCalcRes.isBizSuccess()) {
                b.this.n(ticketCalcRes.model, null, this.a);
            } else {
                b.this.n(null, "价格计算失败", this.a);
            }
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        public void onNetFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834297381")) {
                ipChange.ipc$dispatch("-1834297381", new Object[]{this, str, str2});
                return;
            }
            this.a.doNetWork(false);
            b.this.n(null, "价格计算失败", this.a);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.helper.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0067b implements SeatDataSubmitter.OnSubmitSeatDataListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;

        C0067b(OnSubmitListener onSubmitListener) {
            this.a = onSubmitListener;
        }

        @Override // cn.damai.seat.helper.SeatDataSubmitter.OnSubmitSeatDataListener
        public void onSubmitFailed(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768502190")) {
                ipChange.ipc$dispatch("-768502190", new Object[]{this, str, str2, str3});
                return;
            }
            t82.g(str, str2, str3, b.this.f.itemId + "", b.this.f.performId + "");
            this.a.doNetWork(false, true);
            this.a.onSubmitFailed(str, str2, str3);
        }

        @Override // cn.damai.seat.helper.SeatDataSubmitter.OnSubmitSeatDataListener
        public void onSubmitSuccess(OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1283378567")) {
                ipChange.ipc$dispatch("1283378567", new Object[]{this, orderAfterChooseSeatInfo});
                return;
            }
            this.a.doNetWork(false, true);
            this.a.onSubmitSuccess(b.this.f.orderId, orderAfterChooseSeatInfo);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements OnNetBizListener<TicketCalcRes> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;

        c(OnSubmitListener onSubmitListener) {
            this.a = onSubmitListener;
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        /* renamed from: a */
        public void onNetSuccess(@NonNull TicketCalcRes ticketCalcRes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "147291715")) {
                ipChange.ipc$dispatch("147291715", new Object[]{this, ticketCalcRes});
            } else if (ticketCalcRes.isBizSuccess()) {
                if (!b.this.n) {
                    this.a.doNetWork(false, false);
                }
                b.this.n(ticketCalcRes.model, null, this.a);
                b.this.o(ticketCalcRes.model.ticketModuleDetailVOS, this.a);
            } else {
                this.a.doNetWork(false, false);
                b.this.n(null, "价格计算失败", this.a);
                ToastUtil.a().e(mu0.a(), "价格计算失败");
            }
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        public void onNetFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-295957351")) {
                ipChange.ipc$dispatch("-295957351", new Object[]{this, str, str2});
                return;
            }
            this.a.doNetWork(false, false);
            ToastUtil.a().e(mu0.a(), "价格计算失败");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements SeatPreLocker.OnPreLockResultListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;
        final /* synthetic */ List b;

        d(OnSubmitListener onSubmitListener, List list) {
            this.a = onSubmitListener;
            this.b = list;
        }

        @Override // cn.damai.seat.helper.SeatPreLocker.OnPreLockResultListener
        public void onOpenNextPage(boolean z, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1010139063")) {
                ipChange.ipc$dispatch("-1010139063", new Object[]{this, Boolean.valueOf(z), str, str2});
                return;
            }
            this.a.doNetWork(false, false);
            this.a.onOpenPurchase(b.this.m(this.b));
        }

        @Override // cn.damai.seat.helper.SeatPreLocker.OnPreLockResultListener
        public void onPreLockFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615588468")) {
                ipChange.ipc$dispatch("1615588468", new Object[]{this});
                return;
            }
            this.a.doNetWork(false, false);
            this.a.seatPreLockFailed();
        }
    }

    public b(TbParams tbParams) {
        this.f = tbParams;
        this.j = new SeatCalculator(tbParams.itemId, tbParams.performId);
        this.k = new SeatPreLocker(tbParams.projectId, tbParams.performId);
    }

    private void E(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357508026")) {
            ipChange.ipc$dispatch("357508026", new Object[]{this, seatNew, Boolean.valueOf(z)});
        } else if (z) {
            this.d.add(seatNew);
        } else if (seatNew.isPackaged) {
            for (SeatNew seatNew2 : this.d) {
                if (seatNew2.packageCombinedId == seatNew.packageCombinedId) {
                    this.d.remove(seatNew2);
                    return;
                }
            }
        } else {
            this.d.remove(seatNew);
        }
    }

    private void i(SeatGroup seatGroup, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697346981")) {
            ipChange.ipc$dispatch("1697346981", new Object[]{this, seatGroup, Boolean.valueOf(z)});
            return;
        }
        String str = seatGroup.kanTaiId;
        if (z) {
            ArrayList<SeatGroup> arrayList = this.e.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.e.put(str, arrayList);
            }
            arrayList.add(seatGroup);
        } else {
            ArrayList<SeatGroup> arrayList2 = this.e.get(str);
            if (!cb2.d(arrayList2)) {
                arrayList2.remove(seatGroup);
            }
            if (cb2.d(arrayList2)) {
                this.e.remove(str);
            }
        }
        if (seatGroup.isPackage) {
            List<SeatNew> list = seatGroup.packageList;
            if (cb2.d(list)) {
                return;
            }
            if (z) {
                this.c.addAll(list);
            } else {
                this.c.removeAll(list);
            }
            for (int i = 0; i < list.size(); i++) {
                k(list.get(i), z);
            }
            return;
        }
        SeatNew seatNew = seatGroup.single;
        if (z) {
            this.c.add(seatNew);
        } else {
            this.c.remove(seatNew);
        }
        k(seatNew, z);
    }

    private void k(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8852946")) {
            ipChange.ipc$dispatch("-8852946", new Object[]{this, seatNew, Boolean.valueOf(z)});
        } else {
            seatNew.isSelected = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Bundle m(@Nullable List<TicketCombineInfo> list) {
        List list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299090607")) {
            return (Bundle) ipChange.ipc$dispatch("-299090607", new Object[]{this, list});
        }
        if (cb2.c(this.e) || cb2.d(this.c)) {
            return null;
        }
        long j = this.f.itemId;
        if (!cb2.d(list)) {
            BuyParam.bindItemId(list, j);
            list2 = list;
        } else {
            list2 = BuyParam.toBuyParamList(j, this.e, z());
        }
        if (cb2.d(list2)) {
            return null;
        }
        String concatBuyParams = BuyParam.concatBuyParams(list2);
        String seatInfoJson = SeatInfoParams.toSeatInfoJson(this.c);
        CreateOrderExParams createOrderExParams = new CreateOrderExParams("damai_app", this.f.atomSplit + "", seatInfoJson);
        Bundle bundle = new Bundle();
        bundle.putString("buyParam", concatBuyParams);
        bundle.putBoolean("buyNow", false);
        bundle.putLong(LiveActivity.OPTION_DAMAI_ITEM_ID, j);
        bundle.putString(Request.K_EXPARAMS, JSON.toJSONString(createOrderExParams));
        bundle.putBoolean("is_seat", true);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@Nullable TicketCalcBean ticketCalcBean, @Nullable String str, OnPriceBarListener onPriceBarListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "548285868")) {
            ipChange.ipc$dispatch("548285868", new Object[]{this, ticketCalcBean, str, onPriceBarListener});
            return;
        }
        boolean z = r() > 0;
        if (ticketCalcBean != null) {
            onPriceBarListener.onPriceBarV2InfoChanged(new PriceBarInfo(ticketCalcBean.realTotalAmtText, ticketCalcBean.reduceTotalAmtDesc, z, ticketCalcBean.usedPromotionList), ticketCalcBean.calculateModuleVOS);
        } else {
            onPriceBarListener.onPriceBarV2InfoChanged(new PriceBarInfo(wh2.c(f92.d(this.c)), str, z, null), f92.w(this.c, z().getPid2PriceLineMap()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(@Nullable List<TicketCombineInfo> list, OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63750200")) {
            ipChange.ipc$dispatch("-63750200", new Object[]{this, list, onSubmitListener});
        } else if (!this.n) {
            onSubmitListener.onOpenPurchase(m(list));
        } else {
            onSubmitListener.doNetWork(true, false);
            this.a.a(this.k.f(this.c, new d(onSubmitListener, list)));
        }
    }

    private int q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494898240")) {
            return ((Integer) ipChange.ipc$dispatch("1494898240", new Object[]{this})).intValue();
        }
        if (cb2.c(this.e)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            ArrayList<SeatGroup> valueAt = this.e.valueAt(i2);
            i += valueAt == null ? 0 : valueAt.size();
        }
        return i;
    }

    private int r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1233514816") ? ((Integer) ipChange.ipc$dispatch("1233514816", new Object[]{this})).intValue() : this.c.size();
    }

    private int s(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-109429426") ? ((Integer) ipChange.ipc$dispatch("-109429426", new Object[]{this, Long.valueOf(j)})).intValue() : f92.v(this.c, j);
    }

    private List<SeatNew> t(List<SeatNew> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299289752")) {
            return (List) ipChange.ipc$dispatch("-299289752", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        List<Price> fullPriceList = z().getFullPriceList();
        for (SeatNew seatNew : list) {
            long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            for (Price price : fullPriceList) {
                Tag tag = price.promotionTag;
                if (tag != null && tag.tag.equals(PromotionTagView.VIP_BUY) && j == price.priceId) {
                    arrayList.add(seatNew);
                }
            }
        }
        return arrayList;
    }

    private int u() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1214099623")) {
            return ((Integer) ipChange.ipc$dispatch("1214099623", new Object[]{this})).intValue();
        }
        List<Price> fullPriceList = z().getFullPriceList();
        for (SeatNew seatNew : this.c) {
            long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
            for (Price price : fullPriceList) {
                Tag tag = price.promotionTag;
                if (tag != null && tag.tag.equals(PromotionTagView.VIP_BUY) && j == price.priceId) {
                    i++;
                }
            }
        }
        return i;
    }

    private boolean v() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1727913527") ? ((Boolean) ipChange.ipc$dispatch("1727913527", new Object[]{this})).booleanValue() : this.f != null && this.m.size() > 0;
    }

    private boolean x(SeatNew seatNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282922337")) {
            return ((Boolean) ipChange.ipc$dispatch("282922337", new Object[]{this, seatNew})).booleanValue();
        }
        List<Price> fullPriceList = z().getFullPriceList();
        long j = seatNew.isPackaged ? seatNew.packagedPriceIndexId : seatNew.priceLevel;
        for (Price price : fullPriceList) {
            Tag tag = price.promotionTag;
            if (tag != null && tag.tag.equals(PromotionTagView.VIP_BUY) && j == price.priceId) {
                return true;
            }
        }
        return false;
    }

    private IPriceManager z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362506482")) {
            return (IPriceManager) ipChange.ipc$dispatch("1362506482", new Object[]{this});
        }
        if (this.i == null) {
            this.i = PriceManagerImpl.emptyManager();
        }
        return this.i;
    }

    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154019597")) {
            ipChange.ipc$dispatch("-1154019597", new Object[]{this});
        } else {
            this.a.c();
        }
    }

    public int B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387634111")) {
            return ((Integer) ipChange.ipc$dispatch("-387634111", new Object[]{this})).intValue();
        }
        int i = 51;
        if (!cb2.d(this.c)) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                this.c.get(i2).isSelected = false;
            }
            i = 17;
        }
        this.e.clear();
        this.c.clear();
        return i;
    }

    public void C(OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236891821")) {
            ipChange.ipc$dispatch("236891821", new Object[]{this, onSubmitListener});
        } else if (!v() || cb2.d(this.c)) {
        } else {
            if (this.f.firstPayChooseSeat) {
                onSubmitListener.doNetWork(true, true);
                new SeatDataSubmitter(this.f.orderId, this.c).b(new C0067b(onSubmitListener));
                return;
            }
            String G = f92.G(this.c);
            boolean e = this.j.e(G);
            if (!e) {
                this.j.c();
            }
            if ((!this.o || this.p) ? false : !e) {
                onSubmitListener.doNetWork(true, false);
                this.a.a(this.j.b(G, this.q, f92.f(this.e, z().getPid2PriceLineMap()), new c(onSubmitListener)));
                return;
            }
            o(e ? this.j.d() : null, onSubmitListener);
        }
    }

    public int D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103947252")) {
            return ((Integer) ipChange.ipc$dispatch("-103947252", new Object[]{this})).intValue();
        }
        List<Long> d2 = this.k.d();
        this.k.c();
        if (!cb2.d(d2) && !cb2.d(this.c)) {
            for (SeatNew seatNew : this.c) {
                if (d2.contains(Long.valueOf(seatNew.sid))) {
                    seatNew.state = 8;
                }
            }
        }
        if (cb2.d(this.c)) {
            return 51;
        }
        ArrayList arrayList = new ArrayList(this.c);
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            SeatNew seatNew2 = (SeatNew) arrayList.get(i);
            if (seatNew2.state != n92.SEAT_STATUS_AVAILABLE.shortValue()) {
                j(seatNew2, false);
                z = true;
            }
        }
        if (!cb2.d(this.c)) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                this.c.get(i2).isSelected = true;
            }
        }
        if (cb2.d(this.c)) {
            return 17;
        }
        return z ? 34 : 51;
    }

    public void f(List<Region> list, int i, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293165894")) {
            ipChange.ipc$dispatch("293165894", new Object[]{this, list, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        this.g = i;
        this.h = i2;
        this.m.clear();
        this.n = z;
        if (cb2.d(list)) {
            return;
        }
        for (Region region : list) {
            HashMap<String, Region> hashMap = this.m;
            hashMap.put(region.id + "", region);
        }
    }

    public void g(Map<Long, List<SeatNew>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589070440")) {
            ipChange.ipc$dispatch("589070440", new Object[]{this, map});
        } else {
            this.l = map;
        }
    }

    public void h(boolean z, boolean z2, String str, IPriceManager iPriceManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527695335")) {
            ipChange.ipc$dispatch("-527695335", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, iPriceManager});
            return;
        }
        this.o = z;
        this.p = z2;
        this.q = str;
        this.i = iPriceManager;
    }

    public boolean j(SeatNew seatNew, boolean z) {
        SeatGroup makeSingle;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046311608")) {
            return ((Boolean) ipChange.ipc$dispatch("-1046311608", new Object[]{this, seatNew, Boolean.valueOf(z)})).booleanValue();
        }
        if (!v() || seatNew == null) {
            return false;
        }
        if (z && this.c.contains(seatNew)) {
            return false;
        }
        if (z) {
            if (this.f.firstPayChooseSeat) {
                Price firstPriceLevel = z().firstPriceLevel();
                if (firstPriceLevel == null) {
                    return false;
                }
                if (firstPriceLevel.isFreeCombineTiaoPiao()) {
                    long j = seatNew.priceLevel;
                    SubPrice subPrice = firstPriceLevel.getSubPrice(j);
                    if (subPrice == null) {
                        return false;
                    }
                    if (r() >= f92.u(firstPriceLevel, this.g)) {
                        ToastUtil.a().e(mu0.a(), "已选完全部座位啦");
                        return false;
                    } else if (s(j) >= subPrice.count * this.g) {
                        ToastUtil.a().e(mu0.a(), "该档位已选完，请选择其他档位");
                        return false;
                    }
                } else if (q() >= this.g) {
                    ToastUtil.a().e(mu0.a(), "已选完全部座位啦");
                    return false;
                }
            } else {
                int r = r();
                int u = u();
                boolean x = x(seatNew);
                if (seatNew.isPackaged) {
                    List<SeatNew> l = f92.l(this.l, seatNew.packageCombinedId);
                    if (cb2.d(l)) {
                        return false;
                    }
                    List<SeatNew> t = t(l);
                    i2 = wh2.e(l);
                    i = wh2.e(t);
                } else {
                    i = x;
                    i2 = 1;
                }
                if (r + i2 > this.g) {
                    ToastUtil.a().e(mu0.a(), "超出限购数量了哦");
                    return false;
                }
                int i3 = this.h;
                if (i3 > 0 && u + i > i3) {
                    ToastUtil.a().e(mu0.a(), "超出特权限购数量了哦");
                    return false;
                }
            }
        }
        if (seatNew.isPackaged) {
            makeSingle = SeatGroup.makePackage(f92.l(this.l, seatNew.packageCombinedId));
        } else {
            makeSingle = SeatGroup.makeSingle(seatNew);
        }
        if (makeSingle == null) {
            return false;
        }
        i(makeSingle, z);
        E(seatNew, z);
        return true;
    }

    public void l(@NonNull SeatComputeListener seatComputeListener) {
        List<SeatCalcParams> list;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-800939223")) {
            ipChange.ipc$dispatch("-800939223", new Object[]{this, seatComputeListener});
        } else if (v()) {
            seatComputeListener.onSeatListChanged(f92.r(this.c, this.m, z().getFullPriceList()));
            if (this.f.firstPayChooseSeat) {
                Price firstPriceLevel = z().firstPriceLevel();
                int i = this.g;
                if (firstPriceLevel != null) {
                    if (firstPriceLevel.isFreeCombineTiaoPiao() || firstPriceLevel.isTaoPiao()) {
                        i = f92.u(firstPriceLevel, this.g);
                    }
                    seatComputeListener.onPriceBarV2InfoChanged(new PriceBarInfo(i, r()), null);
                    return;
                }
                return;
            }
            if (r() <= 0 || !this.o) {
                list = null;
            } else {
                list = f92.f(this.e, z().getPid2PriceLineMap());
                z = !cb2.d(list);
            }
            if (!z) {
                n(null, null, seatComputeListener);
                return;
            }
            String G = f92.G(this.c);
            seatComputeListener.doNetWork(true);
            this.a.a(this.j.b(G, this.q, list, new a(seatComputeListener)));
        }
    }

    @Nullable
    public String p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "998899971") ? (String) ipChange.ipc$dispatch("998899971", new Object[]{this}) : this.k.e();
    }

    public boolean w() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-5047757") ? ((Boolean) ipChange.ipc$dispatch("-5047757", new Object[]{this})).booleanValue() : f92.z(this.c);
    }

    public SeatNew y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289796615")) {
            return (SeatNew) ipChange.ipc$dispatch("-1289796615", new Object[]{this});
        }
        if (cb2.d(this.d)) {
            return null;
        }
        List<SeatNew> list = this.d;
        return list.get(list.size() - 1);
    }
}
