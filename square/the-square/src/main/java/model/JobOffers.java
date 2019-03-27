package model;

public class JobOffers extends BaseModel {
    String name;
    String description;
    long wage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    public static class Builder {
        String name;
        String description;
        long wage;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withWage(long wage){
            this.wage = wage;
            return this;
        }
        public JobOffers Build() {
            JobOffers job = new JobOffers();
            job.setName(name);
            job.setDescription(description);
            job.setWage(wage);
            return job;
        }
    }
}
