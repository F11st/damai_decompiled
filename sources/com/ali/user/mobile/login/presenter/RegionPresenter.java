package com.ali.user.mobile.login.presenter;

import android.os.AsyncTask;
import com.ali.user.mobile.base.BasePresenter;
import com.ali.user.mobile.base.BaseView;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopCountryCodeContextResult;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.utils.CountryCodeUtil;
import com.ali.user.mobile.utils.ResourceUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RegionPresenter implements BasePresenter {
    public static final int LOGIN_REGION = 0;
    public static final int REGISTER_REGION = 1;
    BaseView mViewer;

    public RegionPresenter(BaseView baseView) {
        this.mViewer = baseView;
    }

    private void getRegion(final int i, final RpcRequestCallback rpcRequestCallback) {
        new CoordinatorWrapper().execute(new AsyncTask<Object, Void, MtopRegisterInitcontextResponseData>() { // from class: com.ali.user.mobile.login.presenter.RegionPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.AsyncTask
            public MtopRegisterInitcontextResponseData doInBackground(Object[] objArr) {
                MtopRegisterInitcontextResponseData countryCodeRes;
                HashMap hashMap = new HashMap();
                BaseRegistRequest baseRegistRequest = new BaseRegistRequest();
                baseRegistRequest.ext = hashMap;
                try {
                    if (i == 0) {
                        countryCodeRes = (MtopRegisterInitcontextResponseData) LoginComponent.getInstance().getCountryList();
                    } else {
                        countryCodeRes = RegisterComponent.getInstance().countryCodeRes(baseRegistRequest);
                    }
                    return countryCodeRes;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData) {
                RpcRequestCallback rpcRequestCallback2 = rpcRequestCallback;
                if (rpcRequestCallback2 == null) {
                    return;
                }
                if (mtopRegisterInitcontextResponseData == null) {
                    rpcRequestCallback2.onSystemError(null);
                } else if (mtopRegisterInitcontextResponseData.returnValue != 0) {
                    rpcRequestCallback2.onSuccess(mtopRegisterInitcontextResponseData);
                } else {
                    rpcRequestCallback2.onError(mtopRegisterInitcontextResponseData);
                }
            }
        }, new Object[0]);
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onDestory() {
        this.mViewer = null;
    }

    @Override // com.ali.user.mobile.base.BasePresenter
    public void onStart() {
    }

    public void region(int i) {
        BaseView baseView = this.mViewer;
        if (baseView == null || !baseView.isActive()) {
            return;
        }
        this.mViewer.showLoading();
        getRegion(i, new RpcRequestCallback() { // from class: com.ali.user.mobile.login.presenter.RegionPresenter.1
            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onError(RpcResponse rpcResponse) {
                BaseView baseView2 = RegionPresenter.this.mViewer;
                if (baseView2 == null || !baseView2.isActive()) {
                    return;
                }
                RegionPresenter.this.mViewer.dismissLoading();
                SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData = (MtopRegisterInitcontextResponseData) rpcResponse;
                if (mtopRegisterInitcontextResponseData == null || (t = mtopRegisterInitcontextResponseData.returnValue) == 0 || ((MtopCountryCodeContextResult) t).countrycodes == null) {
                    return;
                }
                ArrayList<RegionInfo> fillData = CountryCodeUtil.fillData(ResourceUtil.getStringById("aliuser_common_region"), ((MtopCountryCodeContextResult) mtopRegisterInitcontextResponseData.returnValue).countrycodes, new HashMap(), new ArrayList());
                BaseView baseView2 = RegionPresenter.this.mViewer;
                if (baseView2 != null) {
                    baseView2.dismissLoading();
                    RegionPresenter.this.mViewer.onGetRegion(fillData);
                }
            }

            @Override // com.ali.user.mobile.callback.RpcRequestCallback
            public void onSystemError(RpcResponse rpcResponse) {
                BaseView baseView2 = RegionPresenter.this.mViewer;
                if (baseView2 == null || !baseView2.isActive()) {
                    return;
                }
                RegionPresenter.this.mViewer.dismissLoading();
                SDKExceptionHelper.getInstance().rpcExceptionHandler(new RpcException((Integer) 6, ""));
            }
        });
    }
}
