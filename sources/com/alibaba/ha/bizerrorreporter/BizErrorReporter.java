package com.alibaba.ha.bizerrorreporter;

import android.content.Context;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.ha.bizerrorreporter.send.BizErrorThreadPool;
import com.alibaba.ha.bizerrorreporter.send.Sender;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class BizErrorReporter {
    public String processName;
    public Long reporterStartTime;
    public BizErrorSampling sampling;
    private BizErrorThreadPool threadPool;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class InstanceCreater {
        private static BizErrorReporter instance = new BizErrorReporter();

        private InstanceCreater() {
        }
    }

    public static synchronized BizErrorReporter getInstance() {
        BizErrorReporter bizErrorReporter;
        synchronized (BizErrorReporter.class) {
            bizErrorReporter = InstanceCreater.instance;
        }
        return bizErrorReporter;
    }

    public String getProcessName(Context context) {
        String str = this.processName;
        if (str != null) {
            return str;
        }
        String myProcessNameByCmdline = AppUtils.getMyProcessNameByCmdline();
        if (StringUtils.isBlank(myProcessNameByCmdline)) {
            myProcessNameByCmdline = AppUtils.getMyProcessNameByAppProcessInfo(context);
        }
        this.processName = myProcessNameByCmdline;
        return myProcessNameByCmdline;
    }

    public void openSampling(BizErrorSampling bizErrorSampling) {
        this.sampling = bizErrorSampling;
    }

    public void send(Context context, BizErrorModule bizErrorModule) {
        try {
            if (SendService.getInstance().context != null && SendService.getInstance().appKey != null) {
                if (bizErrorModule != null) {
                    this.threadPool.submit(new Sender(context, bizErrorModule));
                    return;
                }
                return;
            }
            Log.e(BizErrorConstants.LOGTAG, "you need init rest send service");
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "adapter err", e);
        }
    }

    private BizErrorReporter() {
        this.threadPool = new BizErrorThreadPool();
        this.reporterStartTime = Long.valueOf(System.currentTimeMillis());
        this.processName = null;
        this.sampling = null;
    }
}
