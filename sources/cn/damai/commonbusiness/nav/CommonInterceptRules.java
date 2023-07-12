package cn.damai.commonbusiness.nav;

import android.os.Bundle;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailFragment;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import com.ali.user.mobile.rpc.ApiConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class CommonInterceptRules implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<RouterParam> routerParamList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    class RouterParam implements Serializable {
        public Bundle extraBundle;
        public String keyUri;
        public String sourceParamKey;
        public String targetParamKey;
        public String targetUri;

        RouterParam() {
        }
    }

    public List<RouterParam> getRules() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490999838")) {
            return (List) ipChange.ipc$dispatch("490999838", new Object[]{this});
        }
        RouterParam routerParam = new RouterParam();
        routerParam.keyUri = "https://m.damai.cn/damai/activity/discover/themepagecms.html";
        routerParam.sourceParamKey = "themeId";
        routerParam.targetParamKey = "themeId";
        routerParam.targetUri = cs.DISCOVER_CIRCLE_THEME_PAGE;
        this.routerParamList.add(routerParam);
        RouterParam routerParam2 = new RouterParam();
        routerParam2.keyUri = "https://m.damai.cn/app/dmfe/show/pages/my/index.html";
        routerParam2.sourceParamKey = ApiConstants.ApiField.HID;
        routerParam2.targetParamKey = "userId";
        routerParam2.targetUri = cs.Y;
        Bundle bundle = new Bundle();
        bundle.putString(RepertoireDetailFragment.USERTYPE, "1");
        routerParam2.extraBundle = bundle;
        this.routerParamList.add(routerParam2);
        RouterParam routerParam3 = new RouterParam();
        routerParam3.keyUri = "https://m.damai.cn/damai/activity/waitcomment/index.html";
        routerParam3.targetUri = "mycomment";
        this.routerParamList.add(routerParam3);
        RouterParam routerParam4 = new RouterParam();
        routerParam4.keyUri = "https://m.damai.cn/damai/activity/discover/detail.html";
        routerParam4.targetUri = cs.DISCOVER_CONTENT_DETAIL;
        routerParam4.sourceParamKey = "contentId";
        routerParam4.targetParamKey = "contentId";
        this.routerParamList.add(routerParam4);
        RouterParam routerParam5 = new RouterParam();
        routerParam5.keyUri = "https://m.damai.cn/shows/pages/jbs/store-detail.html";
        routerParam5.targetUri = cs.SCRIPT_SHOP_DETAIL;
        routerParam5.sourceParamKey = "storeId";
        routerParam5.targetParamKey = "storeId";
        this.routerParamList.add(routerParam5);
        RouterParam routerParam6 = new RouterParam();
        routerParam6.keyUri = "https://m.damai.cn/shows/pages/jbs/coupon-detail.html";
        routerParam6.targetUri = cs.SCRIPT_COUPON_DETAIL;
        routerParam6.sourceParamKey = CouponDetailFragment.COUPON_ID;
        routerParam6.targetParamKey = CouponDetailFragment.COUPON_ID;
        this.routerParamList.add(routerParam6);
        RouterParam routerParam7 = new RouterParam();
        routerParam7.keyUri = "https://m.damai.cn/damai/detail/item.html";
        routerParam7.targetUri = cs.b;
        routerParam7.sourceParamKey = "itemId";
        routerParam7.targetParamKey = IssueConstants.ProjectID;
        this.routerParamList.add(routerParam7);
        return this.routerParamList;
    }
}
