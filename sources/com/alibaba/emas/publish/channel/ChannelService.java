package com.alibaba.emas.publish.channel;

import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ChannelService {
    void addVersionAndArgs(String str, String str2, Map<String, String> map) throws Exception;

    void registAccs(String str);

    void registUt() throws Exception;

    PublishMtopResponse sendActiveMtop(String str, String str2, List<String> list, Map<String, String> map, Map<String, String> map2) throws Exception;

    PublishMtopResponse sendMtop() throws Exception;

    void sendUtData(PublishUtRequest publishUtRequest) throws Exception;
}
