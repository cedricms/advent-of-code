package com.adventofcode.challenge2019;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.challenge2019.model.Point;
import com.adventofcode.challenge2019.model.Segment;

public class Day3 extends Day {

    public int findManhattanDistanceFromCentralPortToClosestIntersection(String inputFilePath) {
        List<String> wires = readFileWithLinesToStringList(inputFilePath);

        List<Segment> horizontalSegments = findHorizontalSegments(wires.get(0));
        List<Segment> verticalSegments = findVerticalSegments(wires.get(1));

        List<Point> intersections = findIntersections(horizontalSegments, verticalSegments);
        System.out.println("intersections : " + intersections.size());

        Point closestIntersection = getClosestIntersection(intersections);

        return getManhattenDistance(closestIntersection);
    }

    private List<Segment> findHorizontalSegments(String wire) {
        List<Segment> segments =  new ArrayList();

        Point currentPosition = new Point();

        String[] deplacements = wire.split(",");

        for (int i = 0; i < deplacements.length; i++) {
            String deplacement = deplacements[i];

            Segment segment = getSegment(currentPosition, deplacement);

            char direction = deplacement.charAt(0);
            if ((direction == 'L') || (direction == 'R')) {
                segments.add(segment);
            }
        }

        return segments;
    }

    private Segment getSegment(Point currentPosition, String deplacement) {
        int x1 = currentPosition.getX();
        int y1 = currentPosition.getY();

        char direction = deplacement.charAt(0);
        int deplacementLength = Integer.parseInt(deplacement.substring(1));
        switch(direction) {
            case 'D' :
                currentPosition.setY(currentPosition.getY() - deplacementLength);
                break;
            case 'L' :
                currentPosition.setX(currentPosition.getX() - deplacementLength);
                break;
            case 'R' :
                currentPosition.setX(currentPosition.getX() + deplacementLength);
                break;
            case 'U' :
                currentPosition.setY(currentPosition.getY() + deplacementLength);
                break;
            default :
                // Do nothing
                break;
        }

        return new Segment(x1, y1, currentPosition.getX(), currentPosition.getY());
    }

    private List<Segment> findVerticalSegments(String wire) {
        List<Segment> segments =  new ArrayList();

        Point currentPosition = new Point();

        String[] deplacements = wire.split(",");

        for (int i = 0; i < deplacements.length; i++) {
            String deplacement = deplacements[i];

            Segment segment = getSegment(currentPosition, deplacement);

            char direction = deplacement.charAt(0);
            if ((direction == 'D') || (direction == 'U')) {
                segments.add(segment);
            }
        }

        return segments;
    }

    private List<Point> findIntersections(List<Segment> horizontalSegments, List<Segment> verticalSegments) {
        List<Point> intersections = new ArrayList();

        for (Segment horizontalSegment : horizontalSegments) {
            for (Segment verticalSegment : verticalSegments) {
                Point intersection = getIntersection(horizontalSegment, verticalSegment);

                if (intersection != null) {
                    intersections.add(intersection);
                }
            }
        }

        return intersections;
    }

    private Point getIntersection(Segment horizontalSegment, Segment verticalSegment) {
        System.out.println("Horizontal : [(" + horizontalSegment.getX1() + ", " + horizontalSegment.getY1()
            + ", " + horizontalSegment.getX2() + ", " + horizontalSegment.getY2() + ")]"
            + " Vertical : [(" + verticalSegment.getX1() + ", " + verticalSegment.getY1()
            + ", " + verticalSegment.getX2() + ", " + verticalSegment.getY2() + ")]");
        int verticalX = verticalSegment.getX1();
        if ((horizontalSegment.getX1() < verticalX) && (verticalX < horizontalSegment.getX2())) {
            int horizontalY = horizontalSegment.getY1();
            if ((verticalSegment.getY1() < horizontalY) && (horizontalY < verticalSegment.getY2())) {
                return new Point(verticalX, horizontalY);
            }
        }

        return null;
    }

    private Point getClosestIntersection(List<Point> intersections) {
        Point closestIntersection = new Point(0, 0);
        Integer closestIntersectionManhattenDistance = null;

        for(Point point : intersections) {
            int pointManhattenDistance = getManhattenDistance(point);
            if ((closestIntersectionManhattenDistance == null) || (pointManhattenDistance < closestIntersectionManhattenDistance)) {
                closestIntersectionManhattenDistance = pointManhattenDistance;
                closestIntersection = point;
            }
        }

        return closestIntersection;
    }

    private int getManhattenDistance(Point point) {
        return Math.abs(point.getX()) + Math.abs(point.getY());
    }
}