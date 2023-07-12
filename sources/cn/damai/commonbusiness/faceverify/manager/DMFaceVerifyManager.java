package cn.damai.commonbusiness.faceverify.manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.faceverify.activity.FaceVerifyFailedActivity;
import cn.damai.commonbusiness.faceverify.activity.IdentityInfoQueryActivity;
import cn.damai.commonbusiness.faceverify.bean.BaseFaceVerifyBean;
import cn.damai.commonbusiness.faceverify.bean.CustomerAccountVerifyBean;
import cn.damai.commonbusiness.faceverify.bean.FaceVerifyTokenBean;
import cn.damai.commonbusiness.faceverify.bean.IdentityInfoQueryBean;
import cn.damai.commonbusiness.faceverify.listener.DMFaceVerifyListener;
import cn.damai.commonbusiness.faceverify.listener.DMFaceVerifyResult;
import cn.damai.commonbusiness.faceverify.request.AccountRealNameAuthRequest;
import cn.damai.commonbusiness.faceverify.request.CustomerAccountVerifyRequest;
import cn.damai.commonbusiness.faceverify.request.FaceVerifyNextStepRequest;
import cn.damai.commonbusiness.faceverify.request.FaceVerifyTokenRequest;
import cn.damai.commonbusiness.faceverify.request.IdentityInfoQueryRequest;
import cn.damai.login.LoginManager;
import com.alibaba.security.rp.RPSDK;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.h4;
import tb.k3;
import tb.mu0;
import tb.my1;
import tb.xr;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class DMFaceVerifyManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DMFaceVerifyManager c;
    private DMFaceVerifyListener a;
    private DMFaceVerifyResult b;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements RPSDK.RPCompletedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        a(Context context, String str, String str2, String str3, String str4) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.alibaba.security.rp.RPSDK.RPCompletedListener
        public void onAuditResult(RPSDK.AUDIT audit) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1063707232")) {
                ipChange.ipc$dispatch("-1063707232", new Object[]{this, audit});
            } else if (audit != RPSDK.AUDIT.AUDIT_NOT) {
                DMFaceVerifyManager.this.p(audit, this.a, this.b, this.c, this.d, this.e);
            } else {
                DMFaceVerifyManager.this.r();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1555765243")) {
                ipChange.ipc$dispatch("1555765243", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            DMFaceVerifyManager.this.t();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        c(Context context, String str, String str2, String str3) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1769621030")) {
                ipChange.ipc$dispatch("-1769621030", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DMFaceVerifyManager.this.j(this.a, this.b, this.c, this.d);
            DMFaceVerifyManager.this.t();
        }
    }

    private DMFaceVerifyManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914143381")) {
            ipChange.ipc$dispatch("-914143381", new Object[]{this, context, str, str2, str3});
            return;
        }
        AccountRealNameAuthRequest accountRealNameAuthRequest = new AccountRealNameAuthRequest();
        accountRealNameAuthRequest.loginKey = z20.q();
        accountRealNameAuthRequest.idCard = str;
        accountRealNameAuthRequest.name = str3;
        accountRealNameAuthRequest.idCardType = str2;
        accountRealNameAuthRequest.request(new DMMtopRequestListener<BaseFaceVerifyBean>(BaseFaceVerifyBean.class) { // from class: cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager.8
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str4, String str5) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-862114212")) {
                    ipChange2.ipc$dispatch("-862114212", new Object[]{this, str4, str5});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseFaceVerifyBean baseFaceVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-553608598")) {
                    ipChange2.ipc$dispatch("-553608598", new Object[]{this, baseFaceVerifyBean});
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(IdentityInfoQueryBean identityInfoQueryBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1152399650")) {
            ipChange.ipc$dispatch("1152399650", new Object[]{this, identityInfoQueryBean});
            return;
        }
        if (this.b == null) {
            this.b = new DMFaceVerifyResult();
        }
        this.b.b = identityInfoQueryBean.getIdCard();
        this.b.c = identityInfoQueryBean.getIdCardType();
        this.b.d = identityInfoQueryBean.getName();
        this.b.e = identityInfoQueryBean.getIdentityHash();
        this.b.f = identityInfoQueryBean.isNeedFaceVerify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final Context context, final String str, final String str2, final String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084060519")) {
            ipChange.ipc$dispatch("2084060519", new Object[]{this, context, str, str2, str3, str4});
            return;
        }
        CustomerAccountVerifyRequest customerAccountVerifyRequest = new CustomerAccountVerifyRequest();
        customerAccountVerifyRequest.scene = str4;
        customerAccountVerifyRequest.request(new DMMtopRequestListener<CustomerAccountVerifyBean>(CustomerAccountVerifyBean.class) { // from class: cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str5, String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-838836135")) {
                    ipChange2.ipc$dispatch("-838836135", new Object[]{this, str5, str6});
                } else {
                    DMFaceVerifyManager.this.t();
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CustomerAccountVerifyBean customerAccountVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-342040428")) {
                    ipChange2.ipc$dispatch("-342040428", new Object[]{this, customerAccountVerifyBean});
                } else if (customerAccountVerifyBean == null || !customerAccountVerifyBean.isCould()) {
                    DMFaceVerifyManager.this.t();
                } else {
                    DMFaceVerifyManager.this.m(context, str, str2, str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310293026")) {
            ipChange.ipc$dispatch("310293026", new Object[]{this, context, str, str2, str3});
            return;
        }
        if (k3.b().c() instanceof IdentityInfoQueryActivity) {
            k3.b().f(k3.b().c());
        }
        Activity c2 = k3.b().c();
        if (c2 != null) {
            new h4(c2).h("是", new c(context, str, str2, str3)).f("否", new b()).e("将该人脸信息补充到您的账号实名认证？").d(false).j();
        }
    }

    public static DMFaceVerifyManager n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "690833883")) {
            return (DMFaceVerifyManager) ipChange.ipc$dispatch("690833883", new Object[0]);
        }
        if (c == null) {
            synchronized (DMFaceVerifyManager.class) {
                if (c == null) {
                    c = new DMFaceVerifyManager();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final Context context, final String str, final String str2, final String str3, final String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055124119")) {
            ipChange.ipc$dispatch("-1055124119", new Object[]{this, context, str, str2, str3, str4});
            return;
        }
        FaceVerifyTokenRequest faceVerifyTokenRequest = new FaceVerifyTokenRequest();
        faceVerifyTokenRequest.loginKey = z20.q();
        faceVerifyTokenRequest.name = str3;
        faceVerifyTokenRequest.idCard = str;
        faceVerifyTokenRequest.idCardType = str2;
        faceVerifyTokenRequest.scene = str4;
        faceVerifyTokenRequest.request(new DMMtopRequestListener<FaceVerifyTokenBean>(FaceVerifyTokenBean.class) { // from class: cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str5, String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-815558058")) {
                    ipChange2.ipc$dispatch("-815558058", new Object[]{this, str5, str6});
                } else {
                    DMFaceVerifyManager.this.s(str5, str6);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FaceVerifyTokenBean faceVerifyTokenBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-216255722")) {
                    ipChange2.ipc$dispatch("-216255722", new Object[]{this, faceVerifyTokenBean});
                } else {
                    DMFaceVerifyManager.this.y(context, faceVerifyTokenBean, str, str2, str3, str4);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final RPSDK.AUDIT audit, final Context context, final String str, final String str2, final String str3, final String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31552612")) {
            ipChange.ipc$dispatch("31552612", new Object[]{this, audit, context, str, str2, str3, str4});
            return;
        }
        FaceVerifyNextStepRequest faceVerifyNextStepRequest = new FaceVerifyNextStepRequest();
        faceVerifyNextStepRequest.scene = str4;
        faceVerifyNextStepRequest.loginKey = z20.q();
        faceVerifyNextStepRequest.request(new DMMtopRequestListener<BaseFaceVerifyBean>(BaseFaceVerifyBean.class) { // from class: cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str5, String str6) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-831076776")) {
                    ipChange2.ipc$dispatch("-831076776", new Object[]{this, str5, str6});
                } else {
                    ToastUtil.i(str6);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseFaceVerifyBean baseFaceVerifyBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-693902098")) {
                    ipChange2.ipc$dispatch("-693902098", new Object[]{this, baseFaceVerifyBean});
                    return;
                }
                RPSDK.AUDIT audit2 = audit;
                if (audit2 != RPSDK.AUDIT.AUDIT_EXCEPTION && audit2 != RPSDK.AUDIT.AUDIT_FAIL) {
                    if (audit2 == RPSDK.AUDIT.AUDIT_NOT) {
                        DMFaceVerifyManager.this.r();
                        return;
                    }
                    xr.c("faceVerify", Boolean.TRUE);
                    DMFaceVerifyManager.this.l(context, str, str2, str3, str4);
                    return;
                }
                FaceVerifyFailedActivity.startFaceVerifyFailedActivity(context, str, str2, str3, str4);
            }
        });
    }

    private void q(final Context context, String str, String str2, String str3, String str4, final String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1668272029")) {
            ipChange.ipc$dispatch("-1668272029", new Object[]{this, context, str, str2, str3, str4, str5});
            return;
        }
        IdentityInfoQueryRequest identityInfoQueryRequest = new IdentityInfoQueryRequest();
        identityInfoQueryRequest.idCard = str;
        identityInfoQueryRequest.name = str3;
        identityInfoQueryRequest.idCardType = str2;
        identityInfoQueryRequest.cryptographicInfo = str4;
        identityInfoQueryRequest.loginKey = z20.q();
        identityInfoQueryRequest.request(new DMMtopRequestListener<IdentityInfoQueryBean>(IdentityInfoQueryBean.class) { // from class: cn.damai.commonbusiness.faceverify.manager.DMFaceVerifyManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str6, String str7) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-807798699")) {
                    ipChange2.ipc$dispatch("-807798699", new Object[]{this, str6, str7});
                } else {
                    DMFaceVerifyManager.this.s(str6, str7);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(IdentityInfoQueryBean identityInfoQueryBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1294950596")) {
                    ipChange2.ipc$dispatch("-1294950596", new Object[]{this, identityInfoQueryBean});
                } else if (identityInfoQueryBean != null && identityInfoQueryBean.isNeedFaceVerify()) {
                    DMFaceVerifyManager.this.k(identityInfoQueryBean);
                    DMFaceVerifyManager.this.o(context, identityInfoQueryBean.getIdCard(), identityInfoQueryBean.getIdCardType(), identityInfoQueryBean.getName(), str5);
                } else {
                    ToastUtil.i("人脸信息已存在");
                    DMFaceVerifyManager.this.u(identityInfoQueryBean);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1277035382")) {
            ipChange.ipc$dispatch("1277035382", new Object[]{this, str, str2});
        } else if (this.a != null) {
            DMFaceVerifyResult dMFaceVerifyResult = new DMFaceVerifyResult();
            dMFaceVerifyResult.a = DMFaceVerifyResult.State.FAIL;
            this.a.onAuditResult(dMFaceVerifyResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649691915")) {
            ipChange.ipc$dispatch("-649691915", new Object[]{this});
            return;
        }
        DMFaceVerifyListener dMFaceVerifyListener = this.a;
        if (dMFaceVerifyListener != null) {
            dMFaceVerifyListener.onAuditResult(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Context context, FaceVerifyTokenBean faceVerifyTokenBean, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915426501")) {
            ipChange.ipc$dispatch("-915426501", new Object[]{this, context, faceVerifyTokenBean, str, str2, str3, str4});
        } else if (faceVerifyTokenBean == null || TextUtils.isEmpty(faceVerifyTokenBean.getVerifyToken())) {
        } else {
            try {
                if (mu0.a() == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("contentlabel", "application 为null");
                    cn.damai.common.user.c.e().A(hashMap, "RPSDK_Application", "faceService");
                    return;
                }
                my1.a(mu0.a());
                if (RPSDK.getContext() == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("contentlabel", "RPSDK Context 为null");
                    cn.damai.common.user.c.e().A(hashMap2, "RPSDK_Context", "faceService");
                    return;
                }
                RPSDK.start(faceVerifyTokenBean.getVerifyToken(), context, new a(context, str, str2, str3, str4));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void r() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53402133")) {
            ipChange.ipc$dispatch("-53402133", new Object[]{this});
        } else if (this.a != null) {
            DMFaceVerifyResult dMFaceVerifyResult = new DMFaceVerifyResult();
            dMFaceVerifyResult.a = DMFaceVerifyResult.State.EMPTY;
            this.a.onAuditResult(dMFaceVerifyResult);
        }
    }

    public void u(IdentityInfoQueryBean identityInfoQueryBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039334095")) {
            ipChange.ipc$dispatch("2039334095", new Object[]{this, identityInfoQueryBean});
            return;
        }
        if (this.b == null) {
            this.b = new DMFaceVerifyResult();
        }
        if (identityInfoQueryBean != null) {
            this.b.b = identityInfoQueryBean.getIdCard();
            this.b.c = identityInfoQueryBean.getIdCardType();
            this.b.d = identityInfoQueryBean.getName();
            this.b.e = identityInfoQueryBean.getIdentityHash();
            this.b.f = identityInfoQueryBean.isNeedFaceVerify();
        }
        DMFaceVerifyListener dMFaceVerifyListener = this.a;
        if (dMFaceVerifyListener != null) {
            dMFaceVerifyListener.onAuditResult(this.b);
        }
    }

    public void v(DMFaceVerifyListener dMFaceVerifyListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064296043")) {
            ipChange.ipc$dispatch("-2064296043", new Object[]{this, dMFaceVerifyListener});
        } else {
            this.a = dMFaceVerifyListener;
        }
    }

    public void w(Context context, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23774031")) {
            ipChange.ipc$dispatch("23774031", new Object[]{this, context, str, str2, str3, str4});
        } else {
            x(context, str, str2, str3, null, str4);
        }
    }

    public void x(Context context, String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38185127")) {
            ipChange.ipc$dispatch("-38185127", new Object[]{this, context, str, str2, str3, str4, str5});
        } else if (LoginManager.k().q()) {
            if (!TextUtils.isEmpty(str4)) {
                q(context, str, str2, str3, str4, str5);
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                q(context, str, str2, str3, str4, str5);
            } else {
                Intent intent = new Intent(context, IdentityInfoQueryActivity.class);
                intent.putExtra("scence", str5);
                context.startActivity(intent);
            }
        } else {
            LoginManager.k().v(context);
        }
    }
}
