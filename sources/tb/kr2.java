package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final /* synthetic */ class kr2 {
    static {
        String str = TypedValues.Position.NAME;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 501;
            case 1:
                return 503;
            case 2:
                return 504;
            case 3:
                return 502;
            case 4:
                return 505;
            case 5:
                return TypedValues.Position.TYPE_PERCENT_X;
            case 6:
                return TypedValues.Position.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }
}
