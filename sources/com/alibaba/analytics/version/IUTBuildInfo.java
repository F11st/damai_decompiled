package com.alibaba.analytics.version;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface IUTBuildInfo {
    String getBuildID();

    String getFullSDKVersion();

    String getGitCommitID();

    String getShortSDKVersion();

    boolean isTestMode();
}
