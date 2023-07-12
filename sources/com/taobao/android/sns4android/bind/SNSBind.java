package com.taobao.android.sns4android.bind;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.SNSBindService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BundleUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.ucc.UccService;
import com.alibaba.fastjson.JSON;
import com.taobao.android.sns4android.AuthCallback;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sns4android.model.SnsCainiaoBindResult;
import com.taobao.android.sns4android.rpc.ExtraBindResult;
import com.taobao.android.sns4android.rpc.SNSDataRepository;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.session.SessionManager;
import java.util.HashMap;
import tb.uh1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SNSBind implements SNSBindService {
    public static final String TAG = "login.SNSBind";
    private static volatile SNSBind instance;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.bind.SNSBind$a */
    /* loaded from: classes11.dex */
    class C6610a implements AuthCallback {
        final /* synthetic */ Activity a;
        final /* synthetic */ CommonCallback b;

        C6610a(Activity activity, CommonCallback commonCallback) {
            this.a = activity;
            this.b = commonCallback;
        }

        @Override // com.taobao.android.sns4android.AuthCallback
        public void onFail(int i, String str) {
            if (i == 1007) {
                this.b.onFail(i, "");
            } else {
                this.b.onFail(i, str);
            }
        }

        @Override // com.taobao.android.sns4android.AuthCallback
        public void onSuccess(SNSSignInAccount sNSSignInAccount) {
            sNSSignInAccount.snsType = "taobao";
            SNSBind.this.doBind(this.a, sNSSignInAccount, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.bind.SNSBind$b */
    /* loaded from: classes11.dex */
    public class C6611b implements RpcRequestCallback {
        final /* synthetic */ CommonCallback a;
        final /* synthetic */ Activity b;
        final /* synthetic */ SNSSignInAccount c;

        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.bind.SNSBind$b$a */
        /* loaded from: classes12.dex */
        class DialogInterface$OnClickListenerC6612a implements DialogInterface.OnClickListener {
            final /* synthetic */ SnsCainiaoBindResult a;

            DialogInterface$OnClickListenerC6612a(SnsCainiaoBindResult snsCainiaoBindResult) {
                this.a = snsCainiaoBindResult;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ExtraBindResult extraBindResult = (ExtraBindResult) this.a.returnValue;
                if (extraBindResult != null) {
                    C6611b c6611b = C6611b.this;
                    SNSSignInAccount sNSSignInAccount = c6611b.c;
                    sNSSignInAccount.userId = extraBindResult.bindId;
                    sNSSignInAccount.changeBindToken = extraBindResult.changeBindToken;
                    SNSBind.this.doChangeBind(sNSSignInAccount, extraBindResult.avatar, extraBindResult.thirdNick, c6611b.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.sns4android.bind.SNSBind$b$b */
        /* loaded from: classes12.dex */
        class DialogInterface$OnClickListenerC6613b implements DialogInterface.OnClickListener {
            DialogInterface$OnClickListenerC6613b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C6611b.this.a.onFail(701, "");
            }
        }

        C6611b(CommonCallback commonCallback, Activity activity, SNSSignInAccount sNSSignInAccount) {
            this.a = commonCallback;
            this.b = activity;
            this.c = sNSSignInAccount;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail"));
            } else {
                commonCallback.onFail(rpcResponse.code, rpcResponse.message);
            }
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, "sns auth code login with empty response");
                return;
            }
            SnsCainiaoBindResult snsCainiaoBindResult = (SnsCainiaoBindResult) rpcResponse;
            boolean z = snsCainiaoBindResult.success;
            String str = snsCainiaoBindResult.message;
            if (TextUtils.isEmpty(str)) {
                str = ResourceUtil.getStringById("aliuser_network_error");
            }
            if (z) {
                this.a.onSuccess();
                return;
            }
            int i = snsCainiaoBindResult.code;
            if (i == 212 || i == 121106) {
                new AlertDialog.Builder(this.b).setMessage(snsCainiaoBindResult.message).setNegativeButton("取消", new DialogInterface$OnClickListenerC6613b()).setPositiveButton("确定", new DialogInterface$OnClickListenerC6612a(snsCainiaoBindResult)).create().show();
            } else if (i != 121104 && i != 216 && i != 203018) {
                this.a.onFail(i, str);
            } else {
                ExtraBindResult extraBindResult = (ExtraBindResult) snsCainiaoBindResult.returnValue;
                if (extraBindResult != null && !TextUtils.isEmpty(extraBindResult.messageExtra)) {
                    this.a.onFail(snsCainiaoBindResult.code, extraBindResult.messageExtra);
                } else {
                    this.a.onFail(snsCainiaoBindResult.code, str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("errorCode", snsCainiaoBindResult.code + "");
                hashMap.put("errorMsg", str);
                T t = snsCainiaoBindResult.returnValue;
                if (t != 0) {
                    hashMap.put("data", JSON.toJSONString(t));
                }
                BroadCastHelper.sendBroadcast(LoginAction.BIND_ALIPAY_FAILED, hashMap);
            }
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, ResourceUtil.getStringById("aliuser_SNS_platform_auth_fail"));
            } else {
                commonCallback.onFail(rpcResponse.code, rpcResponse.message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.bind.SNSBind$c */
    /* loaded from: classes11.dex */
    public class C6614c implements RpcRequestCallback {
        final /* synthetic */ CommonCallback a;

        C6614c(SNSBind sNSBind, CommonCallback commonCallback) {
            this.a = commonCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, "sns auth code login with empty response");
                return;
            }
            String str = ((SnsCainiaoBindResult) rpcResponse).message;
            if (TextUtils.isEmpty(str)) {
                str = ResourceUtil.getStringById("aliuser_network_error");
            }
            this.a.onFail(-2, str);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, "sns auth code login with empty response");
                return;
            }
            SnsCainiaoBindResult snsCainiaoBindResult = (SnsCainiaoBindResult) rpcResponse;
            boolean z = snsCainiaoBindResult.success;
            String str = snsCainiaoBindResult.message;
            if (TextUtils.isEmpty(str)) {
                str = ResourceUtil.getStringById("aliuser_network_error");
            }
            if (z) {
                this.a.onSuccess();
                return;
            }
            int i = snsCainiaoBindResult.code;
            if (i != 121104 && i != 216 && i != 203018) {
                this.a.onFail(-1, str);
                return;
            }
            ExtraBindResult extraBindResult = (ExtraBindResult) snsCainiaoBindResult.returnValue;
            if (extraBindResult != null && !TextUtils.isEmpty(extraBindResult.messageExtra)) {
                this.a.onFail(snsCainiaoBindResult.code, extraBindResult.messageExtra);
            } else {
                this.a.onFail(snsCainiaoBindResult.code, str);
            }
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse rpcResponse) {
            CommonCallback commonCallback = this.a;
            if (commonCallback == null) {
                return;
            }
            if (rpcResponse == null) {
                commonCallback.onFail(704, "sns auth code login with empty response");
                return;
            }
            String str = ((SnsCainiaoBindResult) rpcResponse).message;
            if (TextUtils.isEmpty(str)) {
                str = ResourceUtil.getStringById("aliuser_network_error");
            }
            this.a.onFail(-2, str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.sns4android.bind.SNSBind$d */
    /* loaded from: classes11.dex */
    static class C6615d implements MemberCallback<String> {
        final /* synthetic */ String a;

        C6615d(String str) {
            this.a = str;
        }

        @Override // com.ali.user.open.core.callback.MemberCallback
        /* renamed from: a */
        public void onSuccess(String str) {
            SessionManager sessionManager = SessionManager.getInstance(DataProviderFactory.getApplicationContext());
            if (sessionManager != null && !TextUtils.isEmpty(sessionManager.getUserId())) {
                try {
                    SNSBind.newManageUrl(str, this.a);
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    SNSBind.newManageUrl(str, this.a);
                    return;
                }
            }
            SNSBind.newManageUrl(str, this.a);
        }

        @Override // com.ali.user.open.core.callback.FailureCallback
        public void onFailure(int i, String str) {
            SNSAuth.toastBusy(str);
        }
    }

    private static void auth(AuthCallback authCallback) {
        SNSBindContext.loginCallback = authCallback;
        Intent intent = new Intent();
        intent.setClass(DataProviderFactory.getApplicationContext(), AuthMiddleActivity.class);
        intent.setFlags(268435456);
        DataProviderFactory.getApplicationContext().startActivity(intent);
    }

    private void doCainiaoBind(Activity activity, SNSSignInAccount sNSSignInAccount, CommonCallback commonCallback) {
        if (activity == null || commonCallback == null) {
            return;
        }
        SNSDataRepository.getInstance().snsBindCaiNiao(sNSSignInAccount.snsType, sNSSignInAccount.token, DataProviderFactory.getDataProvider().getAccountBindBizType(), new C6611b(commonCallback, activity, sNSSignInAccount));
    }

    private void doCainiaoChange(SNSSignInAccount sNSSignInAccount, String str, String str2, CommonCallback commonCallback) {
        SNSDataRepository.getInstance().snsChangeBindCaiNiao(sNSSignInAccount.snsType, sNSSignInAccount.userId, sNSSignInAccount.changeBindToken, DataProviderFactory.getDataProvider().getAccountBindBizType(), str, str2, new C6614c(this, commonCallback));
    }

    public static SNSBind getInstance() {
        if (instance == null) {
            synchronized (SNSBind.class) {
                if (instance == null) {
                    instance = new SNSBind();
                }
            }
        }
        return instance;
    }

    protected static void newManageUrl(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        if (str2.endsWith("?")) {
            sb.append("site=");
        } else {
            sb.append("&site=");
        }
        sb.append(AliMemberSDK.getMasterSite());
        sb.append("&request_token=");
        sb.append(str);
        String sb2 = sb.toString();
        UrlParam urlParam = new UrlParam();
        urlParam.url = sb2;
        if (ServiceFactory.getService(NavigatorService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openWebViewPage(DataProviderFactory.getApplicationContext(), urlParam);
        }
    }

    public static void openAuthManagerPage() {
        String str;
        uh1.a();
        if (DataProviderFactory.getDataProvider().getEnvType() == 1) {
            str = "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=daily";
        } else {
            str = DataProviderFactory.getDataProvider().getEnvType() == 2 ? "https://market.wapa.taobao.com/app/vip/ucc/pages/bind_manage?env=pre" : "https://market.m.taobao.com/app/vip/ucc/pages/bind_manage?";
        }
        if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() != null) {
            ((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider().getUserToken("", new C6615d(str));
        } else {
            SNSAuth.toastBusy("data provider为空");
        }
    }

    @Override // com.ali.user.mobile.service.SNSBindService
    public void bind(Activity activity, SNSPlatform sNSPlatform, CommonCallback commonCallback) {
        if (sNSPlatform == null || commonCallback == null) {
            return;
        }
        if (sNSPlatform == SNSPlatform.PLATFORM_TAOBAO) {
            auth(new C6610a(activity, commonCallback));
        } else if (sNSPlatform == SNSPlatform.PLATFORM_QQ && !BundleUtil.isAppInstalled(activity, "com.tencent.mobileqq")) {
            commonCallback.onFail(10001, "请先安装QQ");
        } else if (sNSPlatform == SNSPlatform.PLATFORM_WEIXIN && !BundleUtil.isAppInstalled(activity, "com.tencent.mm")) {
            commonCallback.onFail(10002, "请先安装微信");
        } else {
            SNSBindContext.sBindCallback = commonCallback;
            SNSAuth.bind(sNSPlatform, activity);
        }
    }

    @Override // com.ali.user.mobile.service.SNSBindService
    public void clean() {
        SNSBindContext.sBindCallback = null;
    }

    @Override // com.ali.user.mobile.service.SNSBindService
    public void doBind(Activity activity, SNSSignInAccount sNSSignInAccount, CommonCallback commonCallback) {
        doCainiaoBind(activity, sNSSignInAccount, commonCallback);
    }

    @Override // com.ali.user.mobile.service.SNSBindService
    public void doChangeBind(SNSSignInAccount sNSSignInAccount, String str, String str2, CommonCallback commonCallback) {
        doCainiaoChange(sNSSignInAccount, str, str2, commonCallback);
    }
}
