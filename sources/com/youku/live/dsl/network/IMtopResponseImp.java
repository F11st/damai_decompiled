package com.youku.live.dsl.network;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IMtopResponseImp implements IMtopResponseAttacher, IResponse {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile MtopResponse mtopResponse;
    private volatile String source;

    public IMtopResponseImp(MtopResponse mtopResponse) {
        this.mtopResponse = mtopResponse;
    }

    @Override // com.youku.live.dsl.network.IMtopResponseAttacher
    public void attachResponse(MtopResponse mtopResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200968776")) {
            ipChange.ipc$dispatch("-200968776", new Object[]{this, mtopResponse});
        } else {
            this.mtopResponse = mtopResponse;
        }
    }

    @Override // com.youku.live.dsl.network.IResponse
    public byte[] getRawData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851880864")) {
            return (byte[]) ipChange.ipc$dispatch("1851880864", new Object[]{this});
        }
        if (this.mtopResponse != null) {
            return this.mtopResponse.getBytedata();
        }
        return null;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1758926945") ? (String) ipChange.ipc$dispatch("-1758926945", new Object[]{this}) : this.mtopResponse != null ? this.mtopResponse.getRetCode() : "";
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetMessage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "764623499") ? (String) ipChange.ipc$dispatch("764623499", new Object[]{this}) : this.mtopResponse != null ? this.mtopResponse.getRetMsg() : "";
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getSource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1341334784")) {
            return (String) ipChange.ipc$dispatch("-1341334784", new Object[]{this});
        }
        if (this.source == null) {
            try {
                this.source = new String(getRawData());
            } catch (Throwable unused) {
            }
        }
        if (this.source == null) {
            this.source = "";
        }
        return this.source;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isRequestSuccess() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396767263") ? ((Boolean) ipChange.ipc$dispatch("1396767263", new Object[]{this})).booleanValue() : (this.mtopResponse == null || this.mtopResponse.isMtopSdkError() || this.mtopResponse.isMtopServerError()) ? false : true;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716645725")) {
            return ((Boolean) ipChange.ipc$dispatch("716645725", new Object[]{this})).booleanValue();
        }
        if (this.mtopResponse != null) {
            return this.mtopResponse.isApiSuccess();
        }
        return false;
    }

    public IMtopResponseImp() {
    }
}
