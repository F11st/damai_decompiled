package cn.damai.common.badge.request;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.badge.bean.BadgeMarkResponse;
import cn.damai.common.badge.bean.BadgeQueryResponse;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.iu0;
import tb.mu0;
import tb.rb1;
import tb.uq;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BadgeMTopRequestHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1482633524")) {
            ipChange.ipc$dispatch("-1482633524", new Object[]{this, context, str, badgeMTopCallback});
            return;
        }
        BadgeMarkRequest badgeMarkRequest = new BadgeMarkRequest();
        badgeMarkRequest.markString = str;
        badgeMarkRequest.request(new DMMtopRequestListener<BadgeMarkResponse>(BadgeMarkResponse.class) { // from class: cn.damai.common.badge.request.BadgeMTopRequestHelper.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-377735197")) {
                    ipChange2.ipc$dispatch("-377735197", new Object[]{this, str2, str3});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback2 = badgeMTopCallback;
                if (badgeMTopCallback2 != null) {
                    badgeMTopCallback2.failed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BadgeMarkResponse badgeMarkResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1928879198")) {
                    ipChange2.ipc$dispatch("-1928879198", new Object[]{this, badgeMarkResponse});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback2 = badgeMTopCallback;
                if (badgeMTopCallback2 != null) {
                    badgeMTopCallback2.success(badgeMarkResponse);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, String str, final BadgeMTopCallback badgeMTopCallback) {
        JSONArray parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1198405707")) {
            ipChange.ipc$dispatch("-1198405707", new Object[]{this, context, str, badgeMTopCallback});
            return;
        }
        BadgeQueryRequest badgeQueryRequest = new BadgeQueryRequest();
        badgeQueryRequest.showLoginUI(true);
        badgeQueryRequest.eCode = true;
        if (!TextUtils.isEmpty(str) && str.contains(uq.f)) {
            try {
                if ((JSON.parse(str) instanceof JSONArray) && (parseArray = JSON.parseArray(str)) != null) {
                    parseArray.remove(uq.f);
                    str = JSON.toJSONString(parseArray);
                    badgeQueryRequest.showLoginUI(false);
                    badgeQueryRequest.eCode = false;
                }
            } catch (Exception unused) {
            }
        }
        badgeQueryRequest.queryString = str;
        badgeQueryRequest.request(new DMMtopRequestListener<BadgeQueryResponse>(BadgeQueryResponse.class) { // from class: cn.damai.common.badge.request.BadgeMTopRequestHelper.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-362216479")) {
                    ipChange2.ipc$dispatch("-362216479", new Object[]{this, str2, str3});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback2 = badgeMTopCallback;
                if (badgeMTopCallback2 != null) {
                    badgeMTopCallback2.failed(str2, str3);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BadgeQueryResponse badgeQueryResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-628927563")) {
                    ipChange2.ipc$dispatch("-628927563", new Object[]{this, badgeQueryResponse});
                    return;
                }
                BadgeMTopCallback badgeMTopCallback2 = badgeMTopCallback;
                if (badgeMTopCallback2 != null) {
                    badgeMTopCallback2.success(badgeQueryResponse);
                }
            }
        });
    }

    public void c(final String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944808339")) {
            ipChange.ipc$dispatch("-1944808339", new Object[]{this, str, badgeMTopCallback});
        } else {
            iu0.b().a(new Runnable() { // from class: cn.damai.common.badge.request.BadgeMTopRequestHelper.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2019530316")) {
                        ipChange2.ipc$dispatch("-2019530316", new Object[]{this});
                        return;
                    }
                    try {
                        if (TextUtils.isEmpty(str) || badgeMTopCallback == null) {
                            return;
                        }
                        BadgeMTopRequestHelper.this.d(mu0.a().getApplicationContext(), str, badgeMTopCallback);
                    } catch (Throwable th) {
                        rb1.b("BadgeMTopRequestHelper", th);
                    }
                }
            });
        }
    }

    public void e(final String str, final BadgeMTopCallback badgeMTopCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539501802")) {
            ipChange.ipc$dispatch("-539501802", new Object[]{this, str, badgeMTopCallback});
        } else {
            iu0.b().a(new Runnable() { // from class: cn.damai.common.badge.request.BadgeMTopRequestHelper.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1626503306")) {
                        ipChange2.ipc$dispatch("-1626503306", new Object[]{this});
                        return;
                    }
                    try {
                        if (TextUtils.isEmpty(str) || badgeMTopCallback == null) {
                            return;
                        }
                        BadgeMTopRequestHelper.this.f(mu0.a().getApplicationContext(), str, badgeMTopCallback);
                    } catch (Throwable th) {
                        rb1.b("BadgeMTopRequestHelper", th);
                    }
                }
            });
        }
    }
}
