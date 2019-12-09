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

    public int findFewestCombinedStepsWiresMustTakeToReachAnIntersection(String inputFilePath) {
        List<String> wires = readFileWithLinesToStringList(inputFilePath);

        String wire1 = wires.get(0);
        List<Segment> wire1Segments = findSegments(wire1);
        String wire2 = wires.get(1);
        List<Segment> wire2Segments = findSegments(wire2);

        List<Point> intersections = findIntersections(wire1Segments, wire2Segments);

        return getFewestCombinedStepsWiresMustTakeToReachAnIntersection(intersections, wire1Segments, wire2Segments);
    }

    private int getFewestCombinedStepsWiresMustTakeToReachAnIntersection(List<Point> intersections, List<Segment> wire1Segments, List<Segment> wire2Segments) {
        int minCombinedSteps = 0;

        for (Point intersection : intersections) {
            int distanceToIntersection1 = getDistanceToIntersection(intersection, wire1Segments);
            int distanceToIntersection2 = getDistanceToIntersection(intersection, wire2Segments);

            int combinedDistances = distanceToIntersection1 + distanceToIntersection2;

            if (minCombinedSteps == 0
                || combinedDistances < minCombinedSteps) {
                minCombinedSteps = combinedDistances;
            }
        }

        return minCombinedSteps;
    }

    private int getDistanceToIntersection(Point intersection, List<Segment> wireSegments) {
        int distance = 0;

        Point currentPoint = new Point();

        for (Segment wireSegment : wireSegments) {
            if (wireSegment.intersectsPoint(intersection)) {
                Segment lastSegment = new Segment(currentPoint.getX(), currentPoint.getY()
                                                , intersection.getX(), intersection.getY());
                return distance + lastSegment.getLength();
            } else {
                if (wireSegment.getX1() == currentPoint.getX()
                    && wireSegment.getY1() == currentPoint.getY()) {
                    currentPoint = new Point(wireSegment.getX2(), wireSegment.getY2());
                } else {
                    currentPoint = new Point(wireSegment.getX1(), wireSegment.getY1());
                }

                distance = distance + wireSegment.getLength();
            }
        }

        return distance;
    }
}