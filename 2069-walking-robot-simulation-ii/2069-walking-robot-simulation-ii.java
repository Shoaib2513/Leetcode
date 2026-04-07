class Robot {

    int width, height;
    int perimeter;
    int stepsTaken;
    boolean moved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.stepsTaken = 0;
        this.moved = false;
    }
    
    public void step(int num) {
        stepsTaken = (stepsTaken + num) % perimeter;
        moved = true;
    }
    
    public int[] getPos() {
        int s = stepsTaken;

        if (s < width) return new int[]{s, 0};
        s -= width;

        if (s < height - 1) return new int[]{width - 1, s + 1};
        s -= (height - 1);

        if (s < width - 1) return new int[]{width - 2 - s, height - 1};
        s -= (width - 1);

        return new int[]{0, height - 2 - s};
    }
    
   public String getDir() {
    int[] pos = getPos();
    int x = pos[0], y = pos[1];

    if (x == 0 && y == 0) {
        return moved ? "South" : "East";
    }

    if (y == 0) return "East";
    if (x == width - 1) return "North";
    if (y == height - 1) return "West";
    return "South";
}
}