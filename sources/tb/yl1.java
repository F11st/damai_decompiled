package tb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.apk.MainUpdateData;
import com.taobao.update.framework.Processor;
import com.taobao.update.framework.UpdateRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yl1 implements Processor<ApkUpdateContext> {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        private static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String format = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.getDefault()).format(new Date());
            return str + format;
        }

        public static void clear(String str) {
            SharedPreferences.Editor edit = getDatabase().edit();
            String a = a(str);
            edit.clear();
            edit.putInt(a, 0);
            edit.commit();
        }

        public static int get(String str) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return getDatabase().getInt(a(str), -1);
        }

        public static SharedPreferences getDatabase() {
            return UpdateRuntime.getContext().getSharedPreferences("notification_record", 0);
        }

        public static void update(String str, int i) {
            if (TextUtils.isEmpty(str) || i <= 0) {
                return;
            }
            int i2 = get(str);
            SharedPreferences.Editor edit = getDatabase().edit();
            String a = a(str);
            if (i2 <= 0) {
                edit.clear();
                edit.putInt(a, 1);
            } else if (i2 < i) {
                edit.putInt(a, i2 + 1);
            }
            edit.commit();
        }
    }

    @Override // com.taobao.update.framework.Processor
    public void execute(ApkUpdateContext apkUpdateContext) {
        if (apkUpdateContext.skipUpdate()) {
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = -53;
        } else if (apkUpdateContext.background && !apkUpdateContext.isForceUpdate()) {
            MainUpdateData mainUpdateData = apkUpdateContext.mainUpdate;
            int i = a.get(mainUpdateData.version);
            int i2 = mainUpdateData.remindCount;
            if (i2 > 0 && i < i2) {
                a.update(mainUpdateData.version, i2);
                return;
            }
            apkUpdateContext.success = false;
            apkUpdateContext.errorCode = -52;
            apkUpdateContext.exceedUpdateTimes = Boolean.TRUE;
        }
    }
}
