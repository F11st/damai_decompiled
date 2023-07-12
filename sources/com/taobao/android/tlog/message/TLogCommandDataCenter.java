package com.taobao.android.tlog.message;

import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.tao.log.CommandDataCenter;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventHelper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogCommandDataCenter extends AccsAbstractDataListener {
    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (bArr != null && bArr.length > 0) {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND, "RECEIVE MSG", "接收到accs下发的消息，开始处理");
            CommandDataCenter.getInstance().onData(str, str2, str3, bArr);
            return;
        }
        TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_SEND, "RECEIVE MSG", "接收到accs下发的消息，但是内容为空的.");
        TLogEventHelper.errorEvent(UTConst.UT_TLOG_ACCS_RECEIVE_ERR, ErrorCode.DATA_EMPTY, "onData msg is null");
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        if (bArr != null) {
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_SEND, "RECEIVE REPONSE", "接收到accs返回的reponse");
            CommandDataCenter.getInstance().onData(str, "userId", str2, bArr);
        } else if (i == -11) {
        } else {
            TLogEventHelper.errorEvent(UTConst.UT_TLOG_ACCS_RECEIVE_ERR, String.valueOf(i), "response is null");
            TLogMonitor tLogMonitor = TLogInitializer.getInstance().gettLogMonitor();
            String str3 = TLogStage.MSG_SEND;
            tLogMonitor.stageError(str3, "RECEIVE REPONSE", "接收到accs返回的reponse，但是内容为空的, dataId:" + str2 + " serviceId:" + str + " errorCode:" + i);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
