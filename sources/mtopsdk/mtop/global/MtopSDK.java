package mtopsdk.mtop.global;

import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class MtopSDK {
    @Deprecated
    public static void checkMtopSDKInit() {
        Mtop.instance(null).checkMtopSDKInit();
    }

    @Deprecated
    public static void setLogSwitch(boolean z) {
        Mtop.instance(null).logSwitch(z);
    }
}
