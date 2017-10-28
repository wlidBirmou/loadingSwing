package org.al.percentage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abderrahim
 */
public abstract class LoadingPercentage extends JPanel {

    public static final int MAX_POSITION = 100;
    public static final int MIN_POSITION = 0;

    protected JLabel percentageLabel;
    protected int position = MIN_POSITION;
    protected Dimension sketchDim;
    protected Color textColor;
    protected Color backgroundSketchColor;
    protected Color borderSketchColor;
    protected Color fillingColor;

    Timer timer;
    int goToPosition = 0;
    boolean isProcessing = false;

    public LoadingPercentage() {
        super();
        super.setLayout(null);
        this.textColor = Color.white;
        this.borderSketchColor = new Color(0, 0, 0, 0);
        build();
    }

    private void build() {
        initLabel();
        initEvents();
    }

    private void initLabel() {
        this.percentageLabel = new JLabel(position + "%");
        this.percentageLabel.setVerticalAlignment(JLabel.CENTER);
        this.percentageLabel.setSize(this.getSize().width, this.getSize().height);
        this.percentageLabel.setForeground(textColor);
        this.percentageLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(this.percentageLabel);
    }

    private void initFontSize() {
        FontMetrics fontMetrics = this.percentageLabel.getFontMetrics(percentageLabel.getFont());
        int refLineWidth = fontMetrics.stringWidth("100%");
        int minSketchDim = Math.min(sketchDim.width, sketchDim.height);
        int fontSizePT = percentageLabel.getFont().getSize();
        int newFontSize = Math.max(1, (((minSketchDim * 2) / 3) * fontSizePT) / refLineWidth);
        this.percentageLabel.setFont(new Font(percentageLabel.getFont().getName(), Font.BOLD, newFontSize));
    }

    private void initEvents() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                initSketchDim();
                initFontSize();

            }

            @Override
            public void componentResized(ComponentEvent e) {
                initSketchDim();
                initFontSize();
            }
        });
    }

    private void initSketchDim() {
        this.sketchDim = this.getSketchDimRelativeToPanel();
    }

    public void setPosition(int pos) {
        if (pos > goToPosition) {
            goToPosition = pos;
        }
        if (pos > MAX_POSITION) {
            goToPosition = MAX_POSITION;
        } else {
            goToPosition = pos;
        }
        if (this.position < goToPosition && isProcessing == false) {
            isProcessing = true;
            timer = new Timer(20, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    percentageLabel.setText(position + "%");
                    revalidate();
                    repaint();
                    if (position >= goToPosition) {
                        timer.stop();
                        isProcessing = false;
                    }
                    position++;

                }
            });
            timer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        percentageLabel.setSize(getSize().width, getSize().height);
        initSketchDim();
        drawSketch((Graphics2D) g, sketchDim);
        fillSketch((Graphics2D) g, sketchDim, position);
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        this.percentageLabel.setForeground(this.textColor);
    }

    public Color getBackgroundSketchColor() {
        return backgroundSketchColor;
    }

    public void setBackgroundSketchColor(Color backgroundSketchColor) {
        this.backgroundSketchColor = backgroundSketchColor;
        this.repaint();
    }

    public Color getFillingColor() {
        return fillingColor;
    }

    public void setFillingColor(Color fillingColor) {
        this.fillingColor = fillingColor;
        this.repaint();
    }

    public Color getBorderSketchColor() {
        return borderSketchColor;
    }

    public void setBorderSketchColor(Color color) {
        this.borderSketchColor = color;
        this.repaint();
    }

    public abstract Dimension getSketchDimRelativeToPanel();

    public abstract void drawSketch(Graphics2D graphics, Dimension sketchDimension);

    public abstract void fillSketch(Graphics2D graphics, Dimension sketchDimension, int position);

}
