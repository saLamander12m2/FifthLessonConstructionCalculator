package com.msaggik.fifthlessonconstructioncalculator;

import java.io.Serializable;


public class Drywall implements Serializable {

    private int widthDrywall;
    private int heightDrywall;
    private int costDrywall;

    public Drywall(int widthDrywall, int heightDrywall, int costDrywall) {
        this.widthDrywall = widthDrywall;
        this.heightDrywall = heightDrywall;
        this.costDrywall = costDrywall;
    }

    public int getWidthDrywall() {
        return widthDrywall;
    }

    public int getHeightDrywall() {
        return heightDrywall;
    }

    public int getCostDrywall() {
        return costDrywall;
    }

    public void setWidthDrywall(int widthDrywall) {
        this.widthDrywall = widthDrywall;
    }

    public void setHeightDrywall(int heightDrywall) {
        this.heightDrywall = heightDrywall;
    }

    public void setCostDrywall(int costDrywall) {
        this.costDrywall = costDrywall;
    }
}
