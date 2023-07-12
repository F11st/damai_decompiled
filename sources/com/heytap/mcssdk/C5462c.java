package com.heytap.mcssdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.taobao.windvane.connect.api.ApiConstants;
import android.text.TextUtils;
import com.heytap.mcssdk.b.C5461a;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import com.heytap.mcssdk.d.InterfaceC5465d;
import com.heytap.mcssdk.e.C5466a;
import com.heytap.mcssdk.e.C5467b;
import com.heytap.mcssdk.e.InterfaceC5468c;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.callback.IGetAppNotificationCallBackService;
import com.heytap.msp.push.callback.ISetAppNotificationCallBackService;
import com.mcs.aidl.IMcsSdkService;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tb.d43;
import tb.e43;
import tb.iw2;
import tb.x23;
import tb.y23;
import tb.z23;
import tb.z53;

/* compiled from: Taobao */
/* renamed from: com.heytap.mcssdk.c */
/* loaded from: classes10.dex */
public class C5462c implements InterfaceC5459a {
    private static final int[] k = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] l = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static String m = "";
    private static int n = 0;
    private static String o;
    private static boolean p;
    private Context a;
    private List<InterfaceC5468c> b;
    private List<InterfaceC5465d> c;
    private String d;
    private String e;
    private String f;
    private ICallBackResultService g;
    private ISetAppNotificationCallBackService h;
    private IGetAppNotificationCallBackService i;
    private ConcurrentHashMap<Integer, y23> j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.heytap.mcssdk.c$a */
    /* loaded from: classes10.dex */
    public class ServiceConnectionC5463a implements ServiceConnection {
        final /* synthetic */ Intent a;

        ServiceConnectionC5463a(Intent intent) {
            this.a = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.a.getExtras());
            try {
                IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
            } catch (Exception e) {
                z53.a("bindMcsService exception:" + e);
            }
            C5462c.this.a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.heytap.mcssdk.c$b */
    /* loaded from: classes10.dex */
    private static class C5464b {
        private static final C5462c a = new C5462c(null);
    }

    private C5462c() {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.f = null;
        synchronized (C5462c.class) {
            int i = n;
            if (i > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            n = i + 1;
        }
        c(new e43());
        c(new z23());
        d(new C5467b());
        d(new C5466a());
        this.j = new ConcurrentHashMap<>();
    }

    /* synthetic */ C5462c(ServiceConnectionC5463a serviceConnectionC5463a) {
        this();
    }

    public static String A() {
        return "3.0.0";
    }

    private boolean E(Context context) {
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        String o2 = o(this.a);
        return iw2.f(this.a, o2) && iw2.c(this.a, o2) >= 1019 && iw2.g(this.a, o2, "supportOpenPush");
    }

    private void H(int i, String str, JSONObject jSONObject) {
        if (g(i)) {
            ICallBackResultService iCallBackResultService = this.g;
            if (iCallBackResultService != null) {
                iCallBackResultService.onError(l(i), "api_call_too_frequently");
                return;
            }
            return;
        }
        try {
            this.a.startService(n(i, str, jSONObject));
        } catch (Exception e) {
            z53.b("startMcsService--Exception" + e.getMessage());
        }
    }

    private void I(int i, JSONObject jSONObject) {
        H(i, "", jSONObject);
    }

    private y23 b(int i) {
        String str;
        if (!this.j.containsKey(Integer.valueOf(i))) {
            y23 y23Var = new y23(System.currentTimeMillis(), 1);
            this.j.put(Integer.valueOf(i), y23Var);
            z53.a("addCommandToMap :appBean is null");
            return y23Var;
        }
        y23 y23Var2 = this.j.get(Integer.valueOf(i));
        if (j(y23Var2)) {
            y23Var2.b(1);
            y23Var2.c(System.currentTimeMillis());
            str = "addCommandToMap : appLimitBean.setCount(1)";
        } else {
            y23Var2.b(y23Var2.d() + 1);
            str = "addCommandToMap :appLimitBean.getCount() + 1";
        }
        z53.a(str);
        return y23Var2;
    }

    private synchronized void c(InterfaceC5465d interfaceC5465d) {
        if (interfaceC5465d != null) {
            this.c.add(interfaceC5465d);
        }
    }

    private synchronized void d(InterfaceC5468c interfaceC5468c) {
        if (interfaceC5468c != null) {
            this.b.add(interfaceC5468c);
        }
    }

    private boolean f() {
        return h() && i();
    }

    private boolean h() {
        return this.a != null;
    }

    private boolean i() {
        return this.f != null;
    }

    private boolean j(y23 y23Var) {
        long a = y23Var.a();
        long currentTimeMillis = System.currentTimeMillis();
        z53.a("checkTimeNeedUpdate : lastedTime " + a + " currentTime:" + currentTimeMillis);
        return currentTimeMillis - a > 1000;
    }

    public static C5462c m() {
        return C5464b.a;
    }

    private Intent n(int i, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(y(this.a));
        intent.setPackage(o(this.a));
        intent.putExtra("type", i);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.a;
            jSONObject2.putOpt("versionName", iw2.e(context, context.getPackageName()));
            Context context2 = this.a;
            jSONObject2.putOpt("versionCode", Integer.valueOf(iw2.c(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.a.getPackageName());
        intent.putExtra("appKey", this.d);
        intent.putExtra(ApiConstants.APPSECRET, this.e);
        intent.putExtra("registerID", this.f);
        intent.putExtra("sdkVersion", A());
        return intent;
    }

    private String p(Context context) {
        boolean z;
        boolean z2;
        if (TextUtils.isEmpty(m)) {
            m = new String(x23.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(m), 8192);
        if (Build.VERSION.SDK_INT >= 24) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                String str = resolveInfo.serviceInfo.packageName;
                try {
                    z = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                    z2 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (z || z2) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public static int z() {
        return 3000;
    }

    public C5462c B(Context context, boolean z) {
        if (context != null) {
            C(context);
            new C5461a().a(this.a);
            z53.d(z);
            return this;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public void C(Context context) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (o == null) {
            String p2 = p(applicationContext);
            if (p2 == null) {
                o = iw2.a(k);
                z = false;
            } else {
                o = p2;
                z = true;
            }
            p = z;
        }
    }

    public boolean D(Context context) {
        return E(context);
    }

    public void F(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public void G(ICallBackResultService iCallBackResultService) {
        this.g = iCallBackResultService;
    }

    public void J(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.d = str;
        this.e = str2;
        this.a = context.getApplicationContext();
        this.g = iCallBackResultService;
        unRegister(jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void clearNotificationType() {
        clearNotificationType(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void clearNotificationType(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE, jSONObject);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void clearNotifications() {
        clearNotifications(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void clearNotifications(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_CLEAR_PKG_NOTIFICATION, jSONObject);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void disableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (h()) {
            this.h = iSetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE, null);
        } else if (s() != null) {
            this.h.onSetAppNotificationSwitch(-2);
        }
    }

    public void e(int i) {
        if (!g(i)) {
            Intent n2 = n(i, "", null);
            this.a.bindService(n2, new ServiceConnectionC5463a(n2), 1);
            return;
        }
        ICallBackResultService iCallBackResultService = this.g;
        if (iCallBackResultService != null) {
            iCallBackResultService.onError(l(i), "api_call_too_frequently");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void enableAppNotificationSwitch(ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        if (h()) {
            this.h = iSetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN, null);
            return;
        }
        ISetAppNotificationCallBackService iSetAppNotificationCallBackService2 = this.h;
        if (iSetAppNotificationCallBackService2 != null) {
            iSetAppNotificationCallBackService2.onSetAppNotificationSwitch(-2);
        }
    }

    public boolean g(int i) {
        return (i == 12291 || i == 12312 || b(i).d() <= 2) ? false : true;
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void getAppNotificationSwitch(IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        if (h()) {
            this.i = iGetAppNotificationCallBackService;
            I(MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET, null);
            return;
        }
        IGetAppNotificationCallBackService iGetAppNotificationCallBackService2 = this.i;
        if (iGetAppNotificationCallBackService2 != null) {
            iGetAppNotificationCallBackService2.onGetAppNotificationSwitch(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void getNotificationStatus() {
        getNotificationStatus(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void getNotificationStatus(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_GET_NOTIFICATION_STATUS, jSONObject);
        } else if (s() != null) {
            s().onGetNotificationStatus(-2, 0);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void getRegister() {
        getRegister(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void getRegister(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_REGISTER, jSONObject);
        } else if (s() != null) {
            s().onRegister(-2, null);
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public String getRegisterID() {
        return this.f;
    }

    public Context k() {
        return this.a;
    }

    public int l(int i) {
        switch (i) {
            case MessageConstant$CommandId.COMMAND_REGISTER /* 12289 */:
                return -1;
            case MessageConstant$CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case MessageConstant$CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i) {
                    case MessageConstant$CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case MessageConstant$CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case MessageConstant$CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i) {
                            case MessageConstant$CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant$CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant$CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant$CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant$CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant$CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i) {
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public String o(Context context) {
        boolean z;
        if (o == null) {
            String p2 = p(context);
            if (p2 == null) {
                o = iw2.a(k);
                z = false;
            } else {
                o = p2;
                z = true;
            }
            p = z;
        }
        return o;
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void openNotificationSettings() {
        openNotificationSettings(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void openNotificationSettings(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_SETTINGS, jSONObject);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void pausePush() {
        pausePush(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void pausePush(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_PAUSE_PUSH, jSONObject);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    public List<InterfaceC5465d> q() {
        return this.c;
    }

    public List<InterfaceC5468c> r() {
        return this.b;
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void register(Context context, String str, String str2, ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void register(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        if (this.a == null) {
            this.a = context.getApplicationContext();
        }
        if (!iw2.h(this.a)) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        this.d = str;
        this.e = str2;
        this.g = iCallBackResultService;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt(Constants.KEY_APP_VERSION_CODE, Integer.valueOf(iw2.b(context)));
            jSONObject.putOpt(Constants.KEY_APP_VERSION_NAME, iw2.d(context));
        } catch (JSONException e) {
            z53.b("register-Exception:" + e.getMessage());
        }
        I(MessageConstant$CommandId.COMMAND_REGISTER, jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void requestNotificationPermission() {
        if (h()) {
            e(MessageConstant$CommandId.COMMAND_NOTIFICATION_ALLOWANCE);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void resumePush() {
        resumePush(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void resumePush(JSONObject jSONObject) {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_RESUME_PUSH, jSONObject);
        } else {
            z53.c(z53.a, "please call the register first!");
        }
    }

    public ICallBackResultService s() {
        return this.g;
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void setNotificationType(int i, JSONObject jSONObject) {
        if (!f()) {
            z53.c(z53.a, "please call the register first!");
            return;
        }
        H(MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_TYPE, i + "", jSONObject);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void setPushTime(List<Integer> list, int i, int i2, int i3, int i4, JSONObject jSONObject) {
        if (!f()) {
            if (s() != null) {
                s().onSetPushTime(-2, "please call the register first!");
            }
        } else if (list == null || list.size() <= 0 || i < 0 || i2 < 0 || i3 < i || i3 > 23 || i4 < i2 || i4 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", d43.a(list));
                jSONObject2.put("startHour", i);
                jSONObject2.put("startMin", i2);
                jSONObject2.put("endHour", i3);
                jSONObject2.put("endMin", i4);
                H(MessageConstant$CommandId.COMMAND_SET_PUSH_TIME, jSONObject2.toString(), jSONObject);
            } catch (JSONException e) {
                z53.c(z53.a, e.getLocalizedMessage());
            }
        }
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void setRegisterID(String str) {
        this.f = str;
    }

    public IGetAppNotificationCallBackService t() {
        return this.i;
    }

    public ISetAppNotificationCallBackService u() {
        return this.h;
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void unRegister() {
        unRegister(null);
    }

    @Override // com.heytap.mcssdk.InterfaceC5459a
    public void unRegister(JSONObject jSONObject) {
        if (h()) {
            I(MessageConstant$CommandId.COMMAND_UNREGISTER, jSONObject);
        } else if (s() != null) {
            s().onUnRegister(-2);
        }
    }

    public void v() {
        if (f()) {
            I(MessageConstant$CommandId.COMMAND_GET_PUSH_STATUS, null);
        } else if (s() != null) {
            s().onGetPushStatus(-2, 0);
        }
    }

    public int w() {
        if (h()) {
            Context context = this.a;
            return iw2.c(context, o(context));
        }
        return 0;
    }

    public String x() {
        if (h()) {
            Context context = this.a;
            return iw2.e(context, o(context));
        }
        return "";
    }

    public String y(Context context) {
        if (o == null) {
            p(context);
        }
        if (p) {
            if (TextUtils.isEmpty(m)) {
                m = new String(x23.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
            }
            return m;
        }
        return iw2.a(l);
    }
}
