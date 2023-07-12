package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class g52 {
    private static transient /* synthetic */ IpChange $ipChange;
    public final int[] a = new int[2];

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738544346")) {
            return ((Integer) ipChange.ipc$dispatch("-1738544346", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        try {
            String hexString = Integer.toHexString(i);
            if (hexString == null || hexString.length() < 6) {
                return i;
            }
            String substring = hexString.substring(hexString.length() - 6, hexString.length());
            return Color.parseColor("#33" + substring);
        } catch (Exception unused) {
            return i;
        }
    }

    public final void b(Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688315789")) {
            ipChange.ipc$dispatch("1688315789", new Object[]{this, shape});
        } else if (shape != null) {
            try {
                d(this.a, shape);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-704200021")) {
            return ((Integer) ipChange.ipc$dispatch("-704200021", new Object[]{this, str})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public abstract void d(@NonNull int[] iArr, @NonNull Shape shape);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1646863299")) {
            ipChange.ipc$dispatch("-1646863299", new Object[]{this, shape});
        } else if (shape != null) {
            int[] iArr = this.a;
            iArr[0] = shape.fillColor;
            iArr[1] = shape.strokeColor;
        }
    }
}
