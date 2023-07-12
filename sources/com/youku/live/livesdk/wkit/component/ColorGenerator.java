package com.youku.live.livesdk.wkit.component;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ColorGenerator {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int genColorWithString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790827562")) {
            return ((Integer) ipChange.ipc$dispatch("790827562", new Object[]{str})).intValue();
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes());
            return (-16777216) | ((digest[0] & 255) << 20) | ((digest[1] & 255) << 16) | ((digest[2] & 255) << 12) | ((digest[3] & 255) << 8) | ((digest[4] & 255) << 4) | ((digest[5] & 255) << 0);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
