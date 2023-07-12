package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ChannelConnectionImpl$$IPCProxy implements IServiceProxy {
    private ChannelConnectionImpl object;

    private String convert(String str) {
        return (str == null || str.length() == 0) ? str : str.replace('.', '$');
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public void create(String str, Object... objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("ChannelConnectionImpl()")) {
            this.object = new ChannelConnectionImpl();
            return;
        }
        throw new IPCException(16, "can't find constructorId");
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public Object invoke(String str, Object[] objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("start(java$lang$String,int,com$taobao$accs$connection$IChannelConnListener)")) {
            this.object.start((String) objArr[0], ((Integer) objArr[1]).intValue(), (IChannelConnListener) objArr[2]);
            return null;
        }
        throw new IPCException(12, "can't find methodId");
    }
}
