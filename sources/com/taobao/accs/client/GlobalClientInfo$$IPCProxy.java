package com.taobao.accs.client;

import android.content.Context;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import java.util.Map;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class GlobalClientInfo$$IPCProxy implements IServiceProxy {
    private GlobalClientInfo object;

    private String convert(String str) {
        return (str == null || str.length() == 0) ? str : str.replace('.', '$');
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public void create(String str, Object... objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("getInstance(android$content$Context)")) {
            GlobalClientInfo globalClientInfo = GlobalClientInfo.getInstance((Context) objArr[0]);
            this.object = globalClientInfo;
            if (globalClientInfo == null) {
                throw new IPCException(25, "GlobalClientInfo object is null");
            }
            return;
        }
        throw new IPCException(16, "can't find constructorId");
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public Object invoke(String str, Object[] objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        char c = 65535;
        switch (convert.hashCode()) {
            case -2054296132:
                if (convert.equals("setRemoteAppReceiver(java$lang$String,com$taobao$accs$IAppReceiver)")) {
                    c = 0;
                    break;
                }
                break;
            case -633089731:
                if (convert.equals("registerAllRemoteService(java$lang$String,java$util$Map)")) {
                    c = 1;
                    break;
                }
                break;
            case -346277262:
                if (convert.equals("unregisterRemoteListener(java$lang$String)")) {
                    c = 2;
                    break;
                }
                break;
            case 718269401:
                if (convert.equals("registerRemoteService(java$lang$String,java$lang$String)")) {
                    c = 3;
                    break;
                }
                break;
            case 1034767215:
                if (convert.equals("unregisterRemoteService(java$lang$String)")) {
                    c = 4;
                    break;
                }
                break;
            case 1658516353:
                if (convert.equals("registerRemoteListener(java$lang$String,com$taobao$accs$base$AccsDataListener)")) {
                    c = 5;
                    break;
                }
                break;
            case 1723207683:
                if (convert.equals("setRemoteAgooAppReceiver(com$taobao$accs$IAgooAppReceiver)")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.object.setRemoteAppReceiver((String) objArr[0], (IAppReceiver) objArr[1]);
                return null;
            case 1:
                this.object.registerAllRemoteService((String) objArr[0], (Map) objArr[1]);
                return null;
            case 2:
                this.object.unregisterRemoteListener((String) objArr[0]);
                return null;
            case 3:
                this.object.registerRemoteService((String) objArr[0], (String) objArr[1]);
                return null;
            case 4:
                this.object.unregisterRemoteService((String) objArr[0]);
                return null;
            case 5:
                this.object.registerRemoteListener((String) objArr[0], (AccsDataListener) objArr[1]);
                return null;
            case 6:
                this.object.setRemoteAgooAppReceiver((IAgooAppReceiver) objArr[0]);
                return null;
            default:
                throw new IPCException(12, "can't find methodId");
        }
    }
}
