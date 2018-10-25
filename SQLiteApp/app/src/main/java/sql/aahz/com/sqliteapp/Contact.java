package sql.aahz.com.sqliteapp;

public class Contact {
    private int _id;
    private String _name;
    private String _number;

    public Contact() {}

    public Contact(final String _name, final String _number) {
        this._name = _name;
        this._number = _number;
    }

    public Contact(final int _id, final String _name, final String _number) {
        this._id = _id;
        this._name = _name;
        this._number = _number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_number() {
        return _number;
    }

    public void set_number(String _number) {
        this._number = _number;
    }
}
