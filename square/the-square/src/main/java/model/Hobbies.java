package model;

public class Hobbies extends BaseModel {
    String title;
    String description;

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

    public static class Builder {
        String title;
        String description;

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Hobbies Build() {
            Hobbies hob = new Hobbies();
            hob.setTitle(title);
            hob.setDescription(description);
            return hob;
        }
    }
}
