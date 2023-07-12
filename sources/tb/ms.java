package tb;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ms {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118536337")) {
            ipChange.ipc$dispatch("118536337", new Object[]{context, view, Boolean.valueOf(z)});
            return;
        }
        int[] iArr = z ? new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")} : new int[]{Color.parseColor("#FFF3E7"), Color.parseColor("#FFEBF0"), Color.parseColor("#FFE9F7"), Color.parseColor("#F0F1FE")};
        int a = q60.a(context, 2.0f);
        float a2 = q60.a(context, 15.0f);
        float f = a;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        gradientDrawable.setCornerRadii(new float[]{a2, a2, a2, a2, a2, a2, f, f});
        gradientDrawable.setStroke(q60.a(context, 0.5f), Color.parseColor("#0D000000"));
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(gradientDrawable);
        } else {
            view.setBackgroundDrawable(gradientDrawable);
        }
    }
}
