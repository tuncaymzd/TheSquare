package model;

public class ActivitiesDomain extends BaseModel {
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
        public ActivitiesDomain Build() {
            ActivitiesDomain ac = new ActivitiesDomain();
            ac.setName(name);
            return ac;
        }
    }
}
