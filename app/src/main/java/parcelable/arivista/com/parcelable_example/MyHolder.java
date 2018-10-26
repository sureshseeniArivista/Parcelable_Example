package parcelable.arivista.com.parcelable_example;

import android.os.Parcel;
import android.os.Parcelable;

public class MyHolder implements Parcelable {
    int id;
    String title;
    String subTitle;
    int ImageId;

    public MyHolder(int id, String title, String subTitle, int imageId) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        ImageId = imageId;
    }

    public MyHolder(Parcel source) {
        this.id=source.readInt();
        this.title=source.readString();
        this.subTitle=source.readString();
        this.ImageId=source.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(subTitle);
        parcel.writeInt(ImageId);
    }

    public static final Parcelable.Creator<MyHolder> CREATOR = new Parcelable.Creator<MyHolder>() {
        @Override
        public MyHolder createFromParcel(Parcel source) {
            return new MyHolder(source);
        }

        @Override
        public MyHolder[] newArray(int size) {
            return new MyHolder[size];
        }
    };

}
