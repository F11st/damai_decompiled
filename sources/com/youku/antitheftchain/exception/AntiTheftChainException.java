package com.youku.antitheftchain.exception;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AntiTheftChainException extends BaseException {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum ErrorCode implements ExceptionErrorCode {
        AntiTheftChain_Create_Avmp_Instance_Error(-1),
        AntiTheftChain_Invoke_Avmp_Sign_Error(-1),
        AntiTheftChain_Param_Error(1000),
        AntiTheftChain_Url_Unsupported_Encoding_Error(1001);
        
        private int errorCode;

        ErrorCode(int i) {
            this.errorCode = i;
        }

        @Override // com.youku.antitheftchain.exception.ExceptionErrorCode
        public int getErrorCode() {
            return this.errorCode;
        }

        @Override // com.youku.antitheftchain.exception.ExceptionErrorCode
        public String getMessage() {
            return toString();
        }
    }

    public AntiTheftChainException(BaseException baseException, ExceptionErrorCode exceptionErrorCode, String str) {
        super(baseException, exceptionErrorCode, str);
    }

    public AntiTheftChainException(ExceptionErrorCode exceptionErrorCode, int i, String str) {
        super(exceptionErrorCode, i, str);
    }

    public AntiTheftChainException(ExceptionErrorCode exceptionErrorCode, String str) {
        super(exceptionErrorCode, str);
    }

    public AntiTheftChainException(Throwable th, ExceptionErrorCode exceptionErrorCode, int i, String str) {
        super(th, exceptionErrorCode, i, str);
    }

    public AntiTheftChainException(Throwable th, ExceptionErrorCode exceptionErrorCode, String str) {
        super(th, exceptionErrorCode, str);
    }
}
