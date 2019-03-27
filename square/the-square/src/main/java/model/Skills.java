package model;

public class Skills extends BaseModel {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        String name;

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Skills Build() {
            Skills skills = new Skills();
            skills.setName(name);
            return skills;
        }
    }
}
