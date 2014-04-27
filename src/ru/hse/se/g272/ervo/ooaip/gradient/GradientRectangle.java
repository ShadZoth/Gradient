package ru.hse.se.g272.ervo.ooaip.gradient;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Прямоугольник с градиентной раскрасской.
 *
 * @author Эрво Виктор
 * @since 17.03.14
 */
public class GradientRectangle extends JComponent {
    /**
     * Максимальное число сегментов.
     */
    public static final int MAX_N = 100;

    /**
     * Первый цвет.
     */
    private Color first = Color.BLACK;

    /**
     * Второй цвет.
     */
    private Color second = Color.WHITE;

    /**
     * Количество сегментов.
     */
    private int n = MAX_N;

    /**
     * Устанавливает первый цвет.
     * @param color Цвет
     */
    public final void setFirst(final Color color) {
        this.first = color;
    }

    /**
     * Устанавливает второй цвет.
     * @param color Цвет
     */
    public final void setSecond(final Color color) {
        this.second = color;
    }

    /**
     * Устанавливает количество сегментов.
     * @param i количество сегментов
     */
    public final void setN(final int i) {
        this.n = i;
    }

    @Override
    protected final void paintComponent(final Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        int sectionWidth = getWidth() / n;
        for (int i = 0; i < n; i++) {
            g.setPaint(new Color(first.getRed()
                    + (second.getRed() - first.getRed()) / n * i,
                    first.getGreen()
                            + (second.getGreen() - first.getGreen()) / n * i,
                    first.getBlue()
                            + (second.getBlue() - first.getBlue()) / n * i));
            g.fillRect(sectionWidth * i, 0, sectionWidth, getHeight());
        }
    }

    /**
     * Первый цвет.
     * @return первый цвет
     */
    public final Color getFirst() {
        return first;
    }

    /**
     * Второй цвет.
     * @return второй цвет
     */
    public final Color getSecond() {
        return second;
    }
}
