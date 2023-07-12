package com.taobao.tao.log.task;

import android.util.Log;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.GodeyeInfo;
import com.taobao.android.tlog.protocol.model.request.HeapDumpRequest;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.godeye.GodeyeInitializer;
import com.taobao.tao.log.monitor.TLogStage;
import com.taobao.tao.log.statistics.ErrorCode;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.tao.log.statistics.TLogEventHelper;
import com.taobao.tao.log.statistics.UploadFileType;
import com.taobao.tao.log.statistics.UploadReason;
import com.taobao.tao.log.statistics.UploadStage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HeapDumpRequestTask implements ICommandTask {
    private String TAG = "TLOG.HeapDumpRequestTask";

    @Override // com.taobao.tao.log.task.ICommandTask
    public ICommandTask execute(CommandInfo commandInfo) {
        try {
            UploadFileType uploadFileType = UploadFileType.HEAP_DUMP;
            UploadReason uploadReason = UploadReason.SERVER_PULL;
            TLogEventHelper.uploadEvent(TLogEventConst.UT_TLOG_FILE_UPLOAD_REQ, uploadFileType, uploadReason, "");
            TLogInitializer.getInstance().gettLogMonitor().stageInfo(TLogStage.MSG_HANDLE, this.TAG, "消息处理：堆栈dump请求消息");
            HeapDumpRequest heapDumpRequest = new HeapDumpRequest();
            heapDumpRequest.parse(commandInfo.data, commandInfo);
            GodeyeInfo godeyeInfo = new GodeyeInfo();
            godeyeInfo.commandInfo = commandInfo;
            godeyeInfo.uploadId = heapDumpRequest.uploadId;
            godeyeInfo.threshold = Double.valueOf(heapDumpRequest.heapSizeThreshold.intValue());
            if (!GodeyeInitializer.getInstance().handleRemoteCommand(godeyeInfo)) {
                TLogEventHelper.uploadFailEvent(uploadFileType, uploadReason, UploadStage.STAGE_REQ, ErrorCode.COMMON.getValue(), "handleRemoteCommand failed", "");
            }
        } catch (Exception e) {
            Log.e(this.TAG, "execute error", e);
            TLogEventHelper.uploadFailEvent(UploadFileType.HEAP_DUMP, UploadReason.SERVER_PULL, UploadStage.STAGE_REQ, ErrorCode.CODE_EXC.getValue(), e.getMessage(), "");
            TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, this.TAG, e);
        }
        return this;
    }
}
