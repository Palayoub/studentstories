package ayoub;

/**
 * Created by ayoub on 26/01/2017.
 */

public class Post {
    private int _id;
    private int _fk;
    private int _likes;
    private String _subject;
    private String _content;

    public Post(int fk, String subject, String content) {
        _fk = fk;
        _subject = subject;
        _content = content;
    }

    public String get_subject() {
        return _subject;
    }

    public void set_subject(String _subject) {
        this._subject = _subject;
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public void set_likes(int _likes) {
        this._likes = _likes;
    }

    public void set_fk(int _fk) {
        this._fk = _fk;
    }

    public int get_fk() {

        return _fk;
    }

    public int get_likes() {
        return _likes;
    }

    public String get_content() {
        return _content;
    }
}
