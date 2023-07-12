package com.taobao.tao.log.godeye.methodtrace;

import android.os.Build;
import android.os.Debug;
import android.util.Log;
import com.taobao.tao.log.godeye.api.command.InstructionHandler;
import com.taobao.tao.log.godeye.api.command.ResponseData;
import com.taobao.tao.log.godeye.api.command.TraceProgress;
import com.taobao.tao.log.godeye.api.command.TraceTask;
import com.taobao.tao.log.godeye.api.control.AbsCommandController;
import com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter;
import com.taobao.tao.log.godeye.methodtrace.file.TraceFileUploadListener;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MethodTraceController extends AbsCommandController implements InstructionHandler {
    private static final String opCode = "RDWP_METHOD_TRACE_DUMP";
    private final String mTraceDumpDir;
    private TraceTask mTraceTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodTraceController() {
        super("RDWP_METHOD_TRACE_DUMP");
        this.mTraceDumpDir = MethodTraceInitializer.sApplication.getExternalFilesDir(null) + File.separator + "RDWP_METHOD_TRACE_DUMP.trace";
    }

    private boolean verifyLocalTask(TraceTask traceTask) {
        String str;
        if (traceTask == null || traceTask.start == null || traceTask.stop == null) {
            return false;
        }
        if (traceTask.numTrys.intValue() >= traceTask.maxTrys.intValue()) {
            MethodTraceInitializer.sGodeye.defaultCommandManager().removeLocalCommand(this);
            return false;
        } else if (traceTask.getProgress() == TraceProgress.UPLOADED) {
            MethodTraceInitializer.sGodeye.defaultCommandManager().removeLocalCommand(this);
            return false;
        } else {
            if (traceTask.getProgress() == TraceProgress.RUNNING) {
                traceTask.progress = TraceProgress.NOT_STARTED.name();
            }
            if ((traceTask.getProgress() == TraceProgress.COMPLETE || traceTask.getProgress() == TraceProgress.EXCEPTION_ON_UPLOAD) && (str = traceTask.filePath) != null) {
                MethodTraceInitializer.sGodeye.upload(this, str, new TraceFileUploadListener(this, traceTask));
                return false;
            }
            return true;
        }
    }

    @Override // com.taobao.tao.log.godeye.api.control.AbsCommandController
    public InstructionHandler getInstructionHandler() {
        return this;
    }

    @Override // com.taobao.tao.log.godeye.api.control.AbsCommandController
    public String getRequestId() {
        return this.mTraceTask.requestId;
    }

    @Override // com.taobao.tao.log.godeye.api.control.AbsCommandController
    public String getUploadId() {
        return this.mTraceTask.uploadId;
    }

    @Override // com.taobao.tao.log.godeye.api.command.InstructionHandler
    public void handleInstruction(TraceTask traceTask, boolean z) {
        if (!z) {
            try {
                stopRunningTask();
                MethodTraceInitializer.sGodeye.response(this, new ResponseData(2, "receive-new-command", null));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.mTraceTask = traceTask;
        if (traceTask.isEmptyTask()) {
            MethodTraceInitializer.sGodeye.defaultCommandManager().removeLocalCommand(this);
        } else {
            MethodTraceInitializer.sGodeye.defaultCommandManager().saveRawCommandString(this, this.mTraceTask);
        }
        installTraceTask(this.mTraceTask, z);
    }

    void installTraceTask(TraceTask traceTask, boolean z) {
        if (verifyLocalTask(traceTask)) {
            Log.e("tlog-debug", "installTraceTask");
            setTraceTask(traceTask);
            MethodTraceInitializer.sGodeye.defaultGodeyeJointPointCenter().installJointPoints(traceTask.start, new IGodeyeJointPointCenter.GodeyeJointPointCallback() { // from class: com.taobao.tao.log.godeye.methodtrace.MethodTraceController.1
                @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
                public void doCallback() {
                    MethodTraceController.this.startTask();
                }
            }, traceTask.stop, new IGodeyeJointPointCenter.GodeyeJointPointCallback() { // from class: com.taobao.tao.log.godeye.methodtrace.MethodTraceController.2
                @Override // com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter.GodeyeJointPointCallback
                public void doCallback() {
                    MethodTraceController.this.stopRunningTask();
                }
            }, z);
        }
    }

    public void saveTaskRunningStatus(TraceTask traceTask) {
        MethodTraceInitializer.sGodeye.defaultCommandManager().saveRawCommandString(this, traceTask);
    }

    public void setTraceTask(TraceTask traceTask) {
        this.mTraceTask = traceTask;
    }

    public void startTask() {
        TraceTask traceTask = this.mTraceTask;
        if (traceTask != null && traceTask.getProgress() == TraceProgress.NOT_STARTED) {
            TraceTask traceTask2 = this.mTraceTask;
            if (traceTask2.numTrys.intValue() >= traceTask2.maxTrys.intValue()) {
                MethodTraceInitializer.sGodeye.defaultCommandManager().removeLocalCommand(this);
            } else if (Build.VERSION.SDK_INT > 19) {
                traceTask2.numTrys = Integer.valueOf(traceTask2.numTrys.intValue() + 1);
                saveTaskRunningStatus(this.mTraceTask);
                Log.e("tlog-debug", "startMethodTracing");
                if (this.mTraceTask.samplingInterval.longValue() <= 0) {
                    Debug.startMethodTracing();
                } else {
                    Debug.startMethodTracingSampling(this.mTraceDumpDir, this.mTraceTask.bufferSize.intValue(), 10000);
                }
                traceTask2.progress = TraceProgress.RUNNING.name();
                saveTaskRunningStatus(this.mTraceTask);
            } else if (this.mTraceTask.samplingInterval.longValue() <= 0) {
                Debug.startMethodTracing();
            }
        }
    }

    public void stopRunningTask() {
        TraceTask traceTask = this.mTraceTask;
        if (traceTask == null || traceTask.getProgress() != TraceProgress.RUNNING) {
            return;
        }
        Log.e("tlog-debug", "stopMethodTracing");
        Debug.stopMethodTracing();
        TraceTask traceTask2 = this.mTraceTask;
        traceTask2.filePath = this.mTraceDumpDir;
        traceTask2.progress = TraceProgress.COMPLETE.name();
        saveTaskRunningStatus(this.mTraceTask);
        MethodTraceInitializer.sGodeye.upload(this, this.mTraceDumpDir, new TraceFileUploadListener(this, this.mTraceTask));
    }
}
