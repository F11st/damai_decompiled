package cn.damai.trade.newtradeorder.ui.orderlist.net;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.util.ReflectUtil;
import tb.e80;
import tb.mu0;
import tb.o6;
import tb.z20;
import tb.zo1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrderRefundRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public String sign;
    public String loginKey = z20.q();
    public String appClientKey = zo1.b("appClientKey");
    public String channelFrom = o6.a(mu0.a());
    public String systemVersion = e80.e();
    public String phoneModels = e80.b();
    public String appType = "1";
    public String clientGUID = e80.a(mu0.a()) + "1";
    public String timestamp = (System.currentTimeMillis() / 1000) + "";
    public String source = "10101";
    public String apiVersion = AppConfig.r() + "";
    public String osType = "2";

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2065720148") ? (String) ipChange.ipc$dispatch("-2065720148", new Object[]{this}) : "mtop.damai.wireless.order.zlorderrefundprogress";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "936195118") ? (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("936195118", new Object[]{this}) : DMBaseMtopRequest.HttpMethod.GET;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652581119")) {
            return ((Boolean) ipChange.ipc$dispatch("-1652581119", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072630979")) {
            return ((Boolean) ipChange.ipc$dispatch("-2072630979", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "102016575") ? (String) ipChange.ipc$dispatch("102016575", new Object[]{this}) : "1.0";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public void setRequestData(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "760744906")) {
            ipChange.ipc$dispatch("760744906", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness != null) {
            MtopRequest mtopRequest = mtopBusiness.request;
            mtopRequest.setData(ReflectUtil.converMapToDataStr(mtopRequest.dataParams));
        }
    }
}
