package Java_HW_5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class wave {
    public static void main(String[] args) {
        map myMap = new map();
        myMap.generateStartMap();
        System.out.println(new mapPrinter().mapToString(myMap.getMap()));

        var waveAlgorithm = new waveAlgorithm(myMap.getMap());
        var startPoint = new point2D(1, 1);
        waveAlgorithm.fillMap(startPoint);

        System.out.println(new mapPrinter().mapToString(myMap.getMap()));

        var finishPoint = new point2D(8, 4);
        var road = waveAlgorithm.getRoad(finishPoint, startPoint, myMap.getMap());

        for (point2D coordinate : road) {
            System.out.println(coordinate);
        }
    }
}

class point2D {
    int x, y;

    public point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }
}

class map {
    int[][] map;

    public void generateStartMap() {

        this.map = new int[][]{
                { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, -1, -1, -1, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
    }

    public int[][] getMap() {
        return map;
    }

}

class mapPrinter {
    public String mapToString(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                sb.append(String.format("%3d", anInt));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

class waveAlgorithm {
    int[][] map;

    public waveAlgorithm(int[][] map) {
        this.map = map;
    }

    public void fillMap(point2D startPoint) {
        Queue<point2D> queue = new LinkedList<>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            point2D p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new point2D(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new point2D(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new point2D(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new point2D(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    public ArrayList<point2D> getRoad(point2D exit, point2D start, int[][] map) {
        ArrayList<point2D> road = new ArrayList<>();
        if (map[exit.x][exit.y] != 0 && map[exit.x][exit.y]!=-1) {
            road.add(new point2D(exit.x, exit.y));

            System.out.println("There is definitely a path");

            while (map[exit.x][exit.y] != map[start.x][start.y]) {

                if (map[exit.x - 1][exit.y] == map[exit.x][exit.y] - 1) {
                    exit.x = exit.x - 1;
                    road.add(new point2D(exit.x, exit.y));
                }

                else if (map[exit.x][exit.y - 1] == map[exit.x][exit.y] - 1) {
                    exit.y = exit.y - 1;
                    road.add(new point2D(exit.x, exit.y));
                }

                else if (map[exit.x + 1][exit.y] == map[exit.x][exit.y] - 1) {
                    exit.x = exit.x + 1;
                    road.add(new point2D(exit.x, exit.y));
                }

                else if (map[exit.x][exit.y + 1] == map[exit.x][exit.y] - 1) {
                    exit.y = exit.y + 1;
                    road.add(new point2D(exit.x, exit.y));
                }
            }

        } else {
            System.out.println("Path not found");
        }
        return road;
    }
}