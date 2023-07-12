package com.taobao.mass;

import androidx.annotation.Keep;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class MassService$$IPCProxy implements IServiceProxy {
    private MassService object;

    private String convert(String str) {
        return (str == null || str.length() == 0) ? str : str.replace('.', '$');
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public void create(String str, Object... objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("getInstance()")) {
            MassService massService = MassService.getInstance();
            this.object = massService;
            if (massService == null) {
                throw new IPCException(25, "MassService object is null");
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
            case -1514153671:
                if (convert.equals("registerTopic(java$lang$String,java$lang$String)")) {
                    c = 0;
                    break;
                }
                break;
            case -870872096:
                if (convert.equals("getTopicsByService(java$lang$String)")) {
                    c = 1;
                    break;
                }
                break;
            case -446107182:
                if (convert.equals("unregisterTopic(java$lang$String,java$lang$String)")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                synchronized (MassService.class) {
                    this.object.registerTopic((String) objArr[0], (String) objArr[1]);
                }
                return null;
            case 1:
                return this.object.getTopicsByService((String) objArr[0]);
            case 2:
                synchronized (MassService.class) {
                    this.object.unregisterTopic((String) objArr[0], (String) objArr[1]);
                }
                return null;
            default:
                throw new IPCException(12, "can't find methodId");
        }
    }
}
