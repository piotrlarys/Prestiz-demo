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

    @Override
    public String toString() {
        return "AjaxPresence{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", checked=" + checked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AjaxPresence that = (AjaxPresence) o;

        if (id != that.id) return false;
        if (checked != that.checked) return false;
        return date.equals(that.date);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + (checked ? 1 : 0);
        return result;
    }
}
