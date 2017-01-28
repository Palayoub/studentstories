package ayoub;

/**
 * Created by ayoub on 25/01/2017.
 */

public class Student {
    private int _id;
    private String _name;
    private String _email;
    private String _password;

    public Student() {

    }

    public Student(String name, String email, String password) {
        _name = name;
        _email = email;
        _password = password;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public int get_id() {

        return _id;
    }

    public String get_password() {
        return _password;
    }

    public String get_email() {
        return _email;
    }

    public String get_name() {
        return _name;
    }
}
