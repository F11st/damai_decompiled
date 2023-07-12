package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class gr1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, CharSequence charSequence, List<String> list, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1248726288")) {
            ipChange.ipc$dispatch("-1248726288", new Object[]{context, charSequence, list, Boolean.valueOf(z), onClickListener, onClickListener2});
            return;
        }
        try {
            DMThemeDialog.DMDialogTheme dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION;
            StringBuilder sb = new StringBuilder();
            String[] b = mr1.b(list);
            if (b != null && b.length > 0 && !TextUtils.isEmpty(b[0])) {
                sb.append("开启");
                for (int i = 0; i < b.length; i++) {
                    sb.append(b[i]);
                    if (i < b.length - 1) {
                        sb.append("、");
                    }
                }
                sb.append("权限");
                String str = b[0];
                char c = 65535;
                switch (str.hashCode()) {
                    case 661953:
                        if (str.equals("位置")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 745552:
                        if (str.equals("存储")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 830017:
                        if (str.equals("日历")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 970562:
                        if (str.equals("相机")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 36584224:
                        if (str.equals("通讯录")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_LOCATION;
                } else if (c == 1) {
                    dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION;
                } else if (c == 2) {
                    dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_PERMISSION_CAMERA;
                } else if (c == 3) {
                    dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_PERMISSION_CALENDAR;
                } else if (c == 4) {
                    dMDialogTheme = DMThemeDialog.DMDialogTheme.THEME_PERMISSION_CONTACTS;
                }
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(context);
            dMThemeDialog.r(dMDialogTheme);
            dMThemeDialog.k(charSequence);
            if (!TextUtils.isEmpty(sb.toString())) {
                dMThemeDialog.o(sb.toString());
            }
            if (!z) {
                dMThemeDialog.e("拒绝", onClickListener2);
            }
            dMThemeDialog.i("去开启", onClickListener);
            dMThemeDialog.f(false);
            dMThemeDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
