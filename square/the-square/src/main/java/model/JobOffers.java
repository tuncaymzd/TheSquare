package model;

public class JobOffers extends BaseModel {
    String name;
    String description;
    long wage;
    int idCompagny;

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

    public int getIdCompagny() {
        return idCompagny;
    }

    public void setIdCompagny(int idCompagny) {
        this.idCompagny = idCompagny;
    }

    public static class Builder {
        String name;
        String description;
        long wage;
        int idCompagny;

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

        public Builder withIdCompagny(int idCompagny) {
            this.idCompagny = idCompagny;
            return this;
        }

        public JobOffers Build() {
            JobOffers job = new JobOffers();
            job.setName(name);
            job.setDescription(description);
            job.setWage(wage);
            job.setIdCompagny(idCompagny);
            return job;
        }
    }
}
