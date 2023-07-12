package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.android.tlog.protocol.model.reply.LogConfigureReply;
import com.taobao.android.tlog.protocol.model.reply.base.LogReplyBaseInfo;
import com.taobao.android.tlog.protocol.model.reply.base.UploadTokenInfo;
import com.taobao.tao.log.TLogConstant;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.SendMessage;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.upload.UploaderInfo;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LogConfigureReplyTask {
    private static String TAG = "TLOG.LogConfigureReplyTask";

    public static void execute(CommandInfo commandInfo) {
        try {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, TAG, "消息处理：修改日志请求服务端回复消息");
            LogConfigureReply logConfigureReply = new LogConfigureReply();
            LogReplyBaseInfo logReplyBaseInfo = new LogReplyBaseInfo();
            logReplyBaseInfo.appKey = TLogInitializer.getInstance().getAppkey();
            logReplyBaseInfo.appId = TLogInitializer.getInstance().getAppId();
            logReplyBaseInfo.replyCode = "200";
            logReplyBaseInfo.replyMsg = "";
            logReplyBaseInfo.replyOpCode = OpCode.LOG_CONFIGURE_REPLY;
            logReplyBaseInfo.utdid = TLogInitializer.getUTDID();
            UploaderInfo uploadInfo = TLogInitializer.getInstance().getLogUploader().getUploadInfo();
            UploadTokenInfo uploadTokenInfo = new UploadTokenInfo();
            String str = uploadInfo.type;
            logConfigureReply.tokenType = str;
            if (str.equals(TLogConstant.TOKEN_TYPE_OSS) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_ARUP) || uploadInfo.type.equals(TLogConstant.TOKEN_TYPE_CEPH)) {
                uploadTokenInfo.put(TLogConstant.TOKEN_OSS_BUCKET_NAME_KEY, TLogInitializer.getInstance().ossBucketName);
            }
            logConfigureReply.tokenInfo = uploadTokenInfo;
            String build = logConfigureReply.build(commandInfo, logReplyBaseInfo);
            if (build != null) {
                RequestResult requestResult = new RequestResult();
                requestResult.content = build;
                SendMessage.send(TLogInitializer.getInstance().getContext(), requestResult);
                TLogEventHelper.event(TLogEventConst.UT_TLOG_CONFIG_REPLY);
                return;
            }
            Log.w(TAG, "content build failure");
        } catch (Exception e) {
            Log.e(TAG, "execute error", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, TAG, e);
        }
    }
}
