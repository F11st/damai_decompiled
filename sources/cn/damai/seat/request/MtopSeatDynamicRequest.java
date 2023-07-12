package cn.damai.seat.request;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.seat.bean.biz.SeatDynamic;
import cn.damai.seat.listener.net.MtopSeatDynamicListener;
import cn.damai.tool2.bufferkit.BufferListener;
import cn.damai.tool2.bufferkit.BufferRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.jm1;
import tb.td;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MtopSeatDynamicRequest extends DMBaseMtopRequest implements BufferRequest<SeatDynamic> {
    private static transient /* synthetic */ IpChange $ipChange;
    public String dmChannel = "*@damai_android_*";
    public boolean hasPromotion;
    public String itemId;
    private MtopBusiness mBusiness;
    public String performanceId;
    public String postChooseSeatFilterPriceIds;
    public String privilegeActId;
    public String privilegeFilterSkuIds;
    public String projectId;

    public MtopSeatDynamicRequest(long j, long j2, long j3, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.projectId = j + "";
        this.itemId = j2 + "";
        this.performanceId = j3 + "";
        this.postChooseSeatFilterPriceIds = str;
        this.privilegeActId = str2;
        this.privilegeFilterSkuIds = str3;
        this.hasPromotion = z;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1531664231")) {
            ipChange.ipc$dispatch("1531664231", new Object[]{this});
            return;
        }
        MtopBusiness mtopBusiness = this.mBusiness;
        if (mtopBusiness == null || mtopBusiness.isTaskCanceled()) {
            return;
        }
        this.mBusiness.cancelRequest();
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public void doRequest(final BufferListener<SeatDynamic> bufferListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850739455")) {
            ipChange.ipc$dispatch("850739455", new Object[]{this, bufferListener});
        } else {
            this.mBusiness = request(new MtopSeatDynamicListener(jm1.k(this.itemId, -1L), jm1.k(this.performanceId, -1L)) { // from class: cn.damai.seat.request.MtopSeatDynamicRequest.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.seat.listener.net.OnNetBizListener
                public void onNetFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "672104756")) {
                        ipChange2.ipc$dispatch("672104756", new Object[]{this, str, str2});
                    } else {
                        bufferListener.onFail(str, str2);
                    }
                }

                @Override // cn.damai.seat.listener.net.OnNetBizListener
                public void onNetSuccess(@NonNull SeatDynamic seatDynamic) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-192273462")) {
                        ipChange2.ipc$dispatch("-192273462", new Object[]{this, seatDynamic});
                    } else {
                        bufferListener.onSuccess(seatDynamic);
                    }
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "552168110") ? (String) ipChange.ipc$dispatch("552168110", new Object[]{this}) : "mtop.damai.wireless.seat.dynamicInfo";
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getGroupType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2124562370") ? (String) ipChange.ipc$dispatch("2124562370", new Object[]{this}) : td.BUFFER_GROUP_1;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012413633")) {
            return ((Boolean) ipChange.ipc$dispatch("-1012413633", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1052000261")) {
            return ((Boolean) ipChange.ipc$dispatch("-1052000261", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tool2.bufferkit.BufferRequest
    public String getUniKey() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97681980")) {
            return (String) ipChange.ipc$dispatch("97681980", new Object[]{this});
        }
        return getApiName() + getVersion() + this.projectId + this.itemId + this.performanceId + this.postChooseSeatFilterPriceIds + this.privilegeActId + this.privilegeFilterSkuIds + this.hasPromotion;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1575062463") ? (String) ipChange.ipc$dispatch("-1575062463", new Object[]{this}) : "1.0";
    }
}
