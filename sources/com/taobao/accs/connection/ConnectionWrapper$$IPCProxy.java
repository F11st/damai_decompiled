package com.taobao.accs.connection;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.data.Message;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IServiceProxy;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class ConnectionWrapper$$IPCProxy implements IServiceProxy {
    private ConnectionWrapper object;

    private String convert(String str) {
        return (str == null || str.length() == 0) ? str : str.replace('.', '$');
    }

    @Override // com.taobao.aranger.intf.IServiceProxy
    public void create(String str, Object... objArr) throws Exception {
        String convert = convert(str);
        convert.hashCode();
        if (convert.equals("ConnectionWrapper(com$taobao$accs$AccsClientConfig,int)")) {
            this.object = new ConnectionWrapper((AccsClientConfig) objArr[0], ((Integer) objArr[1]).intValue());
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
            case -2141225700:
                if (convert.equals("setAppkey(java$lang$String)")) {
                    c = 0;
                    break;
                }
                break;
            case -2102943859:
                if (convert.equals("getSendBackState()")) {
                    c = 1;
                    break;
                }
                break;
            case -2011116120:
                if (convert.equals("isAppUnbinded(java$lang$String)")) {
                    c = 2;
                    break;
                }
                break;
            case -1897187101:
                if (convert.equals("start()")) {
                    c = 3;
                    break;
                }
                break;
            case -1675444951:
                if (convert.equals("setSendBackState(boolean)")) {
                    c = 4;
                    break;
                }
                break;
            case -1225302783:
                if (convert.equals("send(com$taobao$accs$data$Message,boolean)")) {
                    c = 5;
                    break;
                }
                break;
            case -1127859174:
                if (convert.equals("getHost(java$lang$String)")) {
                    c = 6;
                    break;
                }
                break;
            case -1038583915:
                if (convert.equals("getAppkey()")) {
                    c = 7;
                    break;
                }
                break;
            case -1022319506:
                if (convert.equals("onResult(com$taobao$accs$data$Message,int)")) {
                    c = '\b';
                    break;
                }
                break;
            case -996504267:
                if (convert.equals("startChannelService()")) {
                    c = '\t';
                    break;
                }
                break;
            case -775164165:
                if (convert.equals("ping(boolean,boolean)")) {
                    c = '\n';
                    break;
                }
                break;
            case -633482557:
                if (convert.equals("getConfigTag()")) {
                    c = 11;
                    break;
                }
                break;
            case -504213164:
                if (convert.equals("isUserBinded(java$lang$String,java$lang$String)")) {
                    c = '\f';
                    break;
                }
                break;
            case 36976441:
                if (convert.equals("setTTid(java$lang$String)")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 188866482:
                if (convert.equals("registerConnectStateListener(com$taobao$accs$base$AccsConnectStateListener)")) {
                    c = 14;
                    break;
                }
                break;
            case 314439232:
                if (convert.equals("isConnected()")) {
                    c = 15;
                    break;
                }
                break;
            case 321351798:
                if (convert.equals("setForeBackState(int)")) {
                    c = 16;
                    break;
                }
                break;
            case 574409679:
                if (convert.equals("isAppBinded(java$lang$String)")) {
                    c = 17;
                    break;
                }
                break;
            case 866534649:
                if (convert.equals("close()")) {
                    c = 18;
                    break;
                }
                break;
            case 1053612988:
                if (convert.equals("getAppSecret()")) {
                    c = 19;
                    break;
                }
                break;
            case 1449009556:
                if (convert.equals("sendMessage(com$taobao$accs$data$Message)")) {
                    c = 20;
                    break;
                }
                break;
            case 1506924377:
                if (convert.equals("unRegisterConnectStateListener(com$taobao$accs$base$AccsConnectStateListener)")) {
                    c = 21;
                    break;
                }
                break;
            case 1546071414:
                if (convert.equals("cancel(java$lang$String)")) {
                    c = 22;
                    break;
                }
                break;
            case 1630380942:
                if (convert.equals("updateConfig(com$taobao$accs$AccsClientConfig)")) {
                    c = 23;
                    break;
                }
                break;
            case 1682029863:
                if (convert.equals("getStoreId()")) {
                    c = 24;
                    break;
                }
                break;
            case 1965943909:
                if (convert.equals("getTag()")) {
                    c = 25;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.object.setAppkey((String) objArr[0]);
                return null;
            case 1:
                return Boolean.valueOf(this.object.getSendBackState());
            case 2:
                return Boolean.valueOf(this.object.isAppUnbinded((String) objArr[0]));
            case 3:
                this.object.start();
                return null;
            case 4:
                this.object.setSendBackState(((Boolean) objArr[0]).booleanValue());
                return null;
            case 5:
                this.object.send((Message) objArr[0], ((Boolean) objArr[1]).booleanValue());
                return null;
            case 6:
                return this.object.getHost((String) objArr[0]);
            case 7:
                return this.object.getAppkey();
            case '\b':
                this.object.onResult((Message) objArr[0], ((Integer) objArr[1]).intValue());
                return null;
            case '\t':
                this.object.startChannelService();
                return null;
            case '\n':
                this.object.ping(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                return null;
            case 11:
                return this.object.getConfigTag();
            case '\f':
                return Boolean.valueOf(this.object.isUserBinded((String) objArr[0], (String) objArr[1]));
            case '\r':
                this.object.setTTid((String) objArr[0]);
                return null;
            case 14:
                this.object.registerConnectStateListener((AccsConnectStateListener) objArr[0]);
                return null;
            case 15:
                return Boolean.valueOf(this.object.isConnected());
            case 16:
                this.object.setForeBackState(((Integer) objArr[0]).intValue());
                return null;
            case 17:
                return Boolean.valueOf(this.object.isAppBinded((String) objArr[0]));
            case 18:
                this.object.close();
                return null;
            case 19:
                return this.object.getAppSecret();
            case 20:
                this.object.sendMessage((Message) objArr[0]);
                return null;
            case 21:
                this.object.unRegisterConnectStateListener((AccsConnectStateListener) objArr[0]);
                return null;
            case 22:
                return Boolean.valueOf(this.object.cancel((String) objArr[0]));
            case 23:
                this.object.updateConfig((AccsClientConfig) objArr[0]);
                return null;
            case 24:
                return this.object.getStoreId();
            case 25:
                return this.object.getTag();
            default:
                throw new IPCException(12, "can't find methodId");
        }
    }
}
