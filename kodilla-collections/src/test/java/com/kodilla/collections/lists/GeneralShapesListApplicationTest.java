package com.kodilla.collections.lists;

import com.kodilla.collections.interfaces.Circle;
import com.kodilla.collections.interfaces.Shape;
import com.kodilla.collections.interfaces.Square;
import com.kodilla.collections.interfaces.Triangle;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralShapesListApplicationTest {

    @Test
    public void testShapeListOperations() {
        // Arrange
        List<Shape> shapes = new LinkedList<>();
        Square square = new Square(10.0);
        Triangle triangle = new Triangle(10.0, 4.0, 10.77);

        // Act
        shapes.add(square);
        shapes.add(new Circle(7.0));
        shapes.add(triangle);

        shapes.remove(1); // Usuwanie koła
        shapes.remove(square); // Usuwanie kwadratu
        shapes.remove(triangle); // Usuwanie trójkąta

        // Assert
        assertEquals(0, shapes.size(), "Lista powinna być pusta po usunięciu wszystkich elementów.");
    }
}