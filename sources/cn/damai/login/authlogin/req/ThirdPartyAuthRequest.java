package cn.damai.login.authlogin.req;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ThirdPartyAuthRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String OPTR_DO_AUTH = "authorizeAndLogin";
    public static final String OPTR_GET_AUTH = "login";
    public String feature;
    public String operator;
    public String target;

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-272743886") ? (String) ipChange.ipc$dispatch("-272743886", new Object[]{this}) : "mtop.damai.wireless.third.account.session.get";
    }

    public String getFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1389203741") ? (String) ipChange.ipc$dispatch("-1389203741", new Object[]{this}) : this.feature;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425155643")) {
            return ((Boolean) ipChange.ipc$dispatch("425155643", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767571959")) {
            return ((Boolean) ipChange.ipc$dispatch("1767571959", new Object[]{this})).booleanValue();
        }
        return true;
    }

    public String getOperator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "357280653") ? (String) ipChange.ipc$dispatch("357280653", new Object[]{this}) : this.operator;
    }

    public String getTarget() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "523463546") ? (String) ipChange.ipc$dispatch("523463546", new Object[]{this}) : this.target;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1894992837") ? (String) ipChange.ipc$dispatch("1894992837", new Object[]{this}) : "1.0";
    }

    public void setFeature(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731896589")) {
            ipChange.ipc$dispatch("-1731896589", new Object[]{this, str});
        } else {
            this.feature = str;
        }
    }

    public void setOperator(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691529487")) {
            ipChange.ipc$dispatch("-1691529487", new Object[]{this, str});
        } else {
            this.operator = str;
        }
    }

    public void setTarget(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1947376036")) {
            ipChange.ipc$dispatch("1947376036", new Object[]{this, str});
        } else {
            this.target = str;
        }
    }
}
