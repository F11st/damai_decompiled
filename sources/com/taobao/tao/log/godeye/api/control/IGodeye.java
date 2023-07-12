package com.taobao.tao.log.godeye.api.control;

import com.taobao.android.tlog.protocol.model.GodeyeInfo;
import com.taobao.tao.log.godeye.api.command.ICommandManager;
import com.taobao.tao.log.godeye.api.command.ResponseData;
import com.taobao.tao.log.upload.FileUploadListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IGodeye {
    ICommandManager defaultCommandManager();

    IGodeyeJointPointCenter defaultGodeyeJointPointCenter();

    boolean handleRemoteCommand(GodeyeInfo godeyeInfo);

    void registerCommandController(AbsCommandController absCommandController);

    void response(AbsCommandController absCommandController, ResponseData responseData);

    void upload(AbsCommandController absCommandController, String str, FileUploadListener fileUploadListener);
}
