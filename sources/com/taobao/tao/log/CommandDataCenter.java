package com.taobao.tao.log;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.android.tlog.protocol.TLogReply;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.task.CommandManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CommandDataCenter {
    private static final String TAG = "TLOG.CommandDataCenter";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CreateInstance {
        private static CommandDataCenter instance = new CommandDataCenter();

        private CreateInstance() {
        }
    }

    public static synchronized CommandDataCenter getInstance() {
        CommandDataCenter commandDataCenter;
        synchronized (CommandDataCenter.class) {
            commandDataCenter = CreateInstance.instance;
        }
        return commandDataCenter;
    }

    public void onData(String str, String str2, String str3, byte[] bArr) {
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_REVEIVE_COUNT, "RECEIVE MESSAGE COUNT", "成功接收到消息，还未开始处理");
        if (bArr == null) {
            Log.e(TAG, "msg is null");
            TLogEventHelper.errorEvent(TLogEventConst.UT_TLOG_CMD_PARSE_ERR, ErrorCode.DATA_EMPTY, "onData msg is null");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_REVEIVE, "NULL MESSAGE", "接收到的服务端消息为空");
            return;
        }
        try {
            String parseContent = TLogReply.getInstance().parseContent(str, str2, str3, bArr);
            if (TextUtils.isEmpty(parseContent)) {
                return;
            }
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_REVEIVE, "RECEIVE MESSAGE", "成功接收到消息");
            Log.i(TAG, "CommandDataCenter.onData : " + parseContent);
            CommandManager.getInstance().dealCommandData(bArr, parseContent, str2, str);
        } catch (Exception e) {
            TLogEventHelper.errorEvent(TLogEventConst.UT_TLOG_CMD_PARSE_ERR, ErrorCode.CODE_EXC, e.getMessage());
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_REVEIVE, "PARSE MESSAGE ERROR", e);
        }
    }

    private CommandDataCenter() {
    }
}
