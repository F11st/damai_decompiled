package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.bean.UtCalculator;
import cn.damai.seat.bean.UtDynamic;
import cn.damai.seat.bean.UtExtra;
import cn.damai.seat.bean.UtStatus;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class o92 extends gb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PROJECT_SITESELECT_PAGE = "seatselect";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class a {
        private static final o92 a = new o92();
    }

    public static final o92 l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1996080149") ? (o92) ipChange.ipc$dispatch("-1996080149", new Object[0]) : a.a;
    }

    @Override // tb.gb
    public Map<String, String> i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2082993347")) {
            return (Map) ipChange.ipc$dispatch("-2082993347", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("contentlabel", str2);
        return hashMap;
    }

    public a.b j(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688172804")) {
            return (a.b) ipChange.ipc$dispatch("1688172804", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("seatselect", "seat", "preareabtn", hashMap, Boolean.FALSE);
    }

    public a.b k(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385278019")) {
            return (a.b) ipChange.ipc$dispatch("-1385278019", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("seatselect", "center", IRequestConst.VR, hashMap, Boolean.FALSE);
    }

    public a.b m(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-149518873")) {
            return (a.b) ipChange.ipc$dispatch("-149518873", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("seatselect", "discountinfor", "layer", hashMap, Boolean.TRUE);
    }

    public a.b n(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1216491922")) {
            return (a.b) ipChange.ipc$dispatch("1216491922", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("seatselect", "bottom", "openselectedlistbtn", hashMap, Boolean.FALSE);
    }

    public a.b o(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690119047")) {
            return (a.b) ipChange.ipc$dispatch("1690119047", new Object[]{this, str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        hashMap.put("contentlabel", str3);
        return e("seatselect", "seatselected", "delselect", hashMap, Boolean.FALSE);
    }

    public a.b p(long j, int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189066326")) {
            return (a.b) ipChange.ipc$dispatch("-1189066326", new Object[]{this, Long.valueOf(j), Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("price_type", str2);
        }
        return e("seatselect", "pricelist", "imgprice_" + i, hashMap, Boolean.FALSE);
    }

    public a.b q(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521080413")) {
            return (a.b) ipChange.ipc$dispatch("-1521080413", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        hashMap.put("titlelabel", str2);
        return e("seatselect", "bottom", "confirm", hashMap, Boolean.TRUE);
    }

    public a.b r(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1570995800")) {
            return (a.b) ipChange.ipc$dispatch("-1570995800", new Object[]{this, Long.valueOf(j), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        hashMap.put("contentlabel", str);
        return e("seatselect", "seat", "item_" + str, hashMap, Boolean.FALSE);
    }

    public a.b s(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602195765")) {
            return (a.b) ipChange.ipc$dispatch("602195765", new Object[]{this, Long.valueOf(j), Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_seat", z ? "1" : "0");
        return new a.b().i("seatselect").d(String.valueOf(j)).j(hashMap);
    }

    public void t(UtCalculator utCalculator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929270612")) {
            ipChange.ipc$dispatch("1929270612", new Object[]{this, utCalculator});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("success", utCalculator.success + "");
            hashMap.put("itemId", utCalculator.itemId + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, utCalculator.performId + "");
            if (!utCalculator.success) {
                hashMap.put("errCode", utCalculator.errCode);
                hashMap.put("errMsg", utCalculator.errMsg);
            }
            hashMap.put("calcuInfo", utCalculator.getParamsInfo());
            cn.damai.common.user.c.e().x(e("seatselect", "seat_calculate", "result", hashMap, Boolean.FALSE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void u(UtDynamic utDynamic) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1442338086")) {
            ipChange.ipc$dispatch("1442338086", new Object[]{this, utDynamic});
            return;
        }
        try {
            TbParams tbParams = utDynamic.mParams;
            boolean z = utDynamic.success;
            HashMap hashMap = new HashMap();
            hashMap.put("success", z + "");
            hashMap.put("itemId", tbParams.itemId + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, tbParams.performId + "");
            if (!z) {
                hashMap.put("errCode", utDynamic.errorCode);
                hashMap.put("errMsg", utDynamic.errorMsg);
            }
            cn.damai.common.user.c.e().x(e("seatselect", "dynamic_mtop", "result", hashMap, Boolean.FALSE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void v(UtExtra<l11> utExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791409708")) {
            ipChange.ipc$dispatch("791409708", new Object[]{this, utExtra});
            return;
        }
        try {
            TbParams tbParams = utExtra.mParams;
            boolean z = utExtra.success;
            kn1<l11> kn1Var = utExtra.option;
            HashMap hashMap = new HashMap();
            hashMap.put("success", z + "");
            hashMap.put("itemId", tbParams.itemId + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, tbParams.performId + "");
            hashMap.put("useMemoryCache", "" + kn1Var.e());
            hashMap.put("picUrl", kn1Var.d());
            if (!z) {
                hashMap.put("errCode", utExtra.errorCode);
                hashMap.put("errMsg", utExtra.errorMsg);
            }
            cn.damai.common.user.c.e().x(e("seatselect", "pic_load", "result", hashMap, Boolean.FALSE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void w(UtExtra<e92> utExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1022293511")) {
            ipChange.ipc$dispatch("-1022293511", new Object[]{this, utExtra});
            return;
        }
        try {
            TbParams tbParams = utExtra.mParams;
            boolean z = utExtra.success;
            kn1<e92> kn1Var = utExtra.option;
            HashMap hashMap = new HashMap();
            hashMap.put("success", z + "");
            hashMap.put("itemId", tbParams.itemId + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, tbParams.performId + "");
            hashMap.put("useMemoryCache", "" + kn1Var.e());
            hashMap.put("seatUrl", kn1Var.d());
            if (!z) {
                hashMap.put("errCode", utExtra.errorCode);
                hashMap.put("errMsg", utExtra.errorMsg);
            }
            cn.damai.common.user.c.e().x(e("seatselect", "seat_load", "result", hashMap, Boolean.FALSE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x(UtStatus utStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1986793724")) {
            ipChange.ipc$dispatch("-1986793724", new Object[]{this, utStatus});
            return;
        }
        try {
            TbParams tbParams = utStatus.mParams;
            boolean z = utStatus.success;
            HashMap hashMap = new HashMap();
            hashMap.put("success", z + "");
            hashMap.put("itemId", tbParams.itemId + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, tbParams.performId + "");
            if (!z) {
                hashMap.put("errCode", utStatus.errorCode);
                hashMap.put("errMsg", utStatus.errorMsg);
            }
            cn.damai.common.user.c.e().x(e("seatselect", "status_mtop", "result", hashMap, Boolean.FALSE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
