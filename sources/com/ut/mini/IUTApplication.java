package com.ut.mini;

import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUTApplication {
    String getUTAppVersion();

    String getUTChannel();

    IUTCrashCaughtListner getUTCrashCraughtListener();

    IUTRequestAuthentication getUTRequestAuthInstance();

    boolean isAliyunOsSystem();

    boolean isUTCrashHandlerDisable();

    boolean isUTLogEnable();
}
