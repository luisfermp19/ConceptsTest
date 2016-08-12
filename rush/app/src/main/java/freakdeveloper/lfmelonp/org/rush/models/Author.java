package freakdeveloper.lfmelonp.org.rush.models;

import java.util.Date;

import co.uk.rushorm.core.RushCallback;
import co.uk.rushorm.core.RushCore;
import co.uk.rushorm.core.RushObject;

/**
 * Created by a67233924 on 11/8/16.
 */
public class Author extends RushObject {
    private String name;
    private String surname;
    private Date birthDate;


    public Author() {
    }

    public Author(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    @Override
    public void save() { RushCore.getInstance().save(this); }
    @Override
    public void save(RushCallback callback) { RushCore.getInstance().save(this, callback); }
    @Override
    public void delete() { RushCore.getInstance().delete(this); }
    @Override
    public void delete(RushCallback callback) { RushCore.getInstance().delete(this, callback); }
    @Override
    public String getId() { return RushCore.getInstance().getId(this); }
}
