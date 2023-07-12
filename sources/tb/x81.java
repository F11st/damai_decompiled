package tb;

import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.C5432a;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;
import com.google.vr.vrcore.nano.C5450a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class x81 implements VrParamsProvider {
    @Override // com.google.vr.cardboard.VrParamsProvider
    public final void close() {
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final CardboardDevice.DeviceParams readDeviceParams() {
        return C5432a.b();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Phone.PhoneParams readPhoneParams() {
        Phone.PhoneParams e = C5432a.e();
        return e == null ? gs1.a() : e;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams(C5450a c5450a) {
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
            return C5432a.f();
        }
        return C5432a.g(deviceParams);
    }
}
