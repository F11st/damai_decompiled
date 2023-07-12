package cn.damai.login.loginaccs;

import android.content.Intent;
import android.os.IBinder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class LoginAccsService extends TaoBaseService {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163624752")) {
            return (IBinder) ipChange.ipc$dispatch("-163624752", new Object[]{this, intent});
        }
        return null;
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251537512")) {
            ipChange.ipc$dispatch("1251537512", new Object[]{this, str, Integer.valueOf(i), extraInfo});
        }
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234004751")) {
            ipChange.ipc$dispatch("-234004751", new Object[]{this});
        } else {
            super.onCreate();
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661595319")) {
            ipChange.ipc$dispatch("-1661595319", new Object[]{this, str, str2, str3, bArr, extraInfo});
        }
    }

    @Override // com.taobao.accs.base.TaoBaseService, android.app.Service
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427974723")) {
            ipChange.ipc$dispatch("1427974723", new Object[]{this});
        } else {
            super.onDestroy();
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898257479")) {
            ipChange.ipc$dispatch("898257479", new Object[]{this, str, str2, Integer.valueOf(i), bArr, extraInfo});
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968370435")) {
            ipChange.ipc$dispatch("-968370435", new Object[]{this, str, str2, Integer.valueOf(i), extraInfo});
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2014308847")) {
            ipChange.ipc$dispatch("2014308847", new Object[]{this, str, Integer.valueOf(i), extraInfo});
        }
    }
}
