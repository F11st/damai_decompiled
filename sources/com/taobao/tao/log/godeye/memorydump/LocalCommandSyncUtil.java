package com.taobao.tao.log.godeye.memorydump;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.tao.log.godeye.api.control.AbsCommandController;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LocalCommandSyncUtil {
    private final String mConfigGroup;
    private final Context mContext;

    public LocalCommandSyncUtil(Context context, String str) {
        this.mConfigGroup = str;
        this.mContext = context;
    }

    public String getRawCommandString(AbsCommandController absCommandController) {
        return this.mContext.getSharedPreferences(this.mConfigGroup, 0).getString(absCommandController.opCode, null);
    }

    public void removeLocalCommand(AbsCommandController absCommandController) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(this.mConfigGroup, 0).edit();
        edit.remove(absCommandController.opCode);
        edit.apply();
    }

    public void saveRawCommandString(AbsCommandController absCommandController, String str) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(this.mConfigGroup, 0).edit();
        edit.putString(absCommandController.opCode, str);
        edit.apply();
    }
}
