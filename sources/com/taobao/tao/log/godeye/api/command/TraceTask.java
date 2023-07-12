package com.taobao.tao.log.godeye.api.command;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.OpCode;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import com.taobao.android.tlog.protocol.model.GodeyeInfo;
import com.taobao.android.tlog.protocol.model.joint.point.JointPoint;
import com.taobao.android.tlog.protocol.model.request.HeapDumpRequest;
import com.taobao.android.tlog.protocol.model.request.MethodTraceRequest;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.monitor.TLogStage;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TraceTask extends GodeyeBaseTask {
    private static final long defaultAllocMemoryLevel = 104857600;
    private static final double defaultThreshold = 0.6d;
    public Long allocMemoryLevel;
    public Boolean allowForeground;
    public Integer bufferSize;
    public String filePath;
    public Integer maxTrys;
    public Integer numTrys;
    public String opCode;
    public String ossEndpoint;
    public String ossObjectKey;
    public String progress;
    public String requestId;
    public Long samplingInterval;
    public String sequence;
    public Double threshold;
    public String uploadId;

    public TraceTask(JSONObject jSONObject) {
        super(jSONObject);
        this.numTrys = 0;
        this.bufferSize = 0;
        this.maxTrys = 3;
        if (jSONObject.containsKey("samplingInterval")) {
            this.samplingInterval = jSONObject.getLong("samplingInterval");
        }
        if (jSONObject.containsKey("maxTrys")) {
            this.maxTrys = jSONObject.getInteger("maxTrys");
        }
        if (jSONObject.containsKey("uploadId")) {
            this.uploadId = jSONObject.getString("uploadId");
        }
        this.progress = TraceProgress.NOT_STARTED.name();
        this.filePath = null;
    }

    public TraceProgress getProgress() {
        return TraceProgress.fromName(this.progress);
    }

    @Override // com.taobao.tao.log.godeye.api.command.GodeyeBaseTask
    public boolean isEmptyTask() {
        return this.start == null;
    }

    public void toTraceTask(GodeyeInfo godeyeInfo) {
        CommandInfo commandInfo = godeyeInfo.commandInfo;
        if (commandInfo == null) {
            return;
        }
        String str = commandInfo.opCode;
        this.opCode = str;
        this.requestId = commandInfo.requestId;
        this.uploadId = godeyeInfo.uploadId;
        if (str.equals(OpCode.METHOD_TRACE_DUMP)) {
            MethodTraceRequest methodTraceRequest = new MethodTraceRequest();
            try {
                methodTraceRequest.parse(commandInfo.data, commandInfo);
            } catch (Exception e) {
                e.printStackTrace();
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, "TLOG.TraceTask", e);
            }
            JointPoint jointPoint = methodTraceRequest.start;
            if (jointPoint != null) {
                this.start = jointPoint;
            }
            JointPoint jointPoint2 = methodTraceRequest.stop;
            if (jointPoint2 != null) {
                this.stop = jointPoint2;
            }
            this.sequence = godeyeInfo.commandInfo.requestId;
            this.numTrys = 0;
            Integer num = methodTraceRequest.maxTrys;
            if (num != null) {
                this.maxTrys = num;
            } else {
                this.maxTrys = 0;
            }
            Long l = methodTraceRequest.samplingInterval;
            if (l != null) {
                this.samplingInterval = l;
            }
            this.numTrys = 0;
            if (this.maxTrys.intValue() == 0) {
                this.maxTrys = 3;
            }
            this.filePath = godeyeInfo.filePath;
            String str2 = godeyeInfo.progress;
            if (str2 != null) {
                this.progress = str2;
            }
            if (this.progress == null) {
                this.progress = TraceProgress.NOT_STARTED.name();
            }
            Integer num2 = godeyeInfo.bufferSize;
            if (num2 != null) {
                this.bufferSize = num2;
            }
            if (this.bufferSize.intValue() == 0) {
                this.bufferSize = 4194304;
            }
            if (this.samplingInterval == null) {
                this.samplingInterval = 10000L;
            }
        } else if (commandInfo.opCode.equals(OpCode.HEAP_DUMP)) {
            HeapDumpRequest heapDumpRequest = new HeapDumpRequest();
            try {
                heapDumpRequest.parse(commandInfo.data, commandInfo);
            } catch (Exception e2) {
                e2.printStackTrace();
                TLogInitializer.getInstance().gettLogMonitor().stageError(TLogStage.MSG_HANDLE, "TLOG.TraceTask", e2);
            }
            JointPoint jointPoint3 = heapDumpRequest.start;
            if (jointPoint3 != null) {
                this.start = jointPoint3;
            }
            Integer num3 = heapDumpRequest.heapSizeThreshold;
            if (num3 != null) {
                this.threshold = Double.valueOf(num3.intValue());
            } else {
                this.threshold = Double.valueOf(0.6d);
            }
            this.allocMemoryLevel = 104857600L;
        }
    }

    public TraceTask() {
        this.numTrys = 0;
        this.bufferSize = 0;
        this.maxTrys = 3;
    }
}
