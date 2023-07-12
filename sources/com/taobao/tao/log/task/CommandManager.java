package com.taobao.tao.log.task;

import android.text.TextUtils;
import android.util.Log;
import com.ali.user.mobile.rpc.ApiConstants;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.TLogReply;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CommandManager {
    private String TAG;
    private ConcurrentHashMap<String, ICommandTask> commandTasks;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SingletonHolder {
        private static final CommandManager INSTANCE = new CommandManager();

        private SingletonHolder() {
        }
    }

    public static final CommandManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addCommandTaskListener(String str, ICommandTask iCommandTask) {
        this.commandTasks.put(str, iCommandTask);
    }

    public void dealCommandData(byte[] bArr, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Log.i(this.TAG, String.format("dealCommandData serverID = %s, content = %s", str3, str));
                CommandInfo parseCommandInfo = TLogReply.getInstance().parseCommandInfo(bArr, str, str2, str3);
                if (parseCommandInfo != null) {
                    TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_REVEIVE, "RECEIVE MESSAGE", "接收消息后，基础信息解析完成");
                    if (parseCommandInfo.msgType.equals(ApiConstants.ResultActionType.NOTIFY)) {
                        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_REVEIVE, "RECEIVE MESSAGE", "接收到notify消息，开始拉任务");
                        PullTask.getInstance().pull();
                    }
                    ICommandTask iCommandTask = this.commandTasks.get(parseCommandInfo.opCode);
                    if (iCommandTask != null) {
                        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
                        String str4 = TLogStage.MSG_REVEIVE;
                        tLogMonitor.stageInfo(str4, "RECEIVE MESSAGE", "开始处理任务，opcode=" + parseCommandInfo.opCode);
                        TLogEventHelper.event(TLogEventConst.UT_TLOG_CMD_EXECUTE, TLogEventConst.PARAM_OP_CODE, parseCommandInfo.opCode);
                        iCommandTask.execute(parseCommandInfo);
                        return;
                    }
                    TLogMonitor tLogMonitor2 = TLogInitializer.getInstance().gettLogMonitor();
                    String str5 = TLogStage.MSG_REVEIVE;
                    tLogMonitor2.stageInfo(str5, "RECEIVE MESSAGE", "没有对应的任务存在，opcode=" + parseCommandInfo.opCode);
                    return;
                }
                TLogEventHelper.errorEvent(TLogEventConst.UT_TLOG_CMD_PARSE_ERR, ErrorCode.DATA_EMPTY, "commandInfo is null");
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "CommandInfo is null");
                return;
            } catch (Exception e) {
                Log.e(this.TAG, "parse command info error", e);
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
                TLogEventHelper.errorEvent(TLogEventConst.UT_TLOG_CMD_EXECUTE_ERR, ErrorCode.CODE_EXC, e.getMessage());
                return;
            }
        }
        TLogEventHelper.errorEvent(TLogEventConst.UT_TLOG_CMD_PARSE_ERR, ErrorCode.DATA_EMPTY, "dealCommandData content is null");
        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, "MESSAGE IS NULL");
    }

    public void init() {
        addCommandTaskListener(OpCode.APPLY_UPLOAD_TOKEN_REPLY, new ApplyTokenReplyTask());
        addCommandTaskListener(OpCode.APPLY_UPLOAD_REPLY, new ApplyUploadFileReplyTask());
        addCommandTaskListener(OpCode.LOG_UPLOAD, new LogUploadRequestTask());
        addCommandTaskListener(OpCode.LOG_CONFIGURE, new LogConfigRequestTask());
        addCommandTaskListener(OpCode.METHOD_TRACE_DUMP, new MethodTraceRequestTask());
        addCommandTaskListener(OpCode.HEAP_DUMP, new HeapDumpRequestTask());
        addCommandTaskListener(OpCode.USER_DEFINED_UPLOAD, new UDFUploadRequestTask());
    }

    private CommandManager() {
        this.TAG = "TLOG.CommandManager";
        this.commandTasks = new ConcurrentHashMap<>();
    }
}
