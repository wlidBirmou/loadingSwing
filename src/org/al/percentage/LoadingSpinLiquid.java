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
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author abderrahim
 */
public class LoadingSpinLiquid extends LoadingSpinPercentage {

    public LoadingSpinLiquid() {
        this.fillingColor = new Color(31, 164, 209);
        this.backgroundSketchColor = Color.white;
        this.textColor = new Color(79, 79, 79);
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
        int liquidHeight = (sketchDimension.height * position) / 100;

        Ellipse2D ellipse = new Ellipse2D.Float(this.gapX / 2, this.gapY / 2, sketchDimension.width, sketchDimension.height);
        Rectangle2D rectangle = new Rectangle2D.Float(this.gapX / 2, this.gapY / 2 + sketchDimension.height - liquidHeight, sketchDimension.width, liquidHeight);
        Area fillingArea = new Area(ellipse);
        fillingArea.intersect(new Area(rectangle));
        graphics.setPaint(fillingColor);
        graphics.fill(fillingArea);

    }
}
