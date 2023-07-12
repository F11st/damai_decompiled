package com.taobao.tao.log.task;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.request.LogConfigRequest;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogController;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.TLogUtils;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.utils.TLogMultiProcessTool;
import java.io.File;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogConfigRequestTask implements ICommandTask {
    private String TAG = "TLOG.LogConfigRequestTask";

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(CommandInfo commandInfo) {
        try {
            TLogEventHelper.event(TLogEventConst.UT_TLOG_CONFIG_RECEIVE);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "消息处理：请求修改日志配置消息");
            LogConfigRequest logConfigRequest = new LogConfigRequest();
            logConfigRequest.parse(commandInfo.data, commandInfo);
            Boolean bool = logConfigRequest.enable;
            Boolean bool2 = logConfigRequest.destroy;
            String str = logConfigRequest.level;
            String str2 = logConfigRequest.module;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(TLogInitializer.getInstance().getContext()).edit();
            edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_VERSION, TLogInitializer.getInstance().getAppVersion()).apply();
            if (bool2 != null && bool2.booleanValue()) {
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "消息处理：销毁日志");
                TLogController.getInstance().closeLog();
                TLogUtils.cleanDir(new File(TLogInitializer.getInstance().getFileDir()));
                edit.putBoolean(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY, true).apply();
            } else {
                edit.putBoolean(TLogConstant.REMOTE_DEBUGER_LOG_DESTROY, false).apply();
            }
            if (bool != null && !bool.booleanValue()) {
                TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
                String str3 = TLogStage.MSG_HANDLE;
                String str4 = this.TAG;
                tLogMonitor.stageError(str3, str4, "消息处理：日志开关 " + bool);
                TLogController.getInstance().closeLog();
                edit.putBoolean("tlog_switch", bool.booleanValue()).apply();
            }
            if (str != null) {
                TLogMonitor tLogMonitor2 = TLogInitializer.getInstance().gettLogMonitor();
                String str5 = TLogStage.MSG_HANDLE;
                String str6 = this.TAG;
                tLogMonitor2.stageError(str5, str6, "消息处理：日志级别修改 " + str);
                LogLevel convertLogLevel = TLogUtils.convertLogLevel(str);
                edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL, str).apply();
                TLogController.getInstance().setLogLevel(convertLogLevel);
                TLogMultiProcessTool.notifyProcessChangeLogLevel(convertLogLevel);
                TLogMonitor tLogMonitor3 = TLogInitializer.getInstance().gettLogMonitor();
                String str7 = TLogStage.MSG_HANDLE;
                String str8 = this.TAG;
                tLogMonitor3.stageError(str7, str8, "消息处理：日志级别修改完成:" + convertLogLevel.getName());
            }
            if ("off".equals(str2)) {
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "消息处理：log model关闭");
                TLogController.getInstance().cleanModuleFilter();
                edit.remove(TLogConstant.REMOTE_DEBUGER_LOG_MODULE).apply();
                TLogMultiProcessTool.notifyProcessChangeModuleLevel(str2);
            } else {
                TLogMonitor tLogMonitor4 = TLogInitializer.getInstance().gettLogMonitor();
                String str9 = TLogStage.MSG_HANDLE;
                String str10 = this.TAG;
                tLogMonitor4.stageError(str9, str10, "消息处理：修改module信息: " + str2);
                Map<String, LogLevel> makeModule = TLogUtils.makeModule(str2);
                if (makeModule != null && makeModule.size() > 0) {
                    TLogController.getInstance().addModuleFilter(makeModule);
                    edit.putString(TLogConstant.REMOTE_DEBUGER_LOG_MODULE, str2).apply();
                    TLogMultiProcessTool.notifyProcessChangeModuleLevel(str2);
                }
            }
            LogConfigureReplyTask.execute(commandInfo);
        } catch (Exception e) {
            Log.e(this.TAG, "execute error", e);
            TLogEventHelper.event(TLogEventConst.UT_TLOG_CONFIG_ERR);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
        }
        return this;
    }
}
