package tb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import cn.damai.member.R$drawable;
import cn.damai.ticklet.ui.activity.TickletListActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class sn2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-131352955")) {
            ipChange.ipc$dispatch("-131352955", new Object[]{context});
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 25) {
                ArrayList arrayList = new ArrayList();
                Intent intent = new Intent();
                intent.setClass(context, TickletListActivity.class);
                intent.setAction("from_3dtouch");
                arrayList.add(new ShortcutInfo.Builder(context, "ticklet").setShortLabel("大麦票夹").setLongLabel("打开「票夹」").setIcon(Icon.createWithResource(context, R$drawable.ticklet_touch_logo)).setIntents(new Intent[]{intent}).build());
                ((ShortcutManager) context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
