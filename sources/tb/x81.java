package tb;

import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x81 implements VrParamsProvider {
    @Override // com.google.vr.cardboard.VrParamsProvider
    public final void close() {
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final CardboardDevice.DeviceParams readDeviceParams() {
        return com.google.vr.cardboard.a.b();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Phone.PhoneParams readPhoneParams() {
        Phone.PhoneParams e = com.google.vr.cardboard.a.e();
        return e == null ? gs1.a() : e;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.a aVar) {
        return null;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Preferences.UserPrefs readUserPrefs() {
        return null;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final boolean updateUserPrefs(Preferences.UserPrefs userPrefs) {
        return false;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        if (deviceParams == null) {
            return com.google.vr.cardboard.a.f();
        }
        return com.google.vr.cardboard.a.g(deviceParams);
    }
}
