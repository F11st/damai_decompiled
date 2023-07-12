package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.FetchBindPageUrlResult;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.ali.user.open.ucc.webview.UccWebViewActivity;
import com.ali.user.open.ucc.webview.WebViewDialogActivity;
import com.ali.user.open.ucc.webview.WebViewTransparentActivity;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccH5Presenter {
    /* JADX INFO: Access modifiers changed from: private */
    public static void dismissProgressContext(Context context) {
        if (context instanceof Activity) {
            UccBindPresenter.dismissProgress((Activity) context);
        }
    }

    public static void leadNewUserH5Page(final Context context, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        final String str;
        final String str2;
        if (map != null) {
            String str3 = TextUtils.isEmpty(map.get("needSession")) ? "0" : map.get("needSession");
            String str4 = TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST)) ? "0" : map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            uccParams.targetPackageName = map.get(ParamsConstants.Key.PARAM_TARGET_PACKAGE_NAME);
            str2 = str4;
            str = str3;
        } else {
            str = "0";
            str2 = str;
        }
        if (map != null && !TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = map.get("site");
        } else {
            uccParams.site = AliMemberSDK.getMasterSite();
        }
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
        if (context instanceof Activity) {
            UccBindPresenter.showProgress((Activity) context);
        }
        DataRepository.fetchNewUser(uccParams, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccH5Presenter.1
            private void rpcResultHit(String str5, String str6) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str5);
                hashMap.put("h5Type", str6);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str5, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                FetchBindPageUrlResult fetchBindPageUrlResult = (FetchBindPageUrlResult) rpcResponse.returnValue;
                if (fetchBindPageUrlResult != null && !TextUtils.isEmpty(fetchBindPageUrlResult.returnUrl)) {
                    rpcResultHit(rpcResponse.code + "", fetchBindPageUrlResult.h5Type);
                    HashMap hashMap = new HashMap();
                    hashMap.put("h5Type", fetchBindPageUrlResult.h5Type);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", fetchBindPageUrlResult.returnUrl);
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    bundle.putString("needSession", str);
                    bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str2);
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map.get(ParamsConstants.Key.PARAM_HALF_H5));
                    if (!"default".equals(fetchBindPageUrlResult.urlType)) {
                        bundle.putString(ParamsConstants.Key.PRAMA_TRANSPARENT_H5, (String) map.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5));
                    }
                    Map map2 = map;
                    if (map2 != null && TextUtils.equals((CharSequence) map2.get("callbackType"), "pageClose")) {
                        UccH5Presenter.openUrl(context, bundle, uccCallback);
                        return;
                    }
                    UccH5Presenter.openUrl(context, bundle, null);
                    uccCallback.onSuccess(uccParams.bindSite, new HashMap());
                    return;
                }
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str5, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }

    public static void leadNoLoginNewUserH5Page(final Context context, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        final String str;
        final String str2;
        if (map != null) {
            String str3 = TextUtils.isEmpty(map.get("needSession")) ? "0" : map.get("needSession");
            str2 = TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST)) ? "0" : map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            str = str3;
        } else {
            str = "0";
            str2 = str;
        }
        if (map != null && !TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = map.get("site");
        } else {
            uccParams.site = AliMemberSDK.getMasterSite();
        }
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        if (map != null && !TextUtils.isEmpty(map.get("mobile"))) {
            uccParams.maskMobile = map.get("mobile");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
        if (context instanceof Activity) {
            UccBindPresenter.showProgress((Activity) context);
        }
        DataRepository.fetchNoLoginNewUserUrl(uccParams, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccH5Presenter.2
            private void rpcResultHit(String str4, String str5) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str4);
                hashMap.put("h5Type", str5);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str4, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                FetchBindPageUrlResult fetchBindPageUrlResult = (FetchBindPageUrlResult) rpcResponse.returnValue;
                if (fetchBindPageUrlResult != null && !TextUtils.isEmpty(fetchBindPageUrlResult.returnUrl)) {
                    rpcResultHit(rpcResponse.code + "", fetchBindPageUrlResult.h5Type);
                    HashMap hashMap = new HashMap();
                    hashMap.put("h5Type", fetchBindPageUrlResult.h5Type);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", fetchBindPageUrlResult.returnUrl);
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    bundle.putString("needSession", str);
                    bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str2);
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map.get(ParamsConstants.Key.PARAM_HALF_H5));
                    if (!"default".equals(fetchBindPageUrlResult.urlType)) {
                        bundle.putString(ParamsConstants.Key.PRAMA_TRANSPARENT_H5, (String) map.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5));
                    }
                    bundle.putString("webviewOption", WebViewOption.UC.name());
                    UccH5Presenter.openUrl(context, bundle, null);
                    uccCallback.onSuccess(uccParams.bindSite, new HashMap());
                    return;
                }
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str4, RpcResponse rpcResponse) {
                UccH5Presenter.dismissProgressContext(context);
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }

    public static void openUrl(Context context, Bundle bundle, UccCallback uccCallback) {
        Intent intent;
        String str;
        String str2;
        if (context == null) {
            context = KernelContext.getApplicationContext();
        }
        if (uccCallback != null) {
            CallbackManager.registerCallback(UccConstants.UCC_H5_CALLBACK_TYPE, uccCallback);
        }
        if (bundle != null && "1".equals(bundle.get(ParamsConstants.Key.PARAM_HALF_H5))) {
            intent = new Intent(context, WebViewDialogActivity.class);
            if (bundle.getString("url") != null) {
                boolean darkModeStatus = CommonUtils.getDarkModeStatus(context);
                String string = bundle.getString("url");
                if (darkModeStatus && !string.contains("theme=dark")) {
                    if (string.indexOf("?") > -1) {
                        str2 = string + "&theme=dark";
                    } else {
                        str2 = string + "?theme=dark";
                    }
                    bundle.putString("url", str2);
                }
            }
        } else if (bundle != null && "1".equals(bundle.get(ParamsConstants.Key.PRAMA_TRANSPARENT_H5))) {
            intent = new Intent(context, WebViewTransparentActivity.class);
            if (bundle.getString("url") != null) {
                boolean darkModeStatus2 = CommonUtils.getDarkModeStatus(context);
                String string2 = bundle.getString("url");
                if (darkModeStatus2 && !string2.contains("theme=dark")) {
                    if (string2.indexOf("?") > -1) {
                        str = string2 + "&theme=dark";
                    } else {
                        str = string2 + "?theme=dark";
                    }
                    bundle.putString("url", str);
                }
            }
        } else {
            intent = new Intent(context, UccWebViewActivity.class);
        }
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        try {
            if (context instanceof WebViewDialogActivity) {
                ((WebViewDialogActivity) context).finish();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void showH5BindPage(final Activity activity, final UccParams uccParams, final Map<String, String> map, final boolean z, final UccCallback uccCallback) {
        final String str;
        final String str2;
        if (map != null) {
            String str3 = TextUtils.isEmpty(map.get("needSession")) ? "0" : map.get("needSession");
            str2 = TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST)) ? "0" : map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            str = str3;
        } else {
            str = "0";
            str2 = str;
        }
        if (map != null && !TextUtils.isEmpty(map.get(UccConstants.PARAM_BIND_URL))) {
            HashMap hashMap = new HashMap();
            hashMap.put("h5Type", map.get("h5Type"));
            UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap);
            Bundle bundle = new Bundle();
            bundle.putString("url", map.get(UccConstants.PARAM_BIND_URL));
            bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
            bundle.putString("needSession", str);
            bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str2);
            bundle.putString("params", Utils.convertMapToJsonStr(map));
            bundle.putString(ParamsConstants.Key.PARAM_HALF_H5, map.get(ParamsConstants.Key.PARAM_HALF_H5));
            bundle.putString("requestToken", map.get("requestToken"));
            openUrl(activity, bundle, uccCallback);
            return;
        }
        if (map != null && !TextUtils.isEmpty(map.get("site"))) {
            uccParams.site = map.get("site");
        } else {
            uccParams.site = AliMemberSDK.getMasterSite();
        }
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        uccParams.createBindSiteSession = TextUtils.equals("1", str);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrl", uccParams, null);
        DataRepository.fetchBindPageUrl(uccParams, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccH5Presenter.3
            private void rpcResultHit(String str4, String str5) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("code", str4);
                hashMap2.put("h5Type", str5);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GetLocalSiteUrlResult", uccParams, hashMap2);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str4, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                FetchBindPageUrlResult fetchBindPageUrlResult = (FetchBindPageUrlResult) rpcResponse.returnValue;
                if (fetchBindPageUrlResult != null && fetchBindPageUrlResult.nativeFirst && !z) {
                    AppCredential oauthConfigByPlatform = OauthPlatformConfig.getOauthConfigByPlatform(uccParams.bindSite);
                    Map map2 = map;
                    if (map2 != null) {
                        map2.remove(ParamsConstants.Key.PARAM_ENABLE_RECOMMEND_BIND);
                    }
                    if (((OauthService) AliMemberSDK.getService(OauthService.class)).isAppAuthSurpport(activity, uccParams.bindSite)) {
                        map.put(ParamsConstants.Key.PARAM_FORCE_NATIVE, "1");
                    }
                    UccServiceProviderFactory.getInstance().getUccServiceProvider(uccParams.bindSite).bind(activity, uccParams, oauthConfigByPlatform, map, uccCallback);
                } else if (fetchBindPageUrlResult != null && !TextUtils.isEmpty(fetchBindPageUrlResult.returnUrl)) {
                    rpcResultHit(rpcResponse.code + "", fetchBindPageUrlResult.h5Type);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("h5Type", fetchBindPageUrlResult.h5Type);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_GoH5BindAction", uccParams, hashMap2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("url", fetchBindPageUrlResult.returnUrl);
                    bundle2.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                    bundle2.putString("needSession", str);
                    bundle2.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str2);
                    bundle2.putString("params", Utils.convertMapToJsonStr(map));
                    Map map3 = map;
                    if (map3 != null) {
                        bundle2.putString(ParamsConstants.Key.PARAM_HALF_H5, (String) map3.get(ParamsConstants.Key.PARAM_HALF_H5));
                    }
                    UccH5Presenter.openUrl(activity, bundle2, uccCallback);
                } else {
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        uccCallback2.onFail(uccParams.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str4, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }

    public static void showH5BindPageFoeNewBind(final Context context, final UccParams uccParams, String str, final Map<String, String> map, final UccCallback uccCallback) {
        final String str2;
        final String str3;
        if (map != null) {
            String str4 = TextUtils.isEmpty(map.get("needSession")) ? "0" : map.get("needSession");
            str3 = TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_NEED_TOAST)) ? "0" : map.get(ParamsConstants.Key.PARAM_NEED_TOAST);
            str2 = str4;
        } else {
            str2 = "0";
            str3 = str2;
        }
        UccParams uccParams2 = new UccParams();
        if (map != null && !TextUtils.isEmpty(map.get("site"))) {
            uccParams2.site = map.get("site");
        } else {
            uccParams2.site = AliMemberSDK.getMasterSite();
        }
        uccParams2.bindSite = uccParams.bindSite;
        uccParams2.userToken = uccParams.userToken;
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams2.scene = map.get("scene");
        }
        uccParams2.createBindSiteSession = TextUtils.equals("1", str2);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GetLocalSiteUrl", uccParams, null);
        DataRepository.fetchNewBindPageUrl(uccParams2, str, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccH5Presenter.4
            private void rpcResultHit(String str5, String str6) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str5);
                hashMap.put("h5Type", str6);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GetLocalSiteUrlResult", UccParams.this, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str5, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(UccParams.this.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "fetchBindPageUrl fail"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                FetchBindPageUrlResult fetchBindPageUrlResult = (FetchBindPageUrlResult) rpcResponse.returnValue;
                if (fetchBindPageUrlResult != null && !TextUtils.isEmpty(fetchBindPageUrlResult.returnUrl)) {
                    rpcResultHit(rpcResponse.code + "", fetchBindPageUrlResult.h5Type);
                    HashMap hashMap = new HashMap();
                    hashMap.put("h5Type", fetchBindPageUrlResult.h5Type);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_GoH5BindAction", UccParams.this, hashMap);
                    Bundle bundle = new Bundle();
                    bundle.putString("url", fetchBindPageUrlResult.returnUrl);
                    bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(UccParams.this));
                    bundle.putString("needSession", str2);
                    bundle.putString(ParamsConstants.Key.PARAM_NEED_TOAST, str3);
                    bundle.putString("params", Utils.convertMapToJsonStr(map));
                    UccH5Presenter.openUrl(context, bundle, uccCallback);
                    return;
                }
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(UccParams.this.bindSite, 1401, Utils.buidErrorMessage(rpcResponse, "url 为空"));
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str5, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1402);
                rpcResultHit(buidErrorCode + "", "");
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(UccParams.this.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "获取页面失败"));
                }
            }
        });
    }
}
