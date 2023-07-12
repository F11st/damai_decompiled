package com.youku.passport.libs;

import android.text.TextUtils;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LoginStyleUpdater {
    private LoginStyle mLoginStyle;

    public LoginStyleUpdater(LoginStyle loginStyle) {
        this.mLoginStyle = loginStyle;
        if (loginStyle == null) {
            this.mLoginStyle = new LoginStyle();
        }
    }

    public LoginStyle build() {
        return this.mLoginStyle;
    }

    public final int readUnsignedLong(long j, int i) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            return i;
        }
        try {
            if (i2 > 0) {
                return new BigDecimal(j).intValue();
            }
            return BigDecimal.valueOf(j & AbsPerformance.LONG_NIL).add(BigDecimal.valueOf((long) AbsPerformance.LONG_NIL)).add(BigDecimal.valueOf(1L)).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public LoginStyleUpdater setBtnBgColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.buttonBgIntColor = readUnsignedLong(loginStyle.buttonBgColor, i);
        return this;
    }

    public LoginStyleUpdater setBtnText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.buttonText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.buttonText = str;
        }
        return this;
    }

    public LoginStyleUpdater setBtnTextColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.buttonTextIntColor = readUnsignedLong(loginStyle.buttonTextColor, i);
        return this;
    }

    public LoginStyleUpdater setChangeBtnText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.changeButtonText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.changeButtonText = str;
        }
        return this;
    }

    public LoginStyleUpdater setChangeSubTitleColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.changeSubTitleIntColor = readUnsignedLong(loginStyle.changeSubTitleColor, i);
        return this;
    }

    public LoginStyleUpdater setChangeSubTitleContent(String str) {
        LoginStyle loginStyle = this.mLoginStyle;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        loginStyle.changeSubTitleContent = str;
        return this;
    }

    public LoginStyleUpdater setChangeSubTitleText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.changeSubTitleText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.changeSubTitleText = str;
        }
        return this;
    }

    public LoginStyleUpdater setChangeTitleContent(String str) {
        LoginStyle loginStyle = this.mLoginStyle;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        loginStyle.changeTitleContent = str;
        return this;
    }

    public LoginStyleUpdater setChangeTitleText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.changeTitleText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.changeTitleText = str;
        }
        return this;
    }

    public LoginStyleUpdater setInputBgColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.inputViewBgIntColor = readUnsignedLong(loginStyle.inputViewBgColor, i);
        return this;
    }

    public LoginStyleUpdater setInputBorderColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.inputViewBorderIntColor = readUnsignedLong(loginStyle.inputViewBorderColor, i);
        return this;
    }

    public LoginStyleUpdater setInputTextColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.inputViewTextIntColor = readUnsignedLong(loginStyle.inputViewTextColor, i);
        return this;
    }

    public LoginStyleUpdater setRetryDefaultColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.retryDefaultIntColor = readUnsignedLong(loginStyle.retryDefaultColor, i);
        return this;
    }

    public LoginStyleUpdater setRetryHighlightColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.retryHighlightIntColor = readUnsignedLong(loginStyle.retryHighlightColor, i);
        return this;
    }

    public LoginStyleUpdater setSubTitleColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.subTitleIntColor = readUnsignedLong(loginStyle.subTitleColor, i);
        return this;
    }

    public LoginStyleUpdater setSubTitleContent(String str) {
        LoginStyle loginStyle = this.mLoginStyle;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        loginStyle.subTitleContent = str;
        return this;
    }

    public LoginStyleUpdater setSubTitleText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.subTitleText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.subTitleText = str;
        }
        return this;
    }

    public LoginStyleUpdater setTitleColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.titleIntColor = readUnsignedLong(loginStyle.titleColor, i);
        return this;
    }

    public LoginStyleUpdater setTitleContent(String str) {
        LoginStyle loginStyle = this.mLoginStyle;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        loginStyle.titleContent = str;
        return this;
    }

    public LoginStyleUpdater setTitleText(String str) {
        if (TextUtils.isEmpty(this.mLoginStyle.titleText)) {
            LoginStyle loginStyle = this.mLoginStyle;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            loginStyle.titleText = str;
        }
        return this;
    }

    public LoginStyleUpdater setVoiceCodeDefaultColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.voiceCodeDefaultIntColor = readUnsignedLong(loginStyle.voiceCodeDefaultColor, i);
        return this;
    }

    public LoginStyleUpdater setVoiceCodeHighlightColor(int i) {
        LoginStyle loginStyle = this.mLoginStyle;
        loginStyle.voiceCodeHighlightIntColor = readUnsignedLong(loginStyle.voiceCodeHighlightColor, i);
        return this;
    }
}
