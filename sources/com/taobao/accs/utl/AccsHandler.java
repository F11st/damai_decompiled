package com.taobao.accs.utl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsHandler {
    public static final String TAG = "AccsHandler";
    private static Handler handler = new Handler(Looper.getMainLooper());

    private static void exeCallback(String str, Runnable runnable) {
        if (!Constants.IMPAAS.equals(str) && !GlobalClientInfo.AGOO_SERVICE_ID.equals(str)) {
            handler.post(runnable);
        } else {
            ThreadPoolExecutorFactory.executeCallback(runnable);
        }
    }

    private static Map<TaoBaseService.ExtHeaderType, String> getExtHeader(Map<Integer, String> map) {
        HashMap hashMap;
        TaoBaseService.ExtHeaderType[] values;
        HashMap hashMap2 = null;
        if (map == null) {
            return null;
        }
        try {
            hashMap = new HashMap();
        } catch (Exception e) {
            e = e;
        }
        try {
            for (TaoBaseService.ExtHeaderType extHeaderType : TaoBaseService.ExtHeaderType.values()) {
                String str = map.get(Integer.valueOf(extHeaderType.ordinal()));
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(extHeaderType, str);
                }
            }
            return hashMap;
        } catch (Exception e2) {
            e = e2;
            hashMap2 = hashMap;
            ALog.e(TAG, "getExtHeader", e, new Object[0]);
            return hashMap2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TaoBaseService.ExtraInfo getExtraInfo(Intent intent) {
        TaoBaseService.ExtraInfo extraInfo = new TaoBaseService.ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService.ExtraInfo.EXT_HEADER);
            Map<TaoBaseService.ExtHeaderType, String> extHeader = getExtHeader(hashMap);
            String stringExtra = intent.getStringExtra("packageName");
            String stringExtra2 = intent.getStringExtra("host");
            extraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            extraInfo.extHeader = extHeader;
            extraInfo.oriExtHeader = hashMap;
            extraInfo.fromPackage = stringExtra;
            extraInfo.fromHost = stringExtra2;
        } catch (Throwable th) {
            ALog.e(TAG, "getExtraInfo", th, new Object[0]);
        }
        return extraInfo;
    }

    public static NetPerformanceMonitor getPref(Intent intent) {
        try {
            intent.getExtras().setClassLoader(NetPerformanceMonitor.class.getClassLoader());
            return (NetPerformanceMonitor) intent.getExtras().getSerializable("monitor");
        } catch (Exception e) {
            ALog.e(TAG, "get NetPerformanceMonitor Error:", e, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPrintLog(String str) {
        return ALog.isPrintLog(ALog.Level.D) || Constants.IMPAAS.equals(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[Catch: Exception -> 0x027e, all -> 0x0289, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x027e, blocks: (B:20:0x0084, B:33:0x00f4, B:34:0x00fe, B:35:0x0128, B:38:0x0150, B:39:0x015a, B:40:0x016b, B:42:0x0178, B:44:0x017e, B:45:0x019f, B:47:0x01a5, B:51:0x01d2, B:52:0x01dc, B:53:0x0207, B:17:0x0054), top: B:81:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026f A[Catch: Exception -> 0x027c, all -> 0x0289, TRY_LEAVE, TryCatch #1 {Exception -> 0x027c, blocks: (B:55:0x0217, B:56:0x021c, B:58:0x022e, B:59:0x0244, B:60:0x0255, B:61:0x0262, B:62:0x026f), top: B:83:0x0082 }] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int onReceiveData(android.content.Context r26, final android.content.Intent r27, final com.taobao.accs.base.AccsDataListener r28) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.AccsHandler.onReceiveData(android.content.Context, android.content.Intent, com.taobao.accs.base.AccsDataListener):int");
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra("host");
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra("target");
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.sendBusinessAck(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                } else {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "sendBusinessAck", th, new Object[0]);
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, th.toString(), 0.0d);
        }
    }
}
