package com.alibaba.security.biometrics.service.state;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Message;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.result.ALFaceDetectResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class FaceDetectState extends BaseState {
    public FaceDetectState(ABStateMachine aBStateMachine) {
        super(aBStateMachine);
    }

    private void doFaceDetect(ABFaceFrame aBFaceFrame) {
        ALFaceDetectResult aLFaceDetectResult = new ALFaceDetectResult();
        if (aBFaceFrame != null && aBFaceFrame.getDetectInfo() != null) {
            if (aBFaceFrame.getDetectInfo().getStaticQuality() > 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().getStaticQuality());
            } else if (aBFaceFrame.getDetectInfo().getFaceQuality() >= 0.0f) {
                aLFaceDetectResult.setFaceQuality(aBFaceFrame.getDetectInfo().getFaceQuality());
            }
            if (aBFaceFrame.getDetectInfo().getBrightness() >= 0.0f) {
                aLFaceDetectResult.setBrightness(aBFaceFrame.getDetectInfo().getBrightness());
            }
            if (aBFaceFrame.getDetectInfo().getGaussianBlur() >= 0.0f) {
                aLFaceDetectResult.setGaussianBlur(aBFaceFrame.getDetectInfo().getGaussianBlur());
            }
            aLFaceDetectResult.setImageWidth(aBFaceFrame.getImageWidth());
            aLFaceDetectResult.setImageHeight(aBFaceFrame.getImageHeight());
            aLFaceDetectResult.setPitchScore(aBFaceFrame.getDetectInfo().getPitchScore());
            aLFaceDetectResult.setYawScore(aBFaceFrame.getDetectInfo().getYawScore());
            aLFaceDetectResult.setMouthScore(aBFaceFrame.getDetectInfo().getMouthScore());
            aLFaceDetectResult.setBlinkScore(aBFaceFrame.getDetectInfo().getBlinkScore());
            aLFaceDetectResult.setLandmarkScore(aBFaceFrame.getDetectInfo().getLandmarkScore());
            aLFaceDetectResult.setBrightDiff(aBFaceFrame.getDetectInfo().getBrightDiff());
            aLFaceDetectResult.setBackHighlight(aBFaceFrame.getDetectInfo().getBackHightlight());
            aLFaceDetectResult.setFaceSpeed(aBFaceFrame.getDetectInfo().getFaceSpeed());
        }
        if (aBFaceFrame != null && aBFaceFrame.hasFace()) {
            aLFaceDetectResult.setFacesDetected(aBFaceFrame.facesDetected());
            if (aBFaceFrame.getFacePos() != null) {
                aLFaceDetectResult.setFacePosition(new RectF(aBFaceFrame.getFacePos()));
            }
            if (aBFaceFrame.getFaceSize() != null) {
                aLFaceDetectResult.setFaceSize(new Rect(aBFaceFrame.getFaceSize()));
            }
            aLFaceDetectResult.setCheckResult(aBFaceFrame.getDetectInfo().getCheckResult());
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_RESULT)) {
                aLFaceDetectResult.setSuccess(aBFaceFrame.getExts().getBoolean(ALBiometricsKeys.KEY_RESULT, false));
                if (aLFaceDetectResult.isSuccess() && this.mDetector.getValidFrames() != null && this.mDetector.getValidFrames().size() > 0) {
                    aLFaceDetectResult.setBestImageData(this.mDetector.getValidFrames().get(0).getImageData());
                }
            }
            if (aBFaceFrame.getExts() != null && aBFaceFrame.getExts().containsKey(ALBiometricsKeys.KEY_ERROR_CODE)) {
                aLFaceDetectResult.setErrors(aBFaceFrame.getExts().getIntArray(ALBiometricsKeys.KEY_ERROR_CODE));
            }
        }
        ABDetectContext.getInstance().getResult().setFaceResult(aLFaceDetectResult);
        this.mABStateMachine.sendMessage(100);
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState
    protected String currentState() {
        return "FaceDetectState";
    }

    @Override // com.alibaba.security.biometrics.service.state.BaseState, com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public void enter() {
        super.enter();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.FACE_DETECT);
    }

    @Override // com.alibaba.security.biometrics.service.util.state.State, com.alibaba.security.biometrics.service.util.state.IState
    public boolean processMessage(Message message) {
        if (message.what != 99) {
            return false;
        }
        Object obj = message.obj;
        if (obj != null) {
            doFaceDetect((ABFaceFrame) obj);
            return true;
        }
        return true;
    }
}
