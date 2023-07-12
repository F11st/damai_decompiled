package com.alibaba.motu.crashreporter;

import android.content.Context;
import com.alibaba.motu.crashreporter.Options;
import com.alibaba.motu.crashreporter.Propertys;
import com.alibaba.motu.crashreporter.async.AsyncThreadPool;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.ut.mini.crashhandler.UTCrashHandlerWapper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MotuCrashReporter {
    static final MotuCrashReporter INSTANCE = new MotuCrashReporter();
    static List listenerList = new ArrayList();
    static List dataListenerList = new ArrayList();
    static List senderListenerList = new ArrayList();
    CrashReportProxy mCrashReporter = new CrashReporter3_3();
    AtomicBoolean enabling = new AtomicBoolean(false);
    public AsyncThreadPool asyncTaskThread = new AsyncThreadPool();

    private MotuCrashReporter() {
    }

    public static MotuCrashReporter getInstance() {
        return INSTANCE;
    }

    public void addCrashReportSendListener(ICrashReportSendListener iCrashReportSendListener) {
        this.mCrashReporter.addSendLinster(iCrashReportSendListener);
    }

    public void addNativeHeaderInfo(String str, String str2) {
        this.mCrashReporter.addNativeHeaderInfo(str, str2);
    }

    public void changeHost(String str) {
        Configuration.getInstance().add(new Options.Option(Configuration.adashxServerHost, str));
        SendService.getInstance().changeHost(str);
    }

    public void closeNativeSignalTerm() {
        this.mCrashReporter.closeNativeSignalTerm();
    }

    @Deprecated
    public boolean enable(Context context, String str, String str2, String str3, String str4, ReporterConfigure reporterConfigure) {
        String str5;
        String str6;
        if (StringUtils.isBlank(str) || "12278902".equals(str) || "21646297".equals(str)) {
            str5 = "12278902@android";
            str6 = "21646297";
        } else {
            str6 = str;
            str5 = "";
        }
        return enable(context, str5, str6, str2, str3, str4, null);
    }

    public int getCrashReporterState() {
        return 0;
    }

    public List getMyDataListenerList() {
        return dataListenerList;
    }

    public List getMyListenerList() {
        return this.mCrashReporter.getAllUncaughtExceptionLinster();
    }

    public List getMySenderListenerList() {
        return senderListenerList;
    }

    public String getStrExtraInfo() {
        return "";
    }

    public boolean isTaobaoApplication(Context context) {
        return StringUtils.isNotBlank(this.mCrashReporter.mProcessName()) && this.mCrashReporter.mProcessName().startsWith("com.taobao.taobao");
    }

    public void registerLifeCallbacks(Context context) {
        this.mCrashReporter.registerLifeCallbacks(context);
    }

    public void removeCrashReportSendListener(ICrashReportSendListener iCrashReportSendListener) {
        this.mCrashReporter.removeSendLinster(iCrashReportSendListener);
    }

    public void setAppVersion(String str) {
        this.mCrashReporter.refreshAppVersion(str);
        SendService.getInstance().updateAppVersion(str);
    }

    public void setCrashCaughtListener(UTCrashHandlerWapper uTCrashHandlerWapper) {
        this.mCrashReporter.setCrashCaughtListener(uTCrashHandlerWapper);
    }

    public void setCrashReportDataListener(ICrashReportDataListener iCrashReportDataListener) {
    }

    public void setCrashReporterState(int i) {
    }

    public void setExtraInfo(String str) {
    }

    public void setTTid(String str) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        this.mCrashReporter.setProperty(new Propertys.Property(Constants.CHANNEL, str));
        SendService.getInstance().updateChannel(str);
    }

    public void setUserNick(String str) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        this.mCrashReporter.setProperty(new Propertys.Property(Constants.USERNICK, str));
        SendService.getInstance().updateUserNick(str);
    }

    public void setCrashCaughtListener(IUTCrashCaughtListener iUTCrashCaughtListener) {
        this.mCrashReporter.setCrashCaughtListener(iUTCrashCaughtListener);
    }

    public boolean enable(Context context, String str, String str2, String str3, String str4, String str5, ReporterConfigure reporterConfigure) {
        if (this.enabling.compareAndSet(false, true)) {
            try {
                LogUtil.d("CrashSDK RestApi initialize start ");
                SendService.getInstance().init(context, str, str2, str3, str4, str5);
                LogUtil.d("CrashSDK RestApi initialize success! ");
                Configuration configuration = Configuration.getInstance();
                if (reporterConfigure != null) {
                    configuration.add(new Options.Option(Configuration.enableUncaughtExceptionIgnore, Boolean.valueOf(reporterConfigure.enableUncaughtExceptionIgnore)));
                    configuration.add(new Options.Option(Configuration.enableExternalLinster, Boolean.valueOf(reporterConfigure.enableExternalLinster)));
                    configuration.add(new Options.Option(Configuration.enableFinalizeFake, Boolean.valueOf(reporterConfigure.enableFinalizeFake)));
                    configuration.add(new Options.Option(Configuration.enableUIProcessSafeGuard, Boolean.valueOf(reporterConfigure.enableUIProcessSafeGuard)));
                    configuration.add(new Options.Option(Configuration.enableSecuritySDK, Boolean.valueOf(reporterConfigure.enableSecuritySDK)));
                    configuration.add(new Options.Option(Configuration.enableANRCatch, Boolean.valueOf(reporterConfigure.enableCatchANRException)));
                    if (!RestConstants.G_DEFAULT_ADASHX_HOST.equals(reporterConfigure.adashxServerHost)) {
                        configuration.add(new Options.Option(Configuration.adashxServerHost, reporterConfigure.adashxServerHost));
                        SendService.getInstance().changeHost(reporterConfigure.adashxServerHost);
                    }
                }
                this.mCrashReporter.initialize(context, str, str2, str3, str4, configuration);
                this.mCrashReporter.enable();
                setUserNick(str5);
                return true;
            } catch (Exception e) {
                LogUtil.e("enable", e);
            }
        }
        return false;
    }
}
