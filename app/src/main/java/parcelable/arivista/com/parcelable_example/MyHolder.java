package parcelable.arivista.com.parcelable_example;

public class MyHolder {
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
}
