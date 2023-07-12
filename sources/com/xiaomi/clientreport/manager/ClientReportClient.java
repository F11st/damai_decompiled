package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.C7548a;
import com.xiaomi.clientreport.processor.C7549b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C7667h;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ClientReportClient {
    public static void init(Context context) {
        init(context, Config.defaultConfig(context), new C7548a(context), new C7549b(context));
    }

    public static void init(Context context, Config config) {
        init(context, config, new C7548a(context), new C7549b(context));
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        AbstractC7535b.c("init in  pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        C7539a.a(context).a(config, iEventProcessor, iPerfProcessor);
        if (C7667h.m942a(context)) {
            AbstractC7535b.c("init in process\u3000start scheduleJob");
            C7539a.a(context).m592a();
        }
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            C7539a.a(context).a(eventClientReport);
        }
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            C7539a.a(context).a(perfClientReport);
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config == null) {
            return;
        }
        C7539a.a(context).a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
    }
}
