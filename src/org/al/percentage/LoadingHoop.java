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
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author abderrahim
 */
public class LoadingHoop extends LoadingSpinnerPercentage{    protected Color backgroundSpinColor;
    protected Color borderSpinColor;
    protected Color fillingColor;
    protected int fillingAreaWidth;

    public LoadingHoop() {
        this.fillingColor = new Color(142, 11, 15);
        this.backgroundSpinColor = Color.WHITE;
        this.borderSpinColor = new Color(142, 11, 15);
        this.setTextForgroundColor(Color.BLACK);
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

    public void setBorderSpinColor(Color borderSpinColor) {
        this.borderSpinColor = borderSpinColor;
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
        Arc2D arc=new Arc2D.Float(gapX / 2, gapY / 2, sketchDimension.getSize().width, sketchDimension.getSize().height, 180, angle,Arc2D.PIE);
        fillingAreaWidth=sketchDimension.height/4;
        Ellipse2D ellipse=new Ellipse2D.Float(gapX / 2+fillingAreaWidth/2, gapY / 2+fillingAreaWidth/2, sketchDimension.width-fillingAreaWidth, sketchDimension.height-fillingAreaWidth);
        graphics.setPaint(fillingColor);
        graphics.fill(arc);
        graphics.setPaint(backgroundSpinColor);
        graphics.fill(ellipse);
    }

}
