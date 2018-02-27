package net.worldline.docid.android.lib.api;

import android.os.Parcel;
import android.os.Parcelable;

import net.worldline.docid.android.lib.data.Sex;

/**
 * Created by A176123 on 15/02/2017.
 */

public class Identity implements Parcelable{

    private static final String TAG = Identity.class.getSimpleName();

    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private Sex gender;
    private String nationality;



    public Identity(String lastname, String firstname, String birthdate, Sex sex, String nationality) {
        this.lastName = lastname;
        this.firstName = firstname;
        this.dateOfBirth = birthdate;
        this.gender = sex;
        this.nationality = nationality;
    }

    // parcelable
    private Identity(Parcel src) {
        lastName = src.readString();
        firstName = src.readString();
        dateOfBirth = src.readString();
        gender = Sex.valueOf(src.readString());
        nationality = src.readString();
    }

    @Override
    public final void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lastName);
        dest.writeString(firstName);
        dest.writeString(dateOfBirth);
        dest.writeString(gender.name());
        dest.writeString(nationality);
    }

    public static final Parcelable.Creator<Identity> CREATOR = new Parcelable.Creator<Identity>() {

        @Override
        public Identity createFromParcel(Parcel source) {
            return new Identity(source);
        }

        @Override
        public Identity[] newArray(int size) {
            return new Identity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
