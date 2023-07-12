package cn.damai.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.common.Constants;
import com.taobao.tao.log.TLog;
import com.youku.arch.beast.PcsManager;
import java.util.HashMap;
import java.util.Map;
import tb.ml;
import tb.mu0;
import tb.t2;
import tb.x20;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class DaMaiPushAgent {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACCS_YOUKU_TAG = "youku";
    public static final String TAG_ACCS = "YKAccs.init";
    private static final String a = DaMaiPushAgent.class.getSimpleName() + "_xxx";
    private static Context b = null;
    private static final Map<String, String> c = new HashMap<String, String>() { // from class: cn.damai.push.DaMaiPushAgent.1
        {
            put("powermsg-youku", "com.youku.livesdk.mkt.AccsReceiverService");
            put("pmmonitor-youku", "com.youku.livesdk.mkt.AccsReceiverService");
            put("VIPDynamicPushService", "com.youku.accs.accsmanager.service.AccsDispatcherService");
            put("youku_msgcenter", "com.youku.messagecenter.service.AccsReceiverService");
            put("community-youku", "com.youku.planet.common.service.AccsReceiverService");
            put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
            put("us_task_accs", "com.youku.phone.task.receiver.TaskMessageReceiverService");
            put("player-youku", "com.youku.phone.MessageCenterService");
            put(PcsManager.SERVICE_ID, "com.youku.arch.beast.PcsAccsService");
            put("youku_pgc", "com.youku.phone.PgcAccsService");
            put("YK_TOUCH_ACCS_SERVICE", "com.youku.phone.AccsPlatformService");
            put("YK_IM_ACCS_SERVICE", "com.youku.yktalk.sdk.base.api.accs.AccsSDKService");
            put("youku_fog_computing_svr", "com.youku.d2d.sdk.service.AccsMessageService");
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class a implements IAppReceiver {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @Override // com.taobao.accs.IAppReceiver
        public Map<String, String> getAllServices() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-565908154") ? (Map) ipChange.ipc$dispatch("-565908154", new Object[]{this}) : DaMaiPushAgent.c;
        }

        @Override // com.taobao.accs.IAppReceiver
        public String getService(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-212839109") ? (String) ipChange.ipc$dispatch("-212839109", new Object[]{this, str}) : (String) DaMaiPushAgent.c.get(str);
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindApp(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-242865704")) {
                ipChange.ipc$dispatch("-242865704", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            TLog.logd(DaMaiPushAgent.TAG_ACCS, "Accs-Youku onBindApp result: " + i);
            if (i == 200) {
                Log.e(DaMaiPushAgent.a + "_accs_Youku", "bindApp success");
                x20.g();
                c.e().A(ml.g().i(DaMaiPushAgent.b, "accs", "1", ""), "trip_yk_accs_sync_login", "push");
                return;
            }
            c.e().A(ml.g().i(DaMaiPushAgent.b, "accs", "2", ""), "trip_yk_accs_sync_login", "push");
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onBindUser(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-821028410")) {
                ipChange.ipc$dispatch("-821028410", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            TLog.logd(DaMaiPushAgent.TAG_ACCS, "Accs-Youku onBindUser result: " + i + " userId: " + str);
            c e = c.e();
            ml g = ml.g();
            Context context = DaMaiPushAgent.b;
            e.A(g.i(context, "accs", "4", "userId=" + str), "trip_yk_accs_sync_login", "push");
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onData(String str, String str2, byte[] bArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1872118700")) {
                ipChange.ipc$dispatch("1872118700", new Object[]{this, str, str2, bArr});
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onSendData(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589628944")) {
                ipChange.ipc$dispatch("-1589628944", new Object[]{this, str, Integer.valueOf(i)});
            }
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindApp(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1170343967")) {
                ipChange.ipc$dispatch("1170343967", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            TLog.logd(DaMaiPushAgent.TAG_ACCS, "Accs-Youku onUnbindApp result: " + i);
        }

        @Override // com.taobao.accs.IAppReceiver
        public void onUnbindUser(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "537402921")) {
                ipChange.ipc$dispatch("537402921", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            TLog.logd(DaMaiPushAgent.TAG_ACCS, "Accs-Youku onUnbindUser result: " + i);
        }
    }

    private static String d(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1768812118") ? (String) ipChange.ipc$dispatch("-1768812118", new Object[]{Integer.valueOf(i)}) : i == 0 ? "youku-jmacs.m.taobao.com" : i == 1 ? "youku-jmacs.wapa.taobao.com" : i == 2 ? "youku-jmacs.waptest.taobao.com" : "youku-jmacs.m.taobao.com";
    }

    private static String e(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "983906001") ? (String) ipChange.ipc$dispatch("983906001", new Object[]{Integer.valueOf(i)}) : i == 0 ? "youku-acs.m.taobao.com" : i == 1 ? "youku-acs.wapa.taobao.com" : i == 2 ? "youku-acs.waptest.taobao.com" : "youku-acs.m.taobao.com";
    }

    private static int f(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1525221734") ? ((Integer) ipChange.ipc$dispatch("1525221734", new Object[]{Integer.valueOf(i)})).intValue() : (i == 0 || i == 1 || i != 2) ? 11 : 0;
    }

    public static String g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1132104285")) {
            return (String) ipChange.ipc$dispatch("-1132104285", new Object[]{Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i == 1) {
                return "pre-msgacs.youku.com";
            }
            if (i == 2 || AppConfig.v()) {
                return "daily-msgacs.youku.com";
            }
        }
        return "msgacs.youku.com";
    }

    public static void h(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-127354040")) {
            ipChange.ipc$dispatch("-127354040", new Object[]{context});
            return;
        }
        try {
            b = context;
            t2.b(mu0.a());
            t2.a();
            t2.c();
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                i = 2;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                i = 1;
            } else {
                AppConfig.g();
                AppConfig.EnvMode envMode = AppConfig.EnvMode.online;
            }
            e(i);
            d(i);
            int f = f(i);
            String g = g(i);
            try {
                AccsClientConfig.Builder builder = new AccsClientConfig.Builder();
                builder.setInappHost(g).setInappPubKey(f).setChannelHost(null).setChannelPubKey(f).setConfigEnv(i).setAppKey(AppConfig.c()).setDisableChannel(true).setTag("youku");
                ACCSClient.init(mu0.a(), builder.build());
                ACCSClient.getAccsClient("youku").bindApp(AppConfig.p(), new a());
            } catch (AccsException e) {
                TLog.logd(TAG_ACCS, "init Accs-Youku AccsException " + e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void i(String str, byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40867124")) {
            ipChange.ipc$dispatch("40867124", new Object[]{str, bArr});
            return;
        }
        try {
            ACCSClient.getAccsClient("default").sendData(new ACCSManager.AccsRequest(x20.c(), t2.ACCS_CHANNEL, bArr, str));
        } catch (AccsException e) {
            e.printStackTrace();
        }
    }

    public static void j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625321566")) {
            ipChange.ipc$dispatch("1625321566", new Object[]{str});
        } else if (b != null) {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.POPCORN_CONFIG);
            intent.setPackage("cn.damai");
            intent.putExtra(DamaiConstants.POPCORN_CONFIG, str);
            b.sendBroadcast(intent);
        }
    }

    public static void k(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1626111833")) {
            ipChange.ipc$dispatch("-1626111833", new Object[]{str, str2, str3});
        } else if (b != null) {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
            intent.setPackage("cn.damai");
            intent.putExtra("type", 6);
            intent.putExtra(Constants.KEY_DATA_ID, str2);
            intent.putExtra("performJson", str3);
            intent.putExtra("bizType", str);
            b.sendBroadcast(intent);
            Log.e("sendTickletAccsMsg", "sendTickletAccsMsg mes= " + str3);
        }
    }

    public static void l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1507318718")) {
            ipChange.ipc$dispatch("1507318718", new Object[]{str});
        } else if (b != null) {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
            intent.setPackage("cn.damai");
            intent.putExtra("type", 8);
            intent.putExtra("updateticket", str);
            b.sendBroadcast(intent);
        }
    }
}
