package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.taobao.weex.ui.animation.TransformParser;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x10 {
    public static final int METHOD_ROTATE = 4;
    public static final int METHOD_ROTATE_Z = 5;
    public static final int METHOD_SCALE = 6;
    public static final int METHOD_SCALE_X = 7;
    public static final int METHOD_SCALE_Y = 8;
    public static final int METHOD_TRANSLATE = 0;
    public static final int METHOD_TRANSLATE_3D = 1;
    public static final int METHOD_TRANSLATE_X = 2;
    public static final int METHOD_TRANSLATE_Y = 3;

    /* compiled from: Taobao */
    /* renamed from: tb.x10$a */
    /* loaded from: classes11.dex */
    public static class C9898a {
        public int a;
        public float[] b;

        public C9898a(int i, float[] fArr) {
            this.a = i;
            this.b = fArr;
        }

        public String toString() {
            return "TransformProp{method=" + this.a + ", args=" + Arrays.toString(this.b) + '}';
        }
    }

    private static int a(String str) {
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1840653217:
                    if (str.equals("translate3d")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1721943862:
                    if (str.equals("translateX")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1721943861:
                    if (str.equals("translateY")) {
                        c = 2;
                        break;
                    }
                    break;
                case -925180581:
                    if (str.equals("rotate")) {
                        c = 3;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = 4;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = 5;
                        break;
                    }
                    break;
                case 109250890:
                    if (str.equals("scale")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1052832078:
                    if (str.equals("translate")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1384173151:
                    if (str.equals(TransformParser.WX_ROTATE_Z)) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 7;
                case 5:
                    return 8;
                case 6:
                    return 6;
                case 7:
                    return 0;
                case '\b':
                    return 5;
                default:
                    throw new IllegalArgumentException("Invalid Transform method: " + str);
            }
        }
        throw new IllegalArgumentException("Invalid Transform method: " + str);
    }

    @Nullable
    public static List<C9898a> b(@Nullable String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        float[] fArr = new float[3];
        Arrays.fill(fArr, Float.NaN);
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == ' ') {
                i++;
            } else if (z) {
                if (!z) {
                    continue;
                } else if (charAt == ',') {
                    float c = c(str.substring(i, i4).trim(), i2, i3);
                    if (i3 < 3) {
                        fArr[i3] = c;
                        i3++;
                        i = i4 + 1;
                    } else {
                        throw new IllegalArgumentException("Invalid Transform args, too many args: " + str);
                    }
                } else if (charAt == ')') {
                    float c2 = c(str.substring(i, i4).trim(), i2, i3);
                    if (i3 < 3) {
                        fArr[i3] = c2;
                        linkedList.add(new C9898a(i2, fArr));
                        float[] fArr2 = new float[3];
                        Arrays.fill(fArr2, Float.NaN);
                        i = i4 + 1;
                        fArr = fArr2;
                        z = false;
                        i2 = -1;
                        i3 = 0;
                    } else {
                        throw new IllegalArgumentException("Invalid Transform args, too many args: " + str);
                    }
                } else {
                    continue;
                }
            } else if (charAt == '(') {
                i2 = a(str.substring(i, i4).trim());
                i = i4 + 1;
                z = true;
            }
        }
        LinkedList linkedList2 = linkedList.isEmpty() ? null : linkedList;
        if (linkedList2 != null || TextUtils.isEmpty(str.trim())) {
            return linkedList2;
        }
        throw new IllegalArgumentException("Invalid Transform format: " + str);
    }

    private static float c(String str, int i, int i2) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return Float.parseFloat(str);
            case 4:
            case 5:
                if (str.endsWith("deg")) {
                    return Float.parseFloat(str.substring(0, str.length() - 3));
                }
                throw new IllegalArgumentException("Invalid Transform deg arg: " + str);
            case 6:
            case 7:
            case 8:
                return Float.parseFloat(str);
            default:
                throw new IllegalArgumentException("Invalid Transform method: " + i);
        }
    }
}
