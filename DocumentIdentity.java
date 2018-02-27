package net.worldline.docid.android.lib.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by A176123 on 15/02/2017.
 */

public class DocumentIdentity implements Parcelable {

    private static final String TAG = DocumentIdentity.class.getSimpleName();

    private String mrzContent;
    private int mrzDocumentType;
    private String issuingCountry;
    private String documentNumber;
    private String documentExpirationDate;

    public DocumentIdentity(String mrzContent, int mrzDocumentType, String issuingCountry, String documentNumber, String documentExpirationDate) {
        this.mrzContent = mrzContent;
        this.mrzDocumentType = mrzDocumentType;
        this.issuingCountry = issuingCountry;
        this.documentNumber = documentNumber;
        this.documentExpirationDate = documentExpirationDate;
    }

    // parcelable
    private DocumentIdentity(Parcel src) {
        mrzContent = src.readString();
        mrzDocumentType = src.readInt();
        issuingCountry = src.readString();
        documentNumber = src.readString();
        documentExpirationDate = src.readString();
    }

    @Override
    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mrzContent);
        dest.writeInt(mrzDocumentType);
        dest.writeString(issuingCountry);
        dest.writeString(documentNumber);
        dest.writeString(documentExpirationDate);
    }

    public static final Parcelable.Creator<DocumentIdentity> CREATOR = new Parcelable.Creator<DocumentIdentity>() {

        @Override
        public DocumentIdentity createFromParcel(Parcel source) {
            return new DocumentIdentity(source);
        }

        @Override
        public DocumentIdentity[] newArray(int size) {
            return new DocumentIdentity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getMrzContent() {
        return mrzContent;
    }

    public void setMrzContent(String mrzContent) {
        this.mrzContent = mrzContent;
    }

    public int getMrzDocumentType() {
        return mrzDocumentType;
    }

    public void setMrzDocumentType(int mrzDocumentType) {
        this.mrzDocumentType = mrzDocumentType;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentExpirationDate() {
        return documentExpirationDate;
    }

    public void setDocumentExpirationDate(String documentExpirationDate) {
        this.documentExpirationDate = documentExpirationDate;
    }
}
