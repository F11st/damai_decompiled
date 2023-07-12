package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MessageHandleService extends BaseService {
    private static ConcurrentLinkedQueue<C7554a> a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private static ExecutorService f25a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.mipush.sdk.MessageHandleService$a */
    /* loaded from: classes11.dex */
    public static class C7554a {
        private Intent a;

        /* renamed from: a  reason: collision with other field name */
        private PushMessageReceiver f26a;

        public C7554a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f26a = pushMessageReceiver;
            this.a = intent;
        }

        public Intent a() {
            return this.a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m600a() {
            return this.f26a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, C7554a c7554a) {
        String[] stringArrayExtra;
        if (c7554a == null) {
            return;
        }
        try {
            PushMessageReceiver m600a = c7554a.m600a();
            Intent a2 = c7554a.a();
            int intExtra = a2.getIntExtra("message_type", 1);
            if (intExtra == 1) {
                PushMessageHandler.InterfaceC7557a a3 = am.a(context).a(a2);
                int intExtra2 = a2.getIntExtra("eventMessageType", -1);
                if (a3 == null) {
                    return;
                }
                if (a3 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) a3;
                    if (!miPushMessage.isArrivedMessage()) {
                        m600a.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        eo.a(context.getApplicationContext()).a(context.getPackageName(), a2, 2004, (String) null);
                        AbstractC7535b.e("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        m600a.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    } else if (!miPushMessage.isNotified()) {
                        AbstractC7535b.e("begin execute onNotificationMessageArrived from " + miPushMessage.getMessageId());
                        m600a.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    } else {
                        if (intExtra2 == 1000) {
                            eo.a(context.getApplicationContext()).a(context.getPackageName(), a2, 1007, (String) null);
                        } else {
                            eo.a(context.getApplicationContext()).a(context.getPackageName(), a2, 3007, (String) null);
                        }
                        AbstractC7535b.e("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                        m600a.onNotificationMessageClicked(context, miPushMessage);
                        return;
                    }
                } else if (!(a3 instanceof MiPushCommandMessage)) {
                    return;
                } else {
                    MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) a3;
                    AbstractC7535b.e("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                    m600a.onCommandResult(context, miPushCommandMessage);
                    if (!TextUtils.equals(miPushCommandMessage.getCommand(), ey.COMMAND_REGISTER.f325a)) {
                        return;
                    }
                    m600a.onReceiveRegisterResult(context, miPushCommandMessage);
                    PushMessageHandler.a(context, miPushCommandMessage);
                    if (miPushCommandMessage.getResultCode() != 0) {
                        return;
                    }
                }
            } else if (intExtra != 3) {
                if (intExtra == 5 && PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(a2.getStringExtra(PushMessageHelper.ERROR_TYPE)) && (stringArrayExtra = a2.getStringArrayExtra(PushMessageHelper.ERROR_MESSAGE)) != null) {
                    AbstractC7535b.e("begin execute onRequirePermissions, lack of necessary permissions");
                    m600a.onRequirePermissions(context, stringArrayExtra);
                    return;
                }
                return;
            } else {
                MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a2.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                AbstractC7535b.e("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                m600a.onCommandResult(context, miPushCommandMessage2);
                if (!TextUtils.equals(miPushCommandMessage2.getCommand(), ey.COMMAND_REGISTER.f325a)) {
                    return;
                }
                m600a.onReceiveRegisterResult(context, miPushCommandMessage2);
                PushMessageHandler.a(context, miPushCommandMessage2);
                if (miPushCommandMessage2.getResultCode() != 0) {
                    return;
                }
            }
            C7572i.b(context);
        } catch (RuntimeException e) {
            AbstractC7535b.a(e);
        }
    }

    public static void addJob(Context context, C7554a c7554a) {
        if (c7554a != null) {
            a.add(c7554a);
            b(context);
            startService(context);
        }
    }

    private static void b(Context context) {
        if (f25a.isShutdown()) {
            return;
        }
        f25a.execute(new RunnableC7592z(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        try {
            a(context, a.poll());
        } catch (RuntimeException e) {
            AbstractC7535b.a(e);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        com.xiaomi.push.al.a(context).a(new RunnableC7591y(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* renamed from: a */
    protected boolean mo606a() {
        ConcurrentLinkedQueue<C7554a> concurrentLinkedQueue = a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
