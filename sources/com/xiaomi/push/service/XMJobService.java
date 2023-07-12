package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.eu;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class XMJobService extends Service {
    static Service a;

    /* renamed from: a  reason: collision with other field name */
    private IBinder f830a = null;

    /* compiled from: Taobao */
    @TargetApi(21)
    /* renamed from: com.xiaomi.push.service.XMJobService$a  reason: invalid class name */
    /* loaded from: classes11.dex */
    static class jobJobServiceC7696a extends JobService {
        Binder a;

        /* renamed from: a  reason: collision with other field name */
        private Handler f831a;

        /* compiled from: Taobao */
        /* renamed from: com.xiaomi.push.service.XMJobService$a$a */
        /* loaded from: classes11.dex */
        private static class HandlerC7697a extends Handler {
            JobService a;

            HandlerC7697a(JobService jobService) {
                super(jobService.getMainLooper());
                this.a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                AbstractC7535b.m586a("Job finished " + jobParameters.getJobId());
                this.a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    eu.a(false);
                }
            }
        }

        jobJobServiceC7696a(Service service) {
            this.a = null;
            this.a = (Binder) com.xiaomi.push.bk.a((Object) this, "onBind", new Intent());
            com.xiaomi.push.bk.a((Object) this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            AbstractC7535b.m586a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f831a == null) {
                this.f831a = new HandlerC7697a(this);
            }
            Handler handler = this.f831a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            AbstractC7535b.m586a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f830a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f830a = new jobJobServiceC7696a(this).a;
        }
        a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}
