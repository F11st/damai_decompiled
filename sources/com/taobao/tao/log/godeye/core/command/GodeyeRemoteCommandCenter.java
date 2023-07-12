package com.taobao.tao.log.godeye.core.command;

import com.taobao.android.tlog.protocol.model.GodeyeInfo;
import com.taobao.tao.log.godeye.api.command.TraceTask;
import com.taobao.tao.log.godeye.api.control.AbsCommandController;
import com.taobao.tao.log.godeye.core.control.Godeye;
import com.taobao.tao.log.godeye.core.plugin.PluginManager;
import com.taobao.tao.log.godeye.protocol.control.Define;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class GodeyeRemoteCommandCenter {
    private Set<Define.Entry<AbsCommandController>> mCommandControllers = new HashSet();

    public void dispatchCommand(GodeyeInfo godeyeInfo) {
        try {
            PluginManager.loadDefaultPlugins();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Define.Entry<AbsCommandController> entry : this.mCommandControllers) {
            if (entry.getOpCode().equals(godeyeInfo.commandInfo.opCode)) {
                try {
                    TraceTask traceTask = new TraceTask();
                    traceTask.toTraceTask(godeyeInfo);
                    dispatchCommandInternal(entry.getValue(), traceTask, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void dispatchCommandInternal(AbsCommandController absCommandController, TraceTask traceTask, boolean z) {
        if (absCommandController == null || traceTask == null) {
            return;
        }
        absCommandController.currentSequence = traceTask.requestId;
        if (absCommandController.getInstructionHandler() != null) {
            absCommandController.getInstructionHandler().handleInstruction(traceTask, z);
        } else if (absCommandController.getStartJointPointCallback() == null || absCommandController.getStopJointPointCallback() == null) {
        } else {
            try {
                Godeye.sharedInstance().defaultCommandManager().saveRawCommandString(absCommandController, traceTask);
                Godeye.sharedInstance().defaultGodeyeJointPointCenter().installJointPoints(traceTask.start, absCommandController.getStartJointPointCallback(), traceTask.stop, absCommandController.getStopJointPointCallback(), z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Set<Define.Entry<AbsCommandController>> getCommandControllers() {
        return this.mCommandControllers;
    }

    public void registerCommandController(String str, AbsCommandController absCommandController) {
        this.mCommandControllers.add(Define.Entry.build(str, absCommandController));
    }
}
