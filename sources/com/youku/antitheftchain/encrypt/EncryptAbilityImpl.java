package com.youku.antitheftchain.encrypt;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.avmp.IAVMPGenericComponent;
import com.youku.antitheftchain.AtcLog;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class EncryptAbilityImpl implements EncryptAbility {
    private static final int MWUA = 0;
    private static IAVMPGenericComponent.IAVMPGenericInstance instance;
    private static SecurityGuardManager secManager;
    private static IAVMPGenericComponent vmpComp;
    private final String TAG = "EncryptAbilityImpl";

    private String getDebugInfo(AntiTheftChainParam antiTheftChainParam) {
        return "antiTheftChainClientType " + antiTheftChainParam.getAntiTheftChainClientType() + ", authCode " + antiTheftChainParam.getAuthCode() + ", ServerEnv  " + antiTheftChainParam.getServerEnv();
    }

    private String getNeedEncryptString(AntiTheftChainParam antiTheftChainParam) {
        String str = "ccode=" + antiTheftChainParam.getCcode() + "&client_ip=" + antiTheftChainParam.getClientIP() + "&client_ts=" + antiTheftChainParam.getClientTs() + "&utid=" + antiTheftChainParam.getUtid() + "&vid=" + antiTheftChainParam.getVid();
        AtcLog.d("EncryptAbilityImpl", "getNeedEncryptString result: " + str);
        return str;
    }

    @Override // com.youku.antitheftchain.encrypt.EncryptAbility
    public String encrypt(AntiTheftChainParam antiTheftChainParam) {
        byte[] bArr;
        String needEncryptString = getNeedEncryptString(antiTheftChainParam);
        AtcLog.d("EncryptAbilityImpl", "getDebugInfo: " + getDebugInfo(antiTheftChainParam));
        byte[] bArr2 = new byte[4];
        int serverEnv = antiTheftChainParam.getServerEnv();
        initSecurityGuard(antiTheftChainParam.getContext(), antiTheftChainParam.getAntiTheftChainClientType(), antiTheftChainParam.getAuthCode());
        try {
            synchronized (EncryptAbilityImpl.class) {
                bArr = (byte[]) instance.invokeAVMP("sign", new byte[0].getClass(), 0, needEncryptString.getBytes(), Integer.valueOf(needEncryptString.getBytes().length), null, bArr2, Integer.valueOf(serverEnv));
            }
            try {
                String str = new String(bArr);
                AtcLog.d("EncryptAbilityImpl", "before url encode: " + str);
                String encode = URLEncoder.encode(str, "UTF-8");
                AtcLog.d("EncryptAbilityImpl", "after url encode: " + encode);
                return encode;
            } catch (UnsupportedEncodingException e) {
                AntiTheftChainException.ErrorCode errorCode = AntiTheftChainException.ErrorCode.AntiTheftChain_Url_Unsupported_Encoding_Error;
                throw new AntiTheftChainException(e, errorCode, "getDebugInfo " + getDebugInfo(antiTheftChainParam));
            }
        } catch (SecException e2) {
            int i = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN).getInt();
            AntiTheftChainException.ErrorCode errorCode2 = AntiTheftChainException.ErrorCode.AntiTheftChain_Invoke_Avmp_Sign_Error;
            throw new AntiTheftChainException(e2, errorCode2, i, "getDebugInfo " + getDebugInfo(antiTheftChainParam));
        }
    }

    @Override // com.youku.antitheftchain.encrypt.EncryptAbility
    public void initSecurityGuard(Context context, AntiTheftChainClientType antiTheftChainClientType, String str) {
        IAVMPGenericComponent.IAVMPGenericInstance createAVMPInstance;
        synchronized (EncryptAbilityImpl.class) {
            if (instance != null) {
                return;
            }
            try {
                if (antiTheftChainClientType == AntiTheftChainClientType.Unknown) {
                    throw new AntiTheftChainException(AntiTheftChainException.ErrorCode.AntiTheftChain_Param_Error, "antiTheftChainClientType is unknown");
                }
                if (context == null) {
                    throw new AntiTheftChainException(AntiTheftChainException.ErrorCode.AntiTheftChain_Param_Error, "context is null");
                }
                secManager = SecurityGuardManager.getInstance(context.getApplicationContext());
                vmpComp = (IAVMPGenericComponent) SecurityGuardManager.getInstance(context.getApplicationContext()).getInterface(IAVMPGenericComponent.class);
                if (antiTheftChainClientType != AntiTheftChainClientType.Internal) {
                    if (antiTheftChainClientType == AntiTheftChainClientType.External) {
                        createAVMPInstance = vmpComp.createAVMPInstance("0335_mwua", "sgcipher");
                    }
                }
                createAVMPInstance = vmpComp.createAVMPInstance(str, "sgcipher");
                instance = createAVMPInstance;
            } catch (SecException e) {
                AntiTheftChainException.ErrorCode errorCode = AntiTheftChainException.ErrorCode.AntiTheftChain_Create_Avmp_Instance_Error;
                int errorCode2 = e.getErrorCode();
                throw new AntiTheftChainException(e, errorCode, errorCode2, "getDebugInfo antiTheftChainClientType " + antiTheftChainClientType + ", authCode " + str);
            }
        }
    }
}
