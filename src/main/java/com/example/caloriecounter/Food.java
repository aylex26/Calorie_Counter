package com.example.caloriecounter;


// get si set pentru backendless
public class Food {
    private String name;
    private String calorii;
    private String carbo;
    private String proteine;
    private String grasimi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalorii() {
        return calorii;
    }

    public void setCalorii(String calorii) {
        this.calorii = calorii;
    }

    public String getCarbo() {
        return carbo;
    }

    public void setCarbo(String carbo) {
        this.carbo = carbo;
    }

    public String getProteine() {
        return proteine;
    }

    public void setProteine(String proteine) {
        this.proteine = proteine;
    }

    public String getGrasimi() {
        return grasimi;
    }

    public void setGrasimi(String grasimi) {
        this.grasimi = grasimi;
    }
}
