package tb;

import android.app.Activity;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.nav.DMNav;
import cn.damai.fluttercommon.DMBaseFlutterActivity;
import cn.damai.fluttercommon.DMNFCActivity;
import cn.damai.solid.C1768a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.idlefish.flutterboost.C5776c;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostDelegate;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.arch.solid.lifecycle.SolidResponse;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.ArrayList;
import tb.ao0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class jo0 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String TAG = jo0.class.getSimpleName() + "_xxx";
    private static String b = "XGS5ysbZ/3DHAT6TGKdGJ7CeBYobdomOTKN5D6yP/v4kd4kjntIrTugRVGudxRwu/bq0UZyJA2XLyRnQLL0QNrUd/m+NZJO+uebVTLVSZBeSNSii5XCXoOIzmyhA8lAmThp12mNOcLuVGqVRRzC4Bh8pxfRRPI+p5mMf3FwlShGWq4lVgT4KgvCg7MeC8NkfAZMim4nDJmRgGxRG8FcD4pAI7MfobG/xlfzoVcvHMtw8xOy+tZ3uJmVFQ4Hn5g3LgbQD538wmT9aP2tQU+xsMEjPZwSwO33w7oBbHF4ah/byOjaiBVIyrk8k9wETwCy8B4WxO4bdKRrQ8EBc+BekJw==";
    private static jo0 c;
    private volatile boolean a = false;

    /* compiled from: Taobao */
    /* renamed from: tb.jo0$a */
    /* loaded from: classes5.dex */
    public class C9316a implements FlutterBoostDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        C9316a(jo0 jo0Var) {
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public boolean popRoute(C5776c c5776c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-600517833")) {
                return ((Boolean) ipChange.ipc$dispatch("-600517833", new Object[]{this, c5776c})).booleanValue();
            }
            return false;
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public void pushFlutterRoute(C5776c c5776c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-900168956")) {
                ipChange.ipc$dispatch("-900168956", new Object[]{this, c5776c});
                return;
            }
            Activity c = k3.b().c();
            if (FlutterBoost.h().e() != null) {
                c = FlutterBoost.h().e();
            }
            Class cls = DMBaseFlutterActivity.class;
            if (!TextUtils.isEmpty(c5776c.b()) && "dm_ticket_nfc".equals(c5776c.b())) {
                cls = DMNFCActivity.class;
            }
            c.startActivity(new FlutterBoostActivity.C5779a(cls).a(FlutterActivityLaunchConfigs.BackgroundMode.transparent).c(false).d(c5776c.d()).e(c5776c.b()).f(c5776c.a()).b(c));
        }

        @Override // com.idlefish.flutterboost.FlutterBoostDelegate
        public void pushNativeRoute(C5776c c5776c) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1246254265")) {
                ipChange.ipc$dispatch("-1246254265", new Object[]{this, c5776c});
            } else if (FlutterBoost.h().e() == null) {
            } else {
                DMNav.from(FlutterBoost.h().e()).forResult(c5776c.c()).withExtras(fo.a(c5776c.a())).toUri(c5776c.b());
            }
        }
    }

    private jo0() {
    }

    public static jo0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352148219")) {
            return (jo0) ipChange.ipc$dispatch("352148219", new Object[0]);
        }
        if (c == null) {
            synchronized (jo0.class) {
                if (c == null) {
                    c = new jo0();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(FlutterEngine flutterEngine) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1540252567")) {
            ipChange.ipc$dispatch("1540252567", new Object[]{flutterEngine});
            return;
        }
        jt0.b();
        jt0.a(flutterEngine);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930685792")) {
            ipChange.ipc$dispatch("-1930685792", new Object[]{this});
        } else if (c()) {
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add("--user-authorization-code=" + b);
            if (!AppConfig.v()) {
                SolidRequest solidRequest = new SolidRequest();
                solidRequest.name = C1768a.LIB_APP_SO;
                SolidResponse checkSoFilePath = SolidServer.checkSoFilePath(solidRequest);
                String str = "--aot-shared-library-name=" + checkSoFilePath.soFilePath;
                cb1.c(C1768a.TAG, "flutter shellArgs lib app path : " + str);
                arrayList.add(str);
            }
            FlutterBoost.h().m(mu0.a(), new C9316a(this), new FlutterBoost.Callback() { // from class: tb.io0
                @Override // com.idlefish.flutterboost.FlutterBoost.Callback
                public final void onStart(FlutterEngine flutterEngine) {
                    jo0.g(flutterEngine);
                }
            }, new ao0.C8917b().g(arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[arrayList.size()])).f());
            this.a = true;
        }
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1452350973") ? ((Boolean) ipChange.ipc$dispatch("1452350973", new Object[]{this})).booleanValue() : this.a && FlutterBoost.h().f() != null;
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374464320")) {
            ipChange.ipc$dispatch("1374464320", new Object[]{this});
        } else {
            b();
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1069281529")) {
            ipChange.ipc$dispatch("-1069281529", new Object[]{this});
        } else {
            DMNav.registerStickPreprocessor(new C9800v4());
        }
    }
}
