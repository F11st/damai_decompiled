package cn.damai.h5container.action;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tb.ir1;
import tb.mr1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ActionRemoveCalendar extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    int time_offset;

    public ActionRemoveCalendar(Context context) {
        super(context);
        this.time_offset = 0;
    }

    private long getTime(WVCallBackContext wVCallBackContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1737506766")) {
            return ((Long) ipChange.ipc$dispatch("-1737506766", new Object[]{this, wVCallBackContext, str})).longValue();
        }
        String param = getParam(str);
        if (wh2.j(param)) {
            wVCallBackContext.error(str + " error ");
        }
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(param);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            wVCallBackContext.error(str + " error ");
            return 0L;
        }
        return date.getTime();
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public boolean doAction(String str, String str2, final WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2077487420")) {
            return ((Boolean) ipChange.ipc$dispatch("-2077487420", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        final long time = getTime(wVCallBackContext, "calendar_start_datetime");
        if (time == 0) {
            return true;
        }
        final String param = getParam("calendar_title");
        if (wh2.j(param)) {
            wVCallBackContext.error("calendar_title error ");
            return true;
        }
        Context context = this.contextReference;
        if (context instanceof Activity) {
            ir1.b((Activity) context, false, mr1.CALENDAR, "用于帮助您取消提醒服务", new OnGrantListener() { // from class: cn.damai.h5container.action.ActionRemoveCalendar.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.askpermission.OnGrantListener
                public void onGranted() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-652762415")) {
                        ipChange2.ipc$dispatch("-652762415", new Object[]{this});
                        return;
                    }
                    CalendarsResolver.i().k(new CalendarsResolver.RemindMeListener() { // from class: cn.damai.h5container.action.ActionRemoveCalendar.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
                        public void addRemindmeSuccess() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-1135810779")) {
                                ipChange3.ipc$dispatch("-1135810779", new Object[]{this});
                            }
                        }

                        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
                        public void candelRemindmeSuccess() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-2083431307")) {
                                ipChange3.ipc$dispatch("-2083431307", new Object[]{this});
                                return;
                            }
                            WVResult wVResult = new WVResult();
                            wVResult.addData("result", Boolean.TRUE);
                            wVCallBackContext.success(wVResult);
                        }
                    });
                    CalendarsResolver.i().h(ActionRemoveCalendar.this.contextReference, param, time);
                }
            });
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2042735730") ? (String) ipChange.ipc$dispatch("2042735730", new Object[]{this}) : "removeCalendar";
    }
}
