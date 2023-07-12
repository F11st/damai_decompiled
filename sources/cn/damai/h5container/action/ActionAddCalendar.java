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
public class ActionAddCalendar extends DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    int time_offset;

    public ActionAddCalendar(Context context) {
        super(context);
        this.time_offset = 0;
    }

    private long getTime(WVCallBackContext wVCallBackContext, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783596897")) {
            return ((Long) ipChange.ipc$dispatch("-783596897", new Object[]{this, wVCallBackContext, str})).longValue();
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
        if (AndroidInstantRuntime.support(ipChange, "2117440311")) {
            return ((Boolean) ipChange.ipc$dispatch("2117440311", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        final long time = getTime(wVCallBackContext, "calendar_start_datetime");
        if (time == 0) {
            return true;
        }
        final long time2 = getTime(wVCallBackContext, "calendar_end_datetime");
        if (time2 == 0) {
            return true;
        }
        final String param = getParam("calendar_title");
        if (wh2.j(param)) {
            wVCallBackContext.error("calendar_title error ");
            return true;
        }
        try {
            this.time_offset = Integer.parseInt(getParam("time_offset"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        final String param2 = getParam("calendar_note");
        Context context = this.contextReference;
        if (context instanceof Activity) {
            ir1.b((Activity) context, false, mr1.CALENDAR, "用于帮助您设置提醒服务", new OnGrantListener() { // from class: cn.damai.h5container.action.ActionAddCalendar.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.askpermission.OnGrantListener
                public void onGranted() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1258371970")) {
                        ipChange2.ipc$dispatch("-1258371970", new Object[]{this});
                        return;
                    }
                    CalendarsResolver.i().k(new CalendarsResolver.RemindMeListener() { // from class: cn.damai.h5container.action.ActionAddCalendar.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
                        public void addRemindmeSuccess() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1399056216")) {
                                ipChange3.ipc$dispatch("1399056216", new Object[]{this});
                                return;
                            }
                            WVResult wVResult = new WVResult();
                            wVResult.addData("success", "true");
                            wVResult.addData("result", Boolean.TRUE);
                            wVCallBackContext.success(wVResult);
                        }

                        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
                        public void candelRemindmeSuccess() {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "24218466")) {
                                ipChange3.ipc$dispatch("24218466", new Object[]{this});
                            }
                        }
                    });
                    CalendarsResolver i = CalendarsResolver.i();
                    ActionAddCalendar actionAddCalendar = ActionAddCalendar.this;
                    i.c(actionAddCalendar.contextReference, param, param2, time, time2, actionAddCalendar.time_offset);
                }
            });
        }
        return true;
    }

    @Override // cn.damai.h5container.action.DMBridgeAction
    public String getAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1339598043") ? (String) ipChange.ipc$dispatch("-1339598043", new Object[]{this}) : "addCalendar";
    }
}
