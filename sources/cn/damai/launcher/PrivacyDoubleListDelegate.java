package cn.damai.launcher;

import android.content.Context;
import cn.damai.wantsee.StartConfig;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.mobsec.privacydoublelist.config.ConfigCenter;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public final class PrivacyDoubleListDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final PrivacyDoubleListDelegate INSTANCE = new PrivacyDoubleListDelegate();
    @Nullable
    private static PrivacyDoubleList a;
    @NotNull
    private static final Lazy b;

    static {
        Lazy b2;
        b2 = b.b(new Function0<Boolean>() { // from class: cn.damai.launcher.PrivacyDoubleListDelegate$isOpen$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "182074424") ? (Boolean) ipChange.ipc$dispatch("182074424", new Object[]{this}) : Boolean.valueOf(StartConfig.isOrangeOpenPrivacyDoubleListInit());
            }
        });
        b = b2;
    }

    private PrivacyDoubleListDelegate() {
    }

    public final void a(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758094611")) {
            ipChange.ipc$dispatch("758094611", new Object[]{this, context});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (isOpen()) {
            try {
                a = PrivacyDoubleList.getInstance();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(ConfigCenter.KEY_DEBUG, "1");
                ConfigCenter.getInstance().updateConfig(linkedHashMap);
                PrivacyDoubleList privacyDoubleList = a;
                if (privacyDoubleList != null) {
                    privacyDoubleList.init(context);
                }
            } catch (Throwable unused) {
                a = null;
            }
        }
    }

    public final void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091952563")) {
            ipChange.ipc$dispatch("1091952563", new Object[]{this});
            return;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(ConfigManager.SWITCH_KEY, "1");
            linkedHashMap.put(ConfigManager.CONFIG_KEY, "{\"v\":1,\"cid\":1,\"gc\":{\"sr\":0,\"dh\":\"0_0_0\",\"rs\":0},\"pr\":[{\"pn\":\"android.net.wifi.WifiInfo.getMacAddress()\",\"st\":[{\"rules\":[{\"rid\":51767,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52287,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.telephony.TelephonyManager.getDeviceId()\",\"st\":[{\"rules\":[{\"rid\":51764,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52321,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.telephony.TelephonyManager.getDeviceId(int)\",\"st\":[{\"rules\":[{\"rid\":51759,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":54112,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.telephony.TelephonyManager.getImei()\",\"st\":[{\"rules\":[{\"rid\":51763,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52286,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.telephony.TelephonyManager.getImei(int)\",\"st\":[{\"rules\":[{\"rid\":51758,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":54111,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.telephony.TelephonyManager.getSubscriberId()\",\"st\":[{\"rules\":[{\"rid\":51766,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52289,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.provider.Settings$Secure.getString(android.content.ContentResolver,java.lang.String)\",\"st\":[{\"rules\":[{\"rid\":51769,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":53566,\"act\":32,\"rs\":0,\"sr\":1,\"cond\":{\"arg\":{\"1\":\"android_id\"}},\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"java.net.NetworkInterface.getHardwareAddress()\",\"st\":[{\"rules\":[{\"rid\":51768,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52294,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.os.Build.getMODEL\",\"st\":[{\"rules\":[{\"rid\":51761,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52283,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.os.Build$VERSION.getRELEASE\",\"st\":[{\"rules\":[{\"rid\":51776,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52284,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"android.os.Build.getBRAND\",\"st\":[{\"rules\":[{\"rid\":51778,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52285,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]},{\"pn\":\"com.alibaba.openid.OpenDeviceId.getOAID(android.content.Context)\",\"st\":[{\"rules\":[{\"rid\":51771,\"act\":1,\"rs\":0,\"sr\":0,\"dh\":\"0_0_0\"},{\"rid\":52288,\"act\":32,\"rs\":0,\"sr\":1,\"modRet\":\"\",\"lmt\":0.0003472,\"crt\":1,\"dh\":\"1000_0_999\"}]}]}]}");
            linkedHashMap.put(ConfigManager.LOG_KEY, "1");
            ConfigManager.getInstance().onConfigChanged(linkedHashMap);
        } catch (Throwable unused) {
        }
    }

    public final boolean isOpen() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1746948693") ? ((Boolean) ipChange.ipc$dispatch("1746948693", new Object[]{this})).booleanValue() : ((Boolean) b.getValue()).booleanValue();
    }
}
