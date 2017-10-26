/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.al;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author abderrahim
 */
public class LoadingPie extends LoadingSpinner {

    protected Color backgroundSpinColor;
    protected Color borderSpinColor;
    protected Color fillingColor;

    public LoadingPie() {
        this.fillingColor = new Color(22, 24, 79);
        this.backgroundSpinColor = new Color(107, 109, 109);
        this.borderSpinColor = new Color(68, 68, 68);
    }

    public Color getFillingColor() {
        return fillingColor;
    }

    public void setFillingColor(Color fillingColor) {
        this.fillingColor = fillingColor;
    }

    public Color getBackgroundSpinColor() {
        return backgroundSpinColor;
    }

    public void setBackgroundSpinColor(Color backgroundSpinColor) {
        this.backgroundSpinColor = backgroundSpinColor;
    }

    public Color getBorderSpinColor() {
        return borderSpinColor;
    }

    public void setBorderSpinColor(Color BorderSpinColor) {
        this.borderSpinColor = BorderSpinColor;
    }

    @Override
    public void drawSketch(Graphics2D graphics, Dimension sketchDimension) {
        Stroke stroke = graphics.getStroke();
        graphics.setPaint(backgroundSpinColor);
        graphics.fillOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setPaint(borderSpinColor);
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
