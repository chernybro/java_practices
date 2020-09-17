public class Human {
    private String color;
    private String bodyType;
    Head head;
    Hand hand;
    Leg leg;

    public Human(String color, String bodyType) {
        this.color = color;
        this.bodyType = bodyType;
        Head head = new Head("круглая", false, "black", "blue"); ////// показываю что могу создать класс в классе
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Human{" +
                "color='" + color + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }

    static class Head {
        private String scullShape;
        private boolean hasBeard;
        private String hairColor;
        private String eyesColor;


        public Head(String scullShape, boolean hasBeard, String hairColor, String eyesColor) {
            super();
            this.scullShape = scullShape;
            this.hasBeard = hasBeard;
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public String getScullShape() {
            return scullShape;
        }

        public void setScullShape(String scullShape) {
            this.scullShape = scullShape;
        }

        public boolean isHasBeard() {
            return hasBeard;
        }

        public void setHasBeard(boolean hasBeard) {
            this.hasBeard = hasBeard;
        }

        public String getHairColor() {
            return hairColor;
        }

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        public String getEyesColor() {
            return eyesColor;
        }

        public void setEyesColor(String eyesColor) {
            this.eyesColor = eyesColor;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "scullShape='" + scullShape + '\'' +
                    ", hasBeard=" + hasBeard +
                    ", hairColor='" + hairColor + '\'' +
                    ", eyesColor='" + eyesColor + '\'' +
                    '}';
        }
    }



    static class Hand {
        private int fingerCount;
        private String size;

        public Hand(int fingerCount, String size) {
            this.fingerCount = fingerCount;
            this.size = size;
        }

        public int getFingerCount() {
            return fingerCount;
        }

        public void setFingerCount(int fingerCount) {
            this.fingerCount = fingerCount;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Hand{" +
                    "fingerCount=" + fingerCount +
                    ", size='" + size + '\'' +
                    '}';
        }
    }

    static class Leg  {
        private boolean hasHair;
        private int legCount;

        public Leg(boolean hasHair, int legCount) {
            this.hasHair = hasHair;
            this.legCount = legCount;
        }

        public boolean isHasHair() {
            return hasHair;
        }

        public void setHasHair(boolean hasHair) {
            this.hasHair = hasHair;
        }

        public int getLegCount() {
            return legCount;
        }

        public void setLegCount(int legCount) {
            this.legCount = legCount;
        }

        @Override
        public String toString() {
            return "Leg{" +
                    "hasHair=" + hasHair +
                    ", legCount=" + legCount +
                    '}';
        }
    }



}
