package com.ali.user.mobile.register.tasks;

import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.callback.CommonDataCallback;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.model.TrackingModel;
import com.ali.user.mobile.register.RegisterException;
import com.ali.user.mobile.register.model.OceanRegisterParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.register.model.OceanRegisterResult;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.MainThreadExecutor;
import com.alibaba.fastjson.JSON;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public abstract class BaseRegisterTask {
    protected static final String TAG = "BaseRegisterTask";
    protected WeakReference<BaseView> baseView;
    protected OceanRegisterParam registerParam;
    protected TrackingModel trackingModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class RegisterRpcRequestCallback implements RpcRequestCallback<OceanRegisterResult> {
        private final OceanRegisterParam registerParam;
        private final RegisterTasksCallback<OceanRegisterResult> registerResultCallback;

        public RegisterRpcRequestCallback(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
            this.registerParam = oceanRegisterParam;
            this.registerResultCallback = registerTasksCallback;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            BaseRegisterTask.this.processRegisterResult(this.registerParam, rpcResponse, this.registerResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            BaseRegisterTask.this.processRegisterResult(this.registerParam, rpcResponse, this.registerResultCallback);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse<OceanRegisterResult> rpcResponse) {
            BaseRegisterTask.this.dismissLoading();
            RegisterTasksCallback<OceanRegisterResult> registerTasksCallback = this.registerResultCallback;
            if (registerTasksCallback != null) {
                registerTasksCallback.onFail(new RegisterException<>(rpcResponse.code, rpcResponse.message, rpcResponse));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface RegisterTasksCallback<T> {
        void onCancel();

        void onFail(RegisterException<T> registerException);

        void onSuccess(RpcResponse<T> rpcResponse);
    }

    private RpcRequestCallback<OceanRegisterResult> createRegisterRpcCallback(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        return new RegisterRpcRequestCallback(oceanRegisterParam, registerTasksCallback);
    }

    protected void buildRegisterParam(final CommonDataCallback commonDataCallback) {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.register.tasks.BaseRegisterTask.2
            @Override // java.lang.Runnable
            public void run() {
                commonDataCallback.onSuccess(null);
            }
        });
    }

    protected void dismissLoading() {
        WeakReference<BaseView> weakReference = this.baseView;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.baseView.get().dismissLoading();
    }

    protected abstract void invokeRegisterRpc(OceanRegisterParam oceanRegisterParam, RpcRequestCallback<OceanRegisterResult> rpcRequestCallback);

    protected void onReceiveH5(OceanRegisterParam oceanRegisterParam, RpcResponse<OceanRegisterResult> rpcResponse, final RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        TrackingModel trackingModel = this.trackingModel;
        String str = trackingModel == null ? UTConstant.PageName.UT_PAGE_EXTEND : trackingModel.pageName;
        String str2 = rpcResponse.returnValue.h5Url;
        LoginParam loginParam = new LoginParam();
        TrackingModel trackingModel2 = this.trackingModel;
        if (trackingModel2 != null) {
            loginParam.loginSourcePage = trackingModel2.pageName;
            loginParam.loginSourceSpm = trackingModel2.pageSpm;
            loginParam.loginSourceType = trackingModel2.loginType;
            loginParam.traceId = trackingModel2.traceId;
        }
        EventBus.getDefault().registerEventListener(EventBusEnum.EventName.REGISTER_H5, new EventListener() { // from class: com.ali.user.mobile.register.tasks.BaseRegisterTask.3
            /* JADX WARN: Type inference failed for: r1v7, types: [com.ali.user.mobile.rpc.register.model.OceanRegisterResult, T] */
            @Override // com.ali.user.mobile.eventbus.EventListener
            public void onEvent(Event event) {
                Map<String, Object> map;
                RegisterTasksCallback registerTasksCallback2;
                EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.REGISTER_H5, this);
                if (event != null && (map = event.params) != null) {
                    String str3 = (String) map.get(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
                    String str4 = (String) event.params.get("result");
                    if (!TextUtils.isEmpty(str3) && TextUtils.equals(str4, "success")) {
                        LoginParam loginParam2 = (LoginParam) JSON.parseObject(str3, LoginParam.class);
                        if (loginParam2 == null) {
                            loginParam2 = new LoginParam();
                        }
                        if (registerTasksCallback != null) {
                            RpcResponse rpcResponse2 = new RpcResponse();
                            ?? oceanRegisterResult = new OceanRegisterResult();
                            rpcResponse2.returnValue = oceanRegisterResult;
                            ((OceanRegisterResult) oceanRegisterResult).continueLoginToken = loginParam2.token;
                            registerTasksCallback.onSuccess(rpcResponse2);
                            return;
                        }
                        return;
                    } else if (TextUtils.equals(str4, "cancel") && (registerTasksCallback2 = registerTasksCallback) != null) {
                        registerTasksCallback2.onCancel();
                        return;
                    } else {
                        RegisterTasksCallback registerTasksCallback3 = registerTasksCallback;
                        if (registerTasksCallback3 != null) {
                            registerTasksCallback3.onFail(new RegisterException(604, ""));
                            return;
                        }
                        return;
                    }
                }
                RegisterTasksCallback registerTasksCallback4 = registerTasksCallback;
                if (registerTasksCallback4 != null) {
                    registerTasksCallback4.onFail(new RegisterException(605, ""));
                }
            }
        });
        ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).openRegWebViewPage(str2, EventBusEnum.EventName.REGISTER_H5, str, loginParam);
    }

    protected void onReceiverOtherError(RpcResponse<OceanRegisterResult> rpcResponse, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        if (registerTasksCallback != null) {
            registerTasksCallback.onFail(new RegisterException<>(rpcResponse == null ? 1100 : rpcResponse.code, rpcResponse == null ? "" : rpcResponse.message, rpcResponse));
        }
    }

    protected void processRegisterResult(OceanRegisterParam oceanRegisterParam, RpcResponse<OceanRegisterResult> rpcResponse, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        if (rpcResponse != null) {
            String str = rpcResponse.actionType;
            String str2 = TAG;
            TLogAdapter.d(str2, ",actionType=" + str + ", msg=" + rpcResponse.message);
            if (!TextUtils.isEmpty(str)) {
                if ("SUCCESS".equals(str)) {
                    if (registerTasksCallback != null) {
                        registerTasksCallback.onSuccess(rpcResponse);
                        return;
                    }
                    return;
                } else if ("H5".equals(str)) {
                    onReceiveH5(oceanRegisterParam, rpcResponse, registerTasksCallback);
                    return;
                } else {
                    onReceiverOtherError(rpcResponse, registerTasksCallback);
                    return;
                }
            }
            onReceiverOtherError(rpcResponse, registerTasksCallback);
            return;
        }
        onReceiverOtherError(null, registerTasksCallback);
    }

    public void register(final OceanRegisterParam oceanRegisterParam, TrackingModel trackingModel, BaseView baseView, final RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        this.registerParam = oceanRegisterParam;
        this.trackingModel = trackingModel;
        this.baseView = new WeakReference<>(baseView);
        buildRegisterParam(new CommonDataCallback() { // from class: com.ali.user.mobile.register.tasks.BaseRegisterTask.1
            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onFail(int i, String str) {
                RegisterTasksCallback registerTasksCallback2 = registerTasksCallback;
                if (registerTasksCallback2 != null) {
                    registerTasksCallback2.onFail(new RegisterException(i, str));
                }
            }

            @Override // com.ali.user.mobile.callback.CommonDataCallback
            public void onSuccess(Map<String, String> map) {
                BaseRegisterTask.this.startRegister(oceanRegisterParam, registerTasksCallback);
            }
        });
    }

    protected void showLoading() {
        WeakReference<BaseView> weakReference = this.baseView;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.baseView.get().showLoading();
    }

    protected void startRegister(OceanRegisterParam oceanRegisterParam, RegisterTasksCallback<OceanRegisterResult> registerTasksCallback) {
        showLoading();
        invokeRegisterRpc(oceanRegisterParam, createRegisterRpcCallback(oceanRegisterParam, registerTasksCallback));
    }
}
