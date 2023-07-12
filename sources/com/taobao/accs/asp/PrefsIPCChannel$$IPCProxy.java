package com.taobao.accs.asp;

import androidx.annotation.Keep;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class PrefsIPCChannel$$IPCProxy implements IServiceProxy {
    private PrefsIPCChannel object;

    private String convert(String str) {
        return (str == null || str.length() == 0) ? str : str.replace('.', '$');
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public void create(String str, Object... objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("getInstance()")) {
            PrefsIPCChannel prefsIPCChannel = PrefsIPCChannel.getInstance();
            this.object = prefsIPCChannel;
            if (prefsIPCChannel == null) {
                throw new IPCException(25, "PrefsIPCChannel object is null");
            }
            return;
        }
        throw new IPCException(16, "can't find constructorId");
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public Object invoke(String str, Object[] objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("commitToDiskRemote(com$taobao$accs$asp$ModifiedRecord)")) {
            this.object.commitToDiskRemote((ModifiedRecord) objArr[0]);
            return null;
        } else if (convert.equals("registerDataListenerRemote(java$lang$String,com$taobao$accs$asp$OnDataUpdateListener)")) {
            this.object.registerDataListenerRemote((String) objArr[0], (OnDataUpdateListener) objArr[1]);
            return null;
        } else {
            throw new IPCException(12, "can't find methodId");
        }
    }
}
