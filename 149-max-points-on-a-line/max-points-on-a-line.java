class Solution {
    public int maxPoints(int[][] points) {
        // Number of points on the plane
        int numPoints = points.length;
        // At least one point will always form a line
        int maxPointsInLine = 1;
      
        // Iterate over all points as the starting point of a line
        for (int i = 0; i < numPoints; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            // A map to store the slope of lines and their counts
            Map<String, Integer> lineMap = new HashMap<>();
          
            // Try forming lines with every other point
            for (int j = i + 1; j < numPoints; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                // Calculate the deltas for the line
                int deltaX = x2 - x1;
                int deltaY = y2 - y1;
                // Compute the greatest common divisor to normalize the slope
                int gcd = gcd(deltaX, deltaY);
                // Create a unique string key for the slope after normalizing
                String slopeKey = (deltaX / gcd) + "." + (deltaY / gcd);
                // Increment the number of points that form the current line
                lineMap.put(slopeKey, lineMap.getOrDefault(slopeKey, 0) + 1);
                // Update the maximum number of points in a line if necessary
                maxPointsInLine = Math.max(maxPointsInLine, lineMap.get(slopeKey) + 1);
            }
        }
        // Return the maximum number of points found in a line
        return maxPointsInLine;
    }

    // Helper method to calculate the greatest common divisor of two numbers
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}