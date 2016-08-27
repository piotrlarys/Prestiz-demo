package pl.larys.prestige.domain.json;

/**
 * Created by piotr on 15.08.16.
 */
public class AjaxPresence {

    private int id;

    private String date;

    private boolean checked;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
