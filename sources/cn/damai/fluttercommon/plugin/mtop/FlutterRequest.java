package cn.damai.fluttercommon.plugin.mtop;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import tb.jn1;
import tb.w20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class FlutterRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String method;
    public Map<String, String> params;

    private String convertMapToDataStr(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-500440444")) {
            return (String) ipChange.ipc$dispatch("-500440444", new Object[]{this, map});
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(jn1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(value));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[convertMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append((Object) value);
                        sb2.append(" to dataStr error.");
                        TBSdkLog.e("mtopsdk.ReflectUtil", sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1377905263") ? (String) ipChange.ipc$dispatch("-1377905263", new Object[]{this}) : this.API_NAME;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public DMBaseMtopRequest.HttpMethod getHttpMethod() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1385810089")) {
            return (DMBaseMtopRequest.HttpMethod) ipChange.ipc$dispatch("1385810089", new Object[]{this});
        }
        if ("POST".equals(this.method)) {
            return DMBaseMtopRequest.HttpMethod.POST;
        }
        return DMBaseMtopRequest.HttpMethod.GET;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "786716348") ? ((Boolean) ipChange.ipc$dispatch("786716348", new Object[]{this})).booleanValue() : this.NEED_ECODE;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1335058488") ? ((Boolean) ipChange.ipc$dispatch("1335058488", new Object[]{this})).booleanValue() : this.NEED_SESSION;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "789831460") ? (String) ipChange.ipc$dispatch("789831460", new Object[]{this}) : this.VERSION;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public void setRequestData(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94041669")) {
            ipChange.ipc$dispatch("94041669", new Object[]{this, mtopBusiness});
        } else if (mtopBusiness == null) {
        } else {
            Map<String, String> map = this.params;
            if (map != null && !map.isEmpty()) {
                Map<String, String> c = w20.b().c(getApiName(), null);
                c.putAll(this.params);
                mtopBusiness.request.setData(convertMapToDataStr(c));
                return;
            }
            super.setRequestData(mtopBusiness);
        }
    }
}
