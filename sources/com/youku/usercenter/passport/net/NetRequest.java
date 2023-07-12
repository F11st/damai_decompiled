package com.youku.usercenter.passport.net;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.statistics.Statistics;
import com.youku.usercenter.passport.task.HYTask;
import com.youku.usercenter.passport.util.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class NetRequest {
    private static final String MTOP_API_DEFAULT_VERSION = "1.0";
    public static final String TAG = "Passport.NetRequest";
    private Context mContext;
    private Map<String, String> mCookies;
    private boolean mNeedSession;
    private String mPostData;
    private IRequestCallback mRequestCallback;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface IRequestCallback {
        void onFailure(int i);

        void onSuccess(Map<String, List<String>> map, byte[] bArr);
    }

    public NetRequest(Context context) {
        this.mContext = context;
    }

    private void startMtopRequest(String str, String str2) {
        Mtop mtop;
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(str);
        if (!TextUtils.isEmpty(str2)) {
            mtopRequest.setVersion(str2);
        } else {
            mtopRequest.setVersion("1.0");
        }
        if (!TextUtils.isEmpty(this.mPostData)) {
            mtopRequest.setData(this.mPostData);
        }
        mtopRequest.setNeedEcode(this.mNeedSession);
        mtopRequest.setNeedSession(this.mNeedSession);
        PassportConfig config = PassportManager.getInstance().getConfig();
        if (config != null && (mtop = config.mSessionMtop) != null) {
            MtopBusiness build = MtopBusiness.build(mtop, mtopRequest);
            build.reqMethod(MethodEnum.POST);
            build.setCacheControlNoCache();
            build.setCustomDomain(PassportManager.getInstance().getConfig().mDomain.getMtopHost());
            build.retryTime(2);
            build.registerListener((IRemoteListener) new IRemoteBaseListener() { // from class: com.youku.usercenter.passport.net.NetRequest.1
                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onError(int i, MtopResponse mtopResponse, Object obj) {
                    Logger.d("mtop request onError! requestType = " + i);
                    AdapterForTLog.loge("YKLogin.NetRequest", "mtop request onError! code = " + mtopResponse.getRetCode());
                    final int i2 = mtopResponse.isApiLockedResult() ? -103 : -102;
                    if (NetRequest.this.mRequestCallback != null) {
                        new HYTask(null) { // from class: com.youku.usercenter.passport.net.NetRequest.1.3
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public String doInBackground(String... strArr) {
                                NetRequest.this.mRequestCallback.onFailure(i2);
                                return null;
                            }
                        }.start(new String[0]);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("spm", "a2h21.9423174.10.1");
                    hashMap.put("code", mtopResponse.getRetCode());
                    hashMap.put("api", mtopResponse.getApi());
                    Statistics.CustomEvent("page_mtopabnormal", "Ykmtopfail", hashMap);
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteListener
                public void onSuccess(int i, final MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
                    if (NetRequest.this.mRequestCallback != null) {
                        new HYTask(null) { // from class: com.youku.usercenter.passport.net.NetRequest.1.2
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public String doInBackground(String... strArr) {
                                NetRequest.this.mRequestCallback.onSuccess(mtopResponse.getHeaderFields(), mtopResponse.getBytedata());
                                return null;
                            }
                        }.start(new String[0]);
                    }
                }

                @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
                public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                    Logger.d("mtop request onSystemError! requestType = " + i);
                    AdapterForTLog.loge("YKLogin.NetRequest", "mtop request onSystemError! code = " + mtopResponse.getRetCode());
                    final int i2 = mtopResponse.isApiLockedResult() ? -103 : -102;
                    if (NetRequest.this.mRequestCallback != null) {
                        new HYTask(null) { // from class: com.youku.usercenter.passport.net.NetRequest.1.1
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public String doInBackground(String... strArr) {
                                NetRequest.this.mRequestCallback.onFailure(i2);
                                return null;
                            }
                        }.start(new String[0]);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("spm", "a2h21.9423174.10.1");
                    hashMap.put("code", mtopResponse.getRetCode());
                    hashMap.put("api", mtopResponse.getApi());
                    Statistics.CustomEvent("page_mtopabnormal", "Ykmtopfail", hashMap);
                }
            }).startRequest();
            return;
        }
        Logger.e(TAG, "did not set mtop in PassportConfig");
    }

    public void addCookie(String str, String str2) {
        if (this.mCookies == null) {
            this.mCookies = new HashMap();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mCookies.put(str, str2);
    }

    public void setListener(IRequestCallback iRequestCallback) {
        this.mRequestCallback = iRequestCallback;
    }

    public void setPostData(String str) {
        this.mPostData = str;
    }

    public void startRequest(String str, IRequestCallback iRequestCallback) {
        this.mRequestCallback = iRequestCallback;
        startMtopRequest(str, null);
    }
}
