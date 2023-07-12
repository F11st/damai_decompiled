package cn.damai.seat.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.listener.net.MtopStatusCompressListener;
import cn.damai.tool2.bufferkit.BufferListener;
import cn.damai.tool2.bufferkit.BufferRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.jm1;
import tb.td;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MtopStatusCompressRequest extends DMBaseMtopRequest implements BufferRequest<CompressSeatStatus> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String areaInfoVersion;
    public String dmChannel = "*@damai_android_*";
    private long itemId;
    private MtopBusiness mRequest;
    public String performanceId;
    public String projectId;
    @Nullable
    public String serialNumber;
    @Nullable
    public String standIds;

    public MtopStatusCompressRequest(long j, long j2, long j3, int i, @Nullable String str, @Nullable String str2) {
        this.projectId = j2 + "";
        this.performanceId = j3 + "";
        this.areaInfoVersion = i + "";
        this.standIds = str;
        this.serialNumber = str2;
        this.itemId = j;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494950151")) {
            ipChange.ipc$dispatch("1494950151", new Object[]{this});
            return;
        }
        MtopBusiness mtopBusiness = this.mRequest;
        if (mtopBusiness == null || mtopBusiness.isTaskCanceled()) {
            return;
        }
        this.mRequest.cancelRequest();
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void doRequest(final BufferListener<CompressSeatStatus> bufferListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751494497")) {
            ipChange.ipc$dispatch("-751494497", new Object[]{this, bufferListener});
        } else {
            this.mRequest = request(new MtopStatusCompressListener(this.itemId, jm1.k(this.performanceId, -1L)) { // from class: cn.damai.seat.request.MtopStatusCompressRequest.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.seat.listener.net.OnNetBizListener
                public void onNetFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-719909996")) {
                        ipChange2.ipc$dispatch("-719909996", new Object[]{this, str, str2});
                    } else {
                        bufferListener.onFail(str, str2);
                    }
                }

                @Override // cn.damai.seat.listener.net.OnNetBizListener
                public void onNetSuccess(@NonNull CompressSeatStatus compressSeatStatus) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2077450739")) {
                        ipChange2.ipc$dispatch("2077450739", new Object[]{this, compressSeatStatus});
                    } else {
                        bufferListener.onSuccess(compressSeatStatus);
                    }
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1033233678") ? (String) ipChange.ipc$dispatch("1033233678", new Object[]{this}) : "mtop.damai.wireless.seat.queryperformseatstatus";
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getGroupType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "572105250") ? (String) ipChange.ipc$dispatch("572105250", new Object[]{this}) : td.BUFFER_GROUP_1;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096688417")) {
            return ((Boolean) ipChange.ipc$dispatch("-1096688417", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-435689061")) {
            return ((Boolean) ipChange.ipc$dispatch("-435689061", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getUniKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25347108")) {
            return (String) ipChange.ipc$dispatch("-25347108", new Object[]{this});
        }
        return getApiName() + getVersion() + this.projectId + this.performanceId + this.areaInfoVersion + this.standIds + this.serialNumber;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1093996895") ? (String) ipChange.ipc$dispatch("-1093996895", new Object[]{this}) : "1.0";
    }
}
