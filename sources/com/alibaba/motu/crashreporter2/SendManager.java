package com.alibaba.motu.crashreporter2;

import android.content.Context;
import com.alibaba.ha.bizerrorreporter.BizErrorConstants;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.CrashReport;
import com.alibaba.motu.crashreporter.ICrashReportSendListener;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter.async.AsyncThreadPool;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alibaba.motu.tbrest.rest.RestUrlWrapper;
import com.alibaba.motu.tbrest.utils.Base64;
import com.alibaba.motu.tbrest.utils.GzipUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class SendManager {
    Configuration mConfiguration;
    Context mContext;
    ReportBuilder mReportBuilder;
    ReportSender mReportSender;
    ReporterContext mReporterContext;
    Map<String, CrashReport> mWaitingSend = new ConcurrentHashMap();
    AtomicBoolean mSending = new AtomicBoolean(false);
    Map<String, ICrashReportSendListener> sendListenerMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    class DefaultSender implements ReportSender {
        Configuration mConfiguration;
        Context mContext;
        ReporterContext mReporterContext;

        public DefaultSender(Context context, ReporterContext reporterContext, Configuration configuration) {
            this.mContext = context;
            this.mReporterContext = reporterContext;
            this.mConfiguration = configuration;
            if (configuration.getBoolean(Configuration.enableSecuritySDK, true)) {
                RestUrlWrapper.enableSecuritySDK();
                RestUrlWrapper.setContext(this.mContext);
            }
        }

        @Override // com.alibaba.motu.crashreporter2.SendManager.ReportSender
        public boolean sendReport(CrashReport crashReport) {
            int i;
            String str;
            if (crashReport == null) {
                return true;
            }
            if ("java".equals(crashReport.mReportType)) {
                i = 1;
            } else if (!"native".equals(crashReport.mReportType) && !"anr".equals(crashReport.mReportType)) {
                LogUtil.i(String.format("unsupport report type:%s path:%s", crashReport.mReportType, crashReport.mReportPath));
                return true;
            } else {
                i = 61006;
            }
            crashReport.mPropertys.copyTo(new HashMap());
            String string = this.mConfiguration.getString(Configuration.adashxServerHost, RestConstants.G_DEFAULT_ADASHX_HOST);
            String reportContent = crashReport.getReportContent();
            if (Configuration.getInstance().getBoolean(Configuration.enableReportContentCompress, true)) {
                reportContent = Base64.encodeBase64String(GzipUtils.gzip(reportContent.getBytes()));
                str = BizErrorConstants.SEND_FLAG;
            } else {
                str = "MOTU_REPORTER_SDK_3.0.0_PRIVATE";
            }
            return SendService.getInstance().sendRequest(string, System.currentTimeMillis(), "-", i, str, reportContent, "-", null).booleanValue();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    interface ReportSender {
        boolean sendReport(CrashReport crashReport);
    }

    public SendManager(Context context, ReporterContext reporterContext, Configuration configuration, ReportBuilder reportBuilder) {
        this.mContext = context;
        this.mReporterContext = reporterContext;
        this.mConfiguration = configuration;
        this.mReportBuilder = reportBuilder;
        this.mReportSender = new DefaultSender(context, reporterContext, configuration);
    }

    public void addListener(ICrashReportSendListener iCrashReportSendListener) {
        if (iCrashReportSendListener == null || !StringUtils.isNotBlank(iCrashReportSendListener.getName())) {
            return;
        }
        this.sendListenerMap.put(iCrashReportSendListener.getName(), iCrashReportSendListener);
    }

    public void removeListener(ICrashReportSendListener iCrashReportSendListener) {
        if (iCrashReportSendListener == null || !StringUtils.isNotBlank(iCrashReportSendListener.getName())) {
            return;
        }
        this.sendListenerMap.remove(iCrashReportSendListener.getName());
    }

    public void sendAllReport() {
        sendReports(this.mReportBuilder.listProcessCrashReport());
    }

    public void sendReport(CrashReport crashReport) {
        sendReports(new CrashReport[]{crashReport});
    }

    public void sendReports(CrashReport[] crashReportArr) {
        if (crashReportArr == null) {
            return;
        }
        for (CrashReport crashReport : crashReportArr) {
            if (crashReport != null && StringUtils.isNotBlank(crashReport.mReportPath)) {
                this.mWaitingSend.put(crashReport.mReportPath, crashReport);
            }
        }
        if (this.mWaitingSend.isEmpty() || !this.mSending.compareAndSet(false, true)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.alibaba.motu.crashreporter2.SendManager.1
            @Override // java.lang.Runnable
            public void run() {
                CrashReport value;
                try {
                    Iterator<Map.Entry<String, CrashReport>> it = SendManager.this.mWaitingSend.entrySet().iterator();
                    if (it != null) {
                        while (it.hasNext()) {
                            Map.Entry<String, CrashReport> next = it.next();
                            if (next != null && (value = next.getValue()) != null) {
                                if (!StringUtils.isBlank(value.mReportPath) && !StringUtils.isBlank(value.mReportName) && !StringUtils.isBlank(value.mReportType)) {
                                    try {
                                        if (value.isComplete()) {
                                            value.extractPropertys();
                                            for (ICrashReportSendListener iCrashReportSendListener : SendManager.this.sendListenerMap.values()) {
                                                try {
                                                    iCrashReportSendListener.beforeSend(value);
                                                } catch (Exception e) {
                                                    LogUtil.e("beforeSend", e);
                                                }
                                            }
                                            boolean sendReport = SendManager.this.mReportSender.sendReport(value);
                                            for (ICrashReportSendListener iCrashReportSendListener2 : SendManager.this.sendListenerMap.values()) {
                                                try {
                                                    iCrashReportSendListener2.afterSend(sendReport, value);
                                                } catch (Exception e2) {
                                                    LogUtil.e("beforeSend", e2);
                                                }
                                            }
                                            if (sendReport) {
                                                LogUtil.e("sendSucc");
                                                TLogAdapter.log("sendSucc", value.mReportFile);
                                                value.deleteReportFile();
                                            }
                                        } else if (!value.mCurrentTrigger) {
                                            value.deleteReportFile();
                                        }
                                    } catch (Exception e3) {
                                        LogUtil.e("send and del crash report.", e3);
                                    }
                                } else {
                                    try {
                                        value.deleteReportFile();
                                    } catch (Exception e4) {
                                        LogUtil.e("remote invalid crash report.", e4);
                                    }
                                }
                            }
                            it.remove();
                        }
                    }
                } finally {
                    SendManager.this.mSending.set(false);
                }
            }
        };
        AsyncThreadPool asyncThreadPool = MotuCrashReporter.getInstance().asyncTaskThread;
        AsyncThreadPool.start(runnable);
    }
}
