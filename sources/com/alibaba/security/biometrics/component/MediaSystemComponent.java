package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.Context;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.b.C3744c;
import com.alibaba.security.biometrics.b.InterfaceC3742a;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.C3818l;
import com.taobao.weex.annotation.JSMethod;
import java.util.Locale;

/* compiled from: Taobao */
@InterfaceC3773f
/* loaded from: classes8.dex */
public class MediaSystemComponent extends AbstractC3768a {
    protected InterfaceC3742a d;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.component.MediaSystemComponent$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ABDetectType.values().length];
            a = iArr;
            try {
                iArr[ABDetectType.BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ABDetectType.BLINK_STILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ABDetectType.MOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ABDetectType.MOUTH_STILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ABDetectType.POS_PITCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ABDetectType.PITCH_STILL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ABDetectType.POS_PITCH_UP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ABDetectType.POS_YAW.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ABDetectType.YAW_STILL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum AudioType {
        BLINK("rp_face_blink"),
        MOUTH("rp_face_open_mouth"),
        POS_PITCH_DOWN("rp_face_pitch_up"),
        POS_PITCH_UP("rp_face_pitch_up"),
        POS_YAW("rp_face_yaw_left_right"),
        DING("rp_face_ding");
        
        String resourceName;

        AudioType(String str) {
            this.resourceName = str;
        }

        private String getResourceName(String str) {
            if (Locale.getDefault().getLanguage().equals(Locale.CHINA.getLanguage())) {
                return str;
            }
            String language = Locale.getDefault().getLanguage();
            return str + JSMethod.NOT_SET + language;
        }

        public final int getRaw(Context context) {
            if (context == null) {
                return 0;
            }
            return context.getResources().getIdentifier(getResourceName(this.resourceName), "raw", C3818l.a(context));
        }
    }

    private void a(Activity activity) {
        try {
            if (this.d == null) {
                this.d = new C3744c(activity);
            }
        } catch (Exception unused) {
        }
    }

    private static AudioType b(ABDetectType aBDetectType) {
        switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                return AudioType.BLINK;
            case 3:
            case 4:
                return AudioType.MOUTH;
            case 5:
            case 6:
            case 7:
                return AudioType.POS_PITCH_DOWN;
            case 8:
                return AudioType.POS_PITCH_UP;
            case 9:
            case 10:
                return AudioType.POS_YAW;
            default:
                return null;
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean c() {
        InterfaceC3742a interfaceC3742a = this.d;
        if (interfaceC3742a != null) {
            interfaceC3742a.b();
            this.d = null;
        }
        return super.c();
    }

    public final void d() {
        InterfaceC3742a interfaceC3742a = this.d;
        if (interfaceC3742a != null) {
            interfaceC3742a.a();
        }
    }

    public final void a(boolean z) {
        InterfaceC3742a interfaceC3742a = this.d;
        if (interfaceC3742a != null) {
            interfaceC3742a.a(z);
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        try {
            if (this.d == null) {
                this.d = new C3744c(activity);
            }
        } catch (Exception unused) {
        }
        a(((AudioSettingComponent) C3772e.a(AudioSettingComponent.class)).d);
        return false;
    }

    public final void a(ABDetectType aBDetectType) {
        InterfaceC3742a interfaceC3742a;
        AudioType audioType;
        InterfaceC3742a interfaceC3742a2;
        if (aBDetectType == ABDetectType.AIMLESS || (interfaceC3742a = this.d) == null || interfaceC3742a.d()) {
            return;
        }
        switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
            case 1:
            case 2:
                audioType = AudioType.BLINK;
                break;
            case 3:
            case 4:
                audioType = AudioType.MOUTH;
                break;
            case 5:
            case 6:
            case 7:
                audioType = AudioType.POS_PITCH_DOWN;
                break;
            case 8:
                audioType = AudioType.POS_PITCH_UP;
                break;
            case 9:
            case 10:
                audioType = AudioType.POS_YAW;
                break;
            default:
                audioType = null;
                break;
        }
        if (audioType == null || (interfaceC3742a2 = this.d) == null) {
            return;
        }
        interfaceC3742a2.a(audioType);
    }
}
