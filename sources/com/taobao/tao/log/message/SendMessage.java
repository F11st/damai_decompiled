package com.taobao.tao.log.message;

import android.content.Context;
import android.util.Log;
import com.taobao.android.tlog.protocol.TLogSecret;
import com.taobao.android.tlog.protocol.model.RequestResult;
import com.taobao.tao.log.CommandDataCenter;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.task.PullTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SendMessage {
    private static String TAG = "SendMessage";

    public static void pull(Context context) {
        MessageSender messageSender = TLogInitializer.getInstance().getMessageSender();
        if (messageSender != null) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.context = context;
            messageInfo.appKey = TLogInitializer.getInstance().getAppkey();
            messageInfo.ttid = TLogInitializer.getInstance().getTtid();
            messageInfo.deviceId = TLogInitializer.getUTDID();
            MessageReponse pullMsg = messageSender.pullMsg(messageInfo);
            if (pullMsg == null || pullMsg.result == null) {
                return;
            }
            PullTask.getInstance().handle(pullMsg);
        }
    }

    public static void send(Context context, RequestResult requestResult) {
        send(context, requestResult, Boolean.FALSE);
    }

    public static void send(Context context, RequestResult requestResult, Boolean bool) {
        MessageReponse sendMsg;
        String str;
        TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND_COUNT, "SEND MESSAGE COUNT", "开始发送消息");
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.context = context;
        messageInfo.content = requestResult.content;
        messageInfo.appKey = TLogInitializer.getInstance().getAppkey();
        messageInfo.ttid = TLogInitializer.getInstance().getTtid();
        messageInfo.deviceId = TLogInitializer.getUTDID();
        messageInfo.publicKeyDigest = TLogSecret.getInstance().getRsaMd5Value();
        MessageSender messageSender = TLogInitializer.getInstance().getMessageSender();
        if (messageSender != null) {
            if (bool.booleanValue()) {
                sendMsg = messageSender.sendStartUp(messageInfo);
            } else {
                sendMsg = messageSender.sendMsg(messageInfo);
            }
            if (sendMsg != null && (str = sendMsg.result) != null) {
                CommandDataCenter.getInstance().onData(sendMsg.serviceId, sendMsg.userId, sendMsg.dataId, str.getBytes());
                return;
            } else if (bool.booleanValue()) {
                return;
            } else {
                Log.e(TAG, "send request message error,result is null ");
                return;
            }
        }
        Log.e(TAG, "send request message error,you need impl message sender ");
        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_SEND, "SEND MESSAGE", "发送消息失败，因为没有实现消息服务");
    }
}
