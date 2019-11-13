public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector(double x) {
        this.x = x;
        y = 0;
        z = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //===============================================================================================================

    //region Gets and Sets
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void addX(double x){
        this.x += x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addY(double y){
        this.y += y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void addZ(double z){
        this.z += z;
    }
    //endregion

    //================================================================================================================

    //changes all of the fields by a Vector's parallel fields
    public void update(Vector other){
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
    }

    public void scale(double scalar){
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }

    public Vector scaledVector(double scalar){
        return new Vector(x * scalar, y * scalar , z * scalar);
    }

    //returns the magnitude of the Vector
    public double magnitude(){
        return Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) );
    }


    //region Differences and Distance
    //returns the difference between a Vector and a point
    public double difference(int x){
        return Math.sqrt( Math.pow( this.x - x, 2) + Math.pow(this.y - 0, 2) + Math.pow(this.z - 0, 2) );
    }

    //returns the difference between a Vector and a point
    public double difference(int x, int y){
        return Math.sqrt( Math.pow( this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - 0, 2) );
    }

    //returns the difference between a Vector and a point
    public double difference(int x, int y, int z){
        return Math.sqrt( Math.pow( this.x - x, 2) + Math.pow(this.y - y, 2) + Math.pow(this.z - z, 2) );
    }

    //returns the difference between two Vectors
    public double difference(Vector other){
        return Math.sqrt( Math.pow( this.x - other.x, 2)+Math.pow(this.y - other.y , 2)+Math.pow(this.z - other.z , 2) );
    }

    public Vector differenceVector(Vector other){
        return new Vector(other.x - this.x, other.y - this.y, other.z - this.z);
    }
    //endregion

    public Vector getInverse(){
        return  new Vector(-this.x, -this.y, -this.z);
    }

    //returns the unit Vector
    public Vector unitVector(){
        double magnitude = magnitude();
        return new Vector(x / magnitude, y / magnitude, z / magnitude);
    }

    //only works on 2-D plains
    public double getRadian(){
        double radian = Math.atan(y / x);

        if(x < 0){
            radian += 3.1416;
        }

        return radian;
    }

    //================================================================================================================

    public String toString(){
        return (x + " - " + y + " - " + z);
    }
}
