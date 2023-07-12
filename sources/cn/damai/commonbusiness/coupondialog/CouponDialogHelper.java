package cn.damai.commonbusiness.coupondialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.coupondialog.net.CouponClearRequest;
import cn.damai.commonbusiness.coupondialog.net.CouponClearResponse;
import cn.damai.commonbusiness.coupondialog.net.CouponListRequest;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.cb1;
import tb.mu0;
import tb.wh2;
import tb.xr;
import tb.yo;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CouponDialogHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static CouponDialogHelper l;
    private CouponListResponse a;
    private boolean b;
    private boolean c;
    private Context d;
    private boolean e;
    private CouponDialog f;
    private boolean g;
    private String h;
    private String i;
    private long j;
    private int k;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.coupondialog.CouponDialogHelper$a */
    /* loaded from: classes14.dex */
    public class CountDownTimerC0635a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        CountDownTimerC0635a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "34967213")) {
                ipChange.ipc$dispatch("34967213", new Object[]{this});
                return;
            }
            cb1.b("CouponDialogHelper", "TimeCountDown finished.");
            if (CouponDialogHelper.this.g || !CouponDialogHelper.this.e) {
                return;
            }
            ToastUtil.a().e(mu0.a(), "仅限新用户领取");
            CouponDialogHelper.this.c = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-437741823")) {
                ipChange.ipc$dispatch("-437741823", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.coupondialog.CouponDialogHelper$b */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnDismissListenerC0636b implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnDismissListenerC0636b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1947047672")) {
                ipChange.ipc$dispatch("-1947047672", new Object[]{this, dialogInterface});
            } else if (CouponDialogHelper.this.f == null) {
            } else {
                if (CouponDialogHelper.this.f.j()) {
                    CouponDialogHelper couponDialogHelper = CouponDialogHelper.this;
                    couponDialogHelper.u(couponDialogHelper.f.g(), CouponDialogHelper.this.f.h());
                }
                CouponDialogHelper couponDialogHelper2 = CouponDialogHelper.this;
                couponDialogHelper2.s(couponDialogHelper2.f);
                CouponDialogHelper.this.f = null;
                CouponDialogHelper.this.z(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.coupondialog.CouponDialogHelper$c */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnShowListenerC0637c implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnShowListenerC0637c() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-286145312")) {
                ipChange.ipc$dispatch("-286145312", new Object[]{this, dialogInterface});
                return;
            }
            CouponDialogHelper.this.t();
            CouponDialogHelper.this.q();
        }
    }

    private CouponDialogHelper() {
    }

    public static synchronized CouponDialogHelper l(Context context) {
        synchronized (CouponDialogHelper.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2101615689")) {
                return (CouponDialogHelper) ipChange.ipc$dispatch("-2101615689", new Object[]{context});
            }
            if (l == null) {
                l = new CouponDialogHelper();
            }
            CouponDialogHelper couponDialogHelper = l;
            couponDialogHelper.d = context;
            return couponDialogHelper;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783196252")) {
            ipChange.ipc$dispatch("-783196252", new Object[]{this});
        } else {
            C0529c.e().A(new HashMap(), "damai_redpacket_layer_event", "redpacket_layer");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085588076")) {
            ipChange.ipc$dispatch("-2085588076", new Object[]{this});
            return;
        }
        int z = z20.z();
        if (z != 1) {
            return;
        }
        cb1.b("CouponDialogHelper", "requestRedPacketRequest()");
        CouponListRequest couponListRequest = new CouponListRequest();
        couponListRequest.type = String.valueOf(z);
        couponListRequest.request(new DMMtopRequestListener<CouponListResponse>(CouponListResponse.class) { // from class: cn.damai.commonbusiness.coupondialog.CouponDialogHelper.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-649963241")) {
                    ipChange2.ipc$dispatch("-649963241", new Object[]{this, str, str2});
                    return;
                }
                if (CouponDialogHelper.this.g && CouponDialogHelper.this.b) {
                    CouponDialogHelper.this.D("请在“我的优惠券”查看领取结果");
                }
                CouponDialogHelper.this.x(0);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponListResponse couponListResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1515753132")) {
                    ipChange2.ipc$dispatch("1515753132", new Object[]{this, couponListResponse});
                    return;
                }
                CouponDialogHelper.this.a = couponListResponse;
                CouponDialogHelper.this.C();
            }
        });
    }

    public void A(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31245384")) {
            ipChange.ipc$dispatch("31245384", new Object[]{this, str});
        } else {
            B(str, "");
        }
    }

    public void B(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1872466926")) {
            ipChange.ipc$dispatch("-1872466926", new Object[]{this, str, str2});
            return;
        }
        this.h = str;
        this.i = str2;
    }

    public void C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591093414")) {
            ipChange.ipc$dispatch("1591093414", new Object[]{this});
        } else if (this.a != null && this.e) {
            if (this.f == null) {
                this.f = new CouponDialog(this.d);
            }
            if (this.f.isShowing()) {
                return;
            }
            this.f.o(this.h, this.i);
            this.f.n(this.a.model);
            cb1.b("CouponDialogHelper", "to show dialog.");
            this.f.setOnDismissListener(new DialogInterface$OnDismissListenerC0636b());
            this.f.setOnShowListener(new DialogInterface$OnShowListenerC0637c());
            Context context = this.d;
            if (context == null || !(context instanceof Activity) || ((BaseActivity) context).isActivityFinsihed()) {
                return;
            }
            if (this.f.isShowing()) {
                this.f.dismiss();
            }
            this.f.p();
        }
    }

    public void D(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603950631")) {
            ipChange.ipc$dispatch("-1603950631", new Object[]{this, str});
        } else if (!this.e || this.d == null || this.c) {
        } else {
            ToastUtil.a().e(mu0.a(), str);
            y(false);
        }
    }

    public boolean m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2111303750") ? ((Boolean) ipChange.ipc$dispatch("-2111303750", new Object[]{this})).booleanValue() : this.b;
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "623914882")) {
            ipChange.ipc$dispatch("623914882", new Object[]{this});
        } else {
            this.e = false;
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-485688635")) {
            ipChange.ipc$dispatch("-485688635", new Object[]{this});
            return;
        }
        this.e = true;
        C();
    }

    public void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1266019553")) {
            ipChange.ipc$dispatch("-1266019553", new Object[]{this});
        } else if (this.b) {
            new CountDownTimerC0635a(3000L, 1000L).start();
            cb1.b("CouponDialogHelper", "openTimeCountDown");
        }
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007012776")) {
            ipChange.ipc$dispatch("-2007012776", new Object[]{this});
        } else {
            this.j = System.currentTimeMillis();
        }
    }

    public void r(xr xrVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48165560")) {
            ipChange.ipc$dispatch("-48165560", new Object[]{this, xrVar});
            return;
        }
        xrVar.b(DamaiConstants.RED_PACKET, new Action<Object>() { // from class: cn.damai.commonbusiness.coupondialog.CouponDialogHelper.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.message.observer.Action
            public void call(Object obj) {
                IpChange ipChange2 = $ipChange;
                int i = 0;
                if (AndroidInstantRuntime.support(ipChange2, "-543201732")) {
                    ipChange2.ipc$dispatch("-543201732", new Object[]{this, obj});
                    return;
                }
                cb1.b("CouponDialogHelper", "message on call()");
                if (obj != null && (obj instanceof Integer)) {
                    i = ((Integer) obj).intValue();
                }
                cb1.b("CouponDialogHelper", "curType = " + i + ", type = " + CouponDialogHelper.this.k);
                CouponDialogHelper.this.g = true;
                if (CouponDialogHelper.this.k != i) {
                    CouponDialogHelper.this.x(i);
                    new Handler().postDelayed(new Runnable() { // from class: cn.damai.commonbusiness.coupondialog.CouponDialogHelper.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1890974412")) {
                                ipChange3.ipc$dispatch("-1890974412", new Object[]{this});
                            } else {
                                CouponDialogHelper.this.w();
                            }
                        }
                    }, 1000L);
                }
            }
        });
        cb1.b("CouponDialogHelper", "registerRedPacketReceiver");
    }

    public void s(CouponDialog couponDialog) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1211415679")) {
            ipChange.ipc$dispatch("-1211415679", new Object[]{this, couponDialog});
        } else if (couponDialog != null) {
            try {
                List<View> i = couponDialog.i();
                int e = wh2.e(i);
                for (int i2 = 0; i2 < e; i2++) {
                    CouponListResponse.Coupon coupon = (CouponListResponse.Coupon) i.get(i2).getTag();
                    yo.f().g(coupon.startShowTimeMillis, this.h, coupon.eventTrack, i2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void u(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751313622")) {
            ipChange.ipc$dispatch("-1751313622", new Object[]{this, str, str2});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(this.i)) {
                hashMap.put("city", z20.d() + "市");
                hashMap.put("usercode", z20.E());
            } else {
                hashMap.put("item_id", this.i);
                hashMap.put("usercode", z20.E());
            }
            hashMap.put("eventTrack", str2);
            C0529c.e().C("use", "redpaper", this.h, "1.0", System.currentTimeMillis() - this.j, hashMap, 2201);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void v() {
        List<CouponListResponse.Model> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914325038")) {
            ipChange.ipc$dispatch("914325038", new Object[]{this});
            return;
        }
        CouponClearRequest couponClearRequest = new CouponClearRequest();
        CouponListResponse couponListResponse = this.a;
        if (couponListResponse != null && (list = couponListResponse.model) != null && list.size() > 0 && this.a.model.get(0).contentList != null && this.a.model.get(0).contentList.size() > 0) {
            couponClearRequest.id = this.a.model.get(0).contentList.get(0).id;
            couponClearRequest.type = this.a.model.get(0).type;
        }
        couponClearRequest.request(new DMMtopRequestListener<CouponClearResponse>(CouponClearResponse.class) { // from class: cn.damai.commonbusiness.coupondialog.CouponDialogHelper.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-673241318")) {
                    ipChange2.ipc$dispatch("-673241318", new Object[]{this, str, str2});
                } else {
                    cb1.b("ClearCouponFalse", "ClearCoupon onFail");
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CouponClearResponse couponClearResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "745569364")) {
                    ipChange2.ipc$dispatch("745569364", new Object[]{this, couponClearResponse});
                } else {
                    cb1.b("ClearCouponSuccess", "ClearCoupon onSuccess");
                }
            }
        });
    }

    public void x(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1459734568")) {
            ipChange.ipc$dispatch("-1459734568", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.k = i;
        }
    }

    public void y(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180117006")) {
            ipChange.ipc$dispatch("1180117006", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.b = z;
        cb1.b("CouponDialogHelper", "setClickRedPacket = " + z);
    }

    public void z(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201776017")) {
            ipChange.ipc$dispatch("1201776017", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            z20.S(0);
            this.a = null;
            y(false);
            x(0);
        }
    }
}
