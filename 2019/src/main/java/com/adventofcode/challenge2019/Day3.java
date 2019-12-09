package com.adventofcode.challenge2019;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.challenge2019.model.Point;
import com.adventofcode.challenge2019.model.Segment;

public class Day3 extends Day {

    public int findManhattanDistanceFromCentralPortToClosestIntersection(String inputFilePath) {
        List<String> wires = readFileWithLinesToStringList(inputFilePath);

        String wire1 = wires.get(0);
        List<Segment> wire1Segments = findSegments(wire1);
        String wire2 = wires.get(1);
        List<Segment> wire2Segments = findSegments(wire2);

        List<Point> intersections = findIntersections(wire1Segments, wire2Segments);

        Point closestIntersection = getClosestIntersection(intersections);

        return getManhattenDistance(closestIntersection);
    }

    private List<Segment> findSegments(String wire) {
        List<Segment> segments =  new ArrayList();

        Point currentPosition = new Point();

        String[] deplacements = wire.split(",");

        for (int i = 0; i < deplacements.length; i++) {
            String deplacement = deplacements[i];

            Segment segment = getSegment(currentPosition, deplacement);

            segments.add(segment);
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

    private List<Point> findIntersections(List<Segment> wire1Segments, List<Segment> wire2Segments) {
        List<Point> intersections = new ArrayList();

        for (Segment wire1Segment : wire1Segments) {
            for (Segment wire2Segment : wire2Segments) {
                Point intersection = getIntersection(wire1Segment, wire2Segment);

                if (intersection != null) {
                    if (!intersection.equals(new Point(0, 0))) {
                        intersections.add(intersection);
                    }
                }
            }
        }

        return intersections;
    }

    private Point getIntersection(Segment wire1Segment, Segment wire2Segment) {
        // Case wire 1 horizontal and wire 2 vertical or the oposite
        if (wire1Segment.isHorizontal()) {
            if (wire2Segment.isVertical()) {
                return getSegmentIntersection(wire1Segment, wire2Segment);
            }
        } else if (wire2Segment.isHorizontal()) {
            if (wire1Segment.isVertical()) {
                return getSegmentIntersection(wire2Segment, wire1Segment);
            }
        }

        return null;
    }

    private Point getSegmentIntersection(Segment horizontal, Segment vertical) {
        int verticalX = vertical.getX1();

        if ((horizontal.getX1() <= verticalX) && (verticalX <= horizontal.getX2())) {
            int horizontalY = horizontal.getY1();

            if ((vertical.getY1() <= horizontalY) && (horizontalY <= vertical.getY2())) {
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