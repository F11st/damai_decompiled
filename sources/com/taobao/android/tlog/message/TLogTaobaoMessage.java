package com.taobao.android.tlog.message;

import android.content.Context;
import android.util.Log;
import cn.damai.user.userprofile.FeedsViewModel;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.message.MessageInfo;
import com.taobao.tao.log.message.MessageReponse;
import com.taobao.tao.log.message.MessageSender;
import com.taobao.tao.log.message.SenderInfo;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventHelper;

/* loaded from: classes11.dex */
public class TLogTaobaoMessage implements MessageSender {
    private static final String TAG = "tlogMessage";

    @Override // com.taobao.tao.log.message.MessageSender
    public SenderInfo getSenderInfo() {
        SenderInfo senderInfo = new SenderInfo();
        senderInfo.type = "accs";
        return senderInfo;
    }

    @Override // com.taobao.tao.log.message.MessageSender
    public void init(MessageInfo messageInfo) {
        try {
            GlobalClientInfo.getInstance(messageInfo.context).registerListener(messageInfo.accsServiceId, (AccsAbstractDataListener) new TLogCommandDataCenter());
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND, "MSG INIT", "初始化消息通道");
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND, "MSG INIT", "初始化消息通道成功");
        } catch (Exception e) {
            Log.e(TAG, "registerDataListener failure : ", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_SEND, "MSG INIT", e);
            TLogEventHelper.errorEvent(UTConst.UT_TLOG_ACCS_INIT_ERR, ErrorCode.CODE_EXC, e.getMessage());
        }
    }

    @Override // com.taobao.tao.log.message.MessageSender
    public MessageReponse pullMsg(MessageInfo messageInfo) {
        return null;
    }

    @Override // com.taobao.tao.log.message.MessageSender
    public MessageReponse sendMsg(MessageInfo messageInfo) {
        Context context = messageInfo.context;
        String str = messageInfo.content;
        String str2 = messageInfo.accsServiceId;
        try {
            ACCSManager.sendRequest(context, FeedsViewModel.ARG_USERID, str2, str.getBytes(), null);
            MessageReponse messageReponse = new MessageReponse();
            messageReponse.result = null;
            messageReponse.dataId = Constants.KEY_DATA_ID;
            messageReponse.serviceId = str2;
            messageReponse.userId = "userId";
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND, "SEND MSG", "异步发送消息完成");
            return messageReponse;
        } catch (Exception e) {
            Log.e(TAG, "send accs message failure : ", e);
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_SEND, "SEND MSG", e);
            TLogEventHelper.errorEvent(UTConst.UT_TLOG_ACCS_SEND_ERR, ErrorCode.CODE_EXC, e.getMessage());
            return null;
        }
    }

    @Override // com.taobao.tao.log.message.MessageSender
    public MessageReponse sendStartUp(MessageInfo messageInfo) {
        return sendMsg(messageInfo);
    }
}
