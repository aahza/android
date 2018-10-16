package test.aahz.com.mvcapp;

public class Profile {
    int photo;
    String fName, sName;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Profile(int photo, String fName, String sName) {
        this.photo = photo;
        this.fName = fName;
        this.sName = sName;
    }
}
