package cn.damai.fluttercommon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import cn.damai.ticket.nfc.NfcUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import tb.as;
import tb.db1;
import tb.pk1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMNFCActivity extends DMBaseFlutterActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHANNEL_NATIVE = "cn.movieshow.app/nfcverify";
    private static final String NFC_READ_FAIL = "2";
    private static final String NFC_READ_OVERTIME = "3";
    private static final String NFC_READ_SUCCESS = "1";
    private final String TAG = DMNFCActivity.class.getSimpleName();
    private final NfcUtil nfcUtil = new NfcUtil();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.fluttercommon.DMNFCActivity$a */
    /* loaded from: classes5.dex */
    public class C1101a implements NfcUtil.ReadCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        C1101a() {
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadError(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-588302746")) {
                ipChange.ipc$dispatch("-588302746", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            DMNFCActivity.this.flutterPlugin("2", new HashMap(), i, str);
            db1.b("DMNFCActivity", str);
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadOvertime() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1840958490")) {
                ipChange.ipc$dispatch("1840958490", new Object[]{this});
                return;
            }
            DMNFCActivity.this.flutterPlugin("3", new HashMap(), 1000, "验证超时，没有检测到验真芯片");
            DMNFCActivity.this.pauseNfc(false);
            db1.b("DMNFCActivity", "11111超时了");
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadSuccess(pk1 pk1Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "153151139")) {
                ipChange.ipc$dispatch("153151139", new Object[]{this, pk1Var});
                return;
            }
            HashMap hashMap = new HashMap();
            if (pk1Var != null) {
                hashMap.put("uid", pk1Var.e());
                hashMap.put("sid", pk1Var.c());
                hashMap.put("tid", pk1Var.d());
                hashMap.put("challenge", pk1Var.a());
                hashMap.put("cipherText", pk1Var.b());
                DMNFCActivity.this.flutterPlugin("1", hashMap, -1, "");
                db1.b("DMNFCActivity", "111111uid=" + pk1Var.e() + " sid=" + pk1Var.c() + " tid=" + pk1Var.d() + " challenge=" + pk1Var.b() + "=cipherText=" + pk1Var.b());
                return;
            }
            hashMap.put("msg", "返回结果为null");
            DMNFCActivity.this.flutterPlugin("2", null, -1, "");
            db1.b("DMNFCActivity", "111111值为null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flutterPlugin(String str, Map map, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971213034")) {
            ipChange.ipc$dispatch("1971213034", new Object[]{this, str, map, Integer.valueOf(i), str2});
            return;
        }
        if (map == null) {
            map = new HashMap();
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("msg", str2);
        }
        HashMap hashMap = new HashMap();
        as.a(i, hashMap);
        hashMap.put("code", str);
        hashMap.put("data", map);
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL_NATIVE).invokeMethod("vefifyComplete", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseNfc(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894940442")) {
            ipChange.ipc$dispatch("-894940442", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        NfcUtil nfcUtil = this.nfcUtil;
        if (nfcUtil != null) {
            if (z) {
                nfcUtil.j();
            }
            this.nfcUtil.h();
        }
    }

    public NfcUtil getNfcUtil() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1345003044") ? (NfcUtil) ipChange.ipc$dispatch("-1345003044", new Object[]{this}) : this.nfcUtil;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1364984780")) {
            ipChange.ipc$dispatch("1364984780", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.nfcUtil.n(NfcUtil.TriggerMode.ONCE);
        this.nfcUtil.m(30000);
        this.nfcUtil.g(this, new C1101a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311138316")) {
            ipChange.ipc$dispatch("311138316", new Object[]{this});
            return;
        }
        db1.a(this.TAG, "MainActivity::onDestroy() --");
        super.onDestroy();
        pauseNfc(true);
    }

    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31268254")) {
            return ((Boolean) ipChange.ipc$dispatch("-31268254", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            pauseNfc(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785009689")) {
            ipChange.ipc$dispatch("-1785009689", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        String str = this.TAG;
        db1.a(str, "MainActivity::onNewIntent() --" + intent.getAction());
        this.nfcUtil.i(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083979056")) {
            ipChange.ipc$dispatch("-2083979056", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468945207")) {
            ipChange.ipc$dispatch("1468945207", new Object[]{this});
            return;
        }
        db1.a(this.TAG, "MainActivity::onResume() --");
        super.onResume();
        this.nfcUtil.k();
    }
}
