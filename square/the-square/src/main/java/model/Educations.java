package model;

import java.util.Date;

public class Educations extends BaseModel {
    String title;
    String description;
    Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Builder {
        String title;
        String description;
        Date date;

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withDate(Date date){
            this.date = date;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Educations Build() {
            Educations edu = new Educations();
            edu.setTitle(title);
            edu.setDescription(description);
            edu.setDate(date);
            return edu;
        }
    }
}
