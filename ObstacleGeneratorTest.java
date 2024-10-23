import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ObstacleGeneratorTest {

    @Test
    void getObstacles() {
        Levels currentLevel = new Levels(1, 10, 2, 5, 150); // Example level values
        ObstacleGenerator obstacleGenerator = new ObstacleGenerator(currentLevel, null);

        assertTrue(obstacleGenerator.getObstacles() instanceof ArrayList<Obstacle>);

    }

    @Test
    void resetObstacles() {
    }
}