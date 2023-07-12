package com.taobao.tao.log.godeye.core.command;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.fastjson.JSON;
import com.taobao.tao.log.godeye.api.command.ICommandManager;
import com.taobao.tao.log.godeye.api.command.TraceTask;
import com.taobao.tao.log.godeye.api.control.AbsCommandController;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodeyeCommandManager implements ICommandManager {
    private static final String LOCAL_COMMAND_CONFIG_NAME = "godeye_command_config";
    private final Context mContext;

    public GodeyeCommandManager(Context context) {
        this.mContext = context;
    }

    @Override // com.taobao.tao.log.godeye.api.command.ICommandManager
    public TraceTask getRawCommandString(AbsCommandController absCommandController) {
        String string = this.mContext.getSharedPreferences(LOCAL_COMMAND_CONFIG_NAME, 0).getString(absCommandController.opCode, null);
        if (string != null) {
            try {
                return new TraceTask(JSON.parseObject(string));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.taobao.tao.log.godeye.api.command.ICommandManager
    public void removeLocalCommand(AbsCommandController absCommandController) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(LOCAL_COMMAND_CONFIG_NAME, 0).edit();
        edit.remove(absCommandController.opCode);
        edit.apply();
    }

    @Override // com.taobao.tao.log.godeye.api.command.ICommandManager
    public void saveRawCommandString(AbsCommandController absCommandController, TraceTask traceTask) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(LOCAL_COMMAND_CONFIG_NAME, 0).edit();
        try {
            edit.putString(absCommandController.opCode, JSON.toJSONString(traceTask));
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
