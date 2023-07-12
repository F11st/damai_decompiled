package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVACCSService extends TaoBaseService {
    private static final String TAG = "CallbackService";
    private Context mContext = null;

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.d(TAG, "onBind");
    }

    @Override // com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
        WVEventService.getInstance().onEvent(5002);
        TaoLog.d(TAG, "onConnected");
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        TaoLog.d(TAG, "onCreate");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "serviceId : " + str + " dataId :" + str3);
        }
        WVEventService.getInstance().onEvent(5001, str, bArr);
    }

    @Override // com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
        WVEventService.getInstance().onEvent(5003);
        TaoLog.d(TAG, "onDisconnected");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.d(TAG, "onResponse");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.d(TAG, "onSendData");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        TaoLog.d(TAG, "onCreate");
    }
}
