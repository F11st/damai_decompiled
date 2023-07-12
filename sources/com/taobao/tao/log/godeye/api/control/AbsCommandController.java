package com.taobao.tao.log.godeye.api.control;

import com.taobao.tao.log.godeye.api.command.InstructionHandler;
import com.taobao.tao.log.godeye.api.control.IGodeyeJointPointCenter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbsCommandController {
    public String currentSequence;
    public String opCode;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsCommandController(String str) {
        this.opCode = str;
    }

    public InstructionHandler getInstructionHandler() {
        return null;
    }

    public String getRequestId() {
        return null;
    }

    public IGodeyeJointPointCenter.GodeyeJointPointCallback getStartJointPointCallback() {
        return null;
    }

    public IGodeyeJointPointCenter.GodeyeJointPointCallback getStopJointPointCallback() {
        return null;
    }

    public String getUploadId() {
        return null;
    }
}
