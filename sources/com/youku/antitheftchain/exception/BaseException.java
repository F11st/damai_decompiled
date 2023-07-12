package com.youku.antitheftchain.exception;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BaseException extends Exception {
    private static final long serialVersionUID = 5269089054051757504L;
    private int errorCode;
    private String errorInfo;
    private ExceptionErrorCode exceptionErrorCode;
    private int subErrorCode;

    public BaseException(BaseException baseException, ExceptionErrorCode exceptionErrorCode, String str) {
        super("Reason: " + exceptionErrorCode.getMessage() + ", ErrorCode " + exceptionErrorCode.getErrorCode() + ", SubErrorCode " + baseException.getErrorCode() + ", ErrorInfo: " + str);
        this.errorCode = 0;
        this.errorInfo = "";
        this.subErrorCode = 0;
        initCause(baseException);
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode.getErrorCode();
        this.subErrorCode = baseException.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode;
    }

    public BaseException(ExceptionErrorCode exceptionErrorCode, int i, String str) {
        super("Reason: " + exceptionErrorCode.getMessage() + ", ErrorCode " + i + ", ErrorInfo: " + str);
        this.errorCode = 0;
        this.errorInfo = "";
        this.subErrorCode = 0;
        this.errorInfo = str;
        this.errorCode = i;
        this.exceptionErrorCode = exceptionErrorCode;
    }

    public BaseException(ExceptionErrorCode exceptionErrorCode, String str) {
        super("Reason: " + exceptionErrorCode.getMessage() + ", ErrorCode " + exceptionErrorCode.getErrorCode() + ", ErrorInfo: " + str);
        this.errorCode = 0;
        this.errorInfo = "";
        this.subErrorCode = 0;
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode;
    }

    public BaseException(Throwable th, ExceptionErrorCode exceptionErrorCode, int i, String str) {
        super("Reason: " + exceptionErrorCode.getMessage() + ", ErrorCode " + i + ", ErrorInfo: " + str);
        this.errorCode = 0;
        this.errorInfo = "";
        this.subErrorCode = 0;
        initCause(th);
        this.errorInfo = str;
        this.errorCode = i;
        this.exceptionErrorCode = exceptionErrorCode;
    }

    public BaseException(Throwable th, ExceptionErrorCode exceptionErrorCode, String str) {
        super("Reason: " + exceptionErrorCode.getMessage() + ", ErrorCode " + exceptionErrorCode.getErrorCode() + ", ErrorInfo: " + str);
        this.errorCode = 0;
        this.errorInfo = "";
        this.subErrorCode = 0;
        initCause(th);
        this.errorInfo = str;
        this.errorCode = exceptionErrorCode.getErrorCode();
        this.exceptionErrorCode = exceptionErrorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public ExceptionErrorCode getExceptionErrorCode() {
        return this.exceptionErrorCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }
}
