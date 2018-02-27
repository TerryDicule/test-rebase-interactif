package net.worldline.docid.android.lib.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by A176123 on 15/02/2017.
 */

public class ErrorResponse implements Parcelable{

    private static final String TAG = ErrorResponse.class.getSimpleName();

    private ErrorCode errorType;
    private String message;
    private String reason;

    public enum ErrorCode {
        CONFIG_ERROR, PROCESSING_ERROR
    };

    public ErrorResponse(ErrorCode errorType, String message, String reason) {
        this.errorType = errorType;
        this.message = message;
        this.reason = reason;
    }

    // parcelable
    private ErrorResponse(Parcel src) {
        errorType = ErrorCode.valueOf(src.readString());
        message = src.readString();
        reason = src.readString();
    }

    @Override
    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeString(errorType.name());
        dest.writeString(message);
        dest.writeString(reason);
    }

    public static final Parcelable.Creator<ErrorResponse> CREATOR = new Parcelable.Creator<ErrorResponse>() {

        @Override
        public ErrorResponse createFromParcel(Parcel source) {
            return new ErrorResponse(source);
        }

        @Override
        public ErrorResponse[] newArray(int size) {
            return new ErrorResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorCode errorType) {
        this.errorType = errorType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
