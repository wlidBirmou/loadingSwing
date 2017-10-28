package org.al.percentage;

import java.awt.Dimension;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abderrahim
 */
public abstract class LoadingSpinPercentage extends LoadingPercentage {

    protected int gapX = 6;
    protected int gapY = 6;

    public LoadingSpinPercentage() {
        super();

    }

    @Override
    public Dimension getSketchDimRelativeToPanel() {
        int sketchSide;
        if (getSize().height == Math.min(getSize().width, getSize().height)) {
            gapY = 6;
            sketchSide = getSize().height - gapY;
            gapX = getSize().width - sketchSide;

        } else {
            gapX = 6;
            sketchSide = getSize().width - gapX;
            gapY = getSize().height - sketchSide;
        }
        return new Dimension(sketchSide, sketchSide);
    }

}
