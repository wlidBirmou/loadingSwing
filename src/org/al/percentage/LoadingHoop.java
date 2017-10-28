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
public class LoadingHoop extends LoadingSpinPercentage {

    protected Color backgroundGrithColor;

    protected int fillingAreaWidth;

    public LoadingHoop() {
        this.backgroundSketchColor = Color.WHITE;
        this.fillingColor = new Color(183, 36, 36);
        this.textColor = Color.BLACK;
    }

    @Override
    public void drawSketch(Graphics2D graphics, Dimension sketchDimension) {
        Stroke stroke = graphics.getStroke();
        graphics.setPaint(backgroundGrithColor);
        graphics.fillOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setPaint(borderSketchColor);
        graphics.setStroke(new BasicStroke(1));
        graphics.drawOval(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setStroke(stroke);
    }

    @Override
    public void fillSketch(Graphics2D graphics, Dimension sketchDimension, int position) {
        int angle = -(int) ((360 * position) / 100.);
        Arc2D arc = new Arc2D.Float(gapX / 2, gapY / 2, sketchDimension.getSize().width, sketchDimension.getSize().height, 180, angle, Arc2D.PIE);
        fillingAreaWidth = sketchDimension.height / 4;
        Ellipse2D internalElipse = new Ellipse2D.Float(gapX / 2 + fillingAreaWidth / 2, gapY / 2 + fillingAreaWidth / 2, sketchDimension.width - fillingAreaWidth, sketchDimension.height - fillingAreaWidth);
        Ellipse2D bigEllipse = new Ellipse2D.Float(gapX / 2, gapY / 2, sketchDimension.width, sketchDimension.height);
        graphics.setPaint(backgroundGrithColor);
        graphics.fill(bigEllipse);

        graphics.setPaint(fillingColor);
        graphics.fill(arc);
        graphics.setPaint(backgroundSketchColor);
        graphics.fill(internalElipse);

    }

    public Color getBackgroundGrithColor() {
        return backgroundGrithColor;
    }

    public void setBackgroundGrithColor(Color backgroundGrithColor) {
        this.backgroundGrithColor = backgroundGrithColor;
        this.repaint();
    }

}
