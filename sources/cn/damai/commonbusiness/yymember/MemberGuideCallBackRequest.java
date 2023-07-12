package cn.damai.commonbusiness.yymember;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MemberGuideCallBackRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String siteName = "damai";
    public String tipType;

    public MemberGuideCallBackRequest(String str) {
        this.tipType = str;
    }

    public static void asyncWriteBack(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974707217")) {
            ipChange.ipc$dispatch("1974707217", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            new MemberGuideCallBackRequest(str).request(new DMMtopRequestListener<Object>(Object.class) { // from class: cn.damai.commonbusiness.yymember.MemberGuideCallBackRequest.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-931445387")) {
                        ipChange2.ipc$dispatch("-931445387", new Object[]{this, str2, str3});
                        return;
                    }
                    cb1.b("YYMember", "回写失败" + str2 + " " + str3);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(Object obj) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1230329060")) {
                        ipChange2.ipc$dispatch("1230329060", new Object[]{this, obj});
                    } else {
                        cb1.b("YYMember", "回写成功");
                    }
                }
            });
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "451422270") ? (String) ipChange.ipc$dispatch("451422270", new Object[]{this}) : "mtop.film.pfusercenter.guide.call.back";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1364697007")) {
            return ((Boolean) ipChange.ipc$dispatch("1364697007", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1571276693")) {
            return ((Boolean) ipChange.ipc$dispatch("-1571276693", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1675808303") ? (String) ipChange.ipc$dispatch("-1675808303", new Object[]{this}) : "1.0";
    }
}
