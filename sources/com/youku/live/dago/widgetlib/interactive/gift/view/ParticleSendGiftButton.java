package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ParticleSendGiftButton extends RelativeLayout implements View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int MAX_PROGRESS;
    private final int PROGRESS;
    private final int PROGRESS_INTERVAL;
    private int beginProgress;
    private boolean canSend;
    private boolean comboSend;
    private int giftType;
    private boolean isCombo;
    private boolean isOldSend;
    private boolean isSending;
    private boolean isSetState;
    private boolean mCanCombo;
    public CombSendView mCombSendView;
    private int mComboCount;
    private int mComboInterval;
    private Context mContext;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler;
    private OnSendListener mOnSendListener;
    private LinearProgressSendButton mSendBtn;
    private CombSendView.OnCombSendListener onCombSendListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnSendListener {
        boolean checkCost();

        void onCombSend(int i);

        void onRenew();

        void onSend();

        void onTouchDown();
    }

    public ParticleSendGiftButton(Context context) {
        super(context);
        this.isCombo = true;
        this.isSetState = false;
        this.isSending = false;
        this.canSend = true;
        this.mComboCount = 0;
        this.comboSend = false;
        this.beginProgress = 0;
        this.PROGRESS = 3;
        this.MAX_PROGRESS = 100;
        this.PROGRESS_INTERVAL = 25;
        this.mComboInterval = 25;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "70747083")) {
                    ipChange.ipc$dispatch("70747083", new Object[]{this, message});
                } else if (message.what != 3) {
                } else {
                    ParticleSendGiftButton.this.oldDoProgress();
                }
            }
        };
        this.onCombSendListener = new CombSendView.OnCombSendListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSend(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "275882581")) {
                    ipChange.ipc$dispatch("275882581", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onCombSend(i);
                ParticleSendGiftButton.this.isSending = true;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSendEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-298681535")) {
                    ipChange.ipc$dispatch("-298681535", new Object[]{this});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onRenew();
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f));
                ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1264883318")) {
                            ipChange2.ipc$dispatch("-1264883318", new Object[]{this, animator});
                            return;
                        }
                        ParticleSendGiftButton.this.mCombSendView.setVisibility(8);
                        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mSendBtn, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
                        ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1854561897")) {
                                    ipChange3.ipc$dispatch("-1854561897", new Object[]{this, animator2});
                                }
                            }
                        });
                        ofPropertyValuesHolder2.setDuration(200L).start();
                    }
                });
                ofPropertyValuesHolder.setDuration(200L).start();
                ParticleSendGiftButton.this.mSendBtn.setVisibility(0);
                ParticleSendGiftButton.this.isSending = false;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onTouchDown() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2139583022")) {
                    ipChange.ipc$dispatch("-2139583022", new Object[]{this});
                } else {
                    ParticleSendGiftButton.this.mOnSendListener.onTouchDown();
                }
            }
        };
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752223221")) {
            return ((Boolean) ipChange.ipc$dispatch("752223221", new Object[]{this})).booleanValue();
        }
        return false;
    }

    private void doActionDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548517053")) {
            ipChange.ipc$dispatch("-1548517053", new Object[]{this});
        } else if (1 == this.giftType) {
        } else {
            if (this.isOldSend) {
                resetProgress(false);
                return;
            }
            this.mCombSendView.reset();
            this.mCombSendView.setVisibility(0);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mSendBtn, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "383711292")) {
                        ipChange2.ipc$dispatch("383711292", new Object[]{this, animator});
                        return;
                    }
                    ParticleSendGiftButton.this.mSendBtn.setVisibility(4);
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f);
                    ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), ofFloat);
                    ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.3.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1896893385")) {
                                ipChange3.ipc$dispatch("1896893385", new Object[]{this, animator2});
                            }
                        }
                    });
                    ofPropertyValuesHolder2.setDuration(200L).start();
                }
            });
            ofPropertyValuesHolder.setDuration(50L).start();
        }
    }

    private void doActionUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206070102")) {
            ipChange.ipc$dispatch("-1206070102", new Object[]{this});
        } else if (this.isOldSend) {
            OnSendListener onSendListener = this.mOnSendListener;
            if (onSendListener != null) {
                this.comboSend = true;
                int i = this.mComboCount + 1;
                this.mComboCount = i;
                onSendListener.onCombSend(i);
                ((ILog) Dsl.getService(ILog.class)).i("oldSend ", "count= " + this.mComboCount);
            }
        } else {
            this.mCombSendView.touchUp(this.giftType);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914825617")) {
            ipChange.ipc$dispatch("1914825617", new Object[]{this});
            return;
        }
        Context context = getContext();
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_send_gift_linear_button, this);
        this.mSendBtn = (LinearProgressSendButton) findViewById(R.id.id_linear_send_bt);
        CombSendView combSendView = (CombSendView) findViewById(R.id.combSendView);
        this.mCombSendView = combSendView;
        combSendView.setOnCombSendListener(this.onCombSendListener);
        this.mSendBtn.setOnTouchListener(this);
        this.mSendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-615541627")) {
                    ipChange2.ipc$dispatch("-615541627", new Object[]{this, view});
                } else if (ParticleSendGiftButton.this.checkNet()) {
                } else {
                    ParticleSendGiftButton.this.mOnSendListener.onSend();
                }
            }
        });
    }

    public int getCountdownNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-90277812") ? ((Integer) ipChange.ipc$dispatch("-90277812", new Object[]{this})).intValue() : this.beginProgress;
    }

    public void isOldSend(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123891435")) {
            ipChange.ipc$dispatch("-123891435", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isOldSend = z;
        setLayoutParams();
    }

    public void oldDoProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362551227")) {
            ipChange.ipc$dispatch("-362551227", new Object[]{this});
        } else if (this.beginProgress != 100) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mComboInterval;
            this.mHandler.sendEmptyMessageAtTime(3, uptimeMillis + (i - (uptimeMillis % i)));
            this.mSendBtn.setSendText("连送");
            LinearProgressSendButton linearProgressSendButton = this.mSendBtn;
            int i2 = this.beginProgress;
            this.beginProgress = i2 + 1;
            linearProgressSendButton.setProgress(i2);
        } else {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-sendbtn", "resetProgress ");
            resetProgress(false);
            this.mComboCount = 0;
            this.comboSend = false;
            this.mOnSendListener.onRenew();
        }
    }

    public void oldStartShowProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653161087")) {
            ipChange.ipc$dispatch("-653161087", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-combo", "on combo startShowProgress()");
        this.mSendBtn.setProgress(this.beginProgress);
        this.mHandler.sendEmptyMessage(3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372054171")) {
            ipChange.ipc$dispatch("372054171", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1630418503")) {
            return ((Boolean) ipChange.ipc$dispatch("1630418503", new Object[]{this, view, motionEvent})).booleanValue();
        }
        if (!this.isCombo) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-sendbtn", "isComboNOT ");
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.canSend) {
                if (this.mCanCombo) {
                    doActionUp();
                } else {
                    this.mOnSendListener.onSend();
                }
            }
        } else {
            this.mOnSendListener.checkCost();
            if (this.canSend) {
                if (this.mCanCombo) {
                    doActionDown();
                }
            } else {
                this.mOnSendListener.onCombSend(0);
            }
        }
        return true;
    }

    public void resetProgress(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857453548")) {
            ipChange.ipc$dispatch("857453548", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.beginProgress = 0;
        this.mSendBtn.setSendText("赠送");
        this.mSendBtn.reset();
        if (this.isOldSend) {
            this.mHandler.removeMessages(3);
        } else if (this.isSending || z) {
            this.mCombSendView.stopCombSend();
            ((ILog) Dsl.getService(ILog.class)).i("", "checkState=  isSending= " + this.isSending);
        }
    }

    public void setCanCombo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451282512")) {
            ipChange.ipc$dispatch("-1451282512", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mCanCombo = z;
        }
    }

    public void setCombo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199750566")) {
            ipChange.ipc$dispatch("-199750566", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCombo = z;
        setSendBtnSelect();
    }

    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493449234")) {
            ipChange.ipc$dispatch("-493449234", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mComboInterval = (i * 1000) / 100;
        }
    }

    public void setGiftType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879047989")) {
            ipChange.ipc$dispatch("-879047989", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.giftType = i;
        }
    }

    public void setLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388839374")) {
            ipChange.ipc$dispatch("-1388839374", new Object[]{this});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (this.isOldSend) {
            layoutParams.width = UIUtil.dip2px(67);
            layoutParams.height = UIUtil.dip2px(32);
            layoutParams.setMargins(0, 0, UIUtil.dip2px(14), UIUtil.dip2px(9));
        }
        setLayoutParams(layoutParams);
    }

    public void setOnSendListener(OnSendListener onSendListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094311436")) {
            ipChange.ipc$dispatch("1094311436", new Object[]{this, onSendListener});
        } else {
            this.mOnSendListener = onSendListener;
        }
    }

    public void setSendBtnSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054006472")) {
            ipChange.ipc$dispatch("-2054006472", new Object[]{this});
        } else if (this.isSetState) {
        } else {
            this.isSetState = true;
        }
    }

    public void setSendText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600633679")) {
            ipChange.ipc$dispatch("-1600633679", new Object[]{this, charSequence});
            return;
        }
        LinearProgressSendButton linearProgressSendButton = this.mSendBtn;
        if (linearProgressSendButton != null) {
            linearProgressSendButton.setSendText(charSequence);
        }
    }

    public void setSendVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099696268")) {
            ipChange.ipc$dispatch("1099696268", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.canSend = z;
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308911081")) {
            ipChange.ipc$dispatch("308911081", new Object[]{this});
            return;
        }
        doActionDown();
        if (this.isOldSend) {
            oldDoProgress();
        }
    }

    public void switchSendBtnStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334564225")) {
            ipChange.ipc$dispatch("-1334564225", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mSendBtn.setButtonState(z);
        }
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661524936")) {
            ipChange.ipc$dispatch("1661524936", new Object[]{this, giftTheme});
        } else {
            this.mSendBtn.updateTheme(giftTheme);
        }
    }

    public ParticleSendGiftButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCombo = true;
        this.isSetState = false;
        this.isSending = false;
        this.canSend = true;
        this.mComboCount = 0;
        this.comboSend = false;
        this.beginProgress = 0;
        this.PROGRESS = 3;
        this.MAX_PROGRESS = 100;
        this.PROGRESS_INTERVAL = 25;
        this.mComboInterval = 25;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "70747083")) {
                    ipChange.ipc$dispatch("70747083", new Object[]{this, message});
                } else if (message.what != 3) {
                } else {
                    ParticleSendGiftButton.this.oldDoProgress();
                }
            }
        };
        this.onCombSendListener = new CombSendView.OnCombSendListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSend(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "275882581")) {
                    ipChange.ipc$dispatch("275882581", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onCombSend(i);
                ParticleSendGiftButton.this.isSending = true;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSendEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-298681535")) {
                    ipChange.ipc$dispatch("-298681535", new Object[]{this});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onRenew();
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f));
                ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1264883318")) {
                            ipChange2.ipc$dispatch("-1264883318", new Object[]{this, animator});
                            return;
                        }
                        ParticleSendGiftButton.this.mCombSendView.setVisibility(8);
                        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mSendBtn, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
                        ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1854561897")) {
                                    ipChange3.ipc$dispatch("-1854561897", new Object[]{this, animator2});
                                }
                            }
                        });
                        ofPropertyValuesHolder2.setDuration(200L).start();
                    }
                });
                ofPropertyValuesHolder.setDuration(200L).start();
                ParticleSendGiftButton.this.mSendBtn.setVisibility(0);
                ParticleSendGiftButton.this.isSending = false;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onTouchDown() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2139583022")) {
                    ipChange.ipc$dispatch("-2139583022", new Object[]{this});
                } else {
                    ParticleSendGiftButton.this.mOnSendListener.onTouchDown();
                }
            }
        };
        initView();
    }

    public ParticleSendGiftButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isCombo = true;
        this.isSetState = false;
        this.isSending = false;
        this.canSend = true;
        this.mComboCount = 0;
        this.comboSend = false;
        this.beginProgress = 0;
        this.PROGRESS = 3;
        this.MAX_PROGRESS = 100;
        this.PROGRESS_INTERVAL = 25;
        this.mComboInterval = 25;
        this.mHandler = new Handler() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "70747083")) {
                    ipChange.ipc$dispatch("70747083", new Object[]{this, message});
                } else if (message.what != 3) {
                } else {
                    ParticleSendGiftButton.this.oldDoProgress();
                }
            }
        };
        this.onCombSendListener = new CombSendView.OnCombSendListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSend(int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "275882581")) {
                    ipChange.ipc$dispatch("275882581", new Object[]{this, Integer.valueOf(i2)});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onCombSend(i2);
                ParticleSendGiftButton.this.isSending = true;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onCombSendEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-298681535")) {
                    ipChange.ipc$dispatch("-298681535", new Object[]{this});
                    return;
                }
                ParticleSendGiftButton.this.mOnSendListener.onRenew();
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f));
                ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1264883318")) {
                            ipChange2.ipc$dispatch("-1264883318", new Object[]{this, animator});
                            return;
                        }
                        ParticleSendGiftButton.this.mCombSendView.setVisibility(8);
                        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mSendBtn, PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
                        ofPropertyValuesHolder2.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.4.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-1854561897")) {
                                    ipChange3.ipc$dispatch("-1854561897", new Object[]{this, animator2});
                                }
                            }
                        });
                        ofPropertyValuesHolder2.setDuration(200L).start();
                    }
                });
                ofPropertyValuesHolder.setDuration(200L).start();
                ParticleSendGiftButton.this.mSendBtn.setVisibility(0);
                ParticleSendGiftButton.this.isSending = false;
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
            public void onTouchDown() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2139583022")) {
                    ipChange.ipc$dispatch("-2139583022", new Object[]{this});
                } else {
                    ParticleSendGiftButton.this.mOnSendListener.onTouchDown();
                }
            }
        };
        initView();
    }
}
