package com.taobao.tao.remotebusiness;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.tao.remotebusiness.handler.HandlerMgr;
import com.taobao.tao.remotebusiness.handler.HandlerParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RequestPool {
    private static final String DEFAULT_BIZINFO = "DEFAULT";
    public static final String TAG = "mtopsdk.RequestPool";
    private Map<String, List<MtopBusiness>> requestPool = new HashMap();
    private Lock lock = new ReentrantLock();

    private String getRequestPoolKey(@NonNull Mtop mtop, @Nullable String str) {
        if (StringUtils.isBlank(str)) {
            str = "DEFAULT";
        }
        return StringUtils.concatStr(mtop.getInstanceId(), str);
    }

    public void addToRequestPool(@NonNull Mtop mtop, @Nullable String str, MtopBusiness mtopBusiness) {
        this.lock.lock();
        try {
            String requestPoolKey = getRequestPoolKey(mtop, str);
            List<MtopBusiness> list = this.requestPool.get(requestPoolKey);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(mtopBusiness);
            this.requestPool.put(requestPoolKey, list);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(requestPoolKey);
                sb.append(" [addToRequestPool] add mtopBuilder to RequestPool.");
                TBSdkLog.e(TAG, mtopBusiness.getMtopContext() != null ? mtopBusiness.getMtopContext().seqNo : null, sb.toString());
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void failAllRequest(@NonNull Mtop mtop, @Nullable String str, String str2, String str3) {
        MtopResponse mtopResponse;
        this.lock.lock();
        try {
            String requestPoolKey = getRequestPoolKey(mtop, str);
            List<MtopBusiness> remove = this.requestPool.remove(requestPoolKey);
            if (remove != null && !remove.isEmpty()) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(requestPoolKey);
                    sb.append(" [failAllRequest]fail all request,current size=");
                    sb.append(remove.size());
                    TBSdkLog.e(TAG, sb.toString());
                }
                for (MtopBusiness mtopBusiness : remove) {
                    MtopRequest mtopRequest = mtopBusiness.request;
                    if (mtopRequest != null) {
                        mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopBusiness.request.getVersion(), str2, str3);
                    } else {
                        mtopResponse = new MtopResponse(str2, str3);
                    }
                    MtopContext mtopContext = mtopBusiness.getMtopContext();
                    if (mtopContext == null) {
                        mtopContext = mtopBusiness.createMtopContext(mtopBusiness.listener);
                    }
                    mtopContext.mtopResponse = mtopResponse;
                    try {
                        FilterUtils.errorCodeMappingAfterFilter.doAfter(mtopContext);
                    } catch (Exception e) {
                        TBSdkLog.e(TAG, "[failAllRequest] do ErrorCode Mapping error.apiKey=" + mtopResponse.getFullKey(), e);
                    }
                    HandlerParam handlerMsg = HandlerMgr.getHandlerMsg(null, null, mtopBusiness);
                    handlerMsg.mtopResponse = mtopResponse;
                    HandlerMgr.instance().obtainMessage(3, handlerMsg).sendToTarget();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void removeRequest(@NonNull Mtop mtop, @Nullable String str, MtopBusiness mtopBusiness) {
        this.lock.lock();
        try {
            String requestPoolKey = getRequestPoolKey(mtop, str);
            List<MtopBusiness> list = this.requestPool.get(requestPoolKey);
            if (list != null && !list.isEmpty()) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(requestPoolKey);
                sb.append(" [removeRequest] remove single request.");
                TBSdkLog.e(TAG, mtopBusiness.getMtopContext() != null ? mtopBusiness.getMtopContext().seqNo : null, sb.toString());
                list.remove(mtopBusiness);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void retryAllRequest(@NonNull Mtop mtop, @Nullable String str) {
        this.lock.lock();
        try {
            String requestPoolKey = getRequestPoolKey(mtop, str);
            List<MtopBusiness> remove = this.requestPool.remove(requestPoolKey);
            if (remove != null && !remove.isEmpty()) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    StringBuilder sb = new StringBuilder(64);
                    sb.append(requestPoolKey);
                    sb.append(" [retryAllRequest] retry all request,current size=");
                    sb.append(remove.size());
                    TBSdkLog.e(TAG, sb.toString());
                }
                for (MtopBusiness mtopBusiness : remove) {
                    if (!mtopBusiness.isTaskCanceled()) {
                        mtopBusiness.retryRequest();
                    }
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void retryRequest(@NonNull Mtop mtop, @Nullable String str, MtopBusiness mtopBusiness) {
        this.lock.lock();
        try {
            String requestPoolKey = getRequestPoolKey(mtop, str);
            List<MtopBusiness> list = this.requestPool.get(requestPoolKey);
            if (list != null && !list.isEmpty()) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(requestPoolKey);
                sb.append(" [retrySingleRequest] retry single request.");
                TBSdkLog.e(TAG, mtopBusiness.getMtopContext() != null ? mtopBusiness.getMtopContext().seqNo : null, sb.toString());
                if (!mtopBusiness.isTaskCanceled() && list.contains(mtopBusiness)) {
                    mtopBusiness.retryRequest();
                    list.remove(mtopBusiness);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }
}
