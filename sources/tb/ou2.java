package tb;

import android.text.TextUtils;
import com.taobao.update.datasource.UpdateDataSource;
import com.taobao.update.datasource.local.UpdateInfo;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ou2 {
    private boolean a;

    public void finishUpdate() {
        this.a = false;
    }

    public boolean isLocalDataValid(UpdateInfo updateInfo) {
        String config = UpdateDataSource.sUpdateAdapter.getConfig(lu2.UPDATE_CONFIG_GROUP, lu2.UPDATE_CACHE_HOUR, "3");
        long intValue = (TextUtils.isEmpty(config) || !TextUtils.isDigitsOnly(config)) ? 0L : Integer.valueOf(config).intValue() * 60 * 60 * 1000;
        return 0 != intValue && updateInfo != null && updateInfo.lastUpdateTime > 0 && pu2.getVersionName().equals(updateInfo.appVersion) && updateInfo.updateList.size() != 0 && System.currentTimeMillis() - updateInfo.lastUpdateTime < intValue;
    }

    public boolean isUpdating() {
        return this.a;
    }

    public void startUpdate() {
        this.a = true;
    }
}
