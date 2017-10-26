package org.al.percentage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.al.LoadingComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author abderrahim
 */
public abstract class LoadingPercentage extends LoadingComponent {

    public static final int MAX_POSITION = 100;
    public static final int MIN_POSITION = 0;

    protected JLabel percentageLabel;
    protected int position = MIN_POSITION;
    protected Dimension sketchDim;
    protected Color textForgroundColor;
    private SwingWorker worker;

    public LoadingPercentage() {
        super();
        super.setLayout(null);
        this.textForgroundColor = Color.white;

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
        this.percentageLabel.setForeground(textForgroundColor);
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
        if (this.position < pos && pos <= 100) {
            if(worker!=null && worker.isDone()){
                worker.cancel(true);
            }
            worker = new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {

                    int initialPosition = position;
                    for (int i = initialPosition; position < pos; i++) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LoadingPie.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        position = i;
                        publish();

                    }
                    return null;
                }

                @Override
                protected void process(List chunks) {
                    super.process(chunks);
                    percentageLabel.setText(position + "%");
                    repaint();
                }

            };
        }

        worker.run();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        percentageLabel.setSize(getSize().width, getSize().height);
        initSketchDim();
        drawSketch((Graphics2D) g, sketchDim);
        fillSketch((Graphics2D) g, sketchDim, position);
    }

    public Color getTextForgroundColor() {
        return textForgroundColor;
    }

    public void setTextForgroundColor(Color textForgroundColor) {
        this.percentageLabel.setForeground(textForgroundColor);
    }

    public abstract Dimension getSketchDimRelativeToPanel();

    public abstract void drawSketch(Graphics2D graphics, Dimension sketchDimension);

    public abstract void fillSketch(Graphics2D graphics, Dimension sketchDimension, int position);

}
