package com.vectorx.principle.openclosed;

import org.junit.Test;

public class OCP1 {

    @Test
    public void test() {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new RectangleShape());
        graphicEditor.drawShape(new CircleShape());
        // 新增三角形绘制
        graphicEditor.drawShape(new TriangleShape());
    }

    // 使用者
    class GraphicEditor {
        public void drawShape(Shape s) {
            if (s.m_type == 1) {
                drawRectangle(s);
            } else if (s.m_type == 2) {
                drawCircle(s);

            } else if (s.m_type == 3) {
                drawTriangle(s);
            }
        }

        public void drawRectangle(Shape r) {
            System.out.println("矩形");
        }

        public void drawCircle(Shape r) {
            System.out.println("圆形");
        }

        public void drawTriangle(Shape r) {
            System.out.println("三角形");
        }
    }

    class Shape {
        public int m_type;
    }

    class RectangleShape extends Shape {
        RectangleShape() {
            m_type = 1;
        }
    }

    class CircleShape extends Shape {
        CircleShape() {
            m_type = 2;
        }
    }

    class TriangleShape extends Shape {
        TriangleShape() {
            m_type = 3;
        }
    }
}
