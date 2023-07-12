package cn.damai.commonbusiness.yymember.request;

import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MemberFinishGuideCallBackRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bizId;
    public String platform = "204";
    public String layoutType = "1";

    public static void syncWriteBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1010804261")) {
            ipChange.ipc$dispatch("-1010804261", new Object[0]);
        } else {
            new MemberFinishGuideCallBackRequest().request(new DMMtopRequestListener<Object>(Object.class) { // from class: cn.damai.commonbusiness.yymember.request.MemberFinishGuideCallBackRequest.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-13285400")) {
                        ipChange2.ipc$dispatch("-13285400", new Object[]{this, str, str2});
                        return;
                    }
                    cb1.b("YYMember", "已成为会员回写失败" + str + " " + str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-20768047")) {
                        ipChange2.ipc$dispatch("-20768047", new Object[]{this, obj});
                    } else {
                        cb1.b("YYMember", "已成为会员回写成功");
                    }
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1829206677") ? (String) ipChange.ipc$dispatch("-1829206677", new Object[]{this}) : "mtop.film.pfusercenter.identity.layout.update";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977626146")) {
            return ((Boolean) ipChange.ipc$dispatch("1977626146", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956893666")) {
            return ((Boolean) ipChange.ipc$dispatch("-956893666", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "338530046") ? (String) ipChange.ipc$dispatch("338530046", new Object[]{this}) : "1.0";
    }
}
