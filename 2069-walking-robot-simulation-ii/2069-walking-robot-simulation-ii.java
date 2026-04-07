class Robot {

    int width, height, perimeter, steps;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        steps = (steps + num) % perimeter;
        moved = true;
    }
    
    public int[] getPos() {
        int s = steps;

        if (s < width) return new int[]{s, 0};

        if (s < width + height - 1)
            return new int[]{width - 1, s - width + 1};

        if (s < 2 * width + height - 2)
            return new int[]{width - 1 - (s - (width + height - 1)), height - 1};

        return new int[]{0, height - 1 - (s - (2 * width + height - 2))};
    }
    
    public String getDir() {
        if (steps == 0) return moved ? "South" : "East";

        if (steps < width - 1) return "East";

        if (steps < width + height - 2) return "North";

        if (steps < 2 * width + height - 3) return "West";

        return "South";
    }
}