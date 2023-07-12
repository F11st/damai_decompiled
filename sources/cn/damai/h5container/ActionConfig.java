package cn.damai.h5container;

import android.content.Context;
import cn.damai.h5container.action.ActionAddCalendar;
import cn.damai.h5container.action.ActionAlipay;
import cn.damai.h5container.action.ActionAppUpdate;
import cn.damai.h5container.action.ActionAuth3rdParty;
import cn.damai.h5container.action.ActionCheckVersion;
import cn.damai.h5container.action.ActionCityID;
import cn.damai.h5container.action.ActionClientInfo;
import cn.damai.h5container.action.ActionCloseWindow;
import cn.damai.h5container.action.ActionDMLoginWithUrl;
import cn.damai.h5container.action.ActionDeviceUMID;
import cn.damai.h5container.action.ActionFaceVerify;
import cn.damai.h5container.action.ActionFissionShare;
import cn.damai.h5container.action.ActionGetAuthToken;
import cn.damai.h5container.action.ActionGetLoginKey;
import cn.damai.h5container.action.ActionGetStatusAndStatusBarHeight;
import cn.damai.h5container.action.ActionGetUserCode;
import cn.damai.h5container.action.ActionGoBack;
import cn.damai.h5container.action.ActionGotoRealNameThenticate;
import cn.damai.h5container.action.ActionHasCalendar;
import cn.damai.h5container.action.ActionHavanaId;
import cn.damai.h5container.action.ActionImageViewer;
import cn.damai.h5container.action.ActionIsBottom;
import cn.damai.h5container.action.ActionIsDMLogin;
import cn.damai.h5container.action.ActionLivePayProjectClose;
import cn.damai.h5container.action.ActionLogin;
import cn.damai.h5container.action.ActionMtopSwitch;
import cn.damai.h5container.action.ActionOpenPage;
import cn.damai.h5container.action.ActionOpenPageAfterTrustYouKuLogin;
import cn.damai.h5container.action.ActionOpenWindow;
import cn.damai.h5container.action.ActionPushWindow;
import cn.damai.h5container.action.ActionRemoveCalendar;
import cn.damai.h5container.action.ActionShare;
import cn.damai.h5container.action.ActionShareByType;
import cn.damai.h5container.action.ActionShowNavbarMenu;
import cn.damai.h5container.action.ActionShowShortVipBind;
import cn.damai.h5container.action.ActionSpecialTitle;
import cn.damai.h5container.action.ActionTTID;
import cn.damai.h5container.action.ActionUserTrack;
import cn.damai.h5container.action.ActionUtdid;
import cn.damai.h5container.action.ActionWxPay;
import cn.damai.h5container.action.ActionWxShare;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ActionConfig {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;

    public ActionConfig(Context context) {
        this.context = context;
    }

    public void addActions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2075053041")) {
            ipChange.ipc$dispatch("-2075053041", new Object[]{this});
            return;
        }
        new ActionOpenPage(this.context);
        new ActionLogin(this.context);
        new ActionUtdid(this.context);
        new ActionOpenWindow(this.context);
        new ActionPushWindow(this.context);
        new ActionCloseWindow(this.context);
        new ActionGoBack(this.context);
        new ActionIsBottom(this.context);
        new ActionCityID(this.context);
        new ActionClientInfo(this.context);
        new ActionWxShare(this.context);
        new ActionUserTrack(this.context);
        new ActionGetLoginKey(this.context);
        new ActionGetUserCode(this.context);
        new ActionSpecialTitle(this.context);
        new ActionWxPay(this.context);
        new ActionAlipay(this.context);
        new ActionImageViewer(this.context);
        new ActionGotoRealNameThenticate(this.context);
        new ActionShare(this.context);
        new ActionAddCalendar(this.context);
        new ActionFaceVerify(this.context);
        new ActionShowNavbarMenu(this.context);
        new ActionHavanaId(this.context);
        new ActionDeviceUMID(this.context);
        new ActionTTID(this.context);
        new ActionShareByType(this.context);
        new ActionOpenPageAfterTrustYouKuLogin(this.context);
        new ActionFissionShare(this.context);
        new ActionMtopSwitch(this.context);
        new ActionLivePayProjectClose(this.context);
        new ActionAuth3rdParty(this.context);
        new ActionIsDMLogin(this.context);
        new ActionDMLoginWithUrl(this.context);
        new ActionGetAuthToken(this.context);
        new ActionGetStatusAndStatusBarHeight(this.context);
        new ActionShowShortVipBind(this.context);
        new ActionAppUpdate(this.context);
        new ActionCheckVersion(this.context);
        new ActionHasCalendar(this.context);
        new ActionRemoveCalendar(this.context);
    }
}
