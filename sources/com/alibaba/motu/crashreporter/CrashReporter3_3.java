package com.alibaba.motu.crashreporter;

import android.content.Context;
import com.alibaba.motu.crashreporter.Propertys;
import com.alibaba.motu.crashreporter2.CatcherManager;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.ut.mini.crashhandler.UTCrashHandlerWapper;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
class CrashReporter3_3 implements CrashReportProxy {
    private final CrashReporter mCrashReporter = CrashReporter.getInstance();

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void addNativeHeaderInfo(String str, String str2) {
        this.mCrashReporter.addNativeHeaderInfo(str, str2);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void addSendLinster(ICrashReportSendListener iCrashReportSendListener) {
        this.mCrashReporter.addSendLinster(iCrashReportSendListener);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void closeNativeSignalTerm() {
        this.mCrashReporter.closeNativeSignalTerm();
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void disable() {
        this.mCrashReporter.disable();
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void enable() {
        this.mCrashReporter.enable();
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public List getAllUncaughtExceptionLinster() {
        return this.mCrashReporter.getAllUncaughtExceptionLinster();
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public String getProperty(String str) {
        return this.mCrashReporter.getProperty(str);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public String getPropertyAndSet(String str) {
        return this.mCrashReporter.getPropertyAndSet(str);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void initialize(Context context, String str, String str2, String str3, String str4, Configuration configuration) {
        this.mCrashReporter.initialize(context, str, str2, str3, str4, configuration);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public String mProcessName() {
        return this.mCrashReporter.mProcessName;
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void refreshAppVersion(String str) {
        this.mCrashReporter.refreshAppVersion(str);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void registerLifeCallbacks(Context context) {
        this.mCrashReporter.registerLifeCallbacks(context);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void removeSendLinster(ICrashReportSendListener iCrashReportSendListener) {
        this.mCrashReporter.removeSendLinster(iCrashReportSendListener);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void setCrashCaughtListener(final IUTCrashCaughtListener iUTCrashCaughtListener) {
        this.mCrashReporter.addUncaughtExceptionLinster(new CatcherManager.UncaughtExceptionLinster() { // from class: com.alibaba.motu.crashreporter.CrashReporter3_3.1
            @Override // com.alibaba.motu.crashreporter2.CatcherManager.UncaughtExceptionLinster
            public Map<String, Object> onUncaughtException(Thread thread, Throwable th) {
                return iUTCrashCaughtListener.onCrashCaught(thread, th);
            }

            @Override // com.alibaba.motu.crashreporter2.CatcherManager.UncaughtExceptionLinster
            public boolean originalEquals(Object obj) {
                IUTCrashCaughtListener iUTCrashCaughtListener2 = iUTCrashCaughtListener;
                if (iUTCrashCaughtListener2 == null || obj == null) {
                    return false;
                }
                return iUTCrashCaughtListener2.equals(obj);
            }
        });
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void setProperty(Propertys.Property property) {
        this.mCrashReporter.setProperty(property);
    }

    @Override // com.alibaba.motu.crashreporter.CrashReportProxy
    public void setCrashCaughtListener(final UTCrashHandlerWapper uTCrashHandlerWapper) {
        this.mCrashReporter.addUncaughtExceptionLinster(new CatcherManager.UncaughtExceptionLinster() { // from class: com.alibaba.motu.crashreporter.CrashReporter3_3.2
            @Override // com.alibaba.motu.crashreporter2.CatcherManager.UncaughtExceptionLinster
            public Map<String, Object> onUncaughtException(Thread thread, Throwable th) {
                return uTCrashHandlerWapper.onCrashCaught(thread, th);
            }

            @Override // com.alibaba.motu.crashreporter2.CatcherManager.UncaughtExceptionLinster
            public boolean originalEquals(Object obj) {
                UTCrashHandlerWapper uTCrashHandlerWapper2 = uTCrashHandlerWapper;
                if (uTCrashHandlerWapper2 == null || obj == null) {
                    return false;
                }
                return uTCrashHandlerWapper2.equals(obj);
            }
        });
    }
}
