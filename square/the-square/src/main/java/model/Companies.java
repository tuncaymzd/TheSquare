package model;

public class Companies extends BaseModel{
    String name;
    long siret;
    long siren;
    String description;
    int idActivitiy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSiret() {
        return siret;
    }

    public void setSiret(long siret) {
        this.siret = siret;
    }

    public long getSiren() {
        return siren;
    }

    public void setSiren(long siren) {
        this.siren = siren;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdActivitiy() {
        return idActivitiy;
    }

    public void setIdActivitiy(int idActivitiy) {
        this.idActivitiy = idActivitiy;
    }

    public static class Builder {
        String name;
        String description;
        long siret;
        long siren;
        int idActivitiy;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withSiret(long siret){
            this.siret = siret;
            return this;
        }

        public Builder withSiren(long siren){
            this.siren = siren;
            return this;
        }

        public Builder withIdActivitiy(int idActivitiy){
            this.idActivitiy = idActivitiy;
            return this;
        }

        public Companies Build() {
            Companies com = new Companies();
            com.setDescription(description);
            com.setName(name);
            com.setSiren(siren);
            com.setSiret(siret);
            com.setIdActivitiy(idActivitiy);
            return com;
        }
    }
}
