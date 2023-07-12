package com.alibaba.ha.bizerrorreporter.send;

import android.content.Context;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.BizErrorBuilder;
import com.alibaba.ha.bizerrorreporter.BizErrorConstants;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.BizErrorSampling;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.ha.bizerrorreporter.module.SendModule;
import com.alibaba.motu.tbrest.SendService;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class Sender implements Runnable {
    BizErrorModule bizErrorModule;
    Context mContext;

    public Sender(Context context, BizErrorModule bizErrorModule) {
        this.mContext = context;
        this.bizErrorModule = bizErrorModule;
    }

    private Boolean canSend() {
        BizErrorSampling bizErrorSampling = BizErrorReporter.getInstance().sampling;
        int randomNumber = getRandomNumber(0, 10000);
        if (bizErrorSampling == BizErrorSampling.OneTenth) {
            if (randomNumber >= 0 && randomNumber < 1000) {
                return Boolean.TRUE;
            }
        } else if (bizErrorSampling == BizErrorSampling.OnePercent) {
            if (randomNumber >= 0 && randomNumber < 100) {
                return Boolean.TRUE;
            }
        } else if (bizErrorSampling == BizErrorSampling.OneThousandth) {
            if (randomNumber >= 0 && randomNumber < 10) {
                return Boolean.TRUE;
            }
        } else if (bizErrorSampling == BizErrorSampling.OneTenThousandth) {
            if (randomNumber >= 0 && randomNumber < 1) {
                return Boolean.TRUE;
            }
        } else if (bizErrorSampling == BizErrorSampling.Zero) {
            return Boolean.FALSE;
        } else {
            if (bizErrorSampling == BizErrorSampling.All) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private int getRandomNumber(int i, int i2) {
        try {
            return i + ((int) (Math.random() * ((i2 - i) + 1)));
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "get random number err", e);
            return 0;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        SendModule build;
        try {
            if (this.bizErrorModule.businessType == null) {
                Log.i(BizErrorConstants.LOGTAG, "business type cannot null");
            } else if ((BizErrorReporter.getInstance().sampling == null || canSend().booleanValue()) && (build = new BizErrorBuilder().build(this.mContext, this.bizErrorModule)) != null) {
                Integer num = build.eventId;
                if (SendService.getInstance().sendRequest(null, System.currentTimeMillis(), build.businessType, num.intValue(), build.sendFlag, build.sendContent, build.aggregationType, null).booleanValue()) {
                    Log.i(BizErrorConstants.LOGTAG, "send business err success");
                } else {
                    Log.i(BizErrorConstants.LOGTAG, "send business err failure");
                }
            }
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "send business err happen ", e);
        }
    }
}
