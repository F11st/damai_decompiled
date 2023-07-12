package cn.damai.ticket.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.media.MessageID;
import tb.pk1;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class NfcUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String[][] i;
    private static IntentFilter[] j;
    private Activity a;
    private NfcAdapter b;
    private PendingIntent c;
    private boolean d;
    private ReadCallback f;
    private CountDownTimerC2010a g;
    private TriggerMode e = TriggerMode.ALWAYS;
    private int h = 60000;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ReadCallback {
        void onReadError(int i, String str);

        void onReadOvertime();

        void onReadSuccess(pk1 pk1Var);
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public enum TriggerMode {
        ONCE,
        ALWAYS
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticket.nfc.NfcUtil$a */
    /* loaded from: classes16.dex */
    private class CountDownTimerC2010a extends CountDownTimer {
        public CountDownTimerC2010a(long j) {
            super(j, j);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Log.i("nfc", "once read overtime");
            NfcUtil.this.d = false;
            if (NfcUtil.this.f != null) {
                NfcUtil.this.f.onReadOvertime();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    static {
        try {
            i = new String[][]{new String[]{NfcA.class.getName()}, new String[]{NfcB.class.getName()}, new String[]{Ndef.class.getName()}, new String[]{MifareClassic.class.getName()}, new String[]{IsoDep.class.getName()}, new String[]{NfcBarcode.class.getName()}, new String[]{MifareUltralight.class.getName()}, new String[]{NfcV.class.getName()}, new String[]{NfcF.class.getName()}, new String[]{NdefFormatable.class.getName()}};
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            try {
                intentFilter.addDataType(IRequestConst.CONTENT_TYPE_TEXT_PLAIN);
            } catch (IntentFilter.MalformedMimeTypeException e) {
                e.printStackTrace();
            }
            IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*");
            intentFilter2.addCategory("android.intent.category.DEFAULT");
            IntentFilter intentFilter3 = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            intentFilter3.addCategory("android.intent.category.DEFAULT");
            j = new IntentFilter[]{intentFilter, intentFilter2, intentFilter3};
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125149782")) {
            ipChange.ipc$dispatch("-125149782", new Object[]{this});
            return;
        }
        try {
            NfcAdapter nfcAdapter = this.b;
            if (nfcAdapter != null) {
                nfcAdapter.disableForegroundDispatch(this.a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992765793")) {
            ipChange.ipc$dispatch("992765793", new Object[]{this});
            return;
        }
        try {
            NfcAdapter nfcAdapter = this.b;
            if (nfcAdapter != null) {
                nfcAdapter.enableForegroundDispatch(this.a, this.c, j, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l(C2012b c2012b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1515480293")) {
            ipChange.ipc$dispatch("-1515480293", new Object[]{this, c2012b});
        } else if (c2012b.a) {
            this.f.onReadSuccess(c2012b.d);
        } else {
            this.f.onReadError(c2012b.c, c2012b.b);
        }
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321599892")) {
            return ((Boolean) ipChange.ipc$dispatch("-1321599892", new Object[]{this})).booleanValue();
        }
        NfcAdapter nfcAdapter = this.b;
        if (nfcAdapter == null) {
            return false;
        }
        return nfcAdapter.isEnabled();
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "693143548") ? ((Boolean) ipChange.ipc$dispatch("693143548", new Object[]{this})).booleanValue() : this.b != null;
    }

    public void g(Activity activity, ReadCallback readCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655143162")) {
            ipChange.ipc$dispatch("-1655143162", new Object[]{this, activity, readCallback});
            return;
        }
        Log.i("nfc", "onCreate");
        this.a = activity;
        this.f = readCallback;
        this.b = NfcAdapter.getDefaultAdapter(activity);
        this.c = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()), 0);
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998485327")) {
            ipChange.ipc$dispatch("-998485327", new Object[]{this});
        } else if (this.e == TriggerMode.ONCE) {
            this.d = false;
            CountDownTimerC2010a countDownTimerC2010a = this.g;
            if (countDownTimerC2010a != null) {
                countDownTimerC2010a.cancel();
            }
        }
    }

    public void i(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829310388")) {
            ipChange.ipc$dispatch("-1829310388", new Object[]{this, intent});
            return;
        }
        Log.i("nfc", "onNewIntent");
        if (TextUtils.equals(intent.getAction(), "android.nfc.action.TECH_DISCOVERED")) {
            if (this.e == TriggerMode.ONCE) {
                if (this.d) {
                    C2012b e = C2011a.e(intent);
                    CountDownTimerC2010a countDownTimerC2010a = this.g;
                    if (countDownTimerC2010a != null) {
                        countDownTimerC2010a.cancel();
                    }
                    this.d = false;
                    l(e);
                    return;
                }
                Log.i("nfc", "once mode,not operate");
                return;
            }
            l(C2011a.e(intent));
            return;
        }
        Log.i("nfc", "not nfc ticket");
        C2012b c2012b = new C2012b();
        c2012b.a = false;
        c2012b.c = 6;
        c2012b.b = "not nfc intent";
        this.f.onReadError(6, "not nfc intent");
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065492661")) {
            ipChange.ipc$dispatch("1065492661", new Object[]{this});
            return;
        }
        Log.i("nfc", MessageID.onPause);
        c();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318320626")) {
            ipChange.ipc$dispatch("318320626", new Object[]{this});
            return;
        }
        Log.i("nfc", "onResume");
        d();
    }

    public void m(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929612176")) {
            ipChange.ipc$dispatch("-929612176", new Object[]{this, Integer.valueOf(i2)});
        } else {
            this.h = i2;
        }
    }

    public void n(TriggerMode triggerMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997997252")) {
            ipChange.ipc$dispatch("1997997252", new Object[]{this, triggerMode});
        } else {
            this.e = triggerMode;
        }
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114138285")) {
            ipChange.ipc$dispatch("-1114138285", new Object[]{this});
            return;
        }
        Log.i("nfc", "startOnceRead");
        if (this.e == TriggerMode.ONCE && !this.d) {
            this.d = true;
            CountDownTimerC2010a countDownTimerC2010a = new CountDownTimerC2010a(this.h);
            this.g = countDownTimerC2010a;
            countDownTimerC2010a.start();
            return;
        }
        Log.i("nfc", "use startOnceRead,should set trigger mode ALWAYS");
    }
}
