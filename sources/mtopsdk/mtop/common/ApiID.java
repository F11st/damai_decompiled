package mtopsdk.mtop.common;

import android.os.Handler;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.network.Call;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApiID implements IMTOPDataObject {
    private static final String TAG = "mtopsdk.ApiID";
    private volatile Call call;
    private volatile boolean isCancelled = false;
    private MtopContext mtopContext;

    public ApiID(Call call, MtopContext mtopContext) {
        this.call = call;
        this.mtopContext = mtopContext;
    }

    public boolean cancelApiCall() {
        if (this.call != null) {
            this.call.cancel();
            this.isCancelled = true;
        }
        return true;
    }

    public Call getCall() {
        return this.call;
    }

    public MtopContext getMtopContext() {
        return this.mtopContext;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public ApiID retryApiCall(Handler handler) {
        MtopContext mtopContext = this.mtopContext;
        if (mtopContext == null) {
            return null;
        }
        mtopContext.property.handler = handler;
        FilterManager filterManager = mtopContext.mtopInstance.getMtopConfig().filterManager;
        if (filterManager != null) {
            filterManager.start(null, this.mtopContext);
        }
        FilterUtils.checkFilterManager(filterManager, this.mtopContext);
        return new ApiID(null, this.mtopContext);
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("ApiID [call=");
        sb.append(this.call);
        sb.append(", mtopContext=");
        sb.append(this.mtopContext);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    public ApiID retryApiCall() {
        return retryApiCall(null);
    }
}
