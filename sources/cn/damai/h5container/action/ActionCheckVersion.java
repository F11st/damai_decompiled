package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;
import java.util.ArrayList;
import tb.e80;
import tb.gn1;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionCheckVersion extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;

    public ActionCheckVersion(Context context) {
        super(context);
    }

    private void checkAppHasNewVersion(final Context context, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860128786")) {
            ipChange.ipc$dispatch("1860128786", new Object[]{this, context, wVCallBackContext});
            return;
        }
        UpdateVersionRequest updateVersionRequest = new UpdateVersionRequest(false);
        updateVersionRequest.brand = Build.getMANUFACTURER();
        updateVersionRequest.model = e80.b();
        updateVersionRequest.identifier = AppConfig.j();
        updateVersionRequest.appVersion = AppConfig.q();
        updateVersionRequest.apiLevel = Build.VERSION.SDK_INT;
        updateVersionRequest.isYunos = isYunOS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lu2.MAIN);
        updateVersionRequest.updateTypes = arrayList;
        updateVersionRequest.request(new DMMtopRequestListener<UpdateResultBean>(UpdateResultBean.class) { // from class: cn.damai.h5container.action.ActionCheckVersion.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-221573982")) {
                    ipChange2.ipc$dispatch("-221573982", new Object[]{this, str, str2});
                    return;
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("isNewVersion", Boolean.FALSE);
                wVCallBackContext.error(wVResult);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(UpdateResultBean updateResultBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "833675025")) {
                    ipChange2.ipc$dispatch("833675025", new Object[]{this, updateResultBean});
                } else if (((Activity) context).isFinishing() || updateResultBean == null) {
                } else {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("isNewVersion", Boolean.valueOf("false".equals(updateResultBean.hasUpdate)));
                    wVCallBackContext.success(wVResult);
                }
            }
        });
    }

    private boolean isYunOS() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1393008668")) {
            return ((Boolean) ipChange.ipc$dispatch("-1393008668", new Object[]{this})).booleanValue();
        }
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                if (str2 == null) {
                }
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
        }
        return (str2 == null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965175890")) {
            return ((Boolean) ipChange.ipc$dispatch("1965175890", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        checkAppHasNewVersion(this.contextReference, wVCallBackContext);
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-541719424") ? (String) ipChange.ipc$dispatch("-541719424", new Object[]{this}) : "isNewVersion";
    }
}
