package tb;

import android.text.TextUtils;
import cn.damai.common.soloader.SoFileInfo;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class be2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static SoFileInfo a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53910797")) {
            return (SoFileInfo) ipChange.ipc$dispatch("-53910797", new Object[0]);
        }
        try {
            if (TextUtils.isEmpty("{\n  \"downType\": \"0\",\n  \"md5\": \"961ea2c62bc09fc711a4e642656b1631\",\n  \"name\": \"libaliplayer-1.2.4.so\",\n  \"size\": \"\",\n  \"type\": \"1\",\n  \"url\": \"https://damai-android.oss-cn-beijing.aliyuncs.com/so/libaliplayer-1.2.4.so\",\n  \"fileMD5\": \"ccab770241d328ed5b6e58a247991198\"\n}")) {
                return null;
            }
            return (SoFileInfo) JSON.parseObject("{\n  \"downType\": \"0\",\n  \"md5\": \"961ea2c62bc09fc711a4e642656b1631\",\n  \"name\": \"libaliplayer-1.2.4.so\",\n  \"size\": \"\",\n  \"type\": \"1\",\n  \"url\": \"https://damai-android.oss-cn-beijing.aliyuncs.com/so/libaliplayer-1.2.4.so\",\n  \"fileMD5\": \"ccab770241d328ed5b6e58a247991198\"\n}", SoFileInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
