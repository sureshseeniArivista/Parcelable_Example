package parcelable.arivista.com.parcelable_example.holder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import parcelable.arivista.com.parcelable_example.MyHolder;

public class List_Holder implements Parcelable {

    @SerializedName("albumId")
    int albumId;
    @SerializedName("id")
    int id;
    @SerializedName("url")
    String url;
    @SerializedName("title")
    String title;
    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    public List_Holder(int albumId, int id, String url, String title, String thumbnailUrl) {
        this.albumId=albumId;
        this.id = id;
        this.url = url;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public List_Holder(Parcel source) {
        this.id=source.readInt();
        this.albumId=source.readInt();
        this.thumbnailUrl=source.readString();
        this.title=source.readString();
        this.url=source.readString();
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeInt(albumId);
        parcel.writeString(thumbnailUrl);
    }

    public static final Parcelable.Creator<List_Holder> CREATOR = new Parcelable.Creator<List_Holder>() {
        @Override
        public List_Holder createFromParcel(Parcel source) {
            return new List_Holder(source);
        }

        @Override
        public List_Holder[] newArray(int size) {
            return new List_Holder[size];
        }
    };
}