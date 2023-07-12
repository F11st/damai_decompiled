package com.alibaba.motu.crashreporter;

import android.content.Context;
import com.alibaba.motu.crashreporter.Propertys;
import com.ut.mini.crashhandler.UTCrashHandlerWapper;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface CrashReportProxy {
    void addNativeHeaderInfo(String str, String str2);

    void addSendLinster(ICrashReportSendListener iCrashReportSendListener);

    void closeNativeSignalTerm();

    void disable();

    void enable();

    List getAllUncaughtExceptionLinster();

    String getProperty(String str);

    String getPropertyAndSet(String str);

    void initialize(Context context, String str, String str2, String str3, String str4, Configuration configuration);

    String mProcessName();

    void refreshAppVersion(String str);

    void registerLifeCallbacks(Context context);

    void removeSendLinster(ICrashReportSendListener iCrashReportSendListener);

    void setCrashCaughtListener(IUTCrashCaughtListener iUTCrashCaughtListener);

    void setCrashCaughtListener(UTCrashHandlerWapper uTCrashHandlerWapper);

    void setProperty(Propertys.Property property);
}
