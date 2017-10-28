/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.al.percentage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author abderrahim
 */
public class LoadingPie extends LoadingSpinPercentage {

    public LoadingPie() {
        this.fillingColor = new Color(183, 36, 36);
        this.backgroundSketchColor = new Color(244, 166, 166);
    }

    @Override
    public void drawSketch(Graphics2D graphics, Dimension sketchDimension) {
        Stroke stroke = graphics.getStroke();
        graphics.setPaint(backgroundSketchColor);
        graphics.fillOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setPaint(borderSketchColor);
        graphics.setStroke(new BasicStroke(1));
        graphics.drawOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setStroke(stroke);
    }

    @Override
    public void fillSketch(Graphics2D graphics, Dimension sketchDimension, int position) {
        int angle = -(int) ((360 * position) / 100.);
        graphics.setPaint(fillingColor);
        graphics.fillArc(gapX / 2, gapY / 2, sketchDimension.getSize().width, sketchDimension.getSize().height, 180, angle);
    }
}
