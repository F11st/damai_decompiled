package com.alibaba.yymidservice.popup.request;

import com.alibaba.pictures.request.BaseRequest;
import com.alient.gaiax.container.util.ChannelUtil;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PicBaseRequest<BizResponse> extends BaseRequest<BizResponse> {
    @Override // com.alibaba.pictures.request.BaseRequest, com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            return "damai";
        }
        channelUtil.isTppApp();
        return "tpp";
    }
}
