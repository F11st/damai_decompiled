package tb;

import com.ali.user.mobile.model.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.login.DefaultTaobaoAppProvider;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class dw0 extends DefaultTaobaoAppProvider {
    private static transient /* synthetic */ IpChange $ipChange;

    public dw0() {
        this.isTaobaoApp = false;
        this.needAlipaySsoGuide = true;
        this.needTaobaoSsoGuide = true;
        this.needPwdGuide = true;
        this.alipaySsoDesKey = "authlogin_tbsdk_android_aes128";
        this.useRegionFragment = true;
        this.enableMobilePwdLogin = true;
        this.site = 18;
        this.showHeadCountry = false;
        this.maxHistoryAccount = 1;
        this.supportTwoStepMobileLogin = false;
        setSaveHistoryWithoutSalt(true);
        setAccountBindBizType("DA_MAI");
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public RegionInfo getCurrentRegion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1141064317")) {
            return (RegionInfo) ipChange.ipc$dispatch("-1141064317", new Object[]{this});
        }
        RegionInfo regionInfo = new RegionInfo();
        regionInfo.domain = "CN";
        return regionInfo;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean isSmsLoginPriority() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-249616593")) {
            return ((Boolean) ipChange.ipc$dispatch("-249616593", new Object[]{this})).booleanValue();
        }
        return true;
    }

    @Override // com.ali.user.mobile.app.dataprovider.DataProvider, com.ali.user.mobile.app.dataprovider.IDataProvider
    public boolean supportTwoStepMobileRegister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "376207007")) {
            return ((Boolean) ipChange.ipc$dispatch("376207007", new Object[]{this})).booleanValue();
        }
        return false;
    }
}
