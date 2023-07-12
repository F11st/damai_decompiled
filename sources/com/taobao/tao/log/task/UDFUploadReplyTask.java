package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.UserDefineUploadReply;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UDFUploadReplyTask {
    private static String TAG = "TLOG.UDFUploadReplyTask";

    public static void executeFailure(CommandInfo commandInfo, String str, String str2) {
        TLogEventHelper.uploadFailEvent(UploadFileType.UDF, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, str, str2, commandInfo.sessionId);
        TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
        String str3 = TLogStage.MSG_HANDLE;
        String str4 = TAG;
        tLogMonitor.stageError(str3, str4, str + ":" + str2);
        UserDefineUploadReply userDefineUploadReply = new UserDefineUploadReply();
        String appkey = TLogInitializer.getInstance().getAppkey();
        String utdid = TLogInitializer.getUTDID();
        LogReplyBaseInfo logReplyBaseInfo = new LogReplyBaseInfo();
        logReplyBaseInfo.appKey = appkey;
        logReplyBaseInfo.appId = TLogInitializer.getInstance().getAppId();
        logReplyBaseInfo.utdid = utdid;
        logReplyBaseInfo.replyOpCode = OpCode.USER_DEFINED_UPLOAD_REPLY;
        logReplyBaseInfo.replyCode = str;
        logReplyBaseInfo.replyMsg = str2;
        try {
            String build = userDefineUploadReply.build(commandInfo, logReplyBaseInfo);
            if (build != null) {
                RequestResult requestResult = new RequestResult();
                requestResult.content = build;
                SendMessage.send(TLogInitializer.getInstance().getContext(), requestResult);
            } else {
                Log.w(TAG, "user define content build failure");
            }
        } catch (Exception e) {
            Log.e(TAG, "user define log upload reply error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }

    public static void executeSuccess(CommandInfo commandInfo) {
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "消息处理：服务端要求上传用户自定义文件回复");
        UserDefineUploadReply userDefineUploadReply = new UserDefineUploadReply();
        String appkey = TLogInitializer.getInstance().getAppkey();
        String utdid = TLogInitializer.getUTDID();
        LogReplyBaseInfo logReplyBaseInfo = new LogReplyBaseInfo();
        logReplyBaseInfo.appKey = appkey;
        logReplyBaseInfo.appId = TLogInitializer.getInstance().getAppId();
        logReplyBaseInfo.utdid = utdid;
        logReplyBaseInfo.replyOpCode = OpCode.USER_DEFINED_UPLOAD_REPLY;
        logReplyBaseInfo.replyCode = "200";
        logReplyBaseInfo.replyMsg = "";
        try {
            String build = userDefineUploadReply.build(commandInfo, logReplyBaseInfo);
            if (build != null) {
                RequestResult requestResult = new RequestResult();
                requestResult.content = build;
                SendMessage.send(TLogInitializer.getInstance().getContext(), requestResult);
            } else {
                Log.w(TAG, "content build failure");
            }
        } catch (Exception e) {
            Log.e(TAG, "user define log upload reply error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }
}
