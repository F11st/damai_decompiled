package com.youku.live.dago.widgetlib.ailproom.adapter.mclient;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPMClientConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    public String appKey;
    public String appVersion;
    public String deviceId;
    public String host;
    public String userId;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class Builder {
        private String appKey;
        private String appVersion;
        private String deviceId;
        private String host;
        private String userId;

        public Builder appHost(String str) {
            this.host = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public AILPMClientConfig build() {
            return new AILPMClientConfig(this);
        }

        public Builder deviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public Builder userId(String str) {
            this.userId = str;
            return this;
        }
    }

    public String getAppKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "30508951") ? (String) ipChange.ipc$dispatch("30508951", new Object[]{this}) : this.appKey;
    }

    public String getAppVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-424423152") ? (String) ipChange.ipc$dispatch("-424423152", new Object[]{this}) : this.appVersion;
    }

    public String getDeviceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-205348310") ? (String) ipChange.ipc$dispatch("-205348310", new Object[]{this}) : this.deviceId;
    }

    public String getHost() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2066443455") ? (String) ipChange.ipc$dispatch("-2066443455", new Object[]{this}) : this.host;
    }

    public String getUserId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1840092511") ? (String) ipChange.ipc$dispatch("1840092511", new Object[]{this}) : this.userId;
    }

    public void setAppKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449314521")) {
            ipChange.ipc$dispatch("-449314521", new Object[]{this, str});
        } else {
            this.appKey = str;
        }
    }

    public void setAppVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912868046")) {
            ipChange.ipc$dispatch("1912868046", new Object[]{this, str});
        } else {
            this.appVersion = str;
        }
    }

    public void setDeviceId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1953158156")) {
            ipChange.ipc$dispatch("-1953158156", new Object[]{this, str});
        } else {
            this.deviceId = str;
        }
    }

    public void setHost(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72005565")) {
            ipChange.ipc$dispatch("72005565", new Object[]{this, str});
        } else {
            this.host = str;
        }
    }

    public void setUserId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186799009")) {
            ipChange.ipc$dispatch("-186799009", new Object[]{this, str});
        } else {
            this.userId = str;
        }
    }

    private AILPMClientConfig(Builder builder) {
        this.appKey = builder.appKey;
        this.userId = builder.userId;
        this.deviceId = builder.deviceId;
        this.appVersion = builder.appVersion;
        this.host = builder.host;
    }
}
