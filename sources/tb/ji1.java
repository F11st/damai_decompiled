package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ji1 extends vq {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Ticket";

    @Override // tb.vq
    protected String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "85275034") ? (String) ipChange.ipc$dispatch("85275034", new Object[]{this}) : c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r9.equals("isSupportNFC") == false) goto L14;
     */
    @Override // tb.vq, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r9, io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ji1.$ipChange
            java.lang.String r1 = "1230921152"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 3
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r2[r5] = r8
            r2[r4] = r9
            r2[r3] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L1a:
            java.lang.Object r0 = r9.arguments
            java.util.Map r0 = (java.util.Map) r0
            cn.damai.fluttercommon.DMBaseFlutterActivity r0 = r8.b()
            boolean r0 = r0 instanceof cn.damai.fluttercommon.DMNFCActivity
            r1 = 0
            if (r0 == 0) goto L32
            cn.damai.fluttercommon.DMBaseFlutterActivity r0 = r8.b()
            cn.damai.fluttercommon.DMNFCActivity r0 = (cn.damai.fluttercommon.DMNFCActivity) r0
            cn.damai.ticket.nfc.NfcUtil r0 = r0.getNfcUtil()
            goto L33
        L32:
            r0 = r1
        L33:
            if (r0 != 0) goto L39
            r10.success(r1)
            return
        L39:
            java.lang.String r9 = r9.method
            r9.hashCode()
            r2 = -1
            int r7 = r9.hashCode()
            switch(r7) {
                case -1200178928: goto L67;
                case 329759243: goto L5c;
                case 1557357606: goto L53;
                case 1924800629: goto L48;
                default: goto L46;
            }
        L46:
            r3 = -1
            goto L71
        L48:
            java.lang.String r3 = "launchTicketByNFC"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L51
            goto L46
        L51:
            r3 = 3
            goto L71
        L53:
            java.lang.String r4 = "isSupportNFC"
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L71
            goto L46
        L5c:
            java.lang.String r3 = "isNFCOpen"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L65
            goto L46
        L65:
            r3 = 1
            goto L71
        L67:
            java.lang.String r3 = "closeTicketByNFC"
            boolean r9 = r9.equals(r3)
            if (r9 != 0) goto L70
            goto L46
        L70:
            r3 = 0
        L71:
            java.lang.String r9 = "0"
            java.lang.String r2 = "1"
            switch(r3) {
                case 0: goto Lb3;
                case 1: goto L9b;
                case 2: goto L83;
                case 3: goto L7c;
                default: goto L78;
            }
        L78:
            r10.notImplemented()
            goto Lb9
        L7c:
            r0.o()
            r10.success(r1)
            goto Lb9
        L83:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            boolean r0 = r0.f()
            java.lang.String r3 = "isSupport"
            if (r0 != 0) goto L94
            r1.put(r3, r9)
            goto L97
        L94:
            r1.put(r3, r2)
        L97:
            r10.success(r1)
            goto Lb9
        L9b:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            boolean r0 = r0.e()
            java.lang.String r3 = "isOpen"
            if (r0 != 0) goto Lac
            r1.put(r3, r9)
            goto Laf
        Lac:
            r1.put(r3, r2)
        Laf:
            r10.success(r1)
            goto Lb9
        Lb3:
            r0.h()
            r10.success(r1)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ji1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
