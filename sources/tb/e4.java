package tb;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.pictures.accs.AgooBroadcastReceiver;
import com.alibaba.pictures.accs.AgooMessage;
import com.alibaba.pictures.accs.DecodeOverListener;
import com.alibaba.pictures.accs.IACCSConfigProvider;
import com.alibaba.pictures.accs.INotifyActionHandler;
import com.alibaba.pictures.accs.PushAgent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import java.util.Random;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class e4 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String AGOO_MSG = "agoo_msg";
    @NotNull
    public static final String AGOO_MSG_ID = "AliAgooMsgID";
    @NotNull
    public static final e4 INSTANCE = new e4();
    private static final String a = "AGOO." + e4.class.getSimpleName();

    /* compiled from: Taobao */
    /* renamed from: tb.e4$a */
    /* loaded from: classes7.dex */
    public static final class C9069a implements DecodeOverListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ AgooMessage b;
        final /* synthetic */ NotificationManager c;
        final /* synthetic */ int d;

        C9069a(Context context, AgooMessage agooMessage, NotificationManager notificationManager, int i) {
            this.a = context;
            this.b = agooMessage;
            this.c = notificationManager;
            this.d = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // com.alibaba.pictures.accs.DecodeOverListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onDecodeOver(@org.jetbrains.annotations.Nullable android.graphics.Bitmap[] r7) {
            /*
                r6 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = tb.e4.C9069a.$ipChange
                java.lang.String r1 = "1782686595"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L17
                java.lang.Object[] r2 = new java.lang.Object[r3]
                r2[r5] = r6
                r2[r4] = r7
                r0.ipc$dispatch(r1, r2)
                return
            L17:
                if (r7 == 0) goto L24
                int r0 = r7.length
                if (r0 != 0) goto L1e
                r0 = 1
                goto L1f
            L1e:
                r0 = 0
            L1f:
                if (r0 == 0) goto L22
                goto L24
            L22:
                r0 = 0
                goto L25
            L24:
                r0 = 1
            L25:
                if (r0 != 0) goto L4b
                r0 = r7[r5]
                r1 = 0
                int r2 = r7.length
                if (r2 < r3) goto L2f
                r1 = r7[r4]
            L2f:
                android.content.Context r7 = r6.a
                com.alibaba.pictures.accs.AgooMessage r2 = r6.b
                android.app.Notification r7 = tb.e4.d(r7, r2, r0, r1)
                android.app.NotificationManager r0 = r6.c
                int r1 = r6.d
                r0.notify(r1, r7)
                tb.e4 r7 = tb.e4.INSTANCE
                java.lang.String r7 = tb.e4.a(r7)
                java.lang.Object[] r0 = new java.lang.Object[r5]
                java.lang.String r1 = "notified:largePushStyle"
                com.taobao.accs.utl.ALog.d(r7, r1, r0)
            L4b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.e4.C9069a.onDecodeOver(android.graphics.Bitmap[]):void");
        }
    }

    private e4() {
    }

    public static final /* synthetic */ String a(e4 e4Var) {
        return a;
    }

    private final boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183388479")) {
            return ((Boolean) ipChange.ipc$dispatch("1183388479", new Object[]{this, context})).booleanValue();
        }
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    @NotNull
    public static final Notification c(@NotNull Context context, @NotNull AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451032650")) {
            return (Notification) ipChange.ipc$dispatch("-1451032650", new Object[]{context, agooMessage});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(agooMessage, "agooMessage");
        return d(context, agooMessage, null, null);
    }

    @JvmStatic
    @NotNull
    public static final Notification d(@NotNull Context context, @NotNull AgooMessage agooMessage, @Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        NotificationCompat.Builder builder;
        Integer appTinyIconRes;
        IACCSConfigProvider f;
        Integer appIconRes;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1357178506")) {
            return (Notification) ipChange.ipc$dispatch("-1357178506", new Object[]{context, agooMessage, bitmap, bitmap2});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(agooMessage, "agooMessage");
        Intent intent = new Intent(context, AgooBroadcastReceiver.class);
        intent.setAction("com.taobao.movie.action.PUSH_CLICK_ACTION");
        intent.setPackage(context.getPackageName());
        int pendingIntentId = agooMessage.getPendingIntentId();
        if (pendingIntentId == 0) {
            pendingIntentId = new Random().nextInt();
            agooMessage.setPendingIntentId(pendingIntentId);
        }
        intent.putExtra(AGOO_MSG, agooMessage);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, pendingIntentId, intent, 134217728);
        Intent intent2 = new Intent(context, AgooBroadcastReceiver.class);
        intent2.setAction("com.taobao.movie.action.PUSH_DELETE_ACTION");
        intent2.setPackage(context.getPackageName());
        intent2.putExtra(AGOO_MSG, agooMessage);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, pendingIntentId, intent2, 134217728);
        if (bitmap == null && (f = PushAgent.INSTANCE.f()) != null && (appIconRes = f.getAppIconRes()) != null) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), appIconRes.intValue());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder(context, INSTANCE.f(context, agooMessage.getNotifyChannelId(), agooMessage.getNotifyChannelName(), agooMessage.getNotifyImportance()));
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        IACCSConfigProvider f2 = PushAgent.INSTANCE.f();
        if (f2 != null && (appTinyIconRes = f2.getAppTinyIconRes()) != null) {
            i = appTinyIconRes.intValue();
        }
        builder.setAutoCancel(true).setContentTitle(agooMessage.getTitle()).setContentText(agooMessage.getText()).setDefaults(-1).setSmallIcon(i).setLargeIcon(bitmap).setTicker(agooMessage.getTicker()).setContentIntent(broadcast).setDeleteIntent(broadcast2);
        if (bitmap2 != null) {
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle(builder);
            bigPictureStyle.setBigContentTitle(agooMessage.getTitle());
            bigPictureStyle.setSummaryText(agooMessage.getText());
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        String url = agooMessage.getUrl();
        if (url == null) {
            url = "--";
        }
        AppMonitorAdapter.commitAlarmSuccess("accs_agoo", "status", url);
        Notification build = builder.build();
        b41.h(build, "builder.build()");
        return build;
    }

    @JvmStatic
    public static final void e(@NotNull Context context, @Nullable AgooMessage agooMessage) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-585208108")) {
            ipChange.ipc$dispatch("-585208108", new Object[]{context, agooMessage});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (agooMessage == null) {
            return;
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        if (!pushAgent.i()) {
            ALog.d(a, "开关已关闭", new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10001", "app notify switch off");
        } else if (!INSTANCE.b(context)) {
            AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10002", "sys notify switch off");
        } else {
            String str = a;
            ALog.d(str, "msg:" + agooMessage, new Object[0]);
            Object systemService = context.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            Integer notifyId = agooMessage.getNotifyId();
            int intValue = notifyId != null ? notifyId.intValue() : new Random().nextInt();
            if ((TextUtils.isEmpty(agooMessage.getBigPicUrl()) && TextUtils.isEmpty(agooMessage.getImgUrl())) || pushAgent.h() == null) {
                notificationManager.notify(intValue, c(context, agooMessage));
                ALog.d(str, "notified", new Object[0]);
                return;
            }
            INotifyActionHandler h = pushAgent.h();
            if (h != null) {
                h.onNotifyImgResDecode(new String[]{agooMessage.getImgUrl(), agooMessage.getBigPicUrl()}, new C9069a(context, agooMessage, notificationManager, intValue));
            }
        }
    }

    @RequiresApi(26)
    private final String f(Context context, String str, String str2, Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275330829")) {
            return (String) ipChange.ipc$dispatch("-275330829", new Object[]{this, context, str, str2, num});
        }
        Object systemService = context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (str == null) {
            str = "tpp_notification_universal";
        }
        if (str2 == null) {
            str2 = "消息推送";
        }
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, num != null ? num.intValue() : 3);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        notificationManager.createNotificationChannel(notificationChannel);
        return str;
    }
}
