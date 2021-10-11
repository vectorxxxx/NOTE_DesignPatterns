package com.vectorx.principle.openclosed;

import org.junit.Test;

public class OCP2 {

    @Test
    public void test() {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new RectangleShape());
        graphicEditor.drawShape(new CircleShape());
        graphicEditor.drawShape(new TriangleShape());
        graphicEditor.drawShape(new OtherGraphic());
    }

    // 使用者
    class GraphicEditor {
        public void drawShape(Shape s) {
            s.draw();
        }
    }

    abstract class Shape {
        int m_type;

        public abstract void draw();
    }

    class RectangleShape extends Shape {
        RectangleShape() {
            m_type = 1;
        }

        @Override
        public void draw() {
            System.out.println("矩形");
        }
    }

    class CircleShape extends Shape {
        CircleShape() {
            m_type = 2;
        }

        @Override
        public void draw() {
            System.out.println("圆形");
        }
    }

    class TriangleShape extends Shape {
        TriangleShape() {
            m_type = 3;
        }

        @Override
        public void draw() {
            System.out.println("三角形");
        }
    }

    class OtherGraphic extends Shape {
        OtherGraphic() {
            m_type = 4;
        }

        @Override
        public void draw() {
            System.out.println("其他图形");
        }
    }
}
